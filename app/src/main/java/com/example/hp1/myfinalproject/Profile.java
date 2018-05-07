package com.example.hp1.myfinalproject;

        import android.content.SharedPreferences;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView tvname, tvemail ;
    ImageView imageView;
    private Bitmap bitmap;

    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        tvname = (TextView)findViewById(R.id.tvname);
        tvemail = (TextView)findViewById(R.id.tvemail);
        imageView = (ImageView)findViewById(R.id.ivprofile);


        pref = getSharedPreferences("mypref",MODE_PRIVATE);// thats where the files are being saved

        String image=pref.getString("image",null);
        String name=pref.getString("name",null);
        String email=pref.getString("email",null);
        tvname.setText(name);
        tvemail.setText(email);

        if(image != null){
            bitmap = BitmapFactory.decodeFile(image);//thats where the code file is saved of the image
            imageView.setImageBitmap(bitmap);
        }

    }
}
