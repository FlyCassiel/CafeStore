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
	//��db.properties�ļ��У���ȡ�Σ���salt��ֵ
	@Value("#{dbConfig.salt}")
	private String salt;

	public void reg(User user) {
		// ͨ��ע����û���ȡ���û�����
		User user1 = userMapper.getUserByUsername(user.getUsername());
		if (user1 == null) {
			/**
	    	 * md5����
	    	 */
	    	String str=user.getPassword();
	    	//����md5
	    	System.out.println("reg"+str+salt);
	    	String password = DigestUtils.md5Hex(str+salt);
	    	System.err.println(password);
	    	user.setPassword(password);
	    	//���ܴ������
			// �û��������� ˵������ע��
			userMapper.insert(user);
		} else {
			// �û��Ѵ��ڣ��׳��쳣
			throw new UsernameAlreadyExistException("�û����Ѵ��ڣ�����������" + user.getUsername());
		}
	}

	/**
	 * ��֤�û����Ƿ����
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
	 * ��֤�����ʼ��Ƿ����
	 * 
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email) {
		return userMapper.getCountByEmail(email) > 0;
	}

	/**
	 * ��֤�ֻ����Ƿ����
	 * 
	 * @param phone
	 * @return
	 */
	public boolean checkPhone(String phone) {
		return userMapper.getCountByPhone(phone) > 0;
	}

	/**
	 * �û���¼
	 */
	public User login(String username, String password) {
		// ���÷����õ����ݿ��е�user����
		User user = userMapper.getUserByUsername(username);
		if (user == null) {
			// ˵���û������� �׳��쳣
			throw new UserNotFoundException("�û��������ڣ�username��" + username);
		} else {
			/**
			 * 
	    	 * md5����
	    	 */
			//����md5
			System.out.println("login"+password+salt);
			String str = DigestUtils.md5Hex(password+salt);
			System.out.println(str);
			// ˵���û�������
			if (str.equals(user.getPassword())) {
				// �û��������붼��ȷ
				return user;
			} else {
				// ���벻��ȷ
				throw new PasswordNotMatchException("���벻��ȷ");
			}
		}
	}

	/**
	 * ͨ��id�õ�user����
	 */
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}
	
	/**
	 * ��֤�����Ƿ�����ݿ��е�����һ��
	 */
	public void checkPassword(Integer id, String oldPassword) {
		//��ȡ���ݿ��е�user����
		User user=userMapper.getUserById(id);
		if(user==null) {
			throw new UserNotFoundException("�û������ڣ������Ѿ�������Աɾ��");
		}else {
			/**
			 * md5����oldPassword
			 * 
			 */
			//����md5����
			String md5 = DigestUtils.md5Hex(oldPassword+salt);
			// user���� �жϱ���������������Ƿ�������ݿ��е���������
			if (user.getPassword().equals(md5)) {
				System.out.println("������ͬ");
			}else {
				throw new PasswordNotMatchException("���벻ƥ���쳣");
			}
		}
	}

	/**
	 * �޸��û�������Ϣ
	 */
	public void changePassword(Integer id, String oldPassword, String newPassword) {
		/**
		 * �����û�id�õ�user����
		 */
		User user = userMapper.getUserById(id);
		/**
		 * �ж�user�Ƿ�Ϊ�� �����ǹ���Ա�Ѿ����û�ɾ��
		 */
		if (user == null) {
			throw new UserNotFoundException("�û�������,�����Ѿ�������Աɾ��");
		} else {
			/**
			 * md5����oldPassword
			 * 
			 */
			//����md5����
			String md5 = DigestUtils.md5Hex(oldPassword+salt);
			// user���� �жϱ���������������Ƿ�������ݿ��е���������
			if (user.getPassword().equals(md5)) {
				// ��ȵ������ �����޸������ֶ�
				User u = new User();
				u.setId(id);
				/**
				 * md5����newPassword
				 */
				md5 = DigestUtils.md5Hex(newPassword+salt);
				u.setPassword(md5);
				Integer affectRow=userMapper.update(u);
				System.out.println(affectRow);
			} else {
				throw new PasswordNotMatchException("���벻ƥ���쳣");
			}
		}
	}
	/**
	 * �޸��û���Ϣ
	 */
	public void updatePerson(Integer id, String username, Integer gender, String phone, String email) {
		// �ж��û���
		User user = new User();
		// ���ݿ��е�user��Ϣ
		//�����û�id�õ��û���Ϣ
		User user1 = userMapper.getUserById(id);
		if (user1 == null) {
			throw new UserNotFoundException("�û������ڣ������Ѿ�������Աɾ��");
		} else {
			// user����
			// �жϱ�����������û������ݿ����Ƿ����
			User user2 = userMapper.getUserByUsername(username);
			if (user2 == null) {
				user.setUsername(username);
			} else {
				// ������ݿ��е����ֺͱ��д���������û�������ͬ�ģ���һ��Ҫ�׳��쳣��
				// ��Ϊ�����û�����û���޸� ��
				// �����ж�һ��getUserById().getUsername().equals(username)
				if (user1.getUsername().equals(username)) {
					// �����������޸��û���
				} else {
					throw new UsernameAlreadyExistException("�û����Ѵ���");
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
	 * �õ����е��û����󼯺�
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
