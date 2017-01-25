package org.androidtown.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by MS on 2017-01-25.
 */
public class Click_a_date extends AppCompatActivity {

    TextView textView;
    Button submit,cancle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_a_date);

        submit=(Button)findViewById(R.id.button11);
        cancle=(Button)findViewById(R.id.button10);

        textView=(TextView)findViewById(R.id.textView25);
        Intent intent=getIntent();

        int year,month,date;
        year=intent.getIntExtra("year",1);
        month=intent.getIntExtra("month",1);
        date=intent.getIntExtra("date",1);
        //String text=intent.getStringExtra("date");
        //textView.setText(text);
        textView.setText(year+"년 "+month+"월 "+date+"일");
    }

    public void OnButtonClick(View view){
        switch (view.getId()){
            case R.id.button10:
                finish();
                break;
            case R.id.button11:
                Toast.makeText(getApplicationContext(),"저장",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
