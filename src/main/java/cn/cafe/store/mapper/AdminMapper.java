package cn.cafe.store.mapper;

import java.util.List;

import org.apache.el.util.Validation;
import org.apache.ibatis.annotations.Param;

import cn.cafe.store.bean.Admin;
import cn.cafe.store.bean.User;

/**
 * ��̨����Ա��mapper�ӿ�
 * @author ����
 *
 */
public interface AdminMapper {
	/**
	 * ��ѯ����Ա���û���Ϣ
	 * @param username ����Ա������
	 * @return ����Ա����Ϣ����
	 */
	Admin getAdminByUsername(String username);
	//----------------------�û��Ĳ�ѯ�޸ĺ�ɾ��----------------------------------------
	/**
	 * ��ѯ�û���Ϣ  �Ժ���ѯ
	 * @param username �û���
	 * @return
	 */
	List<User> getUserByUsername(@Param("username") String username,
			@Param("offset") Integer offset,
			@Param("count") Integer count);
	/**
	 * �����û�����ѯһ���ж���������
	 * @param username
	 * @return
	 */
	Integer getCountByUsername(String username);
	/**
	 * ɾ��ָ���û�id�Ķ���
	 * @param id
	 */
	void deleteUser(Integer id);
}
