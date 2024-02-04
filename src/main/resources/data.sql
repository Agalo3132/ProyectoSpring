INSERT INTO director (dni, nombre, apellido1) VALUES (1, 'Terry', 'Jones');
INSERT INTO director (dni, nombre, apellido1) VALUES (2, 'Sidney', 'Lumet');
INSERT INTO director (dni, nombre, apellido1) VALUES (3, 'Morten', 'Tyldum');
INSERT INTO director (dni, nombre, apellido1) VALUES (4, 'Chris', 'Columbus');
INSERT INTO director (dni, nombre, apellido1) VALUES (5, 'Hayao', 'Miyazaki');
INSERT INTO director (dni, nombre, apellido1, apellido2) VALUES (6, 'Director', 'De', 'Ejemplo');

INSERT INTO pelicula (id, titulo, genero, duracion, director_id) VALUES (1, 'La vida de Brian', 'Comedia', 4, 1);
INSERT INTO pelicula (id, titulo, genero, duracion, director_id) VALUES (2, '12 hombres sin piedad', 'Crimen', 96, 2);
INSERT INTO pelicula (id, titulo, genero, duracion, director_id) VALUES (3, 'Pasajeros', 'Ciencia ficción', 116, 3);
INSERT INTO pelicula (id, titulo, genero, duracion, director_id) VALUES (4, 'Los Goonies', 'Ciencia ficción', 114, 4);
INSERT INTO pelicula (id, titulo, genero, duracion, director_id) VALUES (5, 'El viaje de Chihiro', 'Fantasia', 125, 5);

INSERT INTO usuario (email, nombre, apellido1, apellido2, contrasenya) VALUES (1, 'alvaro', 'serrano', 'martinez', 'patriapruebame123');
INSERT INTO usuario (email, nombre, apellido1, apellido2, contrasenya) VALUES (2, 'patricia', 'marti', 'gran', 'aprobadoparaalvaro10');
INSERT INTO usuario (email, nombre, contrasenya) VALUES (3, 'pablo', 'moevius237agonia123');
INSERT INTO usuario (email, nombre, apellido1, contrasenya) VALUES (4, 'carlos', 'arroyo', 'eren');
INSERT INTO usuario (email, nombre, apellido1, apellido2, contrasenya) VALUES (5, 'angel', 'macia', 'garcia', 'gymfan311221341');
INSERT INTO usuario (email, nombre, apellido1, apellido2, contrasenya) VALUES (6, 'angel', 'macia', 'garcia2', 'gymfan311221341');


INSERT INTO resenya (id, resenya, estrellas, pelicula_id, usuario_id) VALUES (1, 'Buena', 8, 1, 1);
INSERT INTO resenya (id, resenya, estrellas, pelicula_id, usuario_id) VALUES (2, 'Muy buena', 9, 2, 2);
INSERT INTO resenya (id, resenya, estrellas, pelicula_id, usuario_id) VALUES (3, 'No está mal', 7, 3, 3);
INSERT INTO resenya (id, resenya, estrellas, pelicula_id, usuario_id) VALUES (4, 'Mala malisima', 3, 4, 4);
INSERT INTO resenya (id, resenya, estrellas, pelicula_id, usuario_id) VALUES (5, 'Obra magna', 10, 5, 5);
INSERT INTO resenya (id, resenya, estrellas, pelicula_id, usuario_id) VALUES (6, 'Yipikayey', 10, 1, 6);