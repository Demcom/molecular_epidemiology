package views;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.ws.soap.AddressingFeature.Responses;

import db_connection.DataBaseConnection;
import models.PacientModel;

public class ReportWindow extends ParentWindow {
	JLabel lblEua, lblCity, lblDeported, lblDrugs, lblLegal;

	public ReportWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1024, 0, 500, 400);
		setTopBarMenuVisible(false);
		
		JLabel lblNewLabel = new JLabel("Cruzado a EUA");
		lblNewLabel.setBounds(20, 16, 107, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Deportado");
		lblNewLabel_1.setBounds(370, 16, 74, 20);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cambiar de ciudad");
		lblNewLabel_2.setBounds(20, 140, 140, 20);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Legal en EUA");
		lblNewLabel_3.setBounds(370, 140, 95, 20);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Usa drogas");
		lblNewLabel_4.setBounds(200, 252, 79, 20);
		getContentPane().add(lblNewLabel_4);
		
		lblEua = new JLabel("");
		lblEua.setBounds(58, 52, 43, 20);
		getContentPane().add(lblEua);
		
		lblDeported = new JLabel("");
		lblDeported.setBounds(380, 52, 43, 20);
		getContentPane().add(lblDeported);
		
		lblCity = new JLabel("");
		lblCity.setBounds(58, 176, 43, 20);
		getContentPane().add(lblCity);
		
		lblLegal = new JLabel("");
		lblLegal.setBounds(380, 176, 43, 20);
		getContentPane().add(lblLegal);
		
		lblDrugs = new JLabel("");
		lblDrugs.setBounds(221, 288, 43, 20);
		getContentPane().add(lblDrugs);
		loadData();
			
	}
	
	public boolean isTrue(String data) {
		if(data.equals("Si")) 
			return true;
		else
			return false;
	}
	
	public void loadData() {
		ArrayList<PacientModel> pacientModels = DataBaseConnection.getInstance().getPacients();
		int eua = 0;
		int city = 0;
		int deported = 0;
		int legal = 0;
		int drugs = 0;
		
		for (PacientModel pacientModel : pacientModels) {
			if (isTrue(pacientModel.eua_cruzado)) {
				eua += 1;
			}
			if (isTrue(pacientModel.cambiar_ciudad)) {
				city += 1;
			}
			if (isTrue(pacientModel.deportado)) {
				deported += 1;
			}
			if (isTrue(pacientModel.eua_legal)) {
				legal += 1;
			}
			if (isTrue(pacientModel.drogas)) {
				drugs += 1;
			}
			
		}
		int totalResponses = pacientModels.size(); 
		eua = (eua*100) / totalResponses;
		city = (city*100) / totalResponses;
		deported = (deported*100) / totalResponses;
		legal = (legal*100) / totalResponses;
		drugs = (drugs*100) / totalResponses;
		
		lblEua.setText(String.valueOf(eua));
		lblCity.setText(String.valueOf(city));
		lblDeported.setText(String.valueOf(deported));
		lblDrugs.setText(String.valueOf(drugs));
		lblLegal.setText(String.valueOf(legal));
	}

}
