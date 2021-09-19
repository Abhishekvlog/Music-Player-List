package com.example.music_player_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements OnItemClick{
    private RecyclerView recyclerView;
    private TextView mTvSongName;
    private ImageView mIvSongImage;
    private ImageView mBtnPlay;
    private ImageView mBtnPause;
    private ImageView mBtnStop;
    private ArrayList<Model> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildViewData();
        setRecyclerAdapterView();
    }

    private void buildViewData() {
        modelList = new ArrayList<>();
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
        modelList.add(new Model(R.drawable.shapeofyou,"Shape Of You"));
    }

    private void setRecyclerAdapterView() {
        MusicAdapter musicAdapter = new MusicAdapter(modelList , this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(musicAdapter);

    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mTvSongName  = findViewById(R.id.TvSongName);
        mIvSongImage = findViewById(R.id.TvSongImage);

    }

    @Override
    public void onItemClicked(int position, Model model) {
        PreferenceHelper.writeIntToPreference(this,"imageid",model.getImageSong());
        PreferenceHelper.writeStringToPreference(this,"Nameid",model.getSongName());
        Intent intent = new Intent(MainActivity.this, SongDetail.class);
        startActivity(intent);

    }
}