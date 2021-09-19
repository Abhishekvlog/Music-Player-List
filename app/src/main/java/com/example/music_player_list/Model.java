package com.example.music_player_list;

public class Model {
    private int ImageSong;
    private String SongName;

    public Model(int imageSong, String songName) {
        ImageSong = imageSong;
        SongName = songName;
    }

    public int getImageSong() {
        return ImageSong;
    }

    public String getSongName() {
        return SongName;
    }
}
