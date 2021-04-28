CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_PRODUCT`(
	IN_ID_PRODUCT INT
)
BEGIN
	delete from producto where Id_Producto = IN_ID_PRODUCT ;
END