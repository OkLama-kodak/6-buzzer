package com.example.a6_buzzer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.a6_buzzer.Test.Scarlet;
import com.example.a6_buzzer.Test.calendar;
import com.example.a6_buzzer.Test.reminders;
import com.example.a6_buzzer.Test.settings;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set up click listeners for main dashboard buttons
        View buttonGear = findViewById(R.id.buttonGear);
        if (buttonGear != null) {
            buttonGear.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, settings.class)));
        }

        View buttonTasks = findViewById(R.id.buttonTasks);
        if (buttonTasks != null) {
            buttonTasks.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, AddingTask.class)));
        }

        View buttonCalendar = findViewById(R.id.buttonCalendar);
        if (buttonCalendar != null) {
            buttonCalendar.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, calendar.class)));
        }

        View buttonReminders = findViewById(R.id.buttonReminders);
        if (buttonReminders != null) {
            buttonReminders.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, reminders.class)));
        }

        View buttonAlarms = findViewById(R.id.buttonAlarms);
        if (buttonAlarms != null) {
            buttonAlarms.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Scarlet.class)));
        }
    }
}
