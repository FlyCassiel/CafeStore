package cn.cafe.store.mapper;

import java.util.List;

import cn.cafe.store.bean.Address;

/**
 * �ջ���ַ��mapper�ӿ�
 * 
 * @author ����
 *
 */
public interface AddressMapper {
	/***
	 * �����ַ��Ϣ
	 * 
	 * @param address
	 *            �û���Ϣ
	 */
	void insert(Address address);

	/**
	 * ͨ���û�id ��ѯ��ַ��Ϣ���� һ���˿����з�ȵ�ַ�ļ���
	 * 
	 * @param uid
	 *            �û���id
	 * @return �����û��еĵ�ַ�ļ���
	 */
	List<Address> getAddressByUid(Integer uid);

	/**
	 * �޸�uid�������ռ���ַ��is_Dfault��ֵΪ0
	 * 
	 * @param uid
	 *            �û���id �޸��û����е�isDault
	 */
	void setCancle(Integer uid);

	/**
	 * ������¼��ĵ�ַ��isDefault�޸�Ϊ1
	 * 
	 * @param id
	 *            Ҫ�޸ĵĵ�ַid
	 */
	void setDefault(Integer id);

	/**
	 * ͨ��id��ѯAddress������Ϣ �����ջ���������
	 * 
	 * @param id
	 *            �ջ��˵�ַid
	 * @return Address������Ϣ
	 */
	Address getAddressById(Integer id);

	/**
	 * �޸��û���ַ��Ϣ
	 * 
	 * @param address
	 *            �û��±��ύ������
	 */
	void update(Address address);

	/**
	 * ͨ��idɾ���ط���Ϣ
	 * 
	 * @param id
	 *            ��ַ��id
	 * @return
	 */
	Integer delete(Integer id);

}
