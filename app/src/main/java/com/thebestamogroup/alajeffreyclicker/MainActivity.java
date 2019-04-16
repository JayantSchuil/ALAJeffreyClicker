package com.thebestamogroup.alajeffreyclicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences sharedPrefs = getSharedPreferences("player", MODE_PRIVATE);
        final SharedPreferences.Editor ed;
        if(!sharedPrefs.contains("initialized")){
            ed = sharedPrefs.edit();

            //Indicate that the default shared prefs have been set
            ed.putBoolean("initialized", true);

            //Initialise the Shared Preferences
            ed.putInt("Jeffrey Punten", 0);
            ed.putInt("Motiverende Speech", 0);
            ed.putInt("Nieuw Blazter Gebouw", 0);
            ed.putInt("Sterkere Wing Chunners", 0);
            ed.putInt("Duitse Upgrade", 0);
            ed.putInt("Nieuwe Mercedez-Benz", 0);
            ed.putInt("Niewe Baby", 0);

            ed.apply();
        }
        else{
            //If initialized set counter to correct number
            TextView textView1 = findViewById(R.id.counter);
            textView1.setText(String.valueOf(sharedPrefs.getInt("Jeffrey Punten", 0)));
        }

        //OnClickListener for Jeffreys smoel
        final ImageButton button = findViewById(R.id.smoel);
        final TextView textView2 = findViewById(R.id.counter);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int currentJeffs = sharedPrefs.getInt("Jeffrey Punten", 0);
                getSharedPreferences("player", MODE_PRIVATE)
                        .edit()
                        .putInt("Jeffrey Punten", currentJeffs+1)
                        .apply();
                textView2.setText(String.valueOf(sharedPrefs.getInt("Jeffrey Punten", 0)));
            }
        });

        Button buttonUpgrades = findViewById(R.id.button);
        buttonUpgrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UpgradeActivity.class));
            }
        });


    }
}
