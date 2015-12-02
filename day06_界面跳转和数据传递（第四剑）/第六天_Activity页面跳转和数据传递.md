
##Activity界面跳转、数据传递和生命周期


#界面跳转、数据传递
-----
###01 AndroidManifest清单文件详解

1.一个应用程序可以有多个桌面图标

2.创建桌面图标的方法如下:

		<intent-filter>
            <!-- MAIN:应用程序的入口 -->
            <action android:name="android.intent.action.MAIN" />
            <!-- LAUNCHER:应用程序的启动器 -->
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>

3.activity节点中的label标签表示桌面图标的名称

4.activity节点中的label标签表示界面的标题或者名称

5.application节点中的label标签与activity节点中的label标签不是一个概念,它表示应用程序的名称,可以在应用程序管理列表中看到

	category:BROWSABLE浏览器类型,CAR_MODE 驾驶模式;DEFAULT默认类型,通常自己写的activity都是用这个类型;
		
###02 意图设置动作激活一个新的界面（重点）

1. 初始化意图 (做一件事情的目的）

2. 设置动作(在清单文件中配置的action)

		intent.setAction("cn.itcast.multiview.SECONDACTIVITY");

3. 设置数据(在清单文件中配置的data)

		intent.setData(Uri.parse("itcast://dfds"));

4. 添加类型(在清单文件中配置的category)

		intent.addCategory("android.intent.category.DEFAULT");

5. 打开页面(打开第二个界面)

		startActivity(intent);

###03 设计意图的目的
- 作用:激活组件和传递参数

- 目的:组件之间解耦

		解耦:要求写的两个程序之间可以相互独立,又可以相互调用;

###04 意图的分类：隐式意图和显式意图（重点）
1. 隐式意图：在开启目标activity时，系统通过一组动作、数据、类别等属性去清单文件里面匹配，如果匹配到，就打开目标actvity,如果没有匹配到，就抛出异常，没有找个这个activity

		应用场景:适合开启其他应用程序中的activity
		缺点：速度慢,效率低

2. 显式意图：在开启目标activity时，直接指定activity的名称。

		步骤：
		1. 初始化意图 ,指定要打开activity的名称SecondActivity
		Intent intent = new Intent(this, SecondActivity.class);
		2. 打开目标activity
		startActivity(intent);	

	 	应用场景:适合开启本应用程序中的activity;
		优点： 速度快,效率高，代码书写简单


###05 意图传递数据（重点）

1. 基本数据类型及其数组

2. parcelable:把对象序列化到内存中

3. serializable:把对象序列化到文件中

4. bundle:类似于map的集合

5. intent:意图

###06 URI介绍
http://www.baidu.com:80/img/bd_logo1.png

	组成结构:
	1.schema:简单的理解为是协议名称,如http

	2.host:主机名,如192.168.1.100或者ip

	3.port:端口号,如8080

	4.path:路径,如image文件夹

	5.数据:数据资源,如1.jpg
	
###07 开启activity获取返回值（重点）
第一个界面跳转到第二个界面，等待第二个界面关闭时，返回给第一个界面数据

	1. 采用一种特殊的方式开启Activity
			startActivityForResult(intent, 0);
	2. 在开启的第二个Activity里面设置数据
			Intent data = new Intent();
			data.putExtra("content", content);
			setResult(0, data);
	3. 记得关闭新开启的第二个activity
			finish（）；
	4. 在第一个Activity里面，重写一个方法,获取返回的数据
			protected void onActivityResult(int requestCode, int resultCode, Intent data) {
				//data就是返回的intent，里面包含有数据
			}
	
###08 请求码和结果码的作用（重点）
- 请求码的作用:

		用来判断当前数据是从哪个界面返回的
		
- 结果码的作用:

		用来判断当前数据是从哪个界面返回的



#Activity生命周期
-----
###09 activity的生命周期（重点）

- 打开一个activity调用的方法：onCreate(),onStart(),onResume()

- 关闭一个activity调用的方法: onPause(),onStop(),onDestroy()

- 最小化一个activity调用的方法：onPause(),onStop()

- 打开一个最小化的activity调用的方法：onRestart(),onStart(),onResume()

###10 读文档查看activity的生命周期的分类

1. entire lifetime(完整的生命周期方法)：

		onCreate(),onStart(),onResume()，onPause(),onStop(),onDestory()

2. visible lifetime(可视的生命周期方法)：

		onStart(),onResume()，onPause(),onStop()

3. foreground lifetime(前台生命周期方法)：

		onResume()，onPause()

###11 横竖屏切换activity的生命周期
1. 横竖屏切换生命周期的变化:

		先关闭前一个界面,再打开一个新的界面

3. 固定Activity朝向

	 	android:screenOrientation="landscape"
		 portrait：竖向的   landscape：横向的 sensor传感器类型(自适应)

3. 当屏幕朝向变化时，使actvity不敏感变化

		 android:configChanges="orientation|screenSize|keyboardHidden"
	
###12 任务栈的概念

- 任务:做的一件事情,activity的实例对象

- 栈 :后进先出（吃完了吐出来）   队列：先进先出（吃完了拉出来）

- 任务栈：task stack 记录用户操作的行为，维护一个用户体验。打开关闭的界面
	
###13 Activity的启动模式

1. standard:标准默认模式

		打开应用的时，系统会给它创建一个默认的任务栈。开启新的activity，
		系统会把这个activity压入到任务栈的栈顶，返回退出activity,系统会把activity移除任务栈。

		应用：绝大多数默认的情况

2. singleTop:单一顶部模式

		打开activity时，系统回去任务栈的顶部查找，如果栈顶是当前activity，系统就不会创建新的activity，而是使用已经打开的activity。

		应用：浏览器书签，一个界面避免重复开启很多次

3. singleTask:单一任务模式

		打开界面创建实例，系统会去整个任务栈查找，有没有当前的任务？如果没有，则在栈顶创建一个实例任务，
		如果有，则删除当前实例任务上面的所有任务，使其位于栈顶，整个任务栈只有一个实例存在。

		应用：浏览器

4. singleInstance：单一实例模式

		前面三种都是在应用程序默认的任务栈里面。
		系统会为它单独创建一个任务栈，在单独的任务栈里面运行.

		应用：电话拨号器的通话界面
	
	




