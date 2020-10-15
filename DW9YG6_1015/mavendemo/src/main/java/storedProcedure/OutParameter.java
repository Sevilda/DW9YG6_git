package storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

public class OutParameter {
	
	private static CallableStatement cst;

	public static void callGetBreedCount(Connection conn, Scanner sc) {
		try {
				System.out.println("\nGet the number of cats that have the certain breed. ");
				cst=conn.prepareCall("call getBreedCount(?, ?);");
				System.out.println("\nBreed: ");
				cst.setString(1, sc.nextLine());
				cst.registerOutParameter(2,  java.sql.Types.INTEGER);
				cst.execute();
				System.out.println("\nFound " + cst.getInt(2) + "cats.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}