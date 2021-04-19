# Grab Docker Image
> docker pull mysql

# Start mysql server
> docker run --name mysql-server -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql

# MySQL Server Logs
> docker logs mysql-server

# Connecting to mysql server from within the container
> docker exec -it mysql-server mysql -u root -p (password was defined before)


schema=lbu
user=lbuuser
password=password

```
CREATE DATABASE lbu;

USE lbu;

CREATE TABLE lbu_file_statistics (
`id` INT NOT NULL AUTO_INCREMENT,
`origin` VARCHAR(45) NOT NULL,
`file_name` VARCHAR(45) NOT NULL,
`start_date` DATETIME NOT NULL,
`end_date` DATETIME NOT NULL,
`header` TINYINT NOT NULL DEFAULT 0,
`trailer` TINYINT NOT NULL DEFAULT 0,
`total` INT NOT NULL DEFAULT 0,
`success` INT NOT NULL DEFAULT 0,
`failed` INT NOT NULL DEFAULT 0,
`not_decoded` INT NOT NULL DEFAULT 0,
`not_validated` INT NOT NULL DEFAULT 0,
PRIMARY KEY (`id`));
```
=============================================================================
```
CREATE TABLE `lbu`.`subscriber` (
`msisdn` VARCHAR(15) NOT NULL,
`has_roaming` TINYINT(1) NOT NULL,
PRIMARY KEY (`msisdn`));

INSERT INTO `academy`.`subscriber` (`msisdn`, `has_roaming`) VALUES ('0729036111', '1');
INSERT INTO `academy`.`subscriber` (`msisdn`, `has_roaming`) VALUES ('0729036222', '0');
```
=============================================================================
```
CREATE TABLE `lbu`.`interest_area` (
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`type` INT NOT NULL,
PRIMARY KEY (`id`));

INSERT INTO `academy`.`interest_area` (`id`, `name`, `type`) VALUES ('1', 'Bucharest Airport', '1');
INSERT INTO `academy`.`interest_area` (`id`, `name`, `type`) VALUES ('2', 'Piata Unirii', '2');
INSERT INTO `academy`.`interest_area` (`id`, `name`, `type`) VALUES ('3', 'Iasi Airport', '1');
INSERT INTO `academy`.`interest_area` (`id`, `name`, `type`) VALUES ('4', 'Chisinau Airport', '1');
```
=============================================================================
```
CREATE TABLE `lbu`.`interest_area_cell` (
`id` INT NOT NULL AUTO_INCREMENT,
`area_id` INT NOT NULL,
`cell_id` VARCHAR(25) NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY(`area_id`) REFERENCES `academy`.`interest_area`(`id`) ON DELETE CASCADE );

INSERT INTO `academy`.`interest_area_cell` (`area_id`, `cell_id`) VALUES ('1', 'cellId1');
INSERT INTO `academy`.`interest_area_cell` (`area_id`, `cell_id`) VALUES ('1', 'cellId2');
INSERT INTO `academy`.`interest_area_cell` (`area_id`, `cell_id`) VALUES ('1', 'cellId3');
INSERT INTO `academy`.`interest_area_cell` (`area_id`, `cell_id`) VALUES ('2', 'cellId4');
```
