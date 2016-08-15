create database proyectoso1;
use proyectoso2;
create table usuarios
(
	id_usuario INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nombre_usuario VARCHAR(30) NOT NULL,
	palabra_clave VARCHAR(30) NOT NULL,
	fecha_compra date NOT NULL,
	fecha_caducidad DATE NOT NULL
);

INSERT INTO `proyectoso1`.`usuarios`
(`nombre_usuario`,
`palabra_clave`,
`fecha_compra`,
`fecha_caducidad`)
VALUES
('1',
'3',
current_date(),
date_add(current_date(),interval 30 day));

Select * from usuarios