package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.LoginBean;
import util.DBConnection;

public class LoginDao {
	public String authenticateUser(LoginBean loginBean) throws ClassNotFoundException {

		// Keeping user entered values in temporary variables.
		String UserId = loginBean.getUserID();
		String password = loginBean.getPassword();
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String UserIdDB = "";
		String passwordDB = "";
		
		
		try
		{
		con = DBConnection.createConnection(); //establishing connection
		statement = con.createStatement(); //Statement is used to write queries. Read more about it.
		resultSet = statement.executeQuery("select userid,password from MITSUSERS"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
		while(resultSet.next()) // Until next row is present otherwise it return false
		{
		UserIdDB = resultSet.getString("userid"); //fetch the values present in database
		passwordDB = resultSet.getString("password");
		if(UserId.equals(UserIdDB) && password.equals(passwordDB))
		{
		return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
		}
		}
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		return null;
		}
	
}
