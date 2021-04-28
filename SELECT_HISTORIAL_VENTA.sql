CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_HISTORIAL_VENTA`()
BEGIN
Select V.id_venta, V.Fecha, v.Total_venta, U.usuario, l.nombre_comercial from venta AS V
INNER JOIN DETALLE_VENTA AS DV
ON V.ID_VENTA = DV.ID_VENTA
INNER JOIN INVENTARIO AS I
ON DV.ID_INVENTARIO = I.ID_INVENTARIO
INNER JOIN PRODUCTO AS P
ON P.ID_PRODUCTO = I.ID_PRODUCTO
INNER JOIN USUARIO AS U
ON V.ID_USUARIO = U.ID_USUARIO
INNER JOIN LOCAL AS L
ON U.ID_LOCAL = L.ID_LOCAL ORDER BY V.FECHA DESC;
END