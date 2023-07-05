package convertidor_monedas_GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Divisas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_divisa,txt_cantidadTemperatura;
	private double valor, resultado, resultadoTemperatura,cantidadTemperatura;
	private String divisa1,divisa2,
				   temperatura1,temperatura2;
	private JComboBox<String> cmb_divisa1,
			cmb_divisa2,
			cmb_Temp1,
			cmb_Temp2;
	private JLabel lbl_cantidadOrigen,
			lbl_monedaOrigen,
			lbl_cantidadDestino,
			lbl_paisDestino,
			lbl_Importe,
			lbl_titleTemperatura,
			lbl_titleDivisas,
			lbl_De,lbl_a,
			lbl_De_2,lbl_a_2,lbl_cantidadTemperatura,
			lbl_unidad1,lbl_cantidad1,
			lbl_unidad2,lbl_cantidad2,lbl_esIgualA;
	private JButton btn_convertir,
			btn_convertirTemperatura;
	private JLabel lbl_esIgualDivisas;
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Divisas frame = new Divisas();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*Creacion del frame*/
	public Divisas() {
		setResizable(false);
		setTitle("Convertidor de monedas");
		
		String[] paises = {"Selecciona una moneda","Dolar", "Euro","Yen","Peso MXN","Peso ARS","Libra Esterlina"}; 
		String [] temperaturas = {"Selecciona unidad", "Celcius", "Fahrenheit"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 430);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*----------------Labels----------------------*/
		lbl_Importe = new JLabel("Importe");
		lbl_Importe.setBounds(423, 57, 46, 14);
		contentPane.add(lbl_Importe);
		
		lbl_De = new JLabel("De:");
		lbl_De.setBounds(10, 57, 46, 14);
		contentPane.add(lbl_De);
		
		lbl_a = new JLabel("a");
		lbl_a.setBounds(213, 57, 46, 14);
		contentPane.add(lbl_a);
		
		lbl_cantidadOrigen = new JLabel("");
		lbl_cantidadOrigen.setBounds(10, 111, 46, 14);
		contentPane.add(lbl_cantidadOrigen);
		
		lbl_monedaOrigen = new JLabel("");
		lbl_monedaOrigen.setBounds(66, 111, 115, 14);
		contentPane.add(lbl_monedaOrigen);
		
		lbl_cantidadDestino = new JLabel("");
		lbl_cantidadDestino.setBounds(10, 160, 46, 14);
		contentPane.add(lbl_cantidadDestino);
		
		lbl_paisDestino = new JLabel("");
		lbl_paisDestino.setBounds(76, 160, 105, 14);
		contentPane.add(lbl_paisDestino);
		
		lbl_esIgualDivisas = new JLabel("");
		lbl_esIgualDivisas.setBounds(10, 136, 75, 14);
		contentPane.add(lbl_esIgualDivisas);
		
		
		/*----------------txt_divisa----------------------*/
		txt_divisa = new JTextField();
		txt_divisa.setBounds(421, 79, 89, 20);
		txt_divisa.setText("0");
		contentPane.add(txt_divisa);
		txt_divisa.setColumns(10);
		
		
		/*----------------ComboBox 1----------------------*/
		cmb_divisa1 = new JComboBox<String>(paises);
		cmb_divisa1.setBackground(Color.WHITE);
		cmb_divisa1.setBounds(10, 78, 178, 22);
		contentPane.add(cmb_divisa1);
		
		
		/*----------------ComboBox 2----------------------*/
		cmb_divisa2 = new JComboBox<String>(paises);	
		cmb_divisa2.setBackground(Color.WHITE);
		cmb_divisa2.setBounds(213, 78, 178, 22);
		contentPane.add(cmb_divisa2);
		
		
		/*----------------Button/convertir----------------------*/
		btn_convertir = new JButton("Convertir");
		btn_convertir.setForeground(Color.WHITE);
		btn_convertir.setBackground(new Color(0, 128, 255));
		btn_convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(Double.parseDouble(txt_divisa.getText())<0.0) {
					JOptionPane.showMessageDialog(btn_convertir, "Debes ingresar una cantidad positiva o mayor a 0");
				}else if(cmb_divisa1.getSelectedItem().toString().equals(paises[0]) 
				&& cmb_divisa2.getSelectedItem().toString().equals(paises[0])) {
					JOptionPane.showMessageDialog(btn_convertir, "Debes seleccionar una moneda de origen y de destino");
					return;
				}else if(cmb_divisa1.getSelectedItem().toString().equals(cmb_divisa2.getSelectedItem().toString()) 
						|| cmb_divisa2.getSelectedItem().toString().equals(cmb_divisa1.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(btn_convertir, "Las monedas deben ser diferentes");
					return;
				}	
				divisa1 = cmb_divisa1.getSelectedItem().toString();
				divisa2 = cmb_divisa2.getSelectedItem().toString();
				valor = Double.parseDouble(txt_divisa.getText());
				Operaciones puente = new Operaciones(valor,divisa1,divisa2);
				//convertimos la moneda
				resultado = puente.convertir();
				
				lbl_cantidadOrigen.setText(String.format("%.3f",valor));
				lbl_monedaOrigen.setText(divisa1);
				lbl_cantidadDestino.setText(String.format("%.3f",resultado));
				lbl_paisDestino.setText(divisa2);
				lbl_esIgualDivisas.setText("Es igual a: ");
			}
		});
		btn_convertir.setBounds(423, 111, 89, 23);
		contentPane.add(btn_convertir);
		
		lbl_titleTemperatura = new JLabel("Convertidor de temperatura");
		lbl_titleTemperatura.setBounds(10, 185, 163, 20);
		contentPane.add(lbl_titleTemperatura);
		
		lbl_titleDivisas = new JLabel("Convertidor de monedas");
		lbl_titleDivisas.setBounds(10, 21, 143, 14);
		contentPane.add(lbl_titleDivisas);
		txt_divisa.addMouseListener(new Manejador());
		
		
		/*-------------------------Convertidor de Temperatura---------------------------*/
		
		
		/*------------------Combo Box1------------------------------------*/
		cmb_Temp1 = new JComboBox<String>(temperaturas);
		cmb_Temp1.setBackground(Color.WHITE);
		cmb_Temp1.setBounds(10, 244, 136, 22);
		contentPane.add(cmb_Temp1);
		/*------------------Combo Box2------------------------------------*/
		cmb_Temp2 = new JComboBox<String>(temperaturas);
		cmb_Temp2.setBackground(Color.WHITE);
		cmb_Temp2.setBounds(166, 244, 136, 22);
		contentPane.add(cmb_Temp2);
		/*------------------Labels textos------------------------------------*/
		lbl_De_2 = new JLabel("De:");
		lbl_De_2.setBounds(10, 216, 46, 14);
		contentPane.add(lbl_De_2);
		
		lbl_a_2 = new JLabel("a");
		lbl_a_2.setBounds(166, 216, 46, 14);
		contentPane.add(lbl_a_2);
		
		lbl_cantidadTemperatura = new JLabel("Cantidad");
		lbl_cantidadTemperatura.setBounds(323, 216, 55, 14);
		contentPane.add(lbl_cantidadTemperatura);
		
		/*--------------------txtCantidadTEmperatura-------------------------------*/
		txt_cantidadTemperatura = new JTextField();
		txt_cantidadTemperatura.setBounds(323, 245, 89, 20);
		contentPane.add(txt_cantidadTemperatura);
		txt_cantidadTemperatura.setColumns(10);
		
		
		
		
		btn_convertirTemperatura = new JButton("Convertir");
		btn_convertirTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmb_Temp1.getSelectedItem().toString().equals(temperaturas[0])&&
				   cmb_Temp2.getSelectedItem().toString().equals(temperaturas[0])) {
					JOptionPane.showMessageDialog(rootPane, "Debes seleccionar las unidades");
					return;
				}
				else if(cmb_Temp1.getSelectedItem().toString().equals(cmb_Temp2.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(rootPane, "Debes seleccionar unidades diferentes");
					return;	
				}
				else if(txt_cantidadTemperatura.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Debes ingresar una cantidad a convertir");
					return;
				}
				
				temperatura1 = cmb_Temp1.getSelectedItem().toString();
				temperatura2 = cmb_Temp2.getSelectedItem().toString();
				cantidadTemperatura = Double.parseDouble(txt_cantidadTemperatura.getText());
				Temperaturas puente2 = new Temperaturas(temperatura1,temperatura2,cantidadTemperatura);
				resultadoTemperatura = puente2.convertir();
				lbl_unidad2.setText(temperatura1);
				lbl_unidad1.setText(temperatura2);
				lbl_cantidad1.setText(String.format("%.2f", cantidadTemperatura));
				lbl_cantidad2.setText(String.format("%.2f", resultadoTemperatura));
				lbl_esIgualA.setText("Es igual a: ");
			}
		});
		btn_convertirTemperatura.setForeground(Color.WHITE);
		btn_convertirTemperatura.setBackground(new Color(0, 128, 255));
		btn_convertirTemperatura.setBounds(323, 276, 89, 23);
		contentPane.add(btn_convertirTemperatura);
		
		
		/*------------------Resultados temperatura------------------*/
		lbl_unidad1 = new JLabel("");
		lbl_unidad1.setBounds(137, 295, 75, 14);
		contentPane.add(lbl_unidad1);
		
		lbl_cantidad1 = new JLabel("");
		lbl_cantidad1.setBounds(22, 295, 75, 14);
		contentPane.add(lbl_cantidad1);
		
		lbl_unidad2 = new JLabel("");
		lbl_unidad2.setBounds(137, 345, 75, 14);
		contentPane.add(lbl_unidad2);
		
		lbl_cantidad2 = new JLabel("");
		lbl_cantidad2.setBounds(22, 345, 75, 14);
		contentPane.add(lbl_cantidad2);
		
		lbl_esIgualA = new JLabel("");
		lbl_esIgualA.setBounds(20, 320, 77, 14);
		contentPane.add(lbl_esIgualA);
		
		
		
		
		
	}
	
	class Manejador extends MouseAdapter {		
		public void mouseClicked(MouseEvent e) {
			txt_divisa.setText("");			
		}
		
	}
}
