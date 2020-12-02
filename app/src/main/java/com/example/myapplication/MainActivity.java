package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.*;

import java.util.List;




public class MainActivity extends AppCompatActivity {

    ListView lst;
    ProcessManager procMan;
    List<ActivityManager.RunningAppProcessInfo> processes;
    ActivityManager actMan;
    int load = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // using Activity service to list all process
        actMan = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        // list all running process
        processes = actMan.getRunningAppProcesses();



        lst = findViewById(R.id.listView);
        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (load == 1) {
                    for (ActivityManager.RunningAppProcessInfo info : processes) {
                        if (info.processName.equalsIgnoreCase(
                                ((ActivityManager.RunningAppProcessInfo)parent.getItemAtPosition(position)).processName)) {
                            // kill selected process
                            android.os.Process.killProcess(info.pid);
                            android.os.Process.sendSignal(info.pid, android.os.Process.SIGNAL_KILL);
                            actMan.killBackgroundProcesses(info.processName);
                        }
                    }
                    load = 0;
                    // refresh list of process
                    loadProcess();
                }
                return true;
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadProcess();
            }
        });
    }

    private void loadProcess() {
        if (load == 0) {
            actMan = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
            processes = actMan.getRunningAppProcesses();
            procMan = new ProcessManager(processes, MainActivity.this);
            lst.setAdapter(procMan);
            load = 1;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                startActivity(new Intent(this, BuildInfo.class));
                return true;
            case R.id.help:
                startActivity(new Intent(this, ProcessInfo.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
