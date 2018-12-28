package cn.cafe.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;

/**
 * 购物车持久层接口
 * @author 刘飞
 *
 */
public interface CartMapper {
	/**
	 * 向购物车添加商品信息
	 * @param cart
	 */
	void insert(Cart cart);
	
	/**
	 * 查询指定用户的购物车，并返回集合
	 * @param userid
	 * @return
	 */
	List<Cart> getCartByUserid(Integer userid);
	
	/**
	 * 根据商品id和用户id修改数量count   添加购物的时候把数据库中的数量修改为添加的数量
	 * @param cart
	 */
	void update(Cart cart);
	
	/**
	 * 通过userid查询当前用户的购物车的商品信息
	 * @param userid
	 * @return
	 */
	List<CartVo> selectAll(Integer userid);
	
	/**
	 * 根据id删除购物车中的商品
	 * @param id
	 */
	void deleteByCartId(Integer id);
	
	/**
	 * 批量删除购物车中的商品
	 * @param ids
	 */
	void deleteByBatch(Integer[] ids);
	
	/**
	 * 通过id修改商品的数量  在购物车中操作数量的加减
	 * @param id
	 * @param count
	 */
	void updateById(@Param("id") Integer id,@Param("count") Integer count);
}
