package com.example.unconverter;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final double mm = 1;
        final double CM = 10*mm;
        final double M = 100*CM;
        final double KM = 1000*M;

        String[] unitArray = {"KM","M","CM","mm"};
//        Getting operational input
        EditText input = findViewById(R.id.InputEditText1);
        TextView result = findViewById(R.id.InputEditText2);
        TextView button = findViewById(R.id.button);


        Spinner convertFromSpinner = findViewById(R.id.spinner);
        Spinner convertToSpinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unitArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertFromSpinner.setAdapter(adapter);
        convertToSpinner.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double value = Double.parseDouble(input.getText().toString());

                if (convertFromSpinner.getSelectedItem().toString() == "mm"){
                    value *= mm;
                }
                if (convertFromSpinner.getSelectedItem().toString() == "CM"){
                    value *= CM;
                }
                if (convertFromSpinner.getSelectedItem().toString() == "M"){
                    value *= M;
                }
                if (convertFromSpinner.getSelectedItem().toString() == "KM"){
                    value *= KM;
                }

                if (convertToSpinner.getSelectedItem().toString() == "mm"){
                    value /= mm;
                }
                if (convertToSpinner.getSelectedItem().toString() == "CM"){
                    value /= CM;
                }
                if (convertToSpinner.getSelectedItem().toString() == "M"){
                    value /= M;
                }
                if (convertToSpinner.getSelectedItem().toString() == "KM"){
                    value /= KM;
                }

                result.setText(Double.toString(value));
            }
        });

    }
}
