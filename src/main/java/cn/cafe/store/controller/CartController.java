package cn.cafe.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.bean.Address;
import cn.cafe.store.bean.Cart;
import cn.cafe.store.bean.ResponseResult;
import cn.cafe.store.iservice.ICartService;
import cn.cafe.store.iservice.ICollcetServcie;


/**
 * 
 * @author 刘飞
 *
 */
@Controller
@RequestMapping("/cart")
public class CartController extends BaseController{
	@Resource
	private ICartService cartService;
	@Resource
	private ICollcetServcie collectService;
	
	/**
	 * 显示购物车(cart.jsp)页面
	 * @return
	 */
	@RequestMapping("/showCart.do")
	public String showCart(HttpSession session,ModelMap map) {
		List<CartVo> cartVoList = cartService.getAll(this.getUid(session));
	    map.put("cartVoList", cartVoList);
		return "cart";
	}
	/**
	 * 将商品从商品详情页添加到购物车中
	 * @param goodsid
	 * @param session
	 * @param count
	 * @return
	 */
	@RequestMapping("/addCart.do")
	@ResponseBody
	public ResponseResult<Void> addCart(int goodsid,HttpSession session,int count,String taste){
		Cart cart =  new Cart();
		cart.setGoodsid(goodsid);
		cart.setUserid(this.getUid(session));
		cart.setCount(count);
		cart.setTaste(taste);
		cartService.addCart(cart);
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"添加成功");
		return rr;
	}
	/**
	 * 收藏页批量加入购物车
	 * @param goodsid
	 * @param session
	 * @param count
	 * @return
	 */
	@RequestMapping("/addCartByBatch.do")
	@ResponseBody
	public ResponseResult<Void> addCartByBatch(Integer[] goodsids,HttpSession session,int count){
		Cart cart =  new Cart();
		/**
		 * 遍历每个goodsid加入购物车中
		 */
		for (Integer goodsid : goodsids) {
			System.out.println(goodsid);
			System.out.println(count);
			cart.setGoodsid(goodsid);
			cart.setUserid(this.getUid(session));
			cart.setCount(count);
			cartService.addCart(cart);
		}
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"添加成功");
		return rr;
	}
	
	@RequestMapping("/deleteById.do")
	public String deleteById(Integer id) {
		cartService.deleteByCartId(id);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/deleteByBatch.do")
	public String deleteByBatch(Integer[] ids) {
		cartService.deleteByBatch(ids);
		return "redirect:../cart/showCart.do";
	}
	
	@RequestMapping("/updateCountById.do")
	@ResponseBody
	public ResponseResult<Void> updateCountById(Integer count,Integer id){
		cartService.updateById(id, count);
		ResponseResult<Void> rr = new ResponseResult<Void>(1,"修改成功！");
		return rr;
	}
}
