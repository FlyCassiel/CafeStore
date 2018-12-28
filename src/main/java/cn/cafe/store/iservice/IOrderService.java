package cn.cafe.store.iservice;

import java.util.List;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.Vo.OrderItemVo;
import cn.cafe.store.bean.Order;
import cn.cafe.store.bean.OrderItem;
/**
 * 订单服务层接口
 * @author 刘飞
 *
 */
public interface IOrderService {
	/**
	 * 添加订单
	 * @param userid
	 * @param listCartVo
	 * @return 
	 */
    Integer addOrder(Integer userid,List<CartVo> listCartVo);
    /**
     * 添加订单，立即购买功能
     * @param uid
     * @param cartVoList
     * @param count
     * @return
     */
    Integer addOrder(Integer uid, List<CartVo> cartVoList, Integer count);
    
    /**
     * 修改订单付款状态
     * @param orderid
     */
    void updateStatus(Integer orderid);  
    
    /**
     * 查询该用户的所有订单
     * @param userid
     * @return
     */
    List<OrderItemVo> getOrderItems(Integer userid);
    /**
     * 通过用户id取得订单集合
     * @param uid
     * @return
     */
    List<Order> getOrderByUid(Integer userid,Integer offset,Integer count);
    /**
      *  得到该用户下的该订单的所有订单数量
      * @param userid
      * @return
      */
    Integer getCount(Integer uid);
    /**
     * 查询该订单号下的所有订单
     * @param userid
     * @param count 
     * @param offset 
     * @return
     */
    List<OrderItemVo> getOrderItemsByOrderid(Integer orderid);
    /**
     * 删除订单
     * @param orderid
     * @return
     */
    Integer deleteOrder(Integer orderid);
    /**
     * 删除订单详情
     * @param orderid
     * @return
     */
    Integer deleteOrderItem(Integer orderid);
    /**
     * 通过订单号得到订单信息
     * @param orderid
     * @return
     */
    Order getOrderByid(Integer id);
    /**
     * 失效订单设置
     * @param orderid
     * @return
     */
    Integer updateOrderstatus(Integer orderid);
    /*------------------后台用到的订单-------------------------*/
    /**
     * 得到所有的订单信息
     * @return
     */
    List<Order> getOrderAdmin();
    /**
     * 得到所有的订单详情信息
     * @return
     */
    List<OrderItem> getOrderItemAdmin();
	
}
