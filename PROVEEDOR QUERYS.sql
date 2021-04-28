describe proveedor;
USE db_appweb_inventoryprocesscontrol;




USE `db_appweb_inventoryprocesscontrol`;
DROP procedure IF EXISTS `INSERT_PROVIDE`;

DELIMITER $$
USE `db_appweb_inventoryprocesscontrol`$$
CREATE PROCEDURE `INSERT_PROVIDE` (
    IN RUT INT,
    IN DIGITO_VERIFICADOR INT,
    IN NOMBRES VARCHAR (45),
    IN APELLIDO_P VARCHAR (45),
    IN APELLIDO_M VARCHAR (45),
    IN DIRECCION VARCHAR (45),
    IN RAZON_SOCIAL VARCHAR (45),
    IN NOMBRE_COMERCIAL VARCHAR (45))
BEGIN
INSERT INTO proveedor (Rut, Digito_Verificador, Nombres, Apellido_P, Apellido_M, Direccion, Razon_Social, Nombre_Comercial)
VALUES (RUT, DIGITO_VERIFICADOR, NOMBRES, APELLIDO_P, APELLIDO_M, DIRECCION, RAZON_SOCIAL, NOMBRE_COMERCIAL);
END$$

DELIMITER ;

CALL db_appweb_inventoryprocesscontrol.INSERT_PROVIDE (19885308, 9, 'nyxth', 'medina', 'garay', 'matico402', 'confitados', 'Valkmoons' );

USE `db_appweb_inventoryprocesscontrol`;
DROP procedure IF EXISTS `SELECT_PROVIDE`;

DELIMITER $$
USE `db_appweb_inventoryprocesscontrol`$$
CREATE PROCEDURE `SELECT_PROVIDE` (
    IN RUT INT,
    IN DIGITO_VERIFICADOR INT,
    IN NOMBRES VARCHAR (45),
    IN APELLIDO_P VARCHAR (45),
    IN APELLIDO_M VARCHAR (45),
    IN DIRECCION VARCHAR (45),
    IN RAZON_SOCIAL VARCHAR (45),
    IN NOMBRE_COMERCIAL VARCHAR (45)
)
BEGIN

SELECT *FROM PROVEEDOR;

END$$
show tables;
DELIMITER ;

call SELECT_PROVIDE ();
describe proveedor;
UPDATE_PROVIDEUPDATE_PROVIDE
CALL UPDATE_PROVIDE (66, 'nombre', 'apellido p','apellido m','direccion','Razon_social', 'Nombre_comercial');
SET SQL_SAFE_UPDATES = 0;


call Delete_Provide (1);
