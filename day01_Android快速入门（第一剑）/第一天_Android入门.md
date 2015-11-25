
#Android入门

##1 Android历史&版本

Android 2.3.3  2.0以后最稳定的一个版本  API:10
Android 3.0	   专门给平板设计的一个系统
Android 4.1.2  4.0以后最稳定的一个版本  API:16

##2 Android系统四层架构
1. Application：应用层  在这一层做开发，写Java代码
2. Application framework：是Android的一些api
3. Lib：使用C， C++写的代码，Application framework通过JNI调用
4. Linux：驱动，操作手机硬件

##3 搭建Android开发环境
1. Eclipse+ADT
	- Android Developer Tools   Android开发工具，Eclipse的插件
		最新23.xxx   21.xxx
	
2. Android studio

##4 SDK的目录结构
Standard Developer Kits  安卓标准开发工具包

* add-ons
	>附加组件，放在一个额外的工具。google api，提供google地图的jar包
* build-tools
	>编译工具，谷歌sdk升级后采用的目录
* docs
	>文档目录。开发文档。（了解）
* extras 
	>附加工具 support 文件夹，提供向下兼容的jar包。
	>和额外的驱动，摄像头驱动，手机驱动
* platform 
	>开发平台（了解）
* platform tools
	>开发的工具
* sample
	>实例代码
* source
	>源代码 （了解）
* system-image
	>系统镜像 
* tools
	>开发工具

##5 模拟器
AVD:Android virtual Devices 模拟器

分辨率：

		VGA   640*480 	(Video Graphics Array)
		QVGA  320*240 	(Quarter VGA)
		HVGA  480*320 	(Half-size VGA)
		SVGA  800*600	 (Super VGA)
		WVGA  800*480 	(Wide VGA)
		FWVGA 854*480 (Full Wide VGA)

RAM:运行内存  
ROM：储存空间 硬盘

##6 Android工程的目录结构
* add-ons
	>附加组件，放在一个额外的工具。google api，提供google地图的jar包
* build-tools
	>编译工具，谷歌sdk升级后采用的目录
* docs
	>文档目录。开发文档。（了解）
* extras 
	>附加工具 support 文件夹，提供向下兼容的jar包。
	>和额外的驱动，摄像头驱动，手机驱动
* platform 
	>开发平台（了解）
* platform tools
	>开发的工具
* sample
	>实例代码
* source
	>源代码 （了解）
* system-image
	>系统镜像 
* tools
	>开发工具


##7 Eclipse打包安装应用的过程
1. Eclipse打包apk文件
	- javac.exe把.java文件编译成.class
	- dx.bat把.class文件打包到.dex
		\sdk\platform-tools
	- 把.dex文件，res目录和清单文件打包到.apk文件

2. 把apk安装包上传到手机上或者模拟器上
3. 安装apk包

##8 常见的adb指令
Android  Debug Bridge  安卓调试桥

adb devices 列出所有的设备

adb install <应用程序(加扩展名)> 	安装应用程序

adb uninstall <包名>  卸载应用程序

##9 Android应用程序开发的步骤（重要）
1. 产品经理给需求，Ui给设计
2. 开发应用程序
	1. 写UI布局
	2. 写java 代码
3. 测试

##10  点击事件的四种写法（重要）
1. 内部类

		/**
		 * OnClickListener接口的一个实现类
		 * 
		 * 内部类
		 */
		class MyListener implements OnClickListener {
			// 点击按钮调用
			@Override
			public void onClick(View v) {
				System.out.println("您点击了按钮");
	
				// 意图 打 电话 泡 妞 打 酱油
				// 1. 初始化一个意图
				Intent intent = new Intent();
				// 2. 设置动作
				intent.setAction(Intent.ACTION_CALL);
				// 3. 设置数据
				// Url统一资源定位符 http://www.baidu.com < Uri 统一资源标识符 chuangzhi://04/班长
				Uri data = Uri.parse("tel://110");
				intent.setData(data);
				// 4. 激活意图
				startActivity(intent);
			}
	
			}
2. 匿名内部类

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 意图 打 电话 泡 妞 打 酱油
				// 1. 初始化一个意图
				Intent intent = new Intent();
				// 2. 设置动作
				intent.setAction(Intent.ACTION_CALL);
				// 3. 设置数据
				// Url统一资源定位符 http://www.baidu.com < Uri 统一资源标识符
				// chuangzhi://04/班长
				Uri data = Uri.parse("tel://110");
				intent.setData(data);
				// 4. 激活意图
				startActivity(intent);
			}
		});
3. 让当前的MainActivity实现OnClickListener接口

			btn1.setOnClickListener(this);

			//点击按钮调用
			@Override
			public void onClick(View v) {
				System.out.println("哥，您点击了按钮！！！");
				int id = v.getId();
				switch (id) {
				case R.id.btn1:
					System.out.println("1111");
					break;
				case R.id.btn2:
					System.out.println("2222");
					break;
				case R.id.btn3:
					System.out.println("3333");
					break;
				default:
					break;
				}
			}
应用场景：界面上按钮很多的时候用，代码简洁

4.在布局文件中添加android:onClick="click1"属性
	
		public  void click1(View view){
			System.out.println("我是第四种方式");
		} 
应用场景：上课中用，不建议在开发中使用

##11 五中常见ui布局（重要）
1. 线性布局：LinearLayout
2. 相对布局：RelativeLayout
3. 帧布局：  FrameLayout
4. 表格布局：TableLayout
	应用场景：办公类软件

5. 绝对布局：（已经被google废弃了，不建议使用）

	应用场景：机顶盒开发
