package ar.com.conversor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.*;

public class MainGUI {
public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}

class MainWindow extends JFrame {
	public MainWindow() {
		
		Toolkit myScreen = Toolkit.getDefaultToolkit();
		Dimension myScreenSize = myScreen.getScreenSize();
		int screenHeight = myScreenSize.height;
		int screenWidth = myScreenSize.width;
		setSize(screenWidth / 2,screenHeight/2);
		setLocation(screenWidth/4, screenHeight/4);
		
		setTitle("Conversores");
		

		MainLayer mainwindow = new MainLayer();
		add(mainwindow);
		setVisible(true);
		setBackground(new Color(255, 238, 88));
	}

}

class MainLayer extends JPanel {
	public MainLayer() {
		//setLayout(new );
		JPanel titleLayer = new JPanel();
		titleLayer.setOpaque(false);
		titleLayer.setLayout(new GridLayout(2, 1,5,10));
		JLabel titulo = new JLabel("Seleccione un Conversor", SwingConstants.CENTER);
		titulo.setFont(new Font("Serif", Font.BOLD, 24));
		titleLayer.add(titulo);
		JPanel optionsLayer = new JPanel();
		optionsLayer.setOpaque(false);
		options = new JComboBox();
		options.addItem("Conversor de divisas");
		options.addItem("Conversor de temperaturas");
		OptionsEvent event = new OptionsEvent();
		options.addActionListener(event);
		optionsLayer.add(options);
		titleLayer.add(optionsLayer);
		add(titleLayer);
		CurrencyLayer = new JPanel();
		CurrencyLayer.setVisible(false);
		CurrencyLayer.setOpaque(false);
		CurrencyLayer.add(new CurrencyLayer());
		
		add(CurrencyLayer);
	
		TemperaturaLayer = new JPanel();
		TemperaturaLayer.setVisible(false);
		TemperaturaLayer.setOpaque(false);
		TemperaturaLayer.add(new TemperaturaLayer());
		add(TemperaturaLayer);
		setBackground(new Color(255, 238, 88));
	}

	private class OptionsEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (options.getSelectedItem() == "Conversor de divisas") {
				
				TemperaturaLayer.setVisible(false);
				CurrencyLayer.setVisible(true);
			}
			if (options.getSelectedItem() == "Conversor de temperaturas") {
				
				CurrencyLayer.setVisible(false);
				TemperaturaLayer.setVisible(true);
			}

		}

	}

	private JComboBox options;
	private JPanel CurrencyLayer,TemperaturaLayer;

}

