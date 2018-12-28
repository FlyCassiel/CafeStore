package cn.cafe.store.iservice;

import java.awt.Image;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Goods;
import cn.cafe.store.bean.Images;


/**
 * ��Ʒ�����ӿ�
 * @author ����
 *
 */
public interface IGoodsService {
	/**
	 * ����CategoryId�õ���Ʒ
	 * @param id
	 * @param offset
	 * @param count
	 * @return
	 */
    List<Goods> getGoodsByCategoryId(Integer categoryId,Integer offset,Integer count);
    /**
     * ͨ����Ʒid��ѯ���е�ͼƬ
     * @param id
     * @return
     */
    List<Images> getImagesByProductId(Integer id);
    /**
     * �õ���¼��
     * @param categoryId
     * @return
     */
    Integer getCount(Integer categoryId);
    
    /**
	 * ͨ��title��ȡ��Ʒ
	 * @param title
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByTitle(String title,Integer offset,Integer count);
	
	/**
	 * ��ȡtitle�ļ�¼��
	 * @param title
	 * @return
	 */
	Integer getCountByTitle(String title);
	
	/**
	 * ͨ��id��ȡ��Ʒ��Ϣ
	 * @param id
	 * @return
	 */
	Goods getGoodsById(Integer id);
	/**
	 * ��ѯ������Ʒ
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getHotGoods(Integer offset,Integer count);
	/**
	 * ��ѯ������Ʒ
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getSaleGoods(Integer offset,Integer count);
	/**
	 * ��ѯȸ����Ʒ
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getquechaoGoods(Integer offset,Integer count);
	/**
	 * ��Ʒ������֧������ ͨ����Ʒ�����ֱ�ӵ�ȷ��֧�����ܡ�
	 * @param id
	 * @return
	 */
	List<CartVo> getcartVoById(Integer id);
	/*----------------------��̨��չʾ��Ʒ��Ϣ----------------------------*/
	/**
	 * �õ����е���Ʒ��Ϣ
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoods(Integer offset,Integer count);
	/**
	 * �õ�������Ʒ������
	 * @return
	 */
	Integer getAllCount();
	/**
	 * ������Ʒidɾ����Ʒ��Ϣ
	 * @return
	 */
	Integer delete(Integer id);
	/**
	 * �޸���Ʒ��Ϣ
	 * @param goods
	 * @return
	 */
	Integer updateAdmin(Goods goods);
	/**
	 * �����Ʒ��Ϣ
	 * @param goods
	 * @return
	 */
	Integer insertGoodsAdmin(Goods goods);
}
