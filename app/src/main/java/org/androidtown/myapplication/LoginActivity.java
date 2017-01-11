package org.androidtown.myapplication;

/**
 * Created by MS on 2017-01-11.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String email = editText.getText().toString();
                String pw = passward.getText().toString();
            }
        });
    }
}
