package com.example.owner.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs){

        super(context, 0, songs);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Song currentSong = getItem(position);

        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);

        songTextView.setText(currentSong.getSongName());

        TextView singTextView = (TextView) listItemView.findViewById(R.id.singer_text_view);

        singTextView.setText(currentSong.getSongSinger());

        TextView lengthTextView = (TextView) listItemView.findViewById(R.id.length_text_view);

        lengthTextView.setText(currentSong.getSongLength());


        ImageView imageView = (ImageView)listItemView.findViewById(R.id.image);
        if (currentSong.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentSong.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);
        return listItemView;

    }
}
