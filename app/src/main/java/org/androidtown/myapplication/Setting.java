package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by MS on 2017-01-29.
 */
public class Setting extends AppCompatActivity {

    Button set_plant,set_user;
    Spinner menu_spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        set_plant=(Button)findViewById(R.id.bt_setplant);
        set_user=(Button)findViewById(R.id.bt_setuser);
        menu_spinner=(Spinner)findViewById(R.id.spinner5);

        final String[] str=getResources().getStringArray(R.array.menuArray4);
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
                        Intent intent=new Intent(Setting.this,Myplant.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent2=new Intent(Setting.this,Diary.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(Setting.this,Ranking.class);
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

    public void bt_set(View view){
        switch (view.getId()){
            case R.id.bt_setplant:
                Intent intent4=new Intent(Setting.this,Setting_Plant.class);
                startActivity(intent4);
                break;
            case R.id.bt_setuser:
                Intent intent5=new Intent(Setting.this,Setting_info.class);
                startActivity(intent5);
                break;
        }
    }
}
