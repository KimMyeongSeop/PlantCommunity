package org.androidtown.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by MS on 2017-01-18.
 */
public class Signupinfo extends AppCompatActivity {

    ImageButton next;
    ImageButton back;
    Button sign_up_pic;
    Button save_name;
    String name;
    ImageView user;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.sign_up_info);

        next=(ImageButton)findViewById(R.id.imageButton5);
        back=(ImageButton)findViewById(R.id.imageButton4);
        sign_up_pic=(Button)findViewById(R.id.button5);
        save_name=(Button)findViewById(R.id.button6);
        user=(ImageView)findViewById(R.id.userimage);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Resister_rpi.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        sign_up_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signupinfo.this,Register_pic.class);
                startActivityForResult(intent,0);
            }
        });

        save_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 0:
                Intent intent=getIntent();
                Bitmap im = (Bitmap)intent.getParcelableExtra("image");
                user.setImageBitmap(im);
                break;
        }
    }
}
