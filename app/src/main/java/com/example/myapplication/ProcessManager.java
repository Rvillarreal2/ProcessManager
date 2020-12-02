package com.example.myapplication;

import java.util.*;
import android.app.ActivityManager;
import android.content.Context;
import android.widget.*;
import android.view.*;

public class ProcessManager extends BaseAdapter {

    List<ActivityManager.RunningAppProcessInfo> processes;
    Context context;

    public ProcessManager(List<ActivityManager.RunningAppProcessInfo> processes, Context context) {
        this.context = context;
        this.processes = processes;
    }

    public int getCount() {
        return processes.size();
    }

    public Object getItem(int position) {
        return processes.get(position);
    }

    public long getItemId(int position) {
        return processes.get(position).pid;
    }

    public View getView(int position, View newView, ViewGroup parent) {

        Process proc;

        if(newView == null) {
            newView = new TextView(context);
            proc = new Process();
            proc.name = (TextView)newView;

            newView.setTag(proc);
        }else {
            proc = (Process)newView.getTag();
        }

        proc.name.setText(processes.get(position).processName);

        return newView;

    }
    class Process {
        public TextView name;

    }
}