package cn.itcast.fragmentcycle;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    private Fragment01 fragment01;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //1.创建Fragment对象
        fragment01 = new Fragment01();
    	//2.获取Fragment管理器
    	FragmentManager fm = getFragmentManager();
    	//3.打开事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//4.设置显示fragment01
    	//arg0:容器的id，也就是帧布局
    	ft.replace(R.id.fl, fragment01);
    	//5.提交
    	ft.commit();
    }


    public void click1(View v){
    	//显示fragment01
    	//2.获取Fragment管理器
    	FragmentManager fm = getFragmentManager();
    	//3.打开事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//4.设置显示fragment01
    	//arg0:容器的id，也就是帧布局
    	ft.replace(R.id.fl, fragment01);
    	//5.提交
    	ft.commit();
    }
    
    public void click2(View v){
    	//显示fragment02
    	//1.创建Fragment对象
    	Fragment02 fragment02 = new Fragment02();
    	//2.获取Fragment管理器
    	FragmentManager fm = getFragmentManager();
    	//3.打开事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//4.设置显示fragment02
    	//arg0:容器的id，也就是帧布局
    	ft.replace(R.id.fl, fragment02);
    	//5.提交
    	ft.commit();
    }
    
    public void click3(View v){
    	//显示fragment03
    	//1.创建Fragment对象
    	Fragment03 fragment03 = new Fragment03();
    	//2.获取Fragment管理器
    	FragmentManager fm = getFragmentManager();
    	//3.打开事务
    	FragmentTransaction ft = fm.beginTransaction();
    	//4.设置显示fragment03
    	//arg0:容器的id，也就是帧布局
    	ft.replace(R.id.fl, fragment03);
    	//5.提交
    	ft.commit();
    }
    2015/6/14
}
