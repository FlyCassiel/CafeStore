package cn.cafe.store.Vo;
/**
 * 购物车值对象的实体类
 * 购物车实体类依然存在了
 * 创建购物车中所需要的商品信息的值对象
 * @author 刘飞
 *
 */
public class CartVo {
	private Integer id;
	private Integer goodsid;
    private String image;
    private String title;
    private Integer price;
    private Integer count;
    private String taste;
	public CartVo(Integer id, Integer goodsid, String image, String title, Integer price, Integer count, String taste) {
		super();
		this.id = id;
		this.goodsid = goodsid;
		this.image = image;
		this.title = title;
		this.price = price;
		this.count = count;
		this.taste = taste;
	}
	public CartVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CartVo [id=" + id + ", goodsid=" + goodsid + ", image=" + image + ", title=" + title + ", price="
				+ price + ", count=" + count + ", taste=" + taste + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
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
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
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
		CartVo other = (CartVo) obj;
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
