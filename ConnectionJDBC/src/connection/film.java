package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class film implements CrudFilm  {
	Scanner entrada = new Scanner(System.in);
     protected String driver = "com.mysql.cj.jdbc.Driver";
     protected String url ="jdbc:mysql://localhost:3306/sakila";
     protected String user = "root";
     protected String password = "Noviembre2026n";
     protected  Connection conn = null;
     protected Statement st = null;
     protected PreparedStatement  ps = null;
     protected PreparedStatement  psf = null;
     protected  ResultSet rs = null;
     private String Modificador_name;
     private String Modificador_des;
     private int  Modificador_id;
	
	 
	 
	 public film() {
		
		}
	 public void consultar_film() {//vericar
		 try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);	
				System.out.println("Conexion exitosa");
				
				st = conn.createStatement();
				rs =st.executeQuery("SELECT * FROM  film");
				
				while(rs.next()) {
					int idFilm = rs.getInt(1);
					String title_film = rs.getNString(2);
					String Description_film =rs.getString(3);
					System.out.println("Id of Film "+ idFilm);
					System.out.println("title of Film "+ title_film);
					System.out.println("\nDescripcion of Film "+ Description_film);
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
	 
	 public void buscar() {	
	
			int IDfilm;
			
			System.out.println("Ingrese el id de la pelicula ");
			IDfilm = entrada.nextInt();
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);	
				System.out.println("Conexion exitosa");
				
				st = conn.createStatement();
				ps =conn.prepareStatement("SELECT * FROM  film WHERE film_id = ?");
				ps.setInt(1, IDfilm);
				rs=ps.executeQuery();//probar buscar el cliente con ese codigo 
				
				while(rs.next()) {
					int idFilm = rs.getInt("film_id");
					String title_film = rs.getNString("title");
					String Description_film =rs.getString("description");
					System.out.println("Id of Film "+ idFilm);
					System.out.println("title of Film "+ title_film);
					System.out.println("\nDescripcion of Film "+ Description_film);
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
	 
	 
	 public void Modificar() {
		 	
		
		 	System.out.println("Ingrese el ID de la pelicula que desea Modificar");
		 	Modificador_id = entrada.nextInt();
		 	
		 	setModificador_id(Modificador_id);
		 	
		 	
		 	System.out.println("Ingrese el Nombre de la nueva pelicula ");
		 	Modificador_name= entrada.next();
		 	setModificador_name(Modificador_name);
		 	
		 	System.out.println("Ingrese el Descripcion de la nueva pelicula ");
		 	Modificador_des= entrada.nextLine();
		 	setModificador_des(Modificador_des);
		 	
		 
		 try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);	
				System.out.println("Conexion exitosa");
				
				st = conn.createStatement();
				ps =conn.prepareStatement("UPDATE film  set title=? WHERE film_id = ?");
				psf =conn.prepareStatement("UPDATE film  set description=? WHERE film_id = ?");
				
				
				
				ps.setString(1, getModificador_name());
				ps.setInt(2, getModificador_id());
				
				psf.setString(1, getModificador_des());
				psf.setInt(2, getModificador_id());
				
				ps.executeUpdate();
				psf.executeUpdate();
				
				System.out.println("Actulizacion Exitosa!!"+"Favor verificar En las opciones 1 -2"+
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
	public String getModificador_name() {
		return Modificador_name;
	}
	public void setModificador_name(String modificador_name) {
		Modificador_name = modificador_name;
	}
	public int  getModificador_id() {
		return Modificador_id;
	}
	public void setModificador_id(int modificador_id) {
		Modificador_id = modificador_id;
	}
	public String getModificador_des() {
		return Modificador_des;
	}
	public void setModificador_des(String modificador_des) {
		Modificador_des = modificador_des;
	}
		
	
	public void Insertar() {
		
		 try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);	
				System.out.println("Conexion exitosa");
				
				
				ps =conn.prepareStatement("INSERT INTO language VALUES (?,?,?)");
				ps.setInt(1,7);
				ps.setString(2,"Creol");
				ps.setString(3,"2028");
				
				
				ps.executeUpdate();//probar buscar el cliente con ese codigo 
				
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
