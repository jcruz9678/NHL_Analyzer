package edu.wit.mobileapp.nhl_analyzer;

import android.app.LauncherActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class AboutStatsItemAdapter extends ArrayAdapter<AboutStatsItem>
{
    private LayoutInflater mInflater;

    public AboutStatsItemAdapter(Context context, int rid, List<AboutStatsItem> list)
    {
        super(context, rid, list);
        mInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {

        // Retrieve data
        AboutStatsItem item = getItem(position);

        // Use layout file to generate View
        View view = mInflater.inflate(R.layout.about_stats_item, null);

        // Set user name
        TextView title;
        title = (TextView)view.findViewById(R.id.STitle);
        title.setText(item.STitle);

        // Set comment
        TextView comment;
        comment = (TextView) view.findViewById(R.id.SDescription);
        comment.setText(item.SDescription);

        return view;

    }
}