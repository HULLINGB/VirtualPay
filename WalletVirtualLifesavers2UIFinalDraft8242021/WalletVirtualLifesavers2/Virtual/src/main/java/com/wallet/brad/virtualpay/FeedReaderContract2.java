package com.wallet.brad.virtualpay;

import android.provider.BaseColumns;


public class FeedReaderContract2 {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract2() {}

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "transactionhistory.db";


    /* Inner class that defines the table contents */
    public static class FeedEntry2 implements BaseColumns {
        public static final String TABLE_NAME = "transactionhistory";
        public static final String COLUMN_NAME_TITLE1 = "numOfTransactions";
        public static final String COLUMN_NAME_TITLE2 = "transactionAmount";

        





    }


}
