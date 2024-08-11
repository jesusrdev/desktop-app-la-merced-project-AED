package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Compra;
public class ArregloCompras {

	ArrayList<Compra> compras;
	
	public ArregloCompras() {
		compras = new ArrayList<Compra>();
		try {
			cargarCompras();
			obtener(0);
		} catch (Exception e) {
			// TODO: handle exception
			adicionar(new Compra("030 - 12345", "Viene y Toma", "1234567891011122", "10/08/2023", "Maiz Amarillo", 2.50, 1000, 2500.0));
			adicionar(new Compra("030 - 13579", "El El Todo Tengo", "1234567891011122", "10/08/2023", "Maiz Amarillo", 2.50, 1000, 2500.0));
			adicionar(new Compra("030 - 24802", "El Embutidor", "1234567891011122", "10/08/2023", "Integral", 2.50, 1000, 2500.0));
			
		}
		
	}
	
	// Metodos
	public int tamanio() {
		return compras.size();
	}
	
	public void adicionar(Compra x) {
		compras.add(x);
	}

	public Compra obtener(int i) {
		return compras.get(i);
	}

	public Compra buscar(String factura, String fecha, String producto, double precio, double cantidad) {
		Compra x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (	x.getFactura().equals(factura) &&
					x.getFecha().equals(fecha) &&
					x.getProducto().equals(producto) &&
					x.getPrecio() == precio &&
					x.getCantidad() == cantidad
					) {
				return x;
			}
		}
		return null;
	}
	
	public ArrayList<Compra> buscarProveedor(String texto) {
		ArrayList<Compra> ac = new ArrayList<Compra>();
		Compra x;
		
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getNombreProveedor().contains(texto) || x.getNombreProveedor().toLowerCase().contains(texto))
				ac.add(x);
		}
		return ac;
	}
	
	
	public void eliminar(Compra x) {
		compras.remove(x);
	}
	
	public void grabarCompras() {
		try {
			PrintWriter pw;
			Compra x;
			String linea;
			pw = new PrintWriter(new FileWriter("Compras.txt"));
			for (int i = 0; i < compras.size(); i++) {
				x = compras.get(i);
				linea = x.getFactura() + ";" + 
						x.getNombreProveedor() + ";" + 
						x.getRuc() + ";" + 
						x.getFecha() + ";" +
						x.getProducto() + ";" + 
						x.getPrecio() + ";" + 
						x.getCantidad() + ";" + 
						x.getImporteTotal();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}
	
	public void cargarCompras() {
		try {
			BufferedReader br;
			String linea, s[], factura, nombreProveedor, ruc, fecha, producto;
			double precio, importeTotal;
			double cantidad;
		
			br = new BufferedReader(new FileReader("Compras.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
					factura = s[0];
					nombreProveedor = s[1];
					ruc = s[2];
					fecha = s[3];
					producto = s[4];
					precio = Double.parseDouble(s[5]);
					cantidad = Double.parseDouble(s[6]);
					importeTotal = Double.parseDouble(s[7]);
					
				compras.add(new Compra(factura, 
						nombreProveedor, 
						ruc, 
						fecha, 
						producto, 
						precio, 
						cantidad, 
						importeTotal)
						);
			}
			br.close();
		}catch(Exception e) {
		}
	}
	
	
	public ArrayList<Compra> filtrarComprasPorFecha(int mes, int anio) {
		ArrayList<Compra> compras = new ArrayList<>();
		Compra x;
		
		for(int i = 0; i < tamanio(); i ++) {
			x = obtener(i);
			String[] fecha = x.getFecha().split("/");
			int mesCompra = Integer.parseInt(fecha[1]) - 1;
			int anioCompra = Integer.parseInt(fecha[2]);
			
			if(mes == mesCompra && anio == anioCompra) {
				compras.add(x);
			}
			
		}
		return compras;
	}
	
	
}
