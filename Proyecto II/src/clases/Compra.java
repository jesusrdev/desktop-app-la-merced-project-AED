package clases;

public class Compra {

	// Atributos
	private String factura;
	private String nombreProveedor;
	private String ruc;
	private String fecha;
	private String producto;
	private double precio;
	private double cantidad;
	private double importeTotal;
	
	// Constructores
	public Compra(String factura, String nombreProveedor,
			String ruc, String fecha, String producto,
			double precio, double cantidad, double importeTotal) {
//		super();
		this.factura = factura;
		this.nombreProveedor = nombreProveedor;
		this.ruc = ruc;
		this.fecha = fecha;
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.importeTotal = importeTotal;
	}
	
	// Metodos Setters and Getters
	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}
	
	
}
