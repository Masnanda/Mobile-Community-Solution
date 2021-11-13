package com.example.kuufappsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Loginbtn, BtnRegister;
    EditText Usernametxt, Passwordtxt;
    String Usernamepass;
    String Passwordpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Usernamepass="Admin";
        Passwordpass="Admin";
        setContentView(R.layout.activity_main);
        Usernametxt=findViewById(R.id.Usernametxt);
        Passwordtxt=findViewById(R.id.Passwordtxt);
        Loginbtn=findViewById(R.id.Btn_Login);
        Loginbtn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                if (Usernametxt.getText().toString().equals("") ){
                    Toast.makeText(getApplicationContext(), " Username must be Filled",Toast.LENGTH_SHORT).show();
                }
                else if (Passwordtxt.getText().toString().equals("") ) {
                    Toast.makeText(getApplicationContext(), " Password must be Filled",Toast.LENGTH_SHORT).show();
                }
                else if (!Usernametxt.getText().toString().equals(Usernamepass)){
                    Toast.makeText(getApplicationContext(), " Username Wrong!",Toast.LENGTH_SHORT).show();
                }
                else if (!Passwordtxt.getText().toString().equals(Passwordpass)){
                        Toast.makeText(getApplicationContext(), " Password Wrong!",Toast.LENGTH_SHORT).show();
                    }
                if ((Usernametxt.getText().toString().equals(Usernamepass))&&((Passwordtxt.getText().toString().equals(Passwordpass)))) {
                    Toast.makeText(getApplicationContext(), " Login Successfull",Toast.LENGTH_SHORT).show();
                    Intent GoHome = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(GoHome);
                }
            }
        });

        BtnRegister=findViewById(R.id.BtnRegister);
        BtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });
    }
}