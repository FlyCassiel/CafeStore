package cn.cafe.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.OrderItemVo;
import cn.cafe.store.bean.Order;
import cn.cafe.store.bean.OrderItem;

/**
 * �־ò㶩���ӿ�
 * @author ����
 *
 */
public interface OrderMapper {
	/**
	 * �ڶ����в�������
	 * @param order
	 */
    void insertOrder(Order order);
    
    /**
     * �ڶ��������б�ҳ��������
     * @param orderItem
     */
    void insertOrderItem(OrderItem orderItem);
    
    /**
     * �޸ĸ���״̬  ȷ��֧��
     * @param orderid
     */
    void updateStatus(Integer orderid);
   
    /**
     * ��ѯ���û������ж���
     * @param userid
     * @param count 
     * @param offset 
     * @return
     */
    List<OrderItemVo> getOrderItems(Integer userid);
    /**
     * ͨ���û�idȡ�ö�������
     * @param uid
     * @return
     */
    List<Order> getOrderByUid(@Param("userid") Integer userid,@Param("offset") Integer offset,@Param("count") Integer count);
    /**
     * �õ����û��µĸö��������ж�������
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
    /**
     * ͨ�������ŵõ�������Ϣ
     * @param orderid
     * @return
     */
    Order getOrderByid(Integer id);
}
