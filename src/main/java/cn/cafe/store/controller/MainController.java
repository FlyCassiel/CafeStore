package cn.cafe.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cafe.store.bean.Goods;
import cn.cafe.store.bean.GoodsCategory;
import cn.cafe.store.bean.ProductCount;
import cn.cafe.store.iservice.IGoodsCategoryService;
import cn.cafe.store.iservice.IGoodsService;

@Controller
@RequestMapping("/main")
public class MainController extends BaseController{
	@Resource
	private IGoodsCategoryService goodsCategoryService;
	
	@Resource
	private IGoodsService goodsService;
	
	@RequestMapping("/showIndex.do")
	private String showIndex(ModelMap map) {   
		/**
		 * 分类信息的数据的集合
		 */
		List<GoodsCategory> list1=goodsCategoryService.getGoodsCategoryByParentId(0, null, null);
		map.addAttribute("list1",list1);
		/**
		 * 热卖商品数据的信息集合
		 */
		 List<Goods> goodshotList=goodsService.getHotGoods(0, ProductCount.COUNT);
		 map.addAttribute("goodshotList", goodshotList);
		 /**
		  * 热卖商品数据的信息集合
		  */
		List<Goods> goodssaleList=goodsService.getSaleGoods(0, 6);
		map.addAttribute("goodssaleList", goodssaleList);
		List<Goods> goodssaleList2=goodsService.getSaleGoods(6,6);
		map.addAttribute("goodssaleList2", goodssaleList2);
		/**
		 * 咖啡豆的商品信息集合
		 */
		List<Goods> goodsbeanList=goodsService.getGoodsByCategoryId(1, 0, ProductCount.COUNT);
		map.addAttribute("goodsbeanList",goodsbeanList);
		/**
		 * 咖啡粉的商品的信息集合
		 */
		List<Goods> goodsfenList=goodsService.getGoodsByCategoryId(2, 0, ProductCount.COUNT);
		map.addAttribute("goodsfenList",goodsfenList);
		/**
		 * 冲调咖啡的商品的信息集合
		 */
		List<Goods> goodschongList=goodsService.getGoodsByCategoryId(3, 0,4);
		map.addAttribute("goodschongList",goodschongList);
		/**
		 * 现磨咖啡的商品的信息集合
		 */
		List<Goods> goodsmoList=goodsService.getGoodsByCategoryId(4, 0,ProductCount.COUNT);
		map.addAttribute("goodsmoList",goodsmoList);
		/**
		 * 速溶咖啡的商品的信息集合
		 */
		List<Goods> goodssuList=goodsService.getGoodsByCategoryId(5,0,4);
		map.addAttribute("goodssuList",goodssuList);
		/**
		 * 速溶咖啡的商品的信息集合
		 */
		List<Goods> goodsquechaoList=goodsService.getquechaoGoods(0,ProductCount.COUNT);
		map.addAttribute("goodsquechaoList",goodsquechaoList);
		
		return "index";
	}
}
