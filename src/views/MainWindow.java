package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import db_connection.DataBaseConnection;
import models.PacientModel;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Panel;
import java.awt.Point;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainWindow extends ParentWindow implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnNewButton, buttonDetail, buttonPacient;
	private String[] columnNames = new String [] {"Nombre", "Apellido"};
	private JLabel deported;
	private JLabel legal;
	private JLabel drugs;
	private JLabel moved;
	private JLabel crossed;
	private ArrayList<PacientModel> pacientModels;
	private int currentRowPos = -1;
	private MouseMotionListener motionListener = new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			Point point = e.getPoint();
			if(currentRowPos != table.rowAtPoint(point)) {
			currentRowPos = table.rowAtPoint(point);
			table.getSelectionModel().setSelectionInterval(currentRowPos, currentRowPos);
			cellSelectedChanged(currentRowPos);
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};

	public MainWindow() {
		setTitle("Pantalla principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getParentContentJPanel();
		table = new JTable();
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnIdentifiers(columnNames);
		tableModel.fireTableDataChanged();
		tableModel.addTableModelListener(table);
		table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseMotionListener(motionListener);
		
		table.setBounds(0, 0, 400, 713);
		JScrollPane scrollPane = new JScrollPane(table); 	
		scrollPane.setBounds(0, 0, 400, 713);

		contentPane.add(scrollPane);
		
		Panel panel = new Panel();
		panel.setBounds(400, 0, 624, 703);
		contentPane.add(panel);
		panel.setLayout(null);
		int w = 624/3;
		btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(0, 0, w, 40);

		panel.add(btnNewButton);
		
		buttonDetail = new JButton("Detalle");
		buttonDetail.setBounds(200, 0, w, 40);
		buttonDetail.addActionListener(this);


		panel.add(buttonDetail);
		
		buttonPacient = new JButton("Mostrar lista");
		buttonPacient.setBounds(400, 0, w, 40);
		buttonPacient.addActionListener(this);

		panel.add(buttonPacient);
		
		deported = new JLabel("X");
		deported.setBounds(100, 107, 150, 150);
		deported.setIcon(resizedImageIcon("/images/icon_deported.png", deported));
		panel.add(deported);

		legal = new JLabel("X");
		legal.setBounds(370, 107, 150, 150);
		legal.setIcon(resizedImageIcon("/images/icon_legal.png", legal));
		panel.add(legal);
		
		drugs = new JLabel("X");
		drugs.setBounds(100, 327, 150, 150);
		drugs.setIcon(resizedImageIcon("/images/icon_drugs.png", drugs));
		panel.add(drugs);
		
		moved = new JLabel("X");
		moved.setBounds(370, 327, 150, 150);
		moved.setIcon(resizedImageIcon("/images/icon_move.png", moved));
		panel.add(moved);
		
		crossed = new JLabel("X");
		crossed.setBounds(230, 527, 150, 150);
		crossed.setIcon(resizedImageIcon("/images/icon_usa.png", crossed));
		panel.add(crossed);


	}
	
	public ImageIcon resizedImageIcon(String path, JLabel label) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(this.getClass().getResource(path));
		    Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
		            Image.SCALE_SMOOTH);
		    ImageIcon imageIcon = new ImageIcon(dimg);
		    return imageIcon;
		} catch (IOException e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public void updateTable() {
		clearTable();
		pacientModels = DataBaseConnection.getInstance().getPacients();
		//System.out.println(String.valueOf(pacientModels.size()));
		for(int i = 0; i < pacientModels.size(); i++) {
	        tableModel.addRow(pacientModels.get(i).getPacientDataArray());
	        
		}
		tableModel.fireTableDataChanged();
	}
	
	public void clearTable() {
		while(tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}
	
	public void showFormulary() {
		FormularyWindow frame = new FormularyWindow();
		frame.setVisible(true);
	}
	
	public void showReport() {
		ReportWindow reportWindow = new ReportWindow();
		reportWindow.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) {
			showFormulary();
		}
		else if(e.getSource() == buttonDetail) {
			showReport();
		}
		else if(e.getSource() == buttonPacient) {
			updateTable();
		}

	}

	public void cellSelectedChanged(int selected) {	
			//System.out.println(String.valueOf(table.getSelectedRow()));
			if(pacientModels != null) {
				String res = "Si";
				
				if(pacientModels.get(selected).deportado.equals(res)) 
					deported.setVisible(true);
				else 
					deported.setVisible(false);
				
				if(pacientModels.get(selected).eua_legal.equals(res)) 
					legal.setVisible(true);
				else 
					legal.setVisible(false);

				if(pacientModels.get(selected).cambiar_ciudad.equals(res)) 
					moved.setVisible(true);
				else 
					moved.setVisible(false);

				if(pacientModels.get(selected).drogas.equals(res)) 
					drugs.setVisible(true);
				else 
					drugs.setVisible(false);

				if(pacientModels.get(selected).eua_cruzado.equals(res)) 
					crossed.setVisible(true);
				else 
					crossed.setVisible(false);

		}
	}
	
	
}
