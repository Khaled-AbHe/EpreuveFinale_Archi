-- Drop tables if they exist (optional, for clean restart)
DROP TABLE IF EXISTS offre;
DROP TABLE IF EXISTS vol;
DROP TABLE IF EXISTS operateur;
DROP TABLE IF EXISTS aeroport;
DROP TABLE IF EXISTS terminal;

-- Create Aeroport table
CREATE TABLE aeroport (
    id INTEGER PRIMARY KEY,
    code VARCHAR(3) NOT NULL UNIQUE,
    ville VARCHAR(100) NOT NULL
);

-- Create Operateur table
CREATE TABLE operateur (
    id INTEGER PRIMARY KEY,
    code VARCHAR(10) NOT NULL UNIQUE,
    nom VARCHAR(100) NOT NULL
);

-- Create Vol table
CREATE TABLE vol (
    id INTEGER PRIMARY KEY,
    numero VARCHAR(20) NOT NULL UNIQUE,
    origine_id INTEGER NOT NULL,
    destination_id INTEGER NOT NULL,
    duree DOUBLE NOT NULL,
    FOREIGN KEY (origine_id) REFERENCES aeroport(id),
    FOREIGN KEY (destination_id) REFERENCES aeroport(id)
);

-- Create Offre table
CREATE TABLE offre (
    id INTEGER PRIMARY KEY,
    trajet_id INTEGER NOT NULL,
    operateur_id INTEGER NOT NULL,
    depart VARCHAR(50) NOT NULL,
    prix_base DOUBLE NOT NULL,
    FOREIGN KEY (trajet_id) REFERENCES vol(id),
    FOREIGN KEY (operateur_id) REFERENCES operateur(id)
);
-- Create terminal table
CREATE TABLE terminal (
    id INTEGER PRIMARY KEY,
    code VARCHAR(3) NOT NULL UNIQUE,
    ville VARCHAR(100) NOT NULL,
    typetrajet VARCHAR(50) NOT NULL
);