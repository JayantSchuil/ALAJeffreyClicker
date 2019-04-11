package com.thebestamogroup.alajeffreyclicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int num = 0;
    TextView tView;
    ImageButton clickHere;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tView = findViewById(R.id.counter);
        clickHere = findViewById(R.id.smoel);

        clickHere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

    }
}

