package com.wdjr.crud.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.wdjr.crud.bean.Employee;

/*
 * ʹ��Spring��Ԫ���������ܣ�����crud�������ȷ��
 * Spring4��Ҫservlet3.0����
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml","classpath:spring-mvc.xml"})
public class MvcTest {
	//����springmvc��ioc,��������ע��ioc�����Լ�����������ǰ��@WebAppConfiguration
	@Autowired
	WebApplicationContext context;
	//1.����mvc���󣬻�ȡ����Ľ��
	MockMvc mockMvc;
	
	@Before
	public void initMokcMvc() {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public  void testPage() throws Exception {
		// ģ��get����,�������������ֵ
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();
		
		//����ɹ��Ժ�����������pageInfo;ȥ��pageInfo������֤
		MockHttpServletRequest request = result.getRequest();
		
		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("��ǰҳ�룺"+pi.getPageNum());
		System.out.println("��ҳ�룺 "+pi.getPages());
		System.out.println("�ܼ�¼����"+pi.getTotal());
		System.out.println("��ҳ����Ҫ������ʾ��ҳ�룺");
		int[] numbers = pi.getNavigatepageNums();
		for (int i:numbers) {
			System.out.println("  "+i);
		}
		//��ȡԱ������
		List<Employee> list = pi.getList();
		for(Employee emp:list) {
			System.out.println("ID:"+emp.getEmpId()+"\t"+"name: "+emp.getEmpName());
		}
	}
}
