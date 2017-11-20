package views;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.ParentWindowInterface;

public class ParentWindow extends JFrame implements ParentWindowInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	JMenuBar menuBar;
	
	public ParentWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 800);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("	Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnArchivo.add(mntmNuevo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public JPanel getParentContentJPanel() {
		return contentPane;
	}

	@Override
	public void setDefaultCloseOperation(int operation) {
		super.setDefaultCloseOperation(operation);
	}

	@Override
	public void setTopBarMenuVisible(boolean visible) {
		menuBar.setVisible(visible);
	}
}
