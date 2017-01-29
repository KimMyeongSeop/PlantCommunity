package org.androidtown.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by MS on 2017-01-29.
 */
public class Setting_info extends AppCompatActivity {

    ImageView user;
    EditText name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_info);

        user=(ImageView)findViewById(R.id.imageView_user);
        name=(EditText)findViewById(R.id.editText7);
    }

    public void click_bt(View view){
        switch (view.getId()){
            case R.id.imageButton16:
                finish();
                break;
            case R.id.resist_pic:
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
                break;
            case R.id.save_name:
                Toast.makeText(getApplicationContext(),"이름저장",Toast.LENGTH_SHORT).show();
                break;
            case R.id.save:

                Toast.makeText(getApplicationContext(),"저장되엇습니다",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
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
                Bitmap pic=(Bitmap) extras.get("data");
                user.setImageBitmap(pic);

                /**Intent intent=new Intent(Setting_info.this,Signupinfo.class);
                intent.putExtra("image",im);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);*/
                break;
            }
        }
    }
}
