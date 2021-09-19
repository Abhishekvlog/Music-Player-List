package com.example.music_player_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

public class SongDetail extends AppCompatActivity {
    private TextView mTvSName;
    private ImageView mTvSImage;
    private ImageView mBtnPlay;
    private MusicService musicService;
    private ImageView mBtnPause;
    private ImageView mBtnStop;
    private TextView mTvTime;
    private final  String channel_id = "notification_channel";
    private SharedPreferences sp;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MusicService.ServiceBinder serviceBinder = (MusicService.ServiceBinder) iBinder;
            musicService = serviceBinder.getMusicService();
           // musicService.SETHandler(handler);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);
        initView();
        int imageId = PreferenceHelper.getIntFromPreference(SongDetail.this, "imageid");
        String Name = PreferenceHelper.getStringFromPreference(SongDetail.this, "Nameid");

        mTvSImage.setImageResource(imageId);
        mTvSName.setText(Name);
        sp = getSharedPreferences("MyLocalDataBase", Context.MODE_PRIVATE);



        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicService != null){
                    musicService.play();
                    //musicService.startTimer();

                }
            }
        });
        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicService != null){
                    musicService.Pause();
                }
            }
        });
        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicService != null){
                    musicService.stop();
                }
            }
        });

    }
//    private Handler handler = new Handler(getMainLooper()){
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            int time = (int) msg.obj;
//            mTvTime.setText(time + " ");
//        }
//    };

    private void initView() {

        mTvSImage = findViewById(R.id.songimage);
        mTvSName = findViewById(R.id.TvName);
        mBtnPlay = findViewById(R.id.startSong);
        mBtnPause = findViewById(R.id.pauseSong);
        mBtnStop = findViewById(R.id.StopSong);
        StartService();
    }


    private void StartService() {
        Intent intent = new Intent(this,MusicService.class);
        bindService(intent, serviceConnection,BIND_AUTO_CREATE);

    }
}

