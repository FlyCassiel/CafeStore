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
	 * 增加地址信息
	 */
	public void addAddress(Address address) {
		// 1.setDistrict 设置省市区连接起来的地址
		// 获取省名称
		String pCode = address.getRecvProvince();
		String pName = dictMapper.getProvinceByCode(pCode);

		// 获得城市名称
		String cCode = address.getRecvCity();
		String cName = dictMapper.getCityByCode(cCode);

		// 获取区的名称
		String aCode = address.getRecvArea();
		String aName = dictMapper.getAreaByCode(aCode);

		address.setRecvDistrict(pName + cName + aName);
		// 2.setIsDefault 设置默认值
		// 判断方法返回的集合中元素的个数，如果是0，isDefault值为1(为默认地址)；否则为0
		List<Address> listA = addressMapper.getAddressByUid(address.getUid());
		if (listA.size() == 0) {
			address.setIsDefault(1);
		} else {
			address.setIsDefault(0);
		}
		addressMapper.insert(address);

	}

	/**
	 * 获得用户的所有地址信息
	 */
	public List<Address> getAllAddressByUid(Integer uid) {
		return addressMapper.getAddressByUid(uid);
	}

	/**
	 * 设置默认地址 首先把所有地址的默认值设置为0 把点击事件的地址id的默认值设置为1
	 */
	public void setDefault(Integer uid, Integer id) {
		/**
		 * 设置所有的收货地址的is_default=0
		 */
		addressMapper.setCancle(uid);
		/**
		 * 设置指定的地址id为is_default=1
		 */
		addressMapper.setDefault(id);
	}

	/**
	 * 根据地址id获得地址信息 回显收货人的地址信息
	 */
	public Address getAddressById(Integer id) {
		Address address=addressMapper.getAddressById(id);
		return address;
	}

	/**
	 * 修改地址信息
	 */
	public void updateAddress(Address address) {
		//表单提交中没有省市区的联合起来的提交  通过表单提交的省市区的code得到想对应的名字
		String pName = dictMapper.getProvinceByCode(address.getRecvProvince());
		String cName = dictMapper.getCityByCode(address.getRecvCity());
		String aName = dictMapper.getAreaByCode(address.getRecvArea());
		address.setRecvDistrict(pName + cName + aName);
		//调用持久层修改
		addressMapper.update(address);
	}

	/**
	 * 删除地址信息，改变地址默认值信息
	 */
	public void deleteAddress(Integer id, Integer uid) {
		//通过地址id得到地址信息
		Address address = addressMapper.getAddressById(id);
		//调用持久层判断受影响的行数
		Integer affectRow = addressMapper.delete(id);
		//受影响的行数等于1的话   说明用户存在  删除成功
		if (affectRow == 1) {
		    //判断删除的地址的id值是否为1   如果为1 说明删除的是默认地址 要重新设置默认地址 
			//如果不是1 说明删除的不是默认地址  不进行操作
			if (address.getIsDefault() == 1) {
				//通过用户id的得到删除后的所有地址信息集合
				List<Address> list = addressMapper.getAddressByUid(uid);
				//如果删除后的地址信息集合的size不等于1  说明还有地址  
				//如果等于0  说明没有地址可以为默认地址了  不进行设置默认地址的操作
				if (list.size() != 0) {
					//设置剩下的第一条为默认地址
					Integer idq=list.get(0).getId();
					addressMapper.setDefault(idq);
				}else {
					System.out.println("空指针异常");
				}
			}
		} else {
			//用户不存在  没有删除数据
			throw new UserNotFoundException("用户不存在  没有删除数据");
		}
	}

}
