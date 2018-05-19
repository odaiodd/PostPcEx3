package com.example.odaiodeh.ex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button thr;
    Button as;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thr = findViewById(R.id.thr);
        as = findViewById(R.id.asy);

        thr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create = new Intent(MainActivity.this,Thr.class);
                startActivity(create);
            }
        });

        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create = new Intent(MainActivity.this,Async.class);
                startActivity(create);
            }
        });

    }
}
