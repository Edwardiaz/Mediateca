CREATE DATABASE  IF NOT EXISTS `mediateca`;
USE `mediateca`;
/*HAY QUE REVISAR CAMPOS Y TIPOS DE DATOS, ADEMAS HAY QUE METERLE INFORMACION A LAS TABLAS...*/
CREATE TABLE `Artistas` (
  `id` int NOT NULL auto_increment,
  `nombre_artista` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Autores` (
  `id` int NOT NULL auto_increment,
  `nombre_autor` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Directores` (
  `id` int NOT NULL auto_increment,
  `nombre_director` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Editoriales` (
  `id` int NOT NULL auto_increment,
  `nombre_editorial` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Generos` (
  `id` int NOT NULL auto_increment,
  `nombre_genero` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Socios` (
  `id` int NOT NULL auto_increment,
  `nombre` varchar(75) NOT NULL,
  `documento` varchar(25) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo_electronico` varchar(45) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Tipo_Material` (
  `id` int NOT NULL auto_increment,
  `tipo_material` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Materiales` (
  `id` varchar(11) NOT NULL, /*Codigo, dado que id es un nombre de campo generico para saber que es el PK de la tabla*/
  `titulo` varchar(45) NOT NULL,
  `codigo_tipo_material` int(11) NOT NULL,
  `codigo_autor` int(11) DEFAULT NULL,
  `numero_de_paginas` varchar(4) DEFAULT NULL,
  `codigo_editorial` int(11) DEFAULT NULL,
  `isbn` varchar(13) DEFAULT NULL,
  /*`anio_Publicacion` varchar(4) DEFAULT NULL,*/
  `periodicidad` varchar(15) DEFAULT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  `codigo_artista` int(11) DEFAULT NULL,
  `codigo_genero` int(11) DEFAULT NULL,
  `duracion` varchar(15) DEFAULT NULL,
  `numero_de_canciones` varchar(2) DEFAULT NULL,
  `codigo_director` int(11) DEFAULT NULL,
  `unidades_disponibles` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Tipo_id` (`codigo_tipo_material`),
  KEY `FK_Autor_id` (`codigo_autor`),
  KEY `FK_Editorial_id` (`codigo_editorial`),
  KEY `FK_Artista_id` (`codigo_artista`),
  KEY `FK_Genero` (`codigo_genero`),
  KEY `FK_Director` (`codigo_director`),
  CONSTRAINT `FK_Artista` FOREIGN KEY (`codigo_artista`) REFERENCES `Artistas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Autor` FOREIGN KEY (`codigo_autor`) REFERENCES `Autores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Director` FOREIGN KEY (`codigo_director`) REFERENCES `Directores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Editorial` FOREIGN KEY (`codigo_editorial`) REFERENCES `Editoriales` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Genero` FOREIGN KEY (`codigo_genero`) REFERENCES `Generos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Tipo` FOREIGN KEY (`codigo_tipo_material`) REFERENCES `Tipo_Material` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Prestamos` (
  `id` int NOT NULL auto_increment,
  `codigo_material` varchar(10) NOT NULL,
  `codigo_socio` int(11) NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_devolucion` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_socio_id` (`codigo_socio`),
  KEY `FK_material_id` (`codigo_material`),
  CONSTRAINT `FK_Materiales` FOREIGN KEY (`codigo_material`) REFERENCES `Materiales` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Socios` FOREIGN KEY (`codigo_socio`) REFERENCES `Socios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





