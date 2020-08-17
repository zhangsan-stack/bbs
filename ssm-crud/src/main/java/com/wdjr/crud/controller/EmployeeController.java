package com.wdjr.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdjr.crud.bean.Employee;
import com.wdjr.crud.bean.Msg;
import com.wdjr.crud.service.EmployeeService;

/*
 * ����CRUD����
 * */

 //@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/*����jackson,���𽫶���ת��json
	 * @ResponseBody
	 * */
	
	/* Ա��ɾ��
	 * ����ɾ�� ��1-2-3
	 * ����ɾ����1
	 *  */
	@ResponseBody
	@RequestMapping(value="/emp/{ids}",method=RequestMethod.DELETE)
	public Msg deleteEmp(@PathVariable("ids")String ids) {
		//������� - ��������ɾ��
		if(ids.contains("-")) {
			List<Integer> del_ids = new ArrayList<>();
			String[] str_id = ids.split("-");
			for (String string : str_id) {
				del_ids.add(Integer.parseInt(string));
			}
			employeeService.delteBatch(del_ids);
		}else {
			Integer id = Integer.parseInt(ids);
			employeeService.deleteEmp(id);
		}
				
		return Msg.sucess();
	}
	
	/* ����Ա������,
	 * ���ֱ�ӷ���ajax�������������empId ʣ��ȫ��null
	 * ԭ��
	 * tomcat��
	 * 1.���������е����ݣ���װһ��Map
	 * 2.request.getParameter("empName")�ͻ�����map��ȡֵ
	 * 3.SpringMVC��װPOJO�����ʱ��
	 *   ���ÿ�����Ե�ֵ request.getParamter("email");
	 * 
	 * ajax��PUT������tomcat����PUT���󣬾Ͳ����װ����������Ϊmap,POST�ŷ�װ������Ϊmap
	 *   */
	@ResponseBody
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public Msg updateEmp(Employee employee) {
		employeeService.updateEmp(employee);
		return Msg.sucess();
	}
	
	
	/* @PathVariable:ָ�������� ����id���� */
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmp(@PathVariable("id")Integer id) {
		
		Employee employee = employeeService.getEmp(id);
		
		return Msg.sucess().add("emp", employee);
	}
	
	
	/* -----����û��Ƿ���� ------ */
	@RequestMapping(value="/checkUser")
	@ResponseBody
	public Msg checkuser(@RequestParam("empName")String empName) {
		//���У��
//		String regx="(^[A-Za-z0-9]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5}$)";
//		if(!empName.matches(regx)) {
//			return Msg.fail().add("va_msg", "�û�����������2-5λ���ģ�����6-16λӢ�ĺ����ֵļ���!!!");
//		}
		//�ظ�У��
		boolean b = employeeService.checkUser(empName);
		
		if(b) {
			return Msg.sucess();
		}else {
			return Msg.fail().add("va_msg", "�û����Ѵ���!!!");
		}
		
	}
	
	
	  	
	/* ---����Ա������----- */
	@RequestMapping(value="emp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(@Valid Employee employee ,BindingResult result) {
		if(result.hasErrors()) {
			//����ʧ��
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for (FieldError fieldError : errors) {
				System.out.println("������ֶ���"+fieldError.getField());
				System.out.println("�������Ϣ"+fieldError.getDefaultMessage());
				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return Msg.fail().add("errorFields", map);
		}else {
			//����ɹ�
			employeeService.saveEmp(employee);
			return Msg.sucess();
		}

	}
	
	
	/* -------��ҳ��ѯ------ */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		
		//��ѯ֮ǰֻ��Ҫ����(pn,��ҳ����)
		PageHelper.startPage(pn,5);
		//�����ž��Ƿ�ҳ��ѯ
		
     	List<Employee> emps = employeeService.getAll();
     	//ʹ��PI��װ�����ֻ��Ҫ��pageInfo����ҳ��Ϳ���
     	//��װ����ϸ�ķ�ҳ��Ϣ��������ѯ����,��������5ҳ
		PageInfo page = new PageInfo(emps,5);
		
		return Msg.sucess().add("pageInfo", page);
	}
	
	
	/*
	 * ��ѯ����Ա��
	 * */
/*	@RequestMapping("/emps")
	public  String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		//��ѯ֮ǰֻ��Ҫ����(pn,��ҳ����)
		PageHelper.startPage(pn,5);
		//�����ž��Ƿ�ҳ��ѯ
		
     	List<Employee> emps = employeeService.getAll();
     	//ʹ��PI��װ�����ֻ��Ҫ��pageInfo����ҳ��Ϳ���
     	//��װ����ϸ�ķ�ҳ��Ϣ��������ѯ����,��������5ҳ
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo", page);
		System.out.println("����emps");
		return "list";
	}*/
}
