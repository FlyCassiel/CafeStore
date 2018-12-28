package cn.cafe.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.cafe.store.bean.Collect;
import cn.cafe.store.iservice.ICollcetServcie;
import cn.cafe.store.mapper.CollectMapper;
import cn.cafe.store.service.ex.CollectionAlreadyExistException;

/**
 * 收藏夹服务层实现类
 * 
 * @author 刘飞
 *
 */
@Service
public class CollectServcie implements ICollcetServcie {
	@Resource
	private CollectMapper collectMapper;

	/**
	 * 添加收藏夹信息
	 */
	public void addCollect(Collect collect) {
		// 查询：返回集合 通过userid获得该用户下的所有购物车商品信息
		List<Collect> collectList = collectMapper.getCollectByUserid(collect.getUserid());
		// 遍历集合的每个cart对象，得到cart的goodsid，
		// 和参数列表里的cart对象的goodsid作比较
		for (Collect c : collectList) {
			if (c.getGoodsid().equals(collect.getGoodsid())) {
				throw new CollectionAlreadyExistException("该商品已经被收藏，请勿反复收藏");
			}
		}
		collectMapper.insert(collect);
	}

	/**
	 * 
	 * @param userid
	 *            showCart.do
	 * @return
	 */
	public List<Collect> getAll(Integer userid) {
		return collectMapper.selectAll(userid);
	}
	/**
	 * 批量删除购物车商品
	 */
	public void deleteByBatch(Integer[] goodsids) {
		collectMapper.deleteByBatch(goodsids);
	}

	public List<Collect> getCollect() {
		return collectMapper.getCollect();
	}
}
