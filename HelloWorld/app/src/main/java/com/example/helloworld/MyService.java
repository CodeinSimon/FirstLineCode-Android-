package com.example.helloworld;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;



public class MyService extends Service {
    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        //let it continue running until it is stopped.
        Toast.makeText(this, "service has started.", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "service has ended.", Toast.LENGTH_LONG).show();
    }

}
