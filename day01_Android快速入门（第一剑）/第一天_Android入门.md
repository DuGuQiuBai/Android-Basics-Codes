
##Android入门
搭建Android开发环境、Android应用开发的步骤

#什么是Android
-----
### 1 手机通讯制式（1G-4G的介绍）

	G:Generation 时代;
	1G:使用模拟信号,信号不稳定;

	2G:使用GSM/CDMA,增加了发送短信的功能;
		2.5G:使用的EDGE,提高了网速,网速仍然很慢.

	3G:使用TD-SCDMA/WCDMA/CDMA2000,在线看视频网络卡;
	
	4G:使用TD-LTE/FDD-LTE(LTE:Long Term Evolution 长期演变)
### 2 Android操作系统介绍 

	Android是有安迪.鲁宾开发
	名称来源于游戏中的打瓢虫
	图标来源于厕所

### 3 Android历史&版本

	Android2.3.3  安卓2.0后最稳定的版本				API:10
	Android3.0    增加了新特性，针对平板电脑的系统
	Android 4.1.2 安卓4.0后最稳定的版本				API:16

### 4 Android系统四层架构
分为4层：

	1. 应用程序层:安装在手上的软件都属于这一层	
	2. 程序框架层:开发程序调用的API都在这一层	
	3. 基础类库层:第三方开源的框架,dvm	
	4. linux kernel:各种驱动

### 5 两种虚拟机的不同（重点）

区别:

	jvm和dvm加载的文件类型不同:jvm加载的是.jar,dvm加载的是.dex;
	jvm:java--javac--.class-- jar--.jar;
	dvm:java--javac--.class--dx--.dex--.odex;
		
### 6 ART模式

	dvm运行软件时,一遍把字节码编译成机器码,然后在运行

	ART:在安装软件时,就把字节码预编译成机器码,然后存储到一个地方,在运行时,就不需要再去编译机器码了
	使用art模式开机速度和软件运行的速度快

#搭建Android开发环境
-----
### 7 搭建Android开发环境

1. Eclipse+ADT（ADT Android Developer Tools 安卓开发工具，Eclipse的插件） 
			
		1.安装JDK:
			如果电脑操作系统是32位就安装32位JDK.如果电脑操作系统是64位就安装64位JDK
	
		2.获得开发工具adt-bundle(Android develop tool bundle安卓的开发工具集)

2. Android Studio
	- 对硬件要求高

### 8 SDK的目录结构
Standard Developer Kits  标准的开发工具包

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
	>实例代码（了解）
* source
	>源代码 （了解）
* system-image
	>系统镜像 
* tools
	>开发工具（了解）

### 9 模拟器
Android Virtual Device  模拟器

	手机屏幕分辨率：
	VGA   640*480 (Video Graphics Array)
	QVGA  320*240 (Quarter VGA)
	HVGA  480*320 (Half-size VGA)
	SVGA  800*600 (Super VGA)
	WVGA  800*480 (Wide VGA)
	FWVGA 854*480 (Full Wide VGA)

### 10 Android工程的目录结构
* src 
	> 源代码 
* gen
	> 工具自动生成的代码
	>BUildconfig 调试的开关 默认开启
	>R.java 很多的静态的内部类
* android.jar 
	>开发用的jar包
* android dependence
	> 依赖，向下兼容的依赖jar包
* assets 
	>资产目录 存放一些别的类型的文件
* bin
	>eclipse工具编译的文件夹
* libs
	>应用程序开发用的jar包
* res
	>应用程序的资源
* androidmanifest.xml 
	> 清单文件
	
### 11 Eclipse打包安装应用的过程
1. 生成apk文件.

		1.1 把classes中的字节码文件打包通过命令dx.bat打包成一个classes.dex.
		1.2 resources.arsc文件的生成.
		1.3 未编译的资源文件.
		1.4 把清单文件AndroidManifest.xml文件转换成二进制文件.
		1.5 把以上生成的文件打包成一个压缩包(.apk)

2. 把apk文件上传到手机上

3. 安装apk应用程序
	- 创建一个文件夹/data/data/包名, 用于存放当前应用程序数据.

### 12 常见的adb指令
Android Debug Bridge 安卓调试桥
连接模拟器和Eclipse的工具

* adb devices
	> 查看设备

* adb install <xxx.apk>
	> 安装一个apk -r 覆盖安装

* adb uninstall <包名>
	> 卸载一个apk，包名是应用程序的唯一标示，一个手机里面不可能有两个应用程序包名相同。

* adb shell 	


#Android应用程序开发
-----	
### 13 Android应用程序开发的步骤（重要）
1. 产品经理给需求
2. UI给切图，UI设计图
3. 开发，写代码

		1.在xml里面写UI布局
		2.在activity中写代码，打架子
		3.写具体的业务
4. 测试

### 14  点击事件的四种写法（重要）
1. 匿名内部类的方式

		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("你点击了按钮！！！");
				
			}
		});

	简单点击事件的实现 一般都用匿名内部类

2. 内部类的方式

		btn.setOnClickListener(new MyOnClickListener());
	
		private class MyOnClickListener implements OnClickListener{
			public void onClick(View v) {
			System.out.println("内部类的方式,点击按钮");
			}
		}
3. 当前的activity  implements OnClickListener{}

			btn1.setOnClickListener(this);
			public void onClick(View v) {
			System.out.println("你点击按钮！！！");
			int id = v.getId();
			switch (id) {
			case R.id.button1: //按钮1
				System.out.println("你点击了按钮1");
				break;
			case R.id.button2: //按钮2
				System.out.println("你点击了按钮2");
				break;
			default:
				break;
			}
			}
	应用场景：界面上按钮比较多的时候，代码的可读性高

4. onClick属性

		public void click(View view){
			System.out.println("4. 点击按钮");
		}

	应用场景：上课采用这种方式，开发中不建议使用

### 15 五中常见ui布局（重要）
	1. 线性布局 LinearLayout	
		 重要属性 android:orientation="horizontal" 水平排列
		 android:orientation="vertical" 垂直排列
		 android:layout_width="0dip"
		 android:layout_weight="1" 权重

	2. 相对布局 RelativeLayout	
		原理：向前看，相对于某个控件的位置

	3. 绝对布局 AbsoluteLayout	
		过时了，不推荐使用  
		应用场景：机顶盒开发常见

	4. 表格布局 TableLayout			
		应用场景：办公类的软件

	5. 帧布局 FrameLayout	
		应用场景：一个控件浮在另一个控件的上方


### 16 常见单位
	dip dp：控件的宽高用
	sp	  ：字体的大小用
