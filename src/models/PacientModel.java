package models;

public class PacientModel {
	public int id;
	public String name;
	public String lastName;
	public String eua_cruzado;
	public String deportado;
	public String cambiar_ciudad; 
	public String drogas; 
	public String eua_legal;
	public String edo_civil;
	public String sexo;
	public int leer;
	public String ocupacion;
	public String grado_estudio;
	private String[] data = new String[7];


	public String[] getPacientDataArray() {
		data[0] = name;
		data[1] = lastName;
//		data[2] = eua_cruzado;
//		data[3] = deportado;
//		data[4] = cambiar_ciudad;
//		data[5] = eua_legal;
//		data[6] = drogas;
		return data;
	}

}
