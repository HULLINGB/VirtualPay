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
    int cursorCounter = 0;
    String card1 = "";
    String card2 = "";
    String card3 = "";
    String card4 = "";
    String card5 = "";
    String card6 = "";
    String card7 = "";
    String card8 = "";
    String card9 = "";
    String card10 = "";
    private SQLiteDatabase mDB = null;
    private SQLiteDatabase mDB2 = null;
    private SQLiteDatabase mDB3 = null;
    private SQLiteDatabase mDB4 = null;
    private SQLiteDatabase mDB5 = null;
    private SQLiteDatabase mDB6 = null;
    private SQLiteDatabase mDB7 = null;
    private SQLiteDatabase mDB8 = null;
    private SQLiteDatabase mDB9 = null;
    private SQLiteDatabase mDB10 = null;
    int choice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);


        Button mCard1, mCard2, mCard3, mCard4, mCard5, mCard6, mCard7, mCard8, mCard9, mCard10, mCard11, mCard12, mAddNew, mEnterCard, mGenerateOnlinePurchaseNumber, mBack;


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
        CharSequence text = "Accounts";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        final DatabaseOpenHelper4 myDb;
        myDb = new DatabaseOpenHelper4(this);
        final DatabaseOpenHelper5 myDb2;
        myDb2 = new DatabaseOpenHelper5(this);
        final DatabaseOpenHelper6 myDb3;
        myDb3 = new DatabaseOpenHelper6(this);
        final DatabaseOpenHelper7 myDb4;
        myDb4 = new DatabaseOpenHelper7(this);
        final DatabaseOpenHelper8 myDb5;
        myDb5 = new DatabaseOpenHelper8(this);
        final DatabaseOpenHelper9 myDb6;
        myDb6 = new DatabaseOpenHelper9(this);
        final DatabaseOpenHelper10 myDb7;
        myDb7 = new DatabaseOpenHelper10(this);
        final DatabaseOpenHelper11 myDb8;
        myDb8 = new DatabaseOpenHelper11(this);
        final DatabaseOpenHelper12 myDb9;
        myDb9 = new DatabaseOpenHelper12(this);
        final DatabaseOpenHelper13 myDb10;
        myDb10 = new DatabaseOpenHelper13 (this);

        final DatabaseOpenHelper4 myDb11;
        myDb11 = new DatabaseOpenHelper4(this);
        final DatabaseOpenHelper5 myDb12;
        myDb12 = new DatabaseOpenHelper5(this);
        final DatabaseOpenHelper6 myDb13;
        myDb13 = new DatabaseOpenHelper6(this);
        final DatabaseOpenHelper7 myDb14;
        myDb14 = new DatabaseOpenHelper7(this);
        final DatabaseOpenHelper8 myDb15;
        myDb15 = new DatabaseOpenHelper8(this);
        final DatabaseOpenHelper9 myDb16;
        myDb16 = new DatabaseOpenHelper9(this);
        final DatabaseOpenHelper10 myDb17;
        myDb17 = new DatabaseOpenHelper10(this);
        final DatabaseOpenHelper11 myDb18;
        myDb18 = new DatabaseOpenHelper11(this);
        final DatabaseOpenHelper12 myDb19;
        myDb19 = new DatabaseOpenHelper12(this);
        final DatabaseOpenHelper13 myDb20;
        myDb20 = new DatabaseOpenHelper13 (this);

        //final DatabaseOpenHelper3 myDb2;
        //myDb2 = new DatabaseOpenHelper3(this);


        final Intent intent = new Intent(Cards.this, Menu.class);


        final Intent intent2 = new Intent(Cards.this, Menu2.class);
        intent2.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent2.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent3 = new Intent(Cards.this, Menu3.class);
        intent3.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent3.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent4 = new Intent(Cards.this, Menu4.class);
        intent4.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent4.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent5 = new Intent(Cards.this, Menu5.class);
        intent5.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent5.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent6 = new Intent(Cards.this, Menu6.class);
        intent6.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent6.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent7 = new Intent(Cards.this, Menu7.class);
        intent7.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent7.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent8 = new Intent(Cards.this, Menu8.class);
        intent8.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent8.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent9 = new Intent(Cards.this, Menu9.class);
        intent9.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent9.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent10 = new Intent(Cards.this, Menu10.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent11 = new Intent(Cards.this, AddAccountAndRoutingNumber.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent12 = new Intent(Cards.this, AddAccountAndRoutingNumber2.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent13 = new Intent(Cards.this, AddAccountAndRoutingNumber3.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent14 = new Intent(Cards.this, AddAccountAndRoutingNumber4.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent15 = new Intent(Cards.this, AddAccountAndRoutingNumber5.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent16 = new Intent(Cards.this, AddAccountAndRoutingNumber6.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent17 = new Intent(Cards.this, AddAccountAndRoutingNumber7.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent18 = new Intent(Cards.this, AddAccountAndRoutingNumber8.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent19 = new Intent(Cards.this, AddAccountAndRoutingNumber9.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

        final Intent intent20 = new Intent(Cards.this, AddAccountAndRoutingNumber10.class);
        intent10.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent10.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


        final Intent intent21 = new Intent(Cards.this, Menu.class);
        intent11.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent11.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);


        mCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                try {
                    mDB = myDb.getReadableDatabase();



                    int j = 0;


                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper4.CARD_NUMBER + " FROM fake_info", null);

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


                    startActivity(intent);

                }catch(Exception e)
                {


                }








            }
        });

        mCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                try {
                    mDB = myDb2.getReadableDatabase();




                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper5.CARD_NUMBER + " FROM fake_info2", null);

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

                    startActivity(intent2);


                }catch(Exception e)
                {


                }







            }
        });

        mCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {
                    mDB = myDb3.getReadableDatabase();






                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper6.CARD_NUMBER + " FROM fake_info3", null);

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


                    startActivity(intent3);

                }catch(Exception e)
                {


                }








            }
        });

        mCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                try {
                    mDB = myDb4.getReadableDatabase();



                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper7.CARD_NUMBER + " FROM fake_info4", null);

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

                    startActivity(intent4);


                }catch(Exception e)
                {


                }






            }
        });

        mCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                try {
                    mDB = myDb5.getReadableDatabase();






                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper8.CARD_NUMBER + " FROM fake_info5", null);

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


                    startActivity(intent5);

                }catch(Exception e)
                {


                }





            }
        });

        mCard6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                try {
                    mDB = myDb6.getReadableDatabase();






                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper9.CARD_NUMBER + " FROM fake_info6", null);

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



                    startActivity(intent6);

                }catch(Exception e)
                {


                }





            }
        });

        mCard7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




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

                    startActivity(intent7);


                }catch(Exception e)
                {


                }





            }
        });

        mCard8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                try {
                    mDB = myDb8.getReadableDatabase();






                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper11.CARD_NUMBER + " FROM fake_info8", null);

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


                    startActivity(intent8);

                }catch(Exception e)
                {


                }




            }
        });

        mCard9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {
                    mDB = myDb9.getReadableDatabase();






                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper12.CARD_NUMBER + " FROM fake_info9", null);

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


                    startActivity(intent9);

                }catch(Exception e)
                {


                }







            }
        });

        mCard10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                try {
                    mDB = myDb10.getReadableDatabase();






                    Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper13.CARD_NUMBER + " FROM fake_info10", null);

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

                    startActivity(intent10);


                }catch(Exception e)
                {


                }




            }
        });

        mCard11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mDB = myDb11.getReadableDatabase();

                Cursor c = mDB.rawQuery("SELECT " + DatabaseOpenHelper4.CARD_NUMBER + " FROM fake_info", null);

                if (c != null) {
                    if (c.moveToFirst()) {

                        do {
                            cursorCounter++;
                            card1 = c.getString(c.getColumnIndex("fakenumber"));
                            if(c.getString(c.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent11);

                            }

                        } while (c.moveToNext());


                    }
                    c.close();

                }

                mDB2 = myDb12.getReadableDatabase();


                Cursor c2 = mDB2.rawQuery("SELECT " + DatabaseOpenHelper5.CARD_NUMBER + " FROM fake_info2", null);

                if (c2 != null) {
                    if (c2.moveToFirst()) {

                        do {
                            card2 = c2.getString(c2.getColumnIndex("fakenumber"));
                            if(c2.getString(c2.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent12);
                            }
                        } while (c2.moveToNext());


                    }
                    c2.close();

                }

                mDB3 = myDb13.getReadableDatabase();

                Cursor c3 = mDB3.rawQuery("SELECT " + DatabaseOpenHelper6.CARD_NUMBER + " FROM fake_info3", null);

                if (c3 != null) {
                    if (c3.moveToFirst()) {

                        do {
                            card3 = c3.getString(c3.getColumnIndex("fakenumber"));
                            if(c3.getString(c3.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent13);
                            }
                        } while (c3.moveToNext());


                    }
                    c3.close();

                }

                mDB4 = myDb14.getReadableDatabase();


                Cursor c4 = mDB4.rawQuery("SELECT " + DatabaseOpenHelper7.CARD_NUMBER + " FROM fake_info4", null);

                if (c4 != null) {
                    if (c4.moveToFirst()) {

                        do {
                            card4 = c4.getString(c4.getColumnIndex("fakenumber"));
                            if(c4.getString(c4.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent14);
                            }
                        } while (c4.moveToNext());


                    }
                    c4.close();

                }

                mDB5 = myDb15.getReadableDatabase();

                Cursor c5 = mDB5.rawQuery("SELECT " + DatabaseOpenHelper8.CARD_NUMBER + " FROM fake_info5", null);

                if (c5 != null) {
                    if (c5.moveToFirst()) {

                        do {
                            card5 = c5.getString(c5.getColumnIndex("fakenumber"));
                            if(c5.getString(c5.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent15);
                            }
                        } while (c5.moveToNext());


                    }
                    c5.close();

                }

                mDB6 = myDb16.getReadableDatabase();

                Cursor c6 = mDB6.rawQuery("SELECT " + DatabaseOpenHelper9.CARD_NUMBER + " FROM fake_info6", null);

                if (c6 != null) {
                    if (c6.moveToFirst()) {

                        do {
                            card6 = c6.getString(c6.getColumnIndex("fakenumber"));

                            if(c6.getString(c6.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent16);
                            }

                        } while (c6.moveToNext());


                    }
                    c6.close();

                }

                mDB7 = myDb17.getReadableDatabase();


                Cursor c7 = mDB7.rawQuery("SELECT " + DatabaseOpenHelper10.CARD_NUMBER + " FROM fake_info7", null);

                if (c7 != null) {
                    if (c7.moveToFirst()) {

                        do {
                            card7 = c7.getString(c7.getColumnIndex("fakenumber"));

                            if(c7.getString(c7.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent17);
                            }

                        } while (c7.moveToNext());


                    }
                    c7.close();

                }

                mDB8 = myDb18.getReadableDatabase();

                Cursor c8 = mDB8.rawQuery("SELECT " + DatabaseOpenHelper11.CARD_NUMBER + " FROM fake_info8", null);

                if (c8 != null) {
                    if (c8.moveToFirst()) {

                        do {
                            card8 = c8.getString(c8.getColumnIndex("fakenumber"));
                            if(c8.getString(c8.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent18);
                            }

                        } while (c8.moveToNext());


                    }
                    c8.close();

                }

                mDB9 = myDb19.getReadableDatabase();

                Cursor c9 = mDB9.rawQuery("SELECT " + DatabaseOpenHelper12.CARD_NUMBER + " FROM fake_info9", null);

                if (c9 != null) {
                    if (c9.moveToFirst()) {

                        do {
                            card9 = c9.getString(c9.getColumnIndex("fakenumber"));
                            if(c9.getString(c9.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent19);
                            }

                        } while (c9.moveToNext());


                    }
                    c9.close();

                }

                mDB10 = myDb20.getReadableDatabase();

                Cursor c10 = mDB10.rawQuery("SELECT " + DatabaseOpenHelper13.CARD_NUMBER + " FROM fake_info10", null);

                if (c10 != null) {
                    if (c10.moveToFirst()) {

                        do {
                            card10 = c10.getString(c10.getColumnIndex("fakenumber"));

                            if(c10.getString(c10.getColumnIndex("fakenumber")).isEmpty())
                            {
                                startActivity(intent20);
                            }

                        } while (c10.moveToNext());


                    }
                    c10.close();

                }


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




