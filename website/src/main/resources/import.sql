

INSERT INTO person (id, name, lastname, phone) VALUES (1, 'Armando', 'Cordova', '980415200');
INSERT INTO address (id, lat, lng, geohash, address, active, person_id) VALUES (1, 123123123, 1231231231, 'asfasdfasf', 'glgnfdf fgdhdghfdghfdgh', true, 1);
INSERT INTO user (id, username, password, superuser, active, person_id) VALUES (1, 'acordova', 'acordova', true, true, 1);;

INSERT INTO product_type (id, name, active) VALUES (1, 'Abrigos', true);
INSERT INTO product_type (id, name, active) VALUES (2, 'Gorros', true);
INSERT INTO product_type (id, name, active) VALUES (3, 'Mantas', true);
INSERT INTO product_type (id, name, active) VALUES (4, 'Otros', true);

INSERT INTO product (id, name, description, price, active, product_type_id) VALUES  (1, 'Chompa de Alpaca', 'Bella chompa de alpaca, modelo 2017', 80, true, 1);
INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (2, 'Chompa de Vicuña Marron ', 'Chompa de hombre tejido con fibra de alpaca, con bordado de las lineas de nazca', 110, true, 1, 'http://i63.tinypic.com/25gsz0m.jpg', 120);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (3, 'Guantes de Alpaca Plomo Oscuro', 'Guantes de color plomo oscuro para hombre tejido con fibra de alpaca', 35, true, 4, 'http://i64.tinypic.com/2r78pqg.jpg', 100);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (4, 'Guantes de Vicuña Plomo Claro', 'Guantes de color plomo claro para hombre', 35, true, 4, 'http://i66.tinypic.com/vct536.jpg', 90);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (5, 'Chompa de Alpaca Marron con Blanco', 'Abrigo para Mujer de color marron con blanco y bolsillos con capucha', 130, true, 1, 'http://i66.tinypic.com/24gizhj.jpg', 67);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (6, 'Chompa de Alpaca Marron', 'Abrigo para Mujer de color marron entero, cuello "V"', 90, true, 1, 'http://i66.tinypic.com/ivisco.jpg', 75);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (7, 'Chompa de Alpaca Marron manga acero', 'Bello abrigo de color marron con motivos andinos de confexion mixta de mangas cortas', 80, true, 1, 'http://i65.tinypic.com/16217qg.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (8, 'Guantes de Alpaca Plomo Claro', 'Guantes para mujer de color plomo claro', 65, true, 4, 'http://i63.tinypic.com/121ppfs.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (9, 'Chompa de Vicuña Marron Claro', 'Chompa para mujer de color marron claro y mangas largas con cuello "V"', 75, true, 1, 'http://i68.tinypic.com/o7k5ms.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (10, 'Guantes de Alpaca Beis', 'Guantes para hombre de color beis con motivos andinos de confexion mixta', 25, true, 4, 'http://i67.tinypic.com/wcl6vk.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (11, 'Mitones de Alpaca Beis', 'Guantes tipo mitones para mujer de color beis ', 65, true, 4, 'http://i63.tinypic.com/jj8fwl.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (12, 'Mitones de Alpaca Blanco', 'Guantes tipo mitones para mujer de color blanco', 65, true, 4, 'http://i64.tinypic.com/315bzhz.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (13, 'Abrigo de Alpaca tipo Poncho Marron', 'Abrigo tipo poncho de color marron para mujer', 80, true, 1, 'http://i66.tinypic.com/2laq6c1.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (14, 'Chuyo de Alpaca Marron claro', 'Chuyo de alpaca con forro polar de color marron ', 45, true, 2, 'http://i65.tinypic.com/sz8i3b.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (15, 'Chuyo de Alpaca Negro y Blanco', 'Chuyo de alpaca negro y blanco con motivos andinos', 35, true, 2, 'http://i67.tinypic.com/296ej69.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (16, 'Gorro de Alpaca Plomo y blanco', 'Gorro de color blanco y plomo con motivos andinos para mujer', 75, true, 2, 'http://i67.tinypic.com/296ej69.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (17, 'Poncho de Vicuña Marron claro y oscuro', 'Poncho tricolor con base marron para mujer', 60, true, 1, 'http://i68.tinypic.com/2mql2fs.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (18, 'Chuyo de Vicuña Amarillo claro', 'Chuyo de alpaca de color amarillo claro con bordes negros y motivos andinos', 35, true, 2, 'http://i63.tinypic.com/68e93r.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (19, 'Chuyo de Vicuña Negro y Beis', 'Chuyo de vicuña negro y beis con motivos andinos', 35, true, 2, 'http://i64.tinypic.com/16b0y9u.jpg', 50);
  INSERT INTO product (id, name, description, price, active, product_type_id, image, stock) VALUES  (20, 'Poncho de Vicuña Beis', 'Poncho de vicuña color beis para mujer', 80, true, 1, 'http://i63.tinypic.com/20ars6h.jpg', 50);

  UPDATE product_type SET name = 'Mantas', active = false WHERE id = 3;