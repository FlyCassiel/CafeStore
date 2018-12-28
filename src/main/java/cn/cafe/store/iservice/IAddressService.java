package cn.cafe.store.iservice;

import java.util.List;
import cn.cafe.store.bean.Address;


/**
 * 收货地址服务层接口
 * @author 刘飞
 *
 */
public interface IAddressService {
	/**
	 * 增加购物详情地址
	 * @param address
	 */
	void addAddress(Address address);
	/**
	 * 通过uid查询查询用户所有的地址信息
	 * @param uid 用户的id
	 * @return
	 */
	List<Address> getAllAddressByUid(Integer uid);
	
	/**
	 *设置默认
	 * @param uid  用户id
	 * @param id   用户的地址id
	 */
	void setDefault(Integer uid,Integer id);
	/**
	 * 通过收货人地址id获取用户对象信息  回显收货人信息
	 * @param id 收货人地址信息
	 * @return 收货人地址对象信息
	 */
	Address getAddressById(Integer id);
	/**
	 * 修改用户地址信息
	 * @param address  用户地址信息
	 */
	void updateAddress(Address address);
	/**
	 *	通过id删除地址信息  通过uid来设置默认地址信息  isDefault
	 * @param id 地址id
	 * @param uid 用户id
	 */
	void deleteAddress(Integer id,Integer uid);
}
