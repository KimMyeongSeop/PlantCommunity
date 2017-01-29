package org.androidtown.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MS on 2017-01-29.
 */
public class Setting_Plant extends AppCompatActivity {

    ImageButton back;
    EditText search;
    Button bt_search,plus,miners,save;
    TextView water_date;
    Spinner spinner_light,spinner_temp;
    int date=0;
    int light=0,tempurature=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_plant);

        back=(ImageButton) findViewById(R.id.imageButton15);
        search=(EditText)findViewById(R.id.editText_search);
        bt_search=(Button)findViewById(R.id.button12);
        plus=(Button)findViewById(R.id.bt_plus);
        miners=(Button)findViewById(R.id.bt_min);
        save=(Button)findViewById(R.id.button13);
        water_date=(TextView)findViewById(R.id.water_date);
        spinner_light=(Spinner)findViewById(R.id.spinner6);
        spinner_temp=(Spinner)findViewById(R.id.spinner7);

        String[] str=getResources().getStringArray(R.array.spinnerArray1);
        ArrayAdapter<String> adapter=new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item,str);
        spinner_light.setAdapter(adapter);

        String[] str2=getResources().getStringArray(R.array.spinnerArray2);
        ArrayAdapter<String> adapter2=new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item,str2);
        spinner_temp.setAdapter(adapter2);

        spinner_light.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id){
                // String po = Integer.toString(position); //자료형변환
                switch (position){
                    case 0:
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });

        spinner_temp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id){
                // String po = Integer.toString(position); //자료형변환
                switch (position){
                    case 0:
                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void click_bt(View view){
        switch (view.getId()){
            case R.id.button12:
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,search.getText().toString());
                startActivity(intent);
                break;
            case R.id.bt_plus:
                water_date.setText(String.valueOf(++date));
                break;
            case R.id.bt_min:
                if(date>0)
                    water_date.setText(String.valueOf(--date));
                break;
            case R.id.button13:

                Toast.makeText(getApplicationContext(),"저장되엇습니다",Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
