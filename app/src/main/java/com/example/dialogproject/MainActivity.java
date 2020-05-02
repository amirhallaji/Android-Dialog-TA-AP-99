package com.example.dialogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.progressButton);
        setContentView(R.layout.activity_main);
    }

    public void showProgressDialog(View view){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Progress Dialog");
        progressDialog.setMessage("please wait...");
        progressDialog.setCancelable(false);
        final long progress = 3000L ;
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                progressDialog.dismiss();
//            }
//        },progress);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        new Timer().scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                if(progressDialog.getProgress() < progressDialog.getMax()){
//                    progressDialog.incrementProgressBy(2);
//                }
//                else {
//                    progressDialog.dismiss();
//                }
//            }
//        },0,progress);
        progressDialog.show();
    }
}
