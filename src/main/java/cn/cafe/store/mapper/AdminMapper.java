package cn.cafe.store.mapper;

import java.util.List;

import org.apache.el.util.Validation;
import org.apache.ibatis.annotations.Param;

import cn.cafe.store.bean.Admin;
import cn.cafe.store.bean.User;

/**
 * 后台管理员的mapper接口
 * @author 刘飞
 *
 */
public interface AdminMapper {
	/**
	 * 查询管理员的用户信息
	 * @param username 管理员的名字
	 * @return 管理员的信息对象
	 */
	Admin getAdminByUsername(String username);
	//----------------------用户的查询修改和删除----------------------------------------
	/**
	 * 查询用户信息  迷糊查询
	 * @param username 用户名
	 * @return
	 */
	List<User> getUserByUsername(@Param("username") String username,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * 根据用户名查询一共有多少条数据
	 * @param username
	 * @return
	 */
	Integer getCountByUsername(String username);
	/**
	 * 删除指定用户id的对象
	 * @param id
	 */
	void deleteUser(Integer id);
}
