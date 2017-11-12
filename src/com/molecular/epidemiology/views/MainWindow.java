package com.molecular.epidemiology.views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends ParentWindow {


	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable table;

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
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(15, 16, 166, 160);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Detalle");
		button.setBounds(15, 281, 166, 160);
		panel.add(button);
		
		JButton button_1 = new JButton("Borrar");
		button_1.setBounds(15, 527, 166, 160);
		panel.add(button_1);
	}
}
