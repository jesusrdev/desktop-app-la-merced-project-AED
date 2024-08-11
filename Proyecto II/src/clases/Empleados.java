package clases;

public class Empleados extends Persona {

// Atributos 
	
	private String apellido;
	private String dni;
	private String estado;
	
//constructor
	
	public Empleados(
			int codigo, 
			String nombre, 
			String apellido, 
			String dni, 
			String telefono, 
			String estado
		) {
		
		super(codigo, nombre, telefono);
		// TODO Auto-generated constructor stub
		this.apellido = apellido;
		this.dni = dni;
		this.estado = estado;	
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}