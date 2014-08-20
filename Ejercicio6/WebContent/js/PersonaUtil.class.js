function PersonaUtil() {
	var personas = [];
	var contador = 1;
	
	this.agregar = function(p) {
		p.setId(contador++);
		personas.push(p);
	};
	
	this.obtenerTodos = function() {
		return personas;
	};
	
	this.obtener = function(id) {
		// TODO Buscar por id dentro de un bucle
	};
	
	this.modificar = function(p) {
		// TODO Buscar por id dentro de un bucle y cuando lo consiga reemplazarlo
	};

	this.eliminar = function(p) {
		// TODO Buscar por id dentro de un bucle y cuando lo consiga eliminarlo
	};
	
}