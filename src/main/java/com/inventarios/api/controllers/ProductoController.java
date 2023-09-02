package com.inventarios.api.controllers;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventarios.api.components.producto.DatosActulizarProducto;
import com.inventarios.api.components.producto.DatosListadoProducto;
import com.inventarios.api.components.producto.DatosRegistroProducto;
import com.inventarios.api.components.producto.Producto;
import com.inventarios.api.components.producto.ProductoRepository;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/productos")
@CrossOrigin(value="http://localhost:4200")
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping
	public List<Producto> obtenerProductos() {
		//return productoRepository.findAll();
		return productoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Producto obtenerProducto(@PathVariable Long id) {
		return productoRepository.findById(id).orElse(null);
	}

	@PostMapping
	public Producto registrarProducto(@RequestBody @Valid DatosRegistroProducto datosRegistroProducto) {
		Producto producto = productoRepository.save(new Producto(datosRegistroProducto));
		return producto;
	}

	@PutMapping
	@Transactional
	public void actualizarProducto(@RequestBody @Valid DatosActulizarProducto datosActualizarProducto) {
		Producto producto = productoRepository.getReferenceById(datosActualizarProducto.producto_id());
		System.out.println(datosActualizarProducto.producto_id());
		producto.ActualizarDatos(datosActualizarProducto);
	}

	@DeleteMapping("/toggle/{id}")
	@Transactional
	public void toggleProducto(@PathVariable Long id) {
		System.out.println(id);
		//Producto producto = productoRepository.getReferenceById(id);
		//producto.toggleProducto();
	}
	
	@DeleteMapping("/{id}")
	public void deleteProducto(@PathVariable Long id) {
		Producto producto = productoRepository.getReferenceById(id);
		productoRepository.delete(producto);
	}
}
