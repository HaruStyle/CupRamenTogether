package org.togther.cupramentogether;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    String PhoneNum = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TelephonyManager telManager = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        try{
            PhoneNum = telManager.getLine1Number();
            PhoneNum = PhoneNum.replace("+82","0");
        }catch (Exception e){PhoneNum = "010-4321-1234";}

        final TextView login_id = (TextView)findViewById(R.id.login_id);
        login_id.setText(PhoneNum.toString());

        Button b = (Button)findViewById(R.id.btn_login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        MainActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent); // 다음 화면으로 넘어간다
            }
        });

    }
}
