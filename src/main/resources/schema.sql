CREATE TABLE stat_task
(
    id                INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    username          VARCHAR(64) NOT NULL UNIQUE,
    cdate             TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    finished_date     TIMESTAMP,
    collection_locked BOOLEAN     NOT NULL DEFAULT false
);

create table a
(
    id    INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    extid INT          NOT NULL UNIQUE,
    name  VARCHAR(255) NOT NULL
);

create table m
(
    id    INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    extid INT          not null UNIQUE,
    name  VARCHAR(255) NOT NULL
);

create table l
(
    id    INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    extid INT          NOT NULL UNIQUE,
    name  VARCHAR(255) NOT NULL
);

create table r
(
    id           INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    extid        INT          NOT NULL UNIQUE,
    name         VARCHAR(255) NOT NULL,
    ryear        VARCHAR(4),
    master_fk_id INT,
    FOREIGN KEY (master_fk_id) REFERENCES m (id)
);

CREATE TABLE g
(
    id   INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(63) NOT NULL UNIQUE
);

CREATE TABLE s
(
    id   INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(63) NOT NULL UNIQUE
);

CREATE TABLE a_r
(
    id      INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    a_fk_id INT NOT NULL,
    r_fk_id INT NOT NULL,
    FOREIGN KEY (r_fk_id) REFERENCES r (id),
    FOREIGN KEY (a_fk_id) REFERENCES a (id)
);

create table l_r
(
    id      INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    l_fk_id INT NOT NULL,
    r_fk_id INT NOT NULL,
    FOREIGN KEY (r_fk_id) REFERENCES r (id),
    FOREIGN KEY (l_fk_id) REFERENCES l (id),
    UNIQUE (l_fk_id, r_fk_id)
);

create table g_r
(
    id      INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    g_fk_id INT NOT NULL,
    r_fk_id INT NOT NULL,
    FOREIGN KEY (r_fk_id) REFERENCES r (id),
    FOREIGN KEY (g_fk_id) REFERENCES g (id)
);

CREATE TABLE s_r
(
    id      INT NOT NULL PRIMARY KEY AUTO_INCREMENT NOT NULL,
    s_fk_id INT NOT NULL,
    r_fk_id INT NOT NULL,
    FOREIGN KEY (r_fk_id) REFERENCES r (id),
    FOREIGN KEY (s_fk_id) REFERENCES s (id)
);

create table collection
(
    id         INT AUTO_INCREMENT NOT NULL,
    user_fk_id INT NOT NULL,
    r_fk_id    INT NOT NULL,
    FOREIGN KEY (user_fk_id) REFERENCES stat_task (id),
    FOREIGN KEY (r_fk_id) REFERENCES r (id)
);

-- TODO the inserts need to be removed.

insert into stat_task (username, cdate, finished_date, collection_locked)
values ('killerbau', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), false),
       ('guru_mosh', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), true),
       ('someone', CURRENT_TIMESTAMP(), null, false);

INSERT INTO a (name, extid)
VALUES ('Die Ärzte', 123),
       ('EA80', 31);

INSERT INTO l (name, extid)
VALUES ('Vielklang', 123),
       ('Not On Label (EA80 Self-released)', 31);

INSERT INTO r (extid, name, ryear)
VALUES (123, 'Nummus Cecidit', '2023');

INSERT INTO g (name)
VALUES ('Rock'),('Electronic');
INSERT INTO s(name)
VALUES ('Punk'),('Ska');

INSERT INTO a_r (a_fk_id, r_fk_id)
VALUES (1, 1);
INSERT INTO l_r (l_fk_id, r_fk_id)
VALUES (1, 1);
INSERT INTO g_r (g_fk_id, r_fk_id) VALUES (1,1);
INSERT INTO s_r (s_fk_id, r_fk_id) VALUES (1,1);

INSERT INTO collection (user_fk_id, r_fk_id) VALUES (1,1);