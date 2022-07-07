package com.wallet.brad.virtualpay;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Random;


public class PayQR9 extends Activity {


    public String cardChoice;
    public String chosenCard;
    public String payAmount = "";

    public String expiration;
    public String cvv;

    Point point = new Point();
    int width = point.x;
    int height = point.y;
    int smallerDimension = width < height ? width : height;
    public static String IPAddress1;
    public static String IPAddress2;


    private int[] cardArray = new int[16];
    private int[] cardArray2 = new int[40];

    public static String[] IPAddressArrayStrings = new String[15];

    private int card;
    private int card2;
    private int card3;
    private int card4;
    private int card5;
    private int card6;
    private int card7;
    private int card8;
    private int card9;
    private int card10;
    private int card11;
    private int card12;
    private int card13;
    private int card14;
    private int card15;
    private int card16;
    private int cardGenerated;
    private int finalCard;
    private String finalCardString;
    private char[] IPAddressArray = new char[11];
    int exp;
    int cVV;
    boolean validNumber;
    ImageView mImageView;
    long lengthOfCard1 = 1000;
    long lengthOfCard2 = 1000;
    long lengthOfCard3 = 1000;
    long lengthOfCard4 = 1000;
    long lengthOfCard = lengthOfCard1 * lengthOfCard2 * lengthOfCard3 * lengthOfCard4;
    long lengthOfCard6 = 9999;
    long lengthOfCard7 = 9999;
    long lengthOfCard8 = 9999;
    long lengthOfCard9 = 9999;
    long lengthOfCardMax = lengthOfCard6 * lengthOfCard7 * lengthOfCard8 * lengthOfCard9;

    int lengthOfExp = 0420;
    int lengthOfCVV = 001;
    int lengthOfExp2 = 1250;
    int lengthOfCVV2 = 999;


    //covert to string to we can get length for the loop
    Random number = new Random();

    double s;

    int step1;
    int step2;
    int step3;
    int step4;
    int step5;
    int step6;
    int step7;
    int step8;
    int IPChecker;
    public final static int WHITE = 0xFFFFFFFF;
    public final static int BLACK = 0xFF000000;
    public final static int WIDTH = 400;
    public final static int HEIGHT = 400;

    public final static String STR = "A string to be encoded as QR code";
    //final DatabaseHelper DBHelper = new DatabaseHelper(getBaseContext());

    private SQLiteDatabase mDB = null;
    private SimpleCursorAdapter mAdapter;
    String finalQRPattern = "";

    public String fullCreditCardNumber;
    public String mobileCreditCardNumber;
    public String mobileIPAddress = "";
    public String mobileIPAdress2;

    Context context;
    int k;
    int q;

    String text = "";

    boolean isIPv4 = true;
    private char[] IPAddressArray2 = new char[20];


    boolean wifiOrMobile = false;
    String phoneNumber = "";

    char[] vpnIP = new char[10];
    String vpn = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2);

        final DatabaseOpenHelper12 myDb;
        myDb = new DatabaseOpenHelper12(this);
        final DatabaseOpenHelperAmount myDb2;
        myDb2 = new DatabaseOpenHelperAmount(this);

        try {
            mDB = myDb.getReadableDatabase();


            validNumber = true;
            int j = 0;

           Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper12.CARD_NUMBER + " FROM fake_info9", null);

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
            mDB = myDb2.getReadableDatabase();


            validNumber = true;
            int j = 0;

            Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelperAmount.PAY_AMOUNT + " FROM pay_amount", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        payAmount = c.getString(c.getColumnIndex("paymentamount"));

                    } while (c.moveToNext());
                }
                c.close();




                finalQRPattern = payAmount + chosenCard;
            }




        }catch(Exception e)
        {


        }



        /**
        c = mDB.rawQuery("SELECT " + DatabaseOpenHelper4.EXPIRATION + " FROM fake_info", null);

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    expiration = c.getString(c.getColumnIndex("expiration"));

                } while (c.moveToNext());
            }
            c.close();

            finalQRPattern = finalQRPattern + expiration;


        }

        c = mDB.rawQuery("SELECT " + DatabaseOpenHelper4.CVV + " FROM fake_info", null);

        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    cvv = c.getString(c.getColumnIndex("cvv"));

                } while (c.moveToNext());
            }
            c.close();

            finalQRPattern = finalQRPattern + cvv;


        }

**/


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


    public void generateCardNumber() {


        if (IPAddress1 == null) {

            //validNumber = false;
        }


        int i = 0;
        card = cardArray[i];

        i++;
        card2 = cardArray[i];

        i++;
        card3 = cardArray[i];

        i++;
        card4 = cardArray[i];

        i++;
        card5 = cardArray[i];

        i++;
        card6 = cardArray[i];

        i++;
        card7 = cardArray[i];

        i++;
        card8 = cardArray[i];

        i++;
        card9 = cardArray[i];

        i++;
        card10 = cardArray[i];

        i++;
        card11 = cardArray[i];

        i++;
        card12 = cardArray[i];

        i++;
        card13 = cardArray[i];

        i++;
        card14 = cardArray[i];

        i++;
        card15 = cardArray[i];

        i++;
        card16 = cardArray[i];


        //step 1 checker
        //double each second digit from right to left
        step1check();

        //step 2 checker
        //add all of the digits from step1
        step2check();


        //step 3 checker
        //add all of the odd digits from right to left
        int oddPlaces = card15 + card13 + card11 + card9 + card7 + card5 + card3 + card;


        double sum = IPChecker;
        double sum2 = oddPlaces;

        //step 4 checker
        //add the sums of step 2 checker and step 3 checker
        double finalSum = sum + sum2;

        double divideBy10Remainder = finalSum % 10;




        //Step 5 checker

        if(divideBy10Remainder > 0)
        {
            //validNumber = false;
        }




    }

    public void generateExpiration() {
        for (int i = 0; i < 4; i++) {
            s = number.nextDouble();
            s = s + 9;

            s = s * s;


        }

        exp = (int) s;

        if (exp > lengthOfExp || exp < lengthOfExp2) {
            generateExpiration();
        }
    }


    public void generateCVV() {
        for (int i = 0; i < 3; i++) {
            s = number.nextDouble();
            s = s + 9;


            s = s * s;

        }

        cVV = (int) s;

        if (cVV > lengthOfCVV || cVV < lengthOfCVV2) {
            generateCVV();
        }

    }


    // Return true if the card number is valid
    public static boolean isValid(int number) {
        return (getSize(number) >= 13 &&
                getSize(number) <= 16) &&
                (prefixMatched(number, 4) ||
                        prefixMatched(number, 5) ||
                        prefixMatched(number, 37) ||
                        prefixMatched(number, 6)) &&
                ((sumOfDoubleEvenPlace(number) +
                        sumOfOddPlace(number)) % 10 == 0);
    }

    // Get the result from Step 2
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i >= 0; i -= 2)
            sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

        return sum;
    }

    // Return this number if it is a single digit, otherwise,
    // return the sum of the two digits
    public static int getDigit(int number) {
        if (number < 9)
            return number;
        return number / 10 + number % 10;
    }

    // Return sum of odd-place digits in number
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 1; i >= 0; i -= 2)
            sum += Integer.parseInt(num.charAt(i) + "");
        return sum;
    }

    // Return true if the digit d is a prefix for number
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    // Return the number of digits in d
    public static int getSize(long d) {
        String num = d + "";
        return num.length();
    }

    // Return the first k number of digits from
    // number. If the number of digits in number
    // is less than k, return number.
    public static long getPrefix(long number, int k) {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0, k));
        }
        return number;
    }

    public void step1check()  {

        step1 = card2 * 2;



        step2 = card4 * 2;

        step3 = card6 * 2;

        step4 = card8 * 2;

        step5 = card10 * 2;

        step6 = card12 * 2;

        step7 = card14 * 2;

        step8 = card16 * 2;





    }


    public void step2check() {

        IPChecker = step1 + step2 + step3 + step4 + step5 + step6 + step7 + step8;
    }
}


