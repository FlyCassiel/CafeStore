package cn.cafe.store.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.cafe.store.bean.Goods;
import cn.cafe.store.bean.GoodsCategory;
import cn.cafe.store.bean.Images;
import cn.cafe.store.bean.ProductCount;
import cn.cafe.store.bean.ResponseResult;
import cn.cafe.store.iservice.IGoodsCategoryService;
import cn.cafe.store.iservice.IGoodsService;

/**
 * 商品的控制器层
 * 
 * @author 刘飞
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	private IGoodsService goodsService;
	@Resource
	private IGoodsCategoryService goodsCategoryService;

	/**
	 * 当点击咖啡豆的时候把1传进来了， 因为在t_goods表中查询数据 索引按照t_goods表中的字段名
	 * 因为有偏移量、页数，所以显示每一页数据，return转发到页面上， 图片等通过集合显示出来
	 * 
	 * @param categoryId
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping("/showGoods.do")
	public String showGoods(Integer categoryId, Integer page, ModelMap map) {
		if (page == null) {
			page = 1;
		}
		// 通过page计算偏移量 ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// 得到商品集合
		List<Goods> listGoods = goodsService.getGoodsByCategoryId(categoryId, offset, ProductCount.COUNT);
		// 得到categoryId下的数量
		Integer count = goodsService.getCount(categoryId);
		// 判断应该是几页，如果能除尽则为两数相除，否则加1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		/**
		 * 通过传输过来的id得到分类对象
		 */
		GoodsCategory goodsCategory = goodsCategoryService.getGoodsCategoryById(categoryId);
		// 设置页面的记录数
		map.addAttribute("currentPage", page);
		map.addAttribute("count", count);
		map.addAttribute("listGoods", listGoods);
		map.addAttribute("pageCount", pageCount);
		map.addAttribute("goodsCategory", goodsCategory);
		map.addAttribute("categoryId", categoryId);

		return "product_search";
	}

	@RequestMapping("/showGoodsByTitle.do")
	public String showGoodsByTitle(String title, Integer page, Map<String, Object> map) {
		if (page == null) {
			page = 1;
		}
		// 偏移量 每页的起始数据
		Integer offset = (page - 1) * ProductCount.COUNT;
		// 获得的goods集合数据
		List<Goods> listGoods = goodsService.getGoodsByTitle(title, offset, ProductCount.COUNT);
		// 获得的goods数量
		Integer count = goodsService.getCountByTitle(title);

		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		map.put("currentPage", page);
		map.put("listGoods", listGoods);
		map.put("title", title);
		map.put("pageCount", pageCount);
		map.put("count", count);
		return "product_search";
	}

	/**
	 * 商品详情页
	 * 
	 * @param id
	 * @param map
	 * @param categoryId
	 * @return
	 */
	@RequestMapping("/showGoodsInfo.do")
	public String showGoodsInfo(Integer id, ModelMap map, Integer categoryId) {
		/*
		 * 通过商品id获得goods对象
		 */
		Goods goods = goodsService.getGoodsById(id);
		/**
		 * 通过商品父类category_id获得goods集合
		 */
		List<Goods> goodsList = goodsService.getGoodsByCategoryId(categoryId, 0, 4);
		/**
		 * 通过商品得到图片集合
		 */
		List<Images> imagesList = goodsService.getImagesByProductId(id);
		// 把值放到map中
		map.addAttribute("goods", goods);
		map.addAttribute("goodsList", goodsList);
		map.addAttribute("imagesList", imagesList);
		return "product_details";
	}

	/*----------------------后台的展示商品信息----------------------------*/
	@RequestMapping("/showAdminGoods.do")
	public String showAdminGoods(Integer page, ModelMap map) {
		if (page == null) {
			page = 1;
		}
		// 通过page计算偏移量 ProductCount.COUNT=4
		int offset = (page - 1) * ProductCount.COUNT4;
		// 得到商品集合
		List<Goods> listGoods = goodsService.getGoods(offset, ProductCount.COUNT4);
		map.addAttribute("listGoods", listGoods);
		// 得到categoryId下的数量
		Integer count = goodsService.getAllCount();
		// 判断应该是几页，如果能除尽则为两数相除，否则加1
		Integer pageCount = count % ProductCount.COUNT4 == 0 ? count / ProductCount.COUNT4
				: count / ProductCount.COUNT4 + 1;
		// 设置页面的记录数
		map.addAttribute("currentPage", page);
		map.addAttribute("count", count);
		map.addAttribute("pageCount", pageCount);
		return "../admin/jsp/product/list";
	}

	/**
	 * 后台的迷糊查询
	 * @param title
	 * @param page
	 * @param map
	 * @return
	 */
	@RequestMapping("/showGoodsByAdminTitle.do")
	public String showGoodsByAdminTitle(String title, Integer page, Map<String, Object> map) {
		if (page == null) {
			page = 1;
		}
		// 偏移量 每页的起始数据
		Integer offset = (page - 1) * ProductCount.COUNT4;
		// 获得的goods集合数据
		List<Goods> listGoods = goodsService.getGoodsByTitle(title, offset, ProductCount.COUNT4);
		// 获得的goods数量
		Integer count = goodsService.getCountByTitle(title);

		Integer pageCount = count % ProductCount.COUNT4 == 0 ? count / ProductCount.COUNT4
				: count / ProductCount.COUNT4 + 1;
		map.put("currentPage", page);
		map.put("listGoods", listGoods);
		map.put("title", title);
		map.put("pageCount", pageCount);
		map.put("count", count);
		return "../admin/jsp/product/list";
	}
	/**
	 * 删除产品
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteAdmin.do")
	@ResponseBody
	public ResponseResult<Void> deleteAdmin(Integer id) {
		ResponseResult<Void> rr;
		try {
			goodsService.delete(id);
			rr = new ResponseResult<Void>(1, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(0, "删除失败，系统故障，请稍后重试！！！");
		}
		return rr;
	}
	/**
	 * 展示商品修改的页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/showEdit.do")
	public String showEdit(Integer id,ModelMap map) {
		Goods goods=goodsService.getGoodsById(id);
		List<GoodsCategory> goodsCategoriesList=goodsCategoryService.getGoodsCategory(null, null);
		map.addAttribute("goods", goods);
		map.addAttribute("goodsCategoriesList", goodsCategoriesList);
		return "../admin/jsp/product/edit";
	}
	@RequestMapping("/editAdmin.do")
	@ResponseBody
	public ResponseResult<Void> editAdmin(Goods goods) {
		System.out.println(goods);
		ResponseResult<Void> rr;
		try {
			goodsService.updateAdmin(goods);
			rr = new ResponseResult<Void>(1, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(0, "修改失败");
		}
		return rr;
	}
	@RequestMapping("/showInsert.do")
	public String showInsert(ModelMap map) {
		List<GoodsCategory> goodsCategoriesList=goodsCategoryService.getGoodsCategory(null, null);
		map.addAttribute("goodsCategoriesList", goodsCategoriesList);
		return "../admin/jsp/product/add";
	}
	@RequestMapping("/insertGoodsAdmin.do")
	@ResponseBody
	public ResponseResult<Void> insertGoodsAdmin(Goods goods) {
		System.out.println(goods);
		ResponseResult<Void> rr;
		try {
			goodsService.insertGoodsAdmin(goods);
			rr = new ResponseResult<Void>(1, "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(0, "添加失败");
		}
		return rr;
	}
	/**
	 * 上传图片
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadImage.do")
	@ResponseBody
	public ResponseResult<Void> uploadImage(MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
			ResponseResult<Void> rr=null;	
			//如果文件不为空，写入上传路径
			if(!file.isEmpty()) {
	           //上传文件路径
	    	  /* String path=session.getServletContext().getRealPath("/upload");*/
	           String path="D:/upload";
				//上传文件名
	           String filename = file.getOriginalFilename();
	           File filepath = new File(path,filename);
	           //判断路径是否存在，如果不存在就创建一个
	           if (!filepath.getParentFile().exists()) { 
	               filepath.getParentFile().mkdirs();
	           }
	           //将上传文件保存到一个目标文件当中
	           file.transferTo(new File(path + File.separator + filename));
	           rr = new ResponseResult<Void>(1, "上传成功");
	       } else {
	    	   rr = new ResponseResult<Void>(0, "上传失败");
	       }
	/*	//修改数据
		System.out.println(this.getUid(session));
		userService.updateImage(this.getUid(session), file.getOriginalFilename());*/
		return rr;		
	}
}
