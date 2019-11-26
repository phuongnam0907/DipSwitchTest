package com.android.dipswitchtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.styl.yf3.dipswitch.DipSwitchManager;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    private DipSwitchManager dipSwitchManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text);
        button = findViewById(R.id.button);

        dipSwitchManager = new DipSwitchManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int get = dipSwitchManager.getSwitchStatus();
                if (get == -1) get = 999;
                textView.setText("Number: " + get + "\n"
                        + "Binary: " + Integer.toBinaryString(get) + "\n"
                        + "Switch 4: " + dipSwitchManager.getSW4_x000() + "\n"
                        + "Switch 3: " + dipSwitchManager.getSW3_0x00() + "\n"
                        + "Switch 2: " + dipSwitchManager.getSW2_00x0() + "\n"
                        + "Switch 1: " + dipSwitchManager.getSW1_000x());
            }
        });
    }
}
