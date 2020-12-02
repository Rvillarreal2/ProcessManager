package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.app.ActivityManager;
import java.util.*;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BuildInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_build);

        String myVersion = android.os.Build.VERSION.RELEASE;
        int sdkVersion = android.os.Build.VERSION.SDK_INT;
        String board = android.os.Build.BOARD;
        String bootLoader = android.os.Build.BOOTLOADER;
        String brand = android.os.Build.BRAND;
        String deviceDesign = Build.DEVICE;
        String display = Build.DISPLAY;
        String hardware = Build.HARDWARE;
        String host = Build.HOST;
        String ID = Build.ID;
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        String product = Build.PRODUCT;
        String serial = Build.SERIAL;
        long time = Build.TIME;
        String type = Build.TYPE;
        String user = Build.USER;

        List<ActivityManager.RunningAppProcessInfo> processes;
        ActivityManager amg;

        // using Activity service to list all process
        amg = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        // list all running process
        processes = amg.getRunningAppProcesses();

        TextView versionView = (TextView) findViewById(R.id.myVersion);
        versionView.setText("Version: " + myVersion);

        TextView sdkVer = (TextView) findViewById(R.id.sdkVersion);
        sdkVer.setText("SDK version: " + sdkVersion);

        TextView boardV = (TextView) findViewById(R.id.board);
        boardV.setText("Board: " + board);

        TextView bootV = (TextView) findViewById(R.id.bootLoader);
        bootV.setText("Boot Loader: " + bootLoader);

        TextView brandV = (TextView) findViewById(R.id.brandVer);
        brandV.setText("Brand: " + brand);

        TextView devView = (TextView) findViewById(R.id.deviceView);
        devView.setText("Device: " + deviceDesign);

        TextView displayV = (TextView) findViewById(R.id.displayView);
        displayV.setText("Display: " + display);

        TextView hardwareV = (TextView) findViewById(R.id.hardwareV);
        hardwareV.setText("Hardware: " + hardware);

        TextView hostV = (TextView) findViewById(R.id.hostView);
        hostV.setText("Host: " + host);

        TextView IDView = (TextView) findViewById(R.id.IDView);
        IDView.setText("ID: " + ID);

        TextView manV = (TextView) findViewById(R.id.manView);
        manV.setText("Manufacturer: " + manufacturer);

        TextView modelView = (TextView) findViewById(R.id.modelView);
        modelView.setText("Model: " + model);

        TextView productV = (TextView) findViewById(R.id.productView);
        productV.setText("Product: " + product);

        TextView serialV = (TextView) findViewById(R.id.serialView);
        serialV.setText("Serial: " + serial);

        TextView timeV = (TextView) findViewById(R.id.timeView);
        timeV.setText("Time: " + time);

        TextView typeV = (TextView) findViewById(R.id.typeView);
        typeV.setText("Type: " + type);

        TextView userV = (TextView) findViewById(R.id.userView);
        userV.setText("User: " + user);


    }
}
