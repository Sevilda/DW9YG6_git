package CRUD;

import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;

public class App {

	private static Connection conn=null;
	private static String user;
	private static String pw;

	public static void main(String[] args) {
		try {
			user = "dw9yg6";
			pw = "password";
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cats?useSSL=false&serverTimezone=Europe/Budapest",
					user, pw);
			//only willing to work with the useSSL=false and a set timezone.
			Scanner sc = new Scanner(System.in);
						
			Select.SelectCats(conn);
			Select.SelectCatsOlderThan(conn, 1);
			Select.SelectCatsOlderThan(conn, 5);
			Insert.InsertCat(conn, sc);
			Update.UpdateOwner(conn, sc);
			
			
			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
