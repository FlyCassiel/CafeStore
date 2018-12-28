package cn.cafe.store.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * 商品详情实体类
 * @author 刘飞
 *
 */
public class Goods implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer categoryId;
	private String itemType;
	private String title;
	private String sellPoint;
	private Double price;
	private Integer num;
	private String brand;
	private String place;
	private String image;
	private Integer isHot;
	private Integer isSale;
	private Integer status;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
	private String taste;
	public Goods(Integer id, Integer categoryId, String itemType, String title, String sellPoint, Double price,
			Integer num, String brand, String place, String image, Integer isHot, Integer isSale, Integer status,
			Date createdTime, Date modifiedTime, String createdUser, String modifiedUser, String taste) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.itemType = itemType;
		this.title = title;
		this.sellPoint = sellPoint;
		this.price = price;
		this.num = num;
		this.brand = brand;
		this.place = place;
		this.image = image;
		this.isHot = isHot;
		this.isSale = isSale;
		this.status = status;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.createdUser = createdUser;
		this.modifiedUser = modifiedUser;
		this.taste = taste;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", categoryId=" + categoryId + ", itemType=" + itemType + ", title=" + title
				+ ", sellPoint=" + sellPoint + ", price=" + price + ", num=" + num + ", brand=" + brand + ", place="
				+ place + ", image=" + image + ", isHot=" + isHot + ", isSale=" + isSale + ", status=" + status
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", createdUser=" + createdUser
				+ ", modifiedUser=" + modifiedUser + ", taste=" + taste + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSellPoint() {
		return sellPoint;
	}
	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getIsHot() {
		return isHot;
	}
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	public Integer getIsSale() {
		return isSale;
	}
	public void setIsSale(Integer isSale) {
		this.isSale = isSale;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
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
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((createdTime == null) ? 0 : createdTime.hashCode());
		result = prime * result + ((createdUser == null) ? 0 : createdUser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((isHot == null) ? 0 : isHot.hashCode());
		result = prime * result + ((isSale == null) ? 0 : isSale.hashCode());
		result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
		result = prime * result + ((modifiedTime == null) ? 0 : modifiedTime.hashCode());
		result = prime * result + ((modifiedUser == null) ? 0 : modifiedUser.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((sellPoint == null) ? 0 : sellPoint.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((taste == null) ? 0 : taste.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Goods other = (Goods) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (createdTime == null) {
			if (other.createdTime != null)
				return false;
		} else if (!createdTime.equals(other.createdTime))
			return false;
		if (createdUser == null) {
			if (other.createdUser != null)
				return false;
		} else if (!createdUser.equals(other.createdUser))
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
		if (isHot == null) {
			if (other.isHot != null)
				return false;
		} else if (!isHot.equals(other.isHot))
			return false;
		if (isSale == null) {
			if (other.isSale != null)
				return false;
		} else if (!isSale.equals(other.isSale))
			return false;
		if (itemType == null) {
			if (other.itemType != null)
				return false;
		} else if (!itemType.equals(other.itemType))
			return false;
		if (modifiedTime == null) {
			if (other.modifiedTime != null)
				return false;
		} else if (!modifiedTime.equals(other.modifiedTime))
			return false;
		if (modifiedUser == null) {
			if (other.modifiedUser != null)
				return false;
		} else if (!modifiedUser.equals(other.modifiedUser))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (sellPoint == null) {
			if (other.sellPoint != null)
				return false;
		} else if (!sellPoint.equals(other.sellPoint))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (taste == null) {
			if (other.taste != null)
				return false;
		} else if (!taste.equals(other.taste))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
}
