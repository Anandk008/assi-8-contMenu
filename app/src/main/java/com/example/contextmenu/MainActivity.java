package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView mListview;
    private String[] contacts = { "Shashikant", "Pratham", "Anand", "Sarthak", "Adwait"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListview = findViewById(R.id.ListviewD);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, contacts
        );
        mListview.setAdapter(adapter);
        registerForContextMenu(mListview);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context, menu);
        menu.setHeaderTitle("Select Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if( item.getItemId() == R.id.call ){
            Toast.makeText(this, "Call Selected",Toast.LENGTH_SHORT).show();
            return true;
        }
        else if( item.getItemId() == R.id.SMS){
            Toast.makeText(this, "SMS Selected", Toast.LENGTH_SHORT).show();

        }
        else { return false;}
        return true;
    }
}