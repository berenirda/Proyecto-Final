package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Clientes extends Class_padreCostumer {
	
	
    
    public Clientes() {
    	 try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);	
				System.out.println("Conexion exitosa");
				
				st = conn.createStatement();
				rs =st.executeQuery("SELECT * FROM  customer");
				
				while(rs.next()) {
					int id_Customer = rs.getInt(1);
					int Store_id = rs.getInt(2);
					String Name_Customer = rs.getNString(3);
					String LastName_custumer =rs.getString(4);
					System.out.println("Id of Customer "+ id_Customer);
					System.out.println("Store ID "+ Store_id);
					System.out.println("Name of Customer "+ Name_Customer+" "+LastName_custumer);
				
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
