package org.foresee.dbs.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudMysql {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/learn?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, "foresee", "qq520670");
			if (!connection.isClosed()) {
				System.out.println("Connection successful.");
			}
			Statement statement = connection.createStatement();
			String sql = "select * from person";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				System.out.println(id + "," + name);
			}
			PreparedStatement preparedStatement = connection.prepareStatement("select * from person where name like ?");
			preparedStatement.setString(1, "A%");
			ResultSet resultSet2=preparedStatement.executeQuery();
			System.out.println("name like A*");
			while (resultSet2.next()) {
				int id = resultSet2.getInt("id");
				String name = resultSet2.getString("name");
				System.out.println(id + "," + name);
			}
			resultSet.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
