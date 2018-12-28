package cn.cafe.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.bean.User;

public interface UserMapper {
	/**
	 * 插入方法
	 * @param user 用户信息
	 */
	void insert(User user);
	/**
	 * 查询方法
	 * @param username 用户名
	 * @return 数据库中的用户信息
	 */
	User getUserByUsername(String username);
	/**
	 * 通过邮箱查询数据，如果有返回非0的数
	 * 如果没有返回值为0
	 * @param email
	 * @return
	 */
	Integer getCountByEmail(String email);
	/**
	 * 通过电话号码查询数据，如果有返回非0的数
	 * 如果没有返回值为0
	 * @param phone
	 * @return
	 */
	Integer getCountByPhone(String phone);
	/**
	 * 修改用户信息
	 * @param user
	 */
	Integer update(User user);
	/**
	 * 根据id查询用户信息
	 * @param id 用户id
	 * @return 用户信息
	 */
	User getUserById(Integer id);
	//----------------------------admin后台用到的方法----------------------------------------------
	/**
	 * 得到所有的User对象的集合
	 * @return
	 */
	List<User> getUser(@Param("offset") Integer offset,@Param("count") Integer count);
	/**
	 * 得到所有用户的数量
	 * @return
	 */
	Integer getCount();
	/**
    * 修改头像
    * @param userid
    * @param image
    */
   void updateImageById(@Param("uid") Integer uid,
		   											@Param("image") String image);
	
	
	
}
