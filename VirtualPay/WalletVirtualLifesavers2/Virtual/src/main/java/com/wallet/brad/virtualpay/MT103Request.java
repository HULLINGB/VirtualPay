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


public class MT103Request extends Activity {

    public String payAmount = "";
    String accountChoice = "";
    int accountChoi = 0;
    String chosenAccount = "";
    private SQLiteDatabase mDB = null;
    private SimpleCursorAdapter mAdapter;
    private SQLiteDatabase mDB3 = null;
    private SimpleCursorAdapter mAdapter3;
    private SQLiteDatabase mDB2 = null;
    private SimpleCursorAdapter mAdapter2;

    //int accountChoice = 0;

    String paymentInfo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);


        final DatabaseOpenHelperChooseCard myDb;
        myDb = new DatabaseOpenHelperChooseCard(this);
        final DatabaseOpenHelper4 myDb2;
        myDb2 = new DatabaseOpenHelper4(this);
        final DatabaseOpenHelperTakePayment myDb3;
        myDb3 = new DatabaseOpenHelperTakePayment(this);



        try{
            mDB = myDb.getReadableDatabase();
            Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelperChooseCard.ACCOUNT_CHOICE + " FROM account_choice", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        accountChoice = c.getString(c.getColumnIndex("accountchoice"));

                    } while (c.moveToNext());
                }
                c.close();
                mDB2 = myDb2.getReadableDatabase();
                Cursor c2 = mDB2.rawQuery("SELECT " + DatabaseOpenHelper4.CARD_NUMBER + " FROM fake_info", null);

                if(accountChoice.equals("1"))
                {
                    accountChoi = 1;
                }
                if(accountChoice.equals("2"))
                {
                    accountChoi = 2;
                }
                if(accountChoice.equals("3"))
                {
                    accountChoi = 3;
                }
                if(accountChoice.equals("4"))
                {
                    accountChoi = 4;
                }
                if(accountChoice.equals("5"))
                {
                    accountChoi = 5;
                }
                if(accountChoice.equals("6"))
                {
                    accountChoi = 6;
                }
                if(accountChoice.equals("7"))
                {
                    accountChoi = 7;
                }
                if(accountChoice.equals("8"))
                {
                    accountChoi = 8;
                }
                if(accountChoice.equals("9"))
                {
                    accountChoi = 9;
                }
                if(accountChoice.equals("10"))
                {
                    accountChoi = 10;
                }


                if (c2 != null) {

                    c2.moveToPosition(accountChoi - 1);
                    chosenAccount = c2.getString(c2.getColumnIndex("fakenumber"));
                    c2.close();

                }
            }
                mDB3 = myDb3.getReadableDatabase();
                Cursor c3 = mDB3.rawQuery("SELECT " + DatabaseOpenHelperTakePayment.PAYMENT_INFO + " FROM accept_payment", null);

                if (c3 != null) {
                    if (c3.moveToFirst()) {
                        do {
                            paymentInfo = c3.getString(c3.getColumnIndex("acceptpayment"));

                        } while (c.moveToNext());
                    }
                    c.close();

                }

            }
        catch (Exception e) {


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

        String amount = "";
        String account = "";
        String routing = "";
        char[] infoArray = new char[25];
        infoArray = paymentInfo.toCharArray();
        int p = 0;

        for(int i = 0; i < 5; i++)
        {

            if(infoArray[i] == '.')
            {
                p++;
                for(int z = 0; z < 2; z++)
                {
                    amount = amount + infoArray[p];
                    p++;
                }
                break;
            }
            amount = amount + infoArray[p];
            p++;
        }

        for(int i = p; i < infoArray.length; i++)
        {
            if(infoArray[i] == '/')
            {
                p++;
                for(int y = p; y < infoArray.length; y++)
                {
                    routing = routing + infoArray[p];
                    p++;
                }
                break;

            }
            account = account + infoArray[p];
            p++;
        }



        String from = "";
        String text = "Transfer:  $"+ amount + "to account:   " + account + "  routing number:   " + routing;
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;


        Toast toast = Toast.makeText(context, text, duration);
        toast.show();



        String text2 = "";
        text2 = "To:  " + chosenAccount + "  (Still testing feature)";
        Context context2 = getApplicationContext();

        int duration2 = Toast.LENGTH_SHORT;


        Toast toast2 = Toast.makeText(context2, text2, duration2);
        toast2.show();


        //Plaid api
        /**
         BankTransferUser user = new BankTransferUser().legalName("First Last");
         BankTransferCreateRequest request = new BankTransferCreateRequest()
         .accessToken(accessToken)
         .idempotencyKey("random string")
         .accountId("BxBXxLj1m4HMXBm9WZZmCWVbPjX16EHwv99vp")
         .type("credit")
         .network("ach")
         .amount("1.00")
         .isoCurrencyCode("USD")
         .description("payment")
         .user(user)
         .achClass("ppd");
         Response<BankTransferCreateResponse> response = client()
         .bankTransferCreate(request)
         .execute();
         BankTransfer bankTransfer =
         response.body().getBankTransfer();

         **/


    }



    }


