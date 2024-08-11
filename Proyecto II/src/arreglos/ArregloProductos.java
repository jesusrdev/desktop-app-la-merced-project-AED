package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Producto;

public class ArregloProductos {
	
	private ArrayList<Producto> pro; 
	
	// Constructor 
	public ArregloProductos(){
		pro = new ArrayList<Producto>();
		
		try {
			
			cargarProductos();
			
		} catch (Exception e) {
			adicionar(new Producto(101, "Maiz Amarillo", 1.60, "Aves", "Pienso"));
			adicionar(new Producto(102, "Maiz Chancado", 1.58, "Aves" ,"Pienso"));
			adicionar(new Producto(103, "Integral", 1.83, "Bobinos" , "Pienso" ));
			adicionar(new Producto(104, "B. Aves", 1.72, "Aves" , "Mezcla"));
			adicionar(new Producto(105, "Pancamel", 1.88, "Porcinos" ,"Suplemento"));
		}
	}
	
	// 
	public void adicionar(Producto x){
		pro.add(x);
	}
	
	public int tamanio() {
		return pro.size();
	}
	
	public Producto obtener(int i) {
		return pro.get(i);	
	}
	
	public Producto buscar(int codigo) {
		Producto x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	
	public void eliminar(Producto x) {
		pro.remove(x);
	}
	
	public ArrayList<Producto> buscarProducto(String texto) {
		ArrayList<Producto> ap = new ArrayList<Producto>();
		Producto x;
		
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getNombre().contains(texto) || x.getNombre().toLowerCase().contains(texto))
				ap.add(x);
		}
		return ap;
	}
	
	//  Operaciones p�blicas complementarias
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 101;
		else
			return obtener(tamanio()-1).getCodigo() + 1;		
	}
	
	public void grabarProductos() {
		try {
			PrintWriter pw;
			Producto x;
			String linea;
			pw = new PrintWriter(new FileWriter("Productos.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getCodigo() + ";" + 
						x.getNombre() + ";" + 
						x.getPrecio() + ";" +  
						x.getTipo()+ ";" +
						x.getClasificacion();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}
	
	public void cargarProductos() {
		try {
			BufferedReader br;
			String linea, s[], nombre,tipo,clasificacion;
			int codigo;
			double precio;
		
			br = new BufferedReader(new FileReader("Productos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
					codigo = Integer.parseInt(s[0]);
					nombre = s[1];
					precio = Double.parseDouble(s[2]);
					tipo = s[3];
					clasificacion = s[4];
					
				adicionar(new Producto(codigo, 
						nombre, 
						precio, 
						tipo, 
						clasificacion
				));
			}
			br.close();
		}catch(Exception e) {
		}
	}
	
	public String[] productosComboBox(){
		String[] lista = new String[tamanio()];	
		Producto producto;
		for (int i = 0; i < tamanio(); i++) {
			producto = obtener(i);
			lista[i] = producto.getNombre();
		}
		return lista;
	}
	
	public double buscarPrecio(String nombre){
		for (int i = 0; i < tamanio(); i++) {
			if (obtener(i).getNombre().equals(nombre)) {
                return obtener(i).getPrecio();
			}
		}
		return -1;
	}

}
