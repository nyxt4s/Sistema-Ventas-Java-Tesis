CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_LOCAL`(
	IN_RUT INT
)
BEGIN
DELETE FROM LOCAL WHERE Rut = IN_RUT;
END