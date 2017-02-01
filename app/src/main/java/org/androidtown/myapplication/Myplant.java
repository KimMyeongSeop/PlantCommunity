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

    int temp=0;
    int light=0;
    int water=0;

    int set_temp=100;
    int set_light=100;
    int set_water=100;

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
                if(temp>=100)
                    temp=0;
                if(light>=100)
                    light=0;
                if(water>=100)
                    water=0;

                progressBar1.setProgress(100*temp/set_temp);
                progressBar2.setProgress(100*light/set_light);
                progressBar3.setProgress(100*water/set_water);

                per1.setText(String.valueOf(temp));
                per2.setText(String.valueOf(light));
                per3.setText(String.valueOf(water));

                if(temp<=50)
                    progressBar1.getProgressDrawable().setColorFilter(Color.rgb(230,76,60), PorterDuff.Mode.SRC_IN);
                else if(temp>50&&temp <=80)
                    progressBar1.getProgressDrawable().setColorFilter(Color.rgb(240,195,15), PorterDuff.Mode.SRC_IN);
                else
                    progressBar1.getProgressDrawable().setColorFilter(Color.rgb(46,203,113), PorterDuff.Mode.SRC_IN);

                if(light<=50)
                    progressBar2.getProgressDrawable().setColorFilter(Color.rgb(230,76,60), PorterDuff.Mode.SRC_IN);
                else if(light>50&&light<=80)
                    progressBar2.getProgressDrawable().setColorFilter(Color.rgb(240,195,15), PorterDuff.Mode.SRC_IN);
                else
                    progressBar2.getProgressDrawable().setColorFilter(Color.rgb(46,203,113), PorterDuff.Mode.SRC_IN);

                if(water<=50)
                    progressBar3.getProgressDrawable().setColorFilter(Color.rgb(230,76,60), PorterDuff.Mode.SRC_IN);
                else if(water>50&&water <=80)
                    progressBar3.getProgressDrawable().setColorFilter(Color.rgb(240,195,15), PorterDuff.Mode.SRC_IN);
                else
                    progressBar3.getProgressDrawable().setColorFilter(Color.rgb(46,203,113), PorterDuff.Mode.SRC_IN);


                if(water>=50&&temp>=50&&light>=50)
                    speech.setText("최적한 환경이에요");
                else if(water>=50&&temp>=50&&light<50)
                speech.setText("햇빛이 부족해요");
                else if(water>=50&&temp<50&&light>=50)
                    speech.setText("너무 추워요");
                else if(water>=50&&temp<50&&light<50)
                    speech.setText("춥고 어두워요");
                else if(water<50&&temp>=50&&light>=50)
                    speech.setText("목이 말라요");
                else if(water<50&&temp>=50&&light<50)
                    speech.setText("어둡고 목이말라요");
                else if(water<50&&temp<50&&light>=50)
                    speech.setText("춥고 목이말라요");
                else if(water<50&&temp<50&&light<50)
                    speech.setText("살기가 힘들어요");

                int SCORE = (100*temp/set_temp+100*light/set_light+100*water/set_water)/3;
                score.setText(String.valueOf(SCORE));

                temp+=5;
                light+=15;
                water+=30;
            }
        });
    }


}
