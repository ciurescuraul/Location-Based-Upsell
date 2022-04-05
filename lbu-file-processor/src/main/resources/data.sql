CREATE DATABASE lbu;

USE lbu;

CREATE TABLE subscriber
(
    `msisdn`      VARCHAR(15) NOT NULL,
    `has_roaming` TINYINT(1)  NOT NULL,
    PRIMARY KEY (`msisdn`)
);

CREATE TABLE interest_area
(
    `id`   INT         NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `type` INT         NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE interest_area_cell
(
    `id`      INT         NOT NULL AUTO_INCREMENT,
    `area_id` INT         NOT NULL,
    `cell_id` VARCHAR(25) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`area_id`) REFERENCES `lbu`.`interest_area` (`id`) ON DELETE CASCADE
);

-- subscriber
INSERT INTO subscriber (msisdn, has_roaming)
VALUES ('0729036111', '1');
INSERT INTO subscriber (msisdn, has_roaming)
VALUES ('0722223265', '0');
INSERT INTO subscriber (msisdn, has_roaming)
VALUES ('0724587985', '0');
INSERT INTO subscriber (msisdn, has_roaming)
VALUES ('0748789522', '1');
INSERT INTO subscriber (msisdn, has_roaming)
VALUES ('0729036222', '1');

-- interest_area
INSERT INTO interest_area (name, type)
VALUES ('Cluj Concert', '2');
INSERT INTO interest_area (name, type)
VALUES ('Bucharest Airport', '1');
INSERT INTO interest_area (name, type)
VALUES ('Iasi Airport', '1');
INSERT INTO interest_area (name, type)
VALUES ('Chisinau Airport', '1');
INSERT INTO interest_area (name, type)
VALUES ('Pitesti Concert', '1');
INSERT INTO interest_area (name, type)
VALUES ('Brasov Concert', '1');
INSERT INTO interest_area (name, type)
VALUES ('Timisoara Concert', '1');
--
-- interest_area_cell
INSERT INTO interest_area_cell (area_id, cell_id)
VALUES ('1', 'cellId111');
INSERT INTO interest_area_cell (area_id, cell_id)
VALUES ('1', 'cellId222');
INSERT INTO interest_area_cell (area_id, cell_id)
VALUES ('1', 'cellId333');
INSERT INTO interest_area_cell (area_id, cell_id)
VALUES ('2', 'cellId444');