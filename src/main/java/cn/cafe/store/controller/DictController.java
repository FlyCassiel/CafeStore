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
 * ���������Ŀ�������
 * @author ����
 *
 */
@Controller
@RequestMapping("/dict")
public class DictController extends BaseController{
	@Resource
	private IDictService dictService;
	/**
	 * ��ʾʡ
	 * @return
	 */
	@RequestMapping("/showProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> showProvince(){
		ResponseResult<List<Province>> rr;
		try {
			List<Province> listp=dictService.getProvinces();
			rr=new ResponseResult<List<Province>>(1,"��ȡ��Ϣ�ɹ�",listp);
		} catch (Exception e) {
			rr=new ResponseResult<List<Province>>(0,"ϵͳ�쳣");
		}
		return rr;
	}
	/**
	 * ����ʡ��code�õ���
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
			rr=new ResponseResult<List<City>>(1,"��ȡ��Ϣ�ɹ�",listc);
		} catch (Exception e) {
			rr=new ResponseResult<List<City>>(0,"ϵͳ�쳣");
		}
		return rr;
	}
	/**
	 * �����е�code�õ���
	 * @param cityCode
	 * @return
	 */
	@RequestMapping("/showArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> showArea(String cityCode){
		ResponseResult<List<Area>> rr;
		try {
			List<Area> lista=dictService.getAreas(cityCode);
			rr=new ResponseResult<List<Area>>(1,"�ɹ�",lista);
		} catch (Exception e) {
			rr=new ResponseResult<List<Area>>(0,"ϵͳ�쳣");
		}
		return rr;
	}

}
