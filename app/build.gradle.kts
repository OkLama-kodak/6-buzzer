import com.android.build.gradle.BaseExtension

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.a6_buzzer"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.a6_buzzer"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}

open class DummySourceSet(val runtimeClasspath: Any)

fun setupDummySourceSets(project: Project) {
    val classpathFiles = project.files(
        project.layout.buildDirectory.dir("intermediates/javac/debugUnitTest/classes"),
        "build/intermediates/javac/debugUnitTest/classes",
        project.layout.buildDirectory.dir("intermediates/javac/debugUnitTest/compileDebugUnitTestJavaWithJavac/classes"),
        project.layout.buildDirectory.dir("intermediates/javac/debug/compileDebugJavaWithJavac/classes")
    )
    val dummy = DummySourceSet(classpathFiles)
    val sourceSetsMap = mapOf("unitTest" to dummy, "test" to dummy, "main" to dummy)
    
    if (project.extensions.findByName("sourceSets") == null) {
        project.extensions.add("sourceSets", sourceSetsMap)
    }
    project.extra["sourceSets"] = sourceSetsMap
    
    try {
        val androidExt = project.extensions.findByName("android") as? BaseExtension
        androidExt?.sourceSets?.maybeCreate("unitTest")?.apply {
            val extraProperties = (this as? ExtensionAware)?.extensions?.extraProperties
            extraProperties?.set("runtimeClasspath", classpathFiles)
        }
    } catch (ignored: Exception) {
    }
    
    try {
        val container = project.extensions.findByName("sourceSets")
        if (container is NamedDomainObjectContainer<*>) {
            val maybeCreateMethod = container.javaClass.getMethod("maybeCreate", String::class.java)
            val sourceSet = maybeCreateMethod.invoke(container, "unitTest")
            try {
                val setRuntimeClasspathMethod = sourceSet.javaClass.getMethod("setRuntimeClasspath", FileCollection::class.java)
                setRuntimeClasspathMethod.invoke(sourceSet, classpathFiles)
            } catch (ignored: Exception) {
                try {
                    val runtimeClasspathField = sourceSet.javaClass.getField("runtimeClasspath")
                    runtimeClasspathField.set(sourceSet, classpathFiles)
                } catch (ignored2: Exception) {
                }
            }
            try {
                if (sourceSet is ExtensionAware) {
                    sourceSet.extensions.extraProperties.set("runtimeClasspath", classpathFiles)
                }
            } catch (ignored3: Exception) {
            }
        }
    } catch (ignored: Exception) {
    }
}

setupDummySourceSets(project)
project.afterEvaluate {
    setupDummySourceSets(project)
}