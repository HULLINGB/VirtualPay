package com.wallet.brad.virtualpay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Cards extends Activity {


    String chosenCard = "";
    int choice = 0;
    String accountChoice = "";
    int accountChoi = 0;
    String chosenAccount = "";
    SQLiteDatabase mDB = null;
    SQLiteDatabase mDB2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        Button mCard1, mCard2, mCard3, mCard4, mCard5, mCard6, mCard7, mCard8, mCard9, mCard10, mCard11, mBack;

        mCard1 = (Button) findViewById(R.id.card1);
        mCard2 = (Button) findViewById(R.id.card2);
        mCard3 = (Button) findViewById(R.id.card3);
        mCard4 = (Button) findViewById(R.id.card4);
        mCard5 = (Button) findViewById(R.id.card5);
        mCard6 = (Button) findViewById(R.id.card6);
        mCard7 = (Button) findViewById(R.id.card7);
        mCard8 = (Button) findViewById(R.id.card8);
        mCard9 = (Button) findViewById(R.id.card9);
        mCard10 = (Button) findViewById(R.id.card10);
        mCard11 = (Button) findViewById(R.id.card11);
        mBack = (Button) findViewById(R.id.backbutton);

        Context context = getApplicationContext();
        CharSequence text = "Choose Account";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        final DatabaseOpenHelperChooseCard myDb;
        myDb = new DatabaseOpenHelperChooseCard(this);
        final DatabaseOpenHelper4 myDb2;
        myDb2 = new DatabaseOpenHelper4(this);

        final Intent intent = new Intent(Cards.this, Menu.class);
        final Intent intent11 = new Intent(Cards.this, AddAccountAndRoutingNumber.class);
        final Intent intent21 = new Intent(Cards.this, Menu.class);





        mCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    try{
                        myDb.insertData2(1);
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





                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                    }catch(Exception e)
                    {

                    }
                    startActivity(intent);


            }
        });


        mCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    myDb.insertData2(2);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                    startActivity(intent);



            }
        });

        mCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    myDb.insertData2(3);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                startActivity(intent);




            }
        });

        mCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    myDb.insertData2(4);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                startActivity(intent);

            }
        });

        mCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    myDb.insertData2(5);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                startActivity(intent);

            }
        });

        mCard6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    myDb.insertData2(6);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                startActivity(intent);

            }
        });

        mCard7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    myDb.insertData2(7);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                startActivity(intent);

            }
        });

        mCard8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    myDb.insertData2(8);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                startActivity(intent);

            }
        });

        mCard9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    myDb.insertData2(9);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                startActivity(intent);
            }
        });

        mCard10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    myDb.insertData2(10);
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

                    String text2 = "";
                    text2 = " Account number:  " + chosenAccount + " ";
                    Context context2 = getApplicationContext();

                    int duration2 = Toast.LENGTH_SHORT;


                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();

                }catch(Exception e)
                {

                }
                startActivity(intent);

            }
        });

        mCard11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent11);

            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    startActivity(intent21);

            }
        });





    }







    protected void onResume(){
        super.onResume();

    }

    protected void onPause (){
        super.onPause();

    }

    protected void onStop (){
        super.onStop();
    }


}




