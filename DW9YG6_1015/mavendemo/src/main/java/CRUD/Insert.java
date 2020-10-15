package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {

	private static PreparedStatement ps;

	public static void InsertCat(Connection conn, Scanner sc) {
		try {
			System.out.println(
					"\nYou are adding a new cat. Please provide the necessary information, or press 0 to abort.");
//			if (sc.nextInt() == 0) {
//				System.out.println("Aborted\n");
//			} else {
			System.out.println("Cat's name :");
			ps = conn.prepareStatement("Insert into cats (name, breed, age, owner) values (?, ?, ?, ?)");
			ps.setString(1, (String) sc.nextLine());
			System.out.println("Cat's breed :");
			ps.setString(2, (String) sc.nextLine());
			System.out.println("Cat's age :");
			ps.setInt(3, Integer.parseInt(sc.nextLine()));
			System.out.println("Cat's Owner :");
			ps.setString(4, (String) sc.nextLine());
			System.out.println(ps.executeUpdate() + " new cat added.\n");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
