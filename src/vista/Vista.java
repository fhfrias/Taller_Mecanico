package vista;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import modelo.ModeloTabla;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista {

	public JFrame frmTallerMecanico;
	private JTextField textFieldNumeroBastidor;
	private JTextField textFieldMarca;
	private JTextField textFieldModelo;
	private JTextField textFieldMatriculacion;
	private JTextField textFieldBuscador;
	//Para anadir coche
	private JTextField textFieldAnadirNumeroBastidor = new JTextField();
	private JTextField textFieldAnadirMarca = new JTextField();
	private JTextField textFieldAnadirModelo = new JTextField();
	private JTextField textFieldAnadirMatriculacion = new JTextField();
	//
	private JTable table;
	private JButton btnBuscar;
	private JButton btnEliminar;
	private JButton btnAnadir;
	private JButton btnActualizar;
	private JButton buttonMayor_1;
	private JButton buttonMenor_1;
	private JButton buttonMasMenor_1;
	private JButton buttonMasMayor_1;
	
	private JMenuItem mntmSalir_1;
	
	private JComboBox comboBoxMarca;
	private JButton btnFiltrar;
	private JButton btnReset;
	
	
	
	
	
	
	//GETTERS Y SETTERS
	
	public JTextField getTextFieldBuscador() {
		return textFieldBuscador;
	}

	public void setTextFieldBuscador(JTextField textFieldBuscador) {
		this.textFieldBuscador = textFieldBuscador;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}

	public void setBtnFiltrar(JButton btnFiltrar) {
		this.btnFiltrar = btnFiltrar;
	}

	public JButton getButtonMayor_1() {
		return buttonMayor_1;
	}

	public void setButtonMayor_1(JButton buttonMayor_1) {
		this.buttonMayor_1 = buttonMayor_1;
	}

	public JButton getButtonMenor_1() {
		return buttonMenor_1;
	}

	public void setButtonMenor_1(JButton buttonMenor_1) {
		this.buttonMenor_1 = buttonMenor_1;
	}

	public JComboBox getComboBoxMarca() {
		return comboBoxMarca;
	}

	public void setComboBoxMarca(JComboBox comboBoxMarca) {
		this.comboBoxMarca = comboBoxMarca;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}
	
	public JTextField getTextFieldAnadirNumeroBastidor() {
		return textFieldAnadirNumeroBastidor;
	}

	public void setTextFieldAnadirNumeroBastidor(JTextField textFieldAnadirNumeroBastidor) {
		this.textFieldAnadirNumeroBastidor = textFieldAnadirNumeroBastidor;
	}

	public JTextField getTextFieldAnadirMarca() {
		return textFieldAnadirMarca;
	}

	public void setTextFieldAnadirMarca(JTextField textFieldAnadirMarca) {
		this.textFieldAnadirMarca = textFieldAnadirMarca;
	}

	public JTextField getTextFieldAnadirModelo() {
		return textFieldAnadirModelo;
	}

	public void setTextFieldAnadirModelo(JTextField textFieldAnadirModelo) {
		this.textFieldAnadirModelo = textFieldAnadirModelo;
	}

	public JTextField getTextFieldAnadirMatriculacion() {
		return textFieldAnadirMatriculacion;
	}

	public void setTextFieldAnadirMatriculacion(JTextField textFieldAnadirMatriculacion) {
		this.textFieldAnadirMatriculacion = textFieldAnadirMatriculacion;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JMenuItem getMntmSalir_1() {
		return mntmSalir_1;
	}

	public void setMntmSalir_1(JMenuItem mntmSalir_1) {
		this.mntmSalir_1 = mntmSalir_1;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public void setTextFieldNumeroBastidor(JTextField textFieldNumeroBastidor) {
		this.textFieldNumeroBastidor = textFieldNumeroBastidor;
	}

	public void setTextFieldMarca(JTextField textFieldMarca) {
		this.textFieldMarca = textFieldMarca;
	}

	public void setTextFieldModelo(JTextField textFieldModelo) {
		this.textFieldModelo = textFieldModelo;
	}

	public void setTextFieldMatriculacion(JTextField textFieldMatriculacion) {
		this.textFieldMatriculacion = textFieldMatriculacion;
	}

	public JTextField getTextFieldNumeroBastidor() {
		return textFieldNumeroBastidor;
	}

	public JTextField getTextFieldMarca() {
		return textFieldMarca;
	}

	public JTextField getTextFieldModelo() {
		return textFieldModelo;
	}

	public JTextField getTextFieldMatriculacion() {
		return textFieldMatriculacion;
	}

	public JButton getButtonMasMenor_1() {
		return buttonMasMenor_1;
	}

	public void setButtonMasMenor_1(JButton buttonMasMenor_1) {
		this.buttonMasMenor_1 = buttonMasMenor_1;
	}

	public JButton getButtonMasMayor_1() {
		return buttonMasMayor_1;
	}

	public void setButtonMasMayor_1(JButton buttonMasMayor_1) {
		this.buttonMasMayor_1 = buttonMasMayor_1;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTallerMecanico = new JFrame();
		frmTallerMecanico.setResizable(false);
		frmTallerMecanico.setTitle("Taller Mecanico");
		frmTallerMecanico.setBounds(100, 100, 650, 650);
		frmTallerMecanico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTallerMecanico.setVisible(true);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frmTallerMecanico.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		//JSplit Pane
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.28);
		tabbedPane.addTab("Coches", null, splitPane, null);
		
		//Panel Filtro
		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		splitPane.setRightComponent(panel1);
		panel1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lbNumeroBastidor = new JLabel("Numero_Bastidor");
		panel1.add(lbNumeroBastidor);
		
		textFieldNumeroBastidor = new JTextField();
		panel1.add(textFieldNumeroBastidor);
		textFieldNumeroBastidor.setColumns(10);
		textFieldNumeroBastidor.setEditable(false);
		textFieldNumeroBastidor.setBackground(Color.WHITE);
		
		JLabel lblMarca = new JLabel("Marca");
		panel1.add(lblMarca);
		
		textFieldMarca = new JTextField();
		panel1.add(textFieldMarca);
		textFieldMarca.setColumns(10);
		textFieldMarca.setEditable(false);
		textFieldMarca.setBackground(Color.WHITE);
		
		JLabel lblModelo = new JLabel("Modelo");
		panel1.add(lblModelo);
		
		textFieldModelo = new JTextField();
		panel1.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		textFieldModelo.setEditable(false);
		textFieldModelo.setBackground(Color.WHITE);
		
		JLabel lblMatriculacion = new JLabel("Matriculacion");
		panel1.add(lblMatriculacion);
		
		textFieldMatriculacion = new JTextField();
		panel1.add(textFieldMatriculacion);
		textFieldMatriculacion.setColumns(10);
		textFieldMatriculacion.setEditable(false);
		textFieldMatriculacion.setBackground(Color.WHITE);
		
		JPanel panelBotones = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBotones.getLayout();
		flowLayout.setVgap(12);
		panel1.add(panelBotones);
		
		buttonMasMenor_1 = new JButton("<<");
		panelBotones.add(buttonMasMenor_1);
		
		buttonMenor_1 = new JButton("<");
		panelBotones.add(buttonMenor_1);
		
		buttonMayor_1 = new JButton(">");
		panelBotones.add(buttonMayor_1);
		
		buttonMasMayor_1 = new JButton(">>");
		panelBotones.add(buttonMasMayor_1);
		
		JPanel panel2 = new JPanel();
		splitPane.setLeftComponent(panel2);
		panel2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelSelect = new JPanel();
		panel2.add(panelSelect);
		
		JLabel lblMarca_1 = new JLabel("Marca");
		panelSelect.add(lblMarca_1);
		
		comboBoxMarca = new JComboBox();
		panelSelect.add(comboBoxMarca);
		
		JPanel panelBotonesSelect = new JPanel();
		panel2.add(panelBotonesSelect);
		panelBotonesSelect.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotonesSelectIN = new JPanel();
		panelBotonesSelect.add(panelBotonesSelectIN);
		panelBotonesSelectIN.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnFiltrar = new JButton("Filtrar");
		panelBotonesSelectIN.add(btnFiltrar);
		
		JLabel label = new JLabel("");
		panelBotonesSelectIN.add(label);
		
		JLabel label_1 = new JLabel("");
		panelBotonesSelectIN.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panelBotonesSelectIN.add(label_2);
		
		btnReset = new JButton("Reset");
		panelBotonesSelectIN.add(btnReset);
		
		btnBuscar = new JButton("Buscar");
		panelBotonesSelectIN.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		panelBotonesSelectIN.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNumBastidor = new JLabel("NUM BASTIDOR");
		panel_1.add(lblNumBastidor, BorderLayout.NORTH);
		
		textFieldBuscador = new JTextField();
		panel_1.add(textFieldBuscador, BorderLayout.CENTER);
		textFieldBuscador.setColumns(10);
		
		//Panel Tablas
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Tablas", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable(new ModeloTabla());
		JScrollPane scrollPane = new JScrollPane(table);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.NORTH);
		
		btnAnadir = new JButton("Anadir");
		panel.add(btnAnadir);
		
		btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		panel.add(btnActualizar);
		
		
		
		//MenuBar
		
		
		JMenuBar menuBar = new JMenuBar();
		frmTallerMecanico.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		mntmSalir_1 = new JMenuItem("Salir");
		mnOpciones.add(mntmSalir_1);
	}

}