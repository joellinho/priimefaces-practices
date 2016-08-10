CREATE TABLE CATEGORIA_PRODUCTOS(
  cod_categoria NUMBER NOT NULL,
  nom_categoria varchar2(250) DEFAULT NULL,
  img_categoria varchar2(200) DEFAULT NULL,
  estado char(1) DEFAULT NULL,
  constraint "pk_categoria_productos" PRIMARY KEY (cod_categoria)
) TABLESPACE ts_01;

CREATE TABLE CLIENTES (
  cod_cliente NUMBER NOT NULL,
  nombres varchar2(200) DEFAULT NULL,
  apellidos varchar2(200) DEFAULT NULL,
  direccion varchar2(200) DEFAULT NULL,
  telefono varchar2(20) DEFAULT NULL,
  email varchar2(200) DEFAULT NULL,
  clave varchar2(20) DEFAULT NULL,
  fecha_nac varchar2(10) DEFAULT NULL,
  estado char(1) DEFAULT 'A',
  constraint "ck_cli_est_AD" check (estado IN ('A', 'D')),
  constraint "pk_clientes" PRIMARY KEY (cod_cliente)
) TABLESPACE ts_01;

CREATE TABLE CONTACTO (
  cod_contacto NUMBER NOT NULL,
  nombres VARCHAR2(200) DEFAULT NULL,
  apellidos VARCHAR2(200) DEFAULT NULL,
  email VARCHAR2(200) DEFAULT NULL,
  comentarios VARCHAR2(500),
  estado CHAR(1) DEFAULT 'A',
  constraint "ck_cont_est_AD" check (estado IN ('A', 'D')),
  constraint "pk_contacto" PRIMARY KEY (cod_contacto)
) TABLESPACE ts_01;

CREATE TABLE USUARIOS (
  cod_usuario number,
  nombres varchar2(50),
  usuario varchar2(30),
  password varchar2(30),
  constraint"uq_usuario" unique(usuario),
  constraint "pk_usuarios" primary key (cod_usuario)
) TABLESPACE ts_01;

CREATE TABLE SUBCATEGORIA_PRODUCTOS (
  cod_sub_categoria NUMBER NOT NULL,
  cod_categoria NUMBER DEFAULT NULL,
  nom_sub_categoria VARCHAR2(200) DEFAULT NULL,
  img_sub_categoria VARCHAR2(200) DEFAULT NULL,
  estado CHAR(1) DEFAULT 'A',
  constraint "ck_subcat_est_AD" check (estado IN ('A', 'D')),
  constraint "pk_subcategoria_productos" primary key (cod_sub_categoria),
  constraint "fk_subcat_cod_cat" foreign key (cod_categoria) references CATEGORIA_PRODUCTOS(cod_categoria) on delete cascade
) TABLESPACE ts_01;

CREATE TABLE PRODUCTOS (
  cod_producto NUMBER NOT NULL,
  cod_categoria NUMBER DEFAULT NULL,
  cod_sub_categoria NUMBER DEFAULT NULL,
  nom_producto VARCHAR2(250) DEFAULT NULL,
  descripcion VARCHAR2(1000),
  oferta VARCHAR2(20) DEFAULT NULL,
  precio_oferta NUMBER(8,2) DEFAULT NULL,
  precio_normal NUMBER(8,2) DEFAULT NULL,
  fecha_ing VARCHAR2(20) DEFAULT NULL,
  img_producto VARCHAR2(200) DEFAULT NULL,
  video_youtube VARCHAR2(250) DEFAULT NULL,
  banner_grande VARCHAR2(5) DEFAULT NULL,
  banner_oferta_grande VARCHAR2(250) DEFAULT NULL,
  banner_chico VARCHAR2(5) DEFAULT NULL,
  banner_oferta_chica VARCHAR2(250) DEFAULT NULL,
  estado CHAR(1) DEFAULT 'A',
  constraint "ck_oferta_sino" check (oferta IN ('SI', 'NO')),
  constraint "ck_ban_gr_sino" check (banner_grande IN ('SI', 'NO')),
  constraint "ck_ban_ch_sino" check (banner_chico IN ('SI', 'NO')),
  constraint "ck_prod_est_AD" check (estado IN ('A', 'D')),
  constraint "pk_productos" PRIMARY KEY (cod_producto),
  constraint "fk_prod_cod_catego" foreign key (cod_categoria) references CATEGORIA_PRODUCTOS(cod_categoria) on delete cascade,
  constraint "fk_prod_cod_sub_cat" foreign key (cod_sub_categoria) references SUBCATEGORIA_PRODUCTOS(cod_sub_categoria) on delete cascade
) TABLESPACE ts_01;

