INSERT INTO Autor (nombre,telefono,email,pais) VALUES ('Breitner Mora','123456','breitner@gmail.com','Colombia');
INSERT INTO Autor (nombre,telefono,email,pais) VALUES ('Paula Ospina','79554','paula@gmail.com','Colombia');
INSERT INTO Autor (nombre,telefono,email,pais) VALUES ('Oscar murillo','954475','oscar@gmail.com','Colombia');
INSERT INTO Autor (nombre,telefono,email,pais) VALUES ('Monica Pino','3325484','monica@gmail.com','Colombia');
INSERT INTO Autor (nombre,telefono,email,pais) VALUES ('Andres Cardona','77518528','andres@gmail.com','Colombia');
------------------------------------------------------------------
INSERT INTO Producto (nombre,marca,precio) VALUES ('SAMSUNG TV 4K','SAMSUNG',2000000.56);
INSERT INTO Producto (nombre,marca,precio) VALUES ('SONIC 5YD33','SONIC',5000000.80);
INSERT INTO Producto (nombre,marca,precio) VALUES ('LG TV 4K','LG',858000.30);
INSERT INTO Producto (nombre,marca,precio) VALUES ('IPHONE 12 PRO MAX','APPLE',6000000.30);
INSERT INTO Producto (nombre,marca,precio) VALUES ('DELL NITRON','DELL',8000000.90);

-----------------------------------------------------------------

INSERT INTO Caracteristica (nombre,detalles) VALUES ('Dimensiones y definicion','Televisor ultimo modelo, 32 pulgadas, definicion 4K');

INSERT INTO Caracteristica (nombre,detalles) VALUES ('Gama','Equipo de sonido con la utima tegnologia 5g');

INSERT INTO Caracteristica (nombre,detalles) VALUES ('Camara','Tiene una camara de ultima generacion 50px');

INSERT INTO Caracteristica (nombre,detalles) VALUES ('Procesador','Procesador intelCore i7 decima generacion');
-----------------------------------------------------------------------

INSERT INTO Producto_Caracteristica (idProducto,idCaracteristica) VALUES (1,1);
INSERT INTO Producto_Caracteristica (idProducto,idCaracteristica) VALUES (2,2);
INSERT INTO Producto_Caracteristica (idProducto,idCaracteristica) VALUES (3,1);
INSERT INTO Producto_Caracteristica (idProducto,idCaracteristica) VALUES (4,3);
INSERT INTO Producto_Caracteristica (idProducto,idCaracteristica) VALUES (5,4);

