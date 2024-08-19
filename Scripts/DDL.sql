-- database: ../DataBase/examenDataBase.sqlite
DROP TABLE IF EXISTS CSHormiga;
DROP TABLE IF EXISTS CSTipoHormiga;
DROP TABLE IF EXISTS CSPais;
DROP TABLE IF EXISTS CSRegion;
DROP TABLE IF EXISTS CSProvincia;
DROP TABLE IF EXISTS CSAlimento;
DROP TABLE IF EXISTS CSIngestaNativa;
DROP TABLE IF EXISTS CSGenoAlimento;
DROP TABLE IF EXISTS CSSexo;

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
    id_TipoHormiga INTEGER,
    TipoHormiga TEXT,
    id_Sexo INTEGER,
    Sexo TEXT,
    id_Provincia INTEGER,
    Provincia TEXT,
    id_GenoAlimento INTEGER,
    GenoAlimento TEXT,
    id_IngestaNativa INTEGER,
    IngestaNativa TEXT,
    Estado VARCHAR NOT NULL DEFAULT('VIVA'),
    FechaCrea DATETIME DEFAULT(datetime('now','localtime')),
    FechaModifica DATETIME,
    FOREIGN KEY (id_TipoHormiga) REFERENCES CSTipoHormiga(nTipoHormiga),
    FOREIGN KEY (id_Sexo) REFERENCES CSSexo(nSexo),
    FOREIGN KEY (id_Provincia) REFERENCES CSProvincia(nProvincia),
    FOREIGN KEY (id_GenoAlimento) REFERENCES CSGenoAlimento(nGenoAlimento),
    FOREIGN KEY (id_IngestaNativa) REFERENCES CSIngestaNativa(nIngestaNativa)
);

CREATE TRIGGER traductorInsert
AFTER INSERT ON CSHormiga
FOR EACH ROW 
BEGIN 
    UPDATE CSHormiga
    SET 
        TipoHormiga = (SELECT nombre FROM CSTipoHormiga WHERE nTipoHormiga = NEW.id_TipoHormiga),
        Sexo = (SELECT nombre FROM CSSexo WHERE nSexo = NEW.id_Sexo),
        Provincia = (SELECT nombre FROM CSProvincia WHERE nProvincia = NEW.id_Provincia),
        GenoAlimento = (SELECT nombre FROM CSGenoAlimento WHERE nGenoAlimento = NEW.id_GenoAlimento),
        IngestaNativa = (SELECT nombre FROM CSIngestaNativa WHERE nIngestaNativa = NEW.id_IngestaNativa)
    WHERE nHormiga = NEW.nHormiga;
END;

CREATE TRIGGER traductorUpdate
AFTER UPDATE ON CSHormiga
FOR EACH ROW
BEGIN 
    UPDATE CSHormiga
    SET 
        TipoHormiga = (SELECT nombre FROM CSTipoHormiga WHERE nTipoHormiga = NEW.id_TipoHormiga),
        Sexo = (SELECT nombre FROM CSSexo WHERE nSexo = NEW.id_Sexo),
        Provincia = (SELECT nombre FROM CSProvincia WHERE nProvincia = NEW.id_Provincia),
        GenoAlimento = (SELECT nombre FROM CSGenoAlimento WHERE nGenoAlimento = NEW.id_GenoAlimento),
        IngestaNativa = (SELECT nombre FROM CSIngestaNativa WHERE nIngestaNativa = NEW.id_IngestaNativa)
    WHERE nHormiga = NEW.nHormiga;
END;


