package com.wallet.brad.virtualpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class EnterFirstAndLastName extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_first_and_last_name);




            final EditText mFirstName, mLastName;
            final Button mEnter, mBack;


            mBack = (Button) findViewById(R.id.backbutton);

            final Intent intent6 = new Intent(EnterFirstAndLastName.this, MainActivity.class);
            intent6.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent6.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

            mFirstName = (EditText) findViewById(R.id.firstname);
            mLastName = (EditText) findViewById(R.id.lastname);

            mEnter = (Button) findViewById(R.id.enter);


            LayoutInflater inflater = getLayoutInflater();


            /**
             Enter user first and last name
             **/
            Context context = getApplicationContext();
            CharSequence text = "Please enter your first and last name";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


            mFirstName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;

                    return handled;

                }
            });

            mLastName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;

                    return handled;

                }
            });

            mEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String fName = mFirstName.getText().toString();
                    String lName = mLastName.getText().toString();

                    MainActivity.firstName = fName;
                    MainActivity.lastName = lName;

                    Intent intent = new Intent(getApplicationContext(), EnterMiddleInitial.class);
                    intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    startActivity(intent);
                    //finish();
                    //return;


                }
            });

            mBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    startActivity(intent6);

                }
            });




    }

}