CREATE TABLE GALERIA_PRODUCTOS (
  cod_galeria_producto NUMBER NOT NULL,
  cod_producto NUMBER DEFAULT NULL,
  img_galeria_producto VARCHAR2(250) DEFAULT NULL,
  estado char(1) DEFAULT 'A',
  constraint "ck_gal_est_AD" check (estado IN ('A', 'D')),
  constraint "pk_galeria_productos" PRIMARY KEY (cod_galeria_producto),
  constraint "fk_galeria_cod_prod" foreign key (cod_producto) references PRODUCTOS(cod_producto) on delete cascade
) TABLESPACE ts_01;

CREATE TABLE COMPRAS (
  cod_compra NUMBER NOT NULL,
  cod_cliente NUMBER NOT NULL,
  total_neto NUMBER(8,2) NOT NULL,
  fecha varchar(40) NOT NULL,
  constraint "pk_compras" PRIMARY KEY (cod_compra),
  constraint "fk_compras_cod_cli" foreign key (cod_cliente) references CLIENTES(cod_cliente) on delete cascade
) TABLESPACE ts_01;

--CREACION DE SECUENCIAS
CREATE SEQUENCE SEQ_COD_CATEGORIA;
CREATE SEQUENCE SEQ_COD_CLIENTE;
CREATE SEQUENCE SEQ_COD_COMPRA;
CREATE SEQUENCE SEQ_COD_CONTACTO;
CREATE SEQUENCE SEQ_COD_GALERIA_PRODUCTO;
CREATE SEQUENCE SEQ_COD_PRODUCTO;
CREATE SEQUENCE SEQ_COD_SUB_CATEGORIA;
CREATE SEQUENCE SEQ_COD_USUARIO;

--ISERCCION DE DATOS
--CATEGORIA_PRODUCTOS
INSERT INTO CATEGORIA_PRODUCTOS(cod_categoria, nom_categoria, img_categoria, estado)
  VALUES (SEQ_COD_CATEGORIA.NEXTVAL, 'Ropas', 'ropas.jpg', 'A');
INSERT INTO CATEGORIA_PRODUCTOS(cod_categoria, nom_categoria, img_categoria, estado)
  VALUES (SEQ_COD_CATEGORIA.NEXTVAL, 'Zapatos', 'zapatos.jpg', 'A');
INSERT INTO CATEGORIA_PRODUCTOS(cod_categoria, nom_categoria, img_categoria, estado)
  VALUES (SEQ_COD_CATEGORIA.NEXTVAL, 'Accesorios', 'accesorios.jpg', 'A');
INSERT INTO CATEGORIA_PRODUCTOS(cod_categoria, nom_categoria, img_categoria, estado)
  VALUES (SEQ_COD_CATEGORIA.NEXTVAL, 'Relojes', 'relojes.jpg', 'A');
INSERT INTO CATEGORIA_PRODUCTOS(cod_categoria, nom_categoria, img_categoria, estado)
  VALUES (SEQ_COD_CATEGORIA.NEXTVAL, 'Licores', 'licores.jpg', 'A');
INSERT INTO CATEGORIA_PRODUCTOS(cod_categoria, nom_categoria, img_categoria, estado)
  VALUES (SEQ_COD_CATEGORIA.NEXTVAL, 'Carros ', 'carros.jpg', 'A');
--SUBCATEGORIA_PRODUCTOS
 INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 1, 'Mujeres', 'ropa-mujeres.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 1, 'Varones', 'ropa-varones.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 1, 'Niños', 'ropa-ninos.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 2, 'Mujeres', 'zapato-mujeres.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 2, 'Varones', 'zapato-varones.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 2, 'Niños', 'zapato-ninos.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 3, 'Pulseras', 'pulseras.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 3, 'Collares', 'collares.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 3, 'Vinchas', 'vinchas.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 4, 'Mujeres', 'relojes-mujeres.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 4, 'Varones', 'relojes-varones.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 4, 'Relojes Pared', 'relojes-varios.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 5, 'Wisky', 'wisky.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 5, 'Vinos', 'vinos.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 6, 'Mitsubishi', 'mitsubishi.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 3, 'Gafas Para Mujeres', 'gafassol.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 3, 'Carteras', 'bolsos.jpg', 'A');
