CREATE TABLE productos (
    producto_id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255),
    precio DECIMAL(10, 2),
    cantidad INT,
    descripcion VARCHAR(1000),
    PRIMARY KEY (producto_id)
);