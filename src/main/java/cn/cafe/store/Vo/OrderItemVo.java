package cn.cafe.store.Vo;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
public class OrderItemVo implements Serializable{
	private static final long serialVersionUID = 5149067438536727864L;
	private Integer orderid;
    private Integer orderitemId;
    private Date tradetime;
    private String image;
    private String title;
    private Integer price;
    private Integer count;
    private Integer paymentstatus;
    private Integer  orderstatus;
    //实现日期的格式化
    private String showTime;
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public OrderItemVo(Integer orderid, Integer orderitemId, Date tradetime, String image, String title, Integer price,
			Integer count, Integer paymentstatus, Integer orderstatus) {
		super();
		this.orderid = orderid;
		this.orderitemId = orderitemId;
		this.tradetime = tradetime;
		this.image = image;
		this.title = title;
		this.price = price;
		this.count = count;
		this.paymentstatus = paymentstatus;
		this.orderstatus = orderstatus;
	}
	public OrderItemVo() {
		super();
	}
	@Override
	public String toString() {
		return "OrderItemVo [orderid=" + orderid + ", orderitemId=" + orderitemId + ", tradetime=" + tradetime
				+ ", image=" + image + ", title=" + title + ", price=" + price + ", count=" + count + ", paymentstatus="
				+ paymentstatus + ", orderstatus=" + orderstatus + "]";
	}
	public Integer getOrderid() {
		return orderid;
	}
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}
	public Integer getOrderitemId() {
		return orderitemId;
	}
	public void setOrderitemId(Integer orderitemId) {
		this.orderitemId = orderitemId;
	}
	public Date getTradetime() {
		return tradetime;
	}
	public void setTradetime(Date tradetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		showTime = sdf.format(tradetime);
		this.tradetime = tradetime;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(Integer paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	public Integer getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}
    
}
