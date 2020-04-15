package com.example.pr13_17it013;

import android.app.PictureInPictureParams;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.util.Rational;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
    Button b;
    String path = "android.resource://com.example.pr13_17it013/"+R.raw.demo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView =(VideoView)findViewById(R.id.videoView1);
        b = findViewById(R.id.pip_button);
        //Creating MediaController
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);

        //specify the location of media file


        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(path));
        videoView.requestFocus();
        videoView.start();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Display d = getWindowManager().getDefaultDisplay();
                Point p = new Point();
                d.getSize(p);
                int width = p.x;
                int height = p.y;

                Rational ratio = new Rational(width,height);
                PictureInPictureParams.Builder pip_Builder = new PictureInPictureParams.Builder();
                pip_Builder.setAspectRatio(ratio).build();
                enterPictureInPictureMode(pip_Builder.build());

            }
        });
    }


}