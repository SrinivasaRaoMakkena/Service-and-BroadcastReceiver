package com.example.srinivas.servicewithbroadcastreceiverdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.textViewActivity);
    }

    public void startMusic(View view) {
        Intent  intent = new Intent(MainActivity.this,MyService.class);
        startService(intent);

    }

    public void stopMusic(View view) {
        Toast.makeText(getApplicationContext(), "Service Stopped", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(MainActivity.this,MyService.class);

        stopService(intent);


    }

    public void customToast(View view) {
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);

        LayoutInflater layoutInflater = getLayoutInflater();
        View appear = layoutInflater.inflate(R.layout.layout_toast,(ViewGroup) findViewById(R.id.toast_linear_layout));

        toast.setView(appear);
        toast.show();


    }
}
