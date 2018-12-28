package cn.cafe.store.mapper;

import java.util.List;

import cn.cafe.store.bean.Area;
import cn.cafe.store.bean.City;
import cn.cafe.store.bean.Province;

/**
 * ��ַ����������mapper�ӿ�
 * @author ����
 *
 */
public interface DictMapper {
	/**
	 * �õ�ʡ���󷽷�
	 * @return  ʡ�ļ���
	 */
	List<Province> getProvinces();
	/**
	 * �õ����ж��󷽷�
	 * @param provinceCode ʡ��code
	 * @return ���еĶ��󼯺�
	 */
	List<City> getCities(String provinceCode);
	/**
	 * �õ������󷽷�
	 * @param cityCode ���е�code
	 * @return ���Ķ��󼯺�
	 */
	List<Area> getAreas(String cityCode);
	
	/**
	 * �õ�ʡ����
	 * @param code
	 * @return ʡ������
	 */
	String getProvinceByCode(String code);
	/**
	 * �õ���������
	 * @param code
	 * @return ���е�����
	 */
	String getCityByCode(String code);
	/**
	 * �õ�������
	 * @param code
	 * @return ��������
	 */
	String getAreaByCode(String code);
}
