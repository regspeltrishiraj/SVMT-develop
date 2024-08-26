INSERT INTO svmt.`user`
(id, firstname, lastname, password, username)
VALUES(1, 'user_firstname', 'user_lastname', '$2a$10$FYnAegOR8L9RajvgAz2PCOUoog1RpFbkgXwsM4s8/Nkoo3xeuuPJC', 'user');
INSERT INTO svmt.`user`
(id, firstname, lastname, password, username)
VALUES(2, 'admin_firstname', 'admin_lastname', '$2a$10$ZTWtrHuvgEkp3S9ETl7inuuB14OX2rDPUQvjvAaEpqfPo/XdU0vXq', 'admin');

INSERT INTO svmt.user_role
(user_id, role_id)
VALUES(2, 1);
INSERT INTO svmt.user_role
(user_id, role_id)
VALUES(1, 2);

INSERT INTO svmt.`role`
(id, description, details)
VALUES(1, 'ROLE_ADMIN', 'Admin Role');
INSERT INTO svmt.`role`
(id, description, details)
VALUES(2, 'ROLE_USER', 'User Role');