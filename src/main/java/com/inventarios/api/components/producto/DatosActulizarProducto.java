package com.inventarios.api.components.producto;

import jakarta.validation.constraints.NotNull;

public record DatosActulizarProducto(
		@NotNull Long producto_id, 
		String nombre,
		String descripcion,
		Integer cantidad, 
		Double precio
		) {

}
