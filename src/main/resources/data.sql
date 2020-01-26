
INSERT INTO city(id,version,description, name) VALUES
(1,1231223131,'Situada en España', 'Barcelona'),
(2,3231233123,'Situada en Italia', 'Roma'),
(3,1334543214,'Situada en Francia', 'Marsella'),
(4,3453453223,'Situada en isla de Malta', 'Malta'),
(5,3456323345,'Situada en Reino Unido', 'Londres'),
(6,6534542326,'Situada en Alemania', 'Berlin'),
(7,4352674553,'Situada en Grecia', 'Atenas');
INSERT INTO ship(id, version, name) VALUES
(1,12342136578,'Eos'),
(2,43455655654,'Helios'),
(3,43152341556,'Venus'),
(4,12451252315,'Aeolus'),
(5,45125451566,'Naglfar');
INSERT INTO room(id,version,capacity,ship_id) VALUES
(1,15376859045,2,1),
(2,12345234665,3,1),
(3,13452616223,4,1),
(4,13451451534,5,1),
(5,67465475643,3,2),
(6,23645654654,2,2),
(7,25463456345,1,2),
(8,87656556544,2,3),
(9,87453626436,3,3),
(10,8957698457,4,3);
INSERT INTO tip(id,version,description,city_id) VALUES
(1,34523544566,'Visitar la Sagrada Familia',1),
(2,54364563345,'Visitar el coliseo',2),
(3,34524342525,'Probar las crepes',3),
(4,65365424353,'Visitar los distintos castillos en acantalidos',4),
(5,76535463456,'Cambiar la moneda',5),
(6,34576575656,'Visitar el muro de Berlin',6),
(7,76754655433,'Visitar el partenon',7);
INSERT INTO trip(id,version,start,end,name,ship_id) VALUES
(1,43523452346,'2020-02-15','2020-02-22','Helios TOUR',1),
(2,54656345657,'2020-01-10','2020-01-21','Eos TOUR',2),
(3,54634563445,'2020-04-15','2020-04-22','Venus TOUR',3);
INSERT INTO service(id,version,dtype,name,description,price,ship_id) VALUES
(1,24535234656,'ocio','spavolution','disfruta de un spa o de un masaje',14.99,1),
(2,35463456456,'ocio','piscina','piscina al aire libre',0,1),
(3,67456774654,'deporte','padelista','alquiler de pistas de padel y material',4.99,1),
(4,56456545555,'comida','gran muralla','restaurante chino',19.95,2),
(5,67677676556,'comida','titto´s','restaurante italiano',19.95,3),
(6,78767867667,'comida','Maruzzella','comida rapida',12.99,4),
(7,67455426576,'comida','wok','restaurante chino',15.95,4),
(8,46576587667,'regalos','souvenirs shop','tienda de regalos',19.95,3),
(9,56768565356,'ocio','casino','ruleta, poker, blackjack, etc',4.99,2);
INSERT INTO scale(id,version,start,end,city_id,trip_id) VALUES
(1,12341235435,'2020-02-15','2020-02-17',1,1),
(2,11111232342,'2020-02-17','2020-02-19',4,1),
(3,11111111354,'2020-02-19','2020-02-21',3,1),
(4,11111124543,'2020-03-15','2020-03-17',1,2),
(5,11111435435,'2020-03-17','2020-03-19',5,2),
(6,11111111119,'2020-03-19','2020-03-21',4,2),
(7,23333453453,'2020-04-15','2020-04-17',6,3),
(8,65645645555,'2020-04-17','2020-04-19',5,3),
(9,76756766665,'2020-04-19','2020-04-21',2,3);
INSERT INTO user(id,version,dni,email,enabled,first_name,last_name,password,phone,role) VALUES
(1,23433333333,'11111111A',1,'admin@okto.com','OKTO','OKTO','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111111','ADMIN'),
(2,43523453444,'11111111B',1,'manager@okto.com','OKTO','OKTO','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111112','MANAGER'),
(3,56656565556,'11111111C',1,'user@okto.com','OKTO','OKTO','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111113','USER'),
(4,75757575757,'11111111D',1,'alvaro@okto.com','Alvaro','Braza','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111114','USER'),
(5,87878787787,'11111111E',1,'rodrigo@okto.com','Rodrigo','Sanabria','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111115','USER'),
(6,34333333333,'11111111F',1,'felix@okto.com','Felix','Periacho','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111117','USER'),
(7,56555555555,'11111111G',1,'borja@okto.com','Borja','OKTO','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111118','USER'),
(8,67676767676,'11111111H',1,'pedro@okto.com','Pedro','Manager','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111119','MANAGER'),
(9,89888997556,'11111111I',1,'admin2@okto.com','OKTO2','OKTO2','$2y$12$aaftVJZqjC.lpQksMHlkHePzGA92X1MBuudZXns.l9p9v4Yohr.Xm','111111120','ADMIN');
INSERT INTO user_trip(id,version,room_id,trip_id,user_id) VALUES
(1,12341234222,1,1,4),
(2,43544544444,1,1,5),
(3,56565655444,5,2,6),
(4,75755557775,5,2,7),
(5,87877787665,9,3,5);
INSERT INTO purchase(id,version,price,usertrip_id) VALUES
(1,12123412334,45.36,1),
(2,34563453643,21.87,2),
(3,67565557676,140.63,3),
(4,29292922999,98.24,4);
INSERT INTO shop_line(id,version,amount,price,shopline_id) VALUES
(1,12334523344,2,3.99,1),
(2,23454323454,2,1.99,2),
(3,63456323456,4,0.5,3),
(4,76543456345,2,12.99,4),
(5,45674567653,2,7.50,5),
(6,87655678332,1,2.99,6),
(7,09758768674,2,3.99,7),
(8,34578676567,2,14.05,8),
(9,98664657785,1,24.99,9),
(10,87553657676,1,2.70,10),
(11,35467567844,3,6.95,11);
