package com.wordpress.sjatyourservice.programminglanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

public class ListViewItemClick1 extends AppCompatActivity {
   ListView listView;
    ImageView ImageButton;
    private TextView mlaunchCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_item_click1);

        ImageButton=(ImageView) findViewById(R.id.imageButton);

            ImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    shareit();


                }
            });


          listView =(ListView) findViewById(R.id.listView);



            String[] values = new String[]{"Question1", "Question2",
                                           "Question3", "Question4","Question5 " ,"Question6",
                                           "Question7", "Question8", "Question9 " ,"Question10.",
                                           };

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, values);

            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    if (position == 0) {
                        Intent myIntent = new Intent(ListViewItemClick1.this,  Question1.class);
                        startActivity(myIntent);
                    }

                    if (position == 1) {
                        Intent myIntent = new Intent(ListViewItemClick1.this, Question2.class);
                        startActivity(myIntent);
                    }

                    if (position == 2) {
                        Intent myIntent = new Intent(ListViewItemClick1.this, Question3.class);
                        startActivity(myIntent);
                    }

                    if (position == 3) {
                        Intent myIntent = new Intent(ListViewItemClick1.this, Question4.class);
                        startActivity(myIntent);
                    }

                    if (position == 4) {
                        Intent myIntent = new Intent(ListViewItemClick1.this,  Question5.class);
                        startActivity(myIntent);
                    }

                    if (position == 5) {
                        Intent myIntent = new Intent(ListViewItemClick1.this, Question6.class);
                        startActivity(myIntent);
                    }

                    if (position == 6) {
                        Intent myIntent = new Intent(ListViewItemClick1.this, Question7.class);
                        startActivity(myIntent);
                    }

                    if (position == 7) {
                        Intent myIntent = new Intent(ListViewItemClick1.this, Question8.class);
                        startActivity(myIntent);
                    }


                    if (position == 8) {
                        Intent myIntent = new Intent(ListViewItemClick1.this, Question9.class);
                        startActivity(myIntent);
                    }
                    if (position == 9) {
                        Intent myIntent = new Intent(ListViewItemClick1.this, Question10.class);
                        startActivity(myIntent);
                    }

                }
            });





        //from here progm for rate us dialog starts!!!


//for counting each launch of app
        mlaunchCount = (TextView) findViewById(R.id.launchCount);
        AppPreferences.getInstance(getApplicationContext()).incrementLaunchCount();
        mlaunchCount.setText(getString(R.string.app_message,
                AppPreferences.getInstance(getApplicationContext()).getLaunchCount()));
        showRateAppDialogIfNeeded();
    }


//sharing activities method are kept out of the bundled saves instances method
protected void shareit(){
    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
    sharingIntent.setType("text/plain");
    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "PROGRAMMING LANGUAGE");
    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Now Learn Android,java  and " +
            "programming language" +
            " with " +
            "their Solved examples just click here to visit https://sjatyourservice.wordpress.com/" +
            " ");
    startActivity(Intent.createChooser(sharingIntent, "Share via"));


}

    // setting number of  specified launch(here 3) to shows dialog box of rating
    private void showRateAppDialogIfNeeded() {
        boolean bool = AppPreferences.getInstance(getApplicationContext()).getAppRate();
        int i = AppPreferences.getInstance(getApplicationContext()).getLaunchCount();
        if ((bool) && (i == 3)) {
            createAppRatingDialog(getString(R.string.rate_app_title), getString(R.string.rate_app_message)).show();
        }
    }

//after specified dialog showing rate option dialog

    private AlertDialog createAppRatingDialog(String rateAppTitle, String rateAppMessage) {
        AlertDialog dialog = new AlertDialog.Builder(this).setPositiveButton(getString(R.string.dialog_app_rate), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                openAppInPlayStore(ListViewItemClick1.this);
                AppPreferences.getInstance(ListViewItemClick1.this.getApplicationContext()).setAppRate(false);
            }
        }).setNegativeButton(getString(R.string.dialog_your_feedback), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                openFeedback(ListViewItemClick1.this);
                AppPreferences.getInstance(ListViewItemClick1.this.getApplicationContext()).setAppRate(false);
            }
        }).setNeutralButton(getString(R.string.dialog_ask_later), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
                paramAnonymousDialogInterface.dismiss();
                AppPreferences.getInstance(ListViewItemClick1.this.getApplicationContext()).resetLaunchCount();
            }
        }).setMessage(rateAppMessage).setTitle(rateAppTitle).create();
        return dialog;
    }


    //for opening app in play store
    public static void openAppInPlayStore(Context paramContext) {
        paramContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/")));
    }
    //for feedback directly to mail id
    public static void openFeedback(Context paramContext) {
        Intent localIntent = new Intent(Intent.ACTION_SEND);
        localIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shashi.jaiswal17@gmail.com"});
        localIntent.putExtra(Intent.EXTRA_CC, "");
        String str = null;
        try {
            str = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
            localIntent.putExtra(Intent.EXTRA_SUBJECT, "Feedback for Your Android App");
            localIntent.putExtra(Intent.EXTRA_TEXT, "\n\n----------------------------------\n Device OS: Android \n Device OS version: " +
                    Build.VERSION.RELEASE + "\n App Version: " + str + "\n Device Brand: " + Build.BRAND +
                    "\n Device Model: " + Build.MODEL + "\n Device Manufacturer: " + Build.MANUFACTURER);
            localIntent.setType("message/rfc822");
            paramContext.startActivity(Intent.createChooser(localIntent, "Choose an Email client :"));
        } catch (Exception e) {
            Log.d("OpenFeedback", e.getMessage());
        }
    }


}

