package model;

import java.util.Date;

public class Persona {
	private Integer id;
	private String nombre;
	private String apellido;
	private Float altura;
	private Date fechaNacimiento;
	
	public Persona(String nombre, String apellido, Float altura,
			Date fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.altura = altura;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Persona(String nombre, String apellido) {
		this(nombre, apellido, null, null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Float getAltura() {
		return altura;
	}

	public void setAltura(Float altura) {
		this.altura = altura;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", altura=" + altura + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
}
