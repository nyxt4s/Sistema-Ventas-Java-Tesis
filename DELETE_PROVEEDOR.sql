CREATE PROCEDURE `new_procedure` (
in_Rut int
)
BEGIN
	DELETE FROM proveedor WHERE Rut = in_Rut;
END
