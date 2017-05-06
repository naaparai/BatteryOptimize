package com.dogpo.batteryoptimize;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.BatteryManager;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class PowerConnectionReceiver extends BroadcastReceiver {
    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        PackageManager pm = context.getPackageManager();
        Intent launchIntent = pm.getLaunchIntentForPackage("com.dogpo.batteryoptimize");
        launchIntent.putExtra("from", "broadcast");
        context.startActivity(launchIntent);

        showMessage("charging");

    }

    private void showMessage(String charging) {
        Toast.makeText(context, charging, Toast.LENGTH_SHORT).show();
    }
}
