
/*PROCEDIMIENTOS ALMACENADOS*/
/*CLIENTES*/
--INSERT
CREATE OR REPLACE PROCEDURE SP_INSERTAR_CLIENTE
(p_nombres IN varchar2,
p_apellidos IN varchar2,
p_direccion IN varchar2,
p_telefono IN varchar2,
p_email IN varchar2,
p_clave IN varchar2,
p_fecha_nac IN varchar2,
p_estado IN char
)
IS
begin
INSERT INTO
CLIENTES (cod_cliente, nombres, apellidos, direccion,
 telefono, email, clave, fecha_nac, estado)
VALUES
 (SEQ_COD_CLIENTE.NEXTVAL, p_nombres, p_apellidos,
  p_direccion, p_telefono, p_email,
  p_clave, p_fecha_nac, p_estado);
end;
--UPDATE
CREATE OR REPLACE PROCEDURE SP_MODIFICAR_CLIENTE
(p_cod_cliente number,
p_nombres IN varchar2,
p_apellidos IN varchar2,
p_direccion IN varchar2,
p_telefono IN varchar2,
p_email IN varchar2,
p_clave IN varchar2,
p_fecha_nac IN varchar2,
p_estado IN char
)
IS
BEGIN
UPDATE CLIENTES SET
  nombres = p_nombres,
  apellidos = p_apellidos,
  direccion = p_direccion,
  telefono = p_telefono,
  email = p_email,
  clave = p_clave,
  fecha_nac = p_fecha_nac,
  estado = p_estado
  WHERE cod_cliente = p_cod_cliente;
end;
--DELETE
CREATE OR REPLACE PROCEDURE SP_ELIMINAR_CLIENTE
(p_cod_cliente IN number)
IS
BEGIN
DELETE FROM CLIENTES WHERE cod_cliente = p_cod_cliente;
END;

/*PRODUCTOS*/
--INSERT
CREATE OR REPLACE PROCEDURE SP_INSERTAR_PRODUCTOS
(p_nombres IN varchar2,
p_usuario IN varchar2,
p_password IN varchar2
p_img_producto IN varchar2,
p_video_youtube IN varchar2,
p_banner_grande IN varchar2,
p_banner_oferta_grande IN varchar2,
p_banner_chico IN varchar2,
p_banner_oferta_chica IN varchar2,
p_estado char
)
IS
begin
INSERT INTO PRODUCTOS
)
IS
begin
INSERT INTO USUARIOS
(cod_usuario, nombres, usuario, password)
VALUES
 (SEQ_COD_USUARIO.NEXTVAL, p_nombres, p_usuario, p_password);
end;
--UPDATE
CREATE OR REPLACE PROCEDURE SP_MODIFICAR_USUARIO
(p_cod_usuario number,
p_nombres IN varchar2,
p_usuario IN varchar2,
p_password IN varchar2
)
IS
BEGIN
UPDATE USUARIOS SET
  nombres = p_nombres,
  usuario = p_usuario,
  password = p_password
  WHERE cod_usuario = p_cod_usuario;
end;
--DELETE
CREATE OR REPLACE PROCEDURE SP_ELIMINAR_USUARIO
(p_cod_usuario IN number)
IS
BEGIN
DELETE FROM USUARIOS WHERE cod_usuario = p_cod_usuario;
END;

/*PRODUCTOS*/
--INSERT
CREATE OR REPLACE PROCEDURE SP_INSERTAR_PRODUCTO
(p_cod_categoria IN number,
p_cod_sub_categoria IN number,
p_nom_producto IN varchar2,
p_descripcion IN varchar2,
p_oferta IN varchar2,
p_precio_oferta IN number,
p_precio_normal IN number,
p_fecha_ing IN varchar2,
 (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion,
  oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube,
  banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado)
 VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, p_cod_categoria, p_cod_sub_categoria, p_nom_producto, p_descripcion,
  p_oferta, p_precio_oferta, p_precio_normal, p_fecha_ing, p_img_producto, p_video_youtube,
  p_banner_grande, p_banner_oferta_grande, p_banner_chico, p_banner_oferta_chica, p_estado);
end;
--UPDATE
CREATE OR REPLACE PROCEDURE SP_MODIFICAR_PRODUCTO
(p_cod_producto IN number,
p_cod_categoria IN number,
p_cod_sub_categoria IN number,
p_nom_producto IN varchar2,
p_descripcion IN varchar2,
p_oferta IN varchar2,
p_precio_oferta IN number,
p_precio_normal IN number,
p_fecha_ing IN varchar2,
p_img_producto IN varchar2,
p_video_youtube IN varchar2,
p_banner_grande IN varchar2,
p_banner_oferta_grande IN varchar2,
p_banner_chico IN varchar2,
p_banner_oferta_chica IN varchar2,
p_estado char
)
IS
BEGIN
UPDATE PRODUCTOS SET
  cod_categoria = p_cod_categoria,
  cod_sub_categoria = p_cod_sub_categoria,
  nom_producto = p_nom_producto,
  descripcion = p_descripcion,
  oferta = p_oferta,
  precio_oferta = p_precio_oferta,
  precio_normal = p_precio_normal,
  fecha_ing = p_fecha_ing,
  img_producto = p_img_producto,
  video_youtube = p_video_youtube,
  banner_grande = p_banner_grande,
  banner_oferta_grande = p_banner_oferta_grande,
  banner_chico = p_banner_chico,
  banner_oferta_chica = p_banner_oferta_chica,
  estado = p_estado
  WHERE cod_producto = p_cod_producto;
end;
--DELETE
CREATE OR REPLACE PROCEDURE SP_ELIMINAR_PRODUCTO
(p_cod_producto IN number)
IS
BEGIN
DELETE FROM PRODUCTOS WHERE cod_producto = p_cod_producto;
END;

/*CONTACTO*/
--INSERT
CREATE OR REPLACE PROCEDURE SP_INSERTAR_CONTACTO
(p_nombres IN varchar2,
p_apellidos IN varchar2,
p_email IN varchar2,
p_comentarios varchar2,
p_estado IN char)
IS
BEGIN
INSERT INTO CONTACTO(cod_contacto, nombres, apellidos, email, comentarios, estado)
VALUES(SEQ_COD_CONTACTO.NEXTVAL, p_nombres, p_apellidos, p_email, p_comentarios, p_estado);
END;

--DELETE
CREATE OR REPLACE PROCEDURE SP_ELIMINAR_CONTACTO
(p_cod_contacto IN NUMBER)
IS
BEGIN
DELETE FROM CONTACTO WHERE cod_contacto = p_cod_contacto;
END;

/*COMPRAS*/
--INSERT
CREATE OR REPLACE PROCEDURE SP_INSERTAR_COMPRA
(p_cod_cliente IN number,
  p_total_neto IN number,
  p_fecha IN varchar2)
IS
BEGIN
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha)
VALUES (SEQ_COD_COMPRA.NEXTVAL, p_cod_cliente, p_total_neto, p_fecha);
END;