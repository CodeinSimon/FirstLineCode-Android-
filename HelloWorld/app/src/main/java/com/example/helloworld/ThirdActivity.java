package com.example.helloworld;



import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class ThirdActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Third Activity", "Task id is" + getTaskId());
        setContentView(R.layout.third_layout);
        Button button3 = (Button) findViewById(R.id.button_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCollector.finishAll();
                //to kill my process
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, ThirdActivity .class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }



    

//    /* when activity is visible */
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        Log.d(msg, "The onStart() event");
//
//    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//        Log.d(msg, "The onResume() event");
//    }
//
//    @Override
//    public void onPause(){
//        super.onPause();
//        Log.d(msg, "The onPause() event");
//    }
//
//    @Override
//    public void onStop(){
//        super.onStop();
//        Log.d(msg, "The onStop() event");
//    }
//
//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        Log.d(msg, "The onDestroy() event");
//    }




}
