CREATE DATABASE TALLER;

USE Taller;

CREATE TABLE Empleados (
    ID INT AUTO_INCREMENT,
    DNI_Empleado VARCHAR(9) PRIMARY KEY,
    Nombre VARCHAR(50),
<<<<<<< HEAD
    Apellidos VARCHAR(50),/* Falta por meter numero de la seguirdad social y su número de cuenta bancaria.*/
=======
    Apellidos VARCHAR(50),
    FechaInscrito DATE,
>>>>>>> origin/Marcos-KQBG
    Num_tlf INT(9), 
    NumeroSS VARCHAR(12),
    CuentaBanco VARCHAR(24)
);

CREATE TABLE Clientes (
    ID INT AUTO_INCREMENT,
    DNI_Cliente VARCHAR(9) PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellidos VARCHAR(50), /*Falta por poner email y dirección, para poder guardarlos. */
    FechaInscrito DATE,
    Num_tlf VARCHAR(15),
    Direccion VARCHAR(50),
    Email VARCHAR(100)
);

CREATE TABLE Vehiculos (
    ID INT AUTO_INCREMENT,
    Matricula VARCHAR(7) PRIMARY KEY,  /*tipo de combustibel lo podemos poner igual en modelo*/
    Marca VARCHAR(50),
    Modelo VARCHAR(50),
    Cliente VARCHAR(9),
    FOREIGN KEY (Cliente) REFERENCES Clientes(DNI_Cliente)

);

CREATE TABLE Proveedores (
    NIF VARCHAR(9) PRIMARY KEY,
    Nombre VARCHAR(50),
    Tipo VARCHAR(50),
    Direccion VARCHAR(50),
    CorreoElectronico VARCHAR(100)
    
);

CREATE TABLE Inventario (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Cantidad INT(10),
    Nombre VARCHAR(50),
    Proveedor VARCHAR(50),
    FOREIGN KEY (Proveedor) REFERENCES Proveedores(NIF)
);


CREATE TABLE Pedidos (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Producto VARCHAR(50),
    Cantidad INT(10),
    Proveedor VARCHAR(9),
    CosteUnidad DOUBLE(6,2),
    FOREIGN KEY (Proveedor) REFERENCES Proveedores(NIF)


);

CREATE TABLE Servicios (
    ID_Servicio INT AUTO_INCREMENT PRIMARY KEY,
    Servicio VARCHAR(50),
    Descripcion VARCHAR(50),
    Vehiculo VARCHAR(7),
    Empleado VARCHAR(9),
    FOREIGN KEY (Vehiculo) REFERENCES Vehiculos(Matricula),
    FOREIGN KEY (Empleado) REFERENCES Empleados(DNI_Empleado)

);

CREATE TABLE Citas (
    ID_Cita INT AUTO_INCREMENT PRIMARY KEY,
    Fecha DATE,
    Vehiculo VARCHAR(7),
    FOREIGN KEY (Vehiculo) REFERENCES Vehiculos(Matricula)

);

CREATE TABLE Factura (
    ID_Factura INT AUTO_INCREMENT PRIMARY KEY,
    Cliente VARCHAR(50),
    Servicio INT(20),
    Coste DOUBLE(6,2),
    FOREIGN KEY (Servicio) REFERENCES Servicios(ID_Servicio),
    FOREIGN KEY (Cliente) REFERENCES Clientes(DNI_Cliente)

);
