INSERT INTO city(descripcion, name) VALUES
('Situada en España', 'Barcelona'),
('Situada en Italia', 'Roma'),
('Situada en Francia', 'Marsella'),
('Situada en isla de Malta', 'Malta'),
('Situada en Reino Unido', 'Londres'),
('Situada en Alemania', 'Berlin'),
('Situada en Grecia', 'Atenas');
INSERT INTO ship(capacity, length, name) VALUES
('1582', '786', 'Eos'),
('1145', '693', 'Helios'),
('2308', '1723', 'Venus'),
('1189', '841', 'Aeolus'),
('1960', '936', 'Naglfar');
INSERT INTO room(capacity,ship_id) VALUES
("2",1),
("3",1),
("4",1),
("5",1),
("3",2),
("2",2),
("1",2),
("2",3),
("3",3),
("4",3);
INSERT INTO tip(description,city_id) VALUES
("Visitar la Sagrada Familia",1),
("Visitar el coliseo",2),
("Probar las crepes",3),
("Visitar los distintos castillos en acantalidos",4),
("Cambiar la moneda",5),
("Visitar el muro de Berlin",6),
("Visitar el partenon",7);
INSERT INTO trip(start,end,name,ship_id) VALUES 
("2020-02-15","2020-02-22","Eos TOUR",1),
("2020-01-10","2020-01-21","Eos TOUR",2),
("2020-04-15","2020-04-22",Venus TOUR",3);
INSERT INTO scale(start,end,city_id,trip_id) VALUES
("2020-02-15","2020-02-17",1,1),
("2020-02-17","2020-02-19",4,1),
("2020-02-19","2020-02-21",3,1),
("2020-03-15","2020-03-17",1,2),
("2020-03-17","2020-03-19",5,2),
("2020-03-19","2020-03-21",4,2),
("2020-04-15","2020-04-17",6,3),
("2020-04-17","2020-04-19",5,3),
("2020-04-19","2020-04-21",2,3);
INSERT INTO service(name,description,price,ship_id) VALUES
("spavolution","disfruta de un spa o de un masaje",14.99,1),
("piscina","piscina al aire libre",0,1),
("padelista","alquiler de pistas de padel y material",4.99,1),
("gran muralla","restaurante chino",19.95,2),
("titto´s","restaurante italiano",19.95,3),
("Maruzzella","comida rapida",12.99,4),
("wok","restaurante chino",15.95,4),
("souvenirs shop","tienda de regalos",19.95,3),
("casino","ruleta, poker, blackjack, etc");
INSERT INTO user(dni,email,enabled,first_name,last_name,password,phone,role) VALUES
("11111111A","admin@okto.com","OKTO","OKTO","okto","111111111","ADMIN"),
("11111111B","manager@okto.com","OKTO","OKTO","okto","111111112","MANAGER"),
("11111111C","user@okto.com","OKTO","OKTO","okto","111111113","USER"),
("11111111D","alvaro@okto.com","Alvaro","Braza","okto","111111114","USER"),
("11111111E","rodrigo@okto.com","Rodrigo","Sanabria","okto","111111115","USER"),
("11111111F","felix@okto.com","Felix","Periacho","okto","111111117","USER"),
("11111111G","borja@okto.com","Borja","OKTO","okto","111111118","USER"),
("11111111H","pedro@okto.com","Pedro","Manager","okto","111111119","MANAGER"),
("11111111I","admin2@okto.com","OKTO2","OKTO2","okto","111111120","ADMIN");
INSERT INTO user_trip(room_id,trip_id,user_id) VALUES
(1,1,4),
(1,1,5),
(5,2,6),
(5,2,7),
(9,3,5);
INSERT INTO purchase(price,user_trip) VALUES
(45.36,1),
(21.87,2),
(140.63,3),
(98.24,4);
INSERT INTO shop_line(amount,price,shopline_id) VALUES
(2,3.99,1),
(2,1.99,2),
(4,0.5,3),
(2,12.99,4),
(2,7.50,5),
(1,2.99,6),
(2,3.99,7),
(2,14.05,8),
(1,24.99,9),
(1,2.70,10),
(3,6.95,11);