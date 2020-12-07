INSERT INTO User (id, login, password) VALUES (1, 'moneta', '123');
INSERT INTO User (id, login, password) VALUES (2, 'igorek', '123');
INSERT INTO UserRole (id, role) VALUES (1, 'ADMIN');
INSERT INTO UserRole (id, role) VALUES (2, 'USER');
INSERT INTO UserRole (id, role) VALUES (3, 'GUEST');
INSERT INTO User_UserRole (roles_id, users_id) VALUES (1, 1);
INSERT INTO User_UserRole (roles_id, users_id) VALUES (2, 1);
INSERT INTO User_UserRole (roles_id, users_id) VALUES (2, 2);
