package com.example.android.quakereport;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Yusuf on 10/11/2016.
 */

public class Earthquake {
    private double mMagnitude;
    private String mPlace;
    private long mTime;
    private String mURL;
    public Earthquake(double magnitude,String place,long time,String url){
        mMagnitude=magnitude;
        mPlace=place;
        mTime=time;
        mURL=url;
    }

    public String getmMagnitude() {
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(mMagnitude);
        return output;
    }
    public int getMagnitudeColor(){
        int x = (int)Math.floor(mMagnitude);
        int colourResource;
        switch (x){
            case 0 :
            case 1 : colourResource= R.color.magnitude1; break;
            case 2 : colourResource= R.color.magnitude2; break;
            case 3 : colourResource= R.color.magnitude3; break;
            case 4 : colourResource= R.color.magnitude4; break;
            case 5 : colourResource= R.color.magnitude5; break;
            case 6 : colourResource= R.color.magnitude6; break;
            case 7 : colourResource= R.color.magnitude7; break;
            case 8 : colourResource= R.color.magnitude8; break;
            case 9 : colourResource= R.color.magnitude9; break;
            case 10 : colourResource= R.color.magnitude10plus; break;
            default: colourResource= R.color.magnitude10plus; break;
        }

        return colourResource;


    }

    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
        String formattedDate = sdf.format(mTime);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM DD,yyyy");
//        String formattedDate = dateFormat.format(new Date(mTime*1000L));
//        Log.v("Earthquake : ",formattedDate);
        return formattedDate;
    }
    public String getLocationOffset(){
        int x = mPlace.indexOf("of");
        if(x==-1){
            return "Near the";
        }
        return mPlace.substring(0,x+2);
    }
    public String getPrimaryLocation() {
        int x = mPlace.indexOf("of");
        if(x==-1){
            return mPlace;
        }
        return mPlace.substring(x+3);
    }
    public String getTime() {
        SimpleDateFormat timeFormat = new SimpleDateFormat(" 'at' h:mm a");
        String formattedTime = timeFormat.format(mTime);
        return formattedTime;
    }
    public String getmURL(){
        return mURL;
    }
}
