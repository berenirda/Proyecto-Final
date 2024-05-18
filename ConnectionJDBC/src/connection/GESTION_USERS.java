package connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class GESTION_USERS  extends Class_padreCostumer {
	
	Scanner entrada = new Scanner(System.in);
	
	private int  UserModificador_Id;
    private String  UserNameModificado;
    private String  UserlastModificado;
    private String  UsermailModificado;
    
	
	
	 public void Search_user() {
	int IdUSer;
			
			System.out.println("Ingrese el ID del Usuario a consultar ");
			IdUSer = entrada.nextInt();
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);	
				System.out.println("Conexion exitosa");
				
				st = conn.createStatement();
				ps =conn.prepareStatement("SELECT * FROM  customer WHERE customer_id = ?");
				ps.setInt(1, IdUSer);
				rs=ps.executeQuery();//probar buscar el cliente con ese codigo 
				
				while(rs.next()) {
					int id_User = rs.getInt(1);
					int Store_id = rs.getInt(2);
					String Name_Customer = rs.getNString(3);
					String LastName_custumer =rs.getString(4);
					
					System.out.println("Id of Customer "+ id_User);
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
	 
	 
	public  void Modificar_user() {
		 
		 	System.out.println("Ingrese el ID del Usario a modificar");
		 	UserModificador_Id = entrada.nextInt();
		 	setUserModificador_Id(UserModificador_Id);
		 	
		 	
		 	System.out.println("Ingrese el Nuevo Nombre del Usuario");
		 	UserNameModificado= entrada.next();
		 	setUserNameModificado(UserNameModificado);
		 	
		 	System.out.println("Ingrese el Nuevo Apellido del Usuario");
		 	UserlastModificado = entrada.next();
		 	setUserlastModificado(UserlastModificado);
		 	
			System.out.println("Ingrese el Correo Apellido del Usuario");
			UsermailModificado = entrada.next();
			setUsermailModificado(UsermailModificado);
		 	
		 
		 try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);	
				System.out.println("Conexion exitosa");
				
				st = conn.createStatement();
				ps =conn.prepareStatement("UPDATE customer set first_name= ?  WHERE customer_id = ?");
				psl =conn.prepareStatement("UPDATE customer set last_name= ?  WHERE customer_id = ?");
				pse =conn.prepareStatement("UPDATE customer set email= ?  WHERE customer_id = ?");
				
				ps.setString(1, getUserNameModificado());
				ps.setInt(2, getUserModificador_Id());
				
				psl.setString(1, getUserlastModificado());
				psl.setInt(2, getUserModificador_Id());
				
				pse.setString(1, getUsermailModificado());
				pse.setInt(2, getUserModificador_Id());
				
				ps.executeUpdate();
				psl.executeUpdate();
				pse.executeUpdate();
				
				
				System.out.println("Actulizacion Exitosa!!"+"Favor verificar "+
				" si el Cambio ha sido realizado");
				
				
			} catch (ClassNotFoundException e) {
				System.out.println("error en el controlador ");
				e.printStackTrace();
			} catch (SQLException e) {	
				e.printStackTrace();
				System.out.println("error la conexion ");
				e.printStackTrace();
			}
	 }
	 
	 
	 public int getUserModificador_Id() {
			return UserModificador_Id;
		}
		public void setUserModificador_Id(int userModificador_Id) {
			UserModificador_Id = userModificador_Id;
		}
		public String getUserNameModificado() {
			return UserNameModificado;
		}
		public void setUserNameModificado(String userNameModificado) {
			UserNameModificado = userNameModificado;
		}
		public String getUserlastModificado() {
			return UserlastModificado;
		}
		public void setUserlastModificado(String userlastModificado) {
			UserlastModificado = userlastModificado;
		}
		public String getUsermailModificado() {
			return UsermailModificado;
		}
		public void setUsermailModificado(String usermailModificado) {
			UsermailModificado = usermailModificado;
		}
	    

}
