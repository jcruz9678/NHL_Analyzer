package edu.wit.mobileapp.nhl_analyzer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment
{
    ImageView ImageButton;

    String DefaultImage = "https://i.imgur.com/a90HNxM.png";

    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        boolean imagedefault = true;
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        if(imagedefault = true){
            //Set default image
            ImageButton = rootView.findViewById(R.id.AdvancedStatsButton);
            loadImageFromUrl(DefaultImage);
            ImageButton = rootView.findViewById(R.id.AboutStatsButton);
            loadImageFromUrl(DefaultImage);
            ImageButton = rootView.findViewById(R.id.GraphsChartsButton);
            loadImageFromUrl(DefaultImage);
            ImageButton = rootView.findViewById(R.id.SettingsButton);
            loadImageFromUrl(DefaultImage);
        }
        else{
            //load chosen image


        }

        return rootView;
    }

    //TODO: Fix photo button
    private void loadImageFromUrl (String url)
    {
        Picasso.with(getContext()).load(url).into(ImageButton, new com.squareup.picasso.Callback()
        {//                        ^.placeholder(R.mipmap.ic_project40logo) .error(R.mipmap.ic_project40logo)
            @Override
            public void onSuccess() { }
            @Override
            public void onError() { }
        });
    }


}