class CurrencyLayer extends JPanel {
	public CurrencyLayer() {
		setLayout(new GridLayout(6,2,5,10));
		setOpaque(false);
		JLabel monto = new JLabel("Ingrese monto a convertir:");
		JLabel fromDivisa = new JLabel("From");
		JLabel toDivisa = new JLabel("To");
		montoEntrada = new JTextField(2);
		MontoEvent ingresoMonto = new MontoEvent();
		montoDoc = montoEntrada.getDocument();
		montoDoc.addDocumentListener(ingresoMonto);
		montoEntrada.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && ((c != KeyEvent.VK_PERIOD)&&(c != KeyEvent.VK_BACK_SPACE))) {
		            e.consume();  // if it's not a number, ignore the event
		            montoEntrada.setBackground(Color.RED);
		        }else {
		        	montoEntrada.setBackground(Color.WHITE);
		        }
		     }
		});
		
		add(monto);
		add(montoEntrada);
		divisas1 = new JComboBox();

		divisas1.addItem("Dolar");
		divisas1.addItem("Euro");
		divisas1.addItem("Libras Esterlinas");
		divisas1.addItem("Yen Japones");
		divisas1.addItem("Won sul-coreano");
		divisas1.addItem("Peso Argentino");
		divisas1.addItem("Peso Mexicano");
		divisas1.addItem("Peso Chileno");
		divisas1.addItem("Peso Colombiano");
		divisas1.addItem("Reales");
		add(fromDivisa);
		
		comboEvent eventoDivisas1 = new comboEvent();
		divisas1.addActionListener(eventoDivisas1);
		
		add(divisas1);
	
		add(toDivisa);
		divisas2 = new JComboBox();
	
		divisas2.addItem("Dolar");
		divisas2.addItem("Euro");
		divisas2.addItem("Libras Esterlinas");
		divisas2.addItem("Yen Japones");
		divisas2.addItem("Won sul-coreano");
		divisas2.addItem("Peso Argentino");
		divisas2.addItem("Peso Mexicano");
		divisas2.addItem("Peso Chileno");
		divisas2.addItem("Peso Colombiano");
		divisas2.addItem("Reales");
		
		comboEvent eventoDivisas2 = new comboEvent();
		divisas2.addActionListener(eventoDivisas2);
		
		add(divisas2);
		
		resultado = new JLabel("");
		resultado.setFont(new Font("Serif", Font.BOLD, 16));
		add(resultado);
		divisas1.setSelectedIndex(0);
		divisas2.setSelectedIndex(0);
	}
	
	
	
	private class MontoEvent implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		
			montoIngresado =Double.parseDouble(montoEntrada.getText());
			resultado.setText(" " + montoIngresado +" "+ divisa1 + " son " + String.format("%.4f", (convertir(montoIngresado, divisa1, divisa2))) +" " + divisa2);
	
			
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			try {
				montoIngresado =Double.parseDouble(montoEntrada.getText());
				resultado.setText(" " + montoIngresado +" "+ divisa1 + " son " + String.format("%.4f", (convertir(montoIngresado, divisa1, divisa2))) +" " + divisa2);
			} catch (Exception e2) {
				e2.getStackTrace();
			}
			
		}
		
	}
	
	private class comboEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			divisa1 = (String) divisas1.getSelectedItem();
			divisa2 = (String) divisas2.getSelectedItem();
			resultado.setText(" " + montoIngresado +" "+ divisa1 + " son " + String.format("%.4f", (convertir(montoIngresado, divisa1, divisa2))) +" " + divisa2);
		
		}
		
	}
	
	
	private double convertir(double monto,String moneda1,String moneda2) {
		if(moneda1=="Dolar") {
			return (Dolar.cotizar(moneda2))*monto;
		}
		if(moneda1=="Euro") {
			return (Euro.cotizar(moneda2))*monto;
		}
		if(moneda1=="Peso Argentino") {
			return (PesoArgentino.cotizar(moneda2))*monto;
		}
		if(moneda1=="Libras Esterlinas") {
			return (Libras.cotizar(moneda2))*monto;
		}
		if(moneda1=="Yen Japones") {
			return (Yen.cotizar(moneda2))*monto;
		}
		if(moneda1=="Won sul-coreano") {
			return (Won.cotizar(moneda2))*monto;
		}
		if(moneda1=="Peso Mexicano") {
			return (PesoMexicano.cotizar(moneda2))*monto;
		}
		if(moneda1=="Peso Chileno") {
			return (PesoChileno.cotizar(moneda2))*monto;
		}
		if(moneda1=="Peso Colombiano") {
			return (PesoColombiano.cotizar(moneda2))*monto;
		}
		if(moneda1=="Reales") {
			return (Reales.cotizar(moneda2))*monto;
		}
		
		return (Dolar.cotizar(moneda2))*monto;
	}
	
	
	
	Divisa Dolar = new Divisa("Dolar", 1, 0.96, 0.83, 135, 1289.29, 122.52, 20.65, 867.60, 3969.36, 5.14);
	Divisa Euro = new Divisa("Euro", 1.04, 1, 0.87, 140.64, 1343.44, 127.57, 21.49, 903.48, 4133.29, 5.35);
	Divisa Libras = new Divisa("Libras Esterlinas", 1.20, 1.15, 1, 161.82, 1544.73, 146.68, 24.71, 1039.18, 4751.88, 6.16);
	Divisa Yen = new Divisa("Yen Japones", 0.0074, 0.0071, 0.0062, 1, 9.54, 0.91, 0.15, 6.41, 29.34, 0.038);
	Divisa Won = new Divisa("Won sul-coreano", 0.00077, 0.00074, 0.00065, 0.10, 1, 0.095, 0.016, 0.67, 3.08, 0.0040);
	Divisa PesoArgentino= new Divisa("Peso Argentino", 0.0082, 0.0078, 0.0068, 1.10, 10.54, 1, 0.17, 7.08, 32.40, 0.042);
	Divisa PesoMexicano = new Divisa("Peso Mexicano", 0.048, 0.047, 0.041, 6.56, 62.58, 5.94, 1, 42.02, 192.31, 0.25);
	Divisa PesoChileno = new Divisa("Peso Chileno", 0.0012, 0.0011, 0.00096, 0.16, 1.49, 0.14, 0.024, 1, 4.58, 0.0059);
	Divisa PesoColombiano = new Divisa("Peso Colombiano", 0.00025, 0.00024, 0.00021, 0.034, 0.32, 0.031, 0.0052, 0.22, 1, 0.0013);
	Divisa Reales = new Divisa("Reales", 0.19, 0.19, 0.16, 26.32, 250.90, 23.82, 4.01, 168.57, 771.38, 1);
	
	public JTextField montoEntrada;
	private Document montoDoc;
	public double montoIngresado;
	private JLabel resultado;
	private JComboBox divisas1,divisas2;
	private String divisa1,divisa2;
}

