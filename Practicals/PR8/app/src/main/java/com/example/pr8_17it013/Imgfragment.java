package com.example.pr8_17it013;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Imgfragment extends Fragment {
    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_imgfragment, container, false);
        text = (TextView) view.findViewById(R.id.img);
        return view;
    }


    public void change(String s){
        text.setText(s);
    }
}
