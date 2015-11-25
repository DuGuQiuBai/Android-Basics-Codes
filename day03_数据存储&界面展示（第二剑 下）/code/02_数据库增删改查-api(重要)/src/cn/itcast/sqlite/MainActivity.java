package cn.itcast.sqlite;

import android.R.id;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	/**
	 * 往数据库的表插入一条数据
	 * 
	 * @param v
	 */
	public void insert(View v) {
		// 1. 在内存中创建一个数据库帮助类的对象
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. 在手机上生成数据库文件
		SQLiteDatabase db = helper.getWritableDatabase();
		// db.execSQL("insert into stu (name,num) values (?,?)", new Object[] {
		// "linqingxia", 28 });

		ContentValues values = new ContentValues();
		values.put("name", "风清扬");
		values.put("num", "10086");
		/*
		 * table :表名 nullColumnHack:默认会添加一个NULL，一般写个null就行了 values
		 * ：ContentValues类似map集合
		 */
		long res = db.insert("stu", null, values);
		if (res != -1) {
			Toast.makeText(this, "插入成功 ：" + res, 0).show();
		} else {
			Toast.makeText(this, "插入失败 ：" + res, 0).show();
		}
		// 重要，释放资源
		db.close();
	}

	/**
	 * 删除数据库表的数据
	 */
	public void delete(View v) {
		// 1. 在内存中创建一个数据库帮助类的对象
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. 在手机上生成数据库文件
		SQLiteDatabase db = helper.getWritableDatabase();
		// db.execSQL("delete from stu");
		/*
		 * table ：表名 whereClause：where条件 whereArgs：查询参数
		 */
		int res = db.delete("stu", null, null);
		if (res > 0) {
			Toast.makeText(this, "succ:" + res, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "err", Toast.LENGTH_SHORT).show();
		}

		// 重要，释放资源
		db.close();
	}

	/**
	 * 修改数据库表的数据
	 */
	public void update(View v) {
		// 1. 在内存中创建一个数据库帮助类的对象
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. 在手机上生成数据库文件
		SQLiteDatabase db = helper.getWritableDatabase();
		// db.execSQL("update stu set name=?", new Object[] { "yadan" });
		/*
		 * table :表名 values ：ContentValues类似map集合 whereClause：where条件
		 * whereArgs：查询参数
		 */
		ContentValues values = new ContentValues();
		values.put("name", "lisi");

		int res = db.update("stu", values, null, null);
		if (res > 0) {
			Toast.makeText(this, "succ:" + res, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "err", Toast.LENGTH_SHORT).show();
		}
		// 重要，释放资源
		db.close();
	}

	/**
	 * 查询数据库表的数据
	 * 
	 * @param v
	 */
	public void query(View v) {
		// 1. 在内存中创建一个数据库帮助类的对象
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. 在手机上生成数据库文件
		SQLiteDatabase db = helper.getReadableDatabase();

		// Cursor cursor = db.rawQuery("select * from stu", null);
		/*
		 * table :表名 columns ：要查询的列 selection：查询条件 selectionArgs：查询参数 groupBy
		 * ：分组 having ：条件 orderBy ：排序 limit ：限制条件
		 */
		Cursor cursor = db.query("stu", new String[] { "num", "name", "_id" },
				null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(2);
			String name = cursor.getString(1);
			String num = cursor.getString(0);

			System.out.println("======");
			System.out.println("id:" + id + "  name:" + name + " num:" + num);
		}
		// 重要，释放
		cursor.close();
		// 重要，释放资源
		db.close();
	}
}
