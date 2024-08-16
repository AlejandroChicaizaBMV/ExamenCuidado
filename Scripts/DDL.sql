-- database: ../DataBase/examenDataBase.sqlite
DROP TABLE IF EXISTS CSTipoHormiga;
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

CREATE TABLE CSRegion (
    nRegion INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE CSProvincia (
    nProvincia INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

DROP TABLE IF EXISTS CSAlimento;
DROP TABLE IF EXISTS CSIngestaNativa;
DROP TABLE IF EXISTS CSGenoAlimento;

DROP TABLE IF EXISTS CSSexo;

CREATE TABLE CSIngestaNativa (
    nIngestaNativa INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE CSGenoAlimento (
    nGenoAlimento INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE CSAlimento (
    nAlimento INTEGER PRIMARY KEY AUTOINCREMENT,
    IngestaNativa INTEGER,
    GenoAlimento INTEGER,
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME,
    FOREIGN KEY (IngestaNativa) REFERENCES CSIngestaNativa(nIngestaNativa),
    FOREIGN KEY (GenoAlimento) REFERENCES CSGenoAlimento(nGenoAlimento)
);

CREATE TABLE CSSexo (
    nSexo INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);

CREATE TABLE CSTipoHormiga(
    nTipoHormiga INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT UNIQUE NOT NULL,
    
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME
);
CREATE TABLE CSHormiga (
    nHormiga INTEGER PRIMARY KEY AUTOINCREMENT,
    TipoHormiga INTEGER,
    Sexo INTEGER,
    Provincia INTEGER,
    GenoAlimento INTEGER,
    IngestaNativa INTEGER,
    Estado VARCHAR(1) NOT NULL DEFAULT('A'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME,
    FOREIGN KEY (TipoHormiga) REFERENCES CSTipoHormiga(nTipoHormiga),
    FOREIGN KEY (Sexo) REFERENCES CSSexo(nSexo),
    FOREIGN KEY (Provincia) REFERENCES CSProvincia(nProvincia),
    FOREIGN KEY (GenoAlimento) REFERENCES CSGenoAlimento(nGenoAlimento),
    FOREIGN KEY (IngestaNativa) REFERENCES CSIngestaNativa(nIngestaNativa)
);
