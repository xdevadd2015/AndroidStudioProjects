package com.example.dltkl.myshare;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    EditText etext1, etext2;
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etext1 = (EditText)findViewById(R.id.etext1);
        etext2 = (EditText)findViewById(R.id.etext2);
        text3 = (TextView)findViewById(R.id.text3);
    }
    public void saveInfo(View v){
        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor she = sp.edit();
        she.putString("username", etext1.getText().toString());
        she.putString("password", etext2.getText().toString());
        she.apply();

        Toast.makeText(this, "Info Saved", Toast.LENGTH_LONG).show();
    }

    public void showInfo(View v){
        SharedPreferences sp = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sp.getString("username", "");
        String pass = sp.getString("password", "");
        text3.setText(name + " " + pass);
    }
}
