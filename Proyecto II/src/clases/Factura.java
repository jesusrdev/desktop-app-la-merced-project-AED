package clases;

public class Factura  {
	private String factura; 
	private String fecha, cliente, ruc, producto;
	private double  precio, pesoSolicitado, total;

	
	public Factura(String factura, String fecha, String cliente, String ruc, String producto, double precio,
			double pesoSolicitado, double total) {
			this.factura = factura;
			this.producto = producto;
			this.precio = precio;
			this.fecha = fecha;
			this.cliente = cliente;
			this.ruc = ruc;
			this.pesoSolicitado = pesoSolicitado;
			this.total = total();
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
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

	public double getPesoSolicitado() {
		return pesoSolicitado;
	}

	public void setPesoSolicitado(double pesoSolicitado) {
		this.pesoSolicitado = pesoSolicitado;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double total(){
		double subtotal = precio * pesoSolicitado;
		double igv = subtotal * 0.18 ;
		double subTotalsinIgv = subtotal - igv;
		return Math.round(subTotalsinIgv * 100.0) /100.0;
	}
	
	
	
}
