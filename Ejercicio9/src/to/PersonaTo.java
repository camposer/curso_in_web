package to;

import java.io.Serializable;

public class PersonaTo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private Integer edad;
	private String mensaje;
	
	public PersonaTo(String nombre, String apellido, Integer edad, String mensaje) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.mensaje = mensaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
