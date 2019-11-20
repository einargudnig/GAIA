-- Ekki breyta, fjarlægja DROP TABLE við launch

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS challenges CASCADE;
DROP TABLE IF EXISTS tengi CASCADE;

CREATE TABLE users(id serial PRIMARY KEY,
                   username varchar(64) NOT NULL,
                   email varchar(64) NOT NULL,
                   password varchar(64) NOT NULL,
                   userinfo text[],
                   originalindex float8 NOT NULL,
                   currindex float8 NOT NULL
                   );

CREATE TABLE challenges(id serial PRIMARY KEY,
                        title varchar(64) NOT NULL,
                        info varchar(64) NOT NULL,
                        count integer NOT NULL,
                        carbonIndex float8
                        );

CREATE TABLE tengi(userid integer NOT NULL references users(id),
                   challengeid integer NOT NULL references challenges(id),
                   id serial PRIMARY KEY
                   );