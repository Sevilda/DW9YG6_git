package CRUD;

import java.sql.*;

public class Select {

	private static PreparedStatement ps;
	private static Statement stm;
	private static ResultSet rs;

	public static void SelectCats(Connection conn) {

		int countAll = 0;

		try {
			stm = conn.createStatement();
			// all
			rs = stm.executeQuery("select * from cats");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
						+ rs.getString(3) + " " + rs.getInt(4) + " " + " " + rs.getString(5));
				countAll++;
			}
			System.out.println("\nPrinted " + countAll + " cats\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void SelectCatsOlderThan(Connection conn, int age) {

		int countAll = 0;

		try {
			
			System.out.println("--Arguement: Age is greater than " + age);
			ps = conn.prepareStatement("Select * from cats where age > ?");
			ps.setInt(1, age);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
						+ rs.getString(3) + " " + rs.getInt(4) + " " + " " + rs.getString(5));
				countAll++;
			}

			System.out.println("\nPrinted " + countAll + " cats\n");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
