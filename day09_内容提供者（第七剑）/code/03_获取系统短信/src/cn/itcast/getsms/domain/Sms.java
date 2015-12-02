package cn.itcast.getsms.domain;

public class Sms {

	private String address;
	private long date;
	private int type;
	private String body;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Sms(String address, long date, int type, String body) {
		super();
		this.address = address;
		this.date = date;
		this.type = type;
		this.body = body;
	}
	
	
}
