package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by MS on 2017-01-29.
 */
public class Ranking extends AppCompatActivity{
    TextView first,second,third,forth,fifth,score1,score2,score3,score4,score5,date;
    Spinner menu_spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);

        first=(TextView)findViewById(R.id.first);
        second=(TextView)findViewById(R.id.second);
        third=(TextView)findViewById(R.id.third);
        forth=(TextView)findViewById(R.id.forth);
        fifth=(TextView)findViewById(R.id.fifth);
        score1=(TextView)findViewById(R.id.firstscore);
        score2=(TextView)findViewById(R.id.secscore);
        score3=(TextView)findViewById(R.id.thirdscore);
        score4=(TextView)findViewById(R.id.forthscore);
        score5=(TextView)findViewById(R.id.fifthscore);
        date=(TextView)findViewById(R.id.date);
        menu_spinner=(Spinner)findViewById(R.id.spinner4);

        final String[] str=getResources().getStringArray(R.array.menuArray3);
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
                        Intent intent=new Intent(Ranking.this,Myplant.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent2=new Intent(Ranking.this,Diary.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(Ranking.this,Setting.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
}
