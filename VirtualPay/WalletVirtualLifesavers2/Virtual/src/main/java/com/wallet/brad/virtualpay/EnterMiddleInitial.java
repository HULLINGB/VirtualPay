package com.wallet.brad.virtualpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterMiddleInitial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_middle_initial);

        /**
         Enter user card number
         **/

        try {

            final EditText mMiddleInitial;
            Button mEnter, mBack;
            String expirationDate;

            mMiddleInitial = (EditText) findViewById(R.id.entermiddle);

            mEnter = (Button) findViewById(R.id.enter);

            mBack = (Button) findViewById(R.id.backbutton);

            final Intent intent6 = new Intent(EnterMiddleInitial.this, MainActivity.class);
            intent6.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent6.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


            Context context = getApplicationContext();
            CharSequence text = "Please enter your middle initial";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


            mMiddleInitial.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        handled = true;
                        Log.v("EditText", mMiddleInitial.getText().toString());
                    }
                    return handled;
                }

            });

            mEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String midInitial = mMiddleInitial.getText().toString();
                    //MainActivity.middleInitial = midInitial;

                    Intent intent = new Intent(getApplicationContext(), AddAccountAndRoutingNumber.class);

                    startActivity(intent);


                }
            });

            mBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    startActivity(intent6);

                }
            });

        }catch(Exception e)
        {



        }


    }



}

