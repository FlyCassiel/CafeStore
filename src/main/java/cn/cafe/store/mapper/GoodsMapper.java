package cn.cafe.store.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Goods;
import cn.cafe.store.bean.Images;

public interface GoodsMapper {
	/**
	 * 根据CategoryId查询到商品
	 * @param CategoryId
	 * @param offset
	 * @param count
	 * @return
	 */
    List<Goods> getGoodsByCategoryId(
    		@Param("categoryId") Integer categoryId,
    		@Param("offset") Integer offset,
    		@Param("count") Integer count);
    
    /**
     * 通过商品id查询所有的图片
     * @param ProductId
     * @return
     */
    List<Images> getImagesByProductId(Integer productId);
    /**
     * 根据categoryId查询有多少条记录
     * @param categoryId
     * @return
     */
    Integer getCount(Integer categoryId);
    
    /**
	 * 通过title查询商品
	 * @param title  
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByTitle(
			@Param("title") String title,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	
	/**
	 * 获取title的记录数
	 * @param title
	 * @param offset
	 * @param count
	 * @return
	 */
	Integer getCountByTitle(@Param("title") String title);
	
	/**
	 * 通过id获取商品信息
	 * @param id
	 * @return
	 */
	Goods getGoodsById(Integer id);
	/**
	 * 查询热卖产品
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getHotGoods(
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * 查询促销产品
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getSaleGoods(
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * 查询雀巢产品
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getquechaoGoods(
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * 商品的立即支付功能 通过商品详情表直接到确定支付功能。
	 * @param id
	 * @return
	 */
	List<CartVo> getcartVoById(Integer id);
	/*----------------------后台的展示商品信息----------------------------*/
	/**
	 * 得到所有的商品信息
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoods(
			@Param("offset") Integer offset,
    		@Param("count") Integer count);
	/**
	 * 得到所有商品的数量
	 * @return
	 */
	Integer getAllCount();
	/**
	 * 根据商品id删除商品信息
	 * @return
	 */
	Integer delete(Integer id);
	/**
	 * 修改商品信息
	 * @param goods
	 * @return
	 */
	Integer updateAdmin(Goods goods);
	/**
	 * 添加商品信息
	 * @param goods
	 * @return
	 */
	Integer insertGoodsAdmin(Goods goods);
}
