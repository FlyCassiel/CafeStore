package cn.cafe.store.iservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;


/**
 * 购物车的服务层接口
 * @author 刘飞
 *
 */
public interface ICartService {
	/**
	 * 添加cart信息到数据库
	 * @param cart
	 */
    void addCart(Cart cart);
    
    /**
     * 通过用户id查询指定用户的商品信息
     * @param userid
     * @return
     */
    List<CartVo> getAll(Integer userid);
    
    /**
     * 根据id删除购物车中的商品
      * @param id
     */
    void deleteByCartId(Integer id);
    
    /**
     * 批量删除商品数据
     * @param ids
     * @return
     */
    void deleteByBatch(Integer[] ids);
    
    /**
     * 通过id修改商品的数量
      * @param id
      * @param count
     */
    void updateById(@Param("id") Integer id,@Param("count") Integer count);
   
    /**
     * 返回确认购买的商品的集合  确定订单
      * @param userid
      * @param id
      * @return
     */
    List<CartVo> getOrderByUserid(Integer userid,Integer[] id);
}
