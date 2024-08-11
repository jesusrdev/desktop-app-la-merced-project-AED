package clases;

public class Persona {

	//  Attributes
	private int codigo;
	private String nombre, telefono;
	
	//  Constructor
	public Persona(int codigo, String nombre, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	
	//  GETTERS & SETTERS
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
