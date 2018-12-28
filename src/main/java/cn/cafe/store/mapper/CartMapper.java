package cn.cafe.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;

/**
 * ���ﳵ�־ò�ӿ�
 * @author ����
 *
 */
public interface CartMapper {
	/**
	 * ���ﳵ�����Ʒ��Ϣ
	 * @param cart
	 */
	void insert(Cart cart);
	
	/**
	 * ��ѯָ���û��Ĺ��ﳵ�������ؼ���
	 * @param userid
	 * @return
	 */
	List<Cart> getCartByUserid(Integer userid);
	
	/**
	 * ������Ʒid���û�id�޸�����count   ��ӹ����ʱ������ݿ��е������޸�Ϊ��ӵ�����
	 * @param cart
	 */
	void update(Cart cart);
	
	/**
	 * ͨ��userid��ѯ��ǰ�û��Ĺ��ﳵ����Ʒ��Ϣ
	 * @param userid
	 * @return
	 */
	List<CartVo> selectAll(Integer userid);
	
	/**
	 * ����idɾ�����ﳵ�е���Ʒ
	 * @param id
	 */
	void deleteByCartId(Integer id);
	
	/**
	 * ����ɾ�����ﳵ�е���Ʒ
	 * @param ids
	 */
	void deleteByBatch(Integer[] ids);
	
	/**
	 * ͨ��id�޸���Ʒ������  �ڹ��ﳵ�в��������ļӼ�
	 * @param id
	 * @param count
	 */
	void updateById(@Param("id") Integer id,@Param("count") Integer count);
}