INSERT INTO SUBCATEGORIA_PRODUCTOS (cod_sub_categoria, cod_categoria, nom_sub_categoria, img_sub_categoria, estado) VALUES
 (SEQ_COD_SUB_CATEGORIA.NEXTVAL, 6, 'Lujo', 'autolujo.jpg', 'A');
--CLIENTES
INSERT INTO CLIENTES (cod_cliente, nombres, apellidos, direccion, telefono, email, clave, fecha_nac, estado) VALUES
 (SEQ_COD_CLIENTE.NEXTVAL, 'Carlos ', 'Ramos Castro', 'Av. Lima 1234 SMP', '23423434', 'carlos@hotmail.com', '123456', '28/05/1985', 'A');
INSERT INTO CLIENTES (cod_cliente, nombres, apellidos, direccion, telefono, email, clave, fecha_nac, estado) VALUES
 (SEQ_COD_CLIENTE.NEXTVAL, 'Juana', 'Rodriguez Rodriguez', 'La paz 234 Magdalena', '23423423', 'juana@hotmail.com', '123456', '08/02/1970', 'A');
INSERT INTO CLIENTES (cod_cliente, nombres, apellidos, direccion, telefono, email, clave, fecha_nac, estado) VALUES
 (SEQ_COD_CLIENTE.NEXTVAL, 'Patricia', 'Alcantara Ramos', 'Av. Consquistadores 123 Lima', '23452344', 'patricia@hotmail.com', '123456', '03/04/1980', 'A');
INSERT INTO CLIENTES (cod_cliente, nombres, apellidos, direccion, telefono, email, clave, fecha_nac, estado) VALUES
 (SEQ_COD_CLIENTE.NEXTVAL, 'Gustavo Cesar', 'Fernandez Sanchez', 'Urb. Santa Rosa', '945390770', 'Gustavo.27.92@hotmail.com', '123456', '27/09/1992', 'A');
INSERT INTO CLIENTES (cod_cliente, nombres, apellidos, direccion, telefono, email, clave, fecha_nac, estado) VALUES
 (SEQ_COD_CLIENTE.NEXTVAL, 'Gustavo', 'Fernandez Sanchez', 'Peru', '999999999', 'unac', 'unac', '27/09/1992', 'A');
--COMPRAS
 INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 1, 1200, '11:10 p.m. 18/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 2, 785.4, '01:10 p.m. 18/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 3, 723.52, '01:09 p.m. 18/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 4, 547.4, '09:52 a.m. 20/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 4, 458.15, '11:03 a.m. 20/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 3, 909.16, '12:22 p.m. 20/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 2, 60275.88, '12:32 p.m. 21/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 1, 1323.28, '12:50 p.m. 21/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 3, 942.48, '12:51 p.m. 21/09/2012');
INSERT INTO COMPRAS (cod_compra, cod_cliente, total_neto, fecha) VALUES
 (SEQ_COD_COMPRA.NEXTVAL, 5, 1035.3, '12:54 p.m. 21/09/2012');
--CONTACTO
INSERT INTO CONTACTO (cod_contacto, nombres, apellidos, email, comentarios, estado) VALUES
 (SEQ_COD_CONTACTO.NEXTVAL, 'Juan', 'Torres', 'jTorres@hotmail.com', 'Esta es una prueba...', 'A');
INSERT INTO CONTACTO (cod_contacto, nombres, apellidos, email, comentarios, estado) VALUES
 (SEQ_COD_CONTACTO.NEXTVAL, 'Gustavo', 'Fernandez', 'Gustavo.27.92@hotmail.com', 'Hello!', 'A');
