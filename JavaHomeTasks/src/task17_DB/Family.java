package task17_DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Family {

	private static Connection connection = null;
	private String tableName;
	private Statement st;

	public Family(String dbName, String user, String password, String tableName) {
		this.tableName = tableName;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/" + dbName + "?user=" + user + "&password=" + password);
			st = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private static String buildLine(String[] arrayStr) {
		String str = "|";
		for (int i = 0; i < arrayStr.length; ++i) {
			str += arrayStr[i] + "\t|";
		}
		return str;
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close(); // close connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void show() {
		try {
			ResultSet rs = st.executeQuery("select * from " + tableName);
			ResultSetMetaData metaData = rs.getMetaData();
			int columns = metaData.getColumnCount();
			String[] arrayCol = new String[columns];
			for (int i = 0; i < columns; i++) {
				arrayCol[i] = metaData.getColumnLabel(i + 1);
			}
			System.out.println(buildLine(arrayCol));

			while (rs.next()) { /// process result
				for (int i = 1; i <= columns; i++) {
					arrayCol[i - 1] = rs.getString(i);
				}
				System.out.println(buildLine(arrayCol));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public boolean add(String arguments) {
		String[] arrVal = arguments.split("\\s+");
		try {
			String name = arrVal[0];
			int year = Integer.parseInt(arrVal[1]);
			int height = Integer.parseInt(arrVal[2]);
			int weight = Integer.parseInt(arrVal[3]);

			PreparedStatement ps = connection.prepareStatement(
					"insert into " + tableName + " (id, name, year, height, weight) values (null, ?, ?, ?, ?)");

			ps.setString(1, name);
			ps.setInt(2, year);
			ps.setInt(3, height);
			ps.setInt(4, weight);

			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Wrong format of input arguments. It must be string and three integer values");
		}

		return false;
		// TODO Auto-generated method stub

	}

}
