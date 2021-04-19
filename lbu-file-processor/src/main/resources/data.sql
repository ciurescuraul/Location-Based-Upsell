
-- lbu_subscriber
INSERT INTO lbu.lbu_subscriber (msisdn, has_roaming) VALUES ('0729036111', '1');
INSERT INTO lbu.lbu_subscriber (msisdn, has_roaming) VALUES ('0722223265', '0');
INSERT INTO lbu.lbu_subscriber (msisdn, has_roaming) VALUES ('0724587985', '0');
INSERT INTO lbu.lbu_subscriber (msisdn, has_roaming) VALUES ('0748789522', '1');
INSERT INTO lbu.lbu_subscriber (msisdn, has_roaming) VALUES ('0729036222', '1');

-- lbu_interest_area
INSERT INTO lbu.lbu_interest_area (name, type) VALUES ('Cluj Concert', '2');
INSERT INTO lbu.lbu_interest_area (name, type) VALUES ('Bucharest Airport', '1');
INSERT INTO lbu.lbu_interest_area (name, type) VALUES ('Iasi Airport', '1');
INSERT INTO lbu.lbu_interest_area (name, type) VALUES ('Chisinau Airport', '1');
INSERT INTO lbu.lbu_interest_area (name, type) VALUES ('Pitesti Concert', '1');
INSERT INTO lbu.lbu_interest_area (name, type) VALUES ('Brasov Concert', '1');
INSERT INTO lbu.lbu_interest_area (name, type) VALUES ('Timisoara Concert', '1');
--
-- lbu_interest_area_cell
INSERT INTO lbu.lbu_interest_area_cell (area_id, cell_id) VALUES ('1', 'cellId111');
INSERT INTO lbu.lbu_interest_area_cell (area_id, cell_id) VALUES ('1', 'cellId222');
INSERT INTO lbu.lbu_interest_area_cell (area_id, cell_id) VALUES ('1', 'cellId333');
INSERT INTO lbu.lbu_interest_area_cell (area_id, cell_id) VALUES ('2', 'cellId444');