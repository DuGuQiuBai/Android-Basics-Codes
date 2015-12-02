package cn.itcast.customcontentprovider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	public MyOpenHelper(Context context) {
		super(context, "People.db", null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table person(_id integer primary key autoincrement, name char(10), money integer(20))");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("create table handsome(_id integer primary key autoincrement, name char(10))");

	}

}
