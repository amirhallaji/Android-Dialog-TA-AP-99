package com.example.dialogproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

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
        long secondaryProgress = 1500L;
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);   //default style
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                progressDialog.dismiss();
//            }
//        },progress);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getProgress() < progressDialog.getMax()) {
                    progressDialog.incrementProgressBy(12);
                }
                else {
                    progressDialog.dismiss();
                }
            }
        }, 0, progress);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getProgress() < progressDialog.getMax()){
                    progressDialog.incrementSecondaryProgressBy(20);
                }
            }
        },0,secondaryProgress);



    }



    public void showAlertDialog(View view){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
//        //type 1
//        alertDialog.setTitle("Alert Dialog")
//                .setMessage("Do you want to delete this file ?")
//                .setCancelable(false)
//                .setIcon(android.R.drawable.ic_dialog_alert)
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"files deleted",Toast.LENGTH_LONG).show();
//                    }
//                })
//                .setNegativeButton("NO" , null)
//                .setNeutralButton("Cancel",null)
//                .show();

        //type 2
        alertDialog.setCancelable(false)
                .setTitle("Question")
                .setSingleChoiceItems(new String[]{"A", "B", "C"}, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"which : " + which,Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Ok",null)
                .show();
    }


}
