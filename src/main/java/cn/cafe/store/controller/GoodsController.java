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
 * ��Ʒ�Ŀ�������
 * 
 * @author ����
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
	 * ��������ȶ���ʱ���1�������ˣ� ��Ϊ��t_goods���в�ѯ���� ��������t_goods���е��ֶ���
	 * ��Ϊ��ƫ������ҳ����������ʾÿһҳ���ݣ�returnת����ҳ���ϣ� ͼƬ��ͨ��������ʾ����
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
		// ͨ��page����ƫ���� ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// �õ���Ʒ����
		List<Goods> listGoods = goodsService.getGoodsByCategoryId(categoryId, offset, ProductCount.COUNT);
		// �õ�categoryId�µ�����
		Integer count = goodsService.getCount(categoryId);
		// �ж�Ӧ���Ǽ�ҳ������ܳ�����Ϊ��������������1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		/**
		 * ͨ�����������id�õ��������
		 */
		GoodsCategory goodsCategory = goodsCategoryService.getGoodsCategoryById(categoryId);
		// ����ҳ��ļ�¼��
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
		// ƫ���� ÿҳ����ʼ����
		Integer offset = (page - 1) * ProductCount.COUNT;
		// ��õ�goods��������
		List<Goods> listGoods = goodsService.getGoodsByTitle(title, offset, ProductCount.COUNT);
		// ��õ�goods����
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
	 * ��Ʒ����ҳ
	 * 
	 * @param id
	 * @param map
	 * @param categoryId
	 * @return
	 */
	@RequestMapping("/showGoodsInfo.do")
	public String showGoodsInfo(Integer id, ModelMap map, Integer categoryId) {
		/*
		 * ͨ����Ʒid���goods����
		 */
		Goods goods = goodsService.getGoodsById(id);
		/**
		 * ͨ����Ʒ����category_id���goods����
		 */
		List<Goods> goodsList = goodsService.getGoodsByCategoryId(categoryId, 0, 4);
		/**
		 * ͨ����Ʒ�õ�ͼƬ����
		 */
		List<Images> imagesList = goodsService.getImagesByProductId(id);
		// ��ֵ�ŵ�map��
		map.addAttribute("goods", goods);
		map.addAttribute("goodsList", goodsList);
		map.addAttribute("imagesList", imagesList);
		return "product_details";
	}

	/*----------------------��̨��չʾ��Ʒ��Ϣ----------------------------*/
	@RequestMapping("/showAdminGoods.do")
	public String showAdminGoods(Integer page, ModelMap map) {
		if (page == null) {
			page = 1;
		}
		// ͨ��page����ƫ���� ProductCount.COUNT=4
		int offset = (page - 1) * ProductCount.COUNT4;
		// �õ���Ʒ����
		List<Goods> listGoods = goodsService.getGoods(offset, ProductCount.COUNT4);
		map.addAttribute("listGoods", listGoods);
		// �õ�categoryId�µ�����
		Integer count = goodsService.getAllCount();
		// �ж�Ӧ���Ǽ�ҳ������ܳ�����Ϊ��������������1
		Integer pageCount = count % ProductCount.COUNT4 == 0 ? count / ProductCount.COUNT4
				: count / ProductCount.COUNT4 + 1;
		// ����ҳ��ļ�¼��
		map.addAttribute("currentPage", page);
		map.addAttribute("count", count);
		map.addAttribute("pageCount", pageCount);
		return "../admin/jsp/product/list";
	}

	/**
	 * ��̨���Ժ���ѯ
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
		// ƫ���� ÿҳ����ʼ����
		Integer offset = (page - 1) * ProductCount.COUNT4;
		// ��õ�goods��������
		List<Goods> listGoods = goodsService.getGoodsByTitle(title, offset, ProductCount.COUNT4);
		// ��õ�goods����
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
	 * ɾ����Ʒ
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteAdmin.do")
	@ResponseBody
	public ResponseResult<Void> deleteAdmin(Integer id) {
		ResponseResult<Void> rr;
		try {
			goodsService.delete(id);
			rr = new ResponseResult<Void>(1, "ɾ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(0, "ɾ��ʧ�ܣ�ϵͳ���ϣ����Ժ����ԣ�����");
		}
		return rr;
	}
	/**
	 * չʾ��Ʒ�޸ĵ�ҳ��
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
			rr = new ResponseResult<Void>(1, "�޸ĳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(0, "�޸�ʧ��");
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
			rr = new ResponseResult<Void>(1, "��ӳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(0, "���ʧ��");
		}
		return rr;
	}
	/**
	 * �ϴ�ͼƬ
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadImage.do")
	@ResponseBody
	public ResponseResult<Void> uploadImage(MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
			ResponseResult<Void> rr=null;	
			//����ļ���Ϊ�գ�д���ϴ�·��
			if(!file.isEmpty()) {
	           //�ϴ��ļ�·��
	    	  /* String path=session.getServletContext().getRealPath("/upload");*/
	           String path="D:/upload";
				//�ϴ��ļ���
	           String filename = file.getOriginalFilename();
	           File filepath = new File(path,filename);
	           //�ж�·���Ƿ���ڣ���������ھʹ���һ��
	           if (!filepath.getParentFile().exists()) { 
	               filepath.getParentFile().mkdirs();
	           }
	           //���ϴ��ļ����浽һ��Ŀ���ļ�����
	           file.transferTo(new File(path + File.separator + filename));
	           rr = new ResponseResult<Void>(1, "�ϴ��ɹ�");
	       } else {
	    	   rr = new ResponseResult<Void>(0, "�ϴ�ʧ��");
	       }
	/*	//�޸�����
		System.out.println(this.getUid(session));
		userService.updateImage(this.getUid(session), file.getOriginalFilename());*/
		return rr;		
	}
}
