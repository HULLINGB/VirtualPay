package com.wallet.brad.virtualpay;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiManager;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.format.Formatter;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


import java.util.Random;

public class Pay extends Activity implements NfcAdapter.CreateNdefMessageCallback {
NfcAdapter nfcAdapter;
        TextView textView;
        PendingIntent pendingIntent;
        String number = "122334455566";
        //String exp = "04/22";
        String cvv = "222";
        boolean validNumber = false;
        static String IPAddress1;
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
        Random numb = new Random();

        private int[] cardArray = new int[11];
        public static String[] IPAddressArrayStrings = new String[15];


        double s;

        int step1;
        int step2;
        int step3;
        int step4;
        int step5;
        int step6;
        int step7;
        int step8;
        static int IPChecker;
        private String chosenCard;
        private String expiration;

        private SQLiteDatabase mDB = null;
        private SimpleCursorAdapter mAdapter;

        public String fullCreditCardNumber;

        char[] vpnIP = new char[10];
        String vpn = "";
        public String mobileIPAddress = "";
        boolean isIPv4 = true;

        String finalNFCPattern = "";

        String phoneNumber = "";

        @Override
public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_pay2);
                final DatabaseOpenHelper4 myDb;
                myDb = new DatabaseOpenHelper4(this);
                final DatabaseOpenHelper0 myDb2;
                myDb2 = new DatabaseOpenHelper0(this);

                try {
                        mDB = myDb.getReadableDatabase();


                        validNumber = true;
                        int j = 0;


                        Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper4.CARD_NUMBER + " FROM fake_info", null);

                        if (c != null) {
                                if (c.moveToFirst()) {
                                        do {
                                                chosenCard = c.getString(c.getColumnIndex("fakenumber"));

                                        } while (c.moveToNext());
                                }
                                c.close();




                                finalNFCPattern = chosenCard;
                        }




                }catch(Exception e)
                {


                }



        }




@Override
public NdefMessage createNdefMessage(NfcEvent event) {
        return null;
}

@Override
public void onResume() {
        super.onResume();
        // Check to see that the Activity started due to an Android Beam
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(getIntent().getAction())) {
        processIntent(getIntent());
        }
        }

