package cn.cafe.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.bean.GoodsCategory;
import cn.cafe.store.bean.User;


/**
 * ���ȷ���Ľӿ�
 * @author ����
 *
 */
public interface GoodsCategoryMapper {
	/**
	 * ����parentId��ѯ�ӷ���
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
    List<GoodsCategory> getGoodsCategoryByParentId(
    		@Param("parentId") Integer parentId,
    		@Param("offset") Integer offset,
    		@Param("count") Integer count);
    /**
     * ͨ������id��ѯ����ʵ�������
     * @param id
     * @return
     */
    GoodsCategory getGoodsCategoryById(Integer id);
    /*-------------------��̨�ķ��������ʾҳ��ͷ�ҳ�õ�--------------------*/
    /**
     * �õ���Ʒ�������Ϣ
     * @return
     */
    List<GoodsCategory> getGoodsCategory(
    		@Param("offset") Integer offset,
    		@Param("count")  Integer count);
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
	/**
	 * �޸�id������
	 * @param id
	 * @param name
	 */
	void updateGoodsCategory(
			@Param("id") Integer id,
			@Param("name") String name);
	/**
	 * ��̨����ӷ�����Ϣ
	 * @param goodsCategory
	 * @return
	 */
	Integer insertGoodsCategoryAdmin(GoodsCategory goodsCategory);
}
