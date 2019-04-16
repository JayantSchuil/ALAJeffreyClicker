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

        final ImageButton imageSpeech = findViewById(R.id.imageSpeech);
        final TextView costSpeech = findViewById(R.id.costSpeech);

        int currentAmount = sharedPrefs.getInt("Motiverende Speech", 0);
        int currentPrice = currentAmount * 5;
        costSpeech.setText("Prijs: "+String.valueOf(currentPrice));

        imageSpeech.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextView amountSpeech = findViewById(R.id.amountSpeech);
                final TextView costSpeech = findViewById(R.id.costSpeech);
                int currentAmount = sharedPrefs.getInt("Motiverende Speech", 0);
                getSharedPreferences("player", MODE_PRIVATE)
                        .edit()
                        .putInt("Motiverende Speech", currentAmount+1)
                        .apply();
                amountSpeech.setText(String.valueOf(sharedPrefs.getInt("Motiverende Speech", 0)));

                int currentPrice = currentAmount * 5;
                costSpeech.setText("Prijs: "+String.valueOf(currentPrice));
            }
        });

    }
}
