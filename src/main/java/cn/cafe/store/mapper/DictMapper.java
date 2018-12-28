package cn.cafe.store.mapper;

import java.util.List;

import cn.cafe.store.bean.Area;
import cn.cafe.store.bean.City;
import cn.cafe.store.bean.Province;

/**
 * 地址三级联动的mapper接口
 * @author 刘飞
 *
 */
public interface DictMapper {
	/**
	 * 得到省对象方法
	 * @return  省的集合
	 */
	List<Province> getProvinces();
	/**
	 * 得到城市对象方法
	 * @param provinceCode 省的code
	 * @return 城市的对象集合
	 */
	List<City> getCities(String provinceCode);
	/**
	 * 得到区对象方法
	 * @param cityCode 城市的code
	 * @return 区的对象集合
	 */
	List<Area> getAreas(String cityCode);
	
	/**
	 * 得到省名字
	 * @param code
	 * @return 省的名字
	 */
	String getProvinceByCode(String code);
	/**
	 * 得到城市名字
	 * @param code
	 * @return 城市的名字
	 */
	String getCityByCode(String code);
	/**
	 * 得到区名字
	 * @param code
	 * @return 区的名字
	 */
	String getAreaByCode(String code);
}
