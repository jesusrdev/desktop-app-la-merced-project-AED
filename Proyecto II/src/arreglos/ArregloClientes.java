package arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Cliente;

public class ArregloClientes {

	// Atributo privado
	private ArrayList<Cliente> clientes;

	// Constructor
	public ArregloClientes() {
		clientes = new ArrayList<Cliente>();
		try {
			cargarClientes();
			obtener(0);

		} catch (Exception e) {
			// TODO: handle exception
			adicionar(new Cliente(1001,"20477731563", "Avicultor Jugabi", "Jugabi SAC", "Avicultor", "La Soledad", "Renzo", "987654321"));	
		}
	}

	// Methods
	public void adicionar(Cliente x) {
		clientes.add(x);
	}

	public int tamanio() {
		return clientes.size();
	}

	public Cliente obtener(int i) {
		return clientes.get(i);
	}

	public Cliente buscar(int codigo) {
		Cliente x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigo() == codigo)
				return x;
		}
		return null;
	}
	
	public Cliente buscar(String ruc) {
		Cliente x;
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getRuc().equals(ruc))
				return x;
		}
		return null;
	}

	public ArrayList<Cliente> buscarClientes(String texto) {
		ArrayList<Cliente> ac = new ArrayList<Cliente>();
		Cliente x;
		
		for (int i = 0; i < tamanio(); i++) {
			x = obtener(i);
			if (x.getNombre().contains(texto) || x.getNombre().toLowerCase().contains(texto))
				ac.add(x);
		}
		return ac;
	}

	public void eliminar(Cliente x) {
		clientes.remove(x);
	}

	// Operaciones publicas complementarias
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 01;
		else
			return obtener(tamanio() - 1).getCodigo() + 1;
	}

	// Metodos para trabajar cn rachivos
	public void grabarClientes() {
		try {
			PrintWriter pw;
			Cliente x;
			String linea;
			pw = new PrintWriter(new FileWriter("Clientes.txt"));
			for (int i = 0; i < clientes.size(); i++) {
				x = clientes.get(i);
				linea = x.getCodigo() + ";" +x.getRuc() + ";" + x.getNombre() + ";" + x.getRazonSocial() + ";" + x.getRubro() + ";"
						+ x.getLugarProcedencia() + ";" + x.getPersonaContacto() + ";" + x.getTelefono();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	public void cargarClientes() {
		try {
			BufferedReader br;
			String linea, s[],ruc , nombre, razonSocial, rubro, lugarProcedencia, personaContacto, telefono;
			int codigo;

			br = new BufferedReader(new FileReader("Clientes.txt"));

			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigo = Integer.parseInt(s[0]);
				ruc = s[1];
				nombre = s[2];
				razonSocial = s[3];
				rubro = s[4];
				lugarProcedencia = s[5];
				personaContacto = s[6];
				telefono = s[7];

				clientes.add(
						new Cliente(codigo, ruc, nombre, razonSocial, rubro, lugarProcedencia, personaContacto, telefono));
			}
			br.close();
		} catch (Exception e) {
		}
	}

}