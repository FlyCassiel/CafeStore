package cn.cafe.store.iservice;

import java.util.List;

import cn.cafe.store.bean.User;

/**
 * IUserService接口 实现解耦
 * 
 * @author 刘飞
 *
 */
public interface IUserService {
	/**
	 * 用户注册
	 * 
	 * @param user
	 *            注册的用户信息
	 */
	void reg(User user);

	/**
	 * 验证用户名是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return yes or no
	 */
	boolean checkUsername(String username);

	/**
	 * 验证电子邮箱是否存在
	 * 
	 * @param email
	 *            电子邮箱
	 * @return yes or no
	 */
	boolean checkEmail(String email);

	/**
	 * 
	 * 验证手机号是否存在
	 * 
	 * @param phone
	 *            手机号
	 * @return yes or no
	 */
	boolean checkPhone(String phone);

	/**
	 * 用户登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            用户密码
	 * @return
	 */
	User login(String username, String password);
	/**
	 * 验证输入的密码是否和数据中的密码一致
	 * @param id
	 * @param oldPassword
	 */
	void checkPassword(Integer id,String oldPassword);
	/**
	 * 修改用户密码
	 * 
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 */
	void changePassword(Integer id, String oldPassword, String newPassword);

	/**
	 * 修改用户信息
	 * 
	 * @param id
	 *            用户id
	 * @param username
	 *            用户username
	 * @param gender
	 *            用户性别
	 * @param phone
	 *            用户电话
	 * @param email
	 *            用户电子邮箱
	 */
	void updatePerson(Integer id, String username, Integer gender, String phone, String email);

	/**
	 * 通过id查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	/**
	 * 得到所有的对象的集合
	 * @return 所有的的用户对象的集合
	 */
	List<User> getUser(Integer offset,Integer count);
	/**
	 * 得到所有用户的数量
	 * @return
	 */
	Integer getCount();
	/**
	 * 修改image的值  头像
	 * @param userid
	 * @param image
	 */
	void updateImage(Integer uid,String image);
}
