SHOW DATABASES;
USE supermercado_catchin;

SHOW TABLES;

INSERT INTO privilegios(tipo) VALUES
('Admin'),
('Gerente'),
('Trabalhador'),
('Cliente');

INSERT INTO produtos(nome, preco, peso, quantidade, marca, categoria, descricao) VALUES
('BATATA LIMPA',10.00,1000,1,'Batata do Vale','Tuberculo','É batata, tenho certeza'),
('BATATA SUJA',8.00,1000,1,'Batata do Vale','Tuberculo','É batata suja, tenho certeza'),
('PALETA 7',19.00,1000,1,'Friboi','Carnosas','É carne, tenho certeza'),
('MAMINHA',16.00,1000,1,'Friboi','Carnosas','É carne, tenho certeza'),
('PICANHA',25.00,1000,1,'Friboi','Carnosas','É carne, tenho certeza'),
('COSTELA',29.00,1000,1,'Friboi','Carnosas','É carne, tenho certeza'),
('FRALDINHA',19.00,1000,1,'Friboi','Carnosas','É carne, tenho certeza'),
('ALCATRA',30.00,1000,1,'Friboi','Carnosas','É carne, tenho certeza'),
('PATINHO',23.00,1000,1,'Friboi','Carnosas','É carne, tenho certeza'),
('FRANGO',14.00,1000,1,'Friboi','Carnosas','É carne, tenho certeza'),
('LINGUIÇINHA TOSCANA ',15.99,1000,1,'Friboi','Carnosas','É linguiça, tenho certeza'),
('LINGUIÇA DE FRANGO',10.00,1000,1,'Friboi','Carnosas','É linguiça, tenho certeza'),
('ARROZ BRANCO',10.00,500,1,'Arroz Buriti','Carboidratosas','É arroz, tenho certeza'),
('ARROZ INTEGRAL',15.99,500,1,'Arroz Buriti','Carboidratosas','É arroz, tenho certeza'),
('ARROZ CHINES',8.99,500,1,'Arroz Buriti','Carboidratosas','É arroz, tenho certeza'),
('MACARRÃO PARAFUSO',2.50,500,1,'Galo','Carboidratosas','É macarrão, tenho certeza'),
('MACARRÃO ESPAGUETE',2.80,500,1,'Galo','Carboidratosas','É macarrão, tenho certeza'),
('MACARRÃO PENNE',2.38,500,1,'Galo','Carboidratosas','É macarrão, tenho certeza'),
('LÁMEN',1.50,200,1,'Galo','Carboidratosas','É macarrão, tenho certeza'),
('MIOJO',0.99,200,1,'Galo','Carboidratosas','É macarrão, tenho certeza'),
('FEIJÃO CARIOCA',4.15,1000,1,'Urbano','Carboidratosas','É feijão, tenho certeza'),
('FEIJÃO PRETO',4.79,1000,1,'Urbano','Carboidratosas','É feijão, tenho certeza'),
('FEIJÃO VERMELHO',5.50,1000,1,'Urbano','Carboidratosas','É feijão, tenho certeza'),
('SUCO TANG',1.35,30,1,'Tang','Carboidratosas','É suco, tenho certeza'),
('SUCO FRESH',0.99,30,1,'Fresh','Carboidratosas','É suco, tenho certeza'),
('SUCO KISUCO',1.19,30,1,'Kisuco','Carboidratosas','É suco, tenho certeza'),
('PEPSI',2.50,600,1,'Pepsi','Carboidratosas','É refrigerante, tenho certeza'),
('PEPSI',3.25,1000,1,'Pepsi','Carboidratosas','É refrigerante, tenho certeza'),
('PEPSI',3.65,1500,1,'Pepsi','Carboidratosas','É refrigerante, tenho certeza'),
('PEPSI',4.99,2000,1,'Pepsi','Carboidratosas','É refrigerante, tenho certeza'),
('PEPSI',5.50,3000,1,'Pepsi','Carboidratosas','É refrigerante, tenho certeza'),
('COCA-COLA',2.50,600,1,'Coca-cola','Carboidratosas','É refrigerante, tenho certeza'),
('COCA-COLA',3.25,1000,1,'Coca-cola','Carboidratosas','É refrigerante, tenho certeza'),
('COCA-COLA',3.65,1500,1,'Coca-cola','Carboidratosas','É refrigerante, tenho certeza'),
('COCA-COLA',4.99,2000,1,'Coca-cola','Carboidratosas','É refrigerante, tenho certeza'),
('COCA-COLA',5.50,3000,1,'Coca-cola','Carboidratosas','É refrigerante, tenho certeza'),
('GUARANÁ',2.50,600,1,'Guaraná','Carboidratosas','É refrigerante, tenho certeza'),
('GUARANÁ',3.25,1000,1,'Guaraná','Carboidratosas','É refrigerante, tenho certeza'),
('GUARANÁ',3.65,1500,1,'Guaraná','Carboidratosas','É refrigerante, tenho certeza'),
('GUARANÁ',4.99,2000,1,'Guaraná','Carboidratosas','É refrigerante, tenho certeza'),
('GUARANÁ',5.50,3000,1,'Guaraná','Carboidratosas','É refrigerante, tenho certeza'),
('SPRITE',2.50,600,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SPRITE',3.25,1000,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SPRITE',3.65,1500,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SPRITE',4.99,2000,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SPRITE',5.50,3000,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SUKITA',2.50,600,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SUKITA',3.25,1000,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SUKITA',3.65,1500,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SUKITA',4.99,2000,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('SUKITA',5.50,3000,1,'Sprite','Carboidratosas','É refrigerante, tenho certeza'),
('FANTA',2.50,600,1,'Fanta','Carboidratosas','É refrigerante, tenho certeza'),
('FANTA',3.25,1000,1,'Fanta','Carboidratosas','É refrigerante, tenho certeza'),
('FANTA',3.65,1500,1,'Fanta','Carboidratosas','É refrigerante, tenho certeza'),
('FANTA',4.99,2000,1,'Fanta','Carboidratosas','É refrigerante, tenho certeza'),
('FANTA',5.50,3000,1,'Fanta','Carboidratosas','É refrigerante, tenho certeza'),
('AÇUCAR',1.60,1000,1,'Caravelas','Carboidratosas','É açucar, tenho certeza'),
('AÇUCAR',7.99,5000,1,'Caravelas','Carboidratosas','É açucar, tenho certeza'),
('SAL',2.99,1000,1,'Cisne','Carboidratosas','É sal, tenho certeza'),
('SAL',8.85,1000,1,'Cisne','Carboidratosas','É sal, tenho certeza'),
('SAL ROSA',3.99,1000,1,'Cisne','Carboidratosas','É sal, tenho certeza'),
('SAL ROSA',20.85,5000,1,'Cisne','Carboidratosas','É sal, tenho certeza');

INSERT INTO pessoas(nome,senha,email,cpf,idade,telefone,id_privilegio) VALUES
('Crispim','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','crispim@gmail.com','111.111.111-11',20,'(47)9 8866-4058',1),
('Sara','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','Sara@gmail.com','222.222.222-22',21,'(47)9 1234-5678',4),
('Leonardo','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','Leonardo@gmail.com','333.333.333-33',18,'(47)9 9793-1575',3),
('Henríque','3c9909afec25354d551dae21590bb26e38d53f2173b8d3dc3eee4c047e7ab1c1eb8b85103e3be7ba613b31bb5c9c36214dc9f14a42fd7a2fdb84856bca5c44c2','Henrique@gmail.com','444.444.444-44',17,'(47)9 9738-2791',4);

INSERT INTO compras(total) VALUES
(1.10),
(2.10),
(3.10),
(4.10);

INSERT INTO listas() VALUES
(),
(),
(),
();

INSERT INTO clientes(logradouro, id_compra, id_pessoa, id_lista,cep,complemento,bairro,cidade,uf,numero) VALUES
('Rua AAA',1,1,1,'798797979','A','Azinho','Azao','AA','321'),
('Rua BBB',2,2,2,'798797979','B','Bzinho','Bzao','BB','321'),
('Rua CCC',3,3,3,'798797979','C','Czinho','Czao','CC','321'),
('Rua DDD',4,4,4,'798797979','D','Dzinho','Dzao','CC','321');

INSERT INTO colaboradores(cargo,id_pessoa) VALUES
('Gerente',1),
('Caixa',2),
('Limpeza',3),
('Frigorifico',4);

INSERT INTO itens (quantidade,id_compra,id_produto) VALUES
(1,2,1),
(2,2,2),
(2,2,3),
(3,2,4);

INSERT INTO produto_lista (quantidade,id_lista,id_produto) VALUES
(20,4,20);

#SELECT * FROM privilegios;
#SELECT * FROM produtos;
SELECT * FROM pessoas;
#SELECT * FROM compras;
SELECT * FROM clientes;
#SELECT * FROM colaboradores;
#SELECT * FROM itens;