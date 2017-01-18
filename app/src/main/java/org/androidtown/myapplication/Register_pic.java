package org.androidtown.myapplication;

/**
 * Created by MS on 2017-01-18.
 */
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Register_pic extends AppCompatActivity {

    ImageButton back;
    ImageButton Photo;
    ImageButton Gellery;
    ImageView iv=null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register_pic);

        back=(ImageButton)findViewById(R.id.imageButton6);
        Photo=(ImageButton)findViewById(R.id.imageButton8);
        Gellery=(ImageButton)findViewById(R.id.imageButton7);
        iv=(ImageView)findViewById(R.id.imageView7);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
            }
        });

        Gellery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            Bundle extras=data.getExtras();
            Bitmap im=(Bitmap) extras.get("data");
            iv.setImageBitmap(im);
    }
}