--PRODUCTOS
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 1, 1, 'Blusa con Brillos', 'descripcion', 'SI', 135, 150, '29/03/2012', 'blusamujer.jpg', '6GFbnCdF6i0', 'SI', 'bannerblusachica.jpg', 'SI', 'bannerblusamujer.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 1, 1, 'Pantalon jean', 'Pantalon jeanPantalon jeanPantalon jeanPantalon jeanPantalon jean ', 'NO', 0, 250, '31/03/2012', 'pantalonmujer.jpg', 'QKm5zN7jUPU', 'SI', 'bannerpantalonmujer.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 3, 16, 'Gafas Oscuras', 'gafas oscuras sin ralladuras ', 'NO', 0, 100, '31/03/2012', 'gafamujer.jpg', 'NHjZcxiu9xk', 'SI', 'bannergafamujer.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 1, 2, 'Camisa de Vestir', 'descripcion', 'SI', 102, 120, '29/03/2012', 'camisavaron.jpg', 'ZZTQd4-bT6A', 'SI', 'bannercamisavaron.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 1, 3, 'Conjunto', 'Conjunto jean camisas gran variedad Conjunto jean camisas gran variedad Conjunto jean camisas gran variedad Conjunto jean camisas gran variedad ', 'NO', 0, 350, '31/03/2012', 'ropaninos.jpg', 'tW9jVvBpBCM', 'NO', '', 'SI', 'bannerropaninos.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 1, 3, 'Pantalon Corduroy', 'Pantalon turquesa.', NULL, NULL, 50, '02/02/2012', 'pantalon-coduroy-ninos.jpg', 'QKm5zN7jUPU', 'NO', '', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 3, 17, 'Carteras de Cuero', 'Carteras de Cuero Carteras de Cuero Carteras de Cuero Carteras de Cuero Carteras de CueroCarteras de Cuero ', 'SI', 150, 200, '29/03/2012', 'cartera.jpg', 'QL5hhx_uVIM', 'SI', 'banneraccesoriocartera.jpg', 'SI', 'banneraccesoriocartera.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 2, 4, 'Zapatos de vestir', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In a leo at metus facilisis lobortis scelerisque eget elit. Nam in nibh velit. Fusce varius pharetra enim pharetra pellentesque.', 'SI', 180, 200, '30/03/2012', 'zapatomujer.jpg', 'MOnvyY-xwog', 'NO', '', 'SI', 'bannerzapatomujer.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 2, 4, 'Zapatillas Varon', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In a leo at metus facilisis lobortis scelerisque eget elit. Mauris diam turpis, sollicitudin in tincidunt vestibulum, mollis id nisl. Nam in nibh velit. Fusce varius pharetra enim pharetra pellentesque.', 'SI', 180, 200, '29/03/2012', 'zapatillasvaron.jpg', 'KqA1fpTdLvU', 'SI', 'zapatillasvaron.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 2, 4, 'Zapatillas NIKE', 'Zapatillas NIKE rosas femenino, ideales para running, también disponibles en colores celeste y purpura.', 'NO', 0, 250, '31/03/2012', 'zapatillasmujer.jpg', '1zJbgleyccg', 'NO', '', 'SI', 'bannerszapaillasmujer.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 2, 6, 'Zapatillas Niños', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In a leo at metus facilisis lobortis scelerisque eget elit. Mauris diam turpis, sollicitudin in tincidunt vestibulum, mollis id nisl. ', 'SI', 25, 50, '29/03/2012', 'zapatillasninos.jpg', 'RhzdyKKwDr0', 'NO', '', 'SI', 'zapaillasninos.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 2, 6, 'Botas para niños', 'descripcion', 'NO', 0, 70, '02/02/2012', 'botas-ninos.jpg', 'It6iesW0iss', 'NO', '', 'NO', '', 'A');
 INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 3, 8, 'Collares de Plata', 'Collares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de PlataCollares de Plata ', 'SI', 180, 200, '31/03/2012', 'collarplata.jpg', '_NVu701Lvv8', 'SI', 'bannercollaresplata.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 3, 8, 'Collares de Oro', 'Collares de Oro Collares de OrovCollares de OroCollares de Oro vCollares de Oro ', 'SI', 180, 200, '29/03/2012', 'joyasmujer.jpg', 'lBB9lHJ_qdo', 'SI', 'bannerjoyasmujer.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 3, 7, 'Vincha de Metal', 'Vincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de MetalVincha de Metal ', 'SI', 18, 20, '31/02/2012', 'accesoriovinchametal.jpg', '', 'NO', '', 'SI', 'banneraccesoriovinchametal.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 3, 9, 'Vichas de Plastico', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In a leo at metus facilisis lobortis scelerisque eget elit. Mauris diam turpis, sollicitudin in tincidunt vestibulum, mollis id nisl. ', 'SI', 18, 20, '29/03/2012', 'accesoriovincha.jpg', '', 'SI', 'banneraccesoriovincha.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 4, 12, 'Reloj Pared', 'Reloj de pared con imagen de Hulk', 'SI', 12, 100, '12/04/2012', 'relojpared.jpg', '', 'SI', 'bannerrelojpared.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 4, 10, 'Reloj Vestir', 'bannerpolosvaron.jpg bannerpolosvaron.jpg bannerpolosvaron.jpg bannerpolosvaron.jpg ', 'NO', 0, 150, '29/03/2012', 'relojmujer.jpg', '', 'NO', '', 'SI', 'bannerrelojmujer.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 4, 11, 'Reloj Sport', 'bannerpolosvaron.jpg bannerpolosvaron.jpg bannerpolosvaron.jpg bannerpolosvaron.jpg ', 'SI', 225, 250, '29/03/2012', 'relojvaron.jpg', '', 'SI', 'bannerrelojvaron.jpg', 'NO', '', 'A');
 INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 5, 13, 'Chivas Regal', 'Texto de prueba ', 'SI', 130, 180, '10/03/2012', 'wiskichiva.jpg', '', 'SI', 'bannewiski.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 3, 7, 'Pulsera de Fantasia', 'Esto es una prueba ', 'SI', 152, 250, '31/03/2012', 'pulsera.jpg', '', 'NO', '', 'SI', 'bannerpulcera.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 6, 15, 'Mitsubishi Lancer', 'asdasd ', 'NO', 0, 325555, '27/09/2012', 'lancer.jpg', '', 'SI', 'bannermitsu.jpg', '', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 1, 1, 'Vestido de Seda Persa', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In a leo at metus facilisis lobortis scelerisque eget elit. In vehicula diam aliquam dui viverra gravida. Etiam scelerisque porttitor tincidunt.', 'NO', 0, 125, '10/03/2012', 'ropamujervestido.jpg', '', 'SI', 'bannerropamujer.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 5, 14, 'vinos aromaticos', 'xdfnfhymn ', 'NO', 0, 100, '29/03/2012', 'licorvino.jpg', '', 'SI', 'bannervinos.jpg', 'NO', '', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 1, 2, 'Polo Billabong', 'polo billabong de algodon data polo billabong de algodon data polo billabong de algodon datapolo billabong de algodon data ', 'SI', 80, 100, '29/03/2012', 'polovaron.jpg', 'P0G_2tiivxE', 'NO', '', 'SI', 'bannerpolosvaron.jpg', 'A');
