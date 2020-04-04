package com.example.quinch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ques7 extends AppCompatActivity {
    private ProgressBar progressBar, progressBar1, progressBar2, progressBar3,progressBar4;
    private TextView textView2, textView3, tv1,tv2,tv3,tv4, butclick, fiftyclick, searchclick;
    private Button audibutton,fifty, search, but3, but4, but5, fifty1, fifty2;
    private long timeremaining=0;
    countdown myCountdownTimer;
    Timer timer=new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques7);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(ques7.this, finish.class);
                String point=textView3.getText().toString();
                intent.putExtra("point1", point);
                startActivity(intent);
                finish();
            }
        },30000);

        ProgressBar progressBar1 = findViewById(R.id.progressBar2);
        progressBar1.setVisibility(View.INVISIBLE);
        ProgressBar progressBar2 = findViewById(R.id.progressBar3);
        progressBar2.setVisibility(View.INVISIBLE);
        ProgressBar progressBar3 = findViewById(R.id.progressBar4);
        progressBar3.setVisibility(View.INVISIBLE);
        ProgressBar progressBar4 = findViewById(R.id.progressBar5);
        progressBar4.setVisibility(View.INVISIBLE);

        TextView tv1=findViewById(R.id.textView6);
        tv1.setVisibility(View.INVISIBLE);
        TextView tv2=findViewById(R.id.textView7);
        tv2.setVisibility(View.INVISIBLE);
        TextView tv3=findViewById(R.id.textView8);
        tv3.setVisibility(View.INVISIBLE);
        TextView tv4=findViewById(R.id.textView9);
        tv4.setVisibility(View.INVISIBLE);

        //Question Randomization
        String[] q1={"In 1206, who founded the Slave Dynasty, in India?", "The observation that 'Supply creates its own demand' is popularly called?", "A tree's age can be found by?", "In which decade was the first solid state integrated circuit demonstrated?"};
        Random r=new Random();
        int randomQues=r.nextInt(q1.length);
        final TextView textView=(TextView) findViewById(R.id.textView3);
        textView.setText(q1[randomQues]);
        //Button Text Randomization
        if (q1[randomQues].equals("In 1206, who founded the Slave Dynasty, in India?"))
        {
            final Button button3=(Button) findViewById(R.id.button3);
            button3.setText("Iltutmish");
            final Button button4=(Button) findViewById(R.id.button4);
            button4.setText("Razia Sultan");
            final Button button5=(Button) findViewById(R.id.button5);
            button5.setText("Balban");
            final Button button6=(Button) findViewById(R.id.button6);
            button6.setText("Qutubuddin Aibak");
        }
        else if (q1[randomQues].equals("The observation that 'Supply creates its own demand' is popularly called?"))
        {
            final Button button3=(Button) findViewById(R.id.button3);
            button3.setText("Graham's Law");
            final Button button4=(Button) findViewById(R.id.button4);
            button4.setText("Murphy's Law");
            final Button button5=(Button) findViewById(R.id.button5);
            button5.setText("Newton's Law");
            final Button button6=(Button) findViewById(R.id.button6);
            button6.setText("Say's Law");
        }
        else if (q1[randomQues].equals("A tree's age can be found by?"))
        {
            final Button button3=(Button) findViewById(R.id.button3);
            button3.setText("Counting number of branches.");
            final Button button4=(Button) findViewById(R.id.button4);
            button4.setText("Measuring height.");
            final Button button5=(Button) findViewById(R.id.button5);
            button5.setText("Measuring girth.");
            final Button button6=(Button) findViewById(R.id.button6);
            button6.setText("Counting number of annual rings.");
        }
        else if (q1[randomQues].equals("In which decade was the first solid state integrated circuit demonstrated?"))
        {
            final Button button3=(Button) findViewById(R.id.button3);
            button3.setText("1960s");
            final Button button4=(Button) findViewById(R.id.button4);
            button4.setText("1970s");
            final Button button5=(Button) findViewById(R.id.button5);
            button5.setText("1980s");
            final Button button6=(Button) findViewById(R.id.button6);
            button6.setText("1950s");
        }
        //Progress Bar Activity
        textView2=findViewById(R.id.textView);
        textView3=findViewById(R.id.textView2);
        progressBar= findViewById(R.id.progressBar);
        progressBar.setProgress(29);
        myCountdownTimer=new countdown(30000,1000);
        myCountdownTimer.start();

        //Disable Audience Poll
        audibutton=findViewById(R.id.button2);
        audibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int point, deductedPoint;
                textView3=(TextView) findViewById(R.id.textView2);
                point = Integer.parseInt(textView3.getText().toString());
                deductedPoint = point - 5;
                String newpoint=Integer.toString(deductedPoint);
                textView3.setText(newpoint);
                butclick = (TextView) findViewById(R.id.textView11);
                butclick.setText("yes");
                //Button Configuration
                audibutton.setEnabled(false);
                audibutton.setForeground(getDrawable(R.drawable.baseline_bar_chart_24_grey));
                audibutton.setBackground(getDrawable(R.drawable.lifeline_select));

                //Text View Visibility
                TextView tv1=findViewById(R.id.textView6);
                tv1.setVisibility(View.VISIBLE);
                String te11=tv1.getText().toString();
                String te1= te11.replace("%","");
                int endvalue3=Integer.parseInt(te1);
                TextView tv2=findViewById(R.id.textView7);
                String te21=tv2.getText().toString();
                String te2= te21.replace("%","");

                int endvalue2=Integer.parseInt(te2);
                tv2.setVisibility(View.VISIBLE);
                TextView tv3=findViewById(R.id.textView8);
                tv3.setVisibility(View.VISIBLE);
                String te31=tv3.getText().toString();
                String te3= te31.replace("%","");
                int endvalue4=Integer.parseInt(te3);
                TextView tv4=findViewById(R.id.textView9);
                tv4.setVisibility(View.VISIBLE);
                String te41=tv4.getText().toString();
                String te4= te41.replace("%","");
                int endvalue1=Integer.parseInt(te4);
                //Progress bars visibility
                ProgressBar progressBar1 = findViewById(R.id.progressBar2);
                progressBar1.setVisibility(View.VISIBLE);

                ObjectAnimator anim = ObjectAnimator.ofInt(progressBar1, "progress", 0, endvalue1);
                anim.setDuration(500);
                anim.setInterpolator(new DecelerateInterpolator());
                anim.start();
                ProgressBar progressBar2 = findViewById(R.id.progressBar3);
                progressBar2.setVisibility(View.VISIBLE);
                ObjectAnimator anim2 = ObjectAnimator.ofInt(progressBar2, "progress", 0, endvalue2);
                anim2.setDuration(500);
                anim2.setInterpolator(new DecelerateInterpolator());
                anim2.start();
                ProgressBar progressBar3 = findViewById(R.id.progressBar4);
                progressBar3.setVisibility(View.VISIBLE);
                ObjectAnimator anim3 = ObjectAnimator.ofInt(progressBar3, "progress", 0, endvalue3);
                anim3.setDuration(500);
                anim3.setInterpolator(new DecelerateInterpolator());
                anim3.start();
                ProgressBar progressBar4 = findViewById(R.id.progressBar5);
                progressBar4.setVisibility(View.VISIBLE);
                ObjectAnimator anim4 = ObjectAnimator.ofInt(progressBar4, "progress", 0, endvalue4);
                anim4.setDuration(500);
                anim4.setInterpolator(new DecelerateInterpolator());
                anim4.start();
            }
        });
        //getting intent
        Intent intent=getIntent();
        //getting yes
        String ifclick=intent.getStringExtra("ifclick");
        TextView ifyes=findViewById(R.id.textView11);
        ifyes.setText(ifclick);
        //getting second yes
        String iffifclick=intent.getStringExtra("iffifclick");
        TextView iffifyes=findViewById(R.id.textView13);
        iffifyes.setText(iffifclick);
        //getting score
        String marks=intent.getStringExtra("point1");
        TextView points=findViewById(R.id.textView2);
        points.setText(marks);
        int point, newpoint;
        point=Integer.parseInt(points.getText().toString());
        newpoint = point + 10;
        String newpoints=Integer.toString(newpoint);
        points.setText(newpoints);
        //disabling audipoll if yes
        Button audibutton=findViewById(R.id.button2);
        if (ifclick.equals("yes"))
        {
            audibutton.setEnabled(false);
            audibutton.setForeground(getDrawable(R.drawable.baseline_bar_chart_24_grey));
            audibutton.setBackground(getDrawable(R.drawable.lifeline_select));
        }
        else
        {
            audibutton.setEnabled(true);
            audibutton.setForeground(getDrawable(R.drawable.baseline_bar_chart_24));
            audibutton.setBackground(getDrawable(R.drawable.lifeline_audi));
        }
        //disabling 50:50 if yes
        Button fifty=findViewById(R.id.button10);
        if (iffifclick.equals("yes"))
        {
            fifty.setEnabled(false);
            fifty.setBackground(getDrawable(R.drawable.lifeline_select));
            fifty.setTextColor(Color.LTGRAY);
        }
    }
    @Override
    public void onBackPressed()
    {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        myCountdownTimer.cancel();
        timer.cancel();
    }
    public void nextques(View view)
    {
        //changing button text color
        but3=findViewById(R.id.button6);
        String option=but3.getText().toString();
        but3.setText(option + " +10");
        but3.setTextColor(Color.GREEN);

        //intent-ing
        Intent intent=new Intent(this, ques8.class);
        String point=textView3.getText().toString();
        intent.putExtra("point1", point);

        //yessing
        butclick=findViewById(R.id.textView11);
        fiftyclick = (TextView) findViewById(R.id.textView13);
        searchclick=findViewById(R.id.textView14);
        String ifclick=butclick.getText().toString();
        String iffifclick=fiftyclick.getText().toString();
        String ifsearchclick=searchclick.getText().toString();
        intent.putExtra("ifsearchclick", ifsearchclick);
        intent.putExtra("ifclick", ifclick);
        intent.putExtra("iffifclick", iffifclick);
        startActivity(intent);
        myCountdownTimer.cancel();
        timer.cancel();
    }
    public void endscr(View view)
    {
        //changing button text color
        but3=findViewById(R.id.button5);
        but4=findViewById(R.id.button3);
        but5=findViewById(R.id.button4);
        String option=but3.getText().toString();
        but3.setText(option + " +0");
        but3.setTextColor(Color.RED);
        String option1=but4.getText().toString();
        but4.setText(option1 + " +0");
        but4.setTextColor(Color.RED);
        String option2=but5.getText().toString();
        but5.setText(option2 + " +0");
        but5.setTextColor(Color.RED);

        //intent-ing
        Intent intent=new Intent(this, finish.class);
        String point=textView3.getText().toString();
        intent.putExtra("point1", point);
        startActivity(intent);
        myCountdownTimer.cancel();
        timer.cancel();
    }
    public void fifty(View view)
    {
        int point, deductedPoint;
        textView3=(TextView) findViewById(R.id.textView2);
        point = Integer.parseInt(textView3.getText().toString());
        deductedPoint = point - 5;
        String newpoint=Integer.toString(deductedPoint);
        textView3.setText(newpoint);
        fiftyclick = (TextView) findViewById(R.id.textView13);
        fiftyclick.setText("yes");
        //Button Configuration
        fifty=(Button) findViewById(R.id.button10);
        fifty.setEnabled(false);
        fifty.setTextColor(Color.LTGRAY);
        fifty.setBackground(getDrawable(R.drawable.lifeline_select));
        fifty1=findViewById(R.id.button3);
        fifty2=findViewById(R.id.button4);
        fifty1.setText(" ");
        fifty1.setEnabled(false);
        fifty2.setText(" ");
        fifty2.setEnabled(false);
    }
    public void search(View view)
    {
        int point, deductedPoint;
        textView3=(TextView) findViewById(R.id.textView2);
        point = Integer.parseInt(textView3.getText().toString());
        deductedPoint = point - 5;
        String newpoint=Integer.toString(deductedPoint);
        textView3.setText(newpoint);
        searchclick = (TextView) findViewById(R.id.textView14);
        searchclick.setText("yes");

        //Button Configuration
        search=(Button) findViewById(R.id.button11);
        search.setEnabled(false);
        search.setForeground(getDrawable(R.drawable.outline_search_24_grey));
        search.setBackground(getDrawable(R.drawable.lifeline_select));

        //Alert Dialog
        final Dialog dialog=new Dialog(ques7.this);
        dialog.setContentView(R.layout.websearch);
        dialog.setTitle("Question Search");
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setLayout(width, height);
        dialog.setCancelable(true);
        TextView tv=(TextView) dialog.findViewById(R.id.tv);
        tv.setText("Question Search (Time's ticking!)");
        WebView wv=(WebView) dialog.findViewById(R.id.wv);
        final TextView urltext=findViewById(R.id.textView3);
        String url=urltext.getText().toString();
        String googleurl="https://www.google.com/search?q="+url;
        wv.loadUrl(googleurl);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
        });

        // Get Connectivity Manager class object from Systems Service
        ConnectivityManager cm = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get Network Info from connectivity Manager
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected())
        {
            final ImageView logo=(ImageView) dialog.findViewById(R.id.logo);
            logo.setImageDrawable(getDrawable(R.drawable.ic_icons8_google_filled));
        }
        else
        {
            final ImageView logo=(ImageView) dialog.findViewById(R.id.logo);
            logo.setImageDrawable(getDrawable(R.drawable.outline_autorenew_24_black));
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WebView wv=(WebView) dialog.findViewById(R.id.wv);
                    final TextView urltext=findViewById(R.id.textView3);
                    String url=urltext.getText().toString();
                    String googleurl="https://www.google.com/search?q="+url;
                    wv.loadUrl(googleurl);
                    wv.getSettings().setJavaScriptEnabled(true);
                    wv.getSettings().setLoadWithOverviewMode(true);
                    wv.getSettings().setUseWideViewPort(true);
                    wv.setWebViewClient(new WebViewClient() {
                        @Override
                        public boolean shouldOverrideUrlLoading(WebView view, String url) {
                            view.loadUrl(url);

                            return true;
                        }
                    });
                    // Get Connectivity Manager class object from Systems Service
                    ConnectivityManager cm = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);

                    // Get Network Info from connectivity Manager
                    NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                    if (networkInfo != null && networkInfo.isConnected())
                    {
                        final ImageView logo=(ImageView) dialog.findViewById(R.id.logo);
                        logo.setImageDrawable(getDrawable(R.drawable.ic_icons8_google_filled));
                    }
                }
            });
        }
        Button gotit=(Button) dialog.findViewById(R.id.gotit);
        gotit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timeremaining==0) {
                    dialog.dismiss();
                }
                else if (timeremaining!=0)
                {
                    myCountdownTimer.start();
                    timer.cancel();
                    dialog.dismiss();
                }
            }
        });
        final Button pause=(Button) dialog.findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                final TextView timerem=findViewById(R.id.textView);
                String bachatime=timerem.getText().toString();
                timeremaining=Long.parseLong(bachatime);
                myCountdownTimer.cancel();
                TextView tv=(TextView) dialog.findViewById(R.id.tv);
                tv.setText("Question Search, TIME PAUSED!");
                int point, deductedPoint;
                textView3=(TextView) findViewById(R.id.textView2);
                point = Integer.parseInt(textView3.getText().toString());
                deductedPoint = point - 5;
                String newpoint=Integer.toString(deductedPoint);
                textView3.setText(newpoint);
                pause.setEnabled(false);
            }
        });
        dialog.show();
    }
    public void exit(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(ques7.this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent gohome=new Intent(ques7.this, MainActivity.class);
                        startActivity(gohome);
                        myCountdownTimer.cancel();
                        timer.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNeutralButton("Go Home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent gohome=new Intent(ques7.this, MainActivity.class);
                        startActivity(gohome);
                        myCountdownTimer.cancel();
                        timer.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void help(View view)
    {
        final Dialog help=new Dialog(this);
        LayoutInflater inflater = getLayoutInflater();
        View helpdiag= inflater.inflate(R.layout.activity_help, null);
        help.setContentView(helpdiag);
        help.setCancelable(true);
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        help.getWindow().setLayout(width, height);
        final TextView ab=help.findViewById(R.id.ab);
        ab.setVisibility(View.INVISIBLE);
        Toolbar toolbar=help.findViewById(R.id.my_toolbar);
        toolbar.setTitle("Help (Time is RUNNING!)");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help.dismiss();
            }
        });
        help.create();
        help.show();
    }

    public class countdown extends CountDownTimer
    {
        public countdown(long millisInFuture, long countDownInterval)
        {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished)
        {
            textView2.setText(String.valueOf(millisUntilFinished/1000));
            int progress = (int) (millisUntilFinished / 300);
            progressBar.setProgress(progress);
        }
        @Override
        public void onFinish()
        {
            textView2.setText("✖");
            textView2.setTextColor(Color.RED);
            Intent intent=new Intent(ques7.this, finish.class);
            String point=textView3.getText().toString();
            intent.putExtra("point1", point);
            startActivity(intent);
            progressBar.setProgress(0);
        }
    }
}

