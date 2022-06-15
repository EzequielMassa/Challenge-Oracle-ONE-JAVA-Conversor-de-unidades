package ar.com.conversor;

class Divisa {
	private String nombre;
	private double cotizacionDolar;
	private double cotizacionEuro;
	private double cotizacionLibras;
	private double cotizacionYen;
	private double cotizacionWon;
	private double cotizacionPesoArgentino;
	
	private double cotizacionPesoMexicano;
	private double cotizacionPesoChileno;
	private double cotizacionPesoColombiano;
	private double cotizacionReales;
	
	

	public Divisa(String nombre, double cotizacionDolar, double cotizacionEuro, double cotizacionLibras,
			double cotizacionYen, double cotizacionWon, double cotizacionPesoArgentino,double cotizacionPesoMexicano,double cotizacionPesoChileno,double cotizacionPesoColombiano,double cotizacionReales) {
		this.nombre = nombre;
		this.cotizacionDolar = cotizacionDolar;
		this.cotizacionEuro = cotizacionEuro;
		this.cotizacionLibras = cotizacionLibras;
		this.cotizacionYen = cotizacionYen;
		this.cotizacionWon = cotizacionWon;
		this.cotizacionPesoArgentino = cotizacionPesoArgentino;
		this.cotizacionPesoMexicano = cotizacionPesoMexicano;
		this.cotizacionPesoChileno = cotizacionPesoChileno;
		this.cotizacionPesoColombiano=cotizacionPesoColombiano;
		this.cotizacionReales = cotizacionReales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCotizacionDolar() {
		return cotizacionDolar;
	}

	public void setCotizacionDolar(double cotizacionDolar) {
		this.cotizacionDolar = cotizacionDolar;
	}

	public double getCotizacionEuro() {
		return cotizacionEuro;
	}

	public void setCotizacionEuro(double cotizacionEuro) {
		this.cotizacionEuro = cotizacionEuro;
	}

	public double getCotizacionLibras() {
		return cotizacionLibras;
	}

	public void setCotizacionLibras(double cotizacionLibras) {
		this.cotizacionLibras = cotizacionLibras;
	}

	public double getCotizacionYen() {
		return cotizacionYen;
	}

	public void setCotizacionYen(double cotizacionYen) {
		this.cotizacionYen = cotizacionYen;
	}

	public double getCotizacionWon() {
		return cotizacionWon;
	}

	public void setCotizacionWon(double cotizacionWon) {
		this.cotizacionWon = cotizacionWon;
	}

	public double getCotizacionPesoArgentino() {
		return cotizacionPesoArgentino;
	}

	public void setCotizacionPesoArgentino(double cotizacionPesoArgentino) {
		this.cotizacionPesoArgentino = cotizacionPesoArgentino;
	}

	
	public double cotizar(String moneda2) {
		if(moneda2=="Dolar") {
			return this.cotizacionDolar;
		}
		if (moneda2=="Euro") {
			return this.cotizacionEuro;
		}
		if(moneda2=="Peso Argentino") {
			return this.cotizacionPesoArgentino;
		}
		if(moneda2=="Libras Esterlinas") {
			return this.cotizacionLibras;
		}
		if(moneda2=="Yen Japones") {
			return this.cotizacionYen;
		}
		if(moneda2=="Won sul-coreano") {
			return this.cotizacionWon;
		}
		if(moneda2=="Peso Mexicano") {
			return this.cotizacionPesoMexicano;
		}
		if(moneda2=="Peso Chileno") {
			return this.cotizacionPesoChileno;
		}
		if(moneda2=="Peso Colombiano") {
			return this.cotizacionPesoColombiano;
		}
		if(moneda2=="Reales") {
			return this.cotizacionReales;
		}
		
        return cotizacionDolar;
	}
	
	
}
