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

public class HowMuchToPay2 extends Activity {

    DatabaseOpenHelperAmount db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_much_to_pay);


        final DatabaseOpenHelperAmount myDb;
        myDb = new DatabaseOpenHelperAmount(this);
        db = myDb;

        try {

            final EditText mAmount;
            Button mEnter, mBack;

            mAmount = (EditText) findViewById(R.id.amount);

            mEnter = (Button) findViewById(R.id.enter);

            mBack = (Button) findViewById(R.id.backbutton);

            final Intent intent6 = new Intent(HowMuchToPay2.this, Menu2.class);
            intent6.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent6.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


            Context context = getApplicationContext();
            CharSequence text = "Please enter the amount";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


            mAmount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        handled = true;
                        Log.v("EditText", mAmount.getText().toString());
                    }
                    return handled;
                }

            });

            mEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{




                        //String name= MainActivity.firstName + " " + MainActivity.middleInitial + " " + MainActivity.lastName;
                        String amount = mAmount.getText().toString();

                        String result = amount;

                        db.insertData2(result);

                        db.close();




                    }catch(Exception e)
                    {





                    }

                    Intent intent = new Intent(getApplicationContext(), PayQR2.class);
                    intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

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

        }catch(Exception e)
        {



        }


    }



}

