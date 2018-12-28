package cn.cafe.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cafe.store.bean.Address;
import cn.cafe.store.bean.ResponseResult;
import cn.cafe.store.iservice.IAddressService;

@Controller
@RequestMapping("/address")
public class AddressController extends BaseController {
	@Resource
	private IAddressService addressService;

	/**
	 * 显示收货地址页面
	 * 
	 * @return
	 */
	@RequestMapping("/showAddress.do")
	public String showAddress(HttpSession session, ModelMap map) {
		Integer uid = this.getUid(session);
		List<Address> listA = addressService.getAllAddressByUid(uid);
		map.addAttribute("listAddress", listA);
		return "address";
	}
	@RequestMapping("/showOrder.do")
	public String showOrder(HttpSession session, ModelMap map) {
		Integer uid = this.getUid(session);
		List<Address> addressList = addressService.getAllAddressByUid(uid);
		map.addAttribute("addressList", addressList);
		return "orderConfirm";
	}

	/**
	 * 添加地址
	 * 
	 * @param recvName
	 *            收货人
	 * @param recvProvince
	 *            收货地址的省
	 * @param recvCity
	 *            收货地址的市
	 * @param recvArea
	 *            收货地址的区
	 * @param recvAddr
	 *            收货地址的详细地区
	 * @param recvPhone
	 *            收货地址的电话号码
	 * @param recvTel
	 *            收货地址的固定电话
	 * @param recvZip
	 *            收货地址的邮编
	 * @param recvTag
	 *            收货地址的标记（家 公司 ）
	 * @param session
	 * @return
	 */
	@RequestMapping("/add.do")
	public String add(@RequestParam("receiverName") String recvName, @RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity, @RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddr, @RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel, @RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag, HttpSession session) {
		Address address = new Address();
		address.setUid(this.getUid(session));
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);
		// 重定向
		return "redirect:../address/showAddress.do";
	}
	@RequestMapping("/addOrder.do")
	public String addOrder(@RequestParam("receiverName") String recvName, @RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity, @RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddr, @RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel, @RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag, HttpSession session) {
		Address address = new Address();
		address.setUid(this.getUid(session));
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.addAddress(address);
		// 重定向
		return "redirect:../address/showOrder.do";
	}

	/**
	 * 设置默认地址
	 * 
	 * @param id
	 *            点击事件的id
	 * @param session
	 * @return
	 */
	@RequestMapping("/setDefault.do")
	public String setDefault(Integer id, HttpSession session) {
		// 用户id
		Integer uid = this.getUid(session);
		// 调用方法
		addressService.setDefault(uid, id);
		// 重定向
		return "redirect:../address/showAddress.do";
	}
	/**
	 * 订单中的用户地址信息默认修改
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/setDefault1.do")
	public String setDefault1(Integer id, HttpSession session) {
		// 用户id
		Integer uid = this.getUid(session);
		// 调用方法
		addressService.setDefault(uid, id);
		// 转发
		return "redirect:../address/showOrder.do";
	}

	/**
	 * 回显收货人信息 通过点击修改触发事件 传送过来该收货地址的id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("getAddress.do")
	@ResponseBody
	public ResponseResult<Address> getAddress(Integer id) {
		ResponseResult<Address> rr = null;
		Address address = addressService.getAddressById(id);
		if (address == null) {
			rr = new ResponseResult<Address>(0, "失败");
		} else {
			rr = new ResponseResult<Address>(1, "成功");
			rr.setData(address);
		}
		return rr;
	}

	/**
	 * 修改用户地址信息
	 */
	@RequestMapping("updateAddress.do")
	public String updateAddress(
			Integer id, 
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince, 
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddr,
			@RequestParam("receiverMobile") String recvPhone, 
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") String recvZip,
			@RequestParam("addressName") String recvTag) {
		Address address = new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddr(recvAddr);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.updateAddress(address);
		return "redirect:../address/showAddress.do";
	}
	/**
	 * 删除地址信息，设置地址默认值
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/deleteAddress.do")
	  public String deleteAddress(Integer id,HttpSession session) {
		  Integer uid=this.getUid(session);
		  addressService.deleteAddress(id, uid);
		  return "redirect:../address/showAddress.do";
	  }

}
