package com.example.owner.musicplayer;
import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home2, container, false);

        final ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Wake up Sid.mp3", "Ed Sheeran", "3:21", R.raw.wake_up_sid, R.drawable.music_image));



        SongAdapter adapter = new SongAdapter(getContext(), songs);

        ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment

        return view;
    }



}
