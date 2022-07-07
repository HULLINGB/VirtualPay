package com.wallet.brad.virtualpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.Random;

public class GenerateCardNumber7 extends Activity {


    private int[] cardArray = new int[16];
    public int[] cardArray2 = new int[40];
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
    public String finalCardString = "";
    private int cardGenerated;
    private int finalCard;
    public String fullCreditCardNumber;
    private char[] IPAddressArray = new char[13];
    private char[] IPAddressArray2 = new char[20];
    private String[] IPAddressArrayStrings = new String[13];
    int exp;
    int cVV;
    boolean validNumber;

    int lengthOfExp = 0420;
    int lengthOfCVV = 001;
    int lengthOfExp2 = 1250;
    int lengthOfCVV2 = 999;
    int IPLength;

    public String IPAddress1;
    public String IPAddress2;

    int step1;
    int step2;
    int step3;
    int step4;
    int step5;
    int step6;
    int step7;
    int step8;
    int IPChecker;
    //covert to string to we can get length for the loop
    Random number = new Random();
    double s;

    Button mCard;
    private String creditCardNum;
    private String expiration;
    private SQLiteDatabase mDB = null;
    private SimpleCursorAdapter mAdapter;
    String chosenCard;
    String cvv;
    public String mobileCreditCardNumber;
    public String mobileIPAdress;
    public String mobileIPAdress2;
    String mobileIPAddress = "";
    char[] VPNIP = new char[16];
    char[] vpnIP = new char[10];

    String[] vIPString = new String[10];

    int k;
    int q;

    String text = "";

    boolean isIPv4 = true;

    boolean wifiOrMobile = false;
    String phoneNumber = "";

    Button mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_card_number);

        final DatabaseOpenHelper10 myDb7;
        myDb7 = new DatabaseOpenHelper10(this);


        //final DatabaseOpenHelper3 myDb2;
        //myDb2 = new DatabaseOpenHelper3(this);

        mBack = (Button) findViewById(R.id.backbutton);

        final Intent intent6 = new Intent(GenerateCardNumber7.this, MainActivity.class);
        intent6.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent6.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


        try {
            mDB = myDb7.getReadableDatabase();


            Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper10.CARD_NUMBER + " FROM fake_info7", null);

            if (c != null) {
                if (c.moveToFirst()) {

                    do {
                        chosenCard = c.getString(c.getColumnIndex("fakenumber"));

                    } while (c.moveToNext());


                }
                c.close();


                String text = "";
                text = chosenCard;
                Context context = getApplicationContext();

                int duration = Toast.LENGTH_LONG;


                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }


        } catch (Exception e) {


        }

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                startActivity(intent6);





            }
        });



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


