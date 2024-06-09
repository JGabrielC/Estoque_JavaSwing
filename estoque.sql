USE estoque;


CREATE TABLE categoria(
	CategoryCod int primary key not null AUTO_INCREMENT,
	Names varchar(40) not null,
	Descriptions varchar(140)
);

CREATE TABLE produtos(
	ID int primary key AUTO_INCREMENT,
	Nome varchar(40) NOT NULL,
    Modelo varchar(40),
    Cor varchar(40),
	Categoria int not null,
	Preco float not null,
	Quantidade int, 
    FOREIGN KEY (categoria) REFERENCES categoria(CategoryCod)
	);

CREATE TABLE users(
	UserID int primary key not null AUTO_INCREMENT,
	UserName varchar(40) not null unique,
	UserPassword char(4) not null,
	UserLevel int not null 
	);

INSERT INTO users 
(UserName, UserLevel, UserPassword) values
('jhon', 2, 1402),
('admin', 2, 0000),
('davi', 2, 2024),
('user', 1, 1234);

INSERT INTO categoria
(Names) values
('capinha'),
('pelicula'), 
('fone com fio'), 
('fone sem fio'), 
('fonte carregador'), 
('cabo'), 
('teclado'), 
('mouse'),
('controle');


