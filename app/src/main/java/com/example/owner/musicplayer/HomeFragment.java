package com.example.owner.musicplayer;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends AppCompatActivity {

        private MediaPlayer mediaPlayer;
        private MediaPlayer.OnCompletionListener mCompleteListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                releaseMediaPlayer();
            }
        };

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_home2);
            final ArrayList<Song> songs = new ArrayList<Song>();
            songs.add(new Song("Wake up Sid", "Ed Sheeran", "3:21", R.raw.wake_up_sid, R.drawable.music_image));
            songs.add(new Song("Wake up Sid", "Ed Sheeran", "3:21", R.raw.wake_up_sid, R.drawable.music_image));
            // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
            // adapter knows how to create list items for each item in the list.
            SongAdapter adaptor = new SongAdapter(this, songs);
            ListView listView = (ListView) findViewById(R.id.list);

            listView.setAdapter(adaptor);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Song song = songs.get(position);

                    releaseMediaPlayer();

                    mediaPlayer = MediaPlayer.create(HomeFragment.this, song.getAudioResourceId());

                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(mCompleteListener);
                }
            });
        }

        @Override
        public void onStop() {
            super.onStop();
            releaseMediaPlayer();
        }


        private void releaseMediaPlayer() {
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }
    }