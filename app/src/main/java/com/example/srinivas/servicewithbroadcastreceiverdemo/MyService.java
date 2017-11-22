package com.example.srinivas.servicewithbroadcastreceiverdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public static String TAG_NAME = MyService.class.getName();
    public MyService() {
    }
    MediaPlayer mediaPlayer;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return null;


    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG_NAME+"Oncreate",Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
//         mediaPlayer = MediaPlayer.create(this, R.raw.song);
//        mediaPlayer.start();

        BackGroundTask backGroundTask = new BackGroundTask();
        backGroundTask.execute();

        Toast.makeText(this, "Song playing Started", Toast.LENGTH_LONG).show();
        Log.i(TAG_NAME+"onStartCommand",Thread.currentThread().getName());
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();
        Log.i(TAG_NAME+"onDestroy",Thread.currentThread().getName());
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
//mediaPlayer.stop();
    }


    public  class BackGroundTask extends AsyncTask<Void,Void,Void>{



        @Override
        protected Void doInBackground(Void... params) {
            Log.i(TAG_NAME+"doInbackGround",Thread.currentThread().getName());
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
            mediaPlayer.start();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Log.i(TAG_NAME+"onPostExecute",Thread.currentThread().getName());
            stopSelf();

            super.onPostExecute(aVoid);
        }
    }

}
