import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cafe.store.Vo.CartVo;
import cn.cafe.store.Vo.OrderItemVo;
import cn.cafe.store.bean.Cart;
import cn.cafe.store.bean.GoodsCategory;
import cn.cafe.store.iservice.ICartService;
import cn.cafe.store.mapper.CartMapper;
import cn.cafe.store.mapper.GoodsCategoryMapper;
import cn.cafe.store.mapper.OrderMapper;

public class Test2 {
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		IGoodsService goodsService=as.getBean("goodsServcie",IGoodsService.class);
		Integer goods=goodsService.getCountByTitle("øß∑»");
		System.out.println(goods);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		CartMapper cartMapper=as.getBean("cartMapper",CartMapper.class);
		Cart cart=new Cart();
		cart.setUserid(1);
		cart.setGoodsid(1);
		cart.setCount(3);
		cartMapper.insert(cart);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		ICartService cartService=as.getBean("cartService",ICartService.class);
		Cart cart=new Cart();
		cart.setUserid(1);
		cart.setGoodsid(2);
		cart.setCount(2);
		cartService.addCart(cart);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		CartMapper cartMapper=as.getBean("cartMapper",CartMapper.class);
		List<CartVo> list=cartMapper.selectAll(1);
		System.out.println(list);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		OrderMapper orderMapper=as.getBean("orderMapper",OrderMapper.class);
		Integer aInteger=orderMapper.getCountByUserid(1);
		System.out.println(aInteger);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		OrderMapper orderMapper=as.getBean("orderMapper",OrderMapper.class);
		List<Integer> orderids=orderMapper.getOrderidByUid(1);
		System.out.println(orderids);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		GoodsCategoryMapper goodsCategoryMapper=as.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		List<GoodsCategory> goodsCategories=goodsCategoryMapper.getGoodsCategoryByName("∂π", 0, 6);
		System.out.println(goodsCategories);
		as.close();
	}*/
	@org.junit.Test
	public void testinsert() {
		/*AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		GoodsCategoryMapper goodsCategoryMapper=as.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		List<GoodsCategory> goodsCategories=goodsCategoryMapper.getGoodsCategoryByName("∂π", 0, 6);
		System.out.println(goodsCategories);
		as.close();*/
		System.out.println(DigestUtils.md5Hex("min1031325684¡ı∑…µƒ√‹¬Î"));
	}
	
}
