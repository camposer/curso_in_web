const SEXO_MASCULINO = "M";
const SEXO_FEMENINO = "F";

function Persona(_nombre, _apellido) {
	var id = null;
	var nombre = _nombre;
	var apellido = _apellido;
	var fechaNacimiento = null;
	var sexo = null;
	
	this.setId = function(_i) { id = _i; };
	this.getId = function() { return id; };
	this.setNombre = function(_n) { nombre = _n; }; 
	this.getNombre = function() { return nombre; };
	this.setApellido = function(_a) { apellido = _a; }; 
	this.getApellido = function() { return apellido; };
	this.setFechaNacimiento = function(_fnac) { 
		fechaNacimiento = _fnac; 
	};
	this.getFechaNacimiento = function() { 
		return fechaNacimiento; 
	};
	this.setSexo = function(_s) { sexo = _s; };
	this.getSexo = function() { return sexo; };
	
	this.toString = function() {
		return "[ id = " + id +
			", nombre = " + nombre +
			", apellido = " + apellido +
			", fnac = " + fechaNacimiento +
			", sexo = " + sexo + " ]";
	};
}