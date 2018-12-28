package cn.cafe.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.cafe.store.bean.Admin;
import cn.cafe.store.bean.User;
import cn.cafe.store.iservice.IAdminService;
import cn.cafe.store.mapper.AdminMapper;
import cn.cafe.store.mapper.UserMapper;
import cn.cafe.store.service.ex.PasswordNotMatchException;
import cn.cafe.store.service.ex.UserNotFoundException;
/**
 * 管理员service的实现类
 * @author 刘飞
 *
 */
@Service
public class AdminService implements IAdminService{
	@Resource
	private AdminMapper adminMapper;
	/**
	 * 管理员登录功能的实现
	 */
	public Admin login(String username, String password) {
		//调用持久层的方法 获取数据库中的admin对象
		Admin admin=adminMapper.getAdminByUsername(username);
		//判断admin对象是否为空
		if(admin==null) {
			//admin空 说明管理员不存在
			throw new UserNotFoundException("管理员账号不正确，请重新填写");
		}else {
			//admin不为空  管理员存在  判断密码是否相等
			if(password.equals(admin.getPassword())) {
				return admin;
			}else {
				throw new PasswordNotMatchException("账号或密码错误");
			}
		}
	}
	//--------------------------用户查询删除修改-------------------------------
	/**
	 * 查询用户信息
	 */
	public List<User> getUserByUsername(String username, Integer offset, Integer count) {
		return adminMapper.getUserByUsername(username, offset, count);
	}
	/**
	 * 查询查询的用户的数量
	 */
	public Integer getCountByUsername(String username) {
		return adminMapper.getCountByUsername(username);
	}
	/**
	 * 删除指定用户id的用户对象信息
	 */
	public void deleteUser(Integer id) {
		//调用持久层的方法
		adminMapper.deleteUser(id);
	}

}
