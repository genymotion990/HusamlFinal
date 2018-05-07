package com.example.hp1.myfinalproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * difining the listview and array adapter
 */
public class Fitness extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener {
    ListView newsfeed;
    ArrayList<String> feed = new ArrayList<>();
    ArrayAdapter<String> adapter;

    /**
     * here i added articles for the app
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);
        newsfeed =(ListView) findViewById(R.id.lvNewsfeed);
        feed.add("The Body Language of Victory");  // discreption of the item in the listview
        feed.add("Feeling Lonely? You May Be Damaging Your Health"); // discreption of the item in the listview
        feed.add("The Emotionally Healthy Athlete");
        feed.add("Healthy Body and a Sound Mind?");
        feed.add("19 Reasons to Exercise");
        feed.add("Better Sleep Found by Exercising on a Regular Basis\n");
        feed.add("Food Addict or Diet Junkie?");

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, feed);
        newsfeed.setAdapter(adapter);// setting the adapter to the listview
        newsfeed.setOnItemLongClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * determined to the article the postition to intent to browser by URL
     * @param parent
     * @param view
     * @param position
     * @param id
     * @return
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/the-athletes-way/201401/the-body-language-victory"));
            startActivity(browserIntent); //listview with the adds that intent to browser on long click
        }
        if (position == 1) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/the-mindful-self-express/201709/feeling-lonely-you-may-be-damaging-your-health"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click


        if (position == 2) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/the-intelligent-divorce/201402/the-emotionally-healthy-athlete"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 3) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/smart-moves/201407/healthy-body-and-sound-mind"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 4) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/fulfillment-any-age/201205/19-reasons-exercise"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 5) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/sleep-newzzz/201309/better-sleep-found-exercising-regular-basis-0"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 6) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/eating-mindfully/201406/food-addict-or-diet-junkie"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        return false;
    }
    }

