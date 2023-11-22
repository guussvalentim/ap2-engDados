CREATE DATABASE IF NOT EXISTS Sound;

use Sound;

CREATE TABLE IF NOT EXISTS Autor (
	id_autor int not null auto_increment,
	cpf varchar(11) not null,
	nome_orig varchar(100),
	nome_art varchar(100),
	PRIMARY KEY  (id_autor)
);

CREATE TABLE IF NOT EXISTS Categoria (
	id_categoria int not null auto_increment,
	nome_cat varchar(20),
    PRIMARY KEY (id_categoria)
);

CREATE TABLE IF NOT EXISTS Musica (
	id_musica int not null auto_increment,
	nome_mus varchar(50),
	data_lancamento date,
    fk_categoria_id int not null,
    
    PRIMARY KEY (id_musica),
    CONSTRAINT fk_categoria FOREIGN KEY (fk_categoria_id) REFERENCES Categoria (id_categoria) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS MusicaAutor (
id_relacao int not null auto_increment,
fk_id_musica int not null,
fk_id_autor int not null,


PRIMARY KEY (id_relacao),
CONSTRAINT fk_musica foreign key (fk_id_musica) references Musica (id_musica) on delete cascade on update cascade,
CONSTRAINT fk_autor foreign key (fk_id_autor) references Autor (id_autor) on delete cascade on update cascade
);





