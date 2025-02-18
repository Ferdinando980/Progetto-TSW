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

-- Inserimento Prodotti

INSERT INTO prodotto (prezzo, descrizione, condizione, tipo, marca, nomeVnl, artista, genere, img_path) VALUES
-- 🎵 Vinili
(29.99, 'Vinile classico', 'Nuovo', 'vinile', NULL, 'Abbey Road', 'The Beatles', 'Rock', 'assets/product/abbey road.jpg'),
(24.50, 'Vinile anni 80', 'Usato', 'vinile', NULL, 'Thriller', 'Michael Jackson', 'Pop', 'assets/product/thriller.jpg'),
(21.99, 'Vinile jazz vintage', 'Nuovo', 'vinile', NULL, 'Kind of Blue', 'Miles Davis', 'Jazz', 'assets/product/kind of blue.jpg'),
(19.99, 'Vinile colonna sonora', 'Usato', 'vinile', NULL, 'Interstellar OST', 'Hans Zimmer', 'Colonna Sonora', 'assets/product/interstellar.jpg'),
(22.99, 'Vinile classico rock', 'Nuovo', 'vinile', NULL, 'Dark Side of the Moon', 'Pink Floyd', 'Rock', 'assets/product/dark side of the moon.jpg'),
(18.50, 'Vinile soul', 'Usato', 'vinile', NULL, 'Back to Black', 'Amy Winehouse', 'Soul', 'assets/product/back to black.jpg'),
(26.99, 'Vinile collezione rap', 'Nuovo', 'vinile', NULL, 'Illmatic', 'Nas', 'Hip-Hop', 'assets/product/illmatic.jpg'),
(23.99, 'Vinile classico blues', 'Usato', 'vinile', NULL, 'The Essential BB King', 'BB King', 'Blues', 'assets/product/the essential bb king.jpg'),
(19.50, 'Vinile elettronico', 'Nuovo', 'vinile', NULL, 'Random Access Memories', 'Daft Punk', 'Elettronica', 'assets/product/random access memory.jpg'),
(20.00, 'Vinile alternative rock', 'Nuovo', 'vinile', NULL, 'OK Computer', 'Radiohead', 'Alternative', 'assets/product/ok computer.jpg'),

-- 💿 CD
(14.99, 'CD classico pop', 'Nuovo', 'cd', NULL, '25', 'Adele', 'Pop', 'assets/product/25.jpg'),
(12.50, 'CD anni 90 rock', 'Usato', 'cd', NULL, 'Nevermind', 'Nirvana', 'Grunge', 'assets/product/nevermind.jpg'),
(16.00, 'CD jazz fusion', 'Nuovo', 'cd', NULL, 'Bitches Brew', 'Miles Davis', 'Jazz Fusion', 'assets/product/bitches brew.jpg'),
(13.99, 'CD classico metal', 'Usato', 'cd', NULL, 'Master of Puppets', 'Metallica', 'Metal', 'assets/product/master of puppets.jpg'),
(15.50, 'CD pop moderno', 'Nuovo', 'cd', NULL, 'Future Nostalgia', 'Dua Lipa', 'Pop', 'assets/product/future nostalgia.jpg'),
(11.99, 'CD elettronico', 'Nuovo', 'cd', NULL, 'Discovery', 'Daft Punk', 'Elettronica', 'assets/product/discovery.jpg'),

-- 🎛️ Giradischi
(149.99, 'Giradischi entry-level', 'Nuovo', 'giradischi', 'Audio-Technica', 'AT-LP60X', NULL, NULL, 'assets/product/audio-technica.jpg'),
(199.99, 'Giradischi hi-fi', 'Nuovo', 'giradischi', 'Sony', 'PS-LX310BT', NULL, NULL, 'assets/product/sony.jpg'),
(249.99, 'Giradischi vintage', 'Usato', 'giradischi', 'Technics', 'SL-1200MK2', NULL, NULL, 'assets/product/technics.jpg'),
(179.99, 'Giradischi professionale', 'Nuovo', 'giradischi', 'Pioneer', 'PLX-500', NULL, NULL, 'assets/product/pioneer.jpg');

INSERT INTO users (username,email,password,data_di_nascita,numero_di_telefono,tipo) VALUES
('ceuto97', 'cerusoantonio97@gmail.com', 'Prova1997!', '1997-07-21', '3806316445','admin');
