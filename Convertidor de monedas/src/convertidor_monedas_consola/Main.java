package convertidor_monedas_consola;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
        // Definir las tasas de cambio fijas
        Map<String, Double> tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("USD", 1.0);
        tasasDeCambio.put("MXN", 19.93);
        tasasDeCambio.put("JPY", 110.62);
        tasasDeCambio.put("EUR", 0.84);
        tasasDeCambio.put("GBP", 0.74);
        tasasDeCambio.put("PEN", 4.09);

        // Mostrar las monedas disponibles
        System.out.println("Monedas disponibles:");
        System.out.println("1. USD - Dólar estadounidense");
        System.out.println("2. MXN - Peso mexicano");
        System.out.println("3. JPY - Yen japonés");
        System.out.println("4. EUR - Euro");
        System.out.println("5. GBP - Libra esterlina");
        System.out.println("6. PEN - Sol peruano");

        Scanner scanner = new Scanner(System.in);

        // Obtener la moneda de origen
        System.out.print("Ingrese la moneda de origen (código): ");
        String monedaOrigen = scanner.nextLine().toUpperCase();

        // Obtener la cantidad a convertir
        System.out.print("Ingrese la cantidad: ");
        double cantidad = scanner.nextDouble();

        // Obtener la moneda de destino
        System.out.print("Ingrese la moneda de destino (código): ");
        String monedaDestino = scanner.next().toUpperCase();

        // Realizar la conversión
        double tasaOrigen = tasasDeCambio.getOrDefault(monedaOrigen, 1.0);
        double tasaDestino = tasasDeCambio.getOrDefault(monedaDestino, 1.0);
        double resultado = (cantidad / tasaOrigen) * tasaDestino;

        // Mostrar el resultado
        System.out.println("Resultado de la conversión:");
        System.out.println(cantidad + " " + monedaOrigen + " equivale a " + resultado + " " + monedaDestino);
    }
}

