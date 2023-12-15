-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema star_wars
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `star_wars` ;

-- -----------------------------------------------------
-- Schema star_wars
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `star_wars` DEFAULT CHARACTER SET latin1 ;
USE `star_wars` ;

-- -----------------------------------------------------
-- Table `star_wars`.`films`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`films` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`films` (
  `id` INT NOT NULL,
  `title` VARCHAR(80) NULL DEFAULT NULL,
  `director` VARCHAR(60) NULL DEFAULT NULL,
  `producer` TEXT NULL DEFAULT NULL,
  `episode_id` INT NULL DEFAULT '0',
  `opening_crawl` LONGTEXT NULL DEFAULT NULL,
  `release_date` TIMESTAMP(3) NULL DEFAULT NULL,
  `created` TIMESTAMP NULL DEFAULT NULL,
  `edited` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `episode_id` (`episode_id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`planets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`planets` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`planets` (
  `id` INT NOT NULL,
  `name` VARCHAR(60) NULL DEFAULT NULL,
  `climate` TEXT NULL DEFAULT NULL,
  `rotation_period` INT NULL DEFAULT '0',
  `orbital_period` INT NULL DEFAULT '0',
  `diameter` INT NULL DEFAULT '0',
  `gravity` TEXT NULL DEFAULT NULL,
  `terrain` TEXT NULL DEFAULT NULL,
  `surface_water` VARCHAR(10) NULL DEFAULT NULL,
  `population` BIGINT NULL DEFAULT NULL,
  `created` TIMESTAMP NULL DEFAULT NULL,
  `edited` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `star_wars`.`species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`species` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`species` (
  `id` INT NOT NULL,
  `name` VARCHAR(60) NULL DEFAULT NULL,
  `average_height` VARCHAR(10) NULL DEFAULT NULL,
  `average_lifespan` VARCHAR(20) NULL DEFAULT NULL,
  `classification` VARCHAR(50) NULL DEFAULT NULL,
  `designation` VARCHAR(60) NULL DEFAULT NULL,
  `eye_colors` TEXT NULL DEFAULT NULL,
  `hair_colors` TEXT NULL DEFAULT NULL,
  `homeworld` INT NOT NULL DEFAULT '0',
  `language` VARCHAR(20) NULL DEFAULT NULL,
  `skin_colors` TEXT NULL DEFAULT NULL,
  `created` TIMESTAMP NULL DEFAULT NULL,
  `edited` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `homeworld` (`homeworld` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`people`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`people` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`people` (
  `id` INT NOT NULL,
  `name` VARCHAR(80) NULL DEFAULT NULL,
  `gender` VARCHAR(15) NULL DEFAULT NULL,
  `birth_year` VARCHAR(10) NULL DEFAULT NULL,
  `height` SMALLINT NOT NULL DEFAULT '0',
  `mass` FLOAT NOT NULL,
  `hair_color` VARCHAR(20) NULL DEFAULT NULL,
  `skin_color` VARCHAR(30) NULL DEFAULT NULL,
  `eye_color` VARCHAR(20) NULL DEFAULT NULL,
  `homeworld_id` INT NOT NULL DEFAULT '0',
  `species_id` INT NOT NULL DEFAULT '0',
  `created` TIMESTAMP NULL DEFAULT NULL,
  `edited` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `homeworld` (`homeworld_id` ASC) VISIBLE,
  CONSTRAINT `s3t_people_homeworld_0`
    FOREIGN KEY (`homeworld_id`)
    REFERENCES `star_wars`.`planets` (`id`),
  CONSTRAINT `s3t_people_species_0`
    FOREIGN KEY (`species_id`)
    REFERENCES `star_wars`.`species` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`films_characters`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`films_characters` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`films_characters` (
  `film_id` INT NOT NULL,
  `people_id` INT NOT NULL,
  PRIMARY KEY (`film_id`, `people_id`),
  INDEX `s3t_characters_films_1` (`people_id` ASC) VISIBLE,
  CONSTRAINT `s3t_characters_films_0`
    FOREIGN KEY (`film_id`)
    REFERENCES `star_wars`.`films` (`id`),
  CONSTRAINT `s3t_characters_films_1`
    FOREIGN KEY (`people_id`)
    REFERENCES `star_wars`.`people` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`films_planets`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`films_planets` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`films_planets` (
  `film_id` INT NOT NULL,
  `planet_id` INT NOT NULL,
  PRIMARY KEY (`film_id`, `planet_id`),
  INDEX `s3t_films_planets_films_1` (`planet_id` ASC) VISIBLE,
  CONSTRAINT `s3t_films_planets_films_0`
    FOREIGN KEY (`film_id`)
    REFERENCES `star_wars`.`films` (`id`),
  CONSTRAINT `s3t_films_planets_films_1`
    FOREIGN KEY (`planet_id`)
    REFERENCES `star_wars`.`planets` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`films_species`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`films_species` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`films_species` (
  `film_id` INT NOT NULL,
  `species_id` INT NOT NULL,
  PRIMARY KEY (`film_id`, `species_id`),
  INDEX `s3t_films_species_films_1` (`species_id` ASC) VISIBLE,
  CONSTRAINT `s3t_films_species_films_0`
    FOREIGN KEY (`film_id`)
    REFERENCES `star_wars`.`films` (`id`),
  CONSTRAINT `s3t_films_species_films_1`
    FOREIGN KEY (`species_id`)
    REFERENCES `star_wars`.`species` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`starships`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`starships` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`starships` (
  `id` INT NOT NULL,
  `starship_class` TEXT NULL DEFAULT NULL,
  `MGLT` VARCHAR(10) NULL DEFAULT NULL,
  `hyperdrive_rating` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`films_starships`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`films_starships` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`films_starships` (
  `film_id` INT NOT NULL,
  `starship_id` INT NOT NULL,
  PRIMARY KEY (`film_id`, `starship_id`),
  INDEX `s3t_films_starships_films_1` (`starship_id` ASC) VISIBLE,
  CONSTRAINT `s3t_films_starships_films_0`
    FOREIGN KEY (`film_id`)
    REFERENCES `star_wars`.`films` (`id`),
  CONSTRAINT `s3t_films_starships_films_1`
    FOREIGN KEY (`starship_id`)
    REFERENCES `star_wars`.`starships` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`vehicles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`vehicles` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`vehicles` (
  `id` INT NOT NULL,
  `vehicle_class` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`films_vehicles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`films_vehicles` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`films_vehicles` (
  `film_id` INT NOT NULL,
  `vehicle_id` INT NOT NULL,
  PRIMARY KEY (`film_id`, `vehicle_id`),
  INDEX `s3t_films_vehicles_films_1` (`vehicle_id` ASC) VISIBLE,
  CONSTRAINT `s3t_films_vehicles_films_0`
    FOREIGN KEY (`film_id`)
    REFERENCES `star_wars`.`films` (`id`),
  CONSTRAINT `s3t_films_vehicles_films_1`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `star_wars`.`vehicles` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`species_people`
-- -----------------------------------------------------
/*DROP TABLE IF EXISTS `star_wars`.`species_people` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`species_people` (
  `species_id` INT NOT NULL,
  `people_id` INT NOT NULL,
  PRIMARY KEY (`species_id`, `people_id`),
  INDEX `s3t_species_people_species_1` (`people_id` ASC) VISIBLE,
  CONSTRAINT `s3t_species_people_species_0`
    FOREIGN KEY (`species_id`)
    REFERENCES `star_wars`.`species` (`id`),
  CONSTRAINT `s3t_species_people_species_1`
    FOREIGN KEY (`people_id`)
    REFERENCES `star_wars`.`people` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
*/

-- -----------------------------------------------------
-- Table `star_wars`.`starships_pilots`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`starships_pilots` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`starships_pilots` (
  `starship_id` INT NOT NULL,
  `people_id` INT NOT NULL,
  PRIMARY KEY (`starship_id`, `people_id`),
  INDEX `s3t_starships_pilots_starships_1` (`people_id` ASC) VISIBLE,
  CONSTRAINT `s3t_starships_pilots_starships_0`
    FOREIGN KEY (`starship_id`)
    REFERENCES `star_wars`.`starships` (`id`),
  CONSTRAINT `s3t_starships_pilots_starships_1`
    FOREIGN KEY (`people_id`)
    REFERENCES `star_wars`.`people` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`transports`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`transports` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`transports` (
  `id` INT NOT NULL,
  `name` VARCHAR(80) NULL DEFAULT NULL,
  `manufacturer` TEXT NULL DEFAULT NULL,
  `model` TEXT NULL DEFAULT NULL,
  `cargo_capacity` TEXT NULL DEFAULT NULL,
  `consumables` TEXT NULL DEFAULT NULL,
  `cost_in_credits` TEXT NULL DEFAULT NULL,
  `crew` TEXT NULL DEFAULT NULL,
  `length` TEXT NULL DEFAULT NULL,
  `max_atmosphering_speed` TEXT NULL DEFAULT NULL,
  `passengers` TEXT NULL DEFAULT NULL,
  `created` TIMESTAMP NULL DEFAULT NULL,
  `edited` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `star_wars`.`vehicles_pilots`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `star_wars`.`vehicles_pilots` ;

CREATE TABLE IF NOT EXISTS `star_wars`.`vehicles_pilots` (
  `vehicle_id` INT NOT NULL,
  `people_id` INT NOT NULL,
  PRIMARY KEY (`vehicle_id`, `people_id`),
  INDEX `s3t_veehicles_pilots_vehicles_1` (`people_id` ASC) VISIBLE,
  CONSTRAINT `s3t_veehicles_pilots_vehicles_0`
    FOREIGN KEY (`vehicle_id`)
    REFERENCES `star_wars`.`vehicles` (`id`),
  CONSTRAINT `s3t_veehicles_pilots_vehicles_1`
    FOREIGN KEY (`people_id`)
    REFERENCES `star_wars`.`people` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `star_wars` ;

-- -----------------------------------------------------
-- procedure spM_SW_GetLongestOpeningCrawlMovie
-- -----------------------------------------------------

USE `star_wars`;
DROP procedure IF EXISTS `star_wars`.`spM_SW_GetLongestOpeningCrawlMovie`;

DELIMITER $$
USE `star_wars`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spM_SW_GetLongestOpeningCrawlMovie`()
BEGIN
		-- Get Star Wars movie has the longest opening crawl
		SELECT fm.id, fm.title AS `name`, COUNT(DISTINCT people_id) AS no_of_characters, LENGTH(TRIM(opening_crawl)) AS len 
		FROM films fm
		LEFT JOIN films_characters fc ON fm.id = fc.film_id
		GROUP BY fm.id ORDER BY len DESC limit 1; 
	END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spM_SW_GetPersonAppearedInMostFilms
-- -----------------------------------------------------

USE `star_wars`;
DROP procedure IF EXISTS `star_wars`.`spM_SW_GetPersonAppearedInMostFilms`;

DELIMITER $$
USE `star_wars`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spM_SW_GetPersonAppearedInMostFilms`()
BEGIN
		-- Persons appeared in most of the Star Wars films
		SELECT pp.id, pp.name, COUNT(DISTINCT fc.film_id) AS no_of_film 
		FROM `people` pp 
		LEFT JOIN films_characters fc ON pp.id = fc.people_id
		GROUP BY pp.id HAVING no_of_film=6 ORDER BY no_of_film DESC, pp.id;
	
	END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spM_SW_GetPlanetWithMoreVehiclePilots
-- -----------------------------------------------------

USE `star_wars`;
DROP procedure IF EXISTS `star_wars`.`spM_SW_GetPlanetWithMoreVehiclePilots`;

DELIMITER $$
USE `star_wars`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spM_SW_GetPlanetWithMoreVehiclePilots`()
BEGIN
	
	-- Get Planet in Star Wars universe provided largest number of vehicle pilots
	-- Planet: Earth - Pilots: (12) Han Solo - Human, Yoda - Yodi
	SELECT pt.id, pt.name, COUNT(*) AS no_of_pilots, GROUP_CONCAT(vpd.fulldesc separator ', ') AS pilots
	FROM `planets` pt
	LEFT JOIN (
		SELECT pp.id, pp.`name`, CONCAT(pp.`name`, ' - ', IFNULL(sp.`name`, 'n/a')) AS fulldesc, pp.`homeworld`, IFNULL(sp.`name`, 'n/a') AS species 
		FROM people pp
		INNER JOIN vehicles_pilots vp ON pp.id= vp.people_id
		LEFT JOIN species sp ON sp.homeworld = pp.homeworld
		GROUP BY pp.id, pp.homeworld
	) vpd ON pt.id = vpd.homeworld 
	GROUP BY pt.id ORDER BY no_of_pilots DESC LIMIT 1; 

	END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spM_SW_GetSpeciesApearedInMostFilms
-- -----------------------------------------------------

USE `star_wars`;
DROP procedure IF EXISTS `star_wars`.`spM_SW_GetSpeciesApearedInMostFilms`;

DELIMITER $$
USE `star_wars`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spM_SW_GetSpeciesApearedInMostFilms`()
BEGIN
	
		-- species appeared in the most number of Star Wars films
		SELECT sp.id, sp.name, COUNT(people_id) AS no_of_characters, COUNT(DISTINCT fc.film_id) AS no_of_film -- COUNT(DISTINCT people_id) AS no_of_characters, 
		FROM species sp
		INNER JOIN films_species fs ON sp.id = fs.species_id
		LEFT JOIN films_characters fc ON fs.film_id = fc.film_id
		GROUP BY sp.id HAVING no_of_film=6 ORDER BY no_of_characters DESC;
	END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure spM_SW_GetUserLoginInfo
-- -----------------------------------------------------

USE `star_wars`;
DROP procedure IF EXISTS `star_wars`.`spM_SW_GetUserLoginInfo`;

DELIMITER $$
USE `star_wars`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `spM_SW_GetUserLoginInfo`(IN USR VARCHAR(100),IN PWD VARCHAR(100))
BEGIN

		SELECT * FROM `user`WHERE (usr_name=USR OR USR_email=USR) AND usr_pwd=PWD AND usr_status=1;

	END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
