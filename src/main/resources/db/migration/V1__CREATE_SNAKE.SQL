
CREATE TABLE snake (
  idsnake number(11) NOT NULL,
  name varchar(45) DEFAULT NULL,
  color varchar(45) DEFAULT NULL,
  breed varchar(45) DEFAULT NULL,
  PRIMARY KEY (idsnake)
);


INSERT INTO snake (idsnake, name, color, breed) VALUES (1234, 'Cobra', 'Black', 'Reptilian');
INSERT INTO snake (idsnake, name, color, breed) VALUES (2345, 'Python', 'Brown', 'Reptilian');