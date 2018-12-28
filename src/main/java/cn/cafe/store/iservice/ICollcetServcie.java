package cn.cafe.store.iservice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;
import cn.cafe.store.bean.Collect;


/**
 * �ղؼеķ����ӿ�
 * @author ����
 *
 */
public interface ICollcetServcie {
	/**
	 * ���collect��Ϣ�����ݿ�
	 * @param cart
	 */
    void addCollect(Collect collect);
    
    /**
     * ͨ���û�id��ѯָ���û�����Ʒ��Ϣ
     * @param userid
     * @return
     */
    List<Collect> getAll(Integer userid);
    
    /**
     * ����ɾ���ղؼ��е���Ʒ����
     * @param ids
     * @return
     */
    void deleteByBatch(Integer[] goodsids);
    /**
	 * �õ����е��ղؼ���Ϣͨ���ղصĶ��ٷ���
	 * @return
	 */
	List<Collect> getCollect();
}
