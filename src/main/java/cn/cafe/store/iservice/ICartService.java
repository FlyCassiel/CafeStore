package cn.cafe.store.iservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;


/**
 * ���ﳵ�ķ����ӿ�
 * @author ����
 *
 */
public interface ICartService {
	/**
	 * ���cart��Ϣ�����ݿ�
	 * @param cart
	 */
    void addCart(Cart cart);
    
    /**
     * ͨ���û�id��ѯָ���û�����Ʒ��Ϣ
     * @param userid
     * @return
     */
    List<CartVo> getAll(Integer userid);
    
    /**
     * ����idɾ�����ﳵ�е���Ʒ
      * @param id
     */
    void deleteByCartId(Integer id);
    
    /**
     * ����ɾ����Ʒ����
     * @param ids
     * @return
     */
    void deleteByBatch(Integer[] ids);
    
    /**
     * ͨ��id�޸���Ʒ������
      * @param id
      * @param count
     */
    void updateById(@Param("id") Integer id,@Param("count") Integer count);
   
    /**
     * ����ȷ�Ϲ������Ʒ�ļ���  ȷ������
      * @param userid
      * @param id
      * @return
     */
    List<CartVo> getOrderByUserid(Integer userid,Integer[] id);
}
