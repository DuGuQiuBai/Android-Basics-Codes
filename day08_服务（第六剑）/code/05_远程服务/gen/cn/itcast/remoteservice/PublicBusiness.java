/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/fudingcheng/Documents/课程/安卓/第一阶段_Android基础/前十天/day08_广播与服务2/代码/05_远程服务/src/cn/itcast/remoteservice/PublicBusiness.aidl
 */
package cn.itcast.remoteservice;
public interface PublicBusiness extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements cn.itcast.remoteservice.PublicBusiness
{
private static final java.lang.String DESCRIPTOR = "cn.itcast.remoteservice.PublicBusiness";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an cn.itcast.remoteservice.PublicBusiness interface,
 * generating a proxy if needed.
 */
public static cn.itcast.remoteservice.PublicBusiness asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof cn.itcast.remoteservice.PublicBusiness))) {
return ((cn.itcast.remoteservice.PublicBusiness)iin);
}
return new cn.itcast.remoteservice.PublicBusiness.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_qianXian:
{
data.enforceInterface(DESCRIPTOR);
this.qianXian();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements cn.itcast.remoteservice.PublicBusiness
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void qianXian() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_qianXian, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_qianXian = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public void qianXian() throws android.os.RemoteException;
}
