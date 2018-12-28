package cn.cafe.store.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.Vo.OrderItemVo;
import cn.cafe.store.bean.Order;
import cn.cafe.store.bean.OrderItem;
import cn.cafe.store.iservice.IOrderService;
import cn.cafe.store.mapper.OrderMapper;

/**
 * 订单服务层实现类
 * 
 * @author 刘飞
 *
 */
@Service
public class OrderService implements IOrderService {
	@Resource
	private OrderMapper orderMapper;

	/**
	 * 插入订单和订单详情的数据
	 * 
	 * @return
	 */
	public Integer addOrder(Integer userid, List<CartVo> listCartVo) {
		// 订单
		Order order = new Order();
		// 插入数据
		order.setUserid(userid);
		orderMapper.insertOrder(order);
		// 遍历listCartVo
		for (CartVo cartVo : listCartVo) {
			// 订单详情
			OrderItem orderItem = new OrderItem();
			orderItem.setGoodsid(cartVo.getGoodsid());
			orderItem.setUserid(userid);
			orderItem.setImage(cartVo.getImage());
			orderItem.setTitle(cartVo.getTitle());
			orderItem.setCount(cartVo.getCount());
			orderItem.setPrice(cartVo.getPrice());
			orderItem.setOrderid(order.getId());
			orderMapper.insertOrderItem(orderItem);
		}
		return order.getId();
	}

	/**
	 * 插入订单和订单详情的数据 商品详情页的立即支付功能
	 */
	public Integer addOrder(Integer uid, List<CartVo> cartVoList, Integer count) {

		// 订单
		Order order = new Order();
		// 插入数据
		order.setUserid(uid);
		orderMapper.insertOrder(order);
		// 遍历listCartVo
		for (CartVo cartVo : cartVoList) {
			// 订单详情
			OrderItem orderItem = new OrderItem();
			orderItem.setGoodsid(cartVo.getGoodsid());
			orderItem.setUserid(uid);
			orderItem.setImage(cartVo.getImage());
			orderItem.setTitle(cartVo.getTitle());
			orderItem.setCount(count);
			orderItem.setPrice(cartVo.getPrice());
			orderItem.setOrderid(order.getId());
			orderMapper.insertOrderItem(orderItem);
		}
		return order.getId();
	}

	/**
	 * 修改付款状态
	 */
	public void updateStatus(Integer orderid) {
		orderMapper.updateStatus(orderid);
	}

	/**
	 * 查询用户的所有订单
	 */
	public List<OrderItemVo> getOrderItems(Integer userid) {
		// 返回该用户的所有订单
		return orderMapper.getOrderItems(userid);
	}

	/**
	 * 通过用户id取得订单id集合
	 */
	public List<Order> getOrderByUid(Integer userid, Integer offset, Integer count) {
		return orderMapper.getOrderByUid(userid, offset, count);
	}

	/**
	 * 查询用户的所有订单数量
	 */
	public Integer getCount(Integer uid) {
		return orderMapper.getCount(uid);
	}

	/**
	 * 查询该订单号下的所有订单
	 */
	public List<OrderItemVo> getOrderItemsByOrderid(Integer orderid) {
		return orderMapper.getOrderItemsByOrderid(orderid);
	}

	/**
	 * 删除订单
	 */
	public Integer deleteOrder(Integer orderid) {
		return orderMapper.deleteOrder(orderid);
	}

	/**
	 * 删除订单详情
	 */
	public Integer deleteOrderItem(Integer orderid) {
		return orderMapper.deleteOrderItem(orderid);
	}
	/**
	 * 通过订单号得到订单
	 */
	public Order getOrderByid(Integer id) {
		return orderMapper.getOrderByid(id);
	}
	/**
	 * 失效订单设置
	 */
	public Integer updateOrderstatus(Integer orderid) {
		return orderMapper.updateOrderstatus(orderid);
	}
	/*------------------后台用到的订单-------------------------*/
	/**
	 * 得到所有的订单信息
	 */
	public List<Order> getOrderAdmin() {
		return orderMapper.getOrderAdmin();
	}
	/**
	 * 得到所有的订单详情信息
	 */
	public List<OrderItem> getOrderItemAdmin() {
		return	orderMapper.getOrderItemAdmin();
	}


}
