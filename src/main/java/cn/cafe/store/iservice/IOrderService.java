package cn.cafe.store.iservice;

import java.util.List;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.Vo.OrderItemVo;
import cn.cafe.store.bean.Order;
import cn.cafe.store.bean.OrderItem;
/**
 * ���������ӿ�
 * @author ����
 *
 */
public interface IOrderService {
	/**
	 * ��Ӷ���
	 * @param userid
	 * @param listCartVo
	 * @return 
	 */
    Integer addOrder(Integer userid,List<CartVo> listCartVo);
    /**
     * ��Ӷ���������������
     * @param uid
     * @param cartVoList
     * @param count
     * @return
     */
    Integer addOrder(Integer uid, List<CartVo> cartVoList, Integer count);
    
    /**
     * �޸Ķ�������״̬
     * @param orderid
     */
    void updateStatus(Integer orderid);  
    
    /**
     * ��ѯ���û������ж���
     * @param userid
     * @return
     */
    List<OrderItemVo> getOrderItems(Integer userid);
    /**
     * ͨ���û�idȡ�ö�������
     * @param uid
     * @return
     */
    List<Order> getOrderByUid(Integer userid,Integer offset,Integer count);
    /**
      *  �õ����û��µĸö��������ж�������
      * @param userid
      * @return
      */
    Integer getCount(Integer uid);
    /**
     * ��ѯ�ö������µ����ж���
     * @param userid
     * @param count 
     * @param offset 
     * @return
     */
    List<OrderItemVo> getOrderItemsByOrderid(Integer orderid);
    /**
     * ɾ������
     * @param orderid
     * @return
     */
    Integer deleteOrder(Integer orderid);
    /**
     * ɾ����������
     * @param orderid
     * @return
     */
    Integer deleteOrderItem(Integer orderid);
    /**
     * ͨ�������ŵõ�������Ϣ
     * @param orderid
     * @return
     */
    Order getOrderByid(Integer id);
    /**
     * ʧЧ��������
     * @param orderid
     * @return
     */
    Integer updateOrderstatus(Integer orderid);
    /*------------------��̨�õ��Ķ���-------------------------*/
    /**
     * �õ����еĶ�����Ϣ
     * @return
     */
    List<Order> getOrderAdmin();
    /**
     * �õ����еĶ���������Ϣ
     * @return
     */
    List<OrderItem> getOrderItemAdmin();
	
}
