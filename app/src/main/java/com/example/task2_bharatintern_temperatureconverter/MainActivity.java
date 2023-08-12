package com.example.task2_bharatintern_temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText temperatureEditText;
    private Button celsiusToFahrenheitButton;
    private Button fahrenheitToCelsiusButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureEditText = findViewById(R.id.temperatureEditText);
        celsiusToFahrenheitButton = findViewById(R.id.celsiusToFahrenheitButton);
        fahrenheitToCelsiusButton = findViewById(R.id.fahrenheitToCelsiusButton);
        resultTextView = findViewById(R.id.resultTextView);

        celsiusToFahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCelsiusToFahrenheit();
            }
        });

        fahrenheitToCelsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertFahrenheitToCelsius();
            }
        });
    }

    private void convertCelsiusToFahrenheit() {
        try {
            double celsius = Double.parseDouble(temperatureEditText.getText().toString());
            double fahrenheit = (celsius * 9/5) + 32;
            resultTextView.setText(String.format("%.2f°C = %.2f°F", celsius, fahrenheit));
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
        }
    }

    private void convertFahrenheitToCelsius() {
        try {
            double fahrenheit = Double.parseDouble(temperatureEditText.getText().toString());
            double celsius = (fahrenheit - 32) * 5/9;
            resultTextView.setText(String.format("%.2f°F = %.2f°C", fahrenheit, celsius));
        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
        }
    }
}