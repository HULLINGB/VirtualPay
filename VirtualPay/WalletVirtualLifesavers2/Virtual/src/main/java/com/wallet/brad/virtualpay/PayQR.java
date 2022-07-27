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


public class PayQR extends Activity {

    public String payAmount = "";
    String accountChoice = "";
    int accountChoi = 0;
    String chosenAccount = "";

    private int[] cardArray = new int[16];
    private char[] IPAddressArray = new char[11];

    boolean validNumber;
    ImageView mImageView;


    public final static int WHITE = 0xFFFFFFFF;
    public final static int BLACK = 0xFF000000;
    public final static int WIDTH = 400;
    public final static int HEIGHT = 400;

    public final static String STR = "A string to be encoded as QR code";
    //final DatabaseHelper DBHelper = new DatabaseHelper(getBaseContext());

    private SQLiteDatabase mDB = null;
    private SimpleCursorAdapter mAdapter;
    private SQLiteDatabase mDB2 = null;
    private SimpleCursorAdapter mAdapter2;
    private SQLiteDatabase mDB3 = null;
    private SimpleCursorAdapter mAdapter3;
    String finalQRPattern = "";

    public String fullCreditCardNumber;
    public static String IPAddress1;
    public static String IPAddress2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);

        final DatabaseOpenHelperChooseCard myDb;
        myDb = new DatabaseOpenHelperChooseCard(this);

        final DatabaseOpenHelper4 myDb2;
        myDb2 = new DatabaseOpenHelper4(this);

        final DatabaseOpenHelperAmount myDb3;
        myDb3 = new DatabaseOpenHelperAmount(this);

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




        }catch(Exception e)
        {

        }


        try {
            mDB3 = myDb3.getReadableDatabase();

            validNumber = true;
            int j = 0;

            Cursor c3 = mDB3.rawQuery("SELECT " + DatabaseOpenHelperAmount.PAY_AMOUNT + " FROM pay_amount", null);

            if (c3 != null) {
                if (c3.moveToFirst()) {
                    do {
                        payAmount = c3.getString(c3.getColumnIndex("paymentamount"));

                    } while (c3.moveToNext());
                }
                c3.close();


                finalQRPattern = payAmount + chosenAccount;
                String text2 = "";
                text2 = " Account number:  " + chosenAccount + " " + "Pay amount:" + payAmount;
                Context context2 = getApplicationContext();

                int duration2 = Toast.LENGTH_SHORT;


                Toast toast2 = Toast.makeText(context2, text2, duration2);
                toast2.show();

            }




        }catch(Exception e)
        {


        }



        ImageView imageView = (ImageView) findViewById(R.id.QR_Image);
        try {
            Bitmap bitmap = encodeAsBitmap(finalQRPattern);
            imageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    Bitmap encodeAsBitmap(String str) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, WIDTH, HEIGHT, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }

        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
        return bitmap;
    }





    public void getLocalIpAddress(){


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
        for(int i = IPLength2; i < 16; i++)
        {
            fullCreditCardNumber = fullCreditCardNumber + "0";

        }
        IPAddressArray = IPAddress1.toCharArray();

        int j = 0;
        for(int i = 0; i < IPAddressArray.length; i++)
        {

            cardArray[i] = IPAddressArray[i];

            j++;
        }

        for(int i = j; i < 16; i++ )
        {

            cardArray[i] = 0;
        }


    }
}


