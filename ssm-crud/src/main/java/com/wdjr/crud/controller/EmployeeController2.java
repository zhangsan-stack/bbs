package com.wdjr.crud.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

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
import com.wdjr.crud.bean.Msg2;
import com.wdjr.crud.service.EmployeeService;
import com.wdjr.crud.service.EmployeeService2;

/*
 * ����CRUD����
 * */

@Controller
public class EmployeeController2 {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@Autowired
	EmployeeService2 employeeService2;
	
	//ɾ�����󣬵�������������һ
	@ResponseBody
	@RequestMapping(value="/emp2/{empId}",method= RequestMethod.DELETE)
	public Msg2 deleteEmpHId(@PathVariable("empId")String empIds) {
		//����ɾ��
		
		if(empIds.contains("-")) {
			
			List<Integer> del_ids = new ArrayList<>();
 			
			String [] str_ids = empIds.split("-");
		 	//��װid����
			for(String string  : str_ids) {
				del_ids.add(Integer.parseInt(string));
			}
			
			
			employeeService.deleteBatch(del_ids);
		}else {
			Integer empId =  Integer.parseInt(empIds);
			employeeService2.deleteEmp(empId);
		}
	
		System.out.println("delete emp");
		return Msg2.success();
	}
	
	
	
	
	
	
	
	
	//����Ա��
	@ResponseBody 
	@RequestMapping(value="/emp/{empId}",method=RequestMethod.PUT)
	public Msg2 saveEmp(Employee employee) {
		
		
		System.out.println(employee);
		employeeService2.updateEmp(employee);
		 
		return Msg2.success();
	}
	
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Msg2 getEmp(@PathVariable("id") Integer id) {
		
		Employee employee =  employeeService2.getEmp(id);
		return Msg2.success().add("emp", employee); 
	}
	
	
	
	
	//����û����Ƿ�����
	@ResponseBody
	@RequestMapping("/checkuser")
	public Msg2 checkuser(@RequestParam("empName")String empName) {
		//���ж��û����Ƿ��ǺϷ�
		String regx =  "(^[0-9]{3}$)";
		if(!empName.matches(regx)) {
			System.out.println(!empName.matches(regx));
			return Msg2.fail().add("va_msg", "�û������������ֻ��������ĸ�����,�����Ϣ");
		} ;
		
		
		//���ݿ��û����ظ�У��
		boolean b =  employeeService2.checkUser(empName);
		if(b){
			return Msg2.success();
		}else {
			return Msg2.fail().add("va_msg", "�û��������ã����������֤");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/emp2", method=RequestMethod.POST)
	@ResponseBody
	public Msg2 saveEmp(@Valid Employee employee,BindingResult result) {
		if(result.hasErrors()) {
			//����У��ʧ����Ϣ
			Map<String, Object> map = new HashMap<>();
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError :errors) {
					System.out.println(fieldError.getField());
					System.out.println(fieldError.getDefaultMessage());
					map.put(fieldError.getField() , fieldError.getDefaultMessage());
			}
			return Msg2.fail().add("errorField", map);
		}
		
		
		employeeService2.saveEmp(employee);
		
		return Msg2.success();
	}
	
	
	
	
	
	
	
	/*
	 * ��ѯ����Ա��
	 * */
	@RequestMapping("/emps2")
	@ResponseBody
	public Msg2 getEmpWithJson(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		PageHelper.startPage(pn,5);
		//�����ž��Ƿ�ҳ��ѯ
		
     	List<Employee> emps = employeeService.getAll();
     	//ʹ��PI��װ�����ֻ��Ҫ��pageInfo����ҳ��Ϳ���
     	//��װ����ϸ�ķ�ҳ��Ϣ��������ѯ����,��������5ҳ
		PageInfo page = new PageInfo(emps,5);
		return Msg2.success().add("pageInfo", page);
		
	}
	
	
	
	
	//@RequestMapping("/emps2")
	public  String getEmps(@RequestParam(value="pn",defaultValue="1")Integer pn,Model model) {
		//��ѯ֮ǰֻ��Ҫ����(pn,��ҳ����)
		PageHelper.startPage(pn,5);
		//�����ž��Ƿ�ҳ��ѯ
		
     	List<Employee> emps = employeeService.getAll();
     	//ʹ��PI��װ�����ֻ��Ҫ��pageInfo����ҳ��Ϳ���
     	//��װ����ϸ�ķ�ҳ��Ϣ��������ѯ����,��������5ҳ
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo", page);
		System.out.println("����emps2");
		return "list2";
	}
	
		/*@RequestMapping("/emps2_list3")
		public  String getEmps_list3() {
			
			System.out.println("����emps2_list3");
			return "list3";
		}*/
	
	
	
}
