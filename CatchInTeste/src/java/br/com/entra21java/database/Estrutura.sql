-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS supermercado_catchin;
-- -----------------------------------------------------
-- Schema supermercado_catchin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supermercado_catchin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `supermercado_catchin` ;

-- -----------------------------------------------------
-- Table `supermercado_catchin`.`privilegios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`privilegios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`pessoas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`pessoas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `senha` VARCHAR(150) NULL DEFAULT NULL,
  `email` VARCHAR(350) NULL DEFAULT NULL,
  `cpf` VARCHAR(14) NULL DEFAULT NULL,
  `idade` TINYINT(4) NULL DEFAULT NULL,
  `telefone` VARCHAR(45) NULL DEFAULT NULL,
  `id_privilegio` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pessoas_privilegios1_idx` (`id_privilegio` ASC),
  CONSTRAINT `fk_pessoas_privilegios1`
    FOREIGN KEY (`id_privilegio`)
    REFERENCES `supermercado_catchin`.`privilegios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`compras` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `total` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`listas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`listas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`clientes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(45) NULL DEFAULT NULL,
  `id_pessoa` INT(11) NOT NULL,
  `id_compra` INT(11) NOT NULL,
  `id_lista` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clientes_pessoas1_idx` (`id_pessoa` ASC),
  INDEX `fk_clientes_compras1_idx` (`id_compra` ASC),
  INDEX `fk_clientes_listas1_idx` (`id_lista` ASC),
  CONSTRAINT `fk_clientes_pessoas1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `supermercado_catchin`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientes_compras1`
    FOREIGN KEY (`id_compra`)
    REFERENCES `supermercado_catchin`.`compras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientes_listas1`
    FOREIGN KEY (`id_lista`)
    REFERENCES `supermercado_catchin`.`listas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`colaboradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`colaboradores` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(45) NULL DEFAULT NULL,
  `id_pessoa` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_colaboradores_pessoas1_idx` (`id_pessoa` ASC),
  CONSTRAINT `fk_colaboradores_pessoas1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `supermercado_catchin`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`produtos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `preco` DOUBLE NULL DEFAULT NULL,
  `peso` DOUBLE NULL DEFAULT NULL,
  `quantidade` INT(11) NULL DEFAULT NULL,
  `marca` VARCHAR(30) NULL DEFAULT NULL,
  `categoria` VARCHAR(30) NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`itens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`itens` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `quantidade` TINYINT(4) NULL DEFAULT NULL,
  `id_compra` INT(11) NOT NULL,
  `id_produto` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_itens_compras1_idx` (`id_compra` ASC),
  INDEX `fk_itens_produtos1_idx` (`id_produto` ASC),
  CONSTRAINT `fk_itens_compras1`
    FOREIGN KEY (`id_compra`)
    REFERENCES `supermercado_catchin`.`compras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_produtos1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `supermercado_catchin`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`produto_lista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`produto_lista` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_produto` INT(11) NOT NULL,
  `id_lista` INT(11) NOT NULL,
  `quantidade` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_DefaultCompras_has_Produtos_Produtos1_idx` (`id_produto` ASC),
  INDEX `fk_produtos_listas_listas1_idx` (`id_lista` ASC),
  CONSTRAINT `fk_DefaultCompras_has_Produtos_Produtos1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `supermercado_catchin`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_listas_listas1`
    FOREIGN KEY (`id_lista`)
    REFERENCES `supermercado_catchin`.`listas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
