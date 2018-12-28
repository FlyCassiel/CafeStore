import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.cafe.store.iservice.IGoodsService;


public class Test {
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		UserMapper userMapper=as.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setUsername("lilili");
		user.setPassword("testtest");
		user.setPhone("15230569330");
		userMapper.insert(user);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		UserMapper userMapper=as.getBean("userMapper",UserMapper.class);
		User user=userMapper.getUserByUsername("lilili");
		System.out.println(user);
		as.close();
		
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		IUserService userService=as.getBean("userService",IUserService.class);
		User user=new User();
		user.setUsername("xiaoxiao");
		user.setPhone("111");
		user.setPassword("111");
		user.setEmail("111");
		userService.reg(user);
		as.close();
		
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		DictMapper dictMapper=as.getBean("dictMapper",DictMapper.class);
		List<Province> listp=dictMapper.getProvinces();
		System.out.println(listp);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		UserMapper userMapper=as.getBean("userMapper",UserMapper.class);
		User user =new User();
		user.setId(1);
		user.setPassword("123456");
		userMapper.update(user);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		AdminMapper adminMapper=as.getBean("adminMapper",AdminMapper.class);
		Admin admin=adminMapper.getAdminByUsername("admin");
		System.out.println(admin);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		IAdminService adminService=as.getBean("adminService",IAdminService.class);
		Admin admin=adminService.login("admin123", "manger");
		System.out.println(admin);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		UserMapper userMapper=as.getBean("userMapper",UserMapper.class);
		Integer count=userMapper.getCount();
		System.out.println(count);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		AdminMapper adminMapper=as.getBean("adminMapper",AdminMapper.class);
		Integer count=adminMapper.getCountByUsername("l");
		System.out.println(count);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		GoodsCategoryMapper goodsCategoryMapper=as.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		List<GoodsCategory> goodsCategories=goodsCategoryMapper.getGoodsCategoryByParentId(0, 0, 10);
		System.out.println(goodsCategories);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		GoodsMapper goodsMapper=as.getBean("goodsMapper",GoodsMapper.class);
		List<Goods> goods=goodsMapper.getGoodsByCategoryId(1, 0, 10);
		System.out.println(goods);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		GoodsMapper goodsMapper=as.getBean("goodsMapper",GoodsMapper.class);
		List<Images> images=goodsMapper.getImagesByProductId(1);
		System.out.println(images);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		GoodsCategoryMapper goodsCategoryMapper=as.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
		GoodsCategory goodsCategory=goodsCategoryMapper.getGoodsCategoryById(1);
		System.out.println(goodsCategory);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		GoodsMapper goodsMapper=as.getBean("goodsMapper",GoodsMapper.class);
		Integer a=goodsMapper.getCountByTitle("¿§·È");
		System.out.println(a);
		as.close();
	}*/
	/*@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		IGoodsService goodsService=as.getBean("goodsServcie",IGoodsService.class);
		List<Goods> goods=goodsService.getGoodsByTitle("¿§·È", 0, 10);
		System.out.println(goods);
		as.close();
	}*/
	@org.junit.Test
	public void testinsert() {
		AbstractApplicationContext as=new ClassPathXmlApplicationContext("spring-mvc.xml","spring-dao.xml","spring-service.xml");
		IGoodsService goodsService=as.getBean("goodsServcie",IGoodsService.class);
		Integer goods=goodsService.getCountByTitle("¿§·È");
		System.out.println(goods);
		as.close();
	}
}
