package cn.cafe.store.iservice;

import java.util.List;
import cn.cafe.store.bean.Address;


/**
 * �ջ���ַ�����ӿ�
 * @author ����
 *
 */
public interface IAddressService {
	/**
	 * ���ӹ��������ַ
	 * @param address
	 */
	void addAddress(Address address);
	/**
	 * ͨ��uid��ѯ��ѯ�û����еĵ�ַ��Ϣ
	 * @param uid �û���id
	 * @return
	 */
	List<Address> getAllAddressByUid(Integer uid);
	
	/**
	 *����Ĭ��
	 * @param uid  �û�id
	 * @param id   �û��ĵ�ַid
	 */
	void setDefault(Integer uid,Integer id);
	/**
	 * ͨ���ջ��˵�ַid��ȡ�û�������Ϣ  �����ջ�����Ϣ
	 * @param id �ջ��˵�ַ��Ϣ
	 * @return �ջ��˵�ַ������Ϣ
	 */
	Address getAddressById(Integer id);
	/**
	 * �޸��û���ַ��Ϣ
	 * @param address  �û���ַ��Ϣ
	 */
	void updateAddress(Address address);
	/**
	 *	ͨ��idɾ����ַ��Ϣ  ͨ��uid������Ĭ�ϵ�ַ��Ϣ  isDefault
	 * @param id ��ַid
	 * @param uid �û�id
	 */
	void deleteAddress(Integer id,Integer uid);
}
