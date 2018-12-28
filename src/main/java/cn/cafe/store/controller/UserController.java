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
	 * 上传图片
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadImage.do")
	@ResponseBody
	public ResponseResult<Void> uploadImage(MultipartFile file,HttpSession session) throws IllegalStateException, IOException{
			ResponseResult<Void> rr=null;	
			//如果文件不为空，写入上传路径
			if(!file.isEmpty()) {
	           //上传文件路径
	    	  /* String path=session.getServletContext().getRealPath("/upload");*/
	           String path="D:/upload";
				//上传文件名
	           String filename = file.getOriginalFilename();
	           File filepath = new File(path,filename);
	           //判断路径是否存在，如果不存在就创建一个
	           if (!filepath.getParentFile().exists()) { 
	               filepath.getParentFile().mkdirs();
	           }
	           //将上传文件保存到一个目标文件当中
	           file.transferTo(new File(path + File.separator + filename));
	           rr = new ResponseResult<Void>(1, "上传成功");
	       } else {
	    	   rr = new ResponseResult<Void>(0, "上传失败");
	       }
		//修改数据
		System.out.println(this.getUid(session));
		userService.updateImage(this.getUid(session), file.getOriginalFilename());
		return rr;		
	}
	
	
	//显示注册功能
	@RequestMapping("/showReg.do")
	private String showReg() {
		return "reg";
	}
	//显示登录页面
	@RequestMapping("/showLogin.do")
	private String showLogin() {
		return "login";
	}
	//------------------------注册----------------------//
	//异步验证用户名
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr;
		if (userService.checkUsername(username)) {
			rr = new ResponseResult<Void>(0, "用户名已存在");
		} else {
			rr = new ResponseResult<Void>(1, "用户名可以使用");
		}
		return rr;
	}
	/**
	 * 异步刷新电子邮箱
	 * @param email
	 * @return
	 */
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
	   ResponseResult<Void> rr;
	   if (userService.checkEmail(email)) {
		rr = new ResponseResult<Void>(0, "邮箱已经被占用");
	     } else {
		rr = new ResponseResult<Void>(1, "邮箱可以使用");
		}
	    return rr;
	}
	/**
	 * 异步刷新手机号
	 * @param phone
	 * @return
	 */
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr;
		if (userService.checkPhone(phone)) {
			rr = new ResponseResult<Void>(0, "手机号被占用");
	           } else {
			rr = new ResponseResult<Void>(1, "手机号可以使用");
		}
		return rr;
	}
	/**
	 * 注册
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
		//set方法给User对象赋值
		try{
			userService.reg(user);
			rr = new ResponseResult<Void>(1,"注册成功");
		}catch(UsernameAlreadyExistException e){
			e.getMessage();
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	//------------------------登录----------------------//
	/**
	 * 登录时的用户名异步刷新
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping("/loginCheckUsername.do")
	@ResponseBody
	public ResponseResult<Void> LogincheckUsername(String username) {
		ResponseResult<Void> rr;
		if (userService.checkUsername(username)) {
			rr = new ResponseResult<Void>(0, "用户名可以使用");
		} else {
			rr = new ResponseResult<Void>(1, "用户名不存在，请先去注册");
		}
		return rr;
	}
	/**
	 * 用户登录
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
			rr = new ResponseResult<Void>(1, "登录成功");
			// 调用service层的login方法
			User user = userService.login(username, password);
			// 用session绑定数据user的id信息
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
	 *用户退出
	 */
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../main/showIndex.do";
	}
	//-----------------------修改用户密码--------------------------------
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
			rr = new ResponseResult<Void>(1, "密码验证成功");
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
			rr = new ResponseResult<Void>(1, "修改成功");
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
			 * 把修改后的user对象重新存放到seesion中
			 */
			session.setAttribute("user", userService.getUserById(id));
			rr=new ResponseResult<Void>(1,"成功");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	
}
