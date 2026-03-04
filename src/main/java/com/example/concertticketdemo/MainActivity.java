package com.example.concertticketdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicket = 79.99;
    private View cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the 'cost' button (btnCost)
        cost = findViewById(R.id.btnCost); // Ensure this matches the button's actual ID in XML

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText tickets = findViewById(R.id.editTextNumber);
                final Spinner group = findViewById(R.id.txtGroup);
                final TextView result = findViewById(R.id.txtResult);

                int numberOfTickets = 0;
                if (tickets.getText().length() != 0) {
                    numberOfTickets = Integer.parseInt(tickets.getText().toString());
                }

                double totalCost = costPerTicket * numberOfTickets;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                String groupChoice = group.getSelectedItem().toString();
                result.setText("Cost for " + groupChoice + " is " + currency.format(totalCost));
            }
        });
    }
}

