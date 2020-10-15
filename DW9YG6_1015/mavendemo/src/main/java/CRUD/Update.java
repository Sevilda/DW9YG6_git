package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {

	private static PreparedStatement ps;

	public static void UpdateOwner(Connection conn, Scanner sc) {
		try {
			System.out.println("\nYou are updating a cat. Please provide the necessary information");
			ps = conn.prepareStatement("Update cats set owner=? where breed=?");
			System.out.println("Cat's breed:");
			ps.setString(2, (String) sc.nextLine());
			System.out.println("Cat's new owner :");
			ps.setString(1, (String) sc.nextLine());
			System.out.println(ps.executeUpdate() + " cat(s) updated.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void UpdateSziami(Connection conn, Scanner sc) {
		try {
			System.out.println("\nYou are updating a cat. Please provide the necessary information");
			ps = conn.prepareStatement("Update cats set owner=? where breed='Sziami'");
			System.out.println("Cat's new owner :");
			ps.setString(1, (String) sc.nextLine());
			System.out.println(ps.executeUpdate() + " cat(s) updated.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
