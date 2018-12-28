package cn.cafe.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.OrderItemVo;
import cn.cafe.store.bean.Order;
import cn.cafe.store.bean.OrderItem;

/**
 * 持久层订单接口
 * @author 刘飞
 *
 */
public interface OrderMapper {
	/**
	 * 在订单中插入数据
	 * @param order
	 */
    void insertOrder(Order order);
    
    /**
     * 在订单详情列表页插入数据
     * @param orderItem
     */
    void insertOrderItem(OrderItem orderItem);
    
    /**
     * 修改付款状态  确定支付
     * @param orderid
     */
    void updateStatus(Integer orderid);
   
    /**
     * 查询该用户的所有订单
     * @param userid
     * @param count 
     * @param offset 
     * @return
     */
    List<OrderItemVo> getOrderItems(Integer userid);
    /**
     * 通过用户id取得订单集合
     * @param uid
     * @return
     */
    List<Order> getOrderByUid(@Param("userid") Integer userid,@Param("offset") Integer offset,@Param("count") Integer count);
    /**
     * 得到该用户下的该订单的所有订单数量
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
     * 失效订单处理
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
    /**
     * 通过订单号得到订单信息
     * @param orderid
     * @return
     */
    Order getOrderByid(Integer id);
}
