INSERT INTO platzi_play_peliculas (titulo, duracion, genero, estado)
VALUES ('John Wick', 101, 'ACCION', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, estado)
VALUES ('El Conjuro', 112, 'TERROR', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, estado)
VALUES ('Coco', 105, 'ANIMADA', 'D')
    ON CONFLICT (titulo) DO NOTHING;

INSERT INTO platzi_play_peliculas (titulo, duracion, genero, estado)
VALUES ('Interstellar', 169, 'CIENCIA_FICCION', 'D')
    ON CONFLICT (titulo) DO NOTHING;