INSERT INTO PRODUCTOS (cod_producto, cod_categoria, cod_sub_categoria, nom_producto, descripcion, oferta, precio_oferta, precio_normal, fecha_ing, img_producto, video_youtube, banner_grande, banner_oferta_grande, banner_chico, banner_oferta_chica, estado) VALUES
 (SEQ_COD_PRODUCTO.NEXTVAL, 6, 18, 'Auto de lujo', 'Auto BMW Azul deportivo europeo de lujo, fecha de lanzamiento 10 Enero 2012', 'NO', 0, 50000, '31/03/2012', 'autolujo.jpg', 'GUnfDKSnRLs', 'SI', 'autodelujo.jpg', 'NO', '', 'A');

--GALERIA_PRODUCTOS
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 22, 'lancer1.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 22, 'lancer2.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 22, 'lancer3.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 4, 'lancer4.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 26, '02porschespeedsterlive2010.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 26, '05porschespeedsterlive2010.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 26, '09porschespeedsterlive2010.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 26, '10porschespeedsterlive2010.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 26, '20porschespeedsterlive2010.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 20, 'chivas1.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 20, 'chivas2.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 20, 'chivas4.jpg', 'A');
INSERT INTO GALERIA_PRODUCTOS (cod_galeria_producto, cod_producto, img_galeria_producto, estado) VALUES
 (SEQ_COD_GALERIA_PRODUCTO.NEXTVAL, 20, 'chivas5.jpg', 'A');

INSERT INTO USUARIOS(cod_usuario, nombres, usuario, password)
  VALUES(SEQ_COD_USUARIO.NEXTVAL, 'Gustavo Fernández', 'admin', 'admin');