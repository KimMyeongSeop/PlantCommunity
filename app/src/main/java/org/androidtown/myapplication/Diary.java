package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;

/**
 * Created by MS on 2017-01-24.
 */
public class Diary extends AppCompatActivity {
    CalendarView cal;
    Spinner menu_spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diary);

        cal = (CalendarView)findViewById(R.id.calendarView);
        menu_spinner=(Spinner)findViewById(R.id.spinner3);

        CalendarViewListener listener=new CalendarViewListener();
        cal.setOnDateChangeListener(listener);

        final String[] str=getResources().getStringArray(R.array.menuArray2);
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
                        Intent intent=new Intent(Diary.this,Myplant.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent2=new Intent(Diary.this,Ranking.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(Diary.this,Setting.class);
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

    class CalendarViewListener implements CalendarView.OnDateChangeListener{

        @Override
        public void onSelectedDayChange(CalendarView arg0, int arg1, int arg2, int arg3){
            // TODO Auto-generated method stub

            //String date = String.valueOf(arg1)+"년 "+String.valueOf(arg2+1)+" 월"+String.valueOf(arg3)+"일";

            Intent intent=new Intent(Diary.this,Click_a_date.class);
            intent.putExtra("year",arg1);
            intent.putExtra("month",arg2+1);
            intent.putExtra("date",arg3);
            startActivity(intent);
        }
    }
}
