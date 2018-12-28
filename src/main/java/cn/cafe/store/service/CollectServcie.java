package cn.cafe.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.cafe.store.bean.Collect;
import cn.cafe.store.iservice.ICollcetServcie;
import cn.cafe.store.mapper.CollectMapper;
import cn.cafe.store.service.ex.CollectionAlreadyExistException;

/**
 * �ղؼз����ʵ����
 * 
 * @author ����
 *
 */
@Service
public class CollectServcie implements ICollcetServcie {
	@Resource
	private CollectMapper collectMapper;

	/**
	 * ����ղؼ���Ϣ
	 */
	public void addCollect(Collect collect) {
		// ��ѯ�����ؼ��� ͨ��userid��ø��û��µ����й��ﳵ��Ʒ��Ϣ
		List<Collect> collectList = collectMapper.getCollectByUserid(collect.getUserid());
		// �������ϵ�ÿ��cart���󣬵õ�cart��goodsid��
		// �Ͳ����б����cart�����goodsid���Ƚ�
		for (Collect c : collectList) {
			if (c.getGoodsid().equals(collect.getGoodsid())) {
				throw new CollectionAlreadyExistException("����Ʒ�Ѿ����ղأ����𷴸��ղ�");
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
	 * ����ɾ�����ﳵ��Ʒ
	 */
	public void deleteByBatch(Integer[] goodsids) {
		collectMapper.deleteByBatch(goodsids);
	}

	public List<Collect> getCollect() {
		return collectMapper.getCollect();
	}
}
