package org.androidtown.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by MS on 2017-01-21.
 */
public class Myplant extends AppCompatActivity{
    Spinner menu_spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myplant);

        menu_spinner=(Spinner)findViewById(R.id.menu);

        String[] str3=getResources().getStringArray(R.array.menuArray);
        ArrayAdapter<String> adapter=new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item,str3);
        menu_spinner.setAdapter(adapter);

        menu_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id){
                /**tv.setText("position : " + position + parent.getItemAtPosition(position));*/
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
}
