package cn.itcast.alipay;

import cn.itcast.alipay.PayInterface.Stub;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;

public class PayService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return new PayMoney();
	}

	class PayMoney extends Stub{

		@Override
		public void pay() throws RemoteException {
			PayService.this.pay();
			
		}
		
	}
	
	private void pay() {
		System.out.println("检测运行环境");
		System.out.println("加密账号密码");
		System.out.println("建立网络连接");
		System.out.println("发送账号密码");
		System.out.println("完成支付");

	}
}
