package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Cliente;
import clases.Empleados;

public class ArregloEmpleados {
// Atributo privado
	private ArrayList<Empleados> per;

// Constructor
	public ArregloEmpleados() {
		per = new ArrayList<Empleados>();
		try {
			cargarEmpleados();
			obtener(0);

		} catch (Exception e) {
		adicionar(new Empleados(1001, "Otar Hefer", "Vega Cordova", "74987201", "957595878", "Soltero"));
		adicionar(new Empleados(1002, "Kevin Alexander", "Briceño Quezada", "73465903", "989647597", "Soltero"));
		adicionar(new Empleados(1003, "Jesus Eduardo", "Rojas Alarcon", "73987289", "934583498", "Soltero"));
		adicionar(new Empleados(1004, "Bruno Sebastian", "Gomez Billegas", "73846836", "934538348", "Soltero"));
		adicionar(new Empleados(1005, "Nun Abdiel", "Zevallos Acosta", "74987201", "934584355", "Soltero"));
	    }
	}

// Operaciones públicas básicas
	public void adicionar(Empleados x) {
		per.add(x);
	}

	public int tamanio() {
		return per.size();
	}

	public Empleados obtener(int i) {
		return per.get(i);
	}
	
	public Empleados buscar(int codigo) {
		Empleados x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	
	public Empleados buscar(String dni) {
		Empleados x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}

	public ArrayList<Empleados> buscarEmpleados(String texto) {
		ArrayList<Empleados> ac = new ArrayList<Empleados>();
		Empleados x;
		
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getNombre().contains(texto) || x.getNombre().toLowerCase().contains(texto))
				ac.add(x);
		}
		return ac;
	}
	public void eliminar(Empleados x) {
		per.remove(x);
	}

// Operaciones públicas complementarias
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 10001;
		else
			return obtener(tamanio() - 1).getCodigo() + 1;
	}

//Metodos para trabajar cn rachivos
	public void grabarEmpleados() {
		try {
			PrintWriter pw;
			Empleados x;
			String linea;
			pw = new PrintWriter(new FileWriter("Empleados.txt"));
			for (int i = 0; i < per.size(); i++) {
				x = per.get(i);
				linea = x.getCodigo() + ";" + x.getNombre() + ";" + x.getApellido() + ";" + x.getDni() + ";"
						+ x.getTelefono() + ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}
	
	public void cargarEmpleados() {
		try {
			BufferedReader br;
			String linea, s[], nombre, apellido, dni, telefono;
			String estado;
			int codigo;

			br = new BufferedReader(new FileReader("Empleados.txt"));

			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0]);
				nombre = s[1];
				apellido = s[2];
				dni = s[3];
				telefono = s[4];
				estado = s[5];

				per.add(
						new Empleados(codigo, nombre, apellido, dni, telefono, estado));
			}
			br.close();
		} catch (Exception e) {
		}
	}

}