package edu.wit.mobileapp.nhl_analyzer;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class SettingsFragment extends Fragment
{
    private static int PICK_IMAGE = 1;
    private static Bitmap bitmap;
    ImageView imageview;

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
        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(galleryIntent, "Select Picture"), PICK_IMAGE);
        Log.d("TAG", "Browser opened");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        View v = getView();

        if(requestCode == PICK_IMAGE ){
            Uri uri = data.getData();

            try{
                bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                Log.d("TAG", String.valueOf(bitmap));


            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}