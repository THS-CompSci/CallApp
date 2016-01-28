package com.callio.callapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by h0607265 on 1/15/2016.
 */
public class DatabaseConnection extends SQLiteOpenHelper {
    public static final String DB_NAME="Calendar";
    public static final int DB_VERSION=1;

    public DatabaseConnection(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT, email TEXT, account_create_date TEXT, active INTEGER, password_create TEXT, first_name TEXT, last_name TEXT, birthday_date TEXT);");
        db.execSQL("CREATE TABLE events(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, start_date TEXT, end_date TEXT, description TEXT, event_type TEXT, notification_buffer TEXT, user_id INTEGER, sharing_id INTEGER);");
        db.execSQL("CREATE TABLE reminders(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, date TEXT, description TEXT, location TEXT, alarm_name TEXT, active INTEGER, user_id INTEGER );");
        db.execSQL("CREATE TABLE messages(_id INTEGER PRIMARY KEY AUTOINCREMENT, sender TEXT, reciever TEXT, message TEXT, send_time TEXT, recieve_time TEXT, read_time TEXT,  );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}