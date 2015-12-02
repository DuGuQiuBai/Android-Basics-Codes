package cn.itcast.banzheng;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class LeaderService extends Service{

	//返回中间人对象
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new WangMiShu();
	}

	class WangMiShu extends Binder implements PublicBusiness{
		@Override
		public void qianXian() {
			banZheng();

		}
		public void daMaJiang(){
			
		}
	}
	
	private void banZheng() {
		System.out.println("张领导帮你来办证");

	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		return super.onUnbind(intent);
	}
}
