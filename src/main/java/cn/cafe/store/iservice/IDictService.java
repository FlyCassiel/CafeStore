package cn.cafe.store.iservice;

import java.util.List;

import cn.cafe.store.bean.Area;
import cn.cafe.store.bean.City;
import cn.cafe.store.bean.Province;


/**
 * 三级联动地址的服务层
 * @author 刘飞
 *
 */
public interface IDictService {
	/**
	 * 得到省对象方法列表
	 * @return  省的对象
	 */
	List<Province> getProvinces();
	/**
	 * 得到城市对象方法
	 * @param provinceCode 省的code
	 * @return 城市的对象
	 */
	List<City> getCities(String provinceCode);
	/**
	 * 得到区对象方法
	 * @param cityCode 城市的code
	 * @return 区的对象
	 */
	List<Area> getAreas(String cityCode);
}
