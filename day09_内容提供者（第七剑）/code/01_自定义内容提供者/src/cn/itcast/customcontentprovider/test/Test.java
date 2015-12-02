package cn.itcast.customcontentprovider.test;

import cn.itcast.customcontentprovider.db.MyOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

public class Test extends AndroidTestCase {

	public void test(){
		MyOpenHelper oh = new MyOpenHelper(getContext());
		SQLiteDatabase db = oh.getWritableDatabase();
	}
}
