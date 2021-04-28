CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_PRODUCT`()
BEGIN
	select Id_Producto, Codigo_de_Barras, Nombre, Imagen, Categoria, marca from producto p 
	inner join categoria c on p.Id_categoria = c.ID_Categoria 
	inner join marca m on p.Id_marca = m.ID_Marca;
END