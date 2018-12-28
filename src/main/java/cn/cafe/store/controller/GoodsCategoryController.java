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
 * ������Ϣ��������
 * 
 * @author ����
 *
 */
@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryController extends BaseController {
	@Resource
	private IGoodsCategoryService goodsCategoryServcie;

	@RequestMapping("/showGoodsCategory.do")
	public String showGoodsCategory(ModelMap map, Integer page, HttpSession session) {
		// ��ҳ
		// �������һҳʱ���ǵ�һҳ
		if (page == null) {
			page = 1;
		}
		// ͨ��page����ÿҳ����ʼ ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// �õ����е���������
		Integer count = goodsCategoryServcie.getCount();

		List<GoodsCategory> goodsCategoriesList = goodsCategoryServcie.getGoodsCategory(offset, ProductCount.COUNT);
		map.addAttribute("goodsCategoriesList", goodsCategoriesList);
		// �ж�Ӧ���Ǽ�ҳ������ܳ�����Ϊ��������������1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		// ����ҳ��ļ�¼��
		map.put("currentPage", page);// ��ǰҳ
		map.put("count", count);// ���ݵ�������
		map.put("pageCount", pageCount);// ��ҳ��
		return "../admin/jsp/goodsCategory/list";
	}

	@RequestMapping("/showQuery.do")
	public String showQuery(String name, ModelMap map, Integer page) {
		// ��ҳ
		// �������һҳʱ���ǵ�һҳ
		if (page == null) {
			page = 1;
		}
		// ͨ��page����ÿҳ����ʼ ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// �õ��û��µ���������
		Integer count = goodsCategoryServcie.getCountByname(name);
		// ������е��û���Ϣ
		List<GoodsCategory> goodsCategoriesList = goodsCategoryServcie.getGoodsCategoryByName(name, offset, ProductCount.COUNT);
		// �洢��map��
		map.addAttribute("goodsCategoriesList", goodsCategoriesList);

		// �ж�Ӧ���Ǽ�ҳ������ܳ�����Ϊ��������������1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		// ����ҳ��ļ�¼��
		map.put("currentPage", page);// ��ǰҳ
		map.put("count", count);// ���ݵ�������
		map.put("pageCount", pageCount);// ��ҳ��
		// ��ѯ���û�������
		map.addAttribute("name", name);
		return "../admin/jsp/goodsCategory/list";
	}
	@RequestMapping("/deleteGoodsCategory.do")
	public String deleteGoodsCategory(Integer id) {
		goodsCategoryServcie.deleteGoodsCategory(id);
		return "../admin/jsp/goodsCategory/list";
	}
	/**
	 * չʾ�޸�ҳ��
	 * @return
	 */
	@RequestMapping("/showEdit.do")
	public String showEdit(Integer id,ModelMap map) {
		GoodsCategory goodsCategory=goodsCategoryServcie.getGoodsCategoryById(id);
		map.addAttribute("goodsCategory", goodsCategory);
		return "../admin/jsp/goodsCategory/edit";
	}
	/**
	 * �޸��û���Ϣ
	 */
	@RequestMapping("/updateGoodsCategory.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(Integer id,String name,HttpSession session) {
		ResponseResult<Void> rr;
		try {
			goodsCategoryServcie.updateGoodsCategory(id, name);
			rr=new ResponseResult<Void>(1,"�ɹ�");
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
	 * ����û���Ϣ
	 * @param goodsCategory
	 * @return
	 */
	@RequestMapping("/insertAdmin.do")
	@ResponseBody
	public ResponseResult<Void> insertAdmin(GoodsCategory goodsCategory) {
		ResponseResult<Void> rr;
		try {
			goodsCategoryServcie.insertGoodsCategoryAdmin(goodsCategory);
			rr=new ResponseResult<Void>(1,"��ӳɹ�");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,"���ʧ��");
		}
		return rr;
	}
}
