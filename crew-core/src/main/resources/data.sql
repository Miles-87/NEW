INSERT INTO Person(version,first_name,last_name,email,location,role,status) VALUES (0,'ADAM','mucha','mial@mail.com','Warszawa','admin','developer');
INSERT INTO Person(version,first_name,last_name,email,location,role,status) VALUES (0,'EWA','kowalksa','mial2@mail.com','Krakow','user','support');
INSERT INTO Person(version,first_name,last_name,email,location,role,status) VALUES (0,'Jurek','mickiewicz','mial3@mail.com','Rzeszow','user','technic');
INSERT INTO Person(version,first_name,last_name,email,location,role,status) VALUES (0,'Wojtek','rybak','mial4@mail.com','Zakopane','user','developer');
INSERT INTO Team(version ,name,description,Creation_time,Modification_time,city) VALUES (1,'Apacze','grupa programistow',null,null,'Włocławek');
INSERT INTO Team(version ,name,description,Creation_time,Modification_time,city) VALUES (1,'Apacze','grupa programistow',null,null,'Radom');
INSERT INTO Team(version ,name,description,Creation_time,Modification_time,city) VALUES (1,'Apacze','grupa programistow',null,null,'Warszawa');
INSERT INTO Team(version ,name,description,Creation_time,Modification_time,city) VALUES (1,'Apacze','grupa programistow',null,null,'Kraków');
INSERT INTO persons_teams(person_id , team_id) VALUES (3,3)

