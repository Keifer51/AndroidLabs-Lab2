package com.cst7335.jess0088;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toastText = getResources().getString(R.string.toasttext);

                Toast toast = Toast.makeText(MainActivity.this, toastText, Toast.LENGTH_LONG);
                toast.show();
            }
        });
        Switch Switch = findViewById(R.id.switch2);

        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                String state = checked ? "on" : "off";
                String snackbarMessage = "The switch is now " + state;

                Snackbar snackbar = Snackbar.make(buttonView, snackbarMessage, Snackbar.LENGTH_LONG);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Undo action: Set the switch back to its original state
                        Switch.setChecked(!checked);
                    }
                });
                snackbar.show();
            }
        });

    }
}