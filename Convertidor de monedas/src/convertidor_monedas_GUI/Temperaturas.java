package convertidor_monedas_GUI;

public class Temperaturas {
	private String temp1,temp2;
	private double cantidadTemp, resultado;
	
	public Temperaturas(String _temp1, String _temp2, double _cantidadTemp) {
		temp1 = _temp1;
		temp2 = _temp2;
		cantidadTemp = _cantidadTemp;
	}
	
	public double convertir() {
		switch(temp1) {
		case "Celcius":
			if(temp2.equals("Fahrenheit")) {
				resultado = (cantidadTemp - 32)/1.8;
			}
		case "Fahrenheit":
			if(temp2.equals("Celcius")) {
				resultado = (cantidadTemp * 1.8)+32;
			}
		}
		return resultado;
	}
}
