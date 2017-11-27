package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import db_connection.DataBaseConnection;
import models.PacientModel;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class FormularyWindow extends ParentWindow implements ActionListener{
	private JTextField textField_1;
	private JTextField nameTextField;
	private JTextField lastNameTextField;
	private String [] options = new String[] {"","Si", "No"};
	private String [] studyOptions = new String[] {"Primaria", "Secundaria", "Preparatoria", "Universidad"};
	private JButton btnRegister;
	private JComboBox euaComboBox, statusComboBox, deportedComboBox, studyComboBox, readComboBox;
	private JComboBox cityComboBox, drugsComboBox, legalComboBox, ocupationComboBox, sexComboBox;
	public FormularyWindow() {
		setTitle("Paciente nuevo");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTopBarMenuVisible(false);
		setBounds(1024, 0, 400, 1000);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setBounds(15, 40, 69, 20);
		getContentPane().add(lblName);
		
		JLabel lblLastName = new JLabel("Apellido");
		lblLastName.setBounds(15, 100, 69, 20);
		getContentPane().add(lblLastName);
		
		JLabel lblStatus = new JLabel("Estado civil");
		lblStatus.setBounds(15, 220, 87, 20);
		getContentPane().add(lblStatus);
		
		JLabel lblEuaCrossed = new JLabel("A cruzado a EUA");
		lblEuaCrossed.setBounds(15, 160, 120, 20);
		getContentPane().add(lblEuaCrossed);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(179, 37, 200, 26);
		getContentPane().add(nameTextField);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(179, 97, 200, 26);
		getContentPane().add(lastNameTextField);
		
		JLabel lblDeported = new JLabel("Deportado");
		lblDeported.setBounds(15, 280, 87, 20);
		getContentPane().add(lblDeported);
		
		euaComboBox = new JComboBox(options);
		euaComboBox.setBounds(179, 157, 200, 26);
		getContentPane().add(euaComboBox);
		
		statusComboBox = new JComboBox(options);
		statusComboBox.setBounds(179, 217, 200, 26);
		getContentPane().add(statusComboBox);
		
		deportedComboBox = new JComboBox(options);
		deportedComboBox.setBounds(179, 277, 200, 26);
		getContentPane().add(deportedComboBox);
		
		JLabel lblRead = new JLabel("Sabe leer");
		lblRead.setBounds(15, 340, 87, 20);
		getContentPane().add(lblRead);
		
		JLabel lblStudy = new JLabel("Grado de estudio");
		lblStudy.setBounds(15, 400, 133, 20);
		getContentPane().add(lblStudy);
		
		JLabel lblCity = new JLabel("A emigrado");
		lblCity.setBounds(15, 460, 133, 20);
		getContentPane().add(lblCity);
		
		JLabel lblUsaDrogas = new JLabel("Usa drogas");
		lblUsaDrogas.setBounds(15, 520, 133, 20);
		getContentPane().add(lblUsaDrogas);
		
		JLabel lblEsLegalEn = new JLabel("Es legal en EUA");
		lblEsLegalEn.setBounds(15, 580, 133, 20);
		getContentPane().add(lblEsLegalEn);
		
		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setBounds(15, 640, 133, 20);
		getContentPane().add(lblOcupacion);
		
		JLabel lblSex = new JLabel("Sexo");
		lblSex.setBounds(15, 700, 133, 20);
		getContentPane().add(lblSex);
		
		btnRegister = new JButton("Registrar");
		btnRegister.setBounds(117, 787, 153, 74);
		getContentPane().add(btnRegister);
		btnRegister.addActionListener(this);
		
		readComboBox = new JComboBox(options);
		readComboBox.setBounds(179, 337, 200, 26);
		getContentPane().add(readComboBox);
		
		studyComboBox = new JComboBox(studyOptions);
		studyComboBox.setBounds(179, 397, 200, 26);
		getContentPane().add(studyComboBox);
		
		cityComboBox = new JComboBox(options);
		cityComboBox.setBounds(179, 457, 200, 26);
		getContentPane().add(cityComboBox);
		
		drugsComboBox = new JComboBox(options);
		drugsComboBox.setBounds(179, 517, 200, 26);
		getContentPane().add(drugsComboBox);
		
		legalComboBox = new JComboBox(options);
		legalComboBox.setBounds(179, 577, 200, 26);
		getContentPane().add(legalComboBox);
		
		ocupationComboBox = new JComboBox(options);
		ocupationComboBox.setBounds(179, 637, 200, 26);
		getContentPane().add(ocupationComboBox);
		
		sexComboBox = new JComboBox(new String[] {"","M", "H"});
		sexComboBox.setBounds(179, 697, 200, 26);
		getContentPane().add(sexComboBox);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegister) {
			if(nameTextField.getText() != "" && lastNameTextField.getText() != "") {
				PacientModel pacient = new PacientModel();
				pacient.name = nameTextField.getText();
				pacient.lastName = lastNameTextField.getText();
				pacient.cambiar_ciudad = (String) cityComboBox.getSelectedItem();
				pacient.edo_civil = (String) statusComboBox.getSelectedItem();
				pacient.drogas = (String) drugsComboBox.getSelectedItem();
				pacient.sexo = (String) sexComboBox.getSelectedItem();
				pacient.deportado = (String) deportedComboBox.getSelectedItem();
				pacient.eua_legal = (String) legalComboBox.getSelectedItem();
				pacient.eua_cruzado = (String) euaComboBox.getSelectedItem();
				String read = (String) readComboBox.getSelectedItem();
				if(read.equals("Si")) 
					pacient.leer = 1;
				else 
					pacient.leer = 0;
				pacient.ocupacion = (String) ocupationComboBox.getSelectedItem();
				pacient.grado_estudio = (String) studyComboBox.getSelectedItem();
				DataBaseConnection.getInstance().saveDataToDb(pacient);
			}
		}
	}
}
