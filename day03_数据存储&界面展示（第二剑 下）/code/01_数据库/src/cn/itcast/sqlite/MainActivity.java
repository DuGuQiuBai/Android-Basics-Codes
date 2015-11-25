package cn.itcast.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

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
		db.execSQL("insert into stu (name,num) values (?,?)", new Object[] {
				"linqingxia", 28 });
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
		db.execSQL("delete from stu");
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
		db.execSQL("update stu set name=?", new Object[] { "yadan" });
		// 重要，释放资源
		db.close();
	}
	/**
	 * 查询数据库表的数据
	 * @param v
	 */
	public void query(View v) {
		// 1. 在内存中创建一个数据库帮助类的对象
		MyDbOpenHelper helper = new MyDbOpenHelper(this);
		// 2. 在手机上生成数据库文件
		SQLiteDatabase db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from stu", null);
		while (cursor.moveToNext()) {
			int id = cursor.getInt(0);
			String name = cursor.getString(1);
			String num = cursor.getString(2);
			System.out.println("======");
			System.out.println("id:" + id + "  name:" + name + " num:" + num);
		}

		// 重要，释放资源
		db.close();
	}
}
