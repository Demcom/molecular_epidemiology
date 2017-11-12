package views;

import java.awt.AWTEvent;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db_connection.DataBaseConnection;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends ParentWindow implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton, button, button_1;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
		contentPane = getParentContentJPanel();
		table = new JTable();
		table.setBounds(0, 0, 800, 713);
		contentPane.add(table);
		
		Panel panel = new Panel();
		panel.setBounds(806, 0, 196, 703);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(15, 16, 166, 160);
		panel.add(btnNewButton);
		
		button = new JButton("Detalle");
		button.setBounds(15, 281, 166, 160);
		panel.add(button);
		
		button_1 = new JButton("Borrar");
		button_1.setBounds(15, 527, 166, 160);
		panel.add(button_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) {
			DataBaseConnection.getInstance().getPacientInfo();
		}
	}
}
