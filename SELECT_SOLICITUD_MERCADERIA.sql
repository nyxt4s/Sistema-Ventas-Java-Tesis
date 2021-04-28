CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECT_SOLICITUD_MERCADERIA`()
BEGIN
select s.idSolicitud, p.NOMBRE , u.Usuario, s.cantidad, s.fecha from solicitudMercaderia s
INNER JOIN producto p ON s.id_producto = p.Id_Producto
INNER JOIN usuario u ON s.id_usuario = u.ID_Usuario;
END