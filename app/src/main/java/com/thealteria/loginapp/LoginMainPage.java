package com.thealteria.loginapp;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class LoginMainPage extends AppCompatActivity {

    Button view, logo;
    int k = 0;
    DBHelper dbHelper;
    TextView show;
    EditText user, pass;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main_page);

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });

        dbHelper = new DBHelper(this);

     //  view = (Button)findViewById(R.id.view);
        logo = (Button) findViewById(R.id.logout);
//        show = (TextView)findViewById(R.id.showAll);
        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.password);
       /* Button but17 = (Button)findViewById(R.id.button17);*/
        Button writeBtn = (Button)findViewById(R.id.writing);
        Button codeBtn = (Button)findViewById(R.id.coding);
        Button marketBtn = (Button)findViewById(R.id.marketing);
        Button surveyBtn = (Button)findViewById(R.id.survey);
        Button instantBtn = (Button)findViewById(R.id.instant_cash);
//        Button but17 = (Button)findViewById(R.id.button17);

   /*     view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = dbHelper.getData();
                StringBuilder stringB = new StringBuilder();
                if(res!=null && res.getCount()>0){
                    while (res.moveToNext()){
                        *//*stringB.append("Name: "+res.getString(0)+"\n");
                        stringB.append("Username: "+res.getString(1)+"\n");
                        stringB.append("Password: "+res.getString(2)+"\n");*//*


                        *//*show.setText(stringB.toString());
                        Toast.makeText(LoginMainPage.this, "Your loan Request have been Submitted our support will get back to you soon", Toast.LENGTH_LONG).show();*//*


                    }
                    show.setText(stringB.toString());
                    Toast.makeText(LoginMainPage.this, "Your loan Request have been Submitted our support will get back to you soon", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LoginMainPage.this, "Data N/A", Toast.LENGTH_LONG).show();
                }
            }
        });*/

       /* public void WriteBtn(View view) {
            Intent intent = new Intent(LoginMainPage.this, TermActivity.class);
            startActivity(intent);
        }*/

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginMainPage.this, Page1.class);
                startActivity(intent);
            }
        });

        codeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginMainPage.this, Page2.class);
                startActivity(intent);
            }
        });


        marketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginMainPage.this, Page3.class);
                startActivity(intent);
            }
        });

        surveyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginMainPage.this, Page4.class);
                startActivity(intent);
            }
        });

        instantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginMainPage.this, Page5.class);
                startActivity(intent);
            }
        });


        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(LoginMainPage.this);
                builder.setTitle("Info");
                builder.setMessage("Are you sure you want to logout ??");
                builder.setPositiveButton("Yes I'm sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(LoginMainPage.this, Login.class);
                        startActivity(intent);
                        finish();
            }
        });

                builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

     /*   but17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// TODO Auto-generated method stub

                Uri uri = Uri.parse("market://details?id=com.fast.mpesake" );
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.fast.mpesake")));
                }

                       *//* intent = new Intent(android.content.Intent.ACTION_VIEW);

//Copy App URL from Google Play Store.
                        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.mpesa.loans"));

                        startActivity(intent);*//*

            }
        });
*/
    }

/*

    public void onBackPressed()
    {
        k++;
        if(k == 1)
        {

            AlertDialog.Builder alert = new AlertDialog.Builder(LoginMainPage.this);
            alert.setTitle("Rate Us Please:");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id="
                                        + getPackageName())));
                    }

                    dialog.dismiss();
                    finish();
                }
            });

            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            alert.create();
            alert.show();



           */
/* Toast.makeText(LoginMainPage.this, "Press again to go previous activity.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginMainPage.this, Login.class);
            startActivity(intent);*//*



                //super.onBackPressed();

               */
/* if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
                    builder = new AlertDialog.Builder(Activity2.this);
                } else {
                    builder = new AlertDialog.Builder(Activity2.this, AlertDialog.THEME_HOLO_LIGHT);
                }
                builder.setTitle(getString(R.string.app_name));
                builder.setMessage("Thank You For using Our Application");
                builder.setNegativeButton("RATE APP",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("market://details?id="+getString(R.string.pkg)));
                                startActivity(intent);
                                Toast.makeText(Activity2.this, "Thank you for your Rating", Toast.LENGTH_SHORT).show();

                            }
                        });
                builder.setPositiveButton("BACK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                finish();
                            }
                        });
                builder.setNeutralButton("MORE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                intent.setData(Uri.parse("market://search?q=pub:"+getString(R.string.pub)));
                                startActivity(intent);

                            }
                        });

                builder.show();*//*


        }
        else
        {
            finish();
        }
    }
*/

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


}
