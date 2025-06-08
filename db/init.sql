
CREATE TABLE IF NOT EXISTS usuarios (
                                    id VARCHAR PRIMARY KEY,
                                    nombre VARCHAR,
                                    apellido VARCHAR,
                                    edad INT
    );

CREATE TABLE IF NOT EXISTS luces (
                                    id VARCHAR PRIMARY KEY,
                                    nombre VARCHAR,
                                    ubicacion VARCHAR,
                                    usuario_id VARCHAR REFERENCES usuarios(id)
    );

CREATE TABLE IF NOT EXISTS camaras (
                                    id VARCHAR PRIMARY KEY,
                                    nombre VARCHAR,
                                    ubicacion VARCHAR,
                                    usuario_id VARCHAR REFERENCES usuarios(id)
    );

CREATE TABLE IF NOT EXISTS termostatos (
                                    id VARCHAR PRIMARY KEY,
                                    nombre VARCHAR,
                                    ubicacion VARCHAR,
                                    usuario_id VARCHAR REFERENCES usuarios(id)
    );

CREATE TABLE IF NOT EXISTS asistentesvirtuales (
                                     id VARCHAR PRIMARY KEY,
                                     nombre VARCHAR,
                                     ubicacion VARCHAR,
                                     usuario_id VARCHAR REFERENCES usuarios(id)
    );


CREATE TABLE IF NOT EXISTS luces_externas (
                                     id VARCHAR PRIMARY KEY,
                                     nombre VARCHAR,
                                     ubicacion VARCHAR,
                                     usuario_id VARCHAR REFERENCES usuarios(id)
    );

CREATE TABLE IF NOT EXISTS camaras_externas (
                                       id VARCHAR PRIMARY KEY,
                                       nombre VARCHAR,
                                       ubicacion VARCHAR,
                                       usuario_id VARCHAR REFERENCES usuarios(id)
    );

CREATE TABLE IF NOT EXISTS termostatos_externos (
                                       id VARCHAR PRIMARY KEY,
                                       nombre VARCHAR,
                                       ubicacion VARCHAR,
                                       usuario_id VARCHAR REFERENCES usuarios(id)
    );

CREATE TABLE IF NOT EXISTS asistentes_externos (
                                       id VARCHAR PRIMARY KEY,
                                       nombre VARCHAR,
                                       ubicacion VARCHAR,
                                       usuario_id VARCHAR REFERENCES usuarios(id)
    );

INSERT INTO usuarios (id, nombre, apellido, edad) VALUES
                                                    ('u001', 'Lucía', 'Ramírez', 35),
                                                    ('u002', 'Pedro', 'González', 42),
                                                    ('u003', 'Juan', 'Morales', 27);

INSERT INTO luces (id, nombre, ubicacion, usuario_id) VALUES
                                                    ('luz001', 'Luz Cocina', 'Cocina', 'u001'),
                                                    ('luz002', 'Luz Dormitorio', 'Dormitorio', 'u001'),
                                                    ('luz003', 'Luz Garage', 'Garage', 'u002');

INSERT INTO luces_externas (id, nombre, ubicacion, usuario_id) VALUES
                                                    ('luze001', 'Luz Cocina', 'Cocina', 'u002'),
                                                    ('luze002', 'Luz Dormitorio', 'Dormitorio', 'u002'),
                                                    ('luze003', 'Luz Garage', 'Garage', 'u003');

INSERT INTO camaras (id, nombre, ubicacion, usuario_id) VALUES
                                                    ('cam001', 'Camara Entrada', 'Entrada principal', 'u001'),
                                                    ('cam002', 'Camara Patio', 'Patio trasero', 'u002');

INSERT INTO camaras_externas (id, nombre, ubicacion, usuario_id) VALUES
                                                    ('came001', 'Camara Entrada', 'Entrada principal', 'u002'),
                                                    ('came002', 'Camara Patio', 'Patio trasero', 'u003');

INSERT INTO termostatos (id, nombre, ubicacion, usuario_id) VALUES
                                                    ('ter001', 'Termostato Cocina', 'Cocina', 'u001'),
                                                    ('ter002', 'Termostato Living', 'Living', 'u001');

INSERT INTO termostatos_externos (id, nombre, ubicacion, usuario_id) VALUES
                                                    ('ter001', 'Termostato Cocina', 'Cocina', 'u002'),
                                                    ('ter002', 'Termostato Living', 'Living', 'u003');

INSERT INTO asistentesvirtuales (id, nombre, ubicacion, usuario_id) VALUES
                                                    ('asi001', 'Asistente Siri', 'Living', 'u001'),
                                                    ('asi002', 'Asistente Alexa', 'Cocina', 'u002');

INSERT INTO asistentes_externos (id, nombre, ubicacion, usuario_id) VALUES
                                                    ('asi001', 'Asistente Siri', 'Living', 'u002'),
                                                    ('asi002', 'Asistente Alexa', 'Cocina', 'u003');