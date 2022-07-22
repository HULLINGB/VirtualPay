package com.wallet.brad.virtualpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DatabaseOpenHelperTakePayment extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "acceptpayment.db";
    public static final String TABLE_NAME = "accept_payment";
    public static final String PAYMENT_INFO = "acceptpayment";
    public static final String EXPIRATION = "expiration";
    public static final String CVV = "cvv";
    final static String _ID = "_id";
    final static String[] columns = {_ID, PAYMENT_INFO, EXPIRATION, CVV};


    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    PAYMENT_INFO + " TEXT," +
                    EXPIRATION + " TEXT, " +
                    CVV + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DatabaseOpenHelperTakePayment(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean insertData(String name, String surname, String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseOpenHelper4.CARD_NUMBER, name);
        db.insert(TABLE_NAME, null, contentValues);


        contentValues.put(DatabaseOpenHelper4.EXPIRATION, surname);
        db.insert(TABLE_NAME, null, contentValues);


        contentValues.put(DatabaseOpenHelper4.CVV, marks);
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();

        //insertLanguage(db, name, surname, marks);

        return true;


    }

    public void deleteTable (SQLiteDatabase db){
        db.execSQL(SQL_DELETE_ENTRIES);
    }




    public boolean insertData2(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseOpenHelperTakePayment.PAYMENT_INFO, name);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.clear();

        //insertLanguage(db, name, surname, marks);

        return true;


    }



    private static void insertLanguage(SQLiteDatabase db, String card, String exp, String cvv) {
        db.execSQL("INSERT INTO " + TABLE_NAME + " (" + PAYMENT_INFO + EXPIRATION + CVV + ") VALUES ('" + card + exp + cvv +"');");


    }


    public String getData2() {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.get(PAYMENT_INFO);
        return PAYMENT_INFO;

    }



    public String getData3() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.get(EXPIRATION);
        return EXPIRATION;

    }

    public String getData4() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.get(CVV);

        return CVV;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        /**
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, name);
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(FeedReaderContract.FeedEntry.FeedEntry2.COLUMN_NAME_TITLE2, surname);
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();

        contentValues.put(FeedReaderContract.FeedEntry.FeedEntry2.FeedEntry3.COLUMN_NAME_TITLE3, marks);
        db.insert(TABLE_NAME, null, contentValues);
        contentValues.clear();

        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
         **/
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}