SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema supermercado_catchin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supermercado_catchin` DEFAULT CHARACTER SET utf8 ;
USE `supermercado_catchin` ;

-- -----------------------------------------------------
-- Table `supermercado_catchin`.`privilegios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`privilegios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`pessoas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`pessoas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `senha` VARCHAR(20) NULL,
  `email` VARCHAR(350) NULL,
  `cpf` VARCHAR(11) NULL,
  `idade` TINYINT NULL,
  `telefone` VARCHAR(45) NULL,
  `id_privilegio` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pessoas_privilegios1_idx` (`id_privilegio` ASC),
  CONSTRAINT `fk_pessoas_privilegios1`
    FOREIGN KEY (`id_privilegio`)
    REFERENCES `supermercado_catchin`.`privilegios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(45) NULL,
  `id_pessoa` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clientes_pessoas1_idx` (`id_pessoa` ASC),
  CONSTRAINT `fk_clientes_pessoas1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `supermercado_catchin`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`colaboradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`colaboradores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(45) NULL DEFAULT NULL,
  `id_pessoa` INT NOT NULL,
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
-- Table `supermercado_catchin`.`listas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`listas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  INDEX `fk_Clientes_has_Produtos_Clientes1_idx` (`id_cliente` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Clientes_has_Produtos_Clientes1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `supermercado_catchin`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `preco` DOUBLE NULL,
  `peso` DOUBLE NULL DEFAULT NULL,
  `quantidade` INT NULL DEFAULT NULL,
  `marca` VARCHAR(30) NULL DEFAULT NULL,
  `categoria` VARCHAR(30) NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`produtos_listas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`produtos_listas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_lista` INT NOT NULL,
  `id_produto` INT NOT NULL,
  `quantidade` INT NULL,
  INDEX `fk_DefaultCompras_has_Produtos_Produtos1_idx` (`id_produto` ASC),
  INDEX `fk_DefaultCompras_has_Produtos_DefaultCompras1_idx` (`id_lista` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_DefaultCompras_has_Produtos_DefaultCompras1`
    FOREIGN KEY (`id_lista`)
    REFERENCES `supermercado_catchin`.`listas` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DefaultCompras_has_Produtos_Produtos1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `supermercado_catchin`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`compras` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_cliente` INT NOT NULL,
  `total` DOUBLE NULL,
  INDEX `fk_Clientes_has_Produtos_Clientes_idx` (`id_cliente` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Clientes_has_Produtos_Clientes`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `supermercado_catchin`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_catchin`.`itens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_catchin`.`itens` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` TINYINT NULL,
  `id_compra` INT NOT NULL,
  `id_produto` INT NOT NULL,
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
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
