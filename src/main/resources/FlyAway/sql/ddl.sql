CREATE DATABASE IF NOT EXISTS spring_mvc;

USE spring_mvc;

DROP TABLE IF EXISTS `spring_mvc`.`users`;

CREATE TABLE `spring_mvc`.`users` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45)  NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `phone` Double NOT NULL,
  PRIMARY KEY (`username`));
  
  DROP TABLE IF EXISTS `spring_mvc`.`flight_master`;
  	
  CREATE TABLE `spring_mvc`.`flight_master` (
  `flightId` int NOT NULL auto_increment,
  `airlineName` VARCHAR(45) NOT NULL,
  `source` VARCHAR(45) NOT NULL,
  `destination` VARCHAR(45) NOT NULL,
  `departureTime` VARCHAR(45) NOT NULL,
  `departureDate` VARCHAR(45) NOT NULL,
  `arrivalTime` VARCHAR(45) NOT NULL,
  `fare` double NOT NULL,
  `availableSeats` INT NULL,
  PRIMARY KEY (`flightId`));
  
  INSERT INTO `spring_mvc`.`flight_master` VALUES
  (1,'indigo','bangalore','delhi','14:00','09/06/2021','15:30',3000,15),
  (2,'spicejet','bangalore','manali','16:00','09/06/2021','20:30',4000,15),
  (3,'vistara','bangalore','jammu','14:00','09/06/2021','15:30',5000,15),
  (4,'indigo','jammu','bangalore','12:00','09/06/2021','14:30',3000,20),
  (5,'spicejet','jammu','manali','13:00','09/06/2021','17:30',3500,15),
  (7,'vistara','jammu','delhi','09:00','09/06/2021','11:30',4500,25),
  (8,'indigo','delhi','bangalore','08:00','09/06/2021','11:00',1500,30),
  (9,'airindia','delhi','jammu','06:00','09/06/2021','10:30',4500,20),
  (10,'indigo','manali','jammu','10:00','09/06/2021','12:30',5000,22),
  (11,'spicejet','manali','delhi','07:00','09/06/2021','09:30',2000,17),
  (12,'vistara','manali','bangalore','23:00','09/06/2021','01:30',6000,30);


  
 DROP TABLE IF EXISTS `spring_mvc`.`admin_master`;

 create table `spring_mvc`.`admin_master`
(
`username` VARCHAR(45) NOT NULL,
`password` VARCHAR(45) NOT NULL,
PRIMARY KEY (`username`)
);

INSERT INTO `spring_mvc`.`admin_master` VALUES ('Darakhshan','Darakhshan');


DROP TABLE IF EXISTS spring_mvc.location_master;

 create table spring_mvc.location_master
(
locId int NOT NULL,
locName VARCHAR(45) NOT NULL,
PRIMARY KEY (locId)
);

INSERT INTO spring_mvc.location_master VALUES ( 1 ,'bangalore'),(2,'delhi'),(3,'jammu'),(4,'manali');

