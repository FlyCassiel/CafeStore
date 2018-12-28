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
 * ����Աcontroller
 * 
 * @author ����
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
	 * ��ʾ����Ա��¼ҳ��
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
	 * ����Ա��¼����ʵ��
	 * 
	 * @param username
	 *            ����Աname
	 * @param password
	 *            ����Ա����
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> login(String username, String password, HttpSession session) {
		ResponseResult<Void> rr = null;
		try {
			rr = new ResponseResult<Void>(1, "��¼�ɹ�");
			// ����service���login����
			Admin admin = adminService.login(username, password);
			// ��session������admin��Ϣ
			session.setAttribute("admin", admin);
		} catch (PasswordNotMatchException e) {
			rr = new ResponseResult<Void>(0, "�˺Ż����벻��ȷ");
		} catch (UserNotFoundException e) {
			rr = new ResponseResult<Void>(-1, "�˺Ŵ�������������");
		}
		return rr;

	}
	
	//--------------------------�û���ѯɾ���޸�-------------------------------
	/**
	 * չʾ���е��û��ļ���չʾ
	 */
	@RequestMapping("/showUser.do")
	public String showUser(ModelMap map, Integer page,HttpSession session) {
		// ��ҳ
		// �������һҳʱ���ǵ�һҳ
		if (page == null) {
			page = 1;
		}
		// ͨ��page����ÿҳ����ʼ ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// �õ��û��µ���������
		Integer count = userServcie.getCount();
		
		// ������е��û���Ϣ
		List<User> userlist = userServcie.getUser(offset, ProductCount.COUNT);
		//�洢��map��
		map.addAttribute("userlist", userlist);
		
		
		// �ж�Ӧ���Ǽ�ҳ������ܳ�����Ϊ��������������1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		// ����ҳ��ļ�¼��
		map.put("currentPage", page);//��ǰҳ
		map.put("count", count);//���ݵ�������
		map.put("pageCount", pageCount);//��ҳ��

		return "../admin/jsp/user/list";
	}
	/**
	 * �û���ѯ
	 * @param username
	 * @param map
	 * @param page
	 * @return
	 */
	@RequestMapping("/showQuery.do")
	public String showQuery(String username,ModelMap map, Integer page) {
		// ��ҳ
		// �������һҳʱ���ǵ�һҳ
		if (page == null) {
			page = 1;
		}
		// ͨ��page����ÿҳ����ʼ ProductCount.COUNT=8
		int offset = (page - 1) * ProductCount.COUNT;
		// �õ��û��µ���������
		Integer count = adminService.getCountByUsername(username);
		
		// ������е��û���Ϣ
		List<User> userQuerylist = adminService.getUserByUsername(username, offset, ProductCount.COUNT);
		//�洢��map��
		map.addAttribute("userQuerylist", userQuerylist);
		
		// �ж�Ӧ���Ǽ�ҳ������ܳ�����Ϊ��������������1
		Integer pageCount = count % ProductCount.COUNT == 0 ? count / ProductCount.COUNT
				: count / ProductCount.COUNT + 1;
		// ����ҳ��ļ�¼��
		map.put("currentPage", page);//��ǰҳ
		map.put("count", count);//���ݵ�������
		map.put("pageCount", pageCount);//��ҳ��
		//��ѯ���û�������
		map.addAttribute("username", username);

		return "../admin/jsp/user/list";
	}
	/**
	 * ɾ���û�����
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUser.do")
	public String deleteUser(Integer id) {
		adminService.deleteUser(id);
		return "redirect:../admin/showUser.do";
	}
	/**
	 * չʾ�޸�ҳ��
	 * @return
	 */
	@RequestMapping("/showEdit.do")
	public String showEdit(Integer id,ModelMap map) {
		User user=userServcie.getUserById(id);
		map.addAttribute("user", user);
		return "../admin/jsp/user/edit";
	}
	/**
	 * �޸��û���Ϣ
	 */
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(Integer id,String username,Integer gender,String phone,String email,HttpSession session) {
		ResponseResult<Void> rr;
		try {
			userServcie.updatePerson(id, username, gender, phone, email);
			rr=new ResponseResult<Void>(1,"�ɹ�");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
}
