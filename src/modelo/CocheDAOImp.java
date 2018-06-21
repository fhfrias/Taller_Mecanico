package modelo;

import java.sql.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class CocheDAOImp implements CocheDAO {

    Connection connection = Conexion.getConexion();
     
    
        private static final String DELETE = "DELETE FROM coches WHERE Numero_Bastidor=?";
        private static final String FIND_BY_Numero_Bastidor = "SELECT * FROM coches WHERE Numero_Bastidor=?";
        private static final String FIND_ALL = "SELECT * FROM coches ORDER BY Matriculacion, Numero_Bastidor";
        private static final String INSERT = "INSERT INTO coches (Numero_Bastidor, Marca, Modelo, Matriculacion) VALUES (?, ?, ?, ?)";
        private static final String UPDATE = "UPDATE coches SET Numero_Bastidor=?, Marca=?, Modelo=?, Matriculacion=? WHERE Numero_Bastidor=?";
    
        //Insertar coche
        
    public void anadirCoche(CocheDTO coche) {
        // TODO Auto-generated method stub
       
        String sql = "INSERT INTO coches (Numero_Bastidor, Marca, Modelo, Matriculacion) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT);
            
            ps.setString(1, coche.getNumeroBastidor());
            ps.setString(2, coche.getMarca());
            ps.setString(3, coche.getModelo());
            ps.setString(4, coche.getMatriculacion());
            
            ps.executeUpdate();
            ps.close();
            
            System.out.println("Coche con estos datos creado: " + coche.toString());
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    
    }
    
    @Override
	public void  anadirListaCoches(ArrayList<CocheDTO> lista) {
		try {
			connection.setAutoCommit(true);
			for (CocheDTO cochesDTO : lista) {
				anadirCoche(cochesDTO);
				System.out.println(cochesDTO);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al anadir lista");
		} 
	}
    
    //Importar CSV
    public void importarCSV() {
    	CocheDAOImp imp = new CocheDAOImp();
		LeerFicheroCSV lector = new LeerFicheroCSV();
		ArrayList<CocheDTO> listaCSV = new ArrayList<CocheDTO>();
		listaCSV = lector.leerCSV("ficheroCSV/coches.csv");
		imp.anadirListaCoches(listaCSV);
    }

    //Modificar coche
    
     @Override
        public void updateCoche(CocheDTO coche, String numeroBastidor) {
             
            try {
     
                PreparedStatement ps = connection.prepareStatement(UPDATE);
     
                ps.setString(1, coche.getNumeroBastidor());
                ps.setString(2, coche.getMarca());
                ps.setString(3, coche.getModelo());
                ps.setString(4, coche.getMatriculacion());
                ps.setString(5, coche.getNumeroBastidor());

             
                 
                ps.executeUpdate();
                ps.close();
     
               System.out.println("Coche con numero de Bastidor " + coche.getNumeroBastidor() + " ha sido actualizado con los siguientes datos: " + coche.toString());
     
            } catch (SQLException e) {
                //e.printStackTrace();
                throw new RuntimeException(e);
            }
             
        }
     
     //Borrar coche
     
     @Override
     public void borrarCoche(String numeroBastidor) {
         
            try {
     
                PreparedStatement ps = connection.prepareStatement(DELETE);
     
                ps.setString(1, numeroBastidor);
     
                ps.executeUpdate();
                ps.close();
     
                System.out.println("Coche con numero de Bastidor: " + numeroBastidor + " ha sido borrado.");
     
            } catch (SQLException e) {
                //e.printStackTrace();
                throw new RuntimeException(e);
            }
     
        }
    
     //Obtener coche por numero de Bastidor
     
     @Override
        public CocheDTO mostrarCochePorNB(String numeroBastidor) {
     
            CocheDTO coche = null;
     
            
            
            try {
                PreparedStatement ps = connection.prepareStatement(FIND_BY_Numero_Bastidor);
                ps.setString(1, numeroBastidor); 
     
                ResultSet resultSet = ps.executeQuery();
     
                if (resultSet.next()) {
     
                    coche = new CocheDTO();
     
                    coche.setNumeroBastidor(resultSet.getString("Numero_Bastidor"));
                    coche.setMarca(resultSet.getString("Marca"));
                    coche.setModelo(resultSet.getString("Modelo"));
                    coche.setMatriculacion(resultSet.getString("Matriculacion"));
                    
                    
     
                }
                
                System.out.println(coche.toString());
     
                resultSet.close();
                ps.close();
     
            } catch (SQLException e) {
                //e.printStackTrace();
                throw new RuntimeException(e);
            }
     
            return coche;
     
        }
 
     //Obtener lista de todos los coches
     
     @Override
        public List<CocheDTO> mostrarLista() {
     
            List<CocheDTO> coches = new LinkedList<CocheDTO>();
     
            try {
                Statement statement = (Statement) connection.createStatement();
                ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(FIND_ALL);
     
                CocheDTO coche = null;
     
                while (resultSet.next()) {
                    coche = new CocheDTO();
     
                    coche.setNumeroBastidor(resultSet.getString("Numero_Bastidor"));
                    coche.setMarca(resultSet.getString("Marca"));
                    coche.setModelo(resultSet.getString("Modelo"));
                    coche.setMatriculacion(resultSet.getString("Matriculacion"));
                    
     
                    System.out.println(coche.toString());
     
                    coches.add(coche);
                }
     
                resultSet.close();
                (statement).close();
     
     
            } catch (SQLException e) {
                //e.printStackTrace();
                throw new RuntimeException(e);
            }
     
            return coches;

     }
     
     //Crear base de datos
     
     public void crearBaseDatos() throws SQLException{
         
         PreparedStatement ps = connection.prepareStatement("CREATE TABLE IF NOT EXISTS coches"
                     + "(Numero_Bastidor varchar(17) PRIMARY KEY,Marca varchar(40),Modelo varchar(40),"
                     + "Matriculacion varchar(4))");
         
         ps.executeUpdate();
         ps.close();
         
         System.out.println("BD creada");
         
         try {
             
             
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error");
            
        } 
         
     }

	//Lista de las diferentes Marcas
     public List<String> crearListaMarcas() {
		 List<String> listaMarcas = new ArrayList<>();
		 String sql = "SELECT Marca FROM coches group by Marca"; 
         try {
             Statement statement = (Statement) connection.createStatement();
             ResultSet resultSet = ((java.sql.Statement) statement).executeQuery(sql);
  
             String marca;
  
             while (resultSet.next()) {
                 
  
                 marca = resultSet.getString("Marca");
                 listaMarcas.add(marca);
             }
  
             resultSet.close();
             (statement).close();
  
  
         } catch (SQLException e) {
             //e.printStackTrace();
             throw new RuntimeException(e);
         }
         
         return listaMarcas;
	 }
     
     public List<CocheDTO> obtenerListaCochesMarcas(String marca){
    	 List<CocheDTO> listaTodosCoches = mostrarLista();
    	 List<CocheDTO> listaMarca = new ArrayList<>();
    	 for (CocheDTO cocheDTO : listaTodosCoches) {
			if(cocheDTO.getMarca().equals(marca)) {
				listaMarca.add(cocheDTO);
				System.out.println(cocheDTO);
			}
		}
    	 
    	 return listaMarca;
     }
     
}