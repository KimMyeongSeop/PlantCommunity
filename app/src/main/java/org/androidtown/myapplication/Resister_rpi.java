package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by MS on 2017-01-21.
 */
public class Resister_rpi extends AppCompatActivity {
    ImageButton next;
    ImageButton back;
    EditText enter_model;
    Button resist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_rpi);

        next=(ImageButton)findViewById(R.id.imageButton10);
        back=(ImageButton)findViewById(R.id.imageButton9);
        enter_model=(EditText)findViewById(R.id.modelnum);
        resist=(Button)findViewById(R.id.btn_resist);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Myplant.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
