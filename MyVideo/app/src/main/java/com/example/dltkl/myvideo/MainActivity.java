package com.example.dltkl.myvideo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView video1 = (VideoView)findViewById(R.id.video1);
        video1.setVideoPath("http://download.jw.org/files/content_assets/46/502015515_E_cnt_1_r720P.mp4");

        MediaController m = new MediaController(this);
        m.setAnchorView(video1);
        video1.setMediaController(m);

        video1.start();
    }


}
