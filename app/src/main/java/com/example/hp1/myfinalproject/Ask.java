package com.example.hp1.myfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ask extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemLongClickListener {
    Button btadd,btclear;
    EditText et1;
    ListView mails;
    ArrayList<String> emails = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        /**
         * setting up the buttons and defining the listviews and adapters
         */
        btadd=(Button)findViewById(R.id.bt1);
        btclear=(Button)findViewById(R.id.bt2);
        mails=(ListView)findViewById(R.id.emails);
        et1=(EditText)findViewById(R.id.EMail);
        btadd.setOnClickListener(this);
        btclear.setOnClickListener(this);
        emails.add("How To Get A girlFriend?");// a question just for the space not to be empty
        emails.add("Is My Mind Big?");// a question just for the space not to be empty
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, emails);
        mails.setAdapter(adapter);
        mails.setOnItemLongClickListener(this);
    }

    /**
     * adss questions
     * @param v
     */
    @Override
    public void onClick(View v) {

        if(v==btadd){
            if(et1.getText().toString().isEmpty())// adding a question
                Toast.makeText(this,"Field is empty",Toast.LENGTH_LONG).show();// if the text is empty show toast

            else{
                emails.add(et1.getText().toString());
                adapter.notifyDataSetChanged();// notifies the data
            }
        }
        if(v==btclear){
            et1.setText("");// erases whats written
        }
    }

    /**
     * here this sends the email that was chosen to be sent to regarding the question
     * @param parent
     * @param view
     * @param position
     * @param id
     * @return
     */
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent email = new Intent(Intent.ACTION_SEND);

        email.putExtra(Intent.EXTRA_EMAIL, new String[]{emails.get(position).toString()});
        email.putExtra(Intent.EXTRA_SUBJECT,"Question from SelfHelp" );
        email.putExtra(Intent.EXTRA_TEXT,emails.get(position).toString());
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));//choosing an email to send to
        return false;
    }


}
