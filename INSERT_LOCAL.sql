CREATE PROCEDURE `INSERT_LOCAL` (
IN_RUT INT,
IN_DIGITOVERIFICADOR VARCHAR(1),
IN_RAZON_SOCIAL VARCHAR (45),
IN_NOMBRE_COMERCIAL VARCHAR (120))
BEGIN
	INSERT INTO local (Rut, Digito_verificador, Razon_Social, Nombre_Comercial) VALUES (IN_RUT, IN_DIGITOVERIFICADOR, IN_RAZON_SOCIAL, IN_NOMBRE_COMERCIAL);
END
