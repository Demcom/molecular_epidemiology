package views;

import java.awt.AWTEvent;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.StringHolder;

import db_connection.DataBaseConnection;
import models.PacientModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.Color;

import javax.naming.spi.ObjectFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainWindow extends ParentWindow implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnNewButton, buttonDetail, buttonPacient;
	private String[] columnNames = new String [] {"Nombre", "Apellido", 
			"Cruzado a EUA", "Deportado", "Cambiar ciudad", "Legal en EUA", "Drogas"};

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getParentContentJPanel();
		table = new JTable();
		tableModel = (DefaultTableModel) table.getModel();	
		tableModel.setColumnIdentifiers(columnNames);
		tableModel.fireTableDataChanged();

		table.setBounds(0, 0, 800, 713);
		JScrollPane scrollPane = new JScrollPane(table); 	
		scrollPane.setBounds(0, 0, 800, 713);

		contentPane.add(scrollPane);
		
		Panel panel = new Panel();
		panel.setBounds(806, 0, 196, 703);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(15, 16, 166, 160);
		panel.add(btnNewButton);
		
		buttonDetail = new JButton("Detalle");
		buttonDetail.setBounds(15, 281, 166, 160);
		buttonDetail.addActionListener(this);
		panel.add(buttonDetail);
		
		buttonPacient = new JButton("Mostrar lista");
		buttonPacient.setBounds(15, 527, 166, 160);
		buttonPacient.addActionListener(this);
		panel.add(buttonPacient);
	}
	
	public void updateTable() {
		ArrayList<PacientModel> pacientModels = DataBaseConnection.getInstance().getPacients();
		//System.out.println(String.valueOf(pacientModels.size()));
		for(int i = 0; i < pacientModels.size(); i++) {
	        tableModel.addRow(pacientModels.get(i).getPacientDataArray());
		}
		tableModel.fireTableDataChanged();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) {
			
		}
		else if(e.getSource() == buttonDetail) {

		}
		else if(e.getSource() == buttonPacient) {
			updateTable();
		}

	}
}
