package cn.cafe.store.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Goods;
import cn.cafe.store.bean.Images;

public interface GoodsMapper {
	/**
	 * ����CategoryId��ѯ����Ʒ
	 * @param CategoryId
	 * @param offset
	 * @param count
	 * @return
	 */
    List<Goods> getGoodsByCategoryId(
    		@Param("categoryId") Integer categoryId,
    		@Param("offset") Integer offset,
    		@Param("count") Integer count);
    
    /**
     * ͨ����Ʒid��ѯ���е�ͼƬ
     * @param ProductId
     * @return
     */
    List<Images> getImagesByProductId(Integer productId);
    /**
     * ����categoryId��ѯ�ж�������¼
     * @param categoryId
     * @return
     */
    Integer getCount(Integer categoryId);
    
    /**
	 * ͨ��title��ѯ��Ʒ
	 * @param title  
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getGoodsByTitle(
			@Param("title") String title,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	
	/**
	 * ��ȡtitle�ļ�¼��
	 * @param title
	 * @param offset
	 * @param count
	 * @return
	 */
	Integer getCountByTitle(@Param("title") String title);
	
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
	List<Goods> getHotGoods(
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * ��ѯ������Ʒ
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getSaleGoods(
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * ��ѯȸ����Ʒ
	 * @param offset
	 * @param count
	 * @return
	 */
	List<Goods> getquechaoGoods(
			@Param("offset") Integer offset,
			@Param("count") Integer count);
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
	List<Goods> getGoods(
			@Param("offset") Integer offset,
    		@Param("count") Integer count);
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
