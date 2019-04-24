package com.thebestamogroup.alajeffreyclicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


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
            ed.putFloat("Jeffrey Punten1", 0);
            ed.putFloat("Jeffrey Punten2", 0);
            ed.putLong("Totaal Jeffrey Punten", 0);
            ed.putLong("Motiverende Speech", 0);
            ed.putLong("Nieuw Blazter Gebouw", 0);
            ed.putLong("Sterkere Wing Chunners", 0);
            ed.putLong("Duitse Upgrade", 0);
            ed.putLong("Nieuwe Mercedez-Benz", 0);
            ed.putLong("Niewe Baby", 0);
            ed.apply();
        }
        else{
            //If initialized set counter to correct number
            TextView textView1 = findViewById(R.id.counter);
            textView1.setText(String.valueOf(sharedPrefs.getLong("Jeffrey Punten", 0)));
        }

        //OnClickListener for Jeffreys smoel
        final ImageButton button = findViewById(R.id.smoel);
        final TextView textView2 = findViewById(R.id.counter);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float currentJeffs = sharedPrefs.getFloat("Jeffrey Punten1", 0) + 1;
                textView2.setText(String.valueOf(currentJeffs));
git            }
        });

        ImageButton buttonUpgrades = findViewById(R.id.imageView);
        buttonUpgrades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UpgradeActivity.class));
            }
        });

        Timer timer = new Timer();
        long delay = 0;
        long intervalPeriod = 1000;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                long currentJeffs = sharedPrefs.getLong("Jeffrey Punten", 0);
                getSharedPreferences("player", MODE_PRIVATE)
                        .edit()
                        .putLong(
                                "Jeffrey Punten",
                                currentJeffs
                                        + sharedPrefs.getLong("Motiverende Speech",0) * 1
                                        + sharedPrefs.getLong("Nieuw Blazter Gebouw",0) * 5
                                        + sharedPrefs.getLong("Sterkere Wing Chunners",0) * 20
                                        + sharedPrefs.getLong("Duitse Upgrade",0) * 88
                                        + sharedPrefs.getLong("Nieuwe Mercedez-Benz",0) * 500
                                        + sharedPrefs.getLong("Niewe Baby",0) * 10000
                        )
                        .apply();
            }
        };

        TimerTask updateJeff = new TimerTask(){
            public void run() {
                MainActivity.this.runOnUiThread(
                        new Runnable() {

                            @Override
                            public void run() {
                                textView2.setText(String.valueOf(sharedPrefs.getLong("Jeffrey Punten", 0)));
                            }

                        }
                );
            }
        };

        timer.scheduleAtFixedRate(task, delay, intervalPeriod);
        timer.scheduleAtFixedRate(updateJeff, delay, intervalPeriod);
    }
}
