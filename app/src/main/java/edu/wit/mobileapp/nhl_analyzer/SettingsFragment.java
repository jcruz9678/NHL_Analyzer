package edu.wit.mobileapp.nhl_analyzer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import javax.xml.transform.Result;

public class SettingsFragment extends Fragment
{
    private static int PICK_IMAGE = 1;

    public SettingsFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        Switch switchTheme = (Switch) view.findViewById(R.id.themeSwitch);

        Button browseButton = (Button) view.findViewById(R.id.browse_button);

        //TODO finish button to allow users to change home stock image
        browseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on click, open image gallery
                openImageBrowser(v);
            }
        });

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            switchTheme.setChecked(true);
        }

        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    ((MainActivity) getActivity()).ToggleTheme(isChecked);

                }
                else{
                    ((MainActivity) getActivity()).ToggleTheme(isChecked);
                }
            }
        });

        return view;



    }


    public void openImageBrowser(View view){
        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(Intent.createChooser(galleryIntent, "Select Picture"), PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        Image userImg;
        if(requestCode == PICK_IMAGE){

        }
    }


}