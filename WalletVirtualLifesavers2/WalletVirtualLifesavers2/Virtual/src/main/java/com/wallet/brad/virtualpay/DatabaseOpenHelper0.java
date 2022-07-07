package com.wallet.brad.virtualpay;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseOpenHelper0 extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final String TABLE_NAME = "user_phone";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "phonenumber.db";
    public static final String PHONENUMBER = "phonenumber";
    final static String _ID = "_id";


    Context context;

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                     PHONENUMBER + " TEXT)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DatabaseOpenHelper0(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public boolean insertData(String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseOpenHelper0.PHONENUMBER, number);
        db.insert(TABLE_NAME, null, contentValues);

        contentValues.clear();

        //insertLanguage(db, name, surname, marks);

        return true;


    }



    public void onCreate(SQLiteDatabase db)
    {
        DatabaseOpenHelper0 dbHelper = new DatabaseOpenHelper0(getContext());
        MainActivity.DBHelper3 = dbHelper;

        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
