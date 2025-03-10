DROP TABLE IF EXISTS Monto_Inicios;
DROP TABLE IF EXISTS Pagos;
DROP TABLE IF EXISTS Items_Pedidos;
DROP TABLE IF EXISTS Movimientos_Stocks;
DROP TABLE IF EXISTS Precios;
DROP TABLE IF EXISTS Tipo_Transacciones;
DROP TABLE IF EXISTS Acreedores;
DROP TABLE IF EXISTS Transacciones;
DROP TABLE IF EXISTS Cajas;
DROP TABLE IF EXISTS Pedidos;
DROP TABLE IF EXISTS Mesas;
DROP TABLE IF EXISTS Categorias;
DROP TABLE IF EXISTS Menus;
DROP TABLE IF EXISTS Mozos;

CREATE TABLE Monto_Inicios (
	ID_Monto_Inicio BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Tipo_Caja VARCHAR(20) NOT NULL,
	Monto DECIMAL(12,4) NOT NULL,
	ID_Caja BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (ID_Monto_Inicio),
	KEY (ID_Caja)
);

CREATE TABLE Pagos (
	ID_Pago BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fecha TIMESTAMP NOT NULL,
	Importe DECIMAL(12,4) NOT NULL,
	ID_Acreedor BIGINT UNSIGNED NOT NULL,
	ID_Transaccion BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (ID_Pago),
	UNIQUE UQ_Pagos_ID_Transaccion(ID_Transaccion),
	KEY (ID_Acreedor),
	KEY (ID_Transaccion)
);

CREATE TABLE Items_Pedidos (
	ID_Item_Pedido BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Cantidad DECIMAL(12,4) NOT NULL,
	Activo BOOL NOT NULL,
	ID_Menu BIGINT UNSIGNED NOT NULL,
	ID_Pedido BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (ID_Item_Pedido),
	KEY (ID_Menu),
	KEY (ID_Pedido)
);

CREATE TABLE Movimientos_Stocks (
	ID_Movimiento_Stock BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fecha TIMESTAMP NOT NULL,
	Descripcion VARCHAR(150) NOT NULL,
	Movimiento DECIMAL(12,4) NOT NULL,
	Disponible DECIMAL(12,4) NOT NULL,
	Activo BOOL NOT NULL,
	ID_Menu BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (ID_Movimiento_Stock),
	KEY (ID_Menu)
);

CREATE TABLE Precios (
	ID_Precio BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Precio DECIMAL(12,4) NOT NULL,
	Fecha_Inicio TIMESTAMP NOT NULL,
	Fecha_Fin TIMESTAMP,
	ID_Menu BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (ID_Precio),
	KEY (ID_Menu)
);

CREATE TABLE Tipo_Transacciones (
	ID_Tipo_Transaccion BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Nombre VARCHAR(75) NOT NULL,
	Ingreso BOOL NOT NULL,
	Activo BOOL NOT NULL,
	PRIMARY KEY (ID_Tipo_Transaccion)
);

CREATE TABLE Acreedores (
	ID_Acreedor BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Nombre VARCHAR(100) NOT NULL,
	Direccion VARCHAR(100),
	Telefono VARCHAR(20),
	Observacion VARCHAR(255),
	Activo BOOL NOT NULL,
	PRIMARY KEY (ID_Acreedor)
);

CREATE TABLE Transacciones (
	ID_Transaccion BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Tipo_Caja VARCHAR(20) NOT NULL,
	Fecha TIMESTAMP NOT NULL,
	Observacion VARCHAR(100) NOT NULL,
	Importe DECIMAL(12,4) NOT NULL,
	ID_Tipo_Transaccion BIGINT UNSIGNED NOT NULL,
	ID_Caja BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (ID_Transaccion),
	KEY (ID_Caja),
	KEY (ID_Tipo_Transaccion)
);

CREATE TABLE Cajas (
	ID_Caja BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fecha_Apertura TIMESTAMP NOT NULL,
	Fecha_Cierre TIMESTAMP,
	PRIMARY KEY (ID_Caja)
);

