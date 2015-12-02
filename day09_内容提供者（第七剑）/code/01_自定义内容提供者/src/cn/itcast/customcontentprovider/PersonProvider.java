package cn.itcast.customcontentprovider;

import cn.itcast.customcontentprovider.db.MyOpenHelper;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PersonProvider extends ContentProvider {

	MyOpenHelper oh;
	SQLiteDatabase db;
	
	//创建一个uri匹配器，用于匹配uri
	UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);
	//给uri匹配器添加匹配规则
	{
		um.addURI("cn.itcast.person", "person", 1);//content://cn.itcast.person/person
		um.addURI("cn.itcast.person", "handsome", 2);//content://cn.itcast.person/handsome
		um.addURI("cn.itcast.person", "person/#", 3);//content://cn.itcast.person/person/2
	}
	
	//内容提供者创建时调用
	@Override
	public boolean onCreate() {
							//内容提供者运行在哪个上下文，就获取哪个上下文
		oh = new MyOpenHelper(getContext());
		db = oh.getWritableDatabase();
		return false;
	}
		
	
	//uri:内容提供者的主机名
	//values:访问者需要插入的数据
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		//如果匹配码是1，往person表插数据
		if(um.match(uri) == 1){
			//往私有数据库中插入数据
			db.insert("person", null, values);
			
			//发送通知给内容观察者
			//arg0:所有注册在这个uri上的内容观察者,都能收到这条通知
			getContext().getContentResolver().notifyChange(uri, null);
		}
		//如果匹配码是2，往handsome表插数据
		else if(um.match(uri) == 2){
			db.insert("handsome", null, values);
			getContext().getContentResolver().notifyChange(uri, null);
		}
		else{
			throw new IllegalArgumentException("你的uri有问题啊傻逼");
		}
		
		return uri;
	}
		
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int i = 0;
		if(um.match(uri) == 1){
			i = db.delete("person", selection, selectionArgs);
		}
		else if(um.match(uri) == 2){
			i = db.delete("handsome", selection, selectionArgs);
		}
		else{
			throw new IllegalArgumentException("你的uri还是有问题啊傻逼耘赫");
		}
		
		return i;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int i = db.update("person", values, selection, selectionArgs);
		return i;
	}
	
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Cursor cursor = null;
		if(um.match(uri) == 1){
			cursor = db.query("person", projection, selection, selectionArgs, null, null, sortOrder);
		}
		else if(um.match(uri) == 2){
			cursor = db.query("handsome", projection, selection, selectionArgs, null, null, sortOrder);
		}
		else if(um.match(uri) == 3){
			//把uri路径中携带的数字取出来
			long id = ContentUris.parseId(uri);
			cursor = db.query("person", projection, "_id = ?", new String[]{id + ""}, null, null, sortOrder);
		}
		else{
			throw new IllegalArgumentException("你的uri还是有问题啊");
		}
		return cursor;
	}

	@Override
	public String getType(Uri uri) {//content://cn.itcast.person/person
		if(um.match(uri) == 1){
			return "vnd.android.cursor.dir/person";
		}
		else if(um.match(uri) == 3){//content://cn.itcast.person/person/4
			return "vnd.android.cursor.item/person";
		}		
		return null;
	}

}
