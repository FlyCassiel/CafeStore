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
	 *  ��ѯ��Ʒ����
	 */
	public List<GoodsCategory> getGoodsCategoryByParentId(Integer parentId, Integer offset, Integer count) {		
		return goodsCategoryMapper.getGoodsCategoryByParentId(parentId, offset, count) ;
	}
	/**
	 * ͨ������id�õ���id�µķ�����Ϣʵ����
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
	/*-------------------ģ����ѯ����Ҫ��--------------------------*/
	public List<GoodsCategory> getGoodsCategoryByName(String name, Integer offset, Integer count) {
		return goodsCategoryMapper.getGoodsCategoryByName(name, offset, count);
	}
	public Integer getCountByname(String name) {
		return goodsCategoryMapper.getCountByname(name);
	}
	/**
	 * ɾ������
	 */
	public void deleteGoodsCategory(Integer id) {
		goodsCategoryMapper.deleteGoodsCategory(id);
	}
	/**
	 * �޸�����
	 */
	public void updateGoodsCategory(Integer id, String name) {
		goodsCategoryMapper.updateGoodsCategory(id, name);
	}
	public Integer insertGoodsCategoryAdmin(GoodsCategory goodsCategory) {
		return goodsCategoryMapper.insertGoodsCategoryAdmin(goodsCategory);
	}

}
