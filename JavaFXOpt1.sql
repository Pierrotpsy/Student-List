drop database if exists java;

create database java;

use java;

CREATE TABLE students (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Gender` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Birth` DATE NULL,
  `Photo` VARCHAR(45) NULL,
  `Mark` FLOAT NULL,
  `Comments` VARCHAR(1000) NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE);
  
  insert into students value (1, 'Ascelin Jakobsson', 'Female', 'aj@gmail.com', '1999-05-23', 'C:/Users/33769/Downloads/photos/5.jpg', 04, '‪');
  insert into students value (5, 'Mike Toyoda', 'Male', 'miko.toyoda@gmail.com', '1997-08-08', '‪C:/Users/33769/Downloads/photos/5.jpg', 18, '');
  insert into students value (2, 'Nicola Haig', 'Male', 'nicholashaig@yahoo.com', '1994-12-09', '‪C:/Users/33769/Downloads/photos/2.jpg', 10, '');
  insert into students value (3, 'Lucie Suchy', 'Female', 'luciaaaaa@gmail.com', '1992-10-17', '‪C:/Users/33769/Downloads/photos/3.jpg', 12, '');
  insert into students value (4, 'Anzo Blythe', 'Female', 'anzythe781@yahoo.com', '1998-01-12', 'C:/Users/33769/Downloads/photos/4.jpg', 19, '‪');
  insert into students value (6, 'Mike Meyers', 'Male', 'mm@gmail.com', '1989-05-23', 'C:/Users/33769/Downloads/photos/1.jpg', 14, '‪');
  insert into students value (7, 'Donald Duck', 'Male', 'dd@gmail.com', '1987-12-23', 'C:/Users/33769/Downloads/photos/2.jpg', 02, '‪');
  
drop user if exists 'test'@'localhost';
create user 'test'@'localhost' identified by 'password';
grant all PRIVILEGES ON students TO 'test'@'localhost';