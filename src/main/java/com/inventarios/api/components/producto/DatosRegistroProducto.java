package com.inventarios.api.components.producto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DatosRegistroProducto (
    @NotBlank String nombre, 
    @NotBlank String descripcion, 
    @Positive Integer cantidad, 
    @Positive Double precio ){

}
