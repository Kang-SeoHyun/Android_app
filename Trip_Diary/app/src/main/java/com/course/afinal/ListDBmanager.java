package com.course.afinal;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ListDBmanager extends SQLiteOpenHelper {

    static final String TRAVEL_DB = "Travel.db";
    static final String TRAVEL_TABLE = "Travels";
    Context context = null;
    private static ListDBmanager dbManager = null;

    static final String CREATE_DB = " CREATE TABLE " + TRAVEL_TABLE + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + " name TEXT NOT NULL, explainn TEXT NOT NULL , latitude TEXT NOT NULL, longitude TEXT NOT NULL);";

    public static ListDBmanager getInstance(Context context) {
        if(dbManager == null) {
            dbManager = new ListDBmanager(context, TRAVEL_DB, null, 1);
        }
        return dbManager;
    }

    public ListDBmanager(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);
        this.context = context;
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS tableName");
        onCreate(db);

    }


    public long insert(ContentValues addValue)
    {
        return getWritableDatabase().insert(TRAVEL_TABLE, null, addValue);
    }

    public Cursor query(String [] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
    {
        return getReadableDatabase().query(TRAVEL_TABLE, columns, selection, selectionArgs, groupBy, having, orderBy);
    }

    public int delete(String whereClause, String[] whereArgs)
    {
        return getWritableDatabase().delete(TRAVEL_TABLE, whereClause, whereArgs);
    }
}