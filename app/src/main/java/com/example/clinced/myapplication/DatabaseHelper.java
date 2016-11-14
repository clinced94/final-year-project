package com.example.clinced.myapplication;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by clinced on 25/10/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //database version
    public static final int DATABASE_VERSION = 1;

    //database name
    public static final String DATABASE_NAME = "Users.db";

    //table names
    public static final String USER_TABLE_NAME = "user_table";
    public static final String ACTIVITY_TABLE_NAME = "activity_table";
    public static final String ACTIVITY_LOGGED_TABLE_NAME = "activity_logged_table";
    public static final String ACTIVITY_REVIEWED_TABLE_NAME = "activity_reviewed_table";


    //common column names
    public static final String COL_ID = "id";
    public static final String COL_CREATED_AT = "created_at";
    public static final String COL_NAME = "name";

    //user column names
    public static final String COL_AGE = "age";
    public static final String COL_USES_MONTH = "uses_this_month";
    public static final String COL_USES = "uses";

    //activity column names
    public static final String COL_EFFECT = "effect";
    public static final String COL_USED = "times_used";

    //activity logged and reviewed names
    public static final String COL_USER_ID = "user_id";
    public static final String COL_ACTIVITY_ID = "activity_id";
    public static final String COL_DATE = "date";
    public static final String COL_RATING = "rating";


    //table create statements
    //user table create statement
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + USER_TABLE_NAME
            + "(" + COL_ID + " INTEGER PRIMARY KEY," + COL_NAME + " TEXT," + COL_AGE
            + " INTEGER," + COL_USES_MONTH + " INTEGER," + COL_USES + " INTEGER,"
            + COL_CREATED_AT + " DATETIME" + ")";

    //activity table create statement
    private static final String CREATE_TABLE_ACTIVITY = "CREATE TABLE " + ACTIVITY_TABLE_NAME
            + "(" + COL_ID + " INTEGER PRIMARY KEY," + COL_NAME + " TEXT," + COL_EFFECT
            + " TEXT," + COL_USED + " INTEGER," + COL_CREATED_AT + " DATETIME" + ")";

    //activity logged table create statement
    private static final String CREATE_TABLE_ACTIVITY_LOGGED = "CREATE TABLE " + ACTIVITY_LOGGED_TABLE_NAME
            + "(" + COL_USER_ID + " INTEGER PRIMARY KEY," + COL_DATE + " DATETIME,"
            + COL_ACTIVITY_ID + " INTEGER PRIMARY KEY" + ")";

    //activity reviewed table create statement
    private static final String CREATE_TABLE_ACTIVITY_REVIEWED = "CREATE TABLE " + ACTIVITY_REVIEWED_TABLE_NAME
            + "(" + COL_USER_ID + " INTEGER PRIMARY KEY," + COL_DATE + " DATETIME,"
            + COL_ACTIVITY_ID + " INTEGER PRIMARY KEY," + COL_RATING + " TEXT" + ")";

    public DatabaseHelper(Context context) {

        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dab) {

        //creating tables
        dab.execSQL(CREATE_TABLE_USERS);
        dab.execSQL(CREATE_TABLE_ACTIVITY);
        dab.execSQL(CREATE_TABLE_ACTIVITY_LOGGED);
        dab.execSQL(CREATE_TABLE_ACTIVITY_REVIEWED);

    }

    @Override
    public void onUpgrade(SQLiteDatabase dab, int oldVersion, int newVersion) {

        //on upgrade, delete older tables if they exist
        dab.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
        dab.execSQL("DROP TABLE IF EXISTS " + ACTIVITY_TABLE_NAME);
        dab.execSQL("DROP TABLE IF EXISTS " + ACTIVITY_LOGGED_TABLE_NAME);
        dab.execSQL("DROP TABLE IF EXISTS " + ACTIVITY_REVIEWED_TABLE_NAME);

        //then create new tables
        onCreate(dab);

    }

    /*
        --------DATABASE OPERATIONS---------
     */

    //USER
    //Creating a user
    public long createUser(User user) {
        SQLiteDatabase dab = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, user.getName());
        contentValues.put(COL_AGE, user.getAge());
        contentValues.put(COL_USES_MONTH, user.getUsesMonth());
        contentValues.put(COL_USES, user.getUses());

        long user_id = dab.insert(USER_TABLE_NAME, null, contentValues);
        return user_id;
    }


    //retrieve a user
    public User getUser(long user_id) {

        SQLiteDatabase dab = this.getReadableDatabase();

        String userSelect = "SELECT * FROM " + USER_TABLE_NAME + " WHERE " + COL_ID + " = " +
                user_id;

        Cursor cursor = dab.rawQuery(userSelect, null);

        User user = new User();
        user.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
        user.setName(cursor.getString(cursor.getColumnIndex(COL_NAME)));
        user.setAge(cursor.getInt(cursor.getColumnIndex(COL_AGE)));
        user.setCreatedAt(cursor.getString(cursor.getColumnIndex(COL_CREATED_AT)));
        user.setUsesThisMonth(cursor.getInt(cursor.getColumnIndex(COL_USES_MONTH)));
        user.setUses(cursor.getInt(cursor.getColumnIndex(COL_USES)));

        cursor.close();
        return user;
    }


    //retrieve all users
    public List<User> getAllUsers() {

        SQLiteDatabase dab = this.getReadableDatabase()

        List<User> allUsers = new ArrayList<User>();
        String userSelect = "SELECT * FROM " + USER_TABLE_NAME;

        Cursor cursor = dab.rawQuery(userSelect, null);

        if(cursor.moveToFirst()) {

            do {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                user.setName(cursor.getString(cursor.getColumnIndex(COL_NAME)));
                user.setAge(cursor.getInt(cursor.getColumnIndex(COL_AGE)));
                user.setCreatedAt(cursor.getString(cursor.getColumnIndex(COL_CREATED_AT)));
                user.setUsesThisMonth(cursor.getInt(cursor.getColumnIndex(COL_USES_MONTH)));
                user.setUses(cursor.getInt(cursor.getColumnIndex(COL_USES)));
            } while (cursor.moveToNext());
        }
        cursor.close();

        return allUsers;
    }




}