package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //this button will start the guessing game
    private Button buttonStart;
    //these radio buttons will let you decide which range of numbers you are guessing
    private RadioButton radio2,radio3,radio4;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //this provides us with the items in our menu and what their functionality does
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.Inspiration:
                Toast.makeText(this, "YOU CAN DO IT, YOU'LL PICK THE RIGHT ONE!", Toast.LENGTH_LONG).show();
        }
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.buttonStart);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);
        radio4 = findViewById(R.id.radio4);

        //once the button is clicked, you will be moved onto the next screen base on which option you picked
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GameActivity.class);

                if (!radio2.isChecked() && !radio3.isChecked() && !radio4.isChecked())
                {
                    Snackbar.make(v,"Please select a number of digits",Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (radio2.isChecked())
                    {
                        intent.putExtra("two",true);
                    }
                    if (radio3.isChecked())
                    {
                        intent.putExtra("three",true);
                    }
                    if (radio4.isChecked())
                    {
                        intent.putExtra("four",true);
                    }
                    startActivity(intent);
                }
            }
        });
    }
}