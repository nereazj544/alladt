--! TABLAS
create table empresa(
    id int auto_increment PRIMARY KEY,
    nombre VARCHAR(255) NOT Null
);

create table personajes(
    id int auto_increment PRIMARY KEY,
    nombre VARCHAR(255) NOT Null,
    juego  VARCHAR(255) NOT Null,
    empresa_id int,
    foreign key (empresa_id) references empresa(id)
);

--! DATOS INSETAR
insert INTO empresa (nombre) values ('Hoyoverse'), ('Kuro Game'), ('Level-5');


insert INTO personajes (nombre, juego, empresa_id) values
('Bennett', 'Genshin Impact', 1),
('Kazuha', 'Genshin Impact', 1),
('Arlecchino', 'Genshin Impact', 1),
('Xiao', 'Genshin Impact', 1),
('Jing Yan', 'Honkai Star Rail', 1),
('Kafka', 'Honkai Star Rail', 1),
('Gepard', 'Honkai Star Rail', 1),
('Topaz y Conti', 'Honkai Star Rail', 1),
('Jiyan', 'Wuthering Waves', 2),
('Calcharo', 'Wuthering Waves', 2),
('Lingyang', 'Wuthering Waves', 2),
('Encore', 'Wuthering Waves', 2),
('Arion', 'Inazuma Eleven', 3),
('Mark', 'Inazuma Eleven', 3),
('Umei', 'Inazuma Eleven', 3),
('Sonny', 'Inazuma Eleven', 3);