package com.example.kuufappsquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.sql.Date;

import static android.text.TextUtils.isEmpty;

public class RegisterActivity extends AppCompatActivity {
    Button TombolRegister,Dateofbirth;
    EditText Usertxt,Numbertxt, Passtxt,CoPasstxt ;
    CheckBox Check;
    RadioGroup Gender;
    RadioButton Selected;
    DatePicker Picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Usertxt=findViewById(R.id.RegUser);
        Numbertxt=findViewById(R.id.RegNumber);
        Passtxt=findViewById(R.id.RegPass);
        CoPasstxt=findViewById(R.id.RegCoPass);
        TombolRegister=findViewById(R.id.Register);
        Check=findViewById(R.id.RegCheckBox);
        Gender=findViewById(R.id.RegRadioGroup);
        TombolRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Usertxt.getText().toString().equals("") ){
                    Usertxt.setError(Html.fromHtml("<font color='red'>Username must be filled</font>"));
                }
                else if (Numbertxt.getText().toString().equals("") ) {
                    Numbertxt.setError(Html.fromHtml("<font color='red'>Number must be filled</font>"));
                }
                else if (Passtxt.getText().toString().equals("") ) {
                    Passtxt.setError(Html.fromHtml("<font color='red'>Password must be filled</font>"));
                }
                else if(CoPasstxt.getText().toString().equals(""))
                {
                    CoPasstxt.setError(Html.fromHtml("<font color='red'>Confirm Password must be filled</font>"));
                }
                else if (!CoPasstxt.equals(Passtxt))
                {
                    CoPasstxt.setError(Html.fromHtml("<font color='red'>Password do not match!</font>"));
                }
                else if (Selected==null ) {
                    Toast.makeText(getApplicationContext(), " Gender must be selected!",Toast.LENGTH_SHORT).show();
                }
                else if (!Check.isChecked() ) {
                    Toast.makeText(getApplicationContext(), " Must Agreed Term and Condition Before Register!",Toast.LENGTH_SHORT).show();
                }
                else  {
                    Toast.makeText(getApplicationContext(), " Register Successfull",Toast.LENGTH_SHORT).show();
                    Intent Gologin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(Gologin);
                }
            }
        });
        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Selected=group.findViewById(checkedId);
            }
        });

        Dateofbirth=findViewById(R.id.RegDate);
        Dateofbirth.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                View view=getLayoutInflater().inflate(R.layout.date,null);
                Picker =view.findViewById(R.id.RegDate);
                builder.setView(view);
                builder.setTitle("Pick Date");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Cancell", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create();
                builder.show();

    }
}));
    }
}
