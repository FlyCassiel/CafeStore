package cn.cafe.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.cafe.store.bean.User;
import cn.cafe.store.iservice.IUserService;
import cn.cafe.store.mapper.UserMapper;
import cn.cafe.store.service.ex.PasswordNotMatchException;
import cn.cafe.store.service.ex.UserNotFoundException;
import cn.cafe.store.service.ex.UsernameAlreadyExistException;

@Service
public class UserService implements IUserService {

	@Resource
	private UserMapper userMapper;
	//从db.properties文件中，获取盐，给salt赋值
	@Value("#{dbConfig.salt}")
	private String salt;

	public void reg(User user) {
		// 通过注册的用户名取得用户对象
		User user1 = userMapper.getUserByUsername(user.getUsername());
		if (user1 == null) {
			/**
	    	 * md5加密
	    	 */
	    	String str=user.getPassword();
	    	//生成md5
	    	System.out.println("reg"+str+salt);
	    	String password = DigestUtils.md5Hex(str+salt);
	    	System.err.println(password);
	    	user.setPassword(password);
	    	//加密处理完毕
			// 用户名不存在 说明可以注册
			userMapper.insert(user);
		} else {
			// 用户已存在，抛出异常
			throw new UsernameAlreadyExistException("用户名已存在，请重新输入" + user.getUsername());
		}
	}

	/**
	 * 验证用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username) {
		if (userMapper.getUserByUsername(username) == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 验证电子邮件是否存在
	 * 
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email) {
		return userMapper.getCountByEmail(email) > 0;
	}

	/**
	 * 验证手机号是否存在
	 * 
	 * @param phone
	 * @return
	 */
	public boolean checkPhone(String phone) {
		return userMapper.getCountByPhone(phone) > 0;
	}

	/**
	 * 用户登录
	 */
	public User login(String username, String password) {
		// 调用方法得到数据库中的user对象
		User user = userMapper.getUserByUsername(username);
		if (user == null) {
			// 说明用户不存在 抛出异常
			throw new UserNotFoundException("用户名不存在：username：" + username);
		} else {
			/**
			 * 
	    	 * md5加密
	    	 */
			//生成md5
			System.out.println("login"+password+salt);
			String str = DigestUtils.md5Hex(password+salt);
			System.out.println(str);
			// 说明用户名存在
			if (str.equals(user.getPassword())) {
				// 用户名和密码都正确
				return user;
			} else {
				// 密码不正确
				throw new PasswordNotMatchException("密码不正确");
			}
		}
	}

	/**
	 * 通过id得到user对象
	 */
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}
	
	/**
	 * 验证密码是否和数据库中的密码一致
	 */
	public void checkPassword(Integer id, String oldPassword) {
		//获取数据库中的user对象
		User user=userMapper.getUserById(id);
		if(user==null) {
			throw new UserNotFoundException("用户不存在，可能已经被管理员删除");
		}else {
			/**
			 * md5加密oldPassword
			 * 
			 */
			//生成md5密码
			String md5 = DigestUtils.md5Hex(oldPassword+salt);
			// user存在 判断表单传输过来的数据是否等于数据库中的密码数据
			if (user.getPassword().equals(md5)) {
				System.out.println("密码相同");
			}else {
				throw new PasswordNotMatchException("密码不匹配异常");
			}
		}
	}

	/**
	 * 修改用户密码信息
	 */
	public void changePassword(Integer id, String oldPassword, String newPassword) {
		/**
		 * 根据用户id得到user对象
		 */
		User user = userMapper.getUserById(id);
		/**
		 * 判断user是否为空 可能是管理员已经把用户删除
		 */
		if (user == null) {
			throw new UserNotFoundException("用户不存在,可能已经被管理员删除");
		} else {
			/**
			 * md5加密oldPassword
			 * 
			 */
			//生成md5密码
			String md5 = DigestUtils.md5Hex(oldPassword+salt);
			// user存在 判断表单传输过来的数据是否等于数据库中的密码数据
			if (user.getPassword().equals(md5)) {
				// 相等的情况下 进行修改密码字段
				User u = new User();
				u.setId(id);
				/**
				 * md5加密newPassword
				 */
				md5 = DigestUtils.md5Hex(newPassword+salt);
				u.setPassword(md5);
				Integer affectRow=userMapper.update(u);
				System.out.println(affectRow);
			} else {
				throw new PasswordNotMatchException("密码不匹配异常");
			}
		}
	}
	/**
	 * 修改用户信息
	 */
	public void updatePerson(Integer id, String username, Integer gender, String phone, String email) {
		// 判断用户名
		User user = new User();
		// 数据库中的user信息
		//根据用户id得到用户信息
		User user1 = userMapper.getUserById(id);
		if (user1 == null) {
			throw new UserNotFoundException("用户不存在，可能已经被管理员删除");
		} else {
			// user存在
			// 判断表单传输过来的用户名数据库中是否存在
			User user2 = userMapper.getUserByUsername(username);
			if (user2 == null) {
				user.setUsername(username);
			} else {
				// 如果数据库中的名字和表单中传输过来的用户名有相同的，不一定要抛出异常，
				// 因为可能用户名并没有修改 ，
				// 所以判断一下getUserById().getUsername().equals(username)
				if (user1.getUsername().equals(username)) {
					// 不做处理，不修改用户名
				} else {
					throw new UsernameAlreadyExistException("用户名已存在");
				}
			}
		}
		user.setId(id);
		user.setGender(gender);
		user.setPhone(phone);
		user.setEmail(email);
		userMapper.update(user);
	}
	/**
	 * 得到所有的用户对象集合
	 */
	public List<User> getUser(Integer offset,Integer count) {
		return userMapper.getUser(offset, count);
	}

	public Integer getCount() {
		return userMapper.getCount();
	}

	public void updateImage(Integer uid, String image) {
		userMapper.updateImageById(uid, image);
	}

	

}
