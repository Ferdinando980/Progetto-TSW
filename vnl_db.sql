drop database if exists vnl;
create database vnl;
use vnl;

-- Updated users table with auto-incremented id
create table users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username varchar(20) not null,
    email varchar(40) not null,
    password varchar(255) not null,
    data_di_nascita date not null,
    numero_di_telefono varchar(30) not null,
    tipo varchar(5) not null
);

-- Updated ordine table with auto-incremented id and users
create table ordine(
    id INT AUTO_INCREMENT PRIMARY KEY, -- auto-generated id
    users INT, -- changed to INT to match users(id)
    stato varchar(10) not null,
    dataOrdine date not null,
    totAmount float default 0,
    nome varchar(20) not null,
    cognome varchar(20) not null,
    via varchar(40) not null,
    civico varchar(5) not null,
    cap int not null,
    paese varchar(20) not null,
    foreign key (users) references users(id),
    unique key (id, users)  -- Add the composite index for foreign key reference
);

-- Updated prodotto table with auto-incremented id
create table prodotto(
    id INT AUTO_INCREMENT PRIMARY KEY, -- auto-generated id
    prezzo float not null,
    descrizione varchar(50) not null,
    condizione varchar(5) not null,
    tipo varchar(10) not null,
    marca varchar(20),
    nomeVnl varchar(50),
    artista varchar(50),
    genere varchar(20),
    img_path varchar(255)
);

-- Updated OP table with auto-incremented ordine_id and ordine_users
create table OP(
    ordine_id INT, 
    ordine_users INT,
    prodotto INT,
    quantita int not null,
    prezzo float not null,
    foreign key (ordine_id, ordine_users) references ordine(id, users),
    foreign key (prodotto) references prodotto(id),
    primary key(ordine_id, ordine_users, prodotto)
);
