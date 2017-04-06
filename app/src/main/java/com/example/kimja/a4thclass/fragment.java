package com.example.kimja.a4thclass;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class fragment extends android.support.v4.app.Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragview = inflater.inflate(R.layout.fragment, container, false);

//        TextView textView = (TextView)fragview.findViewById(R.id.)

        return fragview;
    }
}
