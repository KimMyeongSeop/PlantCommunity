package org.androidtown.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by MS on 2017-01-11.
 */
public class SignupActivity extends AppCompatActivity {

    Button sign_up;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        back = (ImageButton)findViewById(R.id.back);
        sign_up=(Button)findViewById(R.id.button3);

        sign_up.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),
                        "등록되었습니다.",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),
                        "뒤로 버튼이 눌렸어요.",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
