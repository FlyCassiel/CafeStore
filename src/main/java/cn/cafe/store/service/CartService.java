package cn.cafe.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Cart;
import cn.cafe.store.iservice.ICartService;
import cn.cafe.store.mapper.CartMapper;

/**
 * ���ﳵ�����ʵ����
 * @author ����
 *
 */
@Service
public class CartService implements ICartService{
	@Resource
	private CartMapper cartMapper;
	/**
	 * ��ӹ��ﳵ��Ϣ
	 */
	public void addCart(Cart cart) {
		//��ѯ�����ؼ��� ͨ��userid��ø��û��µ����й��ﳵ��Ʒ��Ϣ
		List<Cart> cartList = cartMapper.getCartByUserid(cart.getUserid());
		//�������ϵ�ÿ��cart���󣬵õ�cart��goodsid��
		//�Ͳ����б����cart�����goodsid���Ƚ�
		for(Cart c:cartList) {
			if(c.getGoodsid().equals(cart.getGoodsid())&&cart.getTaste().equals(c.getTaste())) {
				//�����ȣ����ݿ��е���������ԭ�������ϱ��д�����������
				Integer quantity = cart.getCount()+c.getCount();     
				cart.setCount(quantity);
			   //�������true,�޸ģ�update(cart)
			   cartMapper.update(cart);
			   return;
			}
		}
		cartMapper.insert(cart);
	}
	/**
	 * 
	 * @param userid  showCart.do
	 * @return
	 */
	public List<CartVo> getAll(Integer userid) {
		return cartMapper.selectAll(userid);
	}
	
	/**
	 * ɾ��t_cart���ﳵ�е���Ʒ��Ϣ
	 */
	public void deleteByCartId(Integer id) {
		cartMapper.deleteByCartId(id);
	}
	
	/**
	 * ����ɾ�����ﳵ��Ʒ
	 */
	public void deleteByBatch(Integer[] ids) {
		cartMapper.deleteByBatch(ids);
	}
	
	/**
	 * ͨ��id�޸���Ʒ������
	 */
	public void updateById(Integer id, Integer count) {
		cartMapper.updateById(id, count);
	}
	
	/**
	 * ����ȷ�Ϲ������Ʒ�ļ���  ȷ������
	 */
	public List<CartVo> getOrderByUserid(Integer userid, Integer[] ids) {
		//0.�������϶��󣬷�ȷ�϶����е�CartVo����
		List<CartVo> newList = new ArrayList<CartVo>();
		//1.ͨ��userid��ȡ���ﳵ��������Ʒ�����ؼ���
		List<CartVo> list = cartMapper.selectAll(userid);
		//2.�������ϣ��Ѽ����е�CartVo��id��ȡ��
		for(CartVo cartVo:list) {
			for(Integer id:ids) {
				if(cartVo.getId().equals(id)) {
					newList.add(cartVo);
					break;
				}
			}
		}
		return newList;
	}

}
