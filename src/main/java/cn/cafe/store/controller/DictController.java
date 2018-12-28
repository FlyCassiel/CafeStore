package cn.cafe.store.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cafe.store.bean.Area;
import cn.cafe.store.bean.City;
import cn.cafe.store.bean.Province;
import cn.cafe.store.bean.ResponseResult;
import cn.cafe.store.iservice.IDictService;


/**
 * 三级联动的控制器类
 * @author 刘飞
 *
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController{
	@Resource
	private IDictService dictService;
	/**
	 * 显示省
	 * @return
	 */
	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr;
		try {
			List<Province> listp=dictService.getProvinces();
			rr=new ResponseResult<List<Province>>(1,"获取信息成功",listp);
		} catch (Exception e) {
			rr=new ResponseResult<List<Province>>(0,"系统异常");
		}
		return rr;
	}
	/**
	 * 根据省的code得到市
	 * @param provinceCode
	 * @return
	 */
	@RequestMapping("/showCity.do")
	@ResponseBody
	public ResponseResult<List<City>> showCity(String provinceCode){
		ResponseResult<List<City>> rr;
		try {
			List<City> listc=dictService.getCities(provinceCode);
			System.out.println(listc);
			rr=new ResponseResult<List<City>>(1,"获取信息成功",listc);
		} catch (Exception e) {
			rr=new ResponseResult<List<City>>(0,"系统异常");
		}
		return rr;
	}
	/**
	 * 根据市的code得到区
	 * @param cityCode
	 * @return
	 */
	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> showArea(String cityCode){
		ResponseResult<List<Area>> rr;
		try {
			List<Area> lista=dictService.getAreas(cityCode);
			rr=new ResponseResult<List<Area>>(1,"成功",lista);
		} catch (Exception e) {
			rr=new ResponseResult<List<Area>>(0,"系统异常");
		}
		return rr;
	}

}
