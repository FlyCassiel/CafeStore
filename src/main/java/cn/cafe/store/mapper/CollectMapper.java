package cn.cafe.store.mapper;

import java.util.List;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;
import cn.cafe.store.bean.Collect;

/**
 * �ղؼг־ò�ӿ�
 * @author ����
 *
 */
public interface CollectMapper {
	/**
	 * ���ղؼ������Ʒ��Ϣ
	 * @param cart
	 */
	void insert(Collect collect);
	/**
	 * ��ѯָ���û��Ĺ��ﳵ�������ؼ���
	 * @param userid
	 * @return
	 */
	List<Collect> getCollectByUserid(Integer userid);
	
	/**
	 * ������Ʒid���û�id�޸�����count   ��ӹ����ʱ������ݿ��е������޸�Ϊ��ӵ�����
	 * @param cart
	 */
	void update(Collect collect);
	/**
	 * ͨ��userid��ѯ��ǰ�û��Ĺ��ﳵ����Ʒ��Ϣ
	 * @param userid
	 * @return
	 */
	List<Collect> selectAll(Integer userid);
	/**
	 * ����ɾ���ղؼ��е���Ʒ
	 * @param ids
	 */
	void deleteByBatch(Integer[] goodsids);
	/*--------------------------��̨�õ���չʾ�ղؼ�-------------------------*/
	/**
	 * �õ����е��ղؼ���Ϣͨ���ղصĶ��ٷ���
	 * @return
	 */
	List<Collect> getCollect();
	
}
