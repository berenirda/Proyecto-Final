package connection;


import java.util.Scanner;


public class conexionn  {
	
	
	
	public conexionn() {
		
		
	}
	

	public  void printmenu() {
		try (Scanner entrada = new Scanner(System.in)) {
			int opc;
			String sino;
			

			do {
System.out.println("\n|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|" +
					"\n|               	 Bienvenido A Yawey Renta-Film	   		        |\t"+
			        "\n|                                                              	|" +
			        "\n|     					                                        |" +
			        "\n|                                                            	|" +
			        "\n|           1. Consultar Peliculas                           	|" +
			        "\n|           2. Prestar Pelicula                       		    |" +
			        "\n|           3. Ver Inventario de peliculas                       |" +
			        "\n|           4. Modificar Pelicula                                |" +
			        "\n|           5. Insertar Film                     		    	|" +
			        "\n|           6. Ver Lista de Clientes               			    |" +
			        "\n|           7. Buscar Cliente especifico  	             		|" +
			        "\n|           8. Modificar Datos del Usuario               		|" +
			        "\n|           9. Salir                       					    |" +
			        "\n|________________________________________________________________|" );
			opc = entrada.nextInt();
			
			
				switch(opc) {
				
				case 1: 
					
					film lista = new film();
					lista.consultar_film();
					break;	
				
				case 2:
					film search = new film();
					search.buscar();
					
					break;
				case 3:
					new Inventary();
					break;
					
				case 4:
					film modificate = new film();
					modificate.Modificar();
					break;	
					
				case 5:
					film Insertar_Film = new film();
					Insertar_Film.Insertar();
					break;	
				case 6:
					new Clientes();
					
					break;	
				case 7:
					GESTION_USERS Usersearch = new GESTION_USERS();
					Usersearch.Search_user();
					break;
				case 8:
					GESTION_USERS Modificate_user = new GESTION_USERS();
					Modificate_user.Modificar_user();
					break;
				default:
					System.out.println("Opcion No disponible");
					break;
				
				}
			
				System.out.println("\nDesea Elegir Otra opcion Si -->s  && No --> n");
				sino = entrada.next();
				
			}while("s".equals(sino));
		}
	}
	
	
}


