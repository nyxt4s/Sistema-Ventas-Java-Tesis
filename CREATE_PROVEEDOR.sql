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
END