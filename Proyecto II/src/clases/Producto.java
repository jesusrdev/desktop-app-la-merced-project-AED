package clases;

public class Producto {
	private int codigo;
	private String nombre;
	private double precio;
	private String tipo;
	private String clasificacion;

	 
	public Producto(int codigo, String nombre, double precio, String tipo, String clasificacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.tipo = tipo;
		this.clasificacion = clasificacion;
	
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getClasificacion() {
		return clasificacion;
	}


	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
	


}
