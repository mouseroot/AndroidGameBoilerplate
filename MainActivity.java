package com.example.mouseroot.mynetworkgame;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Remove Titlebar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Private Shared Keystore
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor keyStore = sharedPreferences.edit();


        //Set View
        setContentView(new GamePanel(this, keyStore));

    }
}
