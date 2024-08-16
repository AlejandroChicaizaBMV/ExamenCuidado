-- database: ../DataBase/examenDataBase.sqlite
DROP TABLE IF EXISTS CSHormiga;
DROP TABLE IF EXISTS CSPais;
DROP TABLE IF EXISTS CSRegion;
DROP TABLE IF EXISTS CSProvincia;

CREATE TABLE CSPais (
    nPais INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE CSRegion(
    nRegion INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE CSProvincia(
    nProvincia INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

INSERT INTO CSPais (nombre) VALUES ('Ecuador');
INSERT INTO CSRegion (nombre) VALUES 
('Costa'),
('Sierra'),
('Amazonia'),
('Galapagos');
INSERT INTO CSProvincia(nombre) VALUES
('Azuay'),
('Bolivar'),
('Cañar'),
('Carchi'),
('Chimborazo'),
('Cotopaxi'),
('El Oro'),
('Esmeraldas'),
('Galápagos'),
('Guayas'),
('Imbabura'),
('Loja'),
('Los Ríos'),
('Manabí'),
('Morona Santiago'),
('Napo'),
('Sucumbíos'),
('Pastaza'),
('Pinchincha'),
('Santa Elena'),
('Santo Domingo'),
('Francisco De Orellana'),
('Tungurahua'),
('Zamora Chinchipe');

DROP TABLE IF EXISTS CSAlimento;
DROP TABLE IF EXISTS CSIngestaNativa;
DROP TABLE IF EXISTS CSGenoAlimento;
CREATE TABLE CSIngestaNativa(
    nIngestaNativa INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE CSGenoAlimento(
    nGenoAlimento INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE CSAlimento(
    nAlimento INTEGER PRIMARY KEY AUTOINCREMENT,
    IngestaNativa INTEGER,
    GenoAlimento INTEGER,

    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME,

    FOREIGN KEY (IngestaNativa) REFERENCES CSIngestaNativa(nIngestaNativa),
    FOREIGN KEY (GenoAlimento) REFERENCES CSGenoAlimento(nGenoAlimento)
);

INSERT INTO CSIngestaNativa (nombre) VALUES
('Carnivoro'),
('Herviboro'),
('Omnivoro'),
('Insectivoro');

INSERT INTO CSGenoAlimento (nombre) VALUES
('X'),
('XX'),
('XY');

DROP TABLE IF EXISTS CSSexo;
CREATE TABLE CSSexo (
    nSexo INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

INSERT INTO CSSexo (nombre) VALUES
('Macho'),
('Hembra'),
('Asexual');

CREATE TABLE CSHormiga(
    nHormiga INTEGER PRIMARY KEY AUTOINCREMENT,
    TipoHormiga TEXT UNIQUE NOT NULL,
    Sexo INTEGER,
    Provincia INTEGER,
    GenoAlimento INTEGER,
    IngestaNativa INTEGER,

    
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME,
    FOREIGN KEY (Sexo) REFERENCES Sexo(nSexo),
    FOREIGN KEY (Provincia) REFERENCES CSProvincia(nProvincia),
    FOREIGN KEY (GenoAlimento) REFERENCES CSGenoAlimento(nGenoAlimento),
    FOREIGN KEY (IngestaNativa) REFERENCES CSIngestaNativa(nIngestaNativa)
);