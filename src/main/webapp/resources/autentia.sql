
CREATE TABLE IF NOT EXISTS `cursos` (
  `id_curso` int(11) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `id_nivel` int(11) NOT NULL,
  `horas` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `id_profesor` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;



INSERT INTO `cursos` (`id_curso`, `titulo`, `id_nivel`, `horas`, `activo`, `id_profesor`) VALUES
(1, 'Introducción a JSF2', 2, 25, 1, 1),
(2, 'Java 01', 1, 10, 1, 2),
(3, 'Novedades Java 8', 2, 16, 1, 1),
(4, 'Angular 2', 3, 20, 0, 2),
(5, 'NoSQL', 3, 10, 0, 2),
(6, 'Android avanzado', 3, 25, 1, 1);



CREATE TABLE IF NOT EXISTS `nivel` (
  `id_nivel` int(11) NOT NULL,
  `nombre_nivel` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;



INSERT INTO `nivel` (`id_nivel`, `nombre_nivel`) VALUES
(1, 'Basico'),
(2, 'Intermedio'),
(3, 'Avanzado');



CREATE TABLE IF NOT EXISTS `profesores` (
  `id_profesor` int(11) NOT NULL,
  `nombre_profe` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;



INSERT INTO `profesores` (`id_profesor`, `nombre_profe`) VALUES
(1, 'Francisco Garrido Gil'),
(2, 'Paquita Rosales Cruz');


ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `id_profesor` (`id_profesor`),
  ADD KEY `id_nivel` (`id_nivel`);


ALTER TABLE `nivel`
  ADD PRIMARY KEY (`id_nivel`);


ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id_profesor`);


ALTER TABLE `cursos`
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;

ALTER TABLE `nivel`
  MODIFY `id_nivel` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;

ALTER TABLE `profesores`
  MODIFY `id_profesor` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;

ALTER TABLE `cursos`
  ADD CONSTRAINT `fk_curso_nivel` FOREIGN KEY (`id_nivel`) REFERENCES `nivel` (`id_nivel`),
  ADD CONSTRAINT `fk_curso_profe` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id_profesor`);

