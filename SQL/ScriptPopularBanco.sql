SHOW DATABASES;
USE supermercado_catchin;

SHOW TABLES;

SELECT * FROM privilegios;
INSERT INTO privilegios(tipo) VALUES
('Admin'),
('Gerente'),
('Trabalhador'),
('Cliente');

SELECT * FROM produtos;
INSERT INTO produtos(nome, preco, peso, quantidade, marca, categoria, descricao) VALUES
('BATATAO',1.50,1,500,'Batata do Vale','Legumenosas','É batata, tenho certeza'),
('CARNE',1.50,1,500,'Carne do Vale','Carnosas','É carne, tenho certeza'),
('ARROZ',1.50,1,500,'Arroz do Vale','Carboidratosas','É arroz, tenho certeza'),
('FEIJAO',1.50,1,500,'Feijao do Vale','Ferrosas','É feijão, tenho certeza');

SELECT * FROM pessoas;
INSERT INTO pessoas(nome,senha,email,cpf,idade,telefone,id_privilegio) VALUES
('Crispim','123','crispim@gmail.com','11111111111',20,'33333333',1),
('HenriP0N31','123','henrique@gmail.com','11111111111',21,'33333333',2),
('LeonardoMaria','123','leonardo@gmail.com','11111111111',18,'33333333',3),
('SaraComH','123','sara@gmail.com','11111111111',17,'33333333',1);

SELECT * FROM clientes;
INSERT INTO clientes(endereco, id_pessoa) VALUES
('Rua AAA',3),
('Rua BBB',3),
('Rua CCC',3),
('Rua DDD',3);

SELECT * FROM colaboradores;
INSERT INTO colaboradores(cargo,id_pessoa) VALUES
('Gerente',1),
('Caixa',2),
('Limpeza',3),
('Frigorifico',4);

SELECT * FROM compras;
INSERT INTO compras(id_cliente,total) VALUES
(1,10),
(1,20),
(1,30),
(1,40);

SELECT * FROM itens;
INSERT INTO itens (quantidade,id_compra,id_produto) VALUES
(1,1,1),
(2,1,2),
(2,1,2),
(3,1,1);
