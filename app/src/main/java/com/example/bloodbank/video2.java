package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class video2 extends AppCompatActivity {
    private Button yes,no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video2);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(video2.this,video4.class);
                startActivity(intent);
            }
        });
        
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(video2.this,video3.class);
                startActivity(intent);
            }
        });

        VideoView videoView=findViewById(R.id.videoView);
        String path="android.resource://"+ getPackageName() + "/"+R.raw.main;
        Uri uri=Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                yes.setVisibility(View.VISIBLE);
                no.setVisibility(View.VISIBLE);
            }
        });
    }
}