package com.example.kuufappsquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StoreActivity extends AppCompatActivity {

    RecyclerView rv_Storeitems;
    Button Select;

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
                intent= new Intent(StoreActivity.this,HomeActivity.class);
                startActivity(intent);
                break;

            case R.id.Menu_Store :
                Toast.makeText(getApplicationContext(), "Store!",Toast.LENGTH_SHORT).show();
                intent= new Intent(StoreActivity.this,StoreActivity.class);
                startActivity(intent);
                break;

            case R.id.Menu_Profile :
                Toast.makeText(getApplicationContext(), "Profile!",Toast.LENGTH_SHORT).show();
                intent= new Intent(StoreActivity.this,ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.Menu_LogOut :
                Toast.makeText(getApplicationContext(), "LogOut!",Toast.LENGTH_SHORT).show();
                intent= new Intent(StoreActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        rv_Storeitems = findViewById(R.id.rv_Storeitem);

        String[] Name = {"Exploding Kitten","Card Against Humanity","Chess","Monopoli"};
        String[] Min = {"2","2","2","2"};
        String[] Max = {"5","4","2","4"};
        int[]   Price = {250000,182500,50000,10000};

        //Adapter
        StoreAdapter Store_Adapter = new StoreAdapter();
        Store_Adapter.SetData(Name,Min,Max,Price);

        rv_Storeitems.setAdapter(Store_Adapter);
        rv_Storeitems.setLayoutManager(new LinearLayoutManager(this));



    }
}