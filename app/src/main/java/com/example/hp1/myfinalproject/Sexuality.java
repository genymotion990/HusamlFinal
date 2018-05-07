package com.example.hp1.myfinalproject;

import android.content.Intent;
import android.graphics.Color;
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
public class Sexuality extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener {
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
        setContentView(R.layout.activity_sexuality);

        newsfeed =(ListView) findViewById(R.id.lvNewsfeed);

        feed.add("What Do Singles Really Want?"); // discreption of the item in the listview
        feed.add("Can AI Detect Sexual Orientation from Photos?");  // discreption of the item in the listview
        feed.add("The Vicious Sex and Affection Cycle");
        feed.add("The Sexual Secrets Women Keep, Even From Themselves");
        feed.add("Asexuality Is a Lifelong Lack of Sexual Attraction");
        feed.add("When Is Porn Use a Problem?");
        feed.add("What Can a Man’s Finger Size Tell you About His Sex Appeal?");
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
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/your-online-secrets/201709/can-ai-detect-sexual-orientation-photos"));
            startActivity(browserIntent); //listview with the adds that intent to browser on long click
        }
        if (position == 1) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/in-the-name-love/201802/what-do-singles-really-want"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click


        if (position == 2) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/experimentations/201802/when-is-porn-use-problem"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 3) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/fulfillment-any-age/201802/what-can-man-s-finger-size-tell-you-about-his-sex-appeal"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 4) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/the-two-shall-become-one/201801/the-vicious-sex-and-affection-cycle"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 5) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/dating-and-mating/201801/the-sexual-secrets-women-keep-even-themselves"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 6) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/first-blush/201801/asexuality-is-lifelong-lack-sexual-attraction"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        return false;
    }
}
