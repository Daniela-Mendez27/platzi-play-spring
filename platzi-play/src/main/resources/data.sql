INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('John Wick', 101, 'ACCION', NULL, '2014-10-24', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('El Conjuro', 112, 'TERROR', 3.0, '2013-07-19', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Coco', 105, 'ANIMADA', 4.7, '2017-10-27', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Interstellar', 169, 'CIENCIA_FICCION', 5.0, '2014-11-07', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Joker', 122, 'DRAMA', NULL, '2019-10-04', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, clasificacion, fecha_estreno, estado)
VALUES ('Toy Story', 81, 'ANIMADA', 4.5, '1995-11-22', 'D')
    ON CONFLICT (titulo) DO NOTHING;