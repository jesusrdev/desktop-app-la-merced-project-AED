package clases;

public class MejorProducto {

	// Attributes
	private int orden;
	private String nombreProducto;
	private double cantidad;
	
	// Constructor
	public MejorProducto(int orden, String nombreProducto, double cantidad) {
		super();
		this.orden = orden;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
	}
	
	
	// GETTERS & SETTERS
	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
