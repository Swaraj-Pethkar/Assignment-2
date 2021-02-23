package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    var isFragmentOneLoaded = true;
    val manager = supportFragmentManager;


    var cols = listOf<String>(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notification = Notification();
        val services = Services();
        val contentProvider = ContentProvider();
        val notificationButton = findViewById<Button>(R.id.notification);
        val servicesButton = findViewById<Button>(R.id.services);
        val contentButton = findViewById<Button>(R.id.contentProvider);

        notificationButton.setOnClickListener({
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,notification).commit();
        });


        servicesButton.setOnClickListener({
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,services).commit();
        });

        contentButton.setOnClickListener({
//            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,contentProvider).commit();
            val intent = Intent(this,Contacts::class.java)
            startActivity(intent);
        });

    }


}