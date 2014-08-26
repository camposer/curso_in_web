function PersonaUtil() {
	var personas = [];
	var contador = 1;
	
	this.agregar = function(p) {
		p.id = contador++;
		personas.push(p);
	};
	
	this.obtenerTodos = function() {
		return personas;
	};
	
	/**
	 * Busca el índice de la persona dentro del array dado el id
	 */
	var buscarPos = function(id) {
		for (var i in personas) {
			if (id == personas[i].id) 
				return i;
		}
		return null;
	};

	/**
	 * Busca una persona a partir de un id
	 */
	this.obtener = function(id) {
		var pos = buscarPos(id);
		if (pos != null)
			return personas[pos];
		else
			return null;
	};

	/*
	this.modificar = function(p) {
		var p1 = obtener(p.id);
		if (p1 != null) {
			p1.nombre = p.nombre;
			p1.apellido = p.apellido;
			p1.fechaNacimiento = p.fechaNacimiento;
			p1.sexo = p.sexo;
		}
	};
	*/
	
	this.modificar = function(p) {
		var pos = buscarPos(p.id);
		if (pos != null) 
			personas[pos] = p;
	};
	

	this.eliminar = function(id) {
		var pos = buscarPos(id);
		if (pos != null) 
			personas.splice(pos, 1);
	};
	
}