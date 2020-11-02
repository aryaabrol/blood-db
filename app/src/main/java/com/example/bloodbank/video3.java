package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class video3 extends AppCompatActivity {
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video3);
        exit=findViewById(R.id.exit);

        VideoView videoView=findViewById(R.id.videoView);
        String path="android.resource://"+ getPackageName() + "/"+R.raw.badend;
        Uri uri=Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(video3.this,MainActivity.class);
                startActivity(intent);
            }
        });

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}