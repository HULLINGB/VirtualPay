package com.wallet.brad.virtualpay;

import android.provider.BaseColumns;

public final class FeedReaderContract4 {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract4() {
    }

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

        public static class FeedEntry2 implements BaseColumns {
            public static final String TABLE_NAME = "entry";
            public static final String COLUMN_NAME_TITLE2 = "title";
            public static final String COLUMN_NAME_SUBTITLE2 = "subtitle";

            public static class FeedEntry3 implements BaseColumns {
                public static final String TABLE_NAME = "entry";
                public static final String COLUMN_NAME_TITLE3 = "title";
                public static final String COLUMN_NAME_SUBTITLE3 = "subtitle";



            }
        }
    }
}
