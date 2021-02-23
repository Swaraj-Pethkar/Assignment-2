package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ChangedReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val isItEnabled = intent?.getBooleanExtra("state",false) ?: return;
        if(isItEnabled){
            Toast.makeText(context,"It is enabled",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"It is diabled",Toast.LENGTH_SHORT).show();
        }
    }

}