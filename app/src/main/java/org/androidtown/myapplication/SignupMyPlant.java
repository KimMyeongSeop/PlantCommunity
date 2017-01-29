package org.androidtown.myapplication;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by MS on 2017-01-17.
 */
public class SignupMyPlant extends AppCompatActivity {

    int date;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.sign_up_plant);

        Spinner s1 = (Spinner)findViewById(R.id.spinner);
        Spinner s2 = (Spinner)findViewById(R.id.spinner2);
        Button Google=(Button)findViewById(R.id.button4);
        final ImageButton next=(ImageButton)findViewById(R.id.imageButton3);
        final Button add_date=(Button)findViewById(R.id.button9);
        final Button sub_date=(Button)findViewById(R.id.button7);
        final TextView day=(TextView)findViewById(R.id.textView7);
        final EditText search=(EditText)findViewById(R.id.editText4);
        date = 0;

        String[] str=getResources().getStringArray(R.array.spinnerArray1);
        ArrayAdapter<String> adapter=new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item,str);
        s1.setAdapter(adapter);

        String[] str2=getResources().getStringArray(R.array.spinnerArray2);
        ArrayAdapter<String> adapter2=new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_dropdown_item,str2);
        s2.setAdapter(adapter2);

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
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

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
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

        Google.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr"));
                //Toast.makeText(SignupMyPlant.this,"Googling",Toast.LENGTH_SHORT).show();
                //startActivity(intent);
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,search.getText().toString());
                startActivity(intent);
            }
        });

        add_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**add_date.setText(String.valueOf(++date));**/
                day.setText(String.valueOf(++date));
            }
        });

        sub_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(date>0)
                    day.setText(String.valueOf(--date));
                    /**sub_date.setText(String.valueOf(--date));**/
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),
                        Signupinfo.class);
                intent.putExtra("등록완료","등록완료");
                startActivityForResult(intent,1004);
            }
        });
    }
}
