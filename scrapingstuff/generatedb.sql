-- MySQL Script generated by MySQL Workbench
-- Wed Jul 25 18:34:49 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema playerdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema playerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `playerdb` DEFAULT CHARACTER SET utf8 ;
USE `playerdb` ;

-- -----------------------------------------------------
-- Table `playerdb`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `playerdb`.`players` (
  `idplayers` INT NOT NULL AUTO_INCREMENT,
  `team` VARCHAR(45) NULL,
  `age` INT NULL,
  `name` VARCHAR(45) NULL,
  `pos` VARCHAR(45) NULL,
  `gp` INT NULL,
  `CF` INT NULL,
  `CA` INT NULL,
  `CFpercent` DECIMAL NULL,
  `CFpercentRel` DECIMAL NULL,
  `FF` INT NULL,
  `FA` INT NULL,
  `FFpercent` DECIMAL NULL,
  `FFpercentRel` DECIMAL NULL,
  `oiSHpercent` DECIMAL NULL,
  `oiSVpercent` DECIMAL NULL,
  `PDO` DECIMAL NULL,
  `oZSpercent` DECIMAL NULL,
  `dZSpercent` DECIMAL NULL,
  `TOI60` TIME NULL,
  `TOIEV` TIME NULL,
  `TK` INT NULL,
  `GV` INT NULL,
  `Eplusminus` DECIMAL NULL,
  `Satt` INT NULL,
  `Thrupercent` DECIMAL NULL,
  PRIMARY KEY (`idplayers`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
