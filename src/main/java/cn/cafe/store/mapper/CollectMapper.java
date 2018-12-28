package cn.cafe.store.mapper;

import java.util.List;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;
import cn.cafe.store.bean.Collect;

/**
 * 收藏夹持久层接口
 * @author 刘飞
 *
 */
public interface CollectMapper {
	/**
	 * 向收藏夹添加商品信息
	 * @param cart
	 */
	void insert(Collect collect);
	/**
	 * 查询指定用户的购物车，并返回集合
	 * @param userid
	 * @return
	 */
	List<Collect> getCollectByUserid(Integer userid);
	
	/**
	 * 根据商品id和用户id修改数量count   添加购物的时候把数据库中的数量修改为添加的数量
	 * @param cart
	 */
	void update(Collect collect);
	/**
	 * 通过userid查询当前用户的购物车的商品信息
	 * @param userid
	 * @return
	 */
	List<Collect> selectAll(Integer userid);
	/**
	 * 批量删除收藏夹中的商品
	 * @param ids
	 */
	void deleteByBatch(Integer[] goodsids);
	/*--------------------------后台用到的展示收藏夹-------------------------*/
	/**
	 * 得到所有的收藏夹信息通过收藏的多少分组
	 * @return
	 */
	List<Collect> getCollect();
	
}
