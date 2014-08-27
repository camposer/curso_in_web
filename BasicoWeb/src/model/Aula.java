package model;

import java.io.Serializable;

public class Aula implements Serializable {
	private static final long serialVersionUID = -1608544911748909710L;

	private Integer id;
	private Integer capacidad;
	private String nombre;
	
	public Aula(Integer id, Integer capacidad, String nombre) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
