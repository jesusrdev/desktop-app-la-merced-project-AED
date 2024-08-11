package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.w3c.dom.ls.LSInput;

import clases.Cliente;
import clases.Factura;
import clases.Producto;

public class ArregloFacturas {
	ArrayList<Factura> fac;

	public ArregloFacturas() {
		fac = new ArrayList<Factura>();
		try {
			
			cargarFacturas();
			obtener(0);
			
		} catch (Exception e) {
			adicionar(new Factura("10001","16/08/2023","Pablo","12321","Integral",12.0,12.0,118.08));
			adicionar(new Factura("10002","16/08/2023","Lucas","123","Maiz Amarillo",1.5,12.0,14.76));
			adicionar(new Factura("10003","10/08/2023","zxc","234","Maiz Chancado",1.58,12.0,15.55));
		}
	}
	
	// 
	public void adicionar(Factura x){
		fac.add(x);
	}
	
	public int tamanio() {
		return fac.size();
	}
	
	public Factura obtener(int i) {
		return fac.get(i);	
	}
	
	public Factura buscar(String factura, String fecha, String producto, double precio, double cantidad) {
		Factura x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (	x.getFactura().equals(factura) &&
					x.getFecha().equals(fecha) &&
					x.getProducto().equals(producto) &&
					x.getPrecio() == precio &&
					x.getPesoSolicitado() == cantidad
					) {
				return x;
			}
		}
		return null;
	}
	
	public void eliminar(Factura x) {
		fac.remove(x);
	}

	//  Operaciones p�blicas complementarias
	

	
	public void grabarFactura() {
		try {
			PrintWriter pw;
			Factura x;
			String linea;
			pw = new PrintWriter(new FileWriter("Factura.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getFactura() + ";" + 
						x.getFecha() + ";" + 
						x.getCliente() + ";" + 
						x.getRuc() + ";" + 
						x.getProducto()+ ";" +
						x.getPrecio()+ ";" +
						x.getPesoSolicitado()+ ";" +
						x.getTotal();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}
	
	public void cargarFacturas() {
		try {
			BufferedReader br;
			String linea, s[];
			String factura; 
			String fecha, cliente, ruc, producto;
			double  precio, pesoSolicitado, total;
		
			br = new BufferedReader(new FileReader("Factura.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
					factura = s[0];
					fecha = s[1];
					cliente = s[2];
					ruc = s[3];
					producto = s[4];
					precio = Double.parseDouble(s[5]);
					pesoSolicitado = Double.parseDouble(s[6]);
					total = Double.parseDouble(s[7]);
					
				adicionar(new Factura(factura, fecha, cliente, ruc, producto, precio, pesoSolicitado, total));
			}
			br.close();
		}catch(Exception e) {
		}
	}
	
	public ArrayList<Factura> filtrarFacturasPorFecha(int mes, int anio) {
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		Factura x;
		
		
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			
			String[] fecha = x.getFecha().split("/");
			int mesFactura = (Integer.parseInt(fecha[1]) -1);
			int anioFactura = Integer.parseInt(fecha[2]); 				
//			if (mesProducto < 0) {
//				mesProducto = 11;
//				anioProducto = anioProducto -1; 
//			}
			
			if ( mesFactura == mes && anioFactura == anio ) {
				facturas.add(x);
			}
			
		}
		return facturas;
	}
	
}
