package com.example.dltkl.mysqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText etext = (EditText)findViewById(R.id.etext);
    Button abutton = (Button)findViewById(R.id.abutton);
    Button dbutton = (Button)findViewById(R.id.dbutton);
    MyDBHandler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h = new MyDBHandler(this,null,null,1);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = h.databaseToString();
        TextView vtext = (TextView)findViewById(R.id.vtext);
        vtext.setText(dbString);
        etext.setText("");
    }

    public void addButton(View v){
        Products p = new Products(etext.getText().toString());
        h.addProduct(p);
        printDatabase();
    }

    public void deleteButton(View v){
        h.deleteProduct(etext.getText().toString());
        printDatabase();
    }
}

