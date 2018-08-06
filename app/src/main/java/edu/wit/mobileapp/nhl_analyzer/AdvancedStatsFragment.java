package edu.wit.mobileapp.nhl_analyzer;

import android.app.Fragment;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AdvancedStatsFragment extends Fragment
{
    private ArrayList<player> playerlist;

    public AdvancedStatsFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.advanced_stats_fragment, container, false);

        playerlist = new ArrayList<>();
        initplayers(rootView);

        return rootView;
    }

    private void initplayers(final View rootView) {
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
                    while (i < array.length()) {
                        try {
                            JSONObject object = array.getJSONObject(i);
                            player newplayer = new player(object.getInt("idplayers"), object.getString("name"), object.getInt("age"), object.getString("team"), object.getString("pos"), object.getInt("gp"), object.getInt("CF"),
                                    object.getInt("CA"), object.getDouble("CFpercent"), object.getDouble("CFpercentRel"), object.getInt("FF"), object.getInt("FA"), object.getDouble("FFpercent"), object.getDouble("FFpercentRel"),
                                    object.getDouble("oiSHpercent"), object.getDouble("oiSVpercent"), object.getDouble("PDO"), object.getDouble("oZSpercent"), object.getDouble("dZSpercent"), object.getString("TOI60"), object.getString("TOIEV"), object.getInt("TK"),
                                    object.getInt("GV"), object.getDouble("Eplusminus"), object.getInt("Satt"), object.getDouble("Thrupercent"));
                            playerlist.add(newplayer);
                        }catch(JSONException e) {
                            e.printStackTrace();
                        }
                        i++;

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch(JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                //code here can be used to notify the app that everything's been loaded, if needed
                int SizeTest = playerlist.size();
                String SizeTestString = Integer.toString(SizeTest);
                Log.v("MyApp", SizeTestString);
                init(rootView);
            }
        };
        asyncTask.execute();
    }

    public void init(View rootView) {
        TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(getContext());

        //Change all the items in the title here ********************************************
        int TitleColor = getResources().getColor(R.color.colorPrimaryDark);
        int TitleTextColor = getResources().getColor(R.color.white);
        int TitleTextSize = 35;
        int TextAlign = View.TEXT_ALIGNMENT_CENTER;

        TextView tv0 = new TextView(getContext());
        tv0.setText(" ID ");
        tv0.setTextColor(TitleTextColor);
        tv0.setTextSize(TitleTextSize);
        tv0.setBackgroundColor(TitleColor);
        tv0.setTextAlignment(TextAlign);

        TextView tv1 = new TextView(getContext());
        tv1.setText(" Player ");
        tv1.setTextColor(TitleTextColor);
        tv1.setTextSize(TitleTextSize);
        tv1.setBackgroundColor(TitleColor);
        tv1.setTextAlignment(TextAlign);
        tbrow0.addView(tv1);

        TextView tv2 = new TextView(getContext());
        tv2.setText(" Age ");
        tv2.setTextColor(TitleTextColor);
        tv2.setTextSize(TitleTextSize);
        tv2.setBackgroundColor(TitleColor);
        tv2.setTextAlignment(TextAlign);
        tbrow0.addView(tv2);

        TextView tv3 = new TextView(getContext());
        tv3.setText(" Team ");
        tv3.setTextColor(TitleTextColor);
        tv3.setTextSize(TitleTextSize);
        tv3.setBackgroundColor(TitleColor);
        tv3.setTextAlignment(TextAlign);
        tbrow0.addView(tv3);

        TextView tv4 = new TextView(getContext());
        tv4.setText(" Pos ");
        tv4.setTextColor(TitleTextColor);
        tv4.setTextSize(TitleTextSize);
        tv4.setBackgroundColor(TitleColor);
        tv4.setTextAlignment(TextAlign);
        tbrow0.addView(tv4);

        TextView tv5 = new TextView(getContext());
        tv5.setText(" GP ");
        tv5.setTextColor(TitleTextColor);
        tv5.setTextSize(TitleTextSize);
        tv5.setBackgroundColor(TitleColor);
        tv5.setTextAlignment(TextAlign);
        tbrow0.addView(tv5);

        TextView tv6 = new TextView(getContext());
        tv6.setText(" CF ");
        tv6.setTextColor(TitleTextColor);
        tv6.setTextSize(TitleTextSize);
        tv6.setBackgroundColor(TitleColor);
        tv6.setTextAlignment(TextAlign);
        tbrow0.addView(tv6);

        TextView tv7 = new TextView(getContext());
        tv7.setText(" CA ");
        tv7.setTextColor(TitleTextColor);
        tv7.setTextSize(TitleTextSize);
        tv7.setBackgroundColor(TitleColor);
        tv7.setTextAlignment(TextAlign);
        tbrow0.addView(tv7);

        TextView tv8 = new TextView(getContext());
        tv8.setText(" CF% ");
        tv8.setTextColor(TitleTextColor);
        tv8.setTextSize(TitleTextSize);
        tv8.setBackgroundColor(TitleColor);
        tv8.setTextAlignment(TextAlign);
        tbrow0.addView(tv8);

        TextView tv9 = new TextView(getContext());
        tv9.setText(" CF% rel ");
        tv9.setTextColor(TitleTextColor);
        tv9.setTextSize(TitleTextSize);
        tv9.setBackgroundColor(TitleColor);
        tv9.setTextAlignment(TextAlign);
        tbrow0.addView(tv9);

        TextView tv10 = new TextView(getContext());
        tv10.setText(" FF ");
        tv10.setTextColor(TitleTextColor);
        tv10.setTextSize(TitleTextSize);
        tv10.setBackgroundColor(TitleColor);
        tv10.setTextAlignment(TextAlign);
        tbrow0.addView(tv10);

        TextView tv11 = new TextView(getContext());
        tv11.setText(" FA ");
        tv11.setTextColor(TitleTextColor);
        tv11.setTextSize(TitleTextSize);
        tv11.setBackgroundColor(TitleColor);
        tv11.setTextAlignment(TextAlign);
        tbrow0.addView(tv11);

        TextView tv12 = new TextView(getContext());
        tv12.setText(" FF% ");
        tv12.setTextColor(TitleTextColor);
        tv12.setTextSize(TitleTextSize);
        tv12.setBackgroundColor(TitleColor);
        tv12.setTextAlignment(TextAlign);
        tbrow0.addView(tv12);

        TextView tv13 = new TextView(getContext());
        tv13.setText(" FF% rel ");
        tv13.setTextColor(TitleTextColor);
        tv13.setTextSize(TitleTextSize);
        tv13.setBackgroundColor(TitleColor);
        tv13.setTextAlignment(TextAlign);
        tbrow0.addView(tv13);

        TextView tv14 = new TextView(getContext());
        tv14.setText(" oiSH% ");
        tv14.setTextColor(TitleTextColor);
        tv14.setTextSize(TitleTextSize);
        tv14.setBackgroundColor(TitleColor);
        tv14.setTextAlignment(TextAlign);
        tbrow0.addView(tv14);

        TextView tv15 = new TextView(getContext());
        tv15.setText(" oiSV% ");
        tv15.setTextColor(TitleTextColor);
        tv15.setTextSize(TitleTextSize);
        tv15.setBackgroundColor(TitleColor);
        tv15.setTextAlignment(TextAlign);
        tbrow0.addView(tv15);

        TextView tv16 = new TextView(getContext());
        tv16.setText(" PDO ");
        tv16.setTextColor(TitleTextColor);
        tv16.setTextSize(TitleTextSize);
        tv16.setBackgroundColor(TitleColor);
        tv16.setTextAlignment(TextAlign);
        tbrow0.addView(tv16);

        TextView tv17 = new TextView(getContext());
        tv17.setText(" oZS% ");
        tv17.setTextColor(TitleTextColor);
        tv17.setTextSize(TitleTextSize);
        tv17.setBackgroundColor(TitleColor);
        tv17.setTextAlignment(TextAlign);
        tbrow0.addView(tv17);

        TextView tv18 = new TextView(getContext());
        tv18.setText(" dZS% ");
        tv18.setTextColor(TitleTextColor);
        tv18.setTextSize(TitleTextSize);
        tv18.setBackgroundColor(TitleColor);
        tv18.setTextAlignment(TextAlign);
        tbrow0.addView(tv18);

        TextView tv19 = new TextView(getContext());
        tv19.setText(" TOI/60 ");
        tv19.setTextColor(TitleTextColor);
        tv19.setTextSize(TitleTextSize);
        tv19.setBackgroundColor(TitleColor);
        tv19.setTextAlignment(TextAlign);
        tbrow0.addView(tv19);

        TextView tv20 = new TextView(getContext());
        tv20.setText(" TOI(EV) ");
        tv20.setTextColor(TitleTextColor);
        tv20.setTextSize(TitleTextSize);
        tv20.setBackgroundColor(TitleColor);
        tv20.setTextAlignment(TextAlign);
        tbrow0.addView(tv20);

        TextView tv21 = new TextView(getContext());
        tv21.setText(" TK ");
        tv21.setTextColor(TitleTextColor);
        tv21.setTextSize(TitleTextSize);
        tv21.setBackgroundColor(TitleColor);
        tv21.setTextAlignment(TextAlign);
        tbrow0.addView(tv21);

        TextView tv22 = new TextView(getContext());
        tv22.setText(" GV ");
        tv22.setTextColor(TitleTextColor);
        tv22.setTextSize(TitleTextSize);
        tv22.setBackgroundColor(TitleColor);
        tv22.setTextAlignment(TextAlign);
        tbrow0.addView(tv22);

        TextView tv23 = new TextView(getContext());
        tv23.setText(" E+/- ");
        tv23.setTextColor(TitleTextColor);
        tv23.setTextSize(TitleTextSize);
        tv23.setBackgroundColor(TitleColor);
        tv23.setTextAlignment(TextAlign);
        tbrow0.addView(tv23);

        TextView tv24 = new TextView(getContext());
        tv24.setText(" Satt. ");
        tv24.setTextColor(TitleTextColor);
        tv24.setTextSize(TitleTextSize);
        tv24.setBackgroundColor(TitleColor);
        tv24.setTextAlignment(TextAlign);
        tbrow0.addView(tv24);

        TextView tv25 = new TextView(getContext());
        tv25.setText(" Thru% ");
        tv25.setTextColor(TitleTextColor);
        tv25.setTextSize(TitleTextSize);
        tv25.setBackgroundColor(TitleColor);
        tv25.setTextAlignment(TextAlign);
        tbrow0.addView(tv25);

        //Add Id at the end instead of the beginning
        tbrow0.addView(tv0);

        //Add row
        stk.addView(tbrow0,0);

        //Change all the items in the table here ********************************************
        int ColorOdd = getResources().getColor(R.color.offWhite);
        int ColorEven = getResources().getColor(R.color.lightGrey);
        int TextColor = getResources().getColor(R.color.black);
        int TextSize = 18;

        for (int i=0;i < playerlist.size();i++) {
            //Makes row
            TableRow tbrow = new TableRow(getContext());

            TextView t1v = new TextView(getContext());
            int ID = playerlist.get(i).id;
            String IDString = Integer.toString(ID);
            t1v.setText(IDString);
            t1v.setBackgroundColor(ColorOdd);
            t1v.setTextAlignment(TextAlign);
            t1v.setTextColor(TextColor);
            t1v.setTextSize(TextSize);
            //Just need this once because it adds padding all the way down
            t1v.setPadding(0,2,0,2);
            //We don't add ID here.  We add it at the end

            TextView t2v = new TextView(getContext());
            String Name = playerlist.get(i).playername;
            t2v.setText(Name);
            t2v.setBackgroundColor(ColorEven);
            t2v.setTextAlignment(TextAlign);
            t2v.setTextColor(TextColor);
            t2v.setTextSize(TextSize);
            tbrow.addView(t2v);

            TextView t3v = new TextView(getContext());
            int Age = playerlist.get(i).age;
            String AgeString = Integer.toString(Age);
            t3v.setText(AgeString);
            t3v.setBackgroundColor(ColorOdd);
            t3v.setTextAlignment(TextAlign);
            t3v.setTextColor(TextColor);
            t3v.setTextSize(TextSize);
            tbrow.addView(t3v);

            TextView t4v = new TextView(getContext());
            String Team = playerlist.get(i).team;
            t4v.setText(Team);
            t4v.setBackgroundColor(ColorEven);
            t4v.setTextAlignment(TextAlign);
            t4v.setTextColor(TextColor);
            t4v.setTextSize(TextSize);
            tbrow.addView(t4v);

            TextView t5v = new TextView(getContext());
            String Pos = playerlist.get(i).pos;
            t5v.setText(Pos);
            t5v.setBackgroundColor(ColorOdd);
            t5v.setTextAlignment(TextAlign);
            t5v.setTextColor(TextColor);
            t5v.setTextSize(TextSize);
            tbrow.addView(t5v);

            TextView t6v = new TextView(getContext());
            int GP = playerlist.get(i).gp;
            String GPString = Integer.toString(GP);
            t6v.setText(GPString);
            t6v.setBackgroundColor(ColorEven);
            t6v.setTextAlignment(TextAlign);
            t6v.setTextColor(TextColor);
            t6v.setTextSize(TextSize);
            tbrow.addView(t6v);

            TextView t7v = new TextView(getContext());
            int CF = playerlist.get(i).CF;
            String CFString = Integer.toString(CF);
            t7v.setText(CFString);
            t7v.setBackgroundColor(ColorOdd);
            t7v.setTextAlignment(TextAlign);
            t7v.setTextColor(TextColor);
            t7v.setTextSize(TextSize);
            tbrow.addView(t7v);

            TextView t8v = new TextView(getContext());
            int CA = playerlist.get(i).CA;
            String CAString = Integer.toString(CA);
            t8v.setText(CAString);
            t8v.setBackgroundColor(ColorEven);
            t8v.setTextAlignment(TextAlign);
            t8v.setTextColor(TextColor);
            t8v.setTextSize(TextSize);
            tbrow.addView(t8v);

            TextView t9v = new TextView(getContext());
            double CFPer = playerlist.get(i).CFpercent;
            String CFPerString = Double.toString(CFPer);
            t9v.setText(CFPerString);
            t9v.setBackgroundColor(ColorOdd);
            t9v.setTextAlignment(TextAlign);
            t9v.setTextColor(TextColor);
            t9v.setTextSize(TextSize);
            tbrow.addView(t9v);

            TextView t10v = new TextView(getContext());
            double CFPerRel = playerlist.get(i).CFpercentRel;
            String CFPerRelString = Double.toString(CFPerRel);
            t10v.setText(CFPerRelString);
            t10v.setBackgroundColor(ColorEven);
            t10v.setTextAlignment(TextAlign);
            t10v.setTextColor(TextColor);
            t10v.setTextSize(TextSize);
            tbrow.addView(t10v);

            TextView t11v = new TextView(getContext());
            int FF = playerlist.get(i).FF;
            String FFString = Integer.toString(FF);
            t11v.setText(FFString);
            t11v.setBackgroundColor(ColorOdd);
            t11v.setTextAlignment(TextAlign);
            t11v.setTextColor(TextColor);
            t11v.setTextSize(TextSize);
            tbrow.addView(t11v);

            TextView t12v = new TextView(getContext());
            int FA = playerlist.get(i).FA;
            String FAString = Integer.toString(FA);
            t12v.setText(FAString);
            t12v.setBackgroundColor(ColorEven);
            t12v.setTextAlignment(TextAlign);
            t12v.setTextColor(TextColor);
            t12v.setTextSize(TextSize);
            tbrow.addView(t12v);

            TextView t13v = new TextView(getContext());
            double FFPer = playerlist.get(i).FFpercent;
            String FFPerString = Double.toString(FFPer);
            t13v.setText(FFPerString);
            t13v.setBackgroundColor(ColorOdd);
            t13v.setTextAlignment(TextAlign);
            t13v.setTextColor(TextColor);
            t13v.setTextSize(TextSize);
            tbrow.addView(t13v);

            TextView t14v = new TextView(getContext());
            double FFPerRel = playerlist.get(i).FFpercentRel;
            String FFPerRelString = Double.toString(FFPerRel);
            t14v.setText(FFPerRelString);
            t14v.setBackgroundColor(ColorEven);
            t14v.setTextAlignment(TextAlign);
            t14v.setTextColor(TextColor);
            t14v.setTextSize(TextSize);
            tbrow.addView(t14v);

            TextView t15v = new TextView(getContext());
            double ioSHPer = playerlist.get(i).oiSHpercent;
            String ioSHPerString = Double.toString(ioSHPer);
            t15v.setText(ioSHPerString);
            t15v.setBackgroundColor(ColorOdd);
            t15v.setTextAlignment(TextAlign);
            t15v.setTextColor(TextColor);
            t15v.setTextSize(TextSize);
            tbrow.addView(t15v);

            TextView t16v = new TextView(getContext());
            double ioSVPer = playerlist.get(i).oiSVpercent;
            String ioSVPerString = Double.toString(ioSVPer);
            t16v.setText(ioSVPerString);
            t16v.setBackgroundColor(ColorEven);
            t16v.setTextAlignment(TextAlign);
            t16v.setTextColor(TextColor);
            t16v.setTextSize(TextSize);
            tbrow.addView(t16v);

            TextView t17v = new TextView(getContext());
            double PDO = playerlist.get(i).PDO;
            String PDOString = Double.toString(PDO);
            t17v.setText(PDOString);
            t17v.setBackgroundColor(ColorOdd);
            t17v.setTextAlignment(TextAlign);
            t17v.setTextColor(TextColor);
            t17v.setTextSize(TextSize);
            tbrow.addView(t17v);

            TextView t18v = new TextView(getContext());
            double oZSPer = playerlist.get(i).oZSpercent;
            String ozSPerString = Double.toString(oZSPer);
            t18v.setText(ozSPerString);
            t18v.setBackgroundColor(ColorEven);
            t18v.setTextAlignment(TextAlign);
            t18v.setTextColor(TextColor);
            t18v.setTextSize(TextSize);
            tbrow.addView(t18v);

            TextView t19v = new TextView(getContext());
            double dZSPer = playerlist.get(i).dZSpercent;
            String dzSPerString = Double.toString(dZSPer);
            t19v.setText(dzSPerString);
            t19v.setBackgroundColor(ColorOdd);
            t19v.setTextAlignment(TextAlign);
            t19v.setTextColor(TextColor);
            t19v.setTextSize(TextSize);
            tbrow.addView(t19v);

            TextView t20v = new TextView(getContext());
            String TOI60 = playerlist.get(i).TOI60;
            t20v.setText(TOI60);
            t20v.setBackgroundColor(ColorEven);
            t20v.setTextAlignment(TextAlign);
            t20v.setTextColor(TextColor);
            t20v.setTextSize(TextSize);
            tbrow.addView(t20v);

            TextView t21v = new TextView(getContext());
            String TOIEV = playerlist.get(i).TOIEV;
            t21v.setText(TOIEV);
            t21v.setBackgroundColor(ColorOdd);
            t21v.setTextAlignment(TextAlign);
            t21v.setTextColor(TextColor);
            t21v.setTextSize(TextSize);
            tbrow.addView(t21v);

            TextView t22v = new TextView(getContext());
            int TK = playerlist.get(i).TK;
            String TKString = Integer.toString(TK);
            t22v.setText(TKString);
            t22v.setBackgroundColor(ColorEven);
            t22v.setTextAlignment(TextAlign);
            t22v.setTextColor(TextColor);
            t22v.setTextSize(TextSize);
            tbrow.addView(t22v);

            TextView t23v = new TextView(getContext());
            int GV = playerlist.get(i).GV;
            String GVString = Integer.toString(GV);
            t23v.setText(GVString);
            t23v.setBackgroundColor(ColorOdd);
            t23v.setTextAlignment(TextAlign);
            t23v.setTextColor(TextColor);
            t23v.setTextSize(TextSize);
            tbrow.addView(t23v);

            TextView t24v = new TextView(getContext());
            double EPlusMin = playerlist.get(i).Eplusminus;
            String EPlusMinString = Double.toString(EPlusMin);
            t24v.setText(EPlusMinString);
            t24v.setBackgroundColor(ColorEven);
            t24v.setTextAlignment(TextAlign);
            t24v.setTextColor(TextColor);
            t24v.setTextSize(TextSize);
            tbrow.addView(t24v);

            TextView t25v = new TextView(getContext());
            int Satt = playerlist.get(i).Satt;
            String SattString = Integer.toString(Satt);
            t25v.setText(SattString);
            t25v.setBackgroundColor(ColorOdd);
            t25v.setTextAlignment(TextAlign);
            t25v.setTextColor(TextColor);
            t25v.setTextSize(TextSize);
            tbrow.addView(t25v);

            TextView t26v = new TextView(getContext());
            double ThruPer = playerlist.get(i).thrupercent;
            String ThruPerString = Double.toString(ThruPer);
            t26v.setText(ThruPerString);
            t26v.setBackgroundColor(ColorEven);
            t26v.setTextAlignment(TextAlign);
            t26v.setTextColor(TextColor);
            t26v.setTextSize(TextSize);
            tbrow.addView(t26v);

            //Add Id at the end instead of the beginning
            tbrow.addView(t1v);

            //Prints out everything
            stk.addView(tbrow);
        }



    }


}