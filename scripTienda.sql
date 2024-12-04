-- Crear la base de datos TiendaTecnologica
CREATE DATABASE IF NOT EXISTS TiendaTecnologica;
USE TiendaTecnologica;

-- Crear la tabla de categorías
CREATE TABLE IF NOT EXISTS categorias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE
);

-- Crear la tabla de productos
CREATE TABLE IF NOT EXISTS productos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL UNIQUE,
    precio DECIMAL(10, 2) NOT NULL,
    descripcion VARCHAR(500),
    pantalla VARCHAR(100),
    camara VARCHAR(100),
    bateria VARCHAR(100),
    inventario INT NOT NULL,
    categoria_id INT,
    imagen_blob TEXT,
    FOREIGN KEY (categoria_id) REFERENCES categorias(id) ON DELETE CASCADE
);

-- Crear la tabla de características de los productos
CREATE TABLE IF NOT EXISTS caracteristicas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT,
    caracteristica VARCHAR(255),
    valor VARCHAR(255),
    FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
);


-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    calle VARCHAR(255),
    numero INT,
    ciudad VARCHAR(100),
    pais VARCHAR(100)
);

-- Crear la tabla del historial de compras
CREATE TABLE IF NOT EXISTS historial_compras (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    producto_id INT,
    cantidad INT,
    fecha DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
);

DROP database tiendatecnologica;

SELECT * FROM usuarios;
SELECT * FROM categorias;
SELECT * FROM productos;
SELECT * FROM historial_compras;
DROP DATABASE tiendatecnologica;
