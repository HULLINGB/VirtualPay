package com.wallet.brad.virtualpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


//Just enter one card then press the finish button

public class AddAccountAndRoutingNumber extends Activity{


    EditText mAccountNumber, mRouting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_account_and_routing_number);

        final DatabaseOpenHelper4 myDb;
        myDb = new DatabaseOpenHelper4(this);
        try{

            Button mEnter, mFinish, mScan, mScanBarcode, mBack;

            mEnter = (Button) findViewById(R.id.enter);
            mBack = (Button) findViewById(R.id.backbutton);

            final Intent intent6 = new Intent(AddAccountAndRoutingNumber.this, MainActivity.class);
            intent6.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent6.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


            mAccountNumber = (EditText) findViewById(R.id.entercard);
            mRouting = (EditText) findViewById(R.id.enterexpiration);


            mEnter = (Button) findViewById(R.id.enter);
            mFinish = (Button) findViewById(R.id.finish);
            //mScan = (Button) findViewById(R.id.ScanQR);
            //mScanBarcode = (Button) findViewById(R.id.ScanBarcode);
            LayoutInflater inflater = getLayoutInflater();


            Context context = getApplicationContext();
            CharSequence text = "Please enter the account number";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();




            mAccountNumber.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;

                    return handled;

                }
            });


            mRouting.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    boolean handled = false;

                    return handled;

                }
            });


            mEnter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{

                        //String name= MainActivity.firstName + " " + MainActivity.middleInitial + " " + MainActivity.lastName;
                        String accNum = mAccountNumber.getText().toString();
                        String routing = mRouting.getText().toString();
                        String result = accNum + routing;

                        myDb.insertData2(result);

                        myDb.close();

                    }catch(Exception e)
                    {

                    }

                    Intent intent = new Intent(getApplicationContext(), AddAccountAndRoutingNumber.class);
                    intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                    startActivity(intent);
                    //finish();
                    //return;


                }
            });

            mFinish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //QR Code generator
                    //QRGEncoder qrgEncoder = new QRGEncoder(inputValue, null, QRGContents.Type.TEXT, smallerDimension);

                    try{

                        //String name= MainActivity.firstName + " " + MainActivity.middleInitial + " " + MainActivity.lastName;
                        String accNum = mAccountNumber.getText().toString();
                        String routing = mRouting.getText().toString();
                        String result = accNum + routing;

                        myDb.insertData2(result);

                        myDb.close();

                    }catch(Exception e)
                    {

                    }

                    final Intent intent = new Intent(getApplicationContext(), Menu.class);
                    intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setAction(Intent.ACTION_SEND);

                    startActivity(intent);
                    //finish();
                    //return;



                }
            });



/**
            mScan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Intent intent = new Intent(getApplicationContext(), QRScan.class);
                    intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setAction(Intent.ACTION_SEND);




                    startActivity(intent);

                }
        });

            mScanBarcode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), BarcodeScan3.class);
                    intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent.setAction(Intent.ACTION_SEND);




                    startActivity(intent);

                }
            });
**/
            mBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    startActivity(intent6);

                }
            });






/**
 mBack.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
final Intent intent2 = new Intent(getApplicationContext(), Menu.class);

intent2.setAction(Intent.ACTION_SEND);

startActivity(intent2);
//finish();
//return;
}

});

 **/



        }catch(Exception e)
        {


        }





        }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                final DatabaseOpenHelper4 myDb;
                myDb = new DatabaseOpenHelper4(this);
                String contents = data.getStringExtra("SCAN_RESULT");
                String fakeCard = contents;
                char[] fullNumber = fakeCard.toCharArray();
                char[] card = new char[16];

                int j = 0;
                for(int i = 0; i < 16; i++)
                {
                        card[i] = fullNumber[j];
                        j++;
                }
                char[] exp = new char[4];

                for(int i = 0; i < 16; i++)
                {
                    exp[i] = fullNumber[j];

                }
                char[] cvv = new char[3];
                for(int i = 0; i < 16; i++)
                {
                    cvv[i] = fullNumber[j];

                }
                j = 0;
                String cardNumber = "";
                String expiration = "";
                String cvvNumber = "";


                for(int i = 0; i < 16; i++)
                {
                    cardNumber = cardNumber + card[j];
                    j++;
                }
                for(int i = 0; i < 4; i++)
                {
                    expiration = expiration + card[j];
                    j++;
                }
                for(int i = 0; i < 3; i++)
                {
                    cvvNumber = cvvNumber + card[j];
                    j++;
                }

                myDb.insertData(cardNumber, expiration, cvvNumber);
                myDb.close();
            }
            if(resultCode == RESULT_CANCELED){
                //handle cancel
            }
        }
    }



        public void scanCode()
        {
            try {

                Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes

                startActivityForResult(intent, 0);

            } catch (Exception e) {

                Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
                Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
                startActivity(marketIntent);

            }
        }

    }





/**
 public void setCVV(String entry)
 {
 CVVNumber = entry;

 }


 public void setFinalCreditCardNumber(String number)
 {
 finalCreditCardNumber = number;
 }
 **/



