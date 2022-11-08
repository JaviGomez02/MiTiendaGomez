create database CarritoCompra;

GRANT ALL PRIVILEGES ON CarritoCompra.* TO 'gomez'@'%' identified by 'javi';

create table CarritoCompra.USUARIO (
	nickname VARCHAR(50),
	nombre VARCHAR(50),
	apellidos VARCHAR(50),
	email VARCHAR(50),
	contrasena VARCHAR(50),
	fecha_nac DATE,
	genero VARCHAR(50),
	es_admin VARCHAR(50)
);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('Javi', 'Javi', 'Gomez', 'javi@gmail.com', '3e5f2ce4f1d29846c7c2478679be4f3d', '2002-05-02', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('xadame0', 'Xerxes', 'Adame', 'xadame0@noaa.gov', 'abfde839bcd8f4e609b0d6eed93d64b1', '1979-03-08', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('sfedder1', 'Sonnie', 'Fedder', 'sfedder1@prnewswire.com', '815236005f54b502953912883a60ab5d', '1996-01-15', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('ccovelle2', 'Camila', 'Covelle', 'ccovelle2@seattletimes.com', '253ab4ed52a3089589bec6c804b02e28', '2013-05-07', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('rminchella3', 'Rollie', 'Minchella', 'rminchella3@telegraph.co.uk', 'e1ca1a23bed59d68c479d09984f52b42', '2017-09-23', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('lrasp4', 'Leroi', 'Rasp', 'lrasp4@yellowbook.com', '6000c9b6f2feed7eefbd75adf16ea788', '2001-08-22', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('lmcmoyer5', 'Lyman', 'McMoyer', 'lmcmoyer5@soup.io', 'be055d05f6bbb7374e9cc15975a99699', '2001-12-29', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('tlatour6', 'Tibold', 'Latour', 'tlatour6@nba.com', 'a8049398a6c34e7d1229c6393f17e770', '2019-09-03', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('sandriulis7', 'Simon', 'Andriulis', 'sandriulis7@icq.com', '765a2805cf6262e1a3a2c81955b9dff0', '2010-12-03', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('aswetland8', 'Ancell', 'Swetland', 'aswetland8@jiathis.com', 'd2e9f672b2560c52f2970015e038c132', '1994-09-06', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('breichelt9', 'Bartolemo', 'Reichelt', 'breichelt9@wikia.com', '532e5505fd57cbe6abf2df763467b654', '1976-04-17', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('dnoara', 'Dorthea', 'Noar', 'dnoara@nps.gov', 'abe86fc33752068871aa1beceeaf2791', '1997-05-03', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('ecrutb', 'Etheline', 'Crut', 'ecrutb@mediafire.com', '2d4dc117594bab6442232c9e218f581b', '1982-11-05', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('rdoddemeadec', 'Reidar', 'Doddemeade', 'rdoddemeadec@icio.us', 'f65c72a29ed44cd479c501295f2a2e04', '1985-10-18', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('plandellsd', 'Patricia', 'Landells', 'plandellsd@parallels.com', '6c94cb23a3899fb3a560d8af337ef5c1', '1971-03-13', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('sharme', 'Sara', 'Harm', 'sharme@simplemachines.org', '5ba70be692b0286cc2aa5da740ccaa52', '2015-04-11', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('epartonf', 'Elfreda', 'Parton', 'epartonf@hexun.com', '24481b67984e35ae1127eee42838c915', '1999-01-23', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('ncoupmang', 'Nedda', 'Coupman', 'ncoupmang@economist.com', '9207ed7ff3917da31da8d70c268e6091', '1980-12-02', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('skamiyamah', 'Sherilyn', 'Kamiyama', 'skamiyamah@unicef.org', '013e0eef0c59b048d98d7c16ddc7d5a4', '2018-02-27', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('snewcomeni', 'Sutherland', 'Newcomen', 'snewcomeni@fda.gov', '3a523b691d44ce631cd9e1dd5fdd904b', '1971-07-09', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('hkayj', 'Hanna', 'Kay', 'hkayj@vistaprint.com', 'a6743565834f9bbb76a816f9b0e80426', '2014-06-05', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('rlavallk', 'Rodrique', 'Lavall', 'rlavallk@bigcartel.com', '7ef6ab67cb86200dd5d593e044c79702', '1970-01-26', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('gprestnerl', 'Griffie', 'Prestner', 'gprestnerl@google.pl', 'eaa6aa5e62dc886307f7f89c08c033c3', '1982-06-02', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('jdenisetm', 'Janelle', 'Deniset', 'jdenisetm@is.gd', '9273d8d075c8a15d6d50451105090015', '1978-11-25', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('bwillmettn', 'Bethany', 'Willmett', 'bwillmettn@storify.com', 'a7faf49dcb17bbffdd6f6b11ed17f392', '2000-11-20', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('mattoco', 'Mathew', 'Attoc', 'mattoco@nsw.gov.au', '00bc98113f61b800b53f38baebc60e94', '2008-11-11', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('hashleyp', 'Huberto', 'Ashley', 'hashleyp@godaddy.com', 'fc6019b42b975b2b69f38d86f5dfb757', '2000-04-25', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('lwilderspoonq', 'Livvyy', 'Wilderspoon', 'lwilderspoonq@bbc.co.uk', '20f47ddfc09b685a9ffaec97f6debbb7', '2000-12-30', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('kbrokr', 'Kerry', 'Brok', 'kbrokr@youku.com', 'c5c2de9f0ee41450cf5799d3b5967514', '2011-11-14', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('pcattericks', 'Patton', 'Catterick', 'pcattericks@dedecms.com', '2f9104cafefdb9a22b40933b9f1f8573', '1990-11-05', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('wleightont', 'Wright', 'Leighton', 'wleightont@tripod.com', '4d6bc5e124639a5fb9ab412bcfdabbac', '1978-01-20', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('eugolottiu', 'Euell', 'Ugolotti', 'eugolottiu@va.gov', 'f612df27d50bebaa5b693f63d59a6127', '1980-10-31', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('taddymanv', 'Tiphanie', 'Addyman', 'taddymanv@com.com', '6b04299987c545a83a18dd738c417169', '2018-07-25', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('dhelliwellw', 'Dionne', 'Helliwell', 'dhelliwellw@ezinearticles.com', '987d8cdf4f86ad8900b6228fdf8b4802', '1973-03-21', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('vlaurenzx', 'Valeda', 'Laurenz', 'vlaurenzx@cafepress.com', '337a018073689385391e7f244e151b57', '1976-01-24', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('cyitzovitzy', 'Cullin', 'Yitzovitz', 'cyitzovitzy@1688.com', 'f89a73eb0c250d54c0a15e381348768d', '1985-06-01', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('wchansonnauz', 'Winifield', 'Chansonnau', 'wchansonnauz@liveinternet.ru', 'b074f2b9928fef7e79ea459a419eb8dc', '2005-03-22', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('jspowage10', 'Jessie', 'Spowage', 'jspowage10@storify.com', '7ca25d9ed6fda10f63f27e976116a06f', '2008-08-01', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('nfawltey11', 'Nelia', 'Fawltey', 'nfawltey11@mtv.com', '48105552aaa511e814a2e15cfa19c72f', '1982-04-07', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('dribchester12', 'Dino', 'Ribchester', 'dribchester12@sciencedaily.com', '13caa33d8251e11000a5e8336b0cb6bc', '2019-06-07', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('rrothwell13', 'Reidar', 'Rothwell', 'rrothwell13@house.gov', 'b27cf4b4cea44df7c80ee1ebb3ea7ada', '2017-02-08', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('tloudiane14', 'Trueman', 'Loudiane', 'tloudiane14@hugedomains.com', '530958fca20cfd3a3d114ef111dd4b97', '2004-07-29', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('dsutherington15', 'Dulci', 'Sutherington', 'dsutherington15@omniture.com', '36f4efa4b1b3145ae8d38714e51f7bf9', '2003-06-11', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('tchaff16', 'Trudi', 'Chaff', 'tchaff16@foxnews.com', '094d9a4634839a3bce1c6a90f558e5fa', '2014-11-25', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('beastlake17', 'Bobbette', 'Eastlake', 'beastlake17@newyorker.com', 'b39ccfe81f1cad8bff43b15ed2303596', '2018-06-25', 'F', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('lfishleigh18', 'Laird', 'Fishleigh', 'lfishleigh18@meetup.com', 'bf14f4e82374c67d8b6c7cc7f50b8568', '2016-09-22', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('oframpton19', 'Orbadiah', 'Frampton', 'oframpton19@odnoklassniki.ru', '2dc079c67f8528f474001b2784459214', '2020-02-19', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('lbleas1a', 'Liv', 'Bleas', 'lbleas1a@blinklist.com', 'dd312f60cab417f97d9d1507e912cbde', '2008-11-04', 'F', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('aclayfield1b', 'Augy', 'Clayfield', 'aclayfield1b@dell.com', 'b245a470c60520e04ce23a2af9bd9d5c', '1990-10-19', 'M', false);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('bgrundon1c', 'Brenden', 'Grundon', 'bgrundon1c@gov.uk', 'b153d03c6f2e1a3366aaf8aff6ae7428', '1973-02-10', 'M', true);
insert into CarritoCompra.USUARIO (nickname, nombre, apellidos, email, contrasena, fecha_nac, genero, es_admin) values ('gpierse1d', 'Gerrilee', 'Pierse', 'gpierse1d@nih.gov', 'ae2cefc539a6adbc3358ca0c0e7688f1', '1971-02-21', 'F', true);
