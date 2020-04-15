-- Ekki breyta, fjarlægja DROP TABLE við launch

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS challenges CASCADE;
DROP TABLE IF EXISTS tengi CASCADE;

CREATE TABLE users(id serial PRIMARY KEY,
                   username varchar(64) NOT NULL,
                   email varchar(64) NOT NULL,
                   password varchar(64) NOT NULL,
                   userinfo varchar(100),
                   originalindex float8,
                   currindex float8,
                   transIndex integer DEFAULT 0,
                   foodIndex integer DEFAULT 0,
                   houseIndex integer DEFAULT 0,
                   consIndex integer DEFAULT 0,
                   worstCase integer DEFAULT 0,
                   currCase integer DEFAULT 0
                   );

CREATE TABLE challenges(id serial PRIMARY KEY,
                        title varchar(64) NOT NULL,
                        info varchar(1024) NOT NULL,
                        count integer NOT NULL,
                        carbonIndex float8
                        );

CREATE TABLE tengi(userid integer NOT NULL references users(id),
                   challengeid integer NOT NULL references challenges(id),
                   id serial PRIMARY KEY
                   );