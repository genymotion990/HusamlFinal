package com.example.hp1.myfinalproject;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * this activity reads files and/or rewrites them for the developer
 */
public class Fileread extends AppCompatActivity implements View.OnClickListener {
    InputStream is = null;
    InputStreamReader in;
    BufferedReader br;

    public static final String outFile = "myfile.txt";
    FileOutputStream fos;
    DataOutputStream dos;
    String msg="my name is";
    int times=3;

    //C. in order to read from a hidden file
    FileInputStream fis=null;
    DataInputStream dis;

    //parameters for file reading used in both methods
    String temp="", all="";
    int num;

    Button bt1, bt2, bt3;
    TextView tv1, tv2;
    EditText et1;
    private ActionBar.Tab txtData;

    /**
     * defining the widgets
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fileread);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        et1 = (EditText) findViewById(R.id.et1);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        et1.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == bt1) {
            try {
                temp = "";
                all = "";
                //4. open the file for reading
                is = getResources().openRawResource(R.raw.fileread);
                //open a channel for file reading
                in = new InputStreamReader(is);
                br = new BufferedReader(in);
                //while end of file not reached
                //readline() reads one line at a time
                while ((temp = br.readLine()) != null)
                    all += temp + "\n";//concatinate all lines to a string
                tv2.setText(all);
                is.close();//file close
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(v==bt3){//writting to a hidden file
            try {
                Toast.makeText(getApplicationContext(), "writting to file", Toast.LENGTH_LONG).show();
                //open file for writing and permission to write only for this application
                fos=openFileOutput(outFile, Context.MODE_PRIVATE);
                //open a channel for file writting
                dos= new DataOutputStream(fos);
                //actual writing
                dos.writeUTF(et1.getText().toString()+"\n");

                //this is for the first option of reading
                //dos.writeInt(times);
                dos.close();
                fos.close();
            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(), "Couldn't open file for writting", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(), "Couldn't write to file", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }else{
            try {
                temp="";
                all="";
                fis=openFileInput(outFile);
                //first option for reading in the same order as writting
		/*		dis=new DataInputStream(fis);
				all=dis.readUTF();
				num=dis.readInt();
				text.setText(all+"\n"+num);
		*/
                //second option is reading all file in a loop
                in= new InputStreamReader(fis);
                br= new BufferedReader(in);
                //while end of file not reached
                //readline() reads one line at a time
                while((temp=br.readLine())!=null)
                    all+=temp+"\n";//concatinate all lines to a string
                tv2.setText(all);
                fis.close();//file close
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}



