package convertidor_monedas_GUI;

public class Operaciones {

	private double valor, resultado;
	private String divisa1;
	private String divisa2;
	//Constructor
	public Operaciones(double _valor, String _divisa1, String _divisa2) {
		valor = _valor;
		divisa1 = _divisa1;
		divisa2 = _divisa2;	
	}
	
	
	public double convertir() {
		// De Dolares a Euros
		switch(divisa1) {
			//Caso que primera divisa sea dolar
			case "Dolar":
				switch(divisa2) {
					case "Euro":
						resultado = valor * 0.91;
						break;
					case "Yen":
						resultado = valor * 144.51;
						break;
					case "Peso MXN":
						resultado = valor * 17.02;
						break;
					case "Peso ARS":
						resultado = valor * 259.00;
						break;
					case "Libra Esterlina":
						resultado = valor * 0.78;
				}
				break;
			//Caso que segunda divisa sea Euro
			case "Euro":
				switch(divisa2) {
					case "Dolar":
						resultado = valor * 1.08;
						break;
					case "Yen":
						resultado = valor * 157.44;
						break;
					case "Peso MXN":
						resultado = valor * 18.56;
						break;
					case "Peso ARS":
						resultado = valor * 282.21;
						break;
					case "Libra Esterlina":
						resultado = valor * 0.85;
						break;
				}
				break;
			//	caso que tercera divisa sea yen
			case "Yen":
				switch(divisa2) {
					case "Dolar":
						resultado = valor * 0.0069206;
						break;
					case "Euro":
						resultado = valor * 0.0063511;
						break;
					case "Peso MXN":
						resultado = valor * 0.1178998;
						break;
					case "Peso ARS":
						resultado = valor * 1.792312;
						break;
					case "Libra Esterlina":
						resultado = valor * 0.00543970;
						break;
					}
					break;
			//caso que cuarta divisa sea Peso mexicano		
			case "Peso MXN":
				switch(divisa2) {
					case "Dolar":
						resultado = valor * 0.05869669;
						break;
					case "Euro":
						resultado = valor * 0.053868549;
						break;
					case "Yen":
						resultado = valor * 8.4818273;
						break;
					case "Peso ARS":
						resultado = valor * 15.200109;
						break;
					case "Libra Esterlina":
						resultado = valor * 0.046135785;
						break;
				}
				break;
			//Caso que quinta divisa sea peso argentino	
			case "Peso ARS":
				switch(divisa2) {
					case "Dolar":
						resultado = valor * 0.0038605232;
						break;
					case "Euro":
						resultado = valor * 0.0035431308;
						break;
					case "Yen":
						resultado = valor * 0.5579169;
						break;
					case "Peso MXN":
						resultado = valor * 0.065789464;
						break;
					case "Libra Esterlina":
						resultado = valor * 0.0030334964;
						break;
				}
				break;
				//caso que la primera divisa sea Libra esterlina
			case "Libra Esterlina":
				switch(divisa2) {
					case "Dolar":
						resultado = valor * 1.2724315;
						break;
					case "Euro":
						resultado = valor * 1.167742;
						break;
					case "Yen":
						resultado = valor * 183.86244;
						break;
					case "Peso MXN":
						resultado = valor * 21.691726;
						break;
					case "Peso ARS":
						resultado = valor * 329.61273;
						break;
				}
				break;
		}
		//retorna la conversion
		return resultado;
		
	}
	
}
