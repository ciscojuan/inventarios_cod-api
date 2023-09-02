package com.inventarios.api.components.producto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "productos")
@Entity(name = "Producto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "producto_id")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long producto_id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer cantidad;
	private Boolean activo;

	public Producto(DatosRegistroProducto datosRegistroProducto) {
		this.nombre = datosRegistroProducto.nombre();
		this.descripcion = datosRegistroProducto.descripcion();
		this.precio = datosRegistroProducto.precio();
		this.cantidad = datosRegistroProducto.cantidad();
		this.activo = true;

	}

	public void ActualizarDatos(DatosActulizarProducto datosActualizarProducto) {
		if (datosActualizarProducto.nombre() != null);
			this.nombre = datosActualizarProducto.nombre();
		if (datosActualizarProducto.descripcion() != null)
			this.descripcion = datosActualizarProducto.descripcion();
		if (datosActualizarProducto.cantidad() != null)
			this.cantidad = datosActualizarProducto.cantidad();
		if (datosActualizarProducto.precio() != null)
			this.precio = datosActualizarProducto.precio();

	}

	public void toggleProducto() {
		this.activo = !activo;
		System.out.println(activo);
		
	}

}
