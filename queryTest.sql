CREATE TABLE `solicitudmercaderia` (
  `idSolicitud` int NOT NULL AUTO_INCREMENT,
  `id_producto` int NOT NULL,
  `id_usuario` int NOT NULL,
  `cantidad` int NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idSolicitud`),
  KEY `id_producto` (`id_producto`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `solicitudmercaderia_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`Id_Producto`),
  CONSTRAINT `solicitudmercaderia_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`ID_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


/*
create table solicitudMercaderia (
	 idSolicitud int NOT NULL,
     id_producto int NOT NULL,
     id_usuario int NOT NULL,
     cantidad int NOT NULL,
     fecha datetime NOT NULL,
     primary key (idSolicitud),
     FOREIGN KEY (id_producto) references producto(Id_Producto),
     FOREIGN KEY (id_usuario) references usuario (ID_Usuario)
)*/

select * from solicitudMercaderia;
Select * from producto;


select s.idSolicitud, p.NOMBRE , u.Usuario, s.cantidad, s.fecha from solicitudMercaderia s
INNER JOIN producto p ON s.id_producto = p.Id_Producto
INNER JOIN usuario u ON s.id_usuario = u.ID_Usuario;

CALL INSERT_SOLICITUD_MERCADERIA(15, 1 , 30);
