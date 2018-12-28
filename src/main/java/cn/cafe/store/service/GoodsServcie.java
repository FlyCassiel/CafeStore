package cn.cafe.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Goods;
import cn.cafe.store.bean.Images;
import cn.cafe.store.iservice.IGoodsService;
import cn.cafe.store.mapper.GoodsMapper;

/**
 * ��Ʒ�����ʵ����
 * @author ����
 *
 */
@Service
public class GoodsServcie implements IGoodsService{
	@Resource
	private GoodsMapper goodsMapper;
	/**
	 * ͨ������id���goods����
	 * @param categoryId
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Goods> getGoodsByCategoryId(Integer categoryId, Integer offset, Integer count) {
		return goodsMapper.getGoodsByCategoryId(categoryId, offset, count);
	}
	/**
	 * ͨ����Ʒid���images����
	 */
	public List<Images> getImagesByProductId(Integer productId) {
		return goodsMapper.getImagesByProductId(productId);
	}
	/**
	 * ��ø���id�µ�������Ʒ������
	 * @param categoryId
	 * @return
	 */
	public Integer getCount(Integer categoryId) {
		return goodsMapper.getCount(categoryId);
	}
	/**
	 * ͨ������ȥ��ѯ��ȡgoods����
	 * @param title
	 * @param offset
	 * @param count
	 * @return
	 */
	public List<Goods> getGoodsByTitle(String title, Integer offset, Integer count) {
		return goodsMapper.getGoodsByTitle(title, offset, count);
	}
	
	/**
	 * ��ȡ��¼��
	 */
	public Integer getCountByTitle(String title) {
		return goodsMapper.getCountByTitle(title);
	}
	
	/**
	 * ͨ��id��ȡ��Ʒ��Ϣ
	 */
	public Goods getGoodsById(Integer id) {
		return goodsMapper.getGoodsById(id);
	}
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Goods> getHotGoods(Integer offset, Integer count) {
		return goodsMapper.getHotGoods(offset, count);
	}
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Goods> getSaleGoods(Integer offset, Integer count) {
		return goodsMapper.getSaleGoods(offset, count);
	}
	/**
	 *��ѯȸ����Ʒ
	 */
	public List<Goods> getquechaoGoods(Integer offset, Integer count) {
		return  goodsMapper.getquechaoGoods(offset, count);
	}
	/**
	 * ��Ʒ������֧������ ͨ����Ʒ�����ֱ�ӵ�ȷ��֧�����ܡ�
	 * @param id
	 * @return
	 */
	public List<CartVo> getcartVoById(Integer id) {
		return goodsMapper.getcartVoById(id);
	}
	/*----------------------��̨��չʾ��Ʒ��Ϣ----------------------------*/
	/**
	 * �õ����е���Ʒ��Ϣ
	 */
	public List<Goods> getGoods(Integer offset, Integer count) {
		return goodsMapper.getGoods(offset, count);
	}
	/**
	 * �õ�������Ʒ������
	 */
	public Integer getAllCount() {
		return goodsMapper.getAllCount();
	}
	/**
	 * ������Ʒidɾ����Ʒ��Ϣ
	 */
	public Integer delete(Integer id) {
		return goodsMapper.delete(id);
	}
	/**
	 * �޸���Ʒ��Ϣ
	 */
	public Integer updateAdmin(Goods goods) {
		return goodsMapper.updateAdmin(goods);
	}
	/**
	 * �����Ʒ��Ϣ
	 */
	public Integer insertGoodsAdmin(Goods goods) {
		return goodsMapper.insertGoodsAdmin(goods);
	}
	
}
