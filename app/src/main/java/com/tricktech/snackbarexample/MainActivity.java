package com.tricktech.snackbarexample;

import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public CoordinatorLayout mCoordinatorLayout;
    public Button btnShowSnackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        btnShowSnackbar = (Button) findViewById(R.id.button);

        btnShowSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackbar();
            }
        });
    }
    public void showSnackbar(){
        Snackbar.make(mCoordinatorLayout, getString(R.string.no_internet), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.btn_settings), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                       startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                    }
                }).setActionTextColor(Color.RED).show();
    }
}
