package com.wallet.brad.virtualpay;

import android.content.Context;
import android.net.wifi.WifiManager;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import android.graphics.Point;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Random;


public class MT103Request10 extends Activity {

    public static String chosenCard = "";
    public static String IPAddress1;
    public static String IPAddress2;

    boolean validNumber;


    //covert to string to we can get length for the loop
    Random number = new Random();


    private SQLiteDatabase mDB = null;
    private SimpleCursorAdapter mAdapter;
    private SQLiteDatabase mDB2 = null;
    private SimpleCursorAdapter mAdapter2;
    String finalQRPattern = "";

    public String fullCreditCardNumber;
    public String mobileCreditCardNumber;
    public String mobileIPAddress = "";
    public String mobileIPAdress2;

    String paymentInfo = "";



    String dollarAmount = "";
    String[] dollarAmountArray = new String[10];

    String account = "";
    String[] accountArray = new String[20];

    String routing = "";
    String[] routingArray = new String[20];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);

        final DatabaseOpenHelper13 myDb;
        myDb = new DatabaseOpenHelper13(this);

        final DatabaseOpenHelperTakePayment myDb2;
        myDb2 = new DatabaseOpenHelperTakePayment(this);

        try {
            mDB = myDb.getReadableDatabase();


            validNumber = true;
            int j = 0;

            Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper13.CARD_NUMBER + " FROM fake_info10", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        chosenCard = c.getString(c.getColumnIndex("fakenumber"));

                    } while (c.moveToNext());
                }
                c.close();




            }




        }catch(Exception e)
        {


        }



        try {
            mDB2 = myDb2.getReadableDatabase();


            validNumber = true;
            int j = 0;

            Cursor c = mDB2.rawQuery("SELECT " + DatabaseOpenHelperTakePayment.PAYMENT_INFO + " FROM accept_payment", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        paymentInfo = c.getString(c.getColumnIndex("acceptpayment"));

                    } while (c.moveToNext());
                }
                c.close();


            }


        } catch (Exception e) {


        }

        // Creating array of string length
        char[] ch = new char[paymentInfo.length()];
        // Copy character by character into array
        for (int i = 0; i < paymentInfo.length(); i++) {
            ch[i] = paymentInfo.charAt(i);
        }

        //get dollar amount, account, routing from the ch
        //send the MT101 Request to fedwire

//Display contents of Qr and your account
        String text = "";
        text = "Transfer from:" + paymentInfo;
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;


        Toast toast = Toast.makeText(context, text, duration);
        toast.show();



        String text2 = "";
        text2 = "To:  " + chosenCard + "  (Still testing feature)";
        Context context2 = getApplicationContext();

        int duration2 = Toast.LENGTH_SHORT;


        Toast toast2 = Toast.makeText(context2, text2, duration2);
        toast2.show();











    }



    public void getLocalIpAddress() {


    }


    private void setSmartPhoneIPAddress() {


        //assuming we are using the wifi method


        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        IPAddress1 = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());


        //remove periods
        IPAddress2 = IPAddress1;
        IPAddress1 = IPAddress1.replace(".", "");
        fullCreditCardNumber = IPAddress1;
        int IPLength2 = IPAddress1.length();
        for (int i = IPLength2; i < 16; i++) {
            fullCreditCardNumber = fullCreditCardNumber + "0";

        }


    }

}
