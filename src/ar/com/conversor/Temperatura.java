package ar.com.conversor;

class Temperatura {
private String nombre;
private double valor;
public Temperatura(String nombre,double valor) {
	this.nombre = nombre;
	this.valor = valor;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}

public double convertirCelciusaKelvin() {
	return this.valor + 273.15;
}
public double convertirCelsiusaFahrenheit() {
	return (this.valor * 1.8) + 32;
}

public double convertirFahrenheitaCelsius() {
	return (this.valor -32) / 1.8;
}
public double convertirFahrenheitaKelvin() {
	return ((this.valor -32) * 5/9)+273.15;
}
public double convertirKelvinaCelsius() {
	return this.valor -273.15;
}
public double convertirKelvinaFahrenheit() {
	return (((this.valor -273.15)* 1.8)+32);
}
}
