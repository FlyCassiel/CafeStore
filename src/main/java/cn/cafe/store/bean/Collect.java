package cn.cafe.store.bean;

import java.io.Serializable;

/**
 * 收藏夹实体类
 * @author 刘飞
 *
 */
public class Collect implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userid;
	private Integer goodsid;
	private Integer count;
	private String title;
	private Double price;
	private String image;
	private Integer status;
	public Collect(Integer id, Integer userid, Integer goodsid, Integer count, String title, Double price, String image,
			Integer status) {
		super();
		this.id = id;
		this.userid = userid;
		this.goodsid = goodsid;
		this.count = count;
		this.title = title;
		this.price = price;
		this.image = image;
		this.status = status;
	}
	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", userid=" + userid + ", goodsid=" + goodsid + ", count=" + count + ", title="
				+ title + ", price=" + price + ", image=" + image + ", status=" + status + "]";
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Collect other = (Collect) obj;
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
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	

}