/**
 private void readFromDatabase()
 {


 SQLiteDatabase db = MainActivity.DBHelper.getReadableDatabase();

 // Define a projection that specifies which columns from the database
 // you will actually use after this query.
 String[] projection = {
 BaseColumns._ID,
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5,

 };

 // Filter results WHERE "title" = 'My Title'
 String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5 + " = ?";
 String[] selectionArgs = { "My Title" };

 // How you want the results sorted in the resulting Cursor
 String sortOrder =
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5 + " DESC";

 Cursor cursor = db.query(
 FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
 projection,             // The array of columns to return (pass null to get all)
 selection,              // The columns for the WHERE clause
 selectionArgs,          // The values for the WHERE clause
 null,                   // don't group the rows
 null,                   // don't filter by row groups
 sortOrder               // The sort order
 );

 List itemIds = new ArrayList<>();
 while(cursor.moveToNext()) {
 long itemId = cursor.getLong(
 cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5));
 itemIds.add(itemId);
 }

 creditCardNum = itemIds.get(0).toString();

 readFromDatabase2();
 readFromDatabase3();


 cursor.close();
 db.close();
 }


 private void readFromDatabase2()
 {


 SQLiteDatabase db = MainActivity.DBHelper.getReadableDatabase();

 // Define a projection that specifies which columns from the database
 // you will actually use after this query.
 String[] projection = {
 BaseColumns._ID,
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6,

 };

 // Filter results WHERE "title" = 'My Title'
 String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6 + " = ?";
 String[] selectionArgs = { "My Title" };

 // How you want the results sorted in the resulting Cursor
 String sortOrder =
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6 + " DESC";

 Cursor cursor = db.query(
 FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
 projection,             // The array of columns to return (pass null to get all)
 selection,              // The columns for the WHERE clause
 selectionArgs,          // The values for the WHERE clause
 null,                   // don't group the rows
 null,                   // don't filter by row groups
 sortOrder               // The sort order
 );

 List itemIds = new ArrayList<>();
 while(cursor.moveToNext()) {
 long itemId = cursor.getLong(
 cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6));
 itemIds.add(itemId);
 }

 exp = itemIds.get(0).toString();

 readFromDatabase3();



 cursor.close();
 db.close();
 }


 private void readFromDatabase3()
 {


 SQLiteDatabase db = MainActivity.DBHelper.getReadableDatabase();

 // Define a projection that specifies which columns from the database
 // you will actually use after this query.
 String[] projection = {
 BaseColumns._ID,
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7,

 };

 // Filter results WHERE "title" = 'My Title'
 String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7 + " = ?";
 String[] selectionArgs = { "My Title" };

 // How you want the results sorted in the resulting Cursor
 String sortOrder =
 FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7 + " DESC";

 Cursor cursor = db.query(
 FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
 projection,             // The array of columns to return (pass null to get all)
 selection,              // The columns for the WHERE clause
 selectionArgs,          // The values for the WHERE clause
 null,                   // don't group the rows
 null,                   // don't filter by row groups
 sortOrder               // The sort order
 );

 List itemIds = new ArrayList<>();
 while(cursor.moveToNext()) {
 long itemId = cursor.getLong(
 cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7));
 itemIds.add(itemId);
 }

 cVV = itemIds.get(0).toString();





 cursor.close();
 db.close();
 }





 }

 **/


