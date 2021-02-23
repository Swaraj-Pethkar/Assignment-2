package com.example.myapplication

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.app.ActivityCompat

class Contacts : AppCompatActivity() {

    var cols = listOf<String>(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID
    ).toTypedArray()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, Array(1){android.Manifest.permission.READ_CONTACTS},111)
        }
        else{
            readContact()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            readContact();
        }
    }

    @SuppressLint("WrongViewCast")
    public fun readContact() {
        var listView = findViewById(R.id.listview1) as ListView;
        val contacts = ArrayList<String>()

        var from = listOf<String>(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER).toTypedArray()

        var to = intArrayOf(android.R.id.text1, android.R.id.text2)

        var rs = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,null,null,ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

        while(rs?.moveToNext()!!){
            var name = rs.getString(rs.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))

            var number = rs.getString(rs.getColumnIndex((ContactsContract.CommonDataKinds.Phone.NUMBER)))
            contacts.add(name+"\n"+number);
            var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,contacts);
            listView.adapter = adapter;
        }
    }
}