package com.thebestamogroup.alajeffreyclicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class UpgradeActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade2);
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

    }
}
