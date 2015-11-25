package cn.itcast.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 1. 创建一个类继承SQLiteOpenHelper
 * 
 */
public class MyDbOpenHelper extends SQLiteOpenHelper {
	private static final String TAG="MyDbOpenHelper";

	/**
	 * 数据库帮助类的构造方法
	 * @param context 上下文
	 * @param name	    数据库的名字
	 * @param factory null
	 * @param version 数据库的版本号  >=1
	 */
	public MyDbOpenHelper(Context context) {
		super(context, "student.db", null,4);
	}
	
	/**
	 * 第一次创建数据库时执行，适合创建数据库的表
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i(TAG,"数据库第一次创建了，onCreate（）方法执行了！！！");
		
		db.execSQL("create table stu(_id integer primary key autoincrement, name varchar(20),num varchar(20))");
	}

	/**
	 * 数据库升级了
	 * 修改表
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i(TAG, "数据库升级了，onUpgrade()执行了");
		db.execSQL("alter table stu add sex varchar(20)");
	}

}
