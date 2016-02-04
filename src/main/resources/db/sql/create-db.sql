CREATE TABLE city (
  id INT NOT NULL,
  citykey VARCHAR(45) NULL,
  name VARCHAR(45) NULL,
  fullname VARCHAR(45) NULL,
  airportcode VARCHAR(45) NULL,
  citytype VARCHAR(45) NULL,
  countryid INT NULL,
  geopositionid INT NULL,
  PRIMARY KEY (id));
  
CREATE TABLE country (
  id INT NOT NULL,
  name VARCHAR(45) NULL,
  iseurope TINYINT NULL,
  countrycode VARCHAR(45) NULL,
  distance VARCHAR(45) NULL,
  coreCountry VARCHAR(45) NULL,
  PRIMARY KEY (id));

CREATE TABLE geoposition (
  id INT NOT NULL,
  longitude FLOAT NULL,
  latitude FLOAT NULL,
  PRIMARY KEY (id));
