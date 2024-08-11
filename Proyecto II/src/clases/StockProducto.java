package clases;

import arreglos.ArregloCompras;
import arreglos.ArregloFacturas;

public class StockProducto {

	// Attributes
	private String nombreProducto;
	private double stockInicial;
	private double ingresos;
	private double egresos;
	private double stockFinal;
	private int mesStock;
	private int anioStock;
	

	// Constructors
	public StockProducto(String nombreProducto, int mesStock, int anioStock) {
		this.nombreProducto = nombreProducto;
		this.mesStock = mesStock;
		this.anioStock = anioStock;
		
		this.stockInicial = 0.0;
		this.ingresos = 0.0;
		this.egresos = 0.0;
		this.stockFinal = 0.0;
	}
	
	public StockProducto(String nombreProducto, double stockInicial, double ingresos, double egresos, double stockFinal,
			int mesStock, int anioStock) {
		this.nombreProducto = nombreProducto;
		this.stockInicial = stockInicial;
		this.ingresos = ingresos;
		this.egresos = egresos;
		this.stockFinal = stockFinal;
		this.mesStock = mesStock;
		this.anioStock = anioStock;
	}
	
	// Methods
	public void calcularStockInicial() {
		
	}
	
	public void calcularIngresos() {
		
	}
	
	public void calcularEgresos() {
		
	}
	
	public void calcularStockFinal() {
		stockFinal = stockInicial + ingresos - egresos;
	}
	
	public double buscarIngresosDelMes(ArregloCompras compras) {
		double ingresos = 0;
		Compra compra;
		String[] fecha;
		int mesCompra, anioCompra;
		
		for (int i = 0; i < compras.tamanio(); i++) {
			compra = compras.obtener(i);
			
			fecha = compra.getFecha().split("/");
			mesCompra = (Integer.parseInt(fecha[1]) -1);
			anioCompra = Integer.parseInt(fecha[2]); 	
			
			
			if ( nombreProducto.equals(compra.getProducto()) && mesStock == mesCompra && anioStock == anioCompra ) {
				ingresos += compra.getCantidad();
			}
		}
		
		return ingresos;
	}
	
	public double buscarEgresosDelMes(ArregloFacturas facturas) {
		double egresos = 0;
		Factura fac;
		String[] fecha;
		int mesFac, anioFac;
		
		for (int i = 0; i < facturas.tamanio(); i++) {
			fac = facturas.obtener(i);
			
			fecha = fac.getFecha().split("/");
			mesFac = (Integer.parseInt(fecha[1]) -1);
			anioFac = Integer.parseInt(fecha[2]); 	
			
			
			if ( nombreProducto.equals(fac.getProducto()) && mesStock == mesFac && anioStock == anioFac ) {
				egresos += fac.getPesoSolicitado();
			}
		}
		
		return egresos;
	}
	
	
	public double buscarEgresosDelAnio(ArregloFacturas facturas) {
		double egresos = 0;
		Factura fac;
		String[] fecha;
		int anioFac;
		
		for (int i = 0; i < facturas.tamanio(); i++) {
			fac = facturas.obtener(i);
			
			fecha = fac.getFecha().split("/");
			anioFac = Integer.parseInt(fecha[2]); 	
			
			
			if ( nombreProducto.equals(fac.getProducto()) && anioStock == anioFac ) {
				egresos += fac.getPesoSolicitado();
			}
		}
		
		return egresos;
	}
	
	

	// GETTERS & SETTERS
	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getStockInicial() {
		return stockInicial;
	}

	public void setStockInicial(double stockInicial) {
		this.stockInicial = stockInicial;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	public double getEgresos() {
		return egresos;
	}

	public void setEgresos(double egresos) {
		this.egresos = egresos;
	}

	public double getStockFinal() {
		return stockFinal;
	}

	public void setStockFinal(double stockFinal) {
		this.stockFinal = stockFinal;
	}

	public int getMesStock() {
		return mesStock;
	}

	public void setMesStock(int mesStock) {
		this.mesStock = mesStock;
	}

	public int getAnioStock() {
		return anioStock;
	}

	public void setAnioStock(int anioStock) {
		this.anioStock = anioStock;
	}
	
	
	
}