class TemperaturaLayer extends JPanel {
	public TemperaturaLayer() {
		setLayout(new GridLayout(6,2,5,10));
		setOpaque(false);
		JLabel valor = new JLabel("Ingrese valor a convertir:");
		JLabel fromTemp = new JLabel("From");
		JLabel toTemp = new JLabel("To");
		valorEntrada = new JTextField(2);
		ValorEvent ingresoValor = new ValorEvent();
		valorDoc = valorEntrada.getDocument();
		valorDoc.addDocumentListener(ingresoValor);
		valorEntrada.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if ( ((c < '0') || (c > '9')) && ((c != KeyEvent.VK_PERIOD)&&(c != KeyEvent.VK_BACK_SPACE))) {
		            e.consume();  // if it's not a number, ignore the event
		            valorEntrada.setBackground(Color.RED);
		        }else {
		        	valorEntrada.setBackground(Color.WHITE);
		        }
		     }
		});
		
		add(valor);
		add(valorEntrada);
		temperaturas1 = new JComboBox();
		temperaturas1.addItem("Celsius");
		temperaturas1.addItem("Fahrenheit");
		temperaturas1.addItem("Kelvin");
		
		add(fromTemp);
		
		comboTempEvent eventoTemp1 = new comboTempEvent();
		temperaturas1.addActionListener(eventoTemp1);
		
		add(temperaturas1);
	
		add(toTemp);
		temperaturas2 = new JComboBox();
		temperaturas2.addItem("Celsius");
		temperaturas2.addItem("Fahrenheit");
		temperaturas2.addItem("Kelvin");
		
		comboTempEvent eventoTemp2 = new comboTempEvent();
		temperaturas2.addActionListener(eventoTemp2);
		
		add(temperaturas2);
		
		resultadoTemp = new JLabel("");
		resultadoTemp.setFont(new Font("Serif", Font.BOLD, 18));
		add(resultadoTemp);
		temperaturas1.setSelectedIndex(0);
		temperaturas2.setSelectedIndex(0);
	}
	
	
	
	private class ValorEvent implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			
		
			valorIngresado =Double.parseDouble(valorEntrada.getText());
			   resultadoTemp.setText(" " + valorIngresado +" º "+ temperatura1 + " son " + String.format("%.2f", (convertirTemp(valorIngresado, temperatura1, temperatura2))) +" º " + temperatura2);
	
			
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			try {
				valorIngresado =Double.parseDouble(valorEntrada.getText());
				   resultadoTemp.setText(" " + valorIngresado +" º "+ temperatura1 + " son " + String.format("%.2f", (convertirTemp(valorIngresado, temperatura1, temperatura2))) +" º " + temperatura2);
		} catch (Exception e2) {
			e2.getStackTrace();
		}
			
		}
		
	}
	
	private class comboTempEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		
			temperatura1 = (String) temperaturas1.getSelectedItem();
	        temperatura2 = (String) temperaturas2.getSelectedItem();
		   resultadoTemp.setText(" " + valorIngresado +" "+ temperatura1 + " son " + String.format("%.2f", (convertirTemp(valorIngresado, temperatura1, temperatura2))) +" " + temperatura2);
		
		}
		
	}
	
	private double convertirTemp(double valor,String temp1,String temp2) {
		if(temp1=="Celsius" && temp2=="Fahrenheit") {
			Temperatura temperatura = new Temperatura("CaF", valor);
			return temperatura.convertirCelsiusaFahrenheit();
		}
		if(temp1=="Celsius" && temp2=="Kelvin") {
			Temperatura temperatura = new Temperatura("CaF", valor);
			return temperatura.convertirCelciusaKelvin();
		}
		if(temp1=="Fahrenheit" && temp2=="Celsius") {
			Temperatura temperatura = new Temperatura("CaF", valor);
			return temperatura.convertirFahrenheitaCelsius();
		}
		if(temp1=="Fahrenheit" && temp2=="Kelvin") {
			Temperatura temperatura = new Temperatura("CaF", valor);
			return temperatura.convertirFahrenheitaKelvin();
		}
		if(temp1=="Kelvin" && temp2=="Celsius") {
			Temperatura temperatura = new Temperatura("CaF", valor);
			return temperatura.convertirKelvinaCelsius();
		}
		if(temp1=="Kelvin" && temp2=="Fahrenheit") {
			Temperatura temperatura = new Temperatura("CaF", valor);
			return temperatura.convertirKelvinaFahrenheit();
		}
		
		return valor;

	}
	
	
	public JTextField valorEntrada;
	private Document valorDoc;
	public double valorIngresado;
	private JLabel resultadoTemp;
	private JComboBox temperaturas1,temperaturas2;
	private String temperatura1,temperatura2;
}
	
