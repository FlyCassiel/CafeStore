package cn.cafe.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.bean.GoodsCategory;
import cn.cafe.store.bean.User;


/**
 * 咖啡分类的接口
 * @author 刘飞
 *
 */
public interface GoodsCategoryMapper {
	/**
	 * 根据parentId查询子分类
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
     * 通过自增id查询分类实体类对象
     * @param id
     * @return
     */
    GoodsCategory getGoodsCategoryById(Integer id);
    /*-------------------后台的分类管理显示页面和分页用到--------------------*/
    /**
     * 得到商品分类表信息
     * @return
     */
    List<GoodsCategory> getGoodsCategory(
    		@Param("offset") Integer offset,
    		@Param("count")  Integer count);
   /**
    * 得到分类信息的数据数量
    * @return
    */
    Integer getCount();
    /*-------------------模糊查询所需要的--------------------------*/
    /**
	 * 查询分类信息  模糊查询
	 * @param username 用户名
	 * @return
	 */
	List<GoodsCategory> getGoodsCategoryByName(
			@Param("name") String name,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * 根据名字 查询一共有多少条数据
	 * @param username
	 * @return
	 */
	Integer getCountByname(String name);
	/* ----------删除数据 ---------------*/
	/**
	 * 删除指定id的分类信息
	 * @param id
	 */
	void deleteGoodsCategory(Integer id);
	/* ----------修改数据 ---------------*/
	/**
	 * 修改id的名称
	 * @param id
	 * @param name
	 */
	void updateGoodsCategory(
			@Param("id") Integer id,
			@Param("name") String name);
	/**
	 * 后台的添加分类信息
	 * @param goodsCategory
	 * @return
	 */
	Integer insertGoodsCategoryAdmin(GoodsCategory goodsCategory);
}
