package controlador;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

import modelo.*;
import vista.*;



public class Controlador implements ActionListener{
    private Vista vista;
    private CocheDAOImp impl = new CocheDAOImp();
    private CocheDTO coche = new CocheDTO();
    private int contadorFormulario = 0;
    private List<CocheDTO> listaCochesFormulario = impl.mostrarLista();

    public Controlador(Vista vista) {
        this.vista = vista;
        registrarComponentes();
        cargarCombox();
        cargarFormulario();
    }

    private void registrarComponentes() {
    	//MENU-BAR
    	vista.getMntmSalir_1().addActionListener(this);
        //BOTONES
    	vista.getBtnEliminar().addActionListener(this);
    	vista.getBtnAnadir().addActionListener(this);
    	vista.getBtnBuscar().addActionListener(this);
    	vista.getBtnActualizar().addActionListener(this);
    	vista.getButtonMenor_1().addActionListener(this);
    	vista.getButtonMayor_1().addActionListener(this);
    	vista.getButtonMasMayor_1().addActionListener(this);
    	vista.getButtonMasMenor_1().addActionListener(this);
    	vista.getBtnFiltrar().addActionListener(this);
    	vista.getBtnReset().addActionListener(this);
        //TABLA
        vista.getTable();
        //CAMPOS DE TEXTO
        vista.getTextFieldBuscador();
        vista.getTextFieldNumeroBastidor();
        vista.getTextFieldMarca();
        vista.getTextFieldModelo();
        vista.getTextFieldMatriculacion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stube
    	//BOTONES
        if ( e.getSource().getClass() == JButton.class ) {
            JButton botonPulsado = (JButton) e.getSource();
            System.out.println("Pulsado boton " + botonPulsado.getText());
            
            if( botonPulsado.getText() == "Eliminar") {
            	if(vista.getTable().getSelectedRow() >=0) {
            		System.out.println(vista.getTable().getSelectedRow());
            		String numeroBastidorBorrar = vista.getTable().getValueAt(vista.getTable().getSelectedRow(), 0 ).toString();
            		impl.borrarCoche(numeroBastidorBorrar);
            		//Refrescamos JTABLE
            		actualizarTabla();
            		
            	}
            }
            if( botonPulsado.getText() == "Buscar" ) {
            	String bastidor = vista.getTextFieldBuscador().getText();
            	if( bastidor.length() != 17) {
            		JOptionPane.showMessageDialog(null,"Numero de bastidor no valido");
            	} else {
            		if(!comprobarExistenciaNBast(bastidor)) {
            			JOptionPane.showMessageDialog(null,"Coche no registrado");
            		} else {
            			coche = impl.mostrarCochePorNB(bastidor);
            			vista.getTextFieldNumeroBastidor().setText(coche.getNumeroBastidor());
            			vista.getTextFieldMarca().setText(coche.getMarca());
            			vista.getTextFieldModelo().setText(coche.getModelo());
            			vista.getTextFieldMatriculacion().setText(coche.getMatriculacion());
            		}
            	}
            }
            if( botonPulsado.getText() == "Anadir") {
            	Object[] textFields = {
        				"Numero_Bastidor", vista.getTextFieldAnadirNumeroBastidor(),
        				"Marca", vista.getTextFieldAnadirMarca(),
        				"Modelo", vista.getTextFieldAnadirModelo(),
        				"Matriculacion", vista.getTextFieldAnadirMatriculacion()
        		};
            	int resultado = JOptionPane.showConfirmDialog(null, textFields, "Añadir coche", JOptionPane.OK_CANCEL_OPTION);
            	CocheDTO coche2;
            	try {
					 coche2 = new CocheDTO(vista.getTextFieldAnadirNumeroBastidor().getText(), vista.getTextFieldAnadirMarca().getText(), 
							vista.getTextFieldAnadirModelo().getText(), vista.getTextFieldAnadirMatriculacion().getText());
					 if(resultado==JOptionPane.OK_OPTION) {
		        			impl.anadirCoche(coche2);
		        			JOptionPane.showMessageDialog(null, "Coche anadido", "INFORMACION", 1);
		        			actualizarTabla();
		            	}
				} catch (ExceptionCocheDTO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            
            if( botonPulsado.getText() == "Actualizar") {
            	String numeroBastidor;
            	String marca;
            	String modelo;
            	String matriculacion;
            	int numeroFila = vista.getTable().getSelectedRow();
            	
            	numeroBastidor = vista.getTable().getValueAt(numeroFila, 0).toString();
            	marca = vista.getTable().getValueAt(numeroFila, 1).toString();
            	modelo = vista.getTable().getValueAt(numeroFila, 2).toString();
            	matriculacion = vista.getTable().getValueAt(numeroFila, 3).toString();
            	
            	try {
					CocheDTO cocheModificado = new CocheDTO(numeroBastidor, marca, modelo, matriculacion);
					impl.updateCoche(cocheModificado, numeroBastidor);
					actualizarTabla();
				} catch (ExceptionCocheDTO e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	
            }
            
            if( botonPulsado.getText() == ">") {
            	contadorFormulario ++;
            	if(contadorFormulario > listaCochesFormulario.size() - 1) {
            		contadorFormulario = 0;
            	}
            	cargarFormulario();
            }
            
            if( botonPulsado.getText() == "<") {
            	contadorFormulario --;
            	if (contadorFormulario < 0) {
            		contadorFormulario = listaCochesFormulario.size() - 1;
            	}
            	cargarFormulario();
            }
            
            if( botonPulsado.getText() == ">>") {
            	contadorFormulario += 10;
            	if(contadorFormulario > listaCochesFormulario.size() - 1) {
            		contadorFormulario = 0;
            	}
            	cargarFormulario();
            }
            
            if( botonPulsado.getText() == "<<") {
            	contadorFormulario -= 10;
            	if (contadorFormulario < 0) {
            		contadorFormulario = listaCochesFormulario.size() - 1;
            	}
            	cargarFormulario();
            }
            
            if( botonPulsado.getText() == "Filtrar") {
            	listaCochesFormulario = impl.obtenerListaCochesMarcas(vista.getComboBoxMarca().getSelectedItem().toString());
            	contadorFormulario = 0;
            	cargarFormulario();
            }
            
            if( botonPulsado.getText() == "Reset") {
            	listaCochesFormulario = impl.mostrarLista();
            	contadorFormulario = 0;
            	cargarFormulario();
            }
        }
        
        
        //Menu-Bar
        if (e.getSource().getClass() == JMenuItem.class) {
            System.out.println("menu");
            JMenuItem menuPulsado = (JMenuItem) e.getSource();    
            System.out.println("Menu botonn " + menuPulsado.getText());
            if( menuPulsado.getText() == "Salir") {
            	System.exit(1);
            }

        }
        
    }

	private void actualizarTabla() {
		
		List<CocheDTO> lista = impl.mostrarLista();
		Object[][] datos = new Object[lista.size()][4];
		String[] cabeceras = {"Numero_Bastidor", "Marca", "Modelo", "Matriculacion"};
		int contador = 0;
		
		for (CocheDTO coche : lista) {
			datos[contador][0] = coche.getNumeroBastidor();
			datos[contador][1] = coche.getMarca();
			datos[contador][2] = coche.getModelo();
			datos[contador][3] = coche.getMatriculacion();
			contador++;
		}
		DefaultTableModel model = new DefaultTableModel (datos, cabeceras){
			private static final long serialVersionUID = 1L;
			@Override 
		    public boolean isCellEditable(int row, int column){
		    	return column!=0;
		    }
		};
		
		vista.getTable().setModel(model);
		
	}

	private boolean comprobarExistenciaNBast(String numeroBasti){
		List<CocheDTO> listacoches = impl.mostrarLista();
		List<String> listaNumeroBast = new ArrayList<String>();
		String bastidor;
		boolean validador = false;
		for (CocheDTO cocheDTO : listacoches) {
			bastidor = cocheDTO.getNumeroBastidor();
			listaNumeroBast.add(bastidor);
		}
		for (String string : listaNumeroBast) {
			System.out.println(string);
			if(string.equals(numeroBasti)) {
				validador = true;
				return validador;
				
			}
			
		}
		return validador;

	}
	
	public void cargarCombox() {
		List<String> listaMarcas = impl.crearListaMarcas();
        for (int i = 0; i < listaMarcas.size(); i++) {
        	vista.getComboBoxMarca().addItem(listaMarcas.get(i));
        }
	}
	
	public void cargarFormulario() {
		vista.getTextFieldNumeroBastidor().setText(listaCochesFormulario.get(contadorFormulario).getNumeroBastidor());
		vista.getTextFieldMarca().setText(listaCochesFormulario.get(contadorFormulario).getMarca());
		vista.getTextFieldModelo().setText(listaCochesFormulario.get(contadorFormulario).getModelo());
		vista.getTextFieldMatriculacion().setText(listaCochesFormulario.get(contadorFormulario).getMatriculacion());
	}

}