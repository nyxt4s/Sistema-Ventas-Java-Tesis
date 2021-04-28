CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETE_SOLICIUTD`(
    in_id_solicitud int,
    	in_id_usuario int
)
BEGIN
	DELETE FROM solicitudmercaderia WHERE idSolicitud = in_id_solicitud and id_usuario = in_id_usuario;
END