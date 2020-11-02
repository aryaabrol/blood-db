package com.example.bloodbank;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class video1 extends AppCompatActivity {
    private Button help,ignore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video1);

        help=findViewById(R.id.help);
        ignore=findViewById(R.id.ignore);

        ignore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(video1.this,video3.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(video1.this,video2.class);
                startActivity(intent);
            }
        });

        VideoView videoView=findViewById(R.id.videoView);
        String path="android.resource://"+ getPackageName() + "/"+R.raw.accident;
        Uri uri=Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.start();

        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                help.setVisibility(View.VISIBLE);
                ignore.setVisibility(View.VISIBLE);
            }
        });
    }
}