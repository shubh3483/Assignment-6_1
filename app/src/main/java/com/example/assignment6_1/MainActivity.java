package com.example.assignment6_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.assignment6_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;

    // This is to increment the value of count
    int qty = 0;

    // These two integer variables will hold the value corresponding to the colour selected by the user.
    int backgroundColour = Color.parseColor("#C3BCBC");;
    int textColour = Color.parseColor("#FF000000");
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(b.getRoot());
        setTitle("Shared Preference Example");
        if(savedInstanceState != null){
            qty = savedInstanceState.getInt(Constants.QTY);
            b.showTV.setText(String.valueOf(qty));
        }else{

            /**
             * This is getting the values from the SharedPreferences object and setting the values
             * of the text view according to how it was left earlier.
             */

            //Getting reference for SharedPreference object.

            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            qty = prefs.getInt(Constants.QTY, 0);
            backgroundColour = prefs.getInt(Constants.BACKGROUND_COLOUR,backgroundColour);
            textColour = prefs.getInt(Constants.TEXT_COLOUR,textColour);
            b.showTV.setText(String.valueOf(qty));
            b.showTV.setBackgroundColor(backgroundColour);
            b.showTV.setTextColor(textColour);
        }
    }


    /**
     * All these below functions provides the functionality for all the buttons available in the UI.
     * @param view
     */
    public void count(View view) {
        qty++;
        b.showTV.setText(String.valueOf(qty));
    }

    public void blackBackground(View view) {
        textColour = Color.parseColor("#FFFFFFFF");
        backgroundColour = Color.parseColor("#FF000000");
        b.showTV.setBackgroundColor(backgroundColour);
        b.showTV.setTextColor(textColour);
    }

    public void redBackground(View view) {
        textColour = Color.parseColor("#FF000000");
        backgroundColour = Color.parseColor("#CF1919");
        b.showTV.setBackgroundColor(backgroundColour);
        b.showTV.setTextColor(textColour);

    }

    public void greenBackground(View view) {
        textColour = Color.parseColor("#FF000000");
        backgroundColour = Color.parseColor("#12C619");
        b.showTV.setBackgroundColor(backgroundColour);
        b.showTV.setTextColor(textColour);

    }

    public void blueBackground(View view) {
        textColour = Color.parseColor("#FF000000");
        backgroundColour = Color.parseColor("#263DBC");
        b.showTV.setBackgroundColor(backgroundColour);
        b.showTV.setTextColor(textColour);

    }

    public void resetToInitial(View view) {
        qty = 0;
        textColour = Color.parseColor("#FF000000");
        backgroundColour = Color.parseColor("#C3BCBC");
        b.showTV.setText(String.valueOf(qty));
        b.showTV.setBackgroundColor(backgroundColour);
        b.showTV.setTextColor(textColour);

    }


    /**
     * This function will create the object for SharedPreferences and will pass the values in it.
     */
    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        prefs.edit()
                .putInt(Constants.QTY, qty)
                .putInt(Constants.BACKGROUND_COLOUR, backgroundColour)
                .putInt(Constants.TEXT_COLOUR, textColour)
                .apply();
    }
}