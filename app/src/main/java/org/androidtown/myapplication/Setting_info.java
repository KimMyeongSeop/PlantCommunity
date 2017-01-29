package org.androidtown.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

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
                break;
            case R.id.resist_pic:
                break;
            case R.id.save_name:
                break;
            case R.id.save:
                break;
        }
    }
}
