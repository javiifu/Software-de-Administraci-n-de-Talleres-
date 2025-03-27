CREATE DATABASE TALLER;



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
    Num_tlf INT(9),
    
);
CREATE TABLE Vehiculos (
    ID INT(20),
    Matricula VARCHAR(7) PRIMARY KEY,
    Marca VARCHAR(50),
    Modelo VARCHAR(50),
    Cliente VARCHAR(9),
    FOREIGN KEY (Cliente) REFERENCES Clientes(DNI_Cliente),

);

CREATE TABLE Inventario (
    ID INT(20),
    Cantidad INT(10),
    Nombre VARCHAR(50),
    Proveedor VARCHAR(50),
    FOREIGN KEY Proveedor REFERENCES Proveedor(ID_Proveedor)
);

Create table Proveedor (
    NIF INT(20) PRIMARY KEY,
    Nombre VARCHAR(50),
    Tipo VARCHAR(50),
    Direccion VARCHAR(50),
    CorreoElectronico VARCHAR(100),
    

)
