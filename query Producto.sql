describe producto;
call insert_product (3322, 'botellas', 'botella_Pocima.jpg', 4, 8);
call select_product();
select * from producto;

select Id_Producto, Codigo_de_Barras, Nombre, Imagen, Categoria, marca from producto p 
inner join categoria c on p.Id_categoria = c.ID_Categoria 
inner join marca m on p.Id_marca = m.ID_Marca;

delete from producto where id_Producto =8;