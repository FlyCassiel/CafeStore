package cn.cafe.store.iservice;

import java.awt.Image;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Goods;
import cn.cafe.store.bean.Images;


/**
 * 商品服务层接口
 * @author 刘飞
 *
 */
public interface IGoodsService {
	/**
	 * 根据CategoryId得到商品
	 * @param id
	 * @param offset
	 * @param count
	 * @return
	 */
    List<Goods> getGoodsByCategoryId(Integer categoryId,Integer offset,Integer count);
    /**
     * 通过商品id查询所有的图片
     * @param id
     * @return
     */
    List<Images> getImagesByProductId(Integer id);
    /**
     * 得到记录数
     * @param categoryId
     * @return
     */
    Integer getCount(Integer categoryId);
    
    /**
	 * 通过title获取商品
	 * @param title
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByTitle(String title,Integer offset,Integer count);
	
	/**
	 * 获取title的记录数
	 * @param title
	 * @return
	 */
	Integer getCountByTitle(String title);
	
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
	List<Goods> getHotGoods(Integer offset,Integer count);
	/**
	 * 查询促销产品
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getSaleGoods(Integer offset,Integer count);
	/**
	 * 查询雀巢产品
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getquechaoGoods(Integer offset,Integer count);
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
	List<Goods> getGoods(Integer offset,Integer count);
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
