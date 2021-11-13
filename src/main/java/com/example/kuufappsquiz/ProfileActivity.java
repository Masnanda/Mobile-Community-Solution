package com.example.kuufappsquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    TextView Wallet;
    RadioButton Pertama,Kedua,Ketiga;
    Button Confirm;


    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_kuuf,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=null;
        switch (item.getItemId()) {
            case R.id.Menu_Home :
                Toast.makeText(getApplicationContext(), "Home!",Toast.LENGTH_SHORT).show();
                intent= new Intent(ProfileActivity.this,HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.Menu_Store :
                Toast.makeText(getApplicationContext(), "Store!",Toast.LENGTH_SHORT).show();
                intent= new Intent(ProfileActivity.this,StoreActivity.class);
                startActivity(intent);
                break;

            case R.id.Menu_Profile :
                Toast.makeText(getApplicationContext(), "Profile!",Toast.LENGTH_SHORT).show();
                intent= new Intent(ProfileActivity.this,ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.Menu_LogOut :
                Toast.makeText(getApplicationContext(), "LogOut!",Toast.LENGTH_SHORT).show();
                intent= new Intent(ProfileActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Wallet=findViewById(R.id.Uang);
        Pertama=findViewById(R.id.Pertama);
        Kedua=findViewById(R.id.Kedua);
        Ketiga=findViewById(R.id.Ketiga);
        Confirm=findViewById(R.id.Confirm);
        Confirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(ProfileActivity.this);
                View view=getLayoutInflater().inflate(R.layout.password,null);
                Confirm =view.findViewById(R.id.Confirm);
                builder.setView(view);
                builder.setTitle("Password");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), " Validate Success!",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancell", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), " Validate Cancell!",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create();
                builder.show();
            }
        });

    }
}