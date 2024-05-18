package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Inventary extends film {
	
	public Inventary(){
		
		 try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);	
				System.out.println("Conexion exitosa");
				
				st = conn.createStatement();
				rs =st.executeQuery("SELECT * FROM  inventory");
				
				while(rs.next()) {
					int Inventory_id = rs.getInt(1);
					int  Film_id = rs.getInt(2);
					int store_id =rs.getInt(3);
					String  last_uptdate =rs.getString(4);
					
					System.out.println("\nID of Inventary "+ Inventory_id);
					System.out.println("ID of Film "+ Film_id);
					System.out.println("Stores ID "+ store_id);
					System.out.println("Date of Film "+ last_uptdate);
				}
				
				
				
			} catch (ClassNotFoundException e) {
				System.out.println("error en el controlador ");
				e.printStackTrace();
			} catch (SQLException e) {	
				e.printStackTrace();
				System.out.println("error la conexion ");
				e.printStackTrace();
			}
		
	}

}
