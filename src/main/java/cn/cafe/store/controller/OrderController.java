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
 * ����������
 * 
 * @author ����
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {
	// ����ע��
	@Resource
	private ICartService cartService;
	@Resource
	private IAddressService addressService;
	@Resource
	private IOrderService orderService;
	@Resource
	private IGoodsService goodsService;

	/**
	 * ��ʾȷ�϶���ҳ��
	 * 
	 * @param session
	 * @param ids
	 * @param map
	 * @return
	 */
	@RequestMapping("/showOrder.do")
	public String showOrder(HttpSession session, Integer[] ids, Map<String, Object> map) {
		// 1.����ICartServiceҵ���ķ��������ؼ���List<CartVo>,��ȡ��Ʒ��Ϣ�ļ��� ��ŵ�session��
		List<CartVo> cartVoList = cartService.getOrderByUserid(this.getUid(session), ids);
		session.setAttribute("cartVoList", cartVoList);
		// ����IAddressServiceҵ���ķ��������ؼ���List<Address>,��ȡ��ַ��Ϣ�ļ���
		List<Address> addressList = addressService.getAllAddressByUid(this.getUid(session));
		// 2.�ѷ��ص������������õ�map��
		map.put("cartVoList", cartVoList);
		map.put("addressList", addressList);
		return "orderConfirm";
	}

	/**
	 * ��ʾ֧��ҳ��
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/payment.do")
	public String payment(HttpSession session,ModelMap map) {
		// 1.��sessionȡ��userid
		Integer userid = this.getUid(session);
		// 2.��sessionȡ����list<CartVo>
		List<CartVo> cartVoList = (List<CartVo>) session.getAttribute("cartVoList");
		// 3.����ҵ���ķ���
		Integer orderid = orderService.addOrder(userid, cartVoList);
		session.setAttribute("orderid", orderid);
		
		
		//����ʱ
		//�õ��ö������µ�ʱ��(���ȵõ�������)
		Order order=orderService.getOrderByid(orderid);
		//�µ�ʱ��
		Date date=order.getTradetime();
		Calendar startTime=Calendar.getInstance();
		startTime.setTime(date);
		//����ʱ��
		Calendar currentTime=Calendar.getInstance();
		currentTime.setTime(new Date());
		//��ȡ��ʼʱ��ĺ�����
		long startSecond = startTime.getTimeInMillis();
		//����ʱ��ĺ�����
		long currentSecond = currentTime.getTimeInMillis(); 
		//�ܹ���15����
		long totleSecond =15*60; 
		//ʣ���ʱ�䣨����Ϊ��λ��
		long remainingTime = (totleSecond-(currentSecond-startSecond)/1000);  
		System.out.println(remainingTime);
		if(remainingTime>0){  
			map.addAttribute("remainingTime", remainingTime);  
		}else {
			map.addAttribute("remainingTime", 0);
			//ʧЧ��������
			orderService.updateOrderstatus(orderid);
		}
		return "payment";
	}

	/**
	 * ȷ��֧��ҳ��
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/pay.do")
	public String pay(HttpSession session, ModelMap map) {
		// 1.��ȡOrderid
		Integer orderid = (Integer) session.getAttribute("orderid");
		// 2.����ҵ���ķ���
		orderService.updateStatus(orderid);
		// ��session�л�ȡ���е�cartVo����
		List<CartVo> cartVoList = (List<CartVo>) session.getAttribute("cartVoList");
		// ��session���Ƴ�Orderid��cartVoList
		map.addAttribute("orderid", orderid);
		map.addAttribute("cartVoList", cartVoList);
		session.removeAttribute("orderid");
		session.removeAttribute("cartVoList");
		return "pay_success";
	}
	
	@RequestMapping("/showOrderItem.do")
	public String showOrderItem(HttpSession session, ModelMap map, Integer page) {
		// ��ҳ
		// �������һҳʱ���ǵ�һҳ
		if (page == null) {
			page = 1;
		}
		// ͨ��page����ÿҳ����ʼ ProductCount.COUNT2=4
		int offset = (page - 1) * ProductCount.COUNT2;
		//�����û��õ����û��µ����ж���
		List<Order> orders=orderService.getOrderByUid(this.getUid(session),offset,ProductCount.COUNT2);
		map.addAttribute("orders",orders);
		
		//���û������ж����ŵ�����
		Integer count=orderService.getCount(this.getUid(session));
		
		//��ҳ
		// 1.����ҵ��㣬���ؼ���
		List<OrderItemVo> listItems = orderService.getOrderItems(this.getUid(session));
		// 2.�Ѽ������õ�map������
		map.put("listItems", listItems);

		// �ж�Ӧ���Ǽ�ҳ������ܳ�����Ϊ��������������1
		Integer pageCount = count % ProductCount.COUNT2 == 0 ? count / ProductCount.COUNT2
				: count / ProductCount.COUNT2 + 1;
		
		// ����ҳ��ļ�¼��
		map.put("currentPage", page);//��ǰҳ
		map.put("count", count);//���ݵ�������
		map.put("pageCount", pageCount);//��ҳ��
		return "order";
	}
	/**
	 * ��Ʒ������֧������
	 * @return
	 */
	@RequestMapping("/paymentGoods.do")
	public String  paymentGoods(HttpSession session,Integer id,ModelMap map,Integer count) {
		Integer uid=this.getUid(session);
		// 1.����ICartServiceҵ���ķ��������ؼ���List<CartVo>
		List<CartVo> cartVoList =goodsService.getcartVoById(id);
		Integer orderid = orderService.addOrder(uid, cartVoList,count);
		session.setAttribute("orderid", orderid);
		return "payment";
	}
	/**
	 * �ҵĶ���ҳ��������֧����ʾ֧��ҳ��
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/paymentOrder.do")
	public String paymentOrder(HttpSession session,Integer orderid,ModelMap map) {
		session.setAttribute("orderid", orderid);
		//����ʱ
				//�õ��ö������µ�ʱ��(���ȵõ�������)
				Order order=orderService.getOrderByid(orderid);
				//�µ�ʱ��
				Date date=order.getTradetime();
				Calendar startTime=Calendar.getInstance();
				startTime.setTime(date);
				//����ʱ��
				Calendar currentTime=Calendar.getInstance();
				currentTime.setTime(new Date());
				//��ȡ��ʼʱ��ĺ�����
				long startSecond = startTime.getTimeInMillis();
				System.out.println(startSecond);
				//����ʱ��ĺ�����
				long currentSecond = currentTime.getTimeInMillis(); 
				System.out.println(currentSecond);
				//�ܹ���15����
				long totleSecond =15*60; 
				System.out.println(totleSecond);
				//ʣ���ʱ�䣨����Ϊ��λ��
				long remainingTime = (totleSecond-(currentSecond-startSecond)/1000);  
				System.out.println(remainingTime);
				if(remainingTime>0){  
					map.addAttribute("remainingTime", remainingTime);  
				}else {
					map.addAttribute("remainingTime", 0);  
					//ʧЧ��������
					orderService.updateOrderstatus(orderid);
				}
		return "payment2";
	}
	/**
	 * �ҵĶ����е�����֧����ȷ��֧��ҳ��
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/payOrder.do")//��Ƚ�pay.do ����cartVoList��ȡ  ���Ǵ�orderItemVos��ȡ
	public String payOrder(HttpSession session, ModelMap map) {
		// 1.��ȡOrderid
		Integer orderid = (Integer) session.getAttribute("orderid");
		// 2.����ҵ���ķ���
		orderService.updateStatus(orderid);
		// ��session�л�ȡ���е�orderItemVos����
		List<OrderItemVo> orderItemVos= orderService.getOrderItemsByOrderid(orderid);
		// ��session���Ƴ�Orderid��cartVoList
		map.addAttribute("orderid", orderid);
		map.addAttribute("orderItemVos", orderItemVos);
		session.removeAttribute("orderid");
		return "pay_success";
	}
	
	@RequestMapping("/delete.do")
	public String delete(Integer orderid) {
		/**
		 * ɾ������
		 */
		orderService.deleteOrder(orderid);
		/**
		 * ɾ����������
		 */
		orderService.deleteOrderItem(orderid);
		return "redirect:../order/showOrderItem.do";
	}
	@RequestMapping("showOrderInfo.do")
	public String showOrderInfo(Integer orderid,HttpSession session,ModelMap map) {
		/**
		 * �õ��ջ���ַ����Ϣ
		 */
		List<Address> addresses=addressService.getAllAddressByUid(this.getUid(session));
		/**
		 * �õ��ö����µ���Ʒ��Ϣ
		 */
		List<OrderItemVo> orderItemVos=orderService.getOrderItemsByOrderid(orderid);
		map.addAttribute("orderid", orderid);
		map.addAttribute("addresses",addresses);
		map.addAttribute("orderItemVos",orderItemVos);
		return "orderInfo";
	}
	/*---------------��̨�õ��Ķ�������-----------------------*/
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
