package modelo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class LeerFicheroCSV {

	public static ArrayList<CocheDTO> leerCSV(String path) {
		ArrayList<CocheDTO> listaCoches = new ArrayList<>();
		ArrayList<String[]> datosCSV = new ArrayList<>();
		try (CSVReader reader = new CSVReader(new FileReader(path));){	
			reader.readNext();
			String[] nextLine;
			while ((nextLine = reader.readNext()) != null) {
				datosCSV.add(nextLine);	
			}
			
			for (int i = 0; i < datosCSV.size(); i++) {
				String numeroBastidor = datosCSV.get(i)[0];
				String marca =  datosCSV.get(i)[1];		
				String modelo = datosCSV.get(i)[2];
				String matriculacion = datosCSV.get(i)[3];
				
				
				listaCoches.add(new CocheDTO(numeroBastidor, marca, modelo, matriculacion));			
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaCoches;

	}
	
	

	/*public static void main(String[] args) {
		System.out.println(leerCSV("ficheroCSV/coches.csv"));
		
		
		
	}*/

}