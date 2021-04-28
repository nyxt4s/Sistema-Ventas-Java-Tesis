CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERT_SOLICITUD_MERCADERIA`(
     in_id_producto int,
     in_id_usuario int ,
     in_cantidad int     
)
BEGIN
	insert into solicitudmercaderia (id_producto, id_usuario, cantidad) values(in_id_producto, in_id_usuario, in_cantidad );
END