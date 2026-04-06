-- Script para crear la base de datos y la tabla para el punto 4

-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS punto_3_1_o2;

-- Usar la base de datos
USE punto_3_1_o2;

-- Crear la tabla inscripciones
CREATE TABLE IF NOT EXISTS inscripciones (
    idParticipante INT NOT NULL,
    idConcurso INT NOT NULL,
    fecha DATE NOT NULL,
    PRIMARY KEY (idParticipante, idConcurso, fecha)  -- Asumiendo que no hay duplicados por participante, concurso y fecha
);
