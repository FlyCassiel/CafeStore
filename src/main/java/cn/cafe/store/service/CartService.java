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
 * 购物车服务层实现类
 * @author 刘飞
 *
 */
@Service
public class CartService implements ICartService{
	@Resource
	private CartMapper cartMapper;
	/**
	 * 添加购物车信息
	 */
	public void addCart(Cart cart) {
		//查询：返回集合 通过userid获得该用户下的所有购物车商品信息
		List<Cart> cartList = cartMapper.getCartByUserid(cart.getUserid());
		//遍历集合的每个cart对象，得到cart的goodsid，
		//和参数列表里的cart对象的goodsid作比较
		for(Cart c:cartList) {
			if(c.getGoodsid().equals(cart.getGoodsid())&&cart.getTaste().equals(c.getTaste())) {
				//如果相等，数据库中的数量就是原数量加上表单中传过来的数量
				Integer quantity = cart.getCount()+c.getCount();     
				cart.setCount(quantity);
			   //结果返回true,修改，update(cart)
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
	 * 删除t_cart购物车中的商品信息
	 */
	public void deleteByCartId(Integer id) {
		cartMapper.deleteByCartId(id);
	}
	
	/**
	 * 批量删除购物车商品
	 */
	public void deleteByBatch(Integer[] ids) {
		cartMapper.deleteByBatch(ids);
	}
	
	/**
	 * 通过id修改商品的数量
	 */
	public void updateById(Integer id, Integer count) {
		cartMapper.updateById(id, count);
	}
	
	/**
	 * 返回确认购买的商品的集合  确定订单
	 */
	public List<CartVo> getOrderByUserid(Integer userid, Integer[] ids) {
		//0.创建集合对象，放确认订单中的CartVo对象
		List<CartVo> newList = new ArrayList<CartVo>();
		//1.通过userid获取购物车的所有商品，返回集合
		List<CartVo> list = cartMapper.selectAll(userid);
		//2.遍历集合，把集合中的CartVo的id获取到
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
