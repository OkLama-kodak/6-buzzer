
package com.example.a6_buzzer;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class AddingTask extends AppCompatActivity {

    LinearLayout taskContainer;
    Button btnAddTask;

    ArrayList<Task> tasks = new ArrayList<>();

    int selectedYear, selectedMonth, selectedDay;

    static class Task {
        String title;
        String date;
        String priority;
        boolean done;

        Task(String title, String date, String priority) {
            this.title = title;
            this.date = date;
            this.priority = priority;
            this.done = false;
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adding_task);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                });

        taskContainer = findViewById(R.id.taskContainer);
        btnAddTask = findViewById(R.id.btnAddTask);

        // Sample tasks
        tasks.add(new Task("Task 1", "09/20/2026", "High"));
        tasks.add(new Task("Task 2", "09/22/2026", "Medium"));
        tasks.add(new Task("Task 3", "09/25/2026", "Low"));

        tasks.get(0).done = true;

        displayTasks();

        // Add Task button
        btnAddTask.setOnClickListener(v -> showAddTaskDialog());

        // Bottom navigation
        setupNavigation();
    }

    // DISPLAY ALL TASKS
    private void displayTasks() {

        taskContainer.removeAllViews();

        for (int i = 0; i < tasks.size(); i++) {

            final int position = i;
            Task task = tasks.get(i);

            LinearLayout card = new LinearLayout(this);

            card.setOrientation(LinearLayout.HORIZONTAL);
            card.setGravity(Gravity.CENTER_VERTICAL);
            card.setPadding(dp(14), dp(14), dp(14), dp(14));

            GradientDrawable background = new GradientDrawable();

            background.setCornerRadius(dp(20));

            if (task.priority.equals("High")) {
                background.setColor(Color.rgb(255, 249, 231));
            } else if (task.priority.equals("Medium")) {
                background.setColor(Color.rgb(232, 247, 251));
            } else {
                background.setColor(Color.rgb(235, 250, 242));
            }

            card.setBackground(background);

            LinearLayout.LayoutParams cardParams =
                    new LinearLayout.LayoutParams(
                            -1, -2);

            if (i > 0) {
                cardParams.topMargin = dp(12);
            }

            taskContainer.addView(card, cardParams);

            // Colored circle
            TextView dot = new TextView(this);

            dot.setText("●");
            dot.setTextSize(20);

            if (task.priority.equals("High")) {
                dot.setTextColor(Color.rgb(244, 172, 25));
            } else if (task.priority.equals("Medium")) {
                dot.setTextColor(Color.rgb(88, 180, 208));
            } else {
                dot.setTextColor(Color.rgb(67, 166, 140));
            }

            card.addView(dot, new LinearLayout.LayoutParams(
                    dp(34), -2));

            // Task information
            LinearLayout details = new LinearLayout(this);

            details.setOrientation(LinearLayout.VERTICAL);
            details.setPadding(dp(8), 0, 0, 0);

            LinearLayout.LayoutParams detailParams =
                    new LinearLayout.LayoutParams(0, -2, 1);

            card.addView(details, detailParams);

            TextView taskName = new TextView(this);

            taskName.setText(task.title + ": " +
                    (task.done ? "DONE" : "DUE"));

            taskName.setTextColor(Color.rgb(36, 42, 45));
            taskName.setTextSize(14);
            taskName.setTypeface(null, Typeface.BOLD);

            details.addView(taskName);

            TextView taskInfo = new TextView(this);

            taskInfo.setText(task.date + "  •  " +
                    task.priority + " priority");

            taskInfo.setTextColor(Color.rgb(102, 121, 130));
            taskInfo.setTextSize(10);

            LinearLayout.LayoutParams infoParams =
                    new LinearLayout.LayoutParams(-2, -2);

            infoParams.topMargin = dp(5);

            details.addView(taskInfo, infoParams);

            // Priority badge
            TextView priority = new TextView(this);

            priority.setText(task.priority);
            priority.setTextSize(10);
            priority.setPadding(dp(10), dp(6), dp(10), dp(6));

            GradientDrawable badge = new GradientDrawable();
            badge.setCornerRadius(dp(20));

            if (task.priority.equals("High")) {
                badge.setColor(Color.rgb(255, 213, 105));
                priority.setTextColor(Color.rgb(86, 59, 0));

            } else if (task.priority.equals("Medium")) {
                badge.setColor(Color.rgb(190, 229, 239));
                priority.setTextColor(Color.rgb(23, 50, 59));

            } else {
                badge.setColor(Color.rgb(190, 232, 216));
                priority.setTextColor(Color.rgb(23, 59, 50));
            }

            priority.setBackground(badge);

            card.addView(priority);

            // TAP = CHANGE TASK STATUS
            card.setOnClickListener(v -> {

                tasks.get(position).done =
                        !tasks.get(position).done;

                displayTasks();

            });

            // LONG PRESS = DELETE TASK
            card.setOnLongClickListener(v -> {

                new AlertDialog.Builder(this)
                        .setTitle("Delete Task")
                        .setMessage("Do you want to delete this task?")
                        .setPositiveButton("Delete", (dialog, which) -> {

                            tasks.remove(position);
                            displayTasks();

                            Toast.makeText(this,
                                    "Task deleted",
                                    Toast.LENGTH_SHORT).show();

                        })
                        .setNegativeButton("Cancel", null)
                        .show();

                return true;
            });
        }
    }

    // ADD TASK DIALOG
    private void showAddTaskDialog() {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(dp(20), dp(10), dp(20), dp(10));

        EditText titleInput = new EditText(this);

        titleInput.setHint("Enter task name");
        titleInput.setSingleLine(true);

        layout.addView(titleInput);

        Button dateButton = new Button(this);

        Calendar calendar = Calendar.getInstance();

        selectedYear = calendar.get(Calendar.YEAR);
        selectedMonth = calendar.get(Calendar.MONTH);
        selectedDay = calendar.get(Calendar.DAY_OF_MONTH);

        dateButton.setText(getSelectedDate());

        layout.addView(dateButton);

        dateButton.setOnClickListener(v -> {

            DatePickerDialog picker = new DatePickerDialog(
                    this,
                    (view, year, month, day) -> {

                        selectedYear = year;
                        selectedMonth = month;
                        selectedDay = day;

                        dateButton.setText(getSelectedDate());
                    },
                    selectedYear,
                    selectedMonth,
                    selectedDay
            );

            picker.show();
        });

        TextView priorityLabel = new TextView(this);

        priorityLabel.setText("Select Priority");
        priorityLabel.setTextSize(16);
        priorityLabel.setPadding(0, dp(10), 0, dp(5));

        layout.addView(priorityLabel);

        Spinner prioritySpinner = new Spinner(this);

        String[] priorities = {
                "High", "Medium", "Low"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        priorities
                );

        prioritySpinner.setAdapter(adapter);

        layout.addView(prioritySpinner);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Add New Task")
                .setView(layout)
                .setPositiveButton("Add", null)
                .setNegativeButton("Cancel", null)
                .create();

        dialog.setOnShowListener(d -> {

            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setOnClickListener(v -> {

                        String title = titleInput.getText()
                                .toString().trim();

                        if (title.isEmpty()) {

                            titleInput.setError(
                                    "Please enter a task name");

                            return;
                        }

                        String priority =
                                prioritySpinner.getSelectedItem().toString();

                        tasks.add(new Task(
                                title,
                                getSelectedDate(),
                                priority
                        ));

                        displayTasks();

                        Toast.makeText(this,
                                "Task added successfully!",
                                Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    });
        });

        dialog.show();
    }

    // FORMAT DATE
    private String getSelectedDate() {

        return String.format(
                Locale.getDefault(),
                "%02d/%02d/%04d",
                selectedMonth + 1,
                selectedDay,
                selectedYear
        );
    }

    // DP TO PIXELS
    private int dp(int value) {

        return (int) (value *
                getResources().getDisplayMetrics().density);
    }

    // BOTTOM NAVIGATION
    private void setupNavigation() {

        LinearLayout bottomNav =
                findViewById(R.id.bottomNav);

        if (bottomNav == null) return;

        for (int i = 0; i < bottomNav.getChildCount(); i++) {

            final int position = i;

            bottomNav.getChildAt(i).setOnClickListener(v -> {

                if (position == 0) {

                    Toast.makeText(this,
                            "Home",
                            Toast.LENGTH_SHORT).show();

                } else if (position == 1) {

                    Toast.makeText(this,
                            "Tasks",
                            Toast.LENGTH_SHORT).show();

                } else if (position == 2) {

                    Toast.makeText(this,
                            "Settings",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
