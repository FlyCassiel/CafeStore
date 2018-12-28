package cn.cafe.store.controller;

import javax.servlet.http.HttpSession;

import cn.cafe.store.bean.Admin;
import cn.cafe.store.bean.User;
/**
 * session �д���user.id  ����֮���controllerʹ�á�
 * @author soft01
 *
 */
public class BaseController {
	/**
	 * ��session�еõ��û���Ϣ
	 * @param session
	 * @return
	 */
	public Integer getUid(HttpSession session) {
		Integer id = null;
		User user = (User) session.getAttribute("user");
		if (user != null) {
			id = user.getId();
		}
		return id;
	}
	/**
	 * ��session�л�ȡ����Ա��Ϣ
	 * @param session
	 * @return
	 */
	public Integer getAid(HttpSession session) {
		Integer id = null;
		Admin admin=(Admin) session.getAttribute("admin");
		if (admin != null) {
			id = admin.getId();
		}
		return id;
	}
}
