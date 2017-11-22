package com.example.srinivas.servicewithbroadcastreceiverdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving


        Notification.Builder notification = new Notification.Builder(context);
        notification.setSmallIcon(android.R.drawable.ic_notification_overlay);
        notification.setContentTitle("Boot UP");
        notification.setContentText("Good ");

        Intent resultIntent = new Intent(context, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(context,0,resultIntent,0,null);
        notification.setContentIntent(resultPendingIntent);


        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0,notification.build());

       if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
//            Log.i("Boot","Completed");

          //  context.startService(intent);

           context.startService(new Intent(context, MyService.class));
        }

    }
}
