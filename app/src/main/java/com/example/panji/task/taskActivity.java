package com.example.panji.task;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class taskActivity extends AppCompatActivity {

    Button one, two, three, four, five, six, seven, eight, nine;
    FloatingActionButton fab_balance, fab_dell, fab_clear;
    TextView tx_balance;
    EditText edit_income, edit_outcome;
    boolean focus_incom = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        tx_balance = (TextView) findViewById(R.id.text_balance);
        edit_income = (EditText) findViewById(R.id.text_income);
        edit_income.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    focus_incom  = true;
                }
            }



        });

        edit_outcome = (EditText) findViewById(R.id.text_outcome);
        edit_outcome.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    focus_incom  = false;
                }
            }

        });

        fab_balance = (FloatingActionButton) findViewById(R.id.fab_balance);
        fab_balance.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                try {
                    int in, out, balance;
                    in = Integer.parseInt(edit_income.getText().toString().trim());
                    out = Integer.parseInt(edit_outcome.getText().toString().trim());
                    balance = in - out;
                    tx_balance.setText("Balance :" + balance);

                }catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(), "Silahkan Periksa Inputan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fab_dell = (FloatingActionButton) findViewById(R.id.fab_delete);
        fab_dell.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (focus_incom==false){
                    int lenght = edit_income.getText().length();
                    if(lenght > 0){
                        edit_income.getText().delete(lenght -1, lenght);
                    }
                }

                else {
                    int lenght = edit_outcome.getText().length();
                    if(lenght > 0){
                        edit_outcome.getText().delete(lenght -1, lenght);
                    }
                }
            }
        });

        fab_clear = (FloatingActionButton) findViewById(R.id.fab_clear);
        fab_clear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                    edit_income.setText("");
                    edit_outcome.setText("");
                    tx_balance.setText("");


            }
        });



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    String dump;

    public void press(View v) {
        switch (v.getId()) {
            case R.id.button_one:
                dump = "1";
                break;
            case R.id.button_two:
                dump = "2";
                break;
            case R.id.button_three:
                dump = "3";
                break;
            case R.id.button_four:
                dump = "4";
                break;
            case R.id.button_five:
                dump = "5";
                break;
            case R.id.button_six:
                dump = "6";
                break;
            case R.id.button_seven:
                dump = "7";
                break;
            case R.id.button_eight:
                dump = "8";
                break;
            case R.id.button_nine:
                dump = "9";
                break;
            default:
                break;
        }

        if (focus_incom == false) {
            edit_income.setText(edit_income.getText().toString() + dump);
        } else {
            edit_outcome.setText(edit_outcome.getText().toString() + dump);
        }

    }

}
