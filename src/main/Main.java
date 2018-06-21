package main;

import java.awt.EventQueue;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controlador.Controlador;
import modelo.CocheDAOImp;
import modelo.CocheDTO;
import modelo.ExceptionCocheDTO;
import vista.Vista;

public class Main extends Vista {

	public static void main(String[] args) {
		File ficheroBD = new File("BD/coches");
		if(!ficheroBD.exists()) {
			CocheDAOImp impl = new CocheDAOImp();
			try {
				impl.crearBaseDatos();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			impl.importarCSV();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Vista window = new Vista();
						new Controlador(window);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Vista window = new Vista();
						new Controlador(window);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}	
	}
}
