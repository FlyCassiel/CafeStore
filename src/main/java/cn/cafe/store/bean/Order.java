package cn.cafe.store.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 订单实体类
 * 
 * @author 刘飞
 *
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date tradetime;
	private Integer userid;
	// 实现日期的格式化
	private String showTime;

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public Order(Integer id, Date tradetime, Integer userid) {
		super();
		this.id = id;
		this.tradetime = tradetime;
		this.userid = userid;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", tradetime=" + tradetime + ", userid=" + userid + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTradetime() {
		return tradetime;
	}

	public void setTradetime(Date tradetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		showTime = sdf.format(tradetime);
		this.tradetime = tradetime;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tradetime == null) ? 0 : tradetime.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tradetime == null) {
			if (other.tradetime != null)
				return false;
		} else if (!tradetime.equals(other.tradetime))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

}
