package com.example.music_player_list;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MusicViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvSongName;
    private ImageView mIvSongImage;
    private OnItemClick onItemClick;
    private RelativeLayout relativeLayout;
    public MusicViewHolder(@NonNull View itemView, OnItemClick onItemClick) {
        super(itemView);
        this.onItemClick = onItemClick;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvSongName = itemView.findViewById(R.id.TvSongName);
        mIvSongImage = itemView.findViewById(R.id.TvSongImage);
        relativeLayout = itemView.findViewById(R.id.relativeLayout);
    }
    public void setData(Model model){
        mTvSongName.setText(model.getSongName());
        mIvSongImage.setImageResource(model.getImageSong());
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onItemClicked(getAdapterPosition(),model);
            }
        });
    }
}
