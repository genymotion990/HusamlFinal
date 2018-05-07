package com.example.hp1.myfinalproject;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class Home extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener
{
    Button btrelationship, btask, btcamera, btread, btfitness;
    Button  btsex;
    ListView newsfeed;
    ArrayList<String> feed = new ArrayList<>();
    ArrayAdapter<String> adapter;

    /**
     * photo saving profile or choosing from gallery a profile picture
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btcamera = (Button) findViewById(R.id.btcamera);
        btcamera.setOnClickListener(this);
        btread = (Button) findViewById(R.id.btread);
        btread.setOnClickListener(this);
        btsex = (Button) findViewById(R.id.btsex);
        btsex.setOnClickListener(this);
        btask = (Button) findViewById(R.id.btask);
        btask.setOnClickListener(this);
        btfitness = (Button) findViewById(R.id.btfitness);
        btfitness.setOnClickListener(this);
        btrelationship = (Button)findViewById(R.id.btrelationship) ;
        btrelationship.setOnClickListener(this);

        newsfeed =(ListView) findViewById(R.id.lvNewsfeed);
/**
 * Q&A in the ask page.
 */
        feed.add("Can AI Detect Sexual Orientation from Photos?");  // discreption of the item in the listview
        feed.add("Feeling Lonely? You May Be Damaging Your Health"); // discreption of the item in the listview
        feed.add("What is Psychology?");
        feed.add("6 Signs You Don’t Know What Matters");
        feed.add("How To Take Action When You Don’t Wanna");
        feed.add("Talking With Teens About STIs");
        feed.add("11 Reasons Women Have Difficulty, and What Helps");
        feed.add("The Wisdom of Defense Mechanisms");
        feed.add("");
        feed.add("");

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, feed);
        newsfeed.setAdapter(adapter);// setting the adapter to the listview
        newsfeed.setOnItemLongClickListener(this);
    }

    /**
     * in the memu a list of options
     * @param menu on the left top corner
     * @return activity start true or false.
     */
    public boolean onCreateOptionsMenu (Menu menu) {        // coneccting the option menu from the resource file
    getMenuInflater().inflate(R.menu.homemenu, menu);
return true;
}
    public boolean onOptionsItemSelected (MenuItem item) { //setting up the option menu to work
        switch (item.getItemId()){
            case R.id.about:
                Intent i = new Intent(this, About.class);// when clicking on the option menu intents to the page
                startActivity(i);

            case R.id.profile:
                Intent l = new Intent(this, Profile.class);// when clicking on the option menu intents to the page
                startActivity(l);

        }
        return true;

    }

    /**
     * each button is a picture when clicked it intents to the page as described.
     * @param v the view of the activity
     */
    @Override
    public void onClick(View v) {

        if (v==btcamera){
            Intent i = new Intent(this, ProfileSet.class);// clicking on button and intenting to page
            startActivity(i);
        }
        if (v==btrelationship){
            Intent i = new Intent(this, Relationship.class);// clicking on button and intenting to page
            startActivity(i);
        }
        if (v==btask){
            Intent i = new Intent(this, Ask.class);// clicking on button and intenting to page
            startActivity(i);
        }
        if (v==btread){
            Intent i = new Intent(this, Fileread.class);// clicking on button and intenting to page
            startActivity(i);
        }
        if (v==btfitness){
            Intent i = new Intent(this, Fitness.class);// clicking on button and intenting to page
            startActivity(i);
        }
        if (v==btsex){
            Intent i = new Intent(this, Sexuality.class);// clicking on button and intenting to page
            startActivity(i);
        }



    }

    /**
     * on each item clicked the page intents to the items url as described
     * @param parent
     * @param view
     * @param position is where the user has touched or clicked
     * @param id
     * @return onItemLongClick return true or false
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/your-online-secrets/201709/can-ai-detect-sexual-orientation-photos"));
            startActivity(browserIntent); //listview with the adds that intent to browser on long click
        }
        if (position == 1) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/the-mindful-self-express/201709/feeling-lonely-you-may-be-damaging-your-health"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click


        if (position == 2) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.simplypsychology.org/whatispsychology.html"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click

        if (position == 3) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/get-out-your-mind/201802/6-signs-you-don-t-know-what-matters"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 4) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/get-out-your-mind/201802/how-take-action-when-you-don-t-wanna"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 5) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/school-and-family-matters/201802/talking-teens-about-stis"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 6) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/experimentations/201802/11-reasons-women-have-difficulty-orgasm-and-what-helps"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 7) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/insight-therapy/201802/the-wisdom-defense-mechanisms"));
        } //listview with the adds that intent to browser on long click






        return false;
    }

    /**
     * on clicking baCK PRESS, an alert duialog is shown whether to stay or exit
     */
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("No Why? Stay:(")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Home.this.finish();
                    }
                })
                .setNegativeButton("Okay", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private NotificationCompat.Builder builder;
    private Button btnNotify;



    }


