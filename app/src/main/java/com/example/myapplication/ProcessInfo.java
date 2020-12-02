package com.example.myapplication;


import android.os.Bundle;
import android.os.Process;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProcessInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_process);

        int BUID = Process.BLUETOOTH_UID;
        int PUID = Process.PHONE_UID;
        int RUID = Process.ROOT_UID;
        int SUID = Process.SHELL_UID;
        int SYSUID = Process.SYSTEM_UID;
        int FUID = Process.FIRST_APPLICATION_UID;
        int LUID = Process.LAST_APPLICATION_UID;
        int IUID = Process.INVALID_UID;

//        List<ActivityManager.RunningAppProcessInfo> processes;
//        ActivityManager amg;
//
//        // using Activity service to list all process
//        amg = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
//        // list all running process
//        processes = amg.getRunningAppProcesses();

        TextView BUIDV = (TextView) findViewById(R.id.BUID);
        BUIDV.setText("BUID: " + BUID);

        TextView PUIDV = (TextView) findViewById(R.id.PUID);
        PUIDV.setText("PUID: " + PUID);

        TextView RUIDV = (TextView) findViewById(R.id.RUID);
        RUIDV.setText("RUID: " + RUID);

        TextView SUIDV = (TextView) findViewById(R.id.SUID);
        SUIDV.setText("SUID: " + SUID);

        TextView SYSUIDV = (TextView) findViewById(R.id.SYSUID);
        SYSUIDV.setText("SYSUID: " + SYSUID);

        TextView FUIDV = (TextView) findViewById(R.id.FUID);
        FUIDV.setText("FUID: " + FUID);

        TextView LUIDV = (TextView) findViewById(R.id.LUID);
        LUIDV.setText("LUID: " + LUID);

        TextView IUIDV = (TextView) findViewById(R.id.IUID);
        IUIDV.setText("IUID: " + IUID);

    }
}