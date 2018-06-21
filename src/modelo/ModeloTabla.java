package modelo;


import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

	private List<CocheDTO> lista = new ArrayList<CocheDTO>();
	private String[] columnas = {"Numero_Bastidor","Marca","Modelo","Matriculacion"};
	private CocheDAOImp imple = new CocheDAOImp();
	
	public ModeloTabla() {
		lista = imple.mostrarLista();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex) {
		case 0: return lista.get(rowIndex).getNumeroBastidor();
		case 1: return lista.get(rowIndex).getMarca();
		case 2: return lista.get(rowIndex).getModelo();
		case 3: return lista.get(rowIndex).getMatriculacion();
		default: return null;
		}
		
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return columnas[column];
	}
	

}
