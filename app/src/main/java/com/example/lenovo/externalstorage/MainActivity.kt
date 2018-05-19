package com.example.lenovo.externalstorage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        writeToPublic()
        readToFile()

        Log.i("abc","External storage path ${getExternalFilesDir("myDir")}")
        Log.i("abc","Extrenal Storage ${Environment.getExternalStoragePublicDirectory("myDir")}")
    }
    fun writeToPublic(){
        Log.i("abc",(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED).toString())
        if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED){
            val file=File(
                    Environment.getExternalStoragePublicDirectory("myDir"),
                    "abc.txt"
            )
            FileOutputStream(file).use {
                it.write("hello...".toByteArray( ))
            }
        }
        else{
            Toast.makeText(this@MainActivity,"Storage  not found",Toast.LENGTH_SHORT).show();
        }
    }

    fun readToFile(){
        if(Environment.getExternalStorageState()==Environment.MEDIA_MOUNTED){
            val file=File(
                    Environment.getExternalStoragePublicDirectory("codekul"),
                    "abc.txt"
            )
            val data=FileInputStream(file).bufferedReader().use {
                it.readLine()
            }
            Log.i("abc","Data is $data")
        }
        else{
            Toast.makeText(this@MainActivity,"Storage  not found",Toast.LENGTH_SHORT).show();
        }
    }
}
