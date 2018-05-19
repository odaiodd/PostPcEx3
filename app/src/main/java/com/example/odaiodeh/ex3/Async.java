package com.example.odaiodeh.ex3;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Async extends AppCompatActivity {
    MyAsyncTask myAsyncTask;
    Button creat;
    Button start;
    Button cancel;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

        creat = findViewById(R.id.creat1);
        start = findViewById(R.id.start1);
        cancel = findViewById(R.id.cancel1);
        text = findViewById(R.id.counter1);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    myAsyncTask.execute();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    myAsyncTask.cancel(true);

            }
        });
        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask = new MyAsyncTask();
                myAsyncTask.onPreExecute();

            }
        });
    }


    public class MyAsyncTask extends AsyncTask<Void, Integer, String> {
        int counter = 0;

        @Override
        protected void onPreExecute() {
            text.setText("creating");
        }

        @Override
        protected String doInBackground(Void... voids) {
            while (counter < 11) {
                counter++;
                publishProgress(counter);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "done";
        }

        @Override
        protected void onProgressUpdate(Integer... process) {
            super.onProgressUpdate();
            text.setText(String.valueOf(process[0]));
        }

        @Override
        public void onPostExecute(String s) {
            text.setText(s);
        }

        @Override
        public void onCancelled() {
            super.onCancelled();
            text.setText("canceled");
        }


    }
}
