CREATE PROCEDURE `INSERT_BRAND` (
IN_NOMBREMARCA varchar (120))
BEGIN
		INSERT INTO MARCA (Marca) VALUES (IN_NOMBREMARCA);
END
