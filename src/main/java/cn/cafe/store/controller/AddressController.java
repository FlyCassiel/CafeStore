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
	 * ��ʾ�ջ���ַҳ��
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
	 * ��ӵ�ַ
	 * 
	 * @param recvName
	 *            �ջ���
	 * @param recvProvince
	 *            �ջ���ַ��ʡ
	 * @param recvCity
	 *            �ջ���ַ����
	 * @param recvArea
	 *            �ջ���ַ����
	 * @param recvAddr
	 *            �ջ���ַ����ϸ����
	 * @param recvPhone
	 *            �ջ���ַ�ĵ绰����
	 * @param recvTel
	 *            �ջ���ַ�Ĺ̶��绰
	 * @param recvZip
	 *            �ջ���ַ���ʱ�
	 * @param recvTag
	 *            �ջ���ַ�ı�ǣ��� ��˾ ��
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
		// �ض���
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
		// �ض���
		return "redirect:../address/showOrder.do";
	}

	/**
	 * ����Ĭ�ϵ�ַ
	 * 
	 * @param id
	 *            ����¼���id
	 * @param session
	 * @return
	 */
	@RequestMapping("/setDefault.do")
	public String setDefault(Integer id, HttpSession session) {
		// �û�id
		Integer uid = this.getUid(session);
		// ���÷���
		addressService.setDefault(uid, id);
		// �ض���
		return "redirect:../address/showAddress.do";
	}
	/**
	 * �����е��û���ַ��ϢĬ���޸�
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("/setDefault1.do")
	public String setDefault1(Integer id, HttpSession session) {
		// �û�id
		Integer uid = this.getUid(session);
		// ���÷���
		addressService.setDefault(uid, id);
		// ת��
		return "redirect:../address/showOrder.do";
	}

	/**
	 * �����ջ�����Ϣ ͨ������޸Ĵ����¼� ���͹������ջ���ַ��id
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
			rr = new ResponseResult<Address>(0, "ʧ��");
		} else {
			rr = new ResponseResult<Address>(1, "�ɹ�");
			rr.setData(address);
		}
		return rr;
	}

	/**
	 * �޸��û���ַ��Ϣ
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
	 * ɾ����ַ��Ϣ�����õ�ַĬ��ֵ
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
