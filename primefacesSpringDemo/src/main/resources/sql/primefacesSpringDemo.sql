/*CREA BASE DE DATOS*/
DROP SCHEMA IF EXISTS `primefaces_spring_demo`;

CREATE SCHEMA `primefaces_spring_demo`;

use `primefaces_spring_demo`;

SET FOREIGN_KEY_CHECKS = 0;

/*PROFESOR*/
DROP TABLE IF EXISTS `profesor_informacion`;

CREATE TABLE `profesor_informacion` (
  `id_profesor_informacion` int(11) NOT NULL AUTO_INCREMENT,
  `celular` varchar(16) NOT NULL,
  `telefono` varchar(16) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id_profesor_informacion`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `profesor`;

CREATE TABLE `profesor` (
  `id_profesor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `primer_apellido` varchar(100) NOT NULL,
  `segundo_apellido` varchar(100) NOT NULL,
  `profesor_informacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_profesor`),
  CONSTRAINT `FK_PROF_INFO_idx` FOREIGN KEY (`profesor_informacion`) REFERENCES `profesor_informacion` (`id_profesor_informacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*ESTUDIANTE*/

DROP TABLE IF EXISTS `estudiante_informacion`;

CREATE TABLE `estudiante_informacion` (
  `id_estudiante_informacion` int(11) NOT NULL AUTO_INCREMENT,
  `celular` varchar(16) NOT NULL,
  `telefono` varchar(16) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id_estudiante_informacion`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `estudiante`;

CREATE TABLE `estudiante` (
  `id_estudiante` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `primer_apellido` varchar(100) NOT NULL,
  `segundo_apellido` varchar(100) NOT NULL,
  `estudiante_informacion` int(11) DEFAULT NULL,

  PRIMARY KEY (`id_estudiante`),
  CONSTRAINT `FK_EST_INFO` FOREIGN KEY (`estudiante_informacion`) 
  REFERENCES `estudiante_informacion` (`id_estudiante_informacion`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*MATERIA*/

DROP TABLE IF EXISTS `materia`;

CREATE TABLE `materia` (
  `id_materia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `creditos` int(11) NOT NULL,
  `activa` int(1) NOT NULL,

  PRIMARY KEY (`id_materia`),
  UNIQUE KEY `NOMBRE_MATERIA_UK` (`nombre`)  
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

/*CURSO*/
DROP TABLE IF EXISTS `curso`;

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(100) NOT NULL,
  `profesor` int(11) DEFAULT NULL,
  `materia` int(11) NOT NULL,
  `activa` int(1) NOT NULL,
  
  PRIMARY KEY (`id_curso`),
  UNIQUE KEY `CODIGO_CURSO_UK` (`codigo`),

  CONSTRAINT `FK_PROFE_CURSO` 
  FOREIGN KEY (`profesor`) 
  REFERENCES `profesor` (`id_profesor`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT `FK_MAT_CURSO` 
  FOREIGN KEY (`materia`) 
  REFERENCES `materia` (`id_materia`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `curso_estudiante`;

CREATE TABLE `curso_estudiante` (
  `id_curso_estudiante` int(11) NOT NULL AUTO_INCREMENT,
  `curso` int(11) NOT NULL,
  `estudiante` int(11) NOT NULL,
  
  PRIMARY KEY (`id_curso_estudiante`),

  CONSTRAINT `FK_CURSO` FOREIGN KEY (`curso`) 
  REFERENCES `curso` (`id_curso`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_ESTUDIANTE` FOREIGN KEY (`estudiante`) 
  REFERENCES `estudiante` (`id_estudiante`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;