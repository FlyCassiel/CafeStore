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
 * 收藏夹
 * @author 刘飞
 *
 */
@Controller
@RequestMapping("/collect")
public class CollectController extends BaseController{
	@Resource
	private ICollcetServcie collcetServcie;
	
	/**
	 * 显示收藏夹(collect.jsp)页面
	 * @return
	 */
	@RequestMapping("/showCollect.do")
	public String showCollect(HttpSession session,ModelMap map) {
		List<Collect> collectList = collcetServcie.getAll(this.getUid(session));
	    map.put("collectList", collectList);
		return "collect";
	}
	/**
	 * 将商品从商品详情页添加到收藏夹中
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
			rr=new ResponseResult<Void>(1,"收藏成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	/**
	 * 批量删除收藏夹中的商品信息
	 * @param ids
	 * @return
	 */
	@RequestMapping("/deleteByBatch.do")
	@ResponseBody
	public ResponseResult<Void> deleteByBatch(Integer[] goodsids) {
		ResponseResult<Void> rr = null;
		try {
			collcetServcie.deleteByBatch(goodsids);
			rr=new ResponseResult<Void>(1,"删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			rr=new ResponseResult<Void>(0,"删除失败，系统故障，请稍后重试");
		}
		
		return rr;
	}
	/*------------后台展示收藏夹-------------------*/
	@RequestMapping("/showCollectAdmin.do")
	public String showCollect(ModelMap map) {
		List<Collect> collectsList=collcetServcie.getCollect();
		map.addAttribute("collectsList",collectsList);
		return "../admin/jsp/collect/list";
	}
}
