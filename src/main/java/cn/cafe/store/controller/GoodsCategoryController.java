package cn.cafe.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cafe.store.bean.GoodsCategory;
import cn.cafe.store.bean.ProductCount;
import cn.cafe.store.bean.ResponseResult;
import cn.cafe.store.bean.User;
import cn.cafe.store.iservice.IGoodsCategoryService;

/**
 * 分类信息控制器层
 * 
 * @author 刘飞
 *
 */
@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryController extends BaseController {
	@Resource
	private IGoodsCategoryService goodsCategoryServcie;

	@RequestMapping("/showGoodsCategory.do")
	public String showGoodsCategory(ModelMap map, Integer page, HttpSession session) {
		// 分页
		// 当点击第一页时就是第一页
		if (page == null) {
			page = 1;
		}
		// 通过page计算每页的起始 ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// 得到所有的数据数量
		Integer count = goodsCategoryServcie.getCount();

		List<GoodsCategory> goodsCategoriesList = goodsCategoryServcie.getGoodsCategory(offset, ProductCount.COUNT);
		map.addAttribute("goodsCategoriesList", goodsCategoriesList);
		// 判断应该是几页，如果能除尽则为两数相除，否则加1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		// 设置页面的记录数
		map.put("currentPage", page);// 当前页
		map.put("count", count);// 数据的总数量
		map.put("pageCount", pageCount);// 总页数
		return "../admin/jsp/goodsCategory/list";
	}

	@RequestMapping("/showQuery.do")
	public String showQuery(String name, ModelMap map, Integer page) {
		// 分页
		// 当点击第一页时就是第一页
		if (page == null) {
			page = 1;
		}
		// 通过page计算每页的起始 ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// 得到用户下的所有数量
		Integer count = goodsCategoryServcie.getCountByname(name);
		// 获得所有的用户信息
		List<GoodsCategory> goodsCategoriesList = goodsCategoryServcie.getGoodsCategoryByName(name, offset, ProductCount.COUNT);
		// 存储到map中
		map.addAttribute("goodsCategoriesList", goodsCategoriesList);

		// 判断应该是几页，如果能除尽则为两数相除，否则加1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		// 设置页面的记录数
		map.put("currentPage", page);// 当前页
		map.put("count", count);// 数据的总数量
		map.put("pageCount", pageCount);// 总页数
		// 查询的用户名回显
		map.addAttribute("name", name);
		return "../admin/jsp/goodsCategory/list";
	}
	@RequestMapping("/deleteGoodsCategory.do")
	public String deleteGoodsCategory(Integer id) {
		goodsCategoryServcie.deleteGoodsCategory(id);
		return "../admin/jsp/goodsCategory/list";
	}
	/**
	 * 展示修改页面
	 * @return
	 */
	@RequestMapping("/showEdit.do")
	public String showEdit(Integer id,ModelMap map) {
		GoodsCategory goodsCategory=goodsCategoryServcie.getGoodsCategoryById(id);
		map.addAttribute("goodsCategory", goodsCategory);
		return "../admin/jsp/goodsCategory/edit";
	}
	/**
	 * 修改用户信息
	 */
	@RequestMapping("/updateGoodsCategory.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(Integer id,String name,HttpSession session) {
		ResponseResult<Void> rr;
		try {
			goodsCategoryServcie.updateGoodsCategory(id, name);
			rr=new ResponseResult<Void>(1,"成功");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/showAdd.do")
	public String showAdd() {
		return "../admin/jsp/goodsCategory/add";
	}
	/**
	 * 添加用户信息
	 * @param goodsCategory
	 * @return
	 */
	@RequestMapping("/insertAdmin.do")
	@ResponseBody
	public ResponseResult<Void> insertAdmin(GoodsCategory goodsCategory) {
		ResponseResult<Void> rr;
		try {
			goodsCategoryServcie.insertGoodsCategoryAdmin(goodsCategory);
			rr=new ResponseResult<Void>(1,"添加成功");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,"添加失败");
		}
		return rr;
	}
}
