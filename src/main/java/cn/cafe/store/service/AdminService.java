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
 * ����Աservice��ʵ����
 * @author ����
 *
 */
@Service
public class AdminService implements IAdminService{
	@Resource
	private AdminMapper adminMapper;
	/**
	 * ����Ա��¼���ܵ�ʵ��
	 */
	public Admin login(String username, String password) {
		//���ó־ò�ķ��� ��ȡ���ݿ��е�admin����
		Admin admin=adminMapper.getAdminByUsername(username);
		//�ж�admin�����Ƿ�Ϊ��
		if(admin==null) {
			//admin�� ˵������Ա������
			throw new UserNotFoundException("����Ա�˺Ų���ȷ����������д");
		}else {
			//admin��Ϊ��  ����Ա����  �ж������Ƿ����
			if(password.equals(admin.getPassword())) {
				return admin;
			}else {
				throw new PasswordNotMatchException("�˺Ż��������");
			}
		}
	}
	//--------------------------�û���ѯɾ���޸�-------------------------------
	/**
	 * ��ѯ�û���Ϣ
	 */
	public List<User> getUserByUsername(String username, Integer offset, Integer count) {
		return adminMapper.getUserByUsername(username, offset, count);
	}
	/**
	 * ��ѯ��ѯ���û�������
	 */
	public Integer getCountByUsername(String username) {
		return adminMapper.getCountByUsername(username);
	}
	/**
	 * ɾ��ָ���û�id���û�������Ϣ
	 */
	public void deleteUser(Integer id) {
		//���ó־ò�ķ���
		adminMapper.deleteUser(id);
	}

}
