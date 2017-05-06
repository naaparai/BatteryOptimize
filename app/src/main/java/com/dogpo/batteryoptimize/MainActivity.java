package com.dogpo.batteryoptimize;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_SOME_FEATURES_PERMISSIONS = 101;
    static WindowManager.LayoutParams params;
    static WindowManager wm;
    static ViewGroup lockScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle=getIntent().getExtras();
        try{
            String from=bundle.getString("from");
            if(from.equalsIgnoreCase("broadcast")){
                startActivity(new Intent(getApplicationContext(),BatteryAdActivity.class));
                finish();

            }
        }catch (Exception ex){

        }

        getPermission();


    }

    private void getPermission() {
        String[] PERMISSIONS = {Manifest.permission.BATTERY_STATS, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.REORDER_TASKS};
        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_CODE_SOME_FEATURES_PERMISSIONS);
        }
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
