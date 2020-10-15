package storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class InParameters {
	
	private static CallableStatement cst;

	public static void callModifyOwnerByBreed(Connection conn, Scanner sc) {
		try {
				System.out.println("\nUpdate all cats of the same breed to have the same owner. ");
				cst=conn.prepareCall("call modifyOwnerByBreed(?, ?);");
				System.out.println("\nBreed: ");
				cst.setString(1, sc.nextLine());
				System.out.println("\nNew owner's name: ");
				cst.setString(2, sc.nextLine());
				System.out.println("\nUpdated " + cst.executeUpdate() + " cats.\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
