-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-11-2021 a las 16:22:01
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `encuesta`
--
CREATE DATABASE IF NOT EXISTS `encuesta` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `encuesta`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

DROP TABLE IF EXISTS `resultados`;
CREATE TABLE `resultados` (
  `Nombre` varchar(50) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Sexo` varchar(10) NOT NULL,
  `Pregunta1` double NOT NULL,
  `Pregunta2` double NOT NULL,
  `Pregunta3` double NOT NULL,
  `Pregunta4` double NOT NULL,
  `Puntos` double NOT NULL,
  `Intentos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `resultados`
--

INSERT INTO `resultados` (`Nombre`, `FechaNacimiento`, `Sexo`, `Pregunta1`, `Pregunta2`, `Pregunta3`, `Pregunta4`, `Puntos`, `Intentos`) VALUES
('Eva López Díaz', '1975-10-23', 'Mujer', 1, 1, 1, 1, 4, 1),
('Pedro Domínguez Castro', '1982-01-07', 'Hombre', 1, -0.5, 1, 1, 2.5, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`Nombre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
