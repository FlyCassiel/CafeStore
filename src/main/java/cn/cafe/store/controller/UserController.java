package cn.cafe.store.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.cafe.store.bean.ResponseResult;
import cn.cafe.store.bean.User;
import cn.cafe.store.iservice.IUserService;
import cn.cafe.store.service.UserService;
import cn.cafe.store.service.ex.PasswordNotMatchException;
import cn.cafe.store.service.ex.UserNotFoundException;
import cn.cafe.store.service.ex.UsernameAlreadyExistException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Resource
	private IUserService userService;
	
	/**
	 * �ϴ�ͼƬ
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadImage.do")
	@ResponseBody
	public ResponseResult<Void> uploadImage(MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
			ResponseResult<Void> rr=null;	
			//����ļ���Ϊ�գ�д���ϴ�·��
			if(!file.isEmpty()) {
	           //�ϴ��ļ�·��
	    	  /* String path=session.getServletContext().getRealPath("/upload");*/
	           String path="D:/upload";
				//�ϴ��ļ���
	           String filename = file.getOriginalFilename();
	           File filepath = new File(path,filename);
	           //�ж�·���Ƿ���ڣ���������ھʹ���һ��
	           if (!filepath.getParentFile().exists()) { 
	               filepath.getParentFile().mkdirs();
	           }
	           //���ϴ��ļ����浽һ��Ŀ���ļ�����
	           file.transferTo(new File(path + File.separator + filename));
	           rr = new ResponseResult<Void>(1, "�ϴ��ɹ�");
	       } else {
	    	   rr = new ResponseResult<Void>(0, "�ϴ�ʧ��");
	       }
		//�޸�����
		System.out.println(this.getUid(session));
		userService.updateImage(this.getUid(session), file.getOriginalFilename());
		return rr;		
	}
	
	
	//��ʾע�Ṧ��
	@RequestMapping("/showReg.do")
	private String showReg() {
		return "reg";
	}
	//��ʾ��¼ҳ��
	@RequestMapping("/showLogin.do")
	private String showLogin() {
		return "login";
	}
	//------------------------ע��----------------------//
	//�첽��֤�û���
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr;
		if (userService.checkUsername(username)) {
			rr = new ResponseResult<Void>(0, "�û����Ѵ���");
		} else {
			rr = new ResponseResult<Void>(1, "�û�������ʹ��");
		}
		return rr;
	}
	/**
	 * �첽ˢ�µ�������
	 * @param email
	 * @return
	 */
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
	   ResponseResult<Void> rr;
	   if (userService.checkEmail(email)) {
		rr = new ResponseResult<Void>(0, "�����Ѿ���ռ��");
	     } else {
		rr = new ResponseResult<Void>(1, "�������ʹ��");
		}
	    return rr;
	}
	/**
	 * �첽ˢ���ֻ���
	 * @param phone
	 * @return
	 */
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr;
		if (userService.checkPhone(phone)) {
			rr = new ResponseResult<Void>(0, "�ֻ��ű�ռ��");
	           } else {
			rr = new ResponseResult<Void>(1, "�ֻ��ſ���ʹ��");
		}
		return rr;
	}
	/**
	 * ע��
	 * @param username
	 * @param password
	 * @param email
	 * @param phone
	 * @return
	 */
	@RequestMapping("/reg.do")
	@ResponseBody
	public ResponseResult<Void> reg(
		@RequestParam("uname") String username,
		String password,
		String email,String phone){
		ResponseResult<Void> rr;
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmail(email);
		//set������User����ֵ
		try{
			userService.reg(user);
			rr = new ResponseResult<Void>(1,"ע��ɹ�");
		}catch(UsernameAlreadyExistException e){
			e.getMessage();
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	//------------------------��¼----------------------//
	/**
	 * ��¼ʱ���û����첽ˢ��
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping("/loginCheckUsername.do")
	@ResponseBody
	public ResponseResult<Void> LogincheckUsername(String username) {
		ResponseResult<Void> rr;
		if (userService.checkUsername(username)) {
			rr = new ResponseResult<Void>(0, "�û�������ʹ��");
		} else {
			rr = new ResponseResult<Void>(1, "�û��������ڣ�����ȥע��");
		}
		return rr;
	}
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<Void> Login(String username, String password, HttpSession session) {
		ResponseResult<Void> rr;
		try {
			rr = new ResponseResult<Void>(1, "��¼�ɹ�");
			// ����service���login����
			User user = userService.login(username, password);
			// ��session������user��id��Ϣ
			session.setAttribute("user", user);
			System.out.println(user.toString());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(0, e.getMessage());
		} catch (PasswordNotMatchException e) {
			e.printStackTrace();
			rr = new ResponseResult<Void>(-1, e.getMessage());
		}
		return rr;
	}
	/**
	 *�û��˳�
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../main/showIndex.do";
	}
	//-----------------------�޸��û�����--------------------------------
	@RequestMapping("/showPassword.do")
	private String   showPassword() {
		return "password";
	}
	@RequestMapping("/checkPassword.do")
	@ResponseBody
	private ResponseResult<Void> checkPassword(String oldPassword,HttpSession session){
		ResponseResult<Void> rr;
		try {
			Integer id = this.getUid(session);
			userService.checkPassword(id, oldPassword);
			rr = new ResponseResult<Void>(1, "������֤�ɹ�");
		} catch (Exception e) {
			rr = new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;
	}
	
	
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(HttpSession session, String oldPassword, String newPassword) {
		ResponseResult<Void> rr;
		try {
			Integer id = this.getUid(session);
			userService.changePassword(id, oldPassword, newPassword);
			rr = new ResponseResult<Void>(1, "�޸ĳɹ�");
		} catch (RuntimeException e) {
			rr = new ResponseResult<Void>(0, e.getMessage());
		}
		return rr;
	}
	@RequestMapping("/showPerson.do")
	public String showPerson(HttpSession session) {
		User user=(User) session.getAttribute("user");
		System.out.println(user.getImage());
		return "person";
	}
	
	@RequestMapping("/updatePerson.do")
	@ResponseBody
	public ResponseResult<Void> updatePerson(String username,Integer gender,String phone,String email,HttpSession session){
		ResponseResult<Void> rr;
		try {
			Integer id=this.getUid(session);
			userService.updatePerson(id, username, gender, phone, email);
			/**
			 * ���޸ĺ��user�������´�ŵ�seesion��
			 */
			session.setAttribute("user", userService.getUserById(id));
			rr=new ResponseResult<Void>(1,"�ɹ�");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	
}
