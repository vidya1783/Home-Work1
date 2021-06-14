CREATE TABLE test (
id serial not null);
ALTER TABLE test
ADD COLUMN test_value varchar (50);
DROP TABLE tets;

CREATE TABLE artist ( 
artist_id serial NOT NULL,
artist_name varchar (50) NOT NULL,
CONSTRAINT pk_artist_artist_id  PRIMARY KEY(artist_id));
ups
CREATE TABLE painting(
painting_id serial NOT NULL,
title varchar (50) NOT NULL,
CONSTRAINT pk_painting_painting_id PRIMARY KEY (painting_id));

CREATE TABLE artist_painting(
artist_id integer NOT NULL,
painting_id integer NOT NULL,
CONSTRAINT Pk_artist_painting_id PRIMARY KEY (