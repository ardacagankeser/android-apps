package com.ardacagankeser.layoutlearning;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

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

        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        sharedPreferences = this.getSharedPreferences("com.ardacagankeser.layoutlearning", Context.MODE_PRIVATE);

        int userAge = sharedPreferences.getInt("userAge", 0);
        textView.setText("Your age: " + userAge);
    }

    public void save(View view) {
        if(!editText.getText().toString().matches("")) {
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("Your age: " + userAge);

            sharedPreferences.edit().putInt("userAge", userAge).apply();
        }
    }

    public void delete(View view) {
        int userAge = sharedPreferences.getInt("userAge", 0);
        if(userAge != 0) {
            textView.setText("Your age: ");
            sharedPreferences.edit().remove("userAge").apply();
        }
    }
}