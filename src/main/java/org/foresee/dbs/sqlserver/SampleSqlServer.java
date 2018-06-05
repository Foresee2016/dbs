package org.foresee.dbs.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleSqlServer {
	public static void main(String[] args) {
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;DatabaseName=school";
		String user="sa";
		String password="123456";
		try {
			Class.forName(driverName);
			Connection connection=DriverManager.getConnection(url, user, password);
			if (!connection.isClosed()) {
				System.out.println("Connection successful.");
			}
			Statement statement = connection.createStatement();
			String sql = "select top 5 * from Att_detail where ClassName='高一1班'";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("ID");
				String name = resultSet.getString("StudentName");
				System.out.println(id + "," + name);
			}
			PreparedStatement preparedStatement = connection.prepareStatement("select * from Att_detail where ClassName=?");
			preparedStatement.setString(1, "高一2班");
			ResultSet resultSet2=preparedStatement.executeQuery();
			while (resultSet2.next()) {
				String className = resultSet2.getString("ClassName");
				String name = resultSet2.getString("StudentName");
				System.out.println(className + "," + name);
			}
			resultSet.close();
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
