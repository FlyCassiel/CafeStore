package cn.cafe.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Goods;
import cn.cafe.store.bean.Images;
import cn.cafe.store.iservice.IGoodsService;
import cn.cafe.store.mapper.GoodsMapper;

/**
 * 商品服务层实现类
 * @author 刘飞
 *
 */
@Service
public class GoodsServcie implements IGoodsService{
	@Resource
	private GoodsMapper goodsMapper;
	/**
	 * 通过父级id获得goods集合
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
		return goodsMapper.getGoodsByCategoryId(categoryId, offset, count);
	}
	/**
	 * 通过商品id获得images集合
	 */
	public List<Images> getImagesByProductId(Integer productId) {
		return goodsMapper.getImagesByProductId(productId);
	}
	/**
	 * 获得父类id下的所有商品的数量
	 * @param categoryId
	 * @return
	 */
	public Integer getCount(Integer categoryId) {
		return goodsMapper.getCount(categoryId);
	}
	/**
	 * 通过标题去查询获取goods集合
	 * @param title
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Goods> getGoodsByTitle(String title, Integer offset, Integer count) {
		return goodsMapper.getGoodsByTitle(title, offset, count);
	}
	
	/**
	 * 获取记录数
	 */
	public Integer getCountByTitle(String title) {
		return goodsMapper.getCountByTitle(title);
	}
	
	/**
	 * 通过id获取商品信息
	 */
	public Goods getGoodsById(Integer id) {
		return goodsMapper.getGoodsById(id);
	}
	/**
	 * 查询热卖商品
	 */
	public List<Goods> getHotGoods(Integer offset, Integer count) {
		return goodsMapper.getHotGoods(offset, count);
	}
	/**
	 * 查询促销产品
	 */
	public List<Goods> getSaleGoods(Integer offset, Integer count) {
		return goodsMapper.getSaleGoods(offset, count);
	}
	/**
	 *查询雀巢产品
	 */
	public List<Goods> getquechaoGoods(Integer offset, Integer count) {
		return  goodsMapper.getquechaoGoods(offset, count);
	}
	/**
	 * 商品的立即支付功能 通过商品详情表直接到确定支付功能。
	 * @param id
	 * @return
	 */
	public List<CartVo> getcartVoById(Integer id) {
		return goodsMapper.getcartVoById(id);
	}
	/*----------------------后台的展示商品信息----------------------------*/
	/**
	 * 得到所有的商品信息
	 */
	public List<Goods> getGoods(Integer offset, Integer count) {
		return goodsMapper.getGoods(offset, count);
	}
	/**
	 * 得到所有商品的数量
	 */
	public Integer getAllCount() {
		return goodsMapper.getAllCount();
	}
	/**
	 * 根据商品id删除商品信息
	 */
	public Integer delete(Integer id) {
		return goodsMapper.delete(id);
	}
	/**
	 * 修改商品信息
	 */
	public Integer updateAdmin(Goods goods) {
		return goodsMapper.updateAdmin(goods);
	}
	/**
	 * 添加商品信息
	 */
	public Integer insertGoodsAdmin(Goods goods) {
		return goodsMapper.insertGoodsAdmin(goods);
	}
	
}
