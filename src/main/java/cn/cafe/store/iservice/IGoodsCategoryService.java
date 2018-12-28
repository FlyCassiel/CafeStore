package cn.cafe.store.iservice;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.bean.GoodsCategory;
public interface IGoodsCategoryService {
	/**
	 *  ��ѯ��Ʒ����
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
    List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId,Integer offset,Integer count);
    /*-------------------��̨�ķ��������ʾҳ��ͷ�ҳ�õ�--------------------*/
    /**
    * ͨ������id ��ѯ����ʵ�������
    * @param id
    * @return
    */
    GoodsCategory getGoodsCategoryById(Integer id);
    /**
     * �õ���Ʒ�������Ϣ
     * @return
     */
    List<GoodsCategory> getGoodsCategory(Integer offset,Integer count);
    /**
     * �õ�������Ϣ����������
     * @return
     */
    Integer getCount();
    /*-------------------ģ����ѯ����Ҫ��--------------------------*/
    /**
	 * ��ѯ������Ϣ  ģ����ѯ
	 * @param username �û���
	 * @return
	 */
	List<GoodsCategory> getGoodsCategoryByName(
			@Param("name") String name,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * �������� ��ѯһ���ж���������
	 * @param username
	 * @return
	 */
	Integer getCountByname(String name);
	/* ----------ɾ������ ---------------*/
	/**
	 * ɾ��ָ��id�ķ�����Ϣ
	 * @param id
	 */
	void deleteGoodsCategory(Integer id);
	/* ----------�޸����� ---------------*/
	/***
	 * �޸ķ�������
	 * @param id
	 * @param name
	 */
	void updateGoodsCategory(Integer id,String name);
	/**
	 * ��̨����ӷ�����Ϣ
	 * @param goodsCategory
	 * @return
	 */
	Integer insertGoodsCategoryAdmin(GoodsCategory goodsCategory);
}
