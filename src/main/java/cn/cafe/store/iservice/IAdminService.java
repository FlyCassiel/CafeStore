package cn.cafe.store.iservice;
/**
 * 后台管理员的servcie接口
 * @author 刘飞
 *
 */

import java.util.List;

import cn.cafe.store.bean.Admin;
import cn.cafe.store.bean.User;

public interface IAdminService {
	/**
	 * 管理员登录功能
	 * @param username
	 * @param password
	 * @return
	 */
	Admin login(String username,String password);
	//--------------------------用户查询删除修改-------------------------------
	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @param offset
	 * @param count
	 * @return
	 */
	List<User> getUserByUsername(String username,Integer offset,Integer count);
	/**
	 * 根据用户名查询一共有多少数据
	 * @param username
	 * @return
	 */
	Integer getCountByUsername(String username);
	/**
	 * 删除指定用户id的对象信息
	 * @param id
	 */
	void deleteUser(Integer id);
}
