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
		 * ������Ϣ�����ݵļ���
		 */
		List<GoodsCategory> list1=goodsCategoryService.getGoodsCategoryByParentId(0, null, null);
		map.addAttribute("list1",list1);
		/**
		 * ������Ʒ���ݵ���Ϣ����
		 */
		 List<Goods> goodshotList=goodsService.getHotGoods(0, ProductCount.COUNT);
		 map.addAttribute("goodshotList", goodshotList);
		 /**
		  * ������Ʒ���ݵ���Ϣ����
		  */
		List<Goods> goodssaleList=goodsService.getSaleGoods(0, 6);
		map.addAttribute("goodssaleList", goodssaleList);
		List<Goods> goodssaleList2=goodsService.getSaleGoods(6,6);
		map.addAttribute("goodssaleList2", goodssaleList2);
		/**
		 * ���ȶ�����Ʒ��Ϣ����
		 */
		List<Goods> goodsbeanList=goodsService.getGoodsByCategoryId(1, 0, ProductCount.COUNT);
		map.addAttribute("goodsbeanList",goodsbeanList);
		/**
		 * ���ȷ۵���Ʒ����Ϣ����
		 */
		List<Goods> goodsfenList=goodsService.getGoodsByCategoryId(2, 0, ProductCount.COUNT);
		map.addAttribute("goodsfenList",goodsfenList);
		/**
		 * ������ȵ���Ʒ����Ϣ����
		 */
		List<Goods> goodschongList=goodsService.getGoodsByCategoryId(3, 0,4);
		map.addAttribute("goodschongList",goodschongList);
		/**
		 * ��ĥ���ȵ���Ʒ����Ϣ����
		 */
		List<Goods> goodsmoList=goodsService.getGoodsByCategoryId(4, 0,ProductCount.COUNT);
		map.addAttribute("goodsmoList",goodsmoList);
		/**
		 * ���ܿ��ȵ���Ʒ����Ϣ����
		 */
		List<Goods> goodssuList=goodsService.getGoodsByCategoryId(5,0,4);
		map.addAttribute("goodssuList",goodssuList);
		/**
		 * ���ܿ��ȵ���Ʒ����Ϣ����
		 */
		List<Goods> goodsquechaoList=goodsService.getquechaoGoods(0,ProductCount.COUNT);
		map.addAttribute("goodsquechaoList",goodsquechaoList);
		
		return "index";
	}
}
