CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_PRODUCT`(
IN_CODIGOBARRA INT,
IN_NOMBRE VARCHAR (120),
IN_IMAGEN VARCHAR (180),
IN_ID_CATEGORIA INT,
IN_ID_MARCA INT
)
BEGIN
	INSERT INTO  producto (Codigo_de_Barras, Nombre, Imagen, Id_Categoria, Id_Marca) VALUES (IN_CODIGOBARRA, IN_NOMBRE, IN_IMAGEN, IN_ID_CATEGORIA, IN_ID_MARCA );
END