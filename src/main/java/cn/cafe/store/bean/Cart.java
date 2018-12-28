package cn.cafe.store.bean;

import java.io.Serializable;

/**
 * 购物车实体类
 * @author 刘飞
 *
 */
public class Cart implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userid;
	private Integer goodsid;
	private Integer count;
	private String taste;
	public Cart(Integer id, Integer userid, Integer goodsid, Integer count, String taste) {
		super();
		this.id = id;
		this.userid = userid;
		this.goodsid = goodsid;
		this.count = count;
		this.taste = taste;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userid=" + userid + ", goodsid=" + goodsid + ", count=" + count + ", taste="
				+ taste + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((goodsid == null) ? 0 : goodsid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((taste == null) ? 0 : taste.hashCode());
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
		Cart other = (Cart) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (goodsid == null) {
			if (other.goodsid != null)
				return false;
		} else if (!goodsid.equals(other.goodsid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (taste == null) {
			if (other.taste != null)
				return false;
		} else if (!taste.equals(other.taste))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
}
