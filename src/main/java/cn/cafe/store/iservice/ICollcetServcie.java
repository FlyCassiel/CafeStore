package cn.cafe.store.iservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;
import cn.cafe.store.bean.Collect;


/**
 * 收藏夹的服务层接口
 * @author 刘飞
 *
 */
public interface ICollcetServcie {
	/**
	 * 添加collect信息到数据库
	 * @param cart
	 */
    void addCollect(Collect collect);
    
    /**
     * 通过用户id查询指定用户的商品信息
     * @param userid
     * @return
     */
    List<Collect> getAll(Integer userid);
    
    /**
     * 批量删除收藏夹中的商品数据
     * @param ids
     * @return
     */
    void deleteByBatch(Integer[] goodsids);
    /**
	 * 得到所有的收藏夹信息通过收藏的多少分组
	 * @return
	 */
	List<Collect> getCollect();
}
