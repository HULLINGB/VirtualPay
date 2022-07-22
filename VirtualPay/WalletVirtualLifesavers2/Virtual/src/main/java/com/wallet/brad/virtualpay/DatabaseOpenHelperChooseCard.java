package com.wallet.brad.virtualpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
class DatabaseOpenHelperChooseCard extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "accountchoice.db";
    public static final String TABLE_NAME = "account_choice";
    public static final String ACCOUNT_CHOICE = "accountchoice";
    final static String _ID = "_id";
    final static String[] columns = {_ID, ACCOUNT_CHOICE};


    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ACCOUNT_CHOICE + " TEXT)";


    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    public DatabaseOpenHelperChooseCard(Context context) {
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

    public boolean insertData2(int number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseOpenHelperChooseCard.ACCOUNT_CHOICE, number);
        db.insert(TABLE_NAME, null, contentValues);

        return true;
    }



    public String getData2() {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.get(ACCOUNT_CHOICE);
        return ACCOUNT_CHOICE;

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