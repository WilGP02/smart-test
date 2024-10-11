
INSERT INTO users (id, name, email, password, is_active, created, modified, last_login, token) VALUES (UUID(), 'Wilmer Palomino', 'wpalomino@prueba.com', 'Elmaestro1$', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
                                                                                                       'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ3cGFsb21pbm9AcHJ1ZWJhLmNvbSIsImV4cCI6MTcyODY2NzgyNSwiaWF0IjoxNzI4NjY0MjI1LCJlbWFpbCI6IndwYWxvbWlub0BwcnVlYmEuY29tIn0.qk95ENxfCHrx1hNww7SFSjjsteqiXJlcDpDPmmv5wxM');
INSERT INTO phone (id, number, citycode, countrycode) VALUES (UUID(), '1234567890', '123', '1');
INSERT INTO users_phones (phones_id, users_id) VALUES ((SELECT id FROM phone WHERE number = '1234567890'), (SELECT id FROM users WHERE email = 'wpalomino@prueba.com'));
