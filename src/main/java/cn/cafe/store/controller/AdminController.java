package cn.cafe.store.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.coyote.http11.filters.VoidInputFilter;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cafe.store.bean.Admin;
import cn.cafe.store.bean.ProductCount;
import cn.cafe.store.bean.ResponseResult;
import cn.cafe.store.bean.User;
import cn.cafe.store.iservice.IAdminService;
import cn.cafe.store.iservice.IUserService;
import cn.cafe.store.service.ex.PasswordNotMatchException;
import cn.cafe.store.service.ex.UserNotFoundException;


/**
 * 管理员controller
 * 
 * @author 刘飞
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
	@Resource
	private IAdminService adminService;
	@Resource
	private IUserService userServcie;

	/**
	 * 显示管理员登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "../admin/jsp/login";
	}

	@RequestMapping("/showIndex.do")
	public String showIndex() {
		return "../admin/jsp/home";
	}
	
	/**
	 * 管理员登录功能实现
	 * 
	 * @param username
	 *            管理员name
	 * @param password
	 *            管理员密码
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username, String password, HttpSession session) {
		ResponseResult<Void> rr = null;
		try {
			rr = new ResponseResult<Void>(1, "登录成功");
			// 调用service层的login方法
			Admin admin = adminService.login(username, password);
			// 用session绑定数据admin信息
			session.setAttribute("admin", admin);
		} catch (PasswordNotMatchException e) {
			rr = new ResponseResult<Void>(0, "账号或密码不正确");
		} catch (UserNotFoundException e) {
			rr = new ResponseResult<Void>(-1, "账号错误，请重新输入");
		}
		return rr;

	}
	
	//--------------------------用户查询删除修改-------------------------------
	/**
	 * 展示所有的用户的集合展示
	 */
	@RequestMapping("/showUser.do")
	public String showUser(ModelMap map, Integer page,HttpSession session) {
		// 分页
		// 当点击第一页时就是第一页
		if (page == null) {
			page = 1;
		}
		// 通过page计算每页的起始 ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// 得到用户下的所有数量
		Integer count = userServcie.getCount();
		
		// 获得所有的用户信息
		List<User> userlist = userServcie.getUser(offset, ProductCount.COUNT);
		//存储到map中
		map.addAttribute("userlist", userlist);
		
		
		// 判断应该是几页，如果能除尽则为两数相除，否则加1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		// 设置页面的记录数
		map.put("currentPage", page);//当前页
		map.put("count", count);//数据的总数量
		map.put("pageCount", pageCount);//总页数

		return "../admin/jsp/user/list";
	}
	/**
	 * 用户查询
	 * @param username
	 * @param map
	 * @param page
	 * @return
	 */
	@RequestMapping("/showQuery.do")
	public String showQuery(String username,ModelMap map, Integer page) {
		// 分页
		// 当点击第一页时就是第一页
		if (page == null) {
			page = 1;
		}
		// 通过page计算每页的起始 ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// 得到用户下的所有数量
		Integer count = adminService.getCountByUsername(username);
		
		// 获得所有的用户信息
		List<User> userQuerylist = adminService.getUserByUsername(username, offset, ProductCount.COUNT);
		//存储到map中
		map.addAttribute("userQuerylist", userQuerylist);
		
		// 判断应该是几页，如果能除尽则为两数相除，否则加1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		// 设置页面的记录数
		map.put("currentPage", page);//当前页
		map.put("count", count);//数据的总数量
		map.put("pageCount", pageCount);//总页数
		//查询的用户名回显
		map.addAttribute("username", username);

		return "../admin/jsp/user/list";
	}
	/**
	 * 删除用户操作
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUser.do")
	public String deleteUser(Integer id) {
		adminService.deleteUser(id);
		return "redirect:../admin/showUser.do";
	}
	/**
	 * 展示修改页面
	 * @return
	 */
	@RequestMapping("/showEdit.do")
	public String showEdit(Integer id,ModelMap map) {
		User user=userServcie.getUserById(id);
		map.addAttribute("user", user);
		return "../admin/jsp/user/edit";
	}
	/**
	 * 修改用户信息
	 */
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(Integer id,String username,Integer gender,String phone,String email,HttpSession session) {
		ResponseResult<Void> rr;
		try {
			userServcie.updatePerson(id, username, gender, phone, email);
			rr=new ResponseResult<Void>(1,"成功");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
}
