
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
