package org.androidtown.myapplication;

/**
 * Created by MS on 2017-01-18.
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Register_pic extends AppCompatActivity {

    private Uri mImageCaptureUri;

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
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);

        if(resultCode != RESULT_OK)
            return;

        switch (requestCode) {
            case 1 :
            {
                Bundle extras=data.getExtras();
                Bitmap im=(Bitmap) extras.get("data");
                iv.setImageBitmap(im);

                Intent intent=new Intent(Register_pic.this,Signupinfo.class);
                intent.putExtra("image",im);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
            case 2:
            {
                mImageCaptureUri=data.getData();
                Log.d("smart",mImageCaptureUri.getPath().toString());
                iv.setImageURI(mImageCaptureUri);

                break;
            }
        }
    }
}
