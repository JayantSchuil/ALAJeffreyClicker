package com.thebestamogroup.alajeffreyclicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class UpgradeActivity extends AppCompatActivity {

    public class upgradeHandler {
        public void buyUpgrade (String selectedUpgrade) {
            final SharedPreferences sharedPrefs = getSharedPreferences("player", MODE_PRIVATE);
            final TextView amount;
            final TextView cost;
            final int modifier;

            switch (selectedUpgrade) {
                case "Motiverende Speech":
                    amount = findViewById(R.id.amountSpeech);
                    cost = findViewById(R.id.costSpeech);
                    modifier = 5;
                    break;
                case "Nieuw Blazter Gebouw":
                    amount = findViewById(R.id.amountKantoor);
                    cost = findViewById(R.id.costKantoor);
                    modifier = 100;
                    break;
                case "Sterkere Wing Chunners":
                    amount = findViewById(R.id.amountWingchun);
                    cost = findViewById(R.id.costWingchun);
                    modifier = 1000;
                    break;
                case "Duitse Upgrade":
                    amount = findViewById(R.id.amountDuitsland);
                    cost = findViewById(R.id.costDuitsland);
                    modifier = 1500;
                    break;
                case "Nieuwe Mercedez-Benz":
                    amount = findViewById(R.id.amountAuto);
                    cost = findViewById(R.id.costAuto);
                    modifier = 10000;
                    break;
                case "Niewe Baby":
                    amount = findViewById(R.id.amountBaby);
                    cost = findViewById(R.id.costBaby);
                    modifier = 1000000;
                    break;
                default:
                    amount = findViewById(R.id.amountSpeech);
                    cost = findViewById(R.id.costSpeech);
                    modifier = 2147483647;
                    break;
            }

            long currentAmount = sharedPrefs.getLong(selectedUpgrade, 0);
            long currentJeffs = sharedPrefs.getLong("Jeffrey Punten", 0);
            long currentPrice = (currentAmount + 1) * modifier;

            if (currentPrice <= currentJeffs && currentJeffs != 0) {

                getSharedPreferences("player", MODE_PRIVATE)
                        .edit()
                        .putLong(selectedUpgrade, currentAmount + 1)
                        .putLong("Jeffrey Punten", currentJeffs - currentPrice)
                        .apply();
                amount.setText(String.valueOf(sharedPrefs.getLong(selectedUpgrade, 0)));
                cost.setText("Prijs: " + String.valueOf(currentPrice));
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(), "Je hebt niet genoeg Jeffreys", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        final upgradeHandler handler = new upgradeHandler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade2);
        final SharedPreferences sharedPrefs = getSharedPreferences("player", MODE_PRIVATE);

        final ImageButton imageSpeech = findViewById(R.id.imageSpeech);
        final TextView costSpeech = findViewById(R.id.costSpeech);
        final TextView amountSpeech = findViewById(R.id.amountSpeech);
        long currentAmountSpeech = sharedPrefs.getLong("Motiverende Speech", 0);
        long currentPriceSpeech = (currentAmountSpeech + 1) * 5;
        amountSpeech.setText(String.valueOf(currentAmountSpeech));
        costSpeech.setText("Prijs: "+String.valueOf(currentPriceSpeech));

        final ImageButton imageKantoor = findViewById(R.id.imageKantoor);
        final TextView costKantoor = findViewById(R.id.costKantoor);
        final TextView amountKantoor = findViewById(R.id.amountKantoor);
        long currentAmountKantoor = sharedPrefs.getLong("Nieuw Blazter Gebouw", 0);
        long currentPriceKantoor = (currentAmountKantoor + 1) * 100;
        amountKantoor.setText(String.valueOf(currentAmountKantoor));
        costKantoor.setText("Prijs: "+String.valueOf(currentPriceKantoor));

        final ImageButton imageWingchun = findViewById(R.id.imageWingchun);
        final TextView costWingchun = findViewById(R.id.costWingchun);
        final TextView amountWingchun = findViewById(R.id.amountWingchun);
        long currentAmountWingchun = sharedPrefs.getLong("Sterkere Wing Chunners", 0);
        long currentPriceWingchun = (currentAmountWingchun + 1) * 1000;
        amountWingchun.setText(String.valueOf(currentAmountWingchun));
        costWingchun.setText("Prijs: "+String.valueOf(currentPriceWingchun));

        final ImageButton imageDuitsland = findViewById(R.id.imageDuitsland);
        final TextView costDuitsland = findViewById(R.id.costDuitsland);
        final TextView amountDuitsland = findViewById(R.id.amountDuitsland);
        long currentAmountDuitsland = sharedPrefs.getLong("Duitse Upgrade", 0);
        long currentPriceDuitsland = (currentAmountDuitsland + 1) * 1500;
        amountDuitsland.setText(String.valueOf(currentAmountDuitsland));
        costDuitsland.setText("Prijs: "+String.valueOf(currentPriceDuitsland));

        final ImageButton imageAuto = findViewById(R.id.imageAuto);
        final TextView costAuto = findViewById(R.id.costAuto);
        final TextView amountAuto = findViewById(R.id.amountAuto);
        long currentAmountAuto = sharedPrefs.getLong("Nieuwe Mercedez-Benz", 0);
        long currentPriceAuto = (currentAmountAuto + 1) * 10000;
        amountAuto.setText(String.valueOf(currentAmountAuto));
        costAuto.setText("Prijs: "+String.valueOf(currentPriceAuto));

        final ImageButton imageBaby = findViewById(R.id.imageBaby);
        final TextView costBaby = findViewById(R.id.costBaby);
        final TextView amountBaby = findViewById(R.id.amountBaby);
        long currentAmountBaby = sharedPrefs.getLong("Niewe Baby", 0);
        long currentPriceBaby = (currentAmountBaby + 1) * 1000000;
        amountBaby.setText(String.valueOf(currentAmountBaby));
        costBaby.setText("Prijs: "+String.valueOf(currentPriceBaby));

        imageSpeech.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handler.buyUpgrade("Motiverende Speech");
            }
        });

        imageKantoor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handler.buyUpgrade("Nieuw Blazter Gebouw");
            }
        });

        imageWingchun.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handler.buyUpgrade("Sterkere Wing Chunners");
            }
        });

        imageDuitsland.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handler.buyUpgrade("Duitse Upgrade");
            }
        });

        imageAuto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handler.buyUpgrade("Nieuwe Mercedez-Benz");
            }
        });

        imageBaby.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handler.buyUpgrade("Niewe Baby");
            }
        });
    }
}
