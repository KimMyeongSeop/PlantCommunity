package org.androidtown.myapplication;

/**
 * Created by MS on 2017-01-11.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText pw;
    Button login;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        email = (EditText)findViewById(R.id.editText);
        pw = (EditText)findViewById(R.id.passward);
        login = (Button)findViewById(R.id.button3);
        back = (ImageButton)findViewById(R.id.back);

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),
                        "로그인 버튼이 눌렸어요.",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.putExtra("email","naver");

                setResult(RESULT_OK,intent);

                finish();
            }

        });

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
    }


}
