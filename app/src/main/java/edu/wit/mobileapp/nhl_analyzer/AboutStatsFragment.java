package edu.wit.mobileapp.nhl_analyzer;

import android.app.Fragment;
import android.app.LauncherActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AboutStatsFragment extends Fragment
{

    public AboutStatsFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.about_stats_fragment, container, false);

        // Create testing data
        List<AboutStatsItem> list = new ArrayList<AboutStatsItem>();

        //Grab string arrays from string file
        String TitleArray[] = getResources().getStringArray(R.array.about_stats_title_array);
        String DescriptionArray[] = getResources().getStringArray(R.array.about_stats_description_array);

        //Item array                        Size depends on number of strings
        AboutStatsItem[] array = new AboutStatsItem[TitleArray.length];

        for(int i=0;i<array.length;i++)
        {
            AboutStatsItem item = new AboutStatsItem();
            array[i] = item;
            array[i].STitle = TitleArray[i];
            array[i].SDescription = DescriptionArray[i];
            list.add(array[i]);
        }


        edu.wit.mobileapp.nhl_analyzer.AboutStatsItemAdapter adapter;
        adapter = new AboutStatsItemAdapter(getContext(), 0, list);

        ListView listView = (ListView) rootView.findViewById(R.id.ListView01);
        listView.setAdapter(adapter);

        return rootView;
    }


}