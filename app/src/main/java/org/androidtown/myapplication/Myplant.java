package org.androidtown.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by MS on 2017-01-21.
 */

public class Myplant extends AppCompatActivity{
    Spinner menu_spinner;
    TextView per1;
    TextView per2;
    TextView per3;
    TextView username;
    TextView speech;
    TextView score;
    ImageView user;
    ImageButton home;
    ProgressBar progressBar1;
    ProgressBar progressBar2;
    ProgressBar progressBar3;
    int num=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myplant);

        menu_spinner=(Spinner)findViewById(R.id.menu);
        per1=(TextView) findViewById(R.id.textView17);
        per2=(TextView)findViewById(R.id.textView18);
        per3=(TextView)findViewById(R.id.textView19);
        username=(TextView)findViewById(R.id.user_name);
        speech=(TextView)findViewById(R.id.textView13);
        score=(TextView)findViewById(R.id.score);
        user=(ImageView)findViewById(R.id.user);
        home=(ImageButton)findViewById(R.id.imageButton11);
        progressBar1=(ProgressBar)findViewById(R.id.progressBar);
        progressBar2=(ProgressBar)findViewById(R.id.progressBar2);
        progressBar3=(ProgressBar)findViewById(R.id.progressBar3);

        final String[] str=getResources().getStringArray(R.array.menuArray);
        ArrayAdapter<String> adapter=new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item,str);
        menu_spinner.setAdapter(adapter);



        menu_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id){
                // String po = Integer.toString(position); //자료형변환
                switch (position){
                    case 0:
                        break;
                    case 1:
                        Intent intent=new Intent(Myplant.this,Diary.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent2=new Intent(Myplant.this,Ranking.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(Myplant.this,Setting.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = num+5;
                progressBar1.incrementProgressBy(5);
                progressBar2.incrementProgressBy(10);
                per1.setText(String.valueOf(num));
                if(num<=30)
                    progressBar1.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
                else if(num>30&&num<=60)
                    progressBar1.getProgressDrawable().setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_IN);
                else
                    progressBar1.getProgressDrawable().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);

                if(num==100) {
                    progressBar1.incrementProgressBy(-100);
                    num=0;
                }
            }
        });
    }


}
