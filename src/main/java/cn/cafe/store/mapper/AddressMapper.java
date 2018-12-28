package cn.cafe.store.mapper;

import java.util.List;

import cn.cafe.store.bean.Address;

/**
 * 收货地址的mapper接口
 * 
 * @author 刘飞
 *
 */
public interface AddressMapper {
	/***
	 * 插入地址信息
	 * 
	 * @param address
	 *            用户信息
	 */
	void insert(Address address);

	/**
	 * 通过用户id 查询地址信息集合 一个人可能有风度地址的集合
	 * 
	 * @param uid
	 *            用户的id
	 * @return 返回用户有的地址的集合
	 */
	List<Address> getAddressByUid(Integer uid);

	/**
	 * 修改uid的所有收件地址的is_Dfault的值为0
	 * 
	 * @param uid
	 *            用户的id 修改用户所有的isDault
	 */
	void setCancle(Integer uid);

	/**
	 * 将点击事件的地址的isDefault修改为1
	 * 
	 * @param id
	 *            要修改的地址id
	 */
	void setDefault(Integer id);

	/**
	 * 通过id查询Address对象信息 回显收货人嘻嘻你
	 * 
	 * @param id
	 *            收货人地址id
	 * @return Address对象信息
	 */
	Address getAddressById(Integer id);

	/**
	 * 修改用户地址信息
	 * 
	 * @param address
	 *            用户新表单提交的数据
	 */
	void update(Address address);

	/**
	 * 通过id删除地方信息
	 * 
	 * @param id
	 *            地址的id
	 * @return
	 */
	Integer delete(Integer id);

}
