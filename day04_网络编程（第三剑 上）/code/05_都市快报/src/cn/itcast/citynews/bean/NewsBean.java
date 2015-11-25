package cn.itcast.citynews.bean;

/**
 * 新闻条目的JavaBean
 */
public class NewsBean {

	private String title;
	private String des;
	private String image;
	private String comment;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "NewsBean [title=" + title + ", des=" + des + ", image=" + image
				+ ", comment=" + comment + "]";
	}
	
	
}
