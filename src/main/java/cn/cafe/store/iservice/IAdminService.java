package cn.cafe.store.iservice;
/**
 * ��̨����Ա��servcie�ӿ�
 * @author ����
 *
 */

import java.util.List;

import cn.cafe.store.bean.Admin;
import cn.cafe.store.bean.User;

public interface IAdminService {
	/**
	 * ����Ա��¼����
	 * @param username
	 * @param password
	 * @return
	 */
	Admin login(String username,String password);
	//--------------------------�û���ѯɾ���޸�-------------------------------
	/**
	 * �����û�����ѯ�û���Ϣ
	 * @param username
	 * @param offset
	 * @param count
	 * @return
	 */
	List<User> getUserByUsername(String username,Integer offset,Integer count);
	/**
	 * �����û�����ѯһ���ж�������
	 * @param username
	 * @return
	 */
	Integer getCountByUsername(String username);
	/**
	 * ɾ��ָ���û�id�Ķ�����Ϣ
	 * @param id
	 */
	void deleteUser(Integer id);
}
