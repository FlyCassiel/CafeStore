package cn.cafe.store.iservice;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.bean.GoodsCategory;
public interface IGoodsCategoryService {
	/**
	 *  查询商品分类
	 * @param parentId
	 * @param offset
	 * @param count
	 * @return
	 */
    List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId,Integer offset,Integer count);
    /*-------------------后台的分类管理显示页面和分页用到--------------------*/
    /**
    * 通过自增id 查询分类实体类对象
    * @param id
    * @return
    */
    GoodsCategory getGoodsCategoryById(Integer id);
    /**
     * 得到商品分类表信息
     * @return
     */
    List<GoodsCategory> getGoodsCategory(Integer offset,Integer count);
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
	/***
	 * 修改分类数据
	 * @param id
	 * @param name
	 */
	void updateGoodsCategory(Integer id,String name);
	/**
	 * 后台的添加分类信息
	 * @param goodsCategory
	 * @return
	 */
	Integer insertGoodsCategoryAdmin(GoodsCategory goodsCategory);
}
