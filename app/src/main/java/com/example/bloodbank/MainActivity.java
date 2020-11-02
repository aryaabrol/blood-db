package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button donor,looking,awareness;
    private TextView hello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello=findViewById(R.id.textView3);

        looking=(Button) findViewById(R.id.button2);
        awareness=(Button) findViewById(R.id.awareness);

        awareness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,video1.class);
                startActivity(intent);

            }
        });


        looking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,register.class);
                startActivity(intent);
            }
        });
    }
}
