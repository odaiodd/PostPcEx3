package com.example.odaiodeh.ex3;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Thr extends AppCompatActivity {
    Button creat;
    TextView text;
    Button start;
    Button cancel;
    int count = 0;
    String MSG_KEY = "number";
    List<Thread> list = new ArrayList<Thread>();
    int index = -1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thr);
        creat = findViewById(R.id.creat);
        cancel = findViewById(R.id.cancel);
        text = findViewById(R.id.counter);
        start = findViewById(R.id.start);
        creat.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Thread t = new Thread(){
                    @Override
                    public void run() {

                        while(!isInterrupted()){
                            try {
                                sleep(500);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        count ++;
                                        if (count <11){
                                            text.setText(String.valueOf(count));
                                        }else{
                                            text.setText("Done");
                                        }

                                    }
                                });


                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                list.add(t);
                index++;
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = 0;
                list.get(index).start();

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list.get(index).interrupt();
                        text.setText("canceled");
                        list.remove(index);
                        index--;
                    }
                });
            }
        });

    }
}
