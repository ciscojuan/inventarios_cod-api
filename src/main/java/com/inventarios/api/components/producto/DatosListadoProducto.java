package com.inventarios.api.components.producto;

public record DatosListadoProducto(
		Long producto_id, 
		String nombre, 
		String descripcion, 
		Integer cantidad, 
		Double precio) {

	public DatosListadoProducto(Producto producto) {
		this(producto.getProducto_id(),producto.getNombre(), producto.getDescripcion(), producto.getCantidad(), producto.getPrecio());
	}
}
