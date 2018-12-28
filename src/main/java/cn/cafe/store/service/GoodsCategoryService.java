package cn.cafe.store.service;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.cafe.store.bean.GoodsCategory;
import cn.cafe.store.bean.ProductCount;
import cn.cafe.store.iservice.IGoodsCategoryService;
import cn.cafe.store.mapper.GoodsCategoryMapper;
@Service
public class GoodsCategoryService implements IGoodsCategoryService{
	@Resource
	private GoodsCategoryMapper goodsCategoryMapper;
	/**
	 *  查询商品分类
	 */
	public List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId, Integer offset, Integer count) {		
		return goodsCategoryMapper.getGoodsCategoryByParentId(parentId, offset, count) ;
	}
	/**
	 * 通过自增id得到该id下的分类信息实体类
	 */
	public GoodsCategory getGoodsCategoryById(Integer id) {
		return goodsCategoryMapper.getGoodsCategoryById(id);
	}
	/**
	 * 
	 */
	public List<GoodsCategory> getGoodsCategory(Integer offset,Integer count) {
		return goodsCategoryMapper.getGoodsCategory(offset,count);
	}
	public Integer getCount() {
		return goodsCategoryMapper.getCount();
	}
	/*-------------------模糊查询所需要的--------------------------*/
	public List<GoodsCategory> getGoodsCategoryByName(String name, Integer offset, Integer count) {
		return goodsCategoryMapper.getGoodsCategoryByName(name, offset, count);
	}
	public Integer getCountByname(String name) {
		return goodsCategoryMapper.getCountByname(name);
	}
	/**
	 * 删除数据
	 */
	public void deleteGoodsCategory(Integer id) {
		goodsCategoryMapper.deleteGoodsCategory(id);
	}
	/**
	 * 修改数据
	 */
	public void updateGoodsCategory(Integer id, String name) {
		goodsCategoryMapper.updateGoodsCategory(id, name);
	}
	public Integer insertGoodsCategoryAdmin(GoodsCategory goodsCategory) {
		return goodsCategoryMapper.insertGoodsCategoryAdmin(goodsCategory);
	}

}
