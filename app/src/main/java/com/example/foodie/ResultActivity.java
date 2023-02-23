/*
        AUTHORS

        S.C.R FERNANDO AS2019918
        H.R.Ranaweera  AS2019950

*/
package com.example.foodie;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //add the app logo to right
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(actionBar.getDisplayOptions()| ActionBar.DISPLAY_SHOW_CUSTOM);
        ImageView imageView = new ImageView(actionBar.getThemedContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.ic_topbar_logo);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT| Gravity.CENTER_VERTICAL);
        layoutParams.rightMargin = 40;
        imageView.setLayoutParams(layoutParams);
        actionBar.setCustomView(imageView);

        //set the Custom Text To Action Bar
        actionBar.setTitle(Html.fromHtml("<font color=\"#333333\">" + "Nutrient Profile" + "</font>"));

        loadData();

    }

    public void loadData(){

        TextView resultTextViewCarbohydrates =findViewById(R.id.carbohydratesInGrams);
        TextView resultTextViewProtein =findViewById(R.id.proteinInGrams);
        TextView resultTextViewSalt =findViewById(R.id.saltInGrams);
        TextView resultTextViewFat =findViewById(R.id.fatInGrams);
        TextView resultTextViewAdditional =findViewById(R.id.additionalInGrams);

        ProgressBar progressBarCarbohydrates =findViewById(R.id.progressBarCarbohydrates);
        ProgressBar progressBarProtein =findViewById(R.id.progressBarProtein);
        ProgressBar progressBarSalt =findViewById(R.id.progressBarSalt);
        ProgressBar progressBarFat =findViewById(R.id.progressBarFat);
        ProgressBar progressBarAdditional =findViewById(R.id.progressBarAdditional);

        resultTextViewCarbohydrates.setText(getIntent().getStringExtra("TotalNoOfCarbohydrate")+"g");
        resultTextViewProtein.setText(getIntent().getStringExtra("TotalNoOfProtein")+"g");
        resultTextViewSalt.setText(getIntent().getStringExtra("TotalNoOfSalt")+"g");
        resultTextViewFat.setText(getIntent().getStringExtra("TotalNoOfFat")+"g");
        resultTextViewAdditional.setText(getIntent().getStringExtra("TotalNoOfAdditional")+"g");

        //calculate the total weight
        float totalWeight=Float.parseFloat(getIntent().getStringExtra("TotalNoOfCarbohydrate"))+
                Float.parseFloat(getIntent().getStringExtra("TotalNoOfProtein"))+
                Float.parseFloat(getIntent().getStringExtra("TotalNoOfSalt"))+
                Float.parseFloat(getIntent().getStringExtra("TotalNoOfFat"))+
                Float.parseFloat(getIntent().getStringExtra("TotalNoOfAdditional"));

        //set the percentage value to progress bar
        progressBarCarbohydrates.setProgress(Math.round((Float.parseFloat(getIntent().getStringExtra("TotalNoOfCarbohydrate"))/totalWeight)*100));
        progressBarProtein.setProgress(Math.round((Float.parseFloat(getIntent().getStringExtra("TotalNoOfProtein"))/totalWeight)*100));
        progressBarSalt.setProgress(Math.round((Float.parseFloat(getIntent().getStringExtra("TotalNoOfSalt"))/totalWeight)*100));
        progressBarFat.setProgress(Math.round((Float.parseFloat(getIntent().getStringExtra("TotalNoOfFat"))/totalWeight)*100));
        progressBarAdditional.setProgress(Math.round((Float.parseFloat(getIntent().getStringExtra("TotalNoOfAdditional"))/totalWeight)*100));
    }
}