package cn.cafe.store.iservice;

import java.util.List;

import cn.cafe.store.bean.Area;
import cn.cafe.store.bean.City;
import cn.cafe.store.bean.Province;


/**
 * ����������ַ�ķ����
 * @author ����
 *
 */
public interface IDictService {
	/**
	 * �õ�ʡ���󷽷��б�
	 * @return  ʡ�Ķ���
	 */
	List<Province> getProvinces();
	/**
	 * �õ����ж��󷽷�
	 * @param provinceCode ʡ��code
	 * @return ���еĶ���
	 */
	List<City> getCities(String provinceCode);
	/**
	 * �õ������󷽷�
	 * @param cityCode ���е�code
	 * @return ���Ķ���
	 */
	List<Area> getAreas(String cityCode);
}
