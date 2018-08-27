SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema supermercado_gemidao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supermercado_gemidao` DEFAULT CHARACTER SET utf8 ;
USE `supermercado_gemidao` ;

-- -----------------------------------------------------
-- Table `supermercado_gemidao`.`privilegios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`privilegios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_gemidao`.`pessoas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`pessoas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `senha` VARCHAR(20) NULL,
  `email` VARCHAR(350) NULL,
  `cpf` VARCHAR(11) NULL,
  `idade` TINYINT NULL,
  `telefone` VARCHAR(45) NULL,
  `id_privilegios` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pessoas_privilegios1_idx` (`id_privilegios` ASC),
  CONSTRAINT `fk_pessoas_privilegios1`
    FOREIGN KEY (`id_privilegios`)
    REFERENCES `supermercado_gemidao`.`privilegios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supermercado_gemidao`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `endereco` VARCHAR(45) NULL,
  `id_pessoas` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_clientes_pessoas1_idx` (`id_pessoas` ASC),
  CONSTRAINT `fk_clientes_pessoas1`
    FOREIGN KEY (`id_pessoas`)
    REFERENCES `supermercado_gemidao`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_gemidao`.`colaboradores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`colaboradores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cargo` VARCHAR(45) NULL DEFAULT NULL,
  `id_pessoas` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_colaboradores_pessoas1_idx` (`id_pessoas` ASC),
  CONSTRAINT `fk_colaboradores_pessoas1`
    FOREIGN KEY (`id_pessoas`)
    REFERENCES `supermercado_gemidao`.`pessoas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_gemidao`.`listas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`listas` (
  `id_clientes` INT NOT NULL,
  INDEX `fk_Clientes_has_Produtos_Clientes1_idx` (`id_clientes` ASC),
  PRIMARY KEY (`id_clientes`),
  CONSTRAINT `fk_Clientes_has_Produtos_Clientes1`
    FOREIGN KEY (`id_clientes`)
    REFERENCES `supermercado_gemidao`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_gemidao`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`produtos` (
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
-- Table `supermercado_gemidao`.`produtos_listas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`produtos_listas` (
  `id_listas` INT NOT NULL,
  `id_produtos` INT NOT NULL,
  `quantidade` INT NULL,
  PRIMARY KEY (`id_listas`, `id_produtos`),
  INDEX `fk_DefaultCompras_has_Produtos_Produtos1_idx` (`id_produtos` ASC),
  INDEX `fk_DefaultCompras_has_Produtos_DefaultCompras1_idx` (`id_listas` ASC),
  CONSTRAINT `fk_DefaultCompras_has_Produtos_DefaultCompras1`
    FOREIGN KEY (`id_listas`)
    REFERENCES `supermercado_gemidao`.`listas` (`id_clientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DefaultCompras_has_Produtos_Produtos1`
    FOREIGN KEY (`id_produtos`)
    REFERENCES `supermercado_gemidao`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_gemidao`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`compras` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_clientes` INT NOT NULL,
  `total` DOUBLE NULL,
  INDEX `fk_Clientes_has_Produtos_Clientes_idx` (`id_clientes` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Clientes_has_Produtos_Clientes`
    FOREIGN KEY (`id_clientes`)
    REFERENCES `supermercado_gemidao`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `supermercado_gemidao`.`itens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `supermercado_gemidao`.`itens` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` TINYINT NULL,
  `id_compras` INT NOT NULL,
  `id_produtos` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_itens_compras1_idx` (`id_compras` ASC),
  INDEX `fk_itens_produtos1_idx` (`id_produtos` ASC),
  CONSTRAINT `fk_itens_compras1`
    FOREIGN KEY (`id_compras`)
    REFERENCES `supermercado_gemidao`.`compras` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itens_produtos1`
    FOREIGN KEY (`id_produtos`)
    REFERENCES `supermercado_gemidao`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

