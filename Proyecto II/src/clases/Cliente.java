package clases;

public class Cliente extends Persona {
	
	// Attributes
	private String ruc;
	private String razonSocial;
	private String rubro;
	private String lugarProcedencia;
	private String personaContacto;

	// Constructor
	public Cliente(
			int codigo, 
			String ruc,
			String nombre, 
			String razonSocial, 
			String rubro, 
			String lugarProcedencia, 
			String personaContacto, 
			String telefono
		) {
		
		super(codigo, nombre, telefono);
		// TODO Auto-generated constructor stub
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.rubro = rubro;
		this.lugarProcedencia = lugarProcedencia;
		this.personaContacto = personaContacto;
		
	}
	
	
	// Getters & Setters
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getLugarProcedencia() {
		return lugarProcedencia;
	}

	public void setLugarProcedencia(String lugarProcedencia) {
		this.lugarProcedencia = lugarProcedencia;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

}
