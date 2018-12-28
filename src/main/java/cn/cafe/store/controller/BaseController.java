package cn.cafe.store.controller;

import javax.servlet.http.HttpSession;

import cn.cafe.store.bean.Admin;
import cn.cafe.store.bean.User;
/**
 * session 中存入user.id  方便之后的controller使用。
 * @author soft01
 *
 */
public class BaseController {
	/**
	 * 从session中得到用户信息
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
	 * 从session中获取管理员信息
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
