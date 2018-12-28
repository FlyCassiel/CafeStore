package cn.cafe.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.cafe.store.bean.User;

public interface UserMapper {
	/**
	 * ���뷽��
	 * @param user �û���Ϣ
	 */
	void insert(User user);
	/**
	 * ��ѯ����
	 * @param username �û���
	 * @return ���ݿ��е��û���Ϣ
	 */
	User getUserByUsername(String username);
	/**
	 * ͨ�������ѯ���ݣ�����з��ط�0����
	 * ���û�з���ֵΪ0
	 * @param email
	 * @return
	 */
	Integer getCountByEmail(String email);
	/**
	 * ͨ���绰�����ѯ���ݣ�����з��ط�0����
	 * ���û�з���ֵΪ0
	 * @param phone
	 * @return
	 */
	Integer getCountByPhone(String phone);
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	Integer update(User user);
	/**
	 * ����id��ѯ�û���Ϣ
	 * @param id �û�id
	 * @return �û���Ϣ
	 */
	User getUserById(Integer id);
	//----------------------------admin��̨�õ��ķ���----------------------------------------------
	/**
	 * �õ����е�User����ļ���
	 * @return
	 */
	List<User> getUser(@Param("offset") Integer offset,@Param("count") Integer count);
	/**
	 * �õ������û�������
	 * @return
	 */
	Integer getCount();
	/**
    * �޸�ͷ��
    * @param userid
    * @param image
    */
   void updateImageById(@Param("uid") Integer uid,
		   											@Param("image") String image);
	
	
	
}
