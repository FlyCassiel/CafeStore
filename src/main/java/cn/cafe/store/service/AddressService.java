package cn.cafe.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.cafe.store.bean.Address;
import cn.cafe.store.iservice.IAddressService;
import cn.cafe.store.mapper.AddressMapper;
import cn.cafe.store.mapper.DictMapper;
import cn.cafe.store.service.ex.UserNotFoundException;

@Service
public class AddressService implements IAddressService {
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;

	/**
	 * ���ӵ�ַ��Ϣ
	 */
	public void addAddress(Address address) {
		// 1.setDistrict ����ʡ�������������ĵ�ַ
		// ��ȡʡ����
		String pCode = address.getRecvProvince();
		String pName = dictMapper.getProvinceByCode(pCode);

		// ��ó�������
		String cCode = address.getRecvCity();
		String cName = dictMapper.getCityByCode(cCode);

		// ��ȡ��������
		String aCode = address.getRecvArea();
		String aName = dictMapper.getAreaByCode(aCode);

		address.setRecvDistrict(pName + cName + aName);
		// 2.setIsDefault ����Ĭ��ֵ
		// �жϷ������صļ�����Ԫ�صĸ����������0��isDefaultֵΪ1(ΪĬ�ϵ�ַ)������Ϊ0
		List<Address> listA = addressMapper.getAddressByUid(address.getUid());
		if (listA.size() == 0) {
			address.setIsDefault(1);
		} else {
			address.setIsDefault(0);
		}
		addressMapper.insert(address);

	}

	/**
	 * ����û������е�ַ��Ϣ
	 */
	public List<Address> getAllAddressByUid(Integer uid) {
		return addressMapper.getAddressByUid(uid);
	}

	/**
	 * ����Ĭ�ϵ�ַ ���Ȱ����е�ַ��Ĭ��ֵ����Ϊ0 �ѵ���¼��ĵ�ַid��Ĭ��ֵ����Ϊ1
	 */
	public void setDefault(Integer uid, Integer id) {
		/**
		 * �������е��ջ���ַ��is_default=0
		 */
		addressMapper.setCancle(uid);
		/**
		 * ����ָ���ĵ�ַidΪis_default=1
		 */
		addressMapper.setDefault(id);
	}

	/**
	 * ���ݵ�ַid��õ�ַ��Ϣ �����ջ��˵ĵ�ַ��Ϣ
	 */
	public Address getAddressById(Integer id) {
		Address address=addressMapper.getAddressById(id);
		return address;
	}

	/**
	 * �޸ĵ�ַ��Ϣ
	 */
	public void updateAddress(Address address) {
		//���ύ��û��ʡ�����������������ύ  ͨ�����ύ��ʡ������code�õ����Ӧ������
		String pName = dictMapper.getProvinceByCode(address.getRecvProvince());
		String cName = dictMapper.getCityByCode(address.getRecvCity());
		String aName = dictMapper.getAreaByCode(address.getRecvArea());
		address.setRecvDistrict(pName + cName + aName);
		//���ó־ò��޸�
		addressMapper.update(address);
	}

	/**
	 * ɾ����ַ��Ϣ���ı��ַĬ��ֵ��Ϣ
	 */
	public void deleteAddress(Integer id, Integer uid) {
		//ͨ����ַid�õ���ַ��Ϣ
		Address address = addressMapper.getAddressById(id);
		//���ó־ò��ж���Ӱ�������
		Integer affectRow = addressMapper.delete(id);
		//��Ӱ�����������1�Ļ�   ˵���û�����  ɾ���ɹ�
		if (affectRow == 1) {
		    //�ж�ɾ���ĵ�ַ��idֵ�Ƿ�Ϊ1   ���Ϊ1 ˵��ɾ������Ĭ�ϵ�ַ Ҫ��������Ĭ�ϵ�ַ 
			//�������1 ˵��ɾ���Ĳ���Ĭ�ϵ�ַ  �����в���
			if (address.getIsDefault() == 1) {
				//ͨ���û�id�ĵõ�ɾ��������е�ַ��Ϣ����
				List<Address> list = addressMapper.getAddressByUid(uid);
				//���ɾ����ĵ�ַ��Ϣ���ϵ�size������1  ˵�����е�ַ  
				//�������0  ˵��û�е�ַ����ΪĬ�ϵ�ַ��  ����������Ĭ�ϵ�ַ�Ĳ���
				if (list.size() != 0) {
					//����ʣ�µĵ�һ��ΪĬ�ϵ�ַ
					Integer idq=list.get(0).getId();
					addressMapper.setDefault(idq);
				}else {
					System.out.println("��ָ���쳣");
				}
			}
		} else {
			//�û�������  û��ɾ������
			throw new UserNotFoundException("�û�������  û��ɾ������");
		}
	}

}
