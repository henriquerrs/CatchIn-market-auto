SHOW DATABASES;
USE supermercado_catchin;

SHOW TABLES;

INSERT INTO privilegios(tipo) VALUES
('Admin'),
('Gerente'),
('Trabalhador'),
('Cliente');

INSERT INTO produtos(nome, preco, peso, quantidade, marca, categoria, descricao) VALUES
('BATATAO',1.50,1,500,'Batata do Vale','Legumenosas','É batata, tenho certeza'),
('CARNE',1.50,1,500,'Carne do Vale','Carnosas','É carne, tenho certeza'),
('ARROZ',1.50,1,500,'Arroz do Vale','Carboidratosas','É arroz, tenho certeza'),
('FEIJAO',1.50,1,500,'Feijao do Vale','Ferrosas','É feijão, tenho certeza');

INSERT INTO pessoas(nome,senha,email,cpf,idade,telefone,id_privilegio) VALUES
('Crispim','123','crispim@gmail.com','11111111111',20,'33333333',1),
('Sara','123','Sara@gmail.com','11111111111',21,'33333333',2),
('Leonardo','123','Leonardo@gmail.com','11111111111',18,'33333333',3),
('Henrique','123','Henrique@gmail.com','11111111111',17,'33333333',4);

INSERT INTO compras(total) VALUES
(1.10),
(2.10),
(3.10),
(4.10);

INSERT INTO clientes(endereco, id_compra, id_pessoa) VALUES
('Rua AAA',1,1),
('Rua BBB',2,2),
('Rua CCC',3,3),
('Rua DDD',4,4);

INSERT INTO colaboradores(cargo,id_pessoa) VALUES
('Gerente',1),
('Caixa',2),
('Limpeza',3),
('Frigorifico',4);

INSERT INTO itens (quantidade,id_compra,id_produto) VALUES
(1,2,1),
(2,2,2),
(2,2,2),
(3,2,1);

SELECT * FROM privilegios;
SELECT * FROM produtos;
SELECT * FROM pessoas;
SELECT * FROM compras;
SELECT * FROM clientes;
SELECT * FROM colaboradores;
SELECT * FROM itens;