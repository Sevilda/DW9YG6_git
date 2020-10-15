package storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;

public class InResultSet {
	
	private static CallableStatement cst;
	private static ResultSet rs;

	public static void callGetCatsByOwner(Connection conn, Scanner sc) {
		try {
				int countAll =0;
				System.out.println("\nAll cats of an owner. ");
				cst=conn.prepareCall("call get_cats_for_owner(?);");
				System.out.println("\nOwner's name: ");
				cst.setString(1, sc.nextLine());
				rs=cst.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
							+ rs.getString(3) + " " + rs.getInt(4) + " " + " " + rs.getString(5));
					countAll++;
				}
				System.out.println("\nPrinted " + countAll + " cats of the owner\n");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
