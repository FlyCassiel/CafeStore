package cn.cafe.store.controller;

import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.Vo.OrderItemVo;
import cn.cafe.store.bean.Address;
import cn.cafe.store.bean.Order;
import cn.cafe.store.bean.OrderItem;
import cn.cafe.store.bean.ProductCount;
import cn.cafe.store.iservice.IAddressService;
import cn.cafe.store.iservice.ICartService;
import cn.cafe.store.iservice.IGoodsService;
import cn.cafe.store.iservice.IOrderService;
import cn.cafe.store.service.GoodsServcie;

/**
 * 订单控制器
 * 
 * @author 刘飞
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	// 依赖注入
	@Resource
	private ICartService cartService;
	@Resource
	private IAddressService addressService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IGoodsService goodsService;

	/**
	 * 显示确认订单页面
	 * 
	 * @param session
	 * @param ids
	 * @param map
	 * @return
	 */
	@RequestMapping("/showOrder.do")
	public String showOrder(HttpSession session, Integer[] ids, Map<String, Object> map) {
		// 1.调用ICartService业务层的方法，返回集合List<CartVo>,获取商品信息的集合 存放到session中
		List<CartVo> cartVoList = cartService.getOrderByUserid(this.getUid(session), ids);
		session.setAttribute("cartVoList", cartVoList);
		// 调用IAddressService业务层的方法，返回集合List<Address>,获取地址信息的集合
		List<Address> addressList = addressService.getAllAddressByUid(this.getUid(session));
		// 2.把返回的两个集合设置到map中
		map.put("cartVoList", cartVoList);
		map.put("addressList", addressList);
		return "orderConfirm";
	}

	/**
	 * 显示支付页面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/payment.do")
	public String payment(HttpSession session,ModelMap map) {
		// 1.从session取出userid
		Integer userid = this.getUid(session);
		// 2.从session取集合list<CartVo>
		List<CartVo> cartVoList = (List<CartVo>) session.getAttribute("cartVoList");
		// 3.调用业务层的方法
		Integer orderid = orderService.addOrder(userid, cartVoList);
		session.setAttribute("orderid", orderid);
		
		
		//倒计时
		//得到该订单的下单时间(首先得到本订单)
		Order order=orderService.getOrderByid(orderid);
		//下单时间
		Date date=order.getTradetime();
		Calendar startTime=Calendar.getInstance();
		startTime.setTime(date);
		//现在时间
		Calendar currentTime=Calendar.getInstance();
		currentTime.setTime(new Date());
		//获取开始时间的毫秒数
		long startSecond = startTime.getTimeInMillis();
		//现在时间的毫秒数
		long currentSecond = currentTime.getTimeInMillis(); 
		//总共的15分钟
		long totleSecond =15*60; 
		//剩余的时间（以秒为单位）
		long remainingTime = (totleSecond-(currentSecond-startSecond)/1000);  
		System.out.println(remainingTime);
		if(remainingTime>0){  
			map.addAttribute("remainingTime", remainingTime);  
		}else {
			map.addAttribute("remainingTime", 0);
			//失效订单处理
			orderService.updateOrderstatus(orderid);
		}
		return "payment";
	}

	/**
	 * 确认支付页面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/pay.do")
	public String pay(HttpSession session, ModelMap map) {
		// 1.获取Orderid
		Integer orderid = (Integer) session.getAttribute("orderid");
		// 2.调用业务层的方法
		orderService.updateStatus(orderid);
		// 从session中获取所有的cartVo集合
		List<CartVo> cartVoList = (List<CartVo>) session.getAttribute("cartVoList");
		// 从session中移除Orderid和cartVoList
		map.addAttribute("orderid", orderid);
		map.addAttribute("cartVoList", cartVoList);
		session.removeAttribute("orderid");
		session.removeAttribute("cartVoList");
		return "pay_success";
	}
	
	@RequestMapping("/showOrderItem.do")
	public String showOrderItem(HttpSession session, ModelMap map, Integer page) {
		// 分页
		// 当点击第一页时就是第一页
		if (page == null) {
			page = 1;
		}
		// 通过page计算每页的起始 ProductCount.COUNT2=4
		int offset = (page - 1) * ProductCount.COUNT2;
		//根据用户得到该用户下的所有订单
		List<Order> orders=orderService.getOrderByUid(this.getUid(session),offset,ProductCount.COUNT2);
		map.addAttribute("orders",orders);
		
		//该用户的所有订单号的数量
		Integer count=orderService.getCount(this.getUid(session));
		
		//分页
		// 1.调用业务层，返回集合
		List<OrderItemVo> listItems = orderService.getOrderItems(this.getUid(session));
		// 2.把集合设置到map集合中
		map.put("listItems", listItems);

		// 判断应该是几页，如果能除尽则为两数相除，否则加1
		Integer pageCount = count % ProductCount.COUNT2 == 0 ? count / ProductCount.COUNT2
				: count / ProductCount.COUNT2 + 1;
		
		// 设置页面的记录数
		map.put("currentPage", page);//当前页
		map.put("count", count);//数据的总数量
		map.put("pageCount", pageCount);//总页数
		return "order";
	}
	/**
	 * 商品的立即支付功能
	 * @return
	 */
	@RequestMapping("/paymentGoods.do")
	public String  paymentGoods(HttpSession session,Integer id,ModelMap map,Integer count) {
		Integer uid=this.getUid(session);
		// 1.调用ICartService业务层的方法，返回集合List<CartVo>
		List<CartVo> cartVoList =goodsService.getcartVoById(id);
		Integer orderid = orderService.addOrder(uid, cartVoList,count);
		session.setAttribute("orderid", orderid);
		return "payment";
	}
	/**
	 * 我的订单页面中立即支付显示支付页面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/paymentOrder.do")
	public String paymentOrder(HttpSession session,Integer orderid,ModelMap map) {
		session.setAttribute("orderid", orderid);
		//倒计时
				//得到该订单的下单时间(首先得到本订单)
				Order order=orderService.getOrderByid(orderid);
				//下单时间
				Date date=order.getTradetime();
				Calendar startTime=Calendar.getInstance();
				startTime.setTime(date);
				//现在时间
				Calendar currentTime=Calendar.getInstance();
				currentTime.setTime(new Date());
				//获取开始时间的毫秒数
				long startSecond = startTime.getTimeInMillis();
				System.out.println(startSecond);
				//现在时间的毫秒数
				long currentSecond = currentTime.getTimeInMillis(); 
				System.out.println(currentSecond);
				//总共的15分钟
				long totleSecond =15*60; 
				System.out.println(totleSecond);
				//剩余的时间（以秒为单位）
				long remainingTime = (totleSecond-(currentSecond-startSecond)/1000);  
				System.out.println(remainingTime);
				if(remainingTime>0){  
					map.addAttribute("remainingTime", remainingTime);  
				}else {
					map.addAttribute("remainingTime", 0);  
					//失效订单处理
					orderService.updateOrderstatus(orderid);
				}
		return "payment2";
	}
	/**
	 * 我的订单中的立即支付的确认支付页面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/payOrder.do")//相比较pay.do 不是cartVoList中取  而是从orderItemVos中取
	public String payOrder(HttpSession session, ModelMap map) {
		// 1.获取Orderid
		Integer orderid = (Integer) session.getAttribute("orderid");
		// 2.调用业务层的方法
		orderService.updateStatus(orderid);
		// 从session中获取所有的orderItemVos集合
		List<OrderItemVo> orderItemVos= orderService.getOrderItemsByOrderid(orderid);
		// 从session中移除Orderid和cartVoList
		map.addAttribute("orderid", orderid);
		map.addAttribute("orderItemVos", orderItemVos);
		session.removeAttribute("orderid");
		return "pay_success";
	}
	
	@RequestMapping("/delete.do")
	public String delete(Integer orderid) {
		/**
		 * 删除订单
		 */
		orderService.deleteOrder(orderid);
		/**
		 * 删除订单详情
		 */
		orderService.deleteOrderItem(orderid);
		return "redirect:../order/showOrderItem.do";
	}
	@RequestMapping("showOrderInfo.do")
	public String showOrderInfo(Integer orderid,HttpSession session,ModelMap map) {
		/**
		 * 得到收货地址的信息
		 */
		List<Address> addresses=addressService.getAllAddressByUid(this.getUid(session));
		/**
		 * 得到该订单下的商品信息
		 */
		List<OrderItemVo> orderItemVos=orderService.getOrderItemsByOrderid(orderid);
		map.addAttribute("orderid", orderid);
		map.addAttribute("addresses",addresses);
		map.addAttribute("orderItemVos",orderItemVos);
		return "orderInfo";
	}
	/*---------------后台用到的订单管理-----------------------*/
	@RequestMapping("/showOrderAdmin.do")
	public String showOrderAdmin(ModelMap map) {
		List<Order> orderList=orderService.getOrderAdmin();
		map.addAttribute("orderList", orderList);
		return "../admin/jsp/order/list";
	}
	@RequestMapping("/showOrderItemAdmin.do")
	public String showOrderItemAdmin(ModelMap map) {
		List<OrderItem> orderItemsList=orderService.getOrderItemAdmin();
		map.addAttribute("orderItemsList", orderItemsList);
		return "../admin/jsp/order/orderItem";
	}
}
