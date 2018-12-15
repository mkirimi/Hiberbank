package dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoServices {

	public List<Customer> getAllEmployees()
	{
		JdbcTemplate jtemp = (JdbcTemplate)new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
		List<Customer> allemployees = jtemp.query("Select * from employee",new dao.CustomerMapper());
		return allemployees;
	}
	public int addNewEmployee(Customer employee)
	{
		JdbcTemplate jtemp = (JdbcTemplate)new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
		return jtemp.update("insert into employee values(?,?,?,?,?,?)",
								new Object[]{employee.getEmpid(),employee.getEmpname(),employee.getEmpcity(),employee.getEmpphone(),employee.getEmpsalary(),employee.getDepid()});
	}
	
	public int deleteEmployee(int eid)
	{
		JdbcTemplate jtemp = (JdbcTemplate)new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
		return jtemp.update("delete from employee where empid=?",new Object[]{eid});
	}
	public Customer findEmployee(int eid)
	{
		JdbcTemplate jtemp = (JdbcTemplate)new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
		return jtemp.queryForObject("Select * from Employee where empid=?",new Object[]{eid},new dao.CustomerMapper());
		
	}
	public int updateEmployee(int eid,String ecity,String ephone)
	{
		JdbcTemplate jtemp = (JdbcTemplate)new ClassPathXmlApplicationContext("spring-config.xml").getBean("jt");
		return jtemp.update("update employee set empcity=? , empphone =? where empid=?",new Object[]{ecity,ephone,eid});	
	}
	public static void main(String s[])
	{
		System.out.println(new CustomerDaoServices().findEmployee(1009).empname);
		System.out.println(new CustomerDaoServices().updateEmployee(1009, "Memphis", "88888888"));
	}
}
