package com.wallet.brad.virtualpay;

import android.provider.BaseColumns;

public class FeedReaderContract3 {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract3() {}

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "filepaths.db";


    /* Inner class that defines the table contents */
    public static class FeedEntry3 implements BaseColumns {
        public static final String TABLE_NAME = "userinformation";
        public static final String COLUMN_NAME_TITLE = "faceimagepath";








    }


}