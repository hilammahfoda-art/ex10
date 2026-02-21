package com.example.ex10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etDisplay;
    private double firstNumber = Double.NaN;
    private String currentOperator = "";
    private boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etDisplay = findViewById(R.id.et_display);

        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMult = findViewById(R.id.btn_multiply);
        Button btnDiv = findViewById(R.id.btn_divide);
        Button btnEquals = findViewById(R.id.btn_equals);
        Button btnClear = findViewById(R.id.btn_ac);

        btnPlus.setOnClickListener(v -> {
            calculate();
            currentOperator = "+";
            etDisplay.setText("");
        });

        btnMinus.setOnClickListener(v -> {
            calculate();
            currentOperator = "-";
            etDisplay.setText("");
        });

        btnMult.setOnClickListener(v -> {
            calculate();
            currentOperator = "*";
            etDisplay.setText("");
        });

        btnDiv.setOnClickListener(v -> {
            calculate();
            currentOperator = "/";
            etDisplay.setText("");
        });

        btnEquals.setOnClickListener(v -> {
            calculate();
            currentOperator = "";
            firstNumber = Double.NaN;
        });

        btnClear.setOnClickListener(v -> {
            etDisplay.setText("");
            firstNumber = Double.NaN;
            currentOperator = "";
            isNewOp = true;
        });
    }

    private void calculate() {
        String input = etDisplay.getText().toString();

        if (input.isEmpty()) return;

        double secondNumber = Double.parseDouble(input);

        if (Double.isNaN(firstNumber)) {
            firstNumber = secondNumber;
        } else {
            switch (currentOperator) {
                case "+":
                    firstNumber += secondNumber;
                    break;
                case "-":
                    firstNumber -= secondNumber;
                    break;
                case "*":
                    firstNumber *= secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        firstNumber /= secondNumber;
                    } else {
                        etDisplay.setText("Error");
                        firstNumber = Double.NaN;
                        return;
                    }
                    break;
            }
        }
        etDisplay.setText(String.valueOf(firstNumber));
        isNewOp = true;
    }
}





