CREATE TABLE IF NOT EXISTS public.singers_filtered_spring (
    singer_id BIGINT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS public.albums_filtered_spring (
    album_id BIGINT PRIMARY KEY,
    title VARCHAR(50) NOT NULL UNIQUE,
    singer_id BIGINT NOT NULL,
    FOREIGN KEY (singer_id) REFERENCES singers_filtered_spring(singer_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.songs_filtered_spring (
    song_id BIGINT PRIMARY KEY,
    title VARCHAR(50) NOT NULL UNIQUE,
    album_id BIGINT NOT NULL,
    FOREIGN KEY (album_id) REFERENCES albums_filtered_spring(album_id) ON DELETE CASCADE
);


