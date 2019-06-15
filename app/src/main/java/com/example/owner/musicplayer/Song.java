package com.example.owner.musicplayer;

public class Song {
    private String mSongName;
    private String mSongSinger;
    private String mSongLength;
    private int mAudioResourceId;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this song */
    private static final int NO_IMAGE_PROVIDED = -1;


    // All the conditions are satissfied
    public Song(String songName, String songSinger, String songLength, int audioResourceId, int imageResourceId){
        mSongLength = songLength;
        mSongName = songName;
        mSongSinger = songSinger;
        mAudioResourceId= audioResourceId;
        mImageResourceId = imageResourceId;
    }

    public Song(String songName, String songSinger, int audioResourceId){
        mSongName = songName;
        mSongSinger = songSinger;
        mAudioResourceId = audioResourceId;
    }

    //Get the song name.
    public String getSongName() { return mSongName; }

    //Get the singer name.
    public String getSongSinger() {
        return mSongSinger;
    }

    //Get the song length.
    public String getSongLength() {
        return mSongLength;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }
}
