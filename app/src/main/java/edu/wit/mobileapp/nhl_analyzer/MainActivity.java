package edu.wit.mobileapp.nhl_analyzer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<player> playerlist;
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

        playerlist = new ArrayList<>();
        initplayers();
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
    private void initplayers(){
        //with help from http://androidbash.com/connecting-android-app-to-a-database-using-php-and-mysql/
        AsyncTask<Void, Void, Void> asyncTask = new AsyncTask<Void, Void, Void>() {
            String siteurl = "https://pure-badlands-77403.herokuapp.com/phpcodetry2.php";
            @Override
            protected Void doInBackground(Void... voids) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(siteurl).build();
                try {
                    Response response = client.newCall(request).execute();
                    JSONArray array = new JSONArray((response.body().string()));
                    int i = 0;
                    while (i<array.length()){
                        JSONObject object = array.getJSONObject(i);
                        player newplayer = new player(object.getInt("idplayers"), object.getString("name"), object.getInt("age"), object.getString("team"),object.getString("pos"), object.getInt("gp"), object.getInt("CF"),
                                object.getInt("CA"), object.getDouble("CFpercent"), object.getDouble("CFpercentRel"), object.getInt("FF"), object.getInt("FA"), object.getDouble("FFpercent"), object.getDouble("FFpercentRel"),
                                object.getDouble("oiSHpercent"), object.getDouble("oiSVpercent"), object.getDouble("PDO"), object.getDouble("oZSpercent"), object.getDouble("dZSpercent"), object.getString("TOI60"), object.getString("TOIEV"), object.getInt("TK"),
                                object.getInt("GV"), object.getDouble("Eplusminus"), object.getInt("Satt"), object.getDouble("Thrupercent"));
                        MainActivity.this.playerlist.add(newplayer);
                        i++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid){
                //code here can be used to notify the app that everything's been loaded, if needed
            }
        };
        asyncTask.execute();
    }
}
