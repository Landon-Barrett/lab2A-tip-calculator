package com.example.cs408lab2atipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cs408lab2atipcalculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    double total = 0;
    double percent = 0;
    int numPeople = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.calculateTipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double total = 0.0;
                double percent = 0.0;
                int numPeople = 0;

                TextView t = binding.totalBillInput;
                total = parseDouble(t.getText().toString());

                t = binding.tipPercentInput;
                percent = parseDouble(t.getText().toString());


                t = binding.totalPeopleInput;
                numPeople = parseInt(t.getText().toString());

                double tip = 0.0;

                if((total != 0.0) && (percent != 0.0) && (numPeople != 0)) {

                    percent = percent / 100;
                    tip = total * percent;
                    tip = tip / numPeople;

                    DecimalFormat df = new DecimalFormat("#.00");
                    String tipOwed = df.format(tip);

                    String output = (getResources().getString(R.string.tip_output) + " " + tipOwed);
                    t = binding.output;
                    t.setText(output);
                }
            }
        });

    }

    public double parseDouble(String n) {

        try {
            double d = Double.parseDouble(n);
            return d;
        }
        catch(NumberFormatException nfe) {
            return 0.0;
        }

    }

    public int parseInt(String n) {

        try {
            int i = Integer.parseInt(n);
            return i;
        }
        catch(NumberFormatException nfe) {
            return 0;
        }
    }

}