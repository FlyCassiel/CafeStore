package cn.cafe.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cafe.store.bean.Collect;
import cn.cafe.store.bean.ResponseResult;
import cn.cafe.store.iservice.ICollcetServcie;


/**
 * �ղؼ�
 * @author ����
 *
 */
@Controller
@RequestMapping("/collect")
public class CollectController extends BaseController{
	@Resource
	private ICollcetServcie collcetServcie;
	
	/**
	 * ��ʾ�ղؼ�(collect.jsp)ҳ��
	 * @return
	 */
	@RequestMapping("/showCollect.do")
	public String showCollect(HttpSession session,ModelMap map) {
		List<Collect> collectList = collcetServcie.getAll(this.getUid(session));
	    map.put("collectList", collectList);
		return "collect";
	}
	/**
	 * ����Ʒ����Ʒ����ҳ��ӵ��ղؼ���
	 * @param goodsid
	 * @param session
	 * @param count
	 * @return
	 */
	@RequestMapping("/addCollect.do")
	@ResponseBody
	public ResponseResult<Void> addCollect(Integer goodsid,String title,Double price,String image,HttpSession session){
		ResponseResult<Void> rr = null;
		Collect collect=new Collect();
		collect.setGoodsid(goodsid);
		collect.setUserid(this.getUid(session));
		collect.setTitle(title);
		collect.setPrice(price);
		collect.setImage(image);
		try {
			collcetServcie.addCollect(collect);
			rr=new ResponseResult<Void>(1,"�ղسɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	/**
	 * ����ɾ���ղؼ��е���Ʒ��Ϣ
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteByBatch.do")
	@ResponseBody
	public ResponseResult<Void> deleteByBatch(Integer[] goodsids) {
		ResponseResult<Void> rr = null;
		try {
			collcetServcie.deleteByBatch(goodsids);
			rr=new ResponseResult<Void>(1,"ɾ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			rr=new ResponseResult<Void>(0,"ɾ��ʧ�ܣ�ϵͳ���ϣ����Ժ�����");
		}
		
		return rr;
	}
	/*------------��̨չʾ�ղؼ�-------------------*/
	@RequestMapping("/showCollectAdmin.do")
	public String showCollect(ModelMap map) {
		List<Collect> collectsList=collcetServcie.getCollect();
		map.addAttribute("collectsList",collectsList);
		return "../admin/jsp/collect/list";
	}
}
