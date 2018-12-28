package cn.cafe.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.cafe.store.bean.Area;
import cn.cafe.store.bean.City;
import cn.cafe.store.bean.Province;
import cn.cafe.store.iservice.IDictService;
import cn.cafe.store.mapper.DictMapper;

/**
 * 三级联动地址的服务层的实现类
 * @author 刘飞
 *
 */
@Service
public class DictService implements IDictService{
	@Resource
	private DictMapper dictMapper;

	public List<Province> getProvinces() {
		return dictMapper.getProvinces();
	}

	public List<City> getCities(String provinceCode) {
		return dictMapper.getCities(provinceCode);
	}

	public List<Area> getAreas(String cityCode) {
		return dictMapper.getAreas(cityCode);
	}

}
