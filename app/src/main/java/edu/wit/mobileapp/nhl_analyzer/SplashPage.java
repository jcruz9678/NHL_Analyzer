package edu.wit.mobileapp.nhl_analyzer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SplashPage extends AppCompatActivity
{
    private static int SPLASH_TIME_OUT = 2000; //Time in seconds to wait
    ImageView imageView;
    String LogoUrl = "https://i.imgur.com/mqP8nGF.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_splash_page);
        imageView = findViewById(R.id.logo);
        loadImageFromUrl(LogoUrl);

//Wait 2 seconds for splash screen
//*****************************************************************************************************************************
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent homeIntent = new Intent(SplashPage.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
//*****************************************************************************************************************************

    }
    //Load image from URL
//*****************************************************************************************************************************
    private void loadImageFromUrl (String url)
    {
        Picasso.with(this).load(url).into(imageView, new com.squareup.picasso.Callback()
        {//                        ^.placeholder() .error()
            @Override
            public void onSuccess()
            {

            }
            @Override
            public void onError()
            {

            }
        });
    }
//********************************************************************************************************************************
}
