package edu.wit.mobileapp.nhl_analyzer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private RelativeLayout mDrawerRelativeLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    String[] mDrawerOptionLabels;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerListView = (ListView) findViewById(R.id.left_drawer);
        mDrawerRelativeLayout = (RelativeLayout) findViewById(R.id.left_drawer_layout);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);

        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        Resources resources = getResources();
        mDrawerOptionLabels = resources.getStringArray(R.array.sliding_drawer_array);
        ArrayAdapter<String> drawerAdapter = new ArrayAdapter<String>(this,R.layout.drawer_list_item, mDrawerOptionLabels);

        mDrawerListView.setAdapter(drawerAdapter);

        mDrawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void
            onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                FragmentManager fm = getFragmentManager();
                Fragment fragment = new HomeFragment();

                switch (position)
                {
                    case 0:
                        fragment = new HomeFragment();
                        break;
                    case 1:
                        fragment = new AdvancedStatsFragment();
                        break;
                    case 2:
                        fragment = new AboutStatsFragment();
                        break;
                    case 3:
                        fragment = new GraphsChartsFragment();
                        break;
                    case 4:
                        fragment = new SettingsFragment();
                        break;
                }
                fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
                setTitle(mDrawerOptionLabels[position]);
                mDrawerListView.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(mDrawerRelativeLayout);
            }
        });
        if (savedInstanceState == null)
        {
            FragmentManager fm = getFragmentManager();
            Fragment fragment = new HomeFragment();
            fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
            setTitle(mDrawerOptionLabels[0]);
        }
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (mDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Opens fragments by buttons on home fragment
    public void Open(View view)
    {
        int id = view.getId();
        int position=0;

        FragmentManager fm = getFragmentManager();
        Fragment fragment = new HomeFragment();

        if(id == R.id.AdvancedStatsButton)
        {
            position = 1;
            fragment = new AdvancedStatsFragment();
        }
        else if(id == R.id.AboutStatsButton)
        {
            position = 2;
            fragment = new AboutStatsFragment();
        }
        else if(id == R.id.GraphsChartsButton)
        {
            position = 3;
            fragment = new GraphsChartsFragment();
        }
        else if(id == R.id.SettingsButton)
        {
            position = 4;
            fragment = new SettingsFragment();
        }
        fm.beginTransaction().replace(R.id.content_frame, fragment).commit();
        setTitle(mDrawerOptionLabels[position]);
        mDrawerListView.setItemChecked(position, true);
    }

    public ArrayList initializeplayers(){
        ArrayList playerlist = new ArrayList();

        return playerlist;
    }
}