@Override
public void onNewIntent(Intent intent) {
        // onResume gets called after this to handle the intent
        setIntent(intent);
        }

        /**
         * Parses the NDEF Message from the intent and prints to the TextView
         */
        void processIntent(Intent intent) {
        Parcelable[] rawMsgs = intent.getParcelableArrayExtra(
        NfcAdapter.EXTRA_NDEF_MESSAGES);
        // only one message sent during the beam
        NdefMessage msg = (NdefMessage) rawMsgs[0];
        // record 0 contains the MIME type, record 1 is the AAR, if present
        textView.setText(new String(msg.getRecords()[0].getPayload()));
        }



        private void setSmartPhoneIPAddress() {


                //assuming we are using the wifi method

                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                IPAddress1 = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());

                //remove periods
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

                        validNumber = false;
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
                        validNumber = true;
                }




        }

        public void generateExpiration()
        {
                for (int i = 0; i < 4; i++) {
                        s = numb.nextDouble();
                        s = s + 9;

                        s = s * s;


                }

                exp = (int)s;

                if(exp > lengthOfExp || exp < lengthOfExp2)
                {
                        generateExpiration();
                }
        }


        public void generateCVV()
        {
                for (int i = 0; i < 3; i++) {
                        s = numb.nextDouble();
                        s = s + 9;


                        s = s * s;

                }

                cVV = (int)s;

                if(cVV > lengthOfCVV || cVV < lengthOfCVV2)
                {
                        generateCVV();
                }

        }


        static int concat(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j)
        {

                // Convert both the integers to string
                String s1 = Integer.toString(a);
                String s2 = Integer.toString(b);
                String s3 = Integer.toString(c);
                String s4 = Integer.toString(d);
                String s5 = Integer.toString(e);
                String s6 = Integer.toString(f);
                String s7 = Integer.toString(g);
                String s8 = Integer.toString(h);
                String s9 = Integer.toString(i);
                String s10 = Integer.toString(j);



                // Concatenate both strings
                String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10;

                // Convert the concatenated string
                // to integer
                int w = Integer.parseInt(s);

                // return the formed integer
                return w;
        }

        static int concat2(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k)
        {

                // Convert both the integers to string
                String s1 = Integer.toString(a);
                String s2 = Integer.toString(b);
                String s3 = Integer.toString(c);
                String s4 = Integer.toString(d);
                String s5 = Integer.toString(e);
                String s6 = Integer.toString(f);
                String s7 = Integer.toString(g);
                String s8 = Integer.toString(h);
                String s9 = Integer.toString(i);
                String s10 = Integer.toString(j);
                String s11 = Integer.toString(k);



                // Concatenate both strings
                String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11;

                // Convert the concatenated string
                // to integer
                int w = Integer.parseInt(s);

                // return the formed integer
                return w;
        }
        static int concat3(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l)
        {

                // Convert both the integers to string
                String s1 = Integer.toString(a);
                String s2 = Integer.toString(b);
                String s3 = Integer.toString(c);
                String s4 = Integer.toString(d);
                String s5 = Integer.toString(e);
                String s6 = Integer.toString(f);
                String s7 = Integer.toString(g);
                String s8 = Integer.toString(h);
                String s9 = Integer.toString(i);
                String s10 = Integer.toString(j);
                String s11 = Integer.toString(k);
                String s12 = Integer.toString(l);



                // Concatenate both strings
                String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12;

                // Convert the concatenated string
                // to integer
                int w = Integer.parseInt(s);

                // return the formed integer
                return w;
        }

        static int concat4(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m)
        {

                // Convert both the integers to string
                String s1 = Integer.toString(a);
                String s2 = Integer.toString(b);
                String s3 = Integer.toString(c);
                String s4 = Integer.toString(d);
                String s5 = Integer.toString(e);
                String s6 = Integer.toString(f);
                String s7 = Integer.toString(g);
                String s8 = Integer.toString(h);
                String s9 = Integer.toString(i);
                String s10 = Integer.toString(j);
                String s11 = Integer.toString(k);
                String s12 = Integer.toString(l);
                String s13 = Integer.toString(m);


                // Concatenate both strings
                String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13;

                // Convert the concatenated string
                // to integer
                int w = Integer.parseInt(s);

                // return the formed integer
                return w;
        }

        static int concat5(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n)
        {

                // Convert both the integers to string
                String s1 = Integer.toString(a);
                String s2 = Integer.toString(b);
                String s3 = Integer.toString(c);
                String s4 = Integer.toString(d);
                String s5 = Integer.toString(e);
                String s6 = Integer.toString(f);
                String s7 = Integer.toString(g);
                String s8 = Integer.toString(h);
                String s9 = Integer.toString(i);
                String s10 = Integer.toString(j);
                String s11 = Integer.toString(k);
                String s12 = Integer.toString(l);
                String s13 = Integer.toString(m);
                String s14 = Integer.toString(n);


                // Concatenate both strings
                String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14;

                // Convert the concatenated string
                // to integer
                int w = Integer.parseInt(s);

                // return the formed integer
                return w;
        }

        static int concat6(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o)
        {

                // Convert both the integers to string
                String s1 = Integer.toString(a);
                String s2 = Integer.toString(b);
                String s3 = Integer.toString(c);
                String s4 = Integer.toString(d);
                String s5 = Integer.toString(e);
                String s6 = Integer.toString(f);
                String s7 = Integer.toString(g);
                String s8 = Integer.toString(h);
                String s9 = Integer.toString(i);
                String s10 = Integer.toString(j);
                String s11 = Integer.toString(k);
                String s12 = Integer.toString(l);
                String s13 = Integer.toString(m);
                String s14 = Integer.toString(n);
                String s15 = Integer.toString(o);



                // Concatenate both strings
                String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15;

                // Convert the concatenated string
                // to integer
                int w = Integer.parseInt(s);

                // return the formed integer
                return w;
        }


        static int concat7(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o, int p)
        {

                // Convert both the integers to string
                String s1 = Integer.toString(a);
                String s2 = Integer.toString(b);
                String s3 = Integer.toString(c);
                String s4 = Integer.toString(d);
                String s5 = Integer.toString(e);
                String s6 = Integer.toString(f);
                String s7 = Integer.toString(g);
                String s8 = Integer.toString(h);
                String s9 = Integer.toString(i);
                String s10 = Integer.toString(j);
                String s11 = Integer.toString(k);
                String s12 = Integer.toString(l);
                String s13 = Integer.toString(m);
                String s14 = Integer.toString(n);
                String s15 = Integer.toString(o);
                String s16 = Integer.toString(p);



                // Concatenate both strings
                String s = s1 + s2 + s3 + s4 + s5 + s6 + s7 + s8 + s9 + s10 + s11 + s12 + s13 + s14 + s15 + s16;

                // Convert the concatenated string
                // to integer
                int w = Integer.parseInt(s);

                // return the formed integer
                return w;
        }











        // Return true if the card number is valid
        public static boolean isValid ( int number)
        {
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
        public static int sumOfDoubleEvenPlace ( long number)
        {
                int sum = 0;
                String num = number + "";
                for (int i = getSize(number) - 2; i >= 0; i -= 2)
                        sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);

                return sum;
        }

        // Return this number if it is a single digit, otherwise,
        // return the sum of the two digits
        public static int getDigit ( int number)
        {
                if (number < 9)
                        return number;
                return number / 10 + number % 10;
        }

        // Return sum of odd-place digits in number
        public static int sumOfOddPlace ( long number)
        {
                int sum = 0;
                String num = number + "";
                for (int i = getSize(number) - 1; i >= 0; i -= 2)
                        sum += Integer.parseInt(num.charAt(i) + "");
                return sum;
        }

        // Return true if the digit d is a prefix for number
        public static boolean prefixMatched ( long number, int d)
        {
                return getPrefix(number, getSize(d)) == d;
        }

        // Return the number of digits in d
        public static int getSize ( long d)
        {
                String num = d + "";
                return num.length();
        }

        // Return the first k number of digits from
        // number. If the number of digits in number
        // is less than k, return number.
        public static long getPrefix ( long number, int k)
        {
                if (getSize(number) > k) {
                        String num = number + "";
                        return Long.parseLong(num.substring(0, k));
                }
                return number;
        }



        //if we want to pick the card number
        /**
        private void readFromDatabase()
        {


                SQLiteDatabase db = DBHelper.getReadableDatabase();

                // Define a projection that specifies which columns from the database
                // you will actually use after this query.
                String[] projection = {
                        BaseColumns._ID,
                        FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE53,

                };

                // Filter results WHERE "title" = 'My Title'
                String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE53 + " = ?";
                String[] selectionArgs = { "cardChoice" };

                // How you want the results sorted in the resulting Cursor
                String sortOrder =
                        FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE53 + " DESC";

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
                                cursor.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE53));
                        itemIds.add(itemId);
                }


                readFromDatabase2();
                readFromDatabase3();
                readFromDatabase4();

/**
 if(cardChoice == "2")
 {
 readFromDatabase5();
 readFromDatabase6();
 readFromDatabase7();
 }

 if(cardChoice == "3")
 {
 readFromDatabase8();
 readFromDatabase9();
 readFromDatabase10();
 }


 if(cardChoice == "4")
 {
 readFromDatabase11();
 readFromDatabase12();
 readFromDatabase13();

 }

 if(cardChoice == "5")
 {
 readFromDatabase14();
 readFromDatabase15();
 readFromDatabase16();

 }

 if(cardChoice == "6")
 {
 readFromDatabase17();
 readFromDatabase18();
 readFromDatabase19();
 }

 if(cardChoice == "7")
 {
 readFromDatabase20();
 readFromDatabase21();
 readFromDatabase22();

 }

 if(cardChoice == "8")
 {
 readFromDatabase23();
 readFromDatabase24();
 readFromDatabase25();
 }

 if(cardChoice == "9")
 {
 readFromDatabase26();
 readFromDatabase27();
 readFromDatabase28();
 }

 if(cardChoice == "10")
 {
 readFromDatabase29();
 readFromDatabase30();
 readFromDatabase31();
 }

 if(cardChoice == "11")
 {
 readFromDatabase32();
 readFromDatabase33();
 readFromDatabase34();
 }

 if(cardChoice == "12")
 {
 readFromDatabase35();
 readFromDatabase36();
 readFromDatabase37();
 }



                //cursor.close();
                //db.close();
        }
**/
        private void readFromDatabase2()
        {
/**

                SQLiteDatabase db = DBHelper.getReadableDatabase();


                // Define a projection that specifies which columns from the database
                // you will actually use after this query.
                String[] projection = {
                        BaseColumns._ID,
                        FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5,

                };

                // Filter results WHERE "title" = 'My Title'
                String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE5 + " = ?";
                String[] selectionArgs = { "cardnumber" };

                // How you want the results sorted in the resulting Cursor
                String sortOrder =
                        FeedReaderContract.FeedEntry._ID + " DESC";

                Cursor cursor = db.query(
                        FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
                        null,             // The array of columns to return (pass null to get all)
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

                chosenCard = itemIds.get(0).toString();





                cursor.close();
                db.close();
 **/
        }

        private void readFromDatabase3()
        {

/**
                SQLiteDatabase db = DBHelper.getReadableDatabase();


                // Define a projection that specifies which columns from the database
                // you will actually use after this query.
                String[] projection = {
                        BaseColumns._ID,
                        FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6,

                };

                // Filter results WHERE "title" = 'My Title'
                String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE6 + " = ?";
                String[] selectionArgs = { "expirationdate" };

                // How you want the results sorted in the resulting Cursor
                String sortOrder =
                        FeedReaderContract.FeedEntry._ID + " DESC";

                Cursor cursor = db.query(
                        FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
                        null,             // The array of columns to return (pass null to get all)
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


                expiration = itemIds.get(0).toString();





                cursor.close();
                db.close();
 **/
        }

        private void readFromDatabase4()
        {

/**
                SQLiteDatabase db = DBHelper.getReadableDatabase();


                // Define a projection that specifies which columns from the database
                // you will actually use after this query.
                String[] projection = {
                        BaseColumns._ID,
                        FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7,

                };

                // Filter results WHERE "title" = 'My Title'
                String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE7 + " = ?";
                String[] selectionArgs = { "cvv" };

                // How you want the results sorted in the resulting Cursor
                String sortOrder =
                        FeedReaderContract.FeedEntry._ID + " DESC";

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


                cvv = itemIds.get(0).toString();




                cursor.close();
                db.close();
**/
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