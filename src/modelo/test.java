package modelo;

import java.sql.SQLException;
import java.util.ArrayList;

public class test {

	public static void main(String args[]) {
		try {
			CocheDTO coche1 = new CocheDTO("WQU78945612301477", "Audi", "A6", "2005");
		} catch (ExceptionCocheDTO e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}
