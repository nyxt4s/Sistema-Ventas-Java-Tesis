
USE DB_APPWEB_INVENTORYPROCESSCONTROL;

-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Categoria` (
  `ID_Categoria` INT NOT NULL AUTO_INCREMENT,
  `Categoria` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`ID_Categoria`));


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Marca`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Marca` (
  `ID_Marca` INT NOT NULL AUTO_INCREMENT,
  `Marca` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`ID_Marca`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Producto` (
  `Id_Producto` INT NOT NULL AUTO_INCREMENT,
  `Codigo_de_Barras` INT NULL,
  `Nombre` VARCHAR(120) NOT NULL,
  `Imagen` VARCHAR(180) NULL,
  `Id_Categoria` INT NOT NULL,
  `Id_Marca` INT NOT NULL,
  PRIMARY KEY (`Id_Producto`),
  INDEX `fk_Producto_Categoria1_idx` (`Id_Categoria` ASC) VISIBLE,
  INDEX `fk_Producto_Marca1_idx` (`Id_Marca` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`Id_Categoria`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Categoria` (`ID_Categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Marca1`
    FOREIGN KEY (`Id_Marca`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Marca` (`ID_Marca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
 ;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Local` (
  `Id_Local` INT NOT NULL AUTO_INCREMENT,
  `Rut` INT(8) NOT NULL,
  `Digito_Verificador` VARCHAR(1) NOT NULL,
  `Razon_Social` VARCHAR(45) NOT NULL,
  `Nombre_Comercial` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`Id_Local`))
   ;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Inventario` (
  `ID_Inventario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Cantidad` INT NOT NULL,
  `Precio_Costo` INT NOT NULL,
  `Precio_Venta` VARCHAR(45) NOT NULL,
  `Ubicacion` VARCHAR(120) NULL,
  `Id_Producto` INT NOT NULL,
  `Id_Local` INT NOT NULL,
  PRIMARY KEY (`ID_Inventario`),
  INDEX `fk_Inventario_Producto_idx` (`Id_Producto` ASC) VISIBLE,
  INDEX `fk_Inventario_Local1_idx` (`Id_Local` ASC) VISIBLE,
  CONSTRAINT `fk_Inventario_Producto`
    FOREIGN KEY (`Id_Producto`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Producto` (`Id_Producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inventario_Local1`
    FOREIGN KEY (`Id_Local`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Local` (`Id_Local`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Trabajador` (
  `Id_Persona` INT NOT NULL AUTO_INCREMENT,
  `Rut` INT(8) NULL,
  `Digito_Verificador` VARCHAR(1) NULL,
  `Nombre` VARCHAR(120) NOT NULL,
  `Apellido_Paterno` VARCHAR(120) NULL,
  `Apellido_Materno` VARCHAR(120) NULL,
  `Direccion` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`Id_Persona`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Usuario` (
  `ID_Tipo_Usuario` INT NOT NULL AUTO_INCREMENT,
  `Tipo_Usuario` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`ID_Tipo_Usuario`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Usuario` (
  `ID_Usuario` INT NOT NULL AUTO_INCREMENT,
  `Usuario` VARCHAR(80) NOT NULL,
  `Password` VARCHAR(120) NOT NULL,
  `Id_Persona` INT NOT NULL,
  `Id_Tipo_Usuario` INT NOT NULL,
  `Id_Local` INT NOT NULL,
  PRIMARY KEY (`ID_Usuario`),
  INDEX `fk_Usuario_Persona1_idx` (`Id_Persona` ASC) VISIBLE,
  INDEX `fk_Usuario_Tipo_Usuario1_idx` (`Id_Tipo_Usuario` ASC) VISIBLE,
  INDEX `fk_Usuario_Local1_idx` (`Id_Local` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_Persona1`
    FOREIGN KEY (`Id_Persona`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Trabajador` (`Id_Persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Tipo_Usuario1`
    FOREIGN KEY (`Id_Tipo_Usuario`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Usuario` (`ID_Tipo_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Local1`
    FOREIGN KEY (`Id_Local`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Local` (`Id_Local`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Iva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Iva` (
  `Id_Iva` INT NOT NULL AUTO_INCREMENT,
  `Fecha_Ingreso` DATETIME NOT NULL DEFAULT NOW(),
  `Valor` DECIMAL NOT NULL,
  `Estado` INT NOT NULL,
  PRIMARY KEY (`Id_Iva`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Venta` (
  `ID_Venta` INT NOT NULL AUTO_INCREMENT,
  `Fecha` DATETIME NOT NULL DEFAULT NOW(),
  `Descuento_Total_Venta` VARCHAR(45) NULL,
  `Total_Venta` VARCHAR(45) NOT NULL,
  `Id_Usuario` INT NOT NULL,
  PRIMARY KEY (`ID_Venta`),
  INDEX `fk_Venta_Usuario1_idx` (`Id_Usuario` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Usuario1`
    FOREIGN KEY (`Id_Usuario`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Usuario` (`ID_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Detalle_Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Detalle_Venta` (
  `ID_Detalle_Venta` INT NOT NULL AUTO_INCREMENT,
  `Cantidad` INT NOT NULL,
  `Precio_Costo` INT NOT NULL,
  `Precio_Venta` INT NOT NULL,
  `Descuento` INT NULL,
  `Id_Iva` INT NOT NULL,
  `Id_Inventario` INT UNSIGNED NOT NULL,
  `Id_Venta` INT NOT NULL,
  PRIMARY KEY (`ID_Detalle_Venta`),
  INDEX `fk_Detalle_Venta_Iva1_idx` (`Id_Iva` ASC) VISIBLE,
  INDEX `fk_Detalle_Venta_Inventario1_idx` (`Id_Inventario` ASC) VISIBLE,
  INDEX `fk_Detalle_Venta_Venta1_idx` (`Id_Venta` ASC) VISIBLE,
  CONSTRAINT `fk_Detalle_Venta_Iva1`
    FOREIGN KEY (`Id_Iva`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Iva` (`Id_Iva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Venta_Inventario1`
    FOREIGN KEY (`Id_Inventario`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Inventario` (`ID_Inventario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Venta_Venta1`
    FOREIGN KEY (`Id_Venta`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Venta` (`ID_Venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Proveedor` (
  `ID_Proveedor` INT NOT NULL AUTO_INCREMENT,
  `Rut` INT(8) NULL,
  `Digito_Verificador` INT(1) NULL,
  `Nombres` VARCHAR(45) NOT NULL,
  `Apellido_P` VARCHAR(45) NOT NULL,
  `Apellido_M` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Razon_Social` VARCHAR(45) NOT NULL,
  `Nombre_Comercial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID_Proveedor`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Opciones_Sistema`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Opciones_Sistema` (
  `Id_Opciones_Sistema` INT NOT NULL AUTO_INCREMENT,
  `Opciones_Sistema` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`Id_Opciones_Sistema`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Permiso` (
  `Id_Permiso` INT NOT NULL,
  `Visualizar` INT NOT NULL,
  `Crear` INT NOT NULL,
  `Actualizar` INT NOT NULL,
  `Eliminar` INT NOT NULL,
  `Id_Opciones_Sistema` INT NOT NULL,
  `Id_Usuario` INT NOT NULL,
  PRIMARY KEY (`Id_Permiso`),
  INDEX `fk_Permiso_Opciones_Sistema1_idx` (`Id_Opciones_Sistema` ASC) VISIBLE,
  INDEX `fk_Permiso_Usuario1_idx` (`Id_Usuario` ASC) VISIBLE,
  CONSTRAINT `fk_Permiso_Opciones_Sistema1`
    FOREIGN KEY (`Id_Opciones_Sistema`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Opciones_Sistema` (`Id_Opciones_Sistema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Permiso_Usuario1`
    FOREIGN KEY (`Id_Usuario`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Usuario` (`ID_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Telefono` (
  `Id_Tipo_Telefono` INT NOT NULL AUTO_INCREMENT,
  `Tipo_Telefono` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`Id_Tipo_Telefono`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Telefono_Trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Telefono_Trabajador` (
  `Id_Telefono` INT NOT NULL AUTO_INCREMENT,
  `Telefono` INT NOT NULL,
  `Id_Tipo_Telefono` INT NOT NULL,
  `Id_Persona` INT NOT NULL,
  PRIMARY KEY (`Id_Telefono`),
  INDEX `fk_Telefono_Tipo_Telefono1_idx` (`Id_Tipo_Telefono` ASC) VISIBLE,
  INDEX `fk_Telefono_Persona1_idx` (`Id_Persona` ASC) VISIBLE,
  CONSTRAINT `fk_Telefono_Tipo_Telefono1`
    FOREIGN KEY (`Id_Tipo_Telefono`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Telefono` (`Id_Tipo_Telefono`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Telefono_Persona1`
    FOREIGN KEY (`Id_Persona`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Trabajador` (`Id_Persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Email` (
  `Id_Tipo_Email` INT NOT NULL AUTO_INCREMENT,
  `Tipo_Email` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`Id_Tipo_Email`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Email_Trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Email_Trabajador` (
  `Id_Email` INT NOT NULL AUTO_INCREMENT,
  `Email` VARCHAR(200) NOT NULL,
  `Id_Tipo_Email` INT NOT NULL,
  `Id_Persona` INT NOT NULL,
  PRIMARY KEY (`Id_Email`),
  INDEX `fk_Email_Tipo_Email1_idx` (`Id_Tipo_Email` ASC) VISIBLE,
  INDEX `fk_Email_Persona1_idx` (`Id_Persona` ASC) VISIBLE,
  CONSTRAINT `fk_Email_Tipo_Email1`
    FOREIGN KEY (`Id_Tipo_Email`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Email` (`Id_Tipo_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Email_Persona1`
    FOREIGN KEY (`Id_Persona`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Trabajador` (`Id_Persona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Movimiento` (
  `Id_Tipo_Movimiento_Inventario` INT NOT NULL AUTO_INCREMENT,
  `Movimiento` VARCHAR(200) NOT NULL,
  `Tipo_Movimiento` CHAR(1) NOT NULL,
  PRIMARY KEY (`Id_Tipo_Movimiento_Inventario`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Movimiento_Inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Movimiento_Inventario` (
  `Id_Movimiento_Inventario` INT NOT NULL AUTO_INCREMENT,
  `Cantidad` VARCHAR(45) NOT NULL,
  `Costo` VARCHAR(45) NOT NULL,
  `Fecha_Movimiento` DATETIME NOT NULL DEFAULT NOW(),
  `Id_Tipo_Movimiento_Inventario` INT NOT NULL,
  `Id_Inventario` INT UNSIGNED NOT NULL,
  `Id_Usuario` INT NOT NULL,
  PRIMARY KEY (`Id_Movimiento_Inventario`),
  INDEX `fk_Movimiento_Inventario_Inventario1_idx` (`Id_Inventario` ASC) VISIBLE,
  INDEX `fk_Movimiento_Inventario_Tipo_Movimiento1_idx` (`Id_Tipo_Movimiento_Inventario` ASC) VISIBLE,
  INDEX `fk_Movimiento_Inventario_Usuario1_idx` (`Id_Usuario` ASC) VISIBLE,
  CONSTRAINT `fk_Movimiento_Inventario_Inventario1`
    FOREIGN KEY (`Id_Inventario`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Inventario` (`ID_Inventario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movimiento_Inventario_Tipo_Movimiento1`
    FOREIGN KEY (`Id_Tipo_Movimiento_Inventario`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Movimiento` (`Id_Tipo_Movimiento_Inventario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movimiento_Inventario_Usuario1`
    FOREIGN KEY (`Id_Usuario`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Usuario` (`ID_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Telefono_Local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Telefono_Local` (
  `Id_Telefono_Local` INT NOT NULL AUTO_INCREMENT,
  `Telefono_Local` INT NOT NULL,
  `Tipo_Telefono` INT NOT NULL,
  `ID_Local` INT NOT NULL,
  INDEX `fk_Telefono_Local_Tipo_Telefono1_idx` (`Tipo_Telefono` ASC) VISIBLE,
  PRIMARY KEY (`Id_Telefono_Local`),
  INDEX `fk_Telefono_Local_Local1_idx` (`ID_Local` ASC) VISIBLE,
  CONSTRAINT `fk_Telefono_Local_Tipo_Telefono1`
    FOREIGN KEY (`Tipo_Telefono`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Telefono` (`Id_Tipo_Telefono`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Telefono_Local_Local1`
    FOREIGN KEY (`ID_Local`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Local` (`Id_Local`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Email_Local`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Email_Local` (
  `Id_Email_Local` INT NOT NULL AUTO_INCREMENT,
  `Email_local` VARCHAR(200) NOT NULL,
  `Id_Tipo_Email` INT NOT NULL,
  `Id_Local` INT NOT NULL,
  PRIMARY KEY (`Id_Email_Local`),
  INDEX `fk_Email_Local_Tipo_Email1_idx` (`Id_Tipo_Email` ASC) VISIBLE,
  INDEX `fk_Email_Local_Local1_idx` (`Id_Local` ASC) VISIBLE,
  CONSTRAINT `fk_Email_Local_Tipo_Email1`
    FOREIGN KEY (`Id_Tipo_Email`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Email` (`Id_Tipo_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Email_Local_Local1`
    FOREIGN KEY (`Id_Local`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Local` (`Id_Local`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Telefono_Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Telefono_Proveedor` (
  `Id_Telefono_Provedor` INT NOT NULL AUTO_INCREMENT,
  `Telefono_Provedor` INT NOT NULL,
  `Id_Tipo_Telefono` INT NOT NULL,
  `Id_Proveedor` INT NOT NULL,
  PRIMARY KEY (`Id_Telefono_Provedor`),
  INDEX `fk_Telefono_Provedor_Tipo_Telefono1_idx` (`Id_Tipo_Telefono` ASC) VISIBLE,
  INDEX `fk_Telefono_Provedor_Proveedor1_idx` (`Id_Proveedor` ASC) VISIBLE,
  CONSTRAINT `fk_Telefono_Provedor_Tipo_Telefono1`
    FOREIGN KEY (`Id_Tipo_Telefono`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Telefono` (`Id_Tipo_Telefono`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Telefono_Provedor_Proveedor1`
    FOREIGN KEY (`Id_Proveedor`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Proveedor` (`ID_Proveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Email_Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Email_Proveedor` (
  `Id_Email_Provedor` INT NOT NULL AUTO_INCREMENT,
  `Email_Provedor` VARCHAR(200) NOT NULL,
  `Id_Tipo_Email` INT NOT NULL,
  `Id_Proveedor` INT NOT NULL,
  PRIMARY KEY (`Id_Email_Provedor`),
  INDEX `fk_Email_Provedor_Tipo_Email1_idx` (`Id_Tipo_Email` ASC) VISIBLE,
  INDEX `fk_Email_Provedor_Proveedor1_idx` (`Id_Proveedor` ASC) VISIBLE,
  CONSTRAINT `fk_Email_Provedor_Tipo_Email1`
    FOREIGN KEY (`Id_Tipo_Email`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tipo_Email` (`Id_Tipo_Email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Email_Provedor_Proveedor1`
    FOREIGN KEY (`Id_Proveedor`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Proveedor` (`ID_Proveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tabla`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tabla` (
  `IdTabla` INT NOT NULL AUTO_INCREMENT,
  `Tabla` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdTabla`))
;


-- -----------------------------------------------------
-- Table `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Actividad_Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Actividad_Usuario` (
  `Id_Actividad_Usuario` INT NOT NULL AUTO_INCREMENT,
  `Actividad_Usuario` VARCHAR(250) NOT NULL,
  `Fecha` DATETIME NOT NULL DEFAULT NOW(),
  `Tipo_Accion` INT NOT NULL,
  `Id_Usuario` INT NOT NULL,
  `IdTabla` INT NOT NULL,
  PRIMARY KEY (`Id_Actividad_Usuario`),
  INDEX `fk_Actividad_Usuario_Usuario1_idx` (`Id_Usuario` ASC) VISIBLE,
  INDEX `fk_Actividad_Usuario_Tabla1_idx` (`IdTabla` ASC) VISIBLE,
  CONSTRAINT `fk_Actividad_Usuario_Usuario1`
    FOREIGN KEY (`Id_Usuario`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Usuario` (`ID_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Actividad_Usuario_Tabla1`
    FOREIGN KEY (`IdTabla`)
    REFERENCES `DB_APPWEB_INVENTORYPROCESSCONTROL`.`Tabla` (`IdTabla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;

