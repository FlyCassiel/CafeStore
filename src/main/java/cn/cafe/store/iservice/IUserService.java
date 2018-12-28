package cn.cafe.store.iservice;

import java.util.List;

import cn.cafe.store.bean.User;

/**
 * IUserService�ӿ� ʵ�ֽ���
 * 
 * @author ����
 *
 */
public interface IUserService {
	/**
	 * �û�ע��
	 * 
	 * @param user
	 *            ע����û���Ϣ
	 */
	void reg(User user);

	/**
	 * ��֤�û����Ƿ����
	 * 
	 * @param username
	 *            �û���
	 * @return yes or no
	 */
	boolean checkUsername(String username);

	/**
	 * ��֤���������Ƿ����
	 * 
	 * @param email
	 *            ��������
	 * @return yes or no
	 */
	boolean checkEmail(String email);

	/**
	 * 
	 * ��֤�ֻ����Ƿ����
	 * 
	 * @param phone
	 *            �ֻ���
	 * @return yes or no
	 */
	boolean checkPhone(String phone);

	/**
	 * �û���¼
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            �û�����
	 * @return
	 */
	User login(String username, String password);
	/**
	 * ��֤����������Ƿ�������е�����һ��
	 * @param id
	 * @param oldPassword
	 */
	void checkPassword(Integer id,String oldPassword);
	/**
	 * �޸��û�����
	 * 
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 */
	void changePassword(Integer id, String oldPassword, String newPassword);

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param id
	 *            �û�id
	 * @param username
	 *            �û�username
	 * @param gender
	 *            �û��Ա�
	 * @param phone
	 *            �û��绰
	 * @param email
	 *            �û���������
	 */
	void updatePerson(Integer id, String username, Integer gender, String phone, String email);

	/**
	 * ͨ��id��ѯ�û���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	/**
	 * �õ����еĶ���ļ���
	 * @return ���еĵ��û�����ļ���
	 */
	List<User> getUser(Integer offset,Integer count);
	/**
	 * �õ������û�������
	 * @return
	 */
	Integer getCount();
	/**
	 * �޸�image��ֵ  ͷ��
	 * @param userid
	 * @param image
	 */
	void updateImage(Integer uid,String image);
}
