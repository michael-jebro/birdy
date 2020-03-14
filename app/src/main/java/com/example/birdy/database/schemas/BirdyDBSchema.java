package com.example.birdy.database.schemas;

import android.provider.BaseColumns;

public class BirdyDBSchema {
    public static final class LibraryTable implements BaseColumns {
        public static final String NAME = "lib_table";
        public static final String ARTIST = "artist";
        public static final String ITEM_TYPE = "item_type";
        public static final String ITEM_NAME = "item_name";
        public static final String ITEM_GENRE = "item_genre";
    }
}

