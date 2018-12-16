package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class CustomerMapper implements RowMapper<Customer> 
{

	@Override
	public Customer mapRow(ResultSet result, int arg1) throws SQLException 
	{
		Customer obj = new Customer();
		
		obj.setEmpid(result.getInt(1));
		obj.setEmpname(result.getString(2));
		obj.setEmpcity(result.getString(3));
		obj.setEmpphone(result.getString(4));
		obj.setEmpsalary(result.getDouble(5));
		obj.setDepid(result.getInt(6));
		
		return obj;
	}

}