CREATE TABLE Pedidos (
	ID_Pedido BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Fecha TIMESTAMP NOT NULL,
	Cubiertos DECIMAL(12,4) NOT NULL,
	Descuentos DECIMAL(12,4) NOT NULL,
	Importe DECIMAL(12,4) NOT NULL,
	Activo BOOL NOT NULL,
	ID_Mesa BIGINT UNSIGNED NOT NULL,
	ID_Mozo BIGINT UNSIGNED NOT NULL,
	ID_Transaccion BIGINT UNSIGNED,
	PRIMARY KEY (ID_Pedido),
	UNIQUE UQ_Pedidos_ID_Transaccion(ID_Transaccion),
	KEY (ID_Mesa),
	KEY (ID_Mozo),
	KEY (ID_Transaccion)
);

CREATE TABLE Mesas (
	ID_Mesa BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Disponible BOOL NOT NULL,
	Activo BOOL NOT NULL,
	ID_Pedido BIGINT UNSIGNED,
	PRIMARY KEY (ID_Mesa),
	KEY (ID_Pedido)
);

CREATE TABLE Categorias (
	ID_Categoria BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Nombre VARCHAR(75) NOT NULL,
	Activo BOOL NOT NULL,
	PRIMARY KEY (ID_Categoria)
);

CREATE TABLE Menus (
	ID_Menu BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Nombre VARCHAR(100) NOT NULL,
	Activo BOOL NOT NULL,
	ID_Categoria BIGINT UNSIGNED NOT NULL,
	PRIMARY KEY (ID_Menu),
	KEY (ID_Categoria)
);

CREATE TABLE Mozos (
	ID_Mozo BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	Nombre VARCHAR(50) NOT NULL,
	Apellido VARCHAR(50) NOT NULL,
	Activo BOOL NOT NULL,
	PRIMARY KEY (ID_Mozo)
);


ALTER TABLE Monto_Inicios ADD CONSTRAINT FK_Monto_Inicios_Cajas 
	FOREIGN KEY (ID_Caja) REFERENCES Cajas (ID_Caja)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Pagos ADD CONSTRAINT FK_Pagos_Acreedores 
	FOREIGN KEY (ID_Acreedor) REFERENCES Acreedores (ID_Acreedor)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Pagos ADD CONSTRAINT FK_Pagos_Transacciones 
	FOREIGN KEY (ID_Transaccion) REFERENCES Transacciones (ID_Transaccion)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Items_Pedidos ADD CONSTRAINT FK_Items_Pedidos_Menus 
	FOREIGN KEY (ID_Menu) REFERENCES Menus (ID_Menu)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Items_Pedidos ADD CONSTRAINT FK_Items_Pedidos_Pedidos 
	FOREIGN KEY (ID_Pedido) REFERENCES Pedidos (ID_Pedido)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Movimientos_Stocks ADD CONSTRAINT FK_Stocks_Menus 
	FOREIGN KEY (ID_Menu) REFERENCES Menus (ID_Menu)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Precios ADD CONSTRAINT FK_Precios_Menus 
	FOREIGN KEY (ID_Menu) REFERENCES Menus (ID_Menu)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Transacciones ADD CONSTRAINT FK_Transacciones_Cajas 
	FOREIGN KEY (ID_Caja) REFERENCES Cajas (ID_Caja)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Transacciones ADD CONSTRAINT FK_Transacciones_Tipo_Transacciones 
	FOREIGN KEY (ID_Tipo_Transaccion) REFERENCES Tipo_Transacciones (ID_Tipo_Transaccion)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Pedidos ADD CONSTRAINT FK_Pedidos_Mesas 
	FOREIGN KEY (ID_Mesa) REFERENCES Mesas (ID_Mesa)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Pedidos ADD CONSTRAINT FK_Pedidos_Mozos 
	FOREIGN KEY (ID_Mozo) REFERENCES Mozos (ID_Mozo)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Pedidos ADD CONSTRAINT FK_Pedidos_Transacciones 
	FOREIGN KEY (ID_Transaccion) REFERENCES Transacciones (ID_Transaccion)
	ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Mesas ADD CONSTRAINT FK_Mesas_Pedidos 
	FOREIGN KEY (ID_Pedido) REFERENCES Pedidos (ID_Pedido)
	ON DELETE SET NULL ON UPDATE CASCADE;

ALTER TABLE Menus ADD CONSTRAINT FK_Menus_Categorias 
	FOREIGN KEY (ID_Categoria) REFERENCES Categorias (ID_Categoria)
	ON DELETE CASCADE ON UPDATE CASCADE;