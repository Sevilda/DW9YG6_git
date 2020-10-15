package CRUD;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	
	private static Statement stm;

	public static void DeletePGalD(Connection conn, Scanner sc) {
		try {
			System.out.println("\nYou are attempting to delete a cat.");
			stm = conn.createStatement();
			if (stm.execute("Delete from cats where owner='Gal Dora' and breed='Perzsa'"))
				System.out.println("\nCat(s) deleted.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
