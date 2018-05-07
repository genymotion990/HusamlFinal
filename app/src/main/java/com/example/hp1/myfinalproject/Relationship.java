package com.example.hp1.myfinalproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
/**
 * difining the listview and array adapter
 */
public class Relationship extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener {
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
        setContentView(R.layout.activity_relationship);
        newsfeed =(ListView) findViewById(R.id.lvNewsfeed);

        feed.add("11 Reasons Women Have Difficulty, and What Helps");  // discreption of the item in the listview
        feed.add("Do Happier Relationships Make for Better Health?"); // discreption of the item in the listview
        feed.add("Cycles of Intimacy");
        feed.add("5 Relationship Red Flags You Should Never Ignore");
        feed.add("Relationship Misconceptions");
        feed.add("Improve Your Relationship In Twenty Minutes!");
        feed.add("What Is the Smartest Move to Make on Valentines Day?");
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, feed);
        newsfeed.setAdapter(adapter);// setting the adapter to the listview
        newsfeed.setOnItemLongClickListener((AdapterView.OnItemLongClickListener) this);
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
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/experimentations/201802/11-reasons-women-have-difficulty-orgasm-and-what-helps"));
            startActivity(browserIntent); //listview with the adds that intent to browser on long click
        }
        if (position == 1) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/the-social-brain/201802/do-happier-relationships-make-better-health"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click


        if (position == 2) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/complicated-love/201802/cycles-intimacy"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 3) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/tech-support/201802/5-relationship-red-flags-you-should-never-ignore"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 4) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/finding-love-the-scientific-take/201802/relationship-misconceptions"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 5) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/quite-queerly/201802/improve-your-relationship-in-twenty-minutes"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click
        if (position == 6) {

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.psychologytoday.com/blog/slightly-blighty/201802/what-is-the-smartest-move-make-valentines-day"));
            startActivity(browserIntent);
        } //listview with the adds that intent to browser on long click

        return false;
    }
}
