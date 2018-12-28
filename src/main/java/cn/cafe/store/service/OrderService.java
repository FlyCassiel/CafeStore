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
 * ���������ʵ����
 * 
 * @author ����
 *
 */
@Service
public class OrderService implements IOrderService {
	@Resource
	private OrderMapper orderMapper;

	/**
	 * ���붩���Ͷ������������
	 * 
	 * @return
	 */
	public Integer addOrder(Integer userid, List<CartVo> listCartVo) {
		// ����
		Order order = new Order();
		// ��������
		order.setUserid(userid);
		orderMapper.insertOrder(order);
		// ����listCartVo
		for (CartVo cartVo : listCartVo) {
			// ��������
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
	 * ���붩���Ͷ������������ ��Ʒ����ҳ������֧������
	 */
	public Integer addOrder(Integer uid, List<CartVo> cartVoList, Integer count) {

		// ����
		Order order = new Order();
		// ��������
		order.setUserid(uid);
		orderMapper.insertOrder(order);
		// ����listCartVo
		for (CartVo cartVo : cartVoList) {
			// ��������
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
	 * �޸ĸ���״̬
	 */
	public void updateStatus(Integer orderid) {
		orderMapper.updateStatus(orderid);
	}

	/**
	 * ��ѯ�û������ж���
	 */
	public List<OrderItemVo> getOrderItems(Integer userid) {
		// ���ظ��û������ж���
		return orderMapper.getOrderItems(userid);
	}

	/**
	 * ͨ���û�idȡ�ö���id����
	 */
	public List<Order> getOrderByUid(Integer userid, Integer offset, Integer count) {
		return orderMapper.getOrderByUid(userid, offset, count);
	}

	/**
	 * ��ѯ�û������ж�������
	 */
	public Integer getCount(Integer uid) {
		return orderMapper.getCount(uid);
	}

	/**
	 * ��ѯ�ö������µ����ж���
	 */
	public List<OrderItemVo> getOrderItemsByOrderid(Integer orderid) {
		return orderMapper.getOrderItemsByOrderid(orderid);
	}

	/**
	 * ɾ������
	 */
	public Integer deleteOrder(Integer orderid) {
		return orderMapper.deleteOrder(orderid);
	}

	/**
	 * ɾ����������
	 */
	public Integer deleteOrderItem(Integer orderid) {
		return orderMapper.deleteOrderItem(orderid);
	}
	/**
	 * ͨ�������ŵõ�����
	 */
	public Order getOrderByid(Integer id) {
		return orderMapper.getOrderByid(id);
	}
	/**
	 * ʧЧ��������
	 */
	public Integer updateOrderstatus(Integer orderid) {
		return orderMapper.updateOrderstatus(orderid);
	}
	/*------------------��̨�õ��Ķ���-------------------------*/
	/**
	 * �õ����еĶ�����Ϣ
	 */
	public List<Order> getOrderAdmin() {
		return orderMapper.getOrderAdmin();
	}
	/**
	 * �õ����еĶ���������Ϣ
	 */
	public List<OrderItem> getOrderItemAdmin() {
		return	orderMapper.getOrderItemAdmin();
	}


}
