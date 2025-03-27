CREATE DATABASE TALLER;

USE Taller;

CREATE TABLE Empleados (
    ID INT(20),
    DNI_Empleado VARCHAR(9) PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellidos VARCHAR(50),
    Num_tlf INT(9), 
    Profesion VARCHAR(50)
);

CREATE TABLE Clientes (
    ID INT(20),
    DNI_Cliente VARCHAR(9) PRIMARY KEY,
    Nombre VARCHAR(50),
    Apellidos VARCHAR(50),
    FechaInscrito DATE,
    Num_tlf INT(9)
);

CREATE TABLE Vehiculos (
    ID INT(20),
    Matricula VARCHAR(7) PRIMARY KEY,
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
    ID INT(20) PRIMARY KEY,
    Cantidad INT(10),
    Nombre VARCHAR(50),
    Proveedor VARCHAR(50),
    FOREIGN KEY (Proveedor) REFERENCES Proveedores(NIF)
);


CREATE TABLE Pedidos (
    ID INT(20) PRIMARY KEY,
    Producto VARCHAR(50),
    Cantidad INT(10),
    Proveedor VARCHAR(9),
    CosteUnidad DOUBLE(6,2),
    FOREIGN KEY (Proveedor) REFERENCES Proveedores(NIF)


);

CREATE TABLE Servicios (
    ID_Servicio INT(20) PRIMARY KEY,
    Servicio VARCHAR(50),
    Descripcion VARCHAR(50),
    Vehiculo VARCHAR(7),
    FOREIGN KEY (Vehiculo) REFERENCES Vehiculos(Matricula)

);

CREATE TABLE Citas (
    ID_Cita INT(20) PRIMARY KEY,
    Fecha DATE,
    Vehiculo VARCHAR(7),
    FOREIGN KEY (Vehiculo) REFERENCES Vehiculos(Matricula)

);

CREATE TABLE Factura (
    ID_Factura INT(20) PRIMARY KEY,
    Cliente VARCHAR(50),
    Servicio INT(20),
    Coste DOUBLE(6,2),
    FOREIGN KEY (Servicio) REFERENCES Servicios(ID_Servicio),
    FOREIGN KEY (Cliente) REFERENCES Clientes(DNI_Cliente)

);
