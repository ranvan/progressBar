package com.example.kiras.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ProgressBar;
import android.os.Handler;


public class MainActivity extends Activity {
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private Button btn = (Button) findViewById(R.id.btn);
    private TextView tv = (TextView) findViewById(R.id.tv);
    private ProgressBar pb = (ProgressBar) findViewById(R.id.pb);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressStatus < 100){
                            progressStatus +=1;
                            try{
                                Thread.sleep(20);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pb.setProgress(progressStatus);
                                    tv.setText(progressStatus+"");
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }
}