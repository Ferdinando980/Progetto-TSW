drop database vnl;
create database vnl;
use vnl;

create table users(
	id varchar(5) primary key,
    username varchar(20) not null,
    email varchar(40) not null,
    password varchar(50) not null,
    data_di_nascita date not null,
	numero_di_telefono varchar(13) not null,
    tipo varchar(5) not null 
);

create table ordine(
	id varchar(5),
    users varchar(5),
    nome varchar(20) not null,
    cognome varchar(20) not null,
    via varchar(40) not null,
    civico varchar(5) not null,
    cap int not null,
    paese varchar(20) not null,
    totAmount float default 0,
    foreign key (users) references users(id),
    primary key(id, users)
);

create table prodotto(
	id varchar(5) primary key,
    prezzo float not null,
    descrizione varchar(50) not null,
    condizione varchar(5) not null,
    tipo varchar(10) not null,
    marca varchar(20),
    modello varchar(20),
    nomeVnl varchar(20),
    artista varchar(50),
    genere varchar(20)
);

create table OP(
	ordine_id varchar(5),
    ordine_users varchar(5),
    prodotto varchar(5),
    foreign key (ordine_id, ordine_users) references ordine(id, users),
    foreign key (prodotto) references prodotto(id),
    primary key(ordine_id, ordine_users, prodotto)
);