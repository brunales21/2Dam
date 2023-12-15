CREATE DATABASE  IF NOT EXISTS `pokemon_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pokemon_db`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: pokemon_db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `effectiveness`
--

DROP TABLE IF EXISTS `effectiveness`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `effectiveness` (
  `attack_type` varchar(45) NOT NULL,
  `defense_type` varchar(45) NOT NULL,
  `effectiveness` float NOT NULL,
  PRIMARY KEY (`attack_type`,`defense_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `effectiveness`
--

LOCK TABLES `effectiveness` WRITE;
/*!40000 ALTER TABLE `effectiveness` DISABLE KEYS */;
INSERT INTO `effectiveness` VALUES ('bug','bug',1),('bug','dark',2),('bug','dragon',1),('bug','electric',1),('bug','fairy',-0.5),('bug','fighting',-0.5),('bug','fire',-0.5),('bug','flying',-0.5),('bug','ghost',-0.5),('bug','grass',2),('bug','ground',1),('bug','ice',1),('bug','normal',1),('bug','poison',-0.5),('bug','psychic',2),('bug','rock',1),('bug','steel',-0.5),('bug','water',1),('dark','bug',1),('dark','dark',-0.5),('dark','dragon',1),('dark','electric',1),('dark','fairy',-0.5),('dark','fighting',-0.5),('dark','fire',1),('dark','flying',1),('dark','ghost',2),('dark','grass',1),('dark','ground',1),('dark','ice',1),('dark','normal',1),('dark','poison',1),('dark','psychic',2),('dark','rock',1),('dark','steel',1),('dark','water',1),('dragon','bug',1),('dragon','dark',1),('dragon','dragon',2),('dragon','electric',1),('dragon','fairy',0),('dragon','fighting',1),('dragon','fire',1),('dragon','flying',1),('dragon','ghost',1),('dragon','grass',1),('dragon','ground',1),('dragon','ice',1),('dragon','normal',1),('dragon','poison',1),('dragon','psychic',1),('dragon','rock',1),('dragon','steel',-0.5),('dragon','water',1),('electric','bug',1),('electric','dark',1),('electric','dragon',-0.5),('electric','electric',-0.5),('electric','fairy',1),('electric','fighting',1),('electric','fire',1),('electric','flying',2),('electric','ghost',1),('electric','grass',-0.5),('electric','ground',0),('electric','ice',1),('electric','normal',1),('electric','poison',1),('electric','psychic',1),('electric','rock',1),('electric','steel',1),('electric','water',2),('fairy','bug',1),('fairy','dark',2),('fairy','dragon',2),('fairy','electric',1),('fairy','fairy',1),('fairy','fighting',2),('fairy','fire',-0.5),('fairy','flying',1),('fairy','ghost',1),('fairy','grass',1),('fairy','ground',1),('fairy','ice',1),('fairy','normal',1),('fairy','poison',-0.5),('fairy','psychic',1),('fairy','rock',1),('fairy','steel',-0.5),('fairy','water',1),('fighting','bug',-0.5),('fighting','dark',2),('fighting','dragon',1),('fighting','electric',1),('fighting','fairy',-0.5),('fighting','fighting',1),('fighting','fire',1),('fighting','flying',-0.5),('fighting','ghost',0),('fighting','grass',1),('fighting','ground',1),('fighting','ice',2),('fighting','normal',2),('fighting','poison',-0.5),('fighting','psychic',-0.5),('fighting','rock',2),('fighting','steel',2),('fighting','water',1),('fire','bug',2),('fire','dark',1),('fire','dragon',-0.5),('fire','electric',1),('fire','fairy',1),('fire','fighting',1),('fire','fire',-0.5),('fire','flying',1),('fire','ghost',1),('fire','grass',2),('fire','ground',1),('fire','ice',2),('fire','normal',1),('fire','poison',1),('fire','psychic',1),('fire','rock',-0.5),('fire','steel',2),('fire','water',-0.5),('flying','bug',2),('flying','dark',1),('flying','dragon',1),('flying','electric',-0.5),('flying','fairy',1),('flying','fighting',2),('flying','fire',1),('flying','flying',1),('flying','ghost',1),('flying','grass',2),('flying','ground',1),('flying','ice',1),('flying','normal',1),('flying','poison',1),('flying','psychic',1),('flying','rock',-0.5),('flying','steel',-0.5),('flying','water',1),('ghost','bug',1),('ghost','dark',-0.5),('ghost','dragon',1),('ghost','electric',1),('ghost','fairy',1),('ghost','fighting',1),('ghost','fire',1),('ghost','flying',1),('ghost','ghost',2),('ghost','grass',1),('ghost','ground',1),('ghost','ice',1),('ghost','normal',0),('ghost','poison',1),('ghost','psychic',2),('ghost','rock',1),('ghost','steel',1),('ghost','water',1),('grass','bug',1),('grass','dark',1),('grass','dragon',-0.5),('grass','electric',1),('grass','fairy',1),('grass','fighting',1),('grass','fire',-0.5),('grass','flying',-0.5),('grass','ghost',1),('grass','grass',-0.5),('grass','ground',2),('grass','ice',1),('grass','normal',1),('grass','poison',-0.5),('grass','psychic',1),('grass','rock',1),('grass','steel',-0.5),('grass','water',2),('ground','bug',-0.5),('ground','dark',1),('ground','dragon',1),('ground','electric',2),('ground','fairy',1),('ground','fighting',1),('ground','fire',2),('ground','flying',0),('ground','ghost',1),('ground','grass',-0.5),('ground','ground',1),('ground','ice',1),('ground','normal',1),('ground','poison',2),('ground','psychic',1),('ground','rock',2),('ground','steel',2),('ground','water',1),('ice','bug',1),('ice','dark',1),('ice','dragon',2),('ice','electric',1),('ice','fairy',1),('ice','fighting',1),('ice','fire',-0.5),('ice','flying',2),('ice','ghost',1),('ice','grass',2),('ice','ground',2),('ice','ice',-0.5),('ice','normal',1),('ice','poison',1),('ice','psychic',1),('ice','rock',1),('ice','steel',-0.5),('ice','water',-0.5),('normal','bug',1),('normal','dark',1),('normal','dragon',1),('normal','electric',1),('normal','fairy',1),('normal','fighting',1),('normal','fire',1),('normal','flying',1),('normal','ghost',0),('normal','grass',1),('normal','ground',1),('normal','ice',1),('normal','normal',1),('normal','poison',1),('normal','psychic',1),('normal','rock',-0.5),('normal','steel',-0.5),('normal','water',1),('poison','bug',1),('poison','dark',1),('poison','dragon',1),('poison','electric',1),('poison','fairy',2),('poison','fighting',1),('poison','fire',1),('poison','flying',1),('poison','ghost',-0.5),('poison','grass',2),('poison','ground',-0.5),('poison','ice',1),('poison','normal',1),('poison','poison',-0.5),('poison','psychic',1),('poison','rock',-0.5),('poison','steel',0),('poison','water',1),('psychic','bug',1),('psychic','dark',0),('psychic','dragon',1),('psychic','electric',1),('psychic','fairy',1),('psychic','fighting',2),('psychic','fire',1),('psychic','flying',1),('psychic','ghost',1),('psychic','grass',1),('psychic','ground',1),('psychic','ice',1),('psychic','normal',1),('psychic','poison',2),('psychic','psychic',-0.5),('psychic','rock',1),('psychic','steel',-0.5),('psychic','water',1),('rock','bug',2),('rock','dark',1),('rock','dragon',1),('rock','electric',1),('rock','fairy',1),('rock','fighting',-0.5),('rock','fire',2),('rock','flying',2),('rock','ghost',1),('rock','grass',1),('rock','ground',-0.5),('rock','ice',2),('rock','normal',1),('rock','poison',1),('rock','psychic',1),('rock','rock',2),('rock','steel',-0.5),('rock','water',1),('steel','bug',1),('steel','dark',1),('steel','dragon',1),('steel','electric',-0.5),('steel','fairy',2),('steel','fighting',1),('steel','fire',-0.5),('steel','flying',1),('steel','ghost',1),('steel','grass',1),('steel','ground',1),('steel','ice',2),('steel','normal',1),('steel','poison',1),('steel','psychic',1),('steel','rock',2),('steel','steel',-0.5),('steel','water',-0.5),('water','bug',1),('water','dark',1),('water','dragon',-0.5),('water','electric',1),('water','fairy',1),('water','fighting',1),('water','fire',2),('water','flying',1),('water','ghost',1),('water','grass',-0.5),('water','ground',2),('water','ice',1),('water','normal',1),('water','poison',1),('water','psychic',1),('water','rock',2),('water','steel',1),('water','water',-0.5);
/*!40000 ALTER TABLE `effectiveness` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `game` (
  `game_id` int NOT NULL,
  `game_name` varchar(45) NOT NULL,
  `generation` int DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  PRIMARY KEY (`game_id`),
  UNIQUE KEY `game_name_UNIQUE` (`game_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'Pocket Monsters: Red and Green',1,'1996-02-27'),(2,'Pocket Monsters: Blue',1,'1996-10-15'),(3,'Pokemon Red and Blue',1,'1998-09-28'),(4,'Pokemon Yellow',1,'1998-09-12'),(5,'Pokemon Gold and Silver',2,'1999-11-21'),(6,'Pokemon Crystal ',2,'2000-12-14'),(7,'Pokemon Ruby and Sapphire',3,'2002-11-21'),(8,'Pokemon FireRed and LeafGreen',3,'2004-01-29'),(9,'Pokemon Emerald',3,'2004-09-16'),(10,'Pokemon Diamond and Pearl',4,'2006-09-28'),(11,'Pokemon Platinum',4,'2008-09-13'),(12,'Pokemon HeartGold and SoulSilver ',4,'2009-09-12'),(13,'Pokemon Black and White',5,'2010-09-18'),(14,'Pokemon Black 2 and White 2 ',5,'2012-06-23'),(15,'Pokemon X and Y',6,'2013-10-12'),(16,'Pokemon Omega Ruby and Alpha Sapphire ',6,'2014-11-21'),(17,'Pokemon Sun and Moon',7,'2016-11-18'),(18,'Pokemon Ultra Sun and Ultra Moon',7,'2017-11-17'),(20,'Pokemon Sword and Shield',7,'2019-11-15');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generation`
--

DROP TABLE IF EXISTS `generation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `generation` (
  `generation` int NOT NULL,
  `date_introduced` date NOT NULL,
  PRIMARY KEY (`generation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generation`
--

LOCK TABLES `generation` WRITE;
/*!40000 ALTER TABLE `generation` DISABLE KEYS */;
INSERT INTO `generation` VALUES (1,'1996-02-27'),(2,'1999-11-21'),(3,'2002-11-21'),(4,'2006-09-28'),(5,'2010-09-18'),(6,'2010-12-13'),(7,'2016-11-18'),(8,'2020-04-06');
/*!40000 ALTER TABLE `generation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon`
--

DROP TABLE IF EXISTS `pokemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon` (
  `idNum` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `HP` int NOT NULL,
  `speed` int NOT NULL,
  `attack` int NOT NULL,
  `special_attack` int DEFAULT NULL,
  `defense` int NOT NULL,
  `special_defense` int DEFAULT NULL,
  `evolve_id` int DEFAULT NULL,
  `generation` int NOT NULL,
  PRIMARY KEY (`idNum`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=821 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon`
--

LOCK TABLES `pokemon` WRITE;
/*!40000 ALTER TABLE `pokemon` DISABLE KEYS */;
INSERT INTO `pokemon` VALUES (1,'Bulbasaur',45,45,49,65,49,65,2,1),(2,'Ivysaur',60,60,62,80,63,80,3,1),(3,'Venusaur',80,80,100,122,123,120,5,1),(4,'Charmander',39,65,52,60,43,50,6,1),(5,'Charmeleon',58,80,64,80,58,65,8,1),(6,'Charizard',78,100,104,159,78,115,9,1),(7,'Squirtle',44,43,48,50,65,64,11,1),(8,'Wartortle',59,58,63,65,80,80,12,1),(9,'Blastoise',79,78,103,135,120,115,14,1),(10,'Caterpie',45,45,30,20,35,20,15,1),(11,'Metapod',50,30,20,25,55,25,17,1),(12,'Butterfree',60,70,45,90,50,80,18,1),(13,'Weedle',40,50,35,20,30,20,20,1),(14,'Kakuna',45,35,25,25,50,25,22,1),(15,'Beedrill',65,145,150,15,40,80,24,1),(16,'Pidgey',40,56,45,35,40,35,25,1),(17,'Pidgeotto',63,71,60,50,55,50,26,1),(18,'Pidgeot',83,121,80,135,80,80,28,1),(19,'Rattata',30,72,56,25,35,35,30,1),(20,'Raticate',75,77,71,40,70,80,31,1),(21,'Spearow',40,70,60,31,30,31,33,1),(22,'Fearow',65,100,90,61,65,61,34,1),(23,'Ekans',35,55,60,40,44,54,35,1),(24,'Arbok',60,80,95,65,69,79,36,1),(25,'Pikachu',35,90,55,50,40,50,38,1),(26,'Raichu',60,110,85,95,50,85,39,1),(27,'Sandshrew',50,40,75,10,90,35,40,1),(28,'Sandslash',75,65,100,25,120,65,42,1),(29,'Nidoran♀',55,41,47,40,52,40,44,1),(30,'Nidorina',70,56,62,55,67,55,45,1),(31,'Nidoqueen',90,76,92,75,87,85,47,1),(32,'Nidoran♂',46,50,57,40,40,40,49,1),(33,'Nidorino',61,65,72,55,57,55,51,1),(34,'Nidoking',81,85,102,85,77,75,53,1),(35,'Clefairy',70,35,45,60,48,65,55,1),(36,'Clefable',95,60,70,95,73,90,57,1),(37,'Vulpix',38,65,41,50,40,65,59,1),(38,'Ninetales',73,109,67,81,75,100,61,1),(39,'Jigglypuff',115,20,45,45,20,25,62,1),(40,'Wigglytuff',140,45,70,85,45,50,64,1),(41,'Zubat',40,55,45,30,35,40,65,1),(42,'Golbat',75,90,80,65,70,75,67,1),(43,'Oddish',45,30,50,75,55,65,68,1),(44,'Gloom',60,40,65,85,70,75,70,1),(45,'Vileplume',75,50,80,110,85,90,71,1),(46,'Paras',35,25,70,45,55,55,73,1),(47,'Parasect',60,30,95,60,80,80,75,1),(48,'Venonat',60,45,55,40,50,55,76,1),(49,'Venomoth',70,90,65,90,60,75,78,1),(50,'Diglett',10,90,55,35,30,45,80,1),(51,'Dugtrio',35,110,100,50,60,70,82,1),(52,'Meowth',40,90,35,50,35,40,85,1),(53,'Persian',65,115,60,75,60,65,87,1),(54,'Psyduck',50,55,52,65,48,50,89,1),(55,'Golduck',80,85,82,95,78,80,91,1),(56,'Mankey',40,70,80,35,35,45,93,1),(57,'Primeape',65,95,105,60,60,70,94,1),(58,'Growlithe',55,60,70,70,45,50,97,1),(59,'Arcanine',90,95,110,100,80,80,99,1),(60,'Poliwag',40,90,50,40,40,40,101,1),(61,'Poliwhirl',65,90,65,50,65,50,103,1),(62,'Poliwrath',90,70,95,70,95,90,105,1),(63,'Abra',25,90,20,105,15,55,106,1),(64,'Kadabra',40,105,35,120,30,70,107,1),(65,'Alakazam',55,150,50,175,65,105,110,1),(66,'Machop',70,35,80,35,50,35,112,1),(67,'Machoke',80,45,100,50,70,60,113,1),(68,'Machamp',90,55,130,65,80,85,117,1),(69,'Bellsprout',50,40,75,70,35,30,119,1),(70,'Weepinbell',65,55,90,85,50,45,121,1),(71,'Victreebel',80,70,105,100,65,70,122,1),(72,'Tentacool',40,70,40,50,35,100,124,1),(73,'Tentacruel',80,100,70,80,65,120,125,1),(74,'Geodude',40,20,80,30,100,30,126,1),(75,'Graveler',55,35,95,45,115,45,130,1),(76,'Golem',80,45,120,55,130,65,134,1),(77,'Ponyta',50,90,85,65,55,65,135,1),(78,'Rapidash',65,105,100,80,70,80,136,1),(79,'Slowpoke',90,15,65,40,65,40,139,1),(80,'Slowbro',95,30,75,130,180,80,141,1),(81,'Magnemite',25,45,35,95,70,55,143,1),(82,'Magneton',50,70,60,120,95,70,148,1),(83,'Farfetch\'d',52,60,90,58,55,62,149,1),(84,'Doduo',35,75,85,35,45,35,153,1),(85,'Dodrio',60,110,110,60,70,60,154,1),(86,'Seel',65,45,45,45,55,70,156,1),(87,'Dewgong',90,70,70,70,80,95,157,1),(88,'Grimer',80,25,80,40,50,50,159,1),(89,'Muk',105,50,105,65,75,100,160,1),(90,'Shellder',30,40,65,45,100,25,162,1),(91,'Cloyster',50,70,95,85,180,45,164,1),(92,'Gastly',30,80,35,100,30,35,166,1),(93,'Haunter',45,95,50,115,45,55,168,1),(94,'Gengar',60,130,65,170,80,95,169,1),(95,'Onix',35,70,45,30,160,45,171,1),(96,'Drowzee',60,42,48,43,45,90,176,1),(97,'Hypno',85,67,73,73,70,115,178,1),(98,'Krabby',30,50,105,25,90,25,180,1),(99,'Kingler',55,75,130,50,115,50,181,1),(100,'Voltorb',40,100,30,55,50,55,182,1),(101,'Electrode',60,150,50,80,70,80,183,1),(102,'Exeggcute',60,40,40,60,80,45,184,1),(103,'Exeggutor',95,45,105,125,85,75,185,1),(104,'Cubone',50,35,50,40,95,50,186,1),(105,'Marowak',60,45,80,50,110,80,188,1),(106,'Hitmonlee',50,87,120,35,53,110,189,1),(107,'Hitmonchan',50,76,105,35,79,110,192,1),(108,'Lickitung',90,30,55,60,75,75,195,1),(109,'Koffing',40,35,65,60,95,45,196,1),(110,'Weezing',65,60,90,85,120,70,197,1),(111,'Rhyhorn',80,25,85,30,95,30,199,1),(112,'Rhydon',105,40,130,45,120,45,202,1),(113,'Chansey',250,50,5,35,5,105,205,1),(114,'Tangela',65,60,55,100,115,40,208,1),(115,'Kangaskhan',105,100,125,60,100,100,210,1),(116,'Horsea',30,60,40,70,70,25,212,1),(117,'Seadra',55,85,65,95,95,45,217,1),(118,'Goldeen',45,63,67,35,60,50,219,1),(119,'Seaking',80,68,92,65,65,80,221,1),(120,'Staryu',30,85,45,70,55,55,224,1),(121,'Starmie',60,115,75,100,85,85,226,1),(122,'Mr. Mime',40,90,45,100,65,120,229,1),(123,'Scyther',70,105,110,55,80,80,230,1),(124,'Jynx',65,95,50,115,35,95,232,1),(125,'Electabuzz',65,105,83,95,57,85,233,1),(126,'Magmar',65,93,95,100,57,85,237,1),(127,'Pinsir',65,105,155,65,120,90,242,1),(128,'Tauros',75,110,100,40,95,70,247,1),(129,'Magikarp',20,80,10,15,55,20,248,1),(130,'Gyarados',95,81,155,70,109,130,253,1),(131,'Lapras',130,60,85,85,80,95,254,1),(132,'Ditto',48,48,48,48,48,48,256,1),(133,'Eevee',55,55,55,45,50,65,257,1),(134,'Vaporeon',130,65,65,110,60,95,259,1),(135,'Jolteon',65,130,65,110,60,95,260,1),(136,'Flareon',65,65,130,95,60,110,262,1),(137,'Porygon',65,40,60,85,70,75,264,1),(138,'Omanyte',35,35,40,90,100,55,266,1),(139,'Omastar',70,55,60,115,125,70,267,1),(140,'Kabuto',30,55,80,55,90,45,268,1),(141,'Kabutops',60,80,115,65,105,70,269,1),(142,'Aerodactyl',80,150,135,70,85,95,271,1),(143,'Snorlax',160,30,110,65,65,110,272,1),(144,'Articuno',90,85,85,95,100,125,274,1),(145,'Zapdos',90,100,90,125,85,90,275,1),(146,'Moltres',90,90,100,125,90,85,277,1),(147,'Dratini',41,50,64,50,45,50,279,1),(148,'Dragonair',61,70,84,70,65,70,281,1),(149,'Dragonite',91,80,134,100,95,100,282,1),(150,'Mewtwo',106,140,150,194,70,120,284,1),(151,'Mew',100,100,100,100,100,100,286,1),(152,'Chikorita',45,45,49,49,65,65,288,2),(153,'Bayleef',60,60,62,63,80,80,289,2),(154,'Meganium',80,80,82,83,100,100,291,2),(155,'Cyndaquil',39,65,52,60,43,50,292,2),(156,'Quilava',58,80,64,80,58,65,294,2),(157,'Typhlosion',78,100,84,109,78,85,295,2),(158,'Totodile',50,43,65,44,64,48,297,2),(159,'Croconaw',65,58,80,59,80,63,301,2),(160,'Feraligatr',85,78,105,79,100,83,305,2),(161,'Sentret',35,20,46,35,34,45,306,2),(162,'Furret',85,90,76,45,64,55,308,2),(163,'Hoothoot',60,50,30,36,30,56,310,2),(164,'Noctowl',100,70,50,86,50,96,315,2),(165,'Ledyba',40,55,20,40,30,80,317,2),(166,'Ledian',55,85,35,55,50,110,319,2),(167,'Spinarak',40,30,60,40,40,40,321,2),(168,'Ariados',70,40,90,60,70,70,323,2),(169,'Crobat',85,130,90,70,80,80,326,2),(170,'Chinchou',75,67,38,56,38,56,329,2),(171,'Lanturn',125,67,58,76,58,76,330,2),(172,'Pichu',20,60,40,35,15,35,332,2),(173,'Cleffa',50,15,25,45,28,55,334,2),(174,'Igglybuff',90,15,30,40,15,20,340,2),(175,'Togepi',35,20,20,40,65,65,342,2),(176,'Togetic',55,40,40,80,85,105,344,2),(177,'Natu',40,70,50,70,45,45,346,2),(178,'Xatu',65,95,75,95,70,70,348,2),(179,'Mareep',55,35,40,65,40,45,350,2),(180,'Flaaffy',70,45,55,80,55,60,354,2),(181,'Ampharos',90,45,95,165,105,110,356,2),(182,'Bellossom',75,50,80,90,95,100,358,2),(183,'Marill',70,40,20,20,50,50,362,2),(184,'Azumarill',100,50,50,60,80,80,364,2),(185,'Sudowoodo',70,30,100,30,115,65,365,2),(186,'Politoed',90,70,75,90,75,100,367,2),(187,'Hoppip',35,50,35,35,40,55,368,2),(188,'Skiploom',55,80,45,45,50,65,372,2),(189,'Jumpluff',75,110,55,55,70,95,373,2),(190,'Aipom',55,85,70,40,55,55,375,2),(191,'Sunkern',30,30,30,30,30,30,376,2),(192,'Sunflora',75,30,75,105,55,85,388,2),(193,'Yanma',65,95,65,75,45,45,389,2),(194,'Wooper',55,15,45,25,45,25,391,2),(195,'Quagsire',95,35,85,65,85,65,392,2),(196,'Espeon',65,110,65,130,60,95,394,2),(197,'Umbreon',95,65,65,60,110,130,395,2),(198,'Murkrow',60,91,85,85,42,42,397,2),(199,'Slowking',95,30,75,100,80,110,398,2),(200,'Misdreavus',60,85,60,85,60,85,400,2),(201,'Unown',48,48,72,72,48,48,402,2),(202,'Wobbuffet',190,33,33,33,58,58,404,2),(203,'Girafarig',70,85,80,90,65,65,405,2),(204,'Pineco',50,15,65,35,90,35,407,2),(205,'Forretress',75,40,90,60,140,60,409,2),(206,'Dunsparce',100,45,70,65,70,65,411,2),(207,'Gligar',65,85,75,35,105,65,413,2),(208,'Steelix',75,30,125,55,230,95,414,2),(209,'Snubbull',60,30,80,40,50,40,416,2),(210,'Granbull',90,45,120,60,75,60,419,2),(211,'Qwilfish',65,85,95,55,85,55,421,2),(212,'Scizor',70,75,150,65,140,100,423,2),(213,'Shuckle',20,5,10,10,230,230,424,2),(214,'Heracross',80,75,185,40,115,105,426,2),(215,'Sneasel',55,115,95,35,55,75,428,2),(216,'Teddiursa',60,40,80,50,50,50,429,2),(217,'Ursaring',90,55,130,75,75,75,430,2),(218,'Slugma',40,20,40,70,40,40,432,2),(219,'Magcargo',60,30,50,90,120,80,435,2),(220,'Swinub',50,50,50,30,40,30,437,2),(221,'Piloswine',100,50,100,60,80,60,444,2),(222,'Corsola',65,35,55,65,95,95,445,2),(223,'Remoraid',35,65,65,65,35,35,448,2),(224,'Octillery',75,45,105,105,75,75,450,2),(225,'Delibird',45,75,55,65,45,45,452,2),(226,'Mantine',85,70,40,80,70,140,454,2),(227,'Skarmory',65,70,80,40,140,70,457,2),(228,'Houndour',45,65,60,80,30,50,460,2),(229,'Houndoom',75,115,90,140,90,90,461,2),(230,'Kingdra',75,85,95,95,95,95,462,2),(231,'Phanpy',90,40,60,40,60,40,463,2),(232,'Donphan',90,50,120,60,120,60,464,2),(233,'Porygon2',85,60,80,105,90,95,465,2),(234,'Stantler',73,85,95,85,62,65,466,2),(235,'Smeargle',55,75,20,20,35,45,467,2),(236,'Tyrogue',35,35,35,35,35,35,468,2),(237,'Hitmontop',50,70,95,35,95,110,469,2),(238,'Smoochum',45,65,30,85,15,65,470,2),(239,'Elekid',45,95,63,65,37,55,471,2),(240,'Magby',45,83,75,70,37,55,472,2),(241,'Miltank',95,100,80,40,105,70,473,2),(242,'Blissey',255,55,10,75,10,135,474,2),(243,'Raikou',90,115,85,115,75,100,475,2),(244,'Entei',115,100,115,90,85,75,476,2),(245,'Suicune',100,85,75,90,115,115,477,2),(246,'Larvitar',50,41,64,45,50,50,478,2),(247,'Pupitar',70,51,84,65,70,70,496,2),(248,'Tyranitar',100,71,164,95,150,120,497,2),(249,'Lugia',106,110,90,90,130,154,499,2),(250,'Ho-Oh',106,90,130,110,90,154,500,2),(251,'Celebi',100,100,100,100,100,100,502,2),(252,'Treecko',40,70,45,65,35,55,503,3),(253,'Grovyle',50,95,65,85,45,65,505,3),(254,'Sceptile',70,145,110,145,75,85,507,3),(255,'Torchic',45,45,60,70,40,50,508,3),(256,'Combusken',60,55,85,85,60,60,510,3),(257,'Blaziken',80,100,160,130,80,80,512,3),(258,'Mudkip',50,40,70,50,50,50,514,3),(259,'Marshtomp',70,50,85,60,70,70,516,3),(260,'Swampert',100,70,150,95,110,110,518,3),(261,'Poochyena',35,35,55,30,35,30,520,3),(262,'Mightyena',70,70,90,60,70,60,521,3),(263,'Zigzagoon',38,60,30,30,41,41,523,3),(264,'Linoone',78,100,70,50,61,61,525,3),(265,'Wurmple',45,20,45,20,35,30,526,3),(266,'Silcoon',50,15,35,25,55,25,528,3),(267,'Beautifly',60,65,70,100,50,50,530,3),(268,'Cascoon',50,15,35,25,55,25,533,3),(269,'Dustox',60,65,50,50,70,90,534,3),(270,'Lotad',40,30,30,40,30,50,536,3),(271,'Lombre',60,50,50,60,50,70,537,3),(272,'Ludicolo',80,70,70,90,70,100,541,3),(273,'Seedot',40,30,40,30,50,30,542,3),(274,'Nuzleaf',70,60,70,60,40,40,544,3),(275,'Shiftry',90,80,100,90,60,60,545,3),(276,'Taillow',40,85,55,30,30,30,547,3),(277,'Swellow',60,125,85,75,60,50,549,3),(278,'Wingull',40,85,30,55,30,30,552,3),(279,'Pelipper',60,65,50,95,100,70,553,3),(280,'Ralts',28,40,25,45,25,35,555,3),(281,'Kirlia',38,50,35,65,35,55,558,3),(282,'Gardevoir',68,100,85,165,65,135,560,3),(283,'Surskit',40,65,30,50,32,52,563,3),(284,'Masquerain',70,80,60,100,62,82,565,3),(285,'Shroomish',60,35,40,40,60,60,567,3),(286,'Breloom',60,70,130,60,80,60,569,3),(287,'Slakoth',60,30,60,35,60,35,571,3),(288,'Vigoroth',80,90,80,55,80,55,573,3),(289,'Slaking',150,100,160,95,100,65,575,3),(290,'Nincada',31,40,45,30,90,30,576,3),(291,'Ninjask',61,160,90,50,45,50,578,3),(292,'Shedinja',1,40,90,30,45,30,579,3),(293,'Whismur',64,28,51,51,23,23,581,3),(294,'Loudred',84,48,71,71,43,43,583,3),(295,'Exploud',104,68,91,91,63,73,584,3),(296,'Makuhita',72,25,60,20,30,30,586,3),(297,'Hariyama',144,50,120,40,60,60,589,3),(298,'Azurill',50,20,20,20,40,40,591,3),(299,'Nosepass',30,30,45,45,135,90,593,3),(300,'Skitty',50,50,45,35,45,35,596,3),(301,'Delcatty',70,90,65,55,65,55,598,3),(302,'Sableye',50,20,85,85,125,115,600,3),(303,'Mawile',50,50,105,55,125,95,601,3),(304,'Aron',50,30,70,40,100,40,603,3),(305,'Lairon',60,40,90,50,140,50,604,3),(306,'Aggron',70,50,140,60,230,80,606,3),(307,'Meditite',30,60,40,40,55,55,608,3),(308,'Medicham',60,100,100,80,85,85,609,3),(309,'Electrike',40,65,45,65,40,40,611,3),(310,'Manectric',70,135,75,135,80,80,612,3),(311,'Plusle',60,95,50,85,40,75,614,3),(312,'Minun',60,95,40,75,50,85,617,3),(313,'Volbeat',65,85,73,47,75,85,620,3),(314,'Illumise',65,85,47,73,75,85,623,3),(315,'Roselia',50,65,60,100,45,80,625,3),(316,'Gulpin',70,40,43,43,53,53,628,3),(317,'Swalot',100,55,73,73,83,83,630,3),(318,'Carvanha',45,65,90,65,20,20,634,3),(319,'Sharpedo',70,105,140,110,70,65,635,3),(320,'Wailmer',130,60,70,70,35,35,637,3),(321,'Wailord',170,60,90,90,45,45,350,3),(322,'Numel',60,35,60,65,40,45,462,3),(323,'Camerupt',70,20,120,145,100,105,476,3),(324,'Torkoal',70,20,85,85,140,70,470,3),(325,'Spoink',60,60,25,70,35,80,471,3),(326,'Grumpig',80,80,45,90,65,110,NULL,3),(327,'Spinda',60,60,60,60,60,60,683,3),(328,'Trapinch',45,10,100,45,45,45,662,3),(329,'Vibrava',50,70,70,50,50,50,709,3),(330,'Flygon',80,100,100,80,80,80,663,3),(331,'Cacnea',50,35,85,85,40,40,654,3),(332,'Cacturne',70,55,115,115,60,60,687,3),(333,'Swablu',45,50,40,40,60,75,655,3),(334,'Altaria',75,80,110,110,110,105,651,3),(335,'Zangoose',73,90,115,60,60,60,693,3),(336,'Seviper',73,65,100,100,60,60,652,3),(337,'Lunatone',90,70,55,95,65,85,657,3),(338,'Solrock',90,70,95,55,85,65,658,3),(339,'Barboach',50,60,48,46,43,41,680,3),(340,'Whiscash',110,60,78,76,73,71,705,3),(341,'Corphish',43,35,80,50,65,35,666,3),(342,'Crawdaunt',63,55,120,90,85,55,665,3),(343,'Baltoy',40,55,40,40,55,70,689,3),(344,'Claydol',60,75,70,70,105,120,711,3),(345,'Lileep',66,23,41,61,77,87,660,3),(346,'Cradily',86,43,81,81,97,107,670,3),(347,'Anorith',45,75,95,40,50,50,671,3),(348,'Armaldo',75,45,125,70,100,80,681,3),(349,'Feebas',20,80,15,10,20,55,675,3),(350,'Milotic',95,81,60,100,79,125,685,3),(351,'Castform',70,70,70,70,70,70,691,3),(352,'Kecleon',60,40,90,60,70,120,697,3),(353,'Shuppet',44,45,75,63,35,33,699,3),(354,'Banette',64,75,165,93,75,83,713,3),(355,'Duskull',20,25,40,30,90,90,695,3),(356,'Dusclops',40,25,70,60,130,130,668,3),(357,'Tropius',99,51,68,72,83,87,673,3),(358,'Chimecho',75,65,50,95,80,90,706,3),(359,'Absol',65,115,150,115,60,60,715,3),(360,'Wynaut',95,23,23,23,48,48,678,3),(361,'Snorunt',50,50,50,50,50,50,700,3),(362,'Glalie',80,100,120,120,80,80,462,3),(363,'Spheal',70,25,40,55,50,50,470,3),(364,'Sealeo',90,45,60,75,70,70,471,3),(365,'Walrein',110,65,80,95,90,90,476,3),(366,'Clamperl',35,32,64,74,85,55,462,3),(367,'Huntail',55,52,104,94,105,75,105,3),(368,'Gorebyss',55,52,84,114,105,75,470,3),(369,'Relicanth',100,55,90,45,130,65,471,3),(370,'Luvdisc',43,97,30,40,55,65,476,3),(371,'Bagon',45,50,75,40,60,30,350,3),(372,'Shelgon',65,50,95,60,100,50,678,3),(373,'Salamence',95,120,145,120,130,90,723,3),(374,'Beldum',40,30,55,35,80,60,724,3),(375,'Metang',60,50,75,55,100,80,726,3),(376,'Metagross',80,110,145,105,150,110,727,3),(377,'Regirock',80,50,100,50,200,100,729,3),(378,'Regice',80,50,50,100,100,200,730,3),(379,'Registeel',80,50,75,75,150,150,732,3),(380,'Latias',80,110,100,140,120,150,733,3),(381,'Latios',80,110,130,160,100,120,735,3),(382,'Kyogre',100,90,150,180,90,160,737,3),(383,'Groudon',100,90,180,150,160,90,738,3),(384,'Rayquaza',105,115,180,180,100,100,740,3),(385,'Jirachi',100,100,100,100,100,100,743,3),(386,'Deoxys',50,180,95,95,90,90,745,3),(387,'Turtwig',55,31,68,45,64,55,745,4),(388,'Grotle',75,36,89,55,85,65,748,4),(389,'Torterra',95,56,109,75,105,85,750,4),(390,'Chimchar',44,61,58,58,44,44,752,4),(391,'Monferno',64,81,78,78,52,52,754,4),(392,'Infernape',76,108,104,104,71,71,756,4),(393,'Piplup',53,40,51,61,53,56,758,4),(394,'Prinplup',64,50,66,81,68,76,760,4),(395,'Empoleon',84,60,86,111,88,101,762,4),(396,'Starly',40,60,55,30,30,30,763,4),(397,'Staravia',55,80,75,40,50,40,768,4),(398,'Staraptor',85,100,120,50,70,60,770,4),(399,'Bidoof',59,31,45,35,40,40,773,4),(400,'Bibarel',79,71,85,55,60,60,783,4),(401,'Kricketot',37,25,25,25,41,41,784,4),(402,'Kricketune',77,65,85,55,51,51,790,4),(403,'Shinx',45,45,65,40,34,34,791,4),(404,'Luxio',60,60,85,60,49,49,792,4),(405,'Luxray',80,70,120,95,79,79,804,4),(406,'Budew',40,55,30,50,35,70,NULL,4),(407,'Roserade',60,90,70,125,65,105,NULL,4),(408,'Cranidos',67,58,125,30,40,30,NULL,4),(409,'Rampardos',97,58,165,65,60,50,NULL,4),(410,'Shieldon',30,30,42,42,118,88,NULL,4),(411,'Bastiodon',60,30,52,47,168,138,NULL,4),(412,'Burmy',40,36,29,29,45,45,NULL,4),(413,'Wormadam',60,36,69,69,95,95,NULL,4),(414,'Mothim',70,66,94,94,50,50,NULL,4),(415,'Combee',30,70,30,30,42,42,NULL,4),(416,'Vespiquen',70,40,80,80,102,102,NULL,4),(417,'Pachirisu',60,95,45,45,70,90,NULL,4),(418,'Buizel',55,85,65,60,35,30,NULL,4),(419,'Floatzel',85,115,105,85,55,50,NULL,4),(420,'Cherubi',45,35,35,62,45,53,NULL,4),(421,'Cherrim',70,85,60,87,70,78,NULL,4),(422,'Shellos',76,34,48,57,48,62,NULL,4),(423,'Gastrodon',111,39,83,92,68,82,NULL,4),(424,'Ambipom',75,115,100,60,66,66,NULL,4),(425,'Drifloon',90,70,50,60,34,44,NULL,4),(426,'Drifblim',150,80,80,90,44,54,NULL,4),(427,'Buneary',55,85,66,44,44,56,NULL,4),(428,'Lopunny',65,135,136,54,94,96,NULL,4),(429,'Mismagius',60,105,60,105,60,105,NULL,4),(430,'Honchkrow',100,71,125,105,52,52,NULL,4),(431,'Glameow',49,85,55,42,42,37,NULL,4),(432,'Purugly',71,112,82,64,64,59,NULL,4),(433,'Chingling',45,45,30,65,50,50,NULL,4),(434,'Stunky',63,74,63,41,47,41,NULL,4),(435,'Skuntank',103,84,93,71,67,61,NULL,4),(436,'Bronzor',57,23,24,24,86,86,NULL,4),(437,'Bronzong',67,33,89,79,116,116,NULL,4),(438,'Bonsly',50,10,80,10,95,45,NULL,4),(439,'Mime Jr.',20,60,25,70,45,90,NULL,4),(440,'Happiny',100,30,5,15,5,65,NULL,4),(441,'Chatot',76,91,65,92,45,42,NULL,4),(442,'Spiritomb',50,35,92,92,108,108,NULL,4),(443,'Gible',58,42,70,40,45,45,NULL,4),(444,'Gabite',68,82,90,50,65,55,NULL,4),(445,'Garchomp',108,92,170,120,115,95,NULL,4),(446,'Munchlax',135,5,85,40,40,85,NULL,4),(447,'Riolu',40,60,70,35,40,40,NULL,4),(448,'Lucario',70,112,145,140,88,70,NULL,4),(449,'Hippopotas',68,32,72,38,78,42,NULL,4),(450,'Hippowdon',108,47,112,68,118,72,NULL,4),(451,'Skorupi',40,65,50,30,90,55,NULL,4),(452,'Drapion',70,95,90,60,110,75,NULL,4),(453,'Croagunk',48,50,61,61,40,40,NULL,4),(454,'Toxicroak',83,85,106,86,65,65,NULL,4),(455,'Carnivine',74,46,100,90,72,72,NULL,4),(456,'Finneon',49,66,49,49,56,61,NULL,4),(457,'Lumineon',69,91,69,69,76,86,NULL,4),(458,'Mantyke',45,50,20,60,50,120,NULL,4),(459,'Snover',60,40,62,62,50,60,NULL,4),(460,'Abomasnow',90,30,132,132,105,105,NULL,4),(461,'Weavile',70,125,120,45,65,85,NULL,4),(462,'Magnezone',70,60,70,130,115,90,NULL,4),(463,'Lickilicky',110,50,85,80,95,95,NULL,4),(464,'Rhyperior',115,40,140,55,130,55,NULL,4),(465,'Tangrowth',100,50,100,110,125,50,NULL,4),(466,'Electivire',75,95,123,95,67,85,NULL,4),(467,'Magmortar',75,83,95,125,67,95,NULL,4),(468,'Togekiss',85,80,50,120,95,115,NULL,4),(469,'Yanmega',86,95,76,116,86,56,NULL,4),(470,'Leafeon',65,95,110,60,130,65,NULL,4),(471,'Glaceon',65,65,60,130,110,95,NULL,4),(472,'Gliscor',75,95,95,45,125,75,NULL,4),(473,'Mamoswine',110,80,130,70,80,60,NULL,4),(474,'Porygon-Z',85,90,80,135,70,75,NULL,4),(475,'Gallade',68,110,165,65,95,115,NULL,4),(476,'Probopass',60,40,55,75,145,150,NULL,4),(477,'Dusknoir',45,45,100,65,135,135,NULL,4),(478,'Froslass',70,110,80,80,70,70,NULL,4),(479,'Rotom',50,86,65,105,107,107,NULL,4),(480,'Uxie',75,95,75,75,130,130,NULL,4),(481,'Mesprit',80,80,105,105,105,105,NULL,4),(482,'Azelf',75,115,125,125,70,70,NULL,4),(483,'Dialga',100,90,120,150,120,100,NULL,4),(484,'Palkia',90,100,120,150,100,120,NULL,4),(485,'Heatran',91,77,90,130,106,106,NULL,4),(486,'Regigigas',110,100,160,80,110,110,NULL,4),(487,'Giratina',150,90,120,120,100,100,NULL,4),(488,'Cresselia',120,85,70,75,120,130,NULL,4),(489,'Phione',80,80,80,80,80,80,NULL,4),(490,'Manaphy',100,100,100,100,100,100,NULL,4),(491,'Darkrai',70,125,90,135,90,90,NULL,4),(492,'Shaymin',100,127,103,120,75,75,NULL,4),(493,'Arceus',120,120,120,120,120,120,NULL,4),(494,'Victini',100,100,100,100,100,100,NULL,5),(495,'Snivy',45,63,45,45,55,55,NULL,5),(496,'Servine',60,83,60,60,75,75,NULL,5),(497,'Serperior',75,113,75,75,95,95,NULL,5),(498,'Tepig',65,45,63,45,45,45,NULL,5),(499,'Pignite',90,55,93,70,55,55,NULL,5),(500,'Emboar',110,65,123,100,65,65,NULL,5),(501,'Oshawott',55,45,55,63,45,45,NULL,5),(502,'Dewott',75,60,75,83,60,60,NULL,5),(503,'Samurott',95,70,100,108,85,70,NULL,5),(504,'Patrat',45,42,55,35,39,39,NULL,5),(505,'Watchog',60,77,85,60,69,69,NULL,5),(506,'Lillipup',45,55,60,25,45,45,NULL,5),(507,'Herdier',65,60,80,35,65,65,NULL,5),(508,'Stoutland',85,80,110,45,90,90,NULL,5),(509,'Purrloin',41,66,50,50,37,37,NULL,5),(510,'Liepard',64,106,88,88,50,50,NULL,5),(511,'Pansage',50,64,53,53,48,48,NULL,5),(512,'Simisage',75,101,98,98,63,63,NULL,5),(513,'Pansear',50,64,53,53,48,48,NULL,5),(514,'Simisear',75,101,98,98,63,63,NULL,5),(515,'Panpour',50,64,53,53,48,48,NULL,5),(516,'Simipour',75,101,98,98,63,63,NULL,5),(517,'Munna',76,24,25,67,45,55,NULL,5),(518,'Musharna',116,29,55,107,85,95,NULL,5),(519,'Pidove',50,43,55,36,50,30,NULL,5),(520,'Tranquill',62,65,77,50,62,42,NULL,5),(521,'Unfezant',80,93,115,65,80,55,NULL,5),(522,'Blitzle',45,76,60,50,32,32,NULL,5),(523,'Zebstrika',75,116,100,80,63,63,NULL,5),(524,'Roggenrola',55,15,75,25,85,25,NULL,5),(525,'Boldore',70,20,105,50,105,40,NULL,5),(526,'Gigalith',85,25,135,60,130,80,NULL,5),(527,'Woobat',65,72,45,55,43,43,NULL,5),(528,'Swoobat',67,114,57,77,55,55,NULL,5),(529,'Drilbur',60,68,85,30,40,45,NULL,5),(530,'Excadrill',110,88,135,50,60,65,NULL,5),(531,'Audino',103,50,60,80,126,126,NULL,5),(532,'Timburr',75,35,80,25,55,35,NULL,5),(533,'Gurdurr',85,40,105,40,85,50,NULL,5),(534,'Conkeldurr',105,45,140,55,95,65,NULL,5),(535,'Tympole',50,64,50,50,40,40,NULL,5),(536,'Palpitoad',75,69,65,65,55,55,NULL,5),(537,'Seismitoad',105,74,95,85,75,75,NULL,5),(538,'Throh',120,45,100,30,85,85,NULL,5),(539,'Sawk',75,85,125,30,75,75,NULL,5),(540,'Sewaddle',45,42,53,40,70,60,NULL,5),(541,'Swadloon',55,42,63,50,90,80,NULL,5),(542,'Leavanny',75,92,103,70,80,80,NULL,5),(543,'Venipede',30,57,45,30,59,39,NULL,5),(544,'Whirlipede',40,47,55,40,99,79,NULL,5),(545,'Scolipede',60,112,100,55,89,69,NULL,5),(546,'Cottonee',40,66,27,37,60,50,NULL,5),(547,'Whimsicott',60,116,67,77,85,75,NULL,5),(548,'Petilil',45,30,35,70,50,50,NULL,5),(549,'Lilligant',70,90,60,110,75,75,NULL,5),(550,'Basculin',70,98,92,80,65,55,NULL,5),(551,'Sandile',50,65,72,35,35,35,NULL,5),(552,'Krokorok',60,74,82,45,45,45,NULL,5),(553,'Krookodile',95,92,117,65,80,70,NULL,5),(554,'Darumaka',70,50,90,15,45,45,NULL,5),(555,'Darmanitan',105,55,30,140,105,105,NULL,5),(556,'Maractus',75,60,86,106,67,67,NULL,5),(557,'Dwebble',50,55,65,35,85,35,NULL,5),(558,'Crustle',70,45,105,65,125,75,NULL,5),(559,'Scraggy',50,48,75,35,70,70,NULL,5),(560,'Scrafty',65,58,90,45,115,115,NULL,5),(561,'Sigilyph',72,97,58,103,80,80,NULL,5),(562,'Yamask',38,30,30,55,85,65,NULL,5),(563,'Cofagrigus',58,30,50,95,145,105,NULL,5),(564,'Tirtouga',54,22,78,53,103,45,NULL,5),(565,'Carracosta',74,32,108,83,133,65,NULL,5),(566,'Archen',55,70,112,74,45,45,NULL,5),(567,'Archeops',75,110,140,112,65,65,NULL,5),(568,'Trubbish',50,65,50,40,62,62,NULL,5),(569,'Garbodor',80,75,95,60,82,82,NULL,5),(570,'Zorua',40,65,65,80,40,40,NULL,5),(571,'Zoroark',60,105,105,120,60,60,NULL,5),(572,'Minccino',55,75,50,40,40,40,NULL,5),(573,'Cinccino',75,115,95,65,60,60,NULL,5),(574,'Gothita',45,45,30,55,50,65,NULL,5),(575,'Gothorita',60,55,45,75,70,85,NULL,5),(576,'Gothitelle',70,65,55,95,95,110,NULL,5),(577,'Solosis',45,20,30,105,40,50,NULL,5),(578,'Duosion',65,30,40,125,50,60,NULL,5),(579,'Reuniclus',110,30,65,125,75,85,NULL,5),(580,'Ducklett',62,55,44,44,50,50,NULL,5),(581,'Swanna',75,98,87,87,63,63,NULL,5),(582,'Vanillite',36,44,50,65,50,60,NULL,5),(583,'Vanillish',51,59,65,80,65,75,NULL,5),(584,'Vanilluxe',71,79,95,110,85,95,NULL,5),(585,'Deerling',60,75,60,40,50,50,NULL,5),(586,'Sawsbuck',80,95,100,60,70,70,NULL,5),(587,'Emolga',55,103,75,75,60,60,NULL,5),(588,'Karrablast',50,60,75,40,45,45,NULL,5),(589,'Escavalier',70,20,135,60,105,105,NULL,5),(590,'Foongus',69,15,55,55,45,55,NULL,5),(591,'Amoonguss',114,30,85,85,70,80,NULL,5),(592,'Frillish',55,40,40,65,50,85,NULL,5),(593,'Jellicent',100,60,60,85,70,105,NULL,5),(594,'Alomomola',165,65,75,40,80,45,NULL,5),(595,'Joltik',50,65,47,57,50,50,NULL,5),(596,'Galvantula',70,108,77,97,60,60,NULL,5),(597,'Ferroseed',44,10,50,24,91,86,NULL,5),(598,'Ferrothorn',74,20,94,54,131,116,NULL,5),(599,'Klink',40,30,55,45,70,60,NULL,5),(600,'Klang',60,50,80,70,95,85,NULL,5),(601,'Klinklang',60,90,100,70,115,85,NULL,5),(602,'Tynamo',35,60,55,45,40,40,NULL,5),(603,'Eelektrik',65,40,85,75,70,70,NULL,5),(604,'Eelektross',85,50,115,105,80,80,NULL,5),(605,'Elgyem',55,30,55,85,55,55,NULL,5),(606,'Beheeyem',75,40,75,125,75,95,NULL,5),(607,'Litwick',50,20,30,65,55,55,NULL,5),(608,'Lampent',60,55,40,95,60,60,NULL,5),(609,'Chandelure',60,80,55,145,90,90,NULL,5),(610,'Axew',46,57,87,30,60,40,NULL,5),(611,'Fraxure',66,67,117,40,70,50,NULL,5),(612,'Haxorus',76,97,147,60,90,70,NULL,5),(613,'Cubchoo',55,40,70,60,40,40,NULL,5),(614,'Beartic',95,50,130,70,80,80,NULL,5),(615,'Cryogonal',80,105,50,95,50,135,NULL,5),(616,'Shelmet',50,25,40,40,85,65,NULL,5),(617,'Accelgor',80,145,70,100,40,60,NULL,5),(618,'Stunfisk',109,32,66,81,84,99,NULL,5),(619,'Mienfoo',45,65,85,55,50,50,NULL,5),(620,'Mienshao',65,105,125,95,60,60,NULL,5),(621,'Druddigon',77,48,120,60,90,90,NULL,5),(622,'Golett',59,35,74,35,50,50,NULL,5),(623,'Golurk',89,55,124,55,80,80,NULL,5),(624,'Pawniard',45,60,85,40,70,40,NULL,5),(625,'Bisharp',65,70,125,60,100,70,NULL,5),(626,'Bouffalant',95,55,110,40,95,95,NULL,5),(627,'Rufflet',70,60,83,37,50,50,NULL,5),(628,'Braviary',100,80,123,57,75,75,NULL,5),(629,'Vullaby',70,60,55,45,75,65,NULL,5),(630,'Mandibuzz',110,80,65,55,105,95,NULL,5),(631,'Heatmor',85,65,97,105,66,66,NULL,5),(632,'Durant',58,109,109,48,112,48,NULL,5),(633,'Deino',52,38,65,45,50,50,NULL,5),(634,'Zweilous',72,58,85,65,70,70,NULL,5),(635,'Hydreigon',92,98,105,125,90,90,NULL,5),(636,'Larvesta',55,60,85,50,55,55,NULL,5),(637,'Volcarona',85,100,60,135,65,105,NULL,5),(638,'Cobalion',91,108,90,90,129,72,NULL,5),(639,'Terrakion',91,108,129,72,90,90,NULL,5),(640,'Virizion',91,108,90,90,72,129,NULL,5),(641,'Tornadus',79,121,100,110,80,90,NULL,5),(642,'Thundurus',79,101,105,145,70,80,NULL,5),(643,'Reshiram',100,90,120,150,100,120,NULL,5),(644,'Zekrom',100,90,150,120,120,100,NULL,5),(645,'Landorus',89,91,145,105,90,80,NULL,5),(646,'Kyurem',125,95,120,170,90,100,NULL,5),(647,'Keldeo',91,108,72,129,90,90,NULL,5),(648,'Meloetta',100,128,128,77,90,77,NULL,5),(649,'Genesect',71,99,120,120,95,95,NULL,5),(650,'Chespin',56,38,61,48,65,45,NULL,6),(651,'Quilladin',61,57,78,56,95,58,NULL,6),(652,'Chesnaught',88,64,107,74,122,75,NULL,6),(653,'Fennekin',40,60,45,62,40,60,NULL,6),(654,'Braixen',59,73,59,90,58,70,NULL,6),(655,'Delphox',75,104,69,114,72,100,NULL,6),(656,'Froakie',41,71,56,62,40,44,NULL,6),(657,'Frogadier',54,97,63,83,52,56,NULL,6),(658,'Greninja',72,132,145,153,67,71,NULL,6),(659,'Bunnelby',38,57,36,32,38,36,NULL,6),(660,'Diggersby',85,78,56,50,77,77,NULL,6),(661,'Fletchling',45,62,50,40,43,38,NULL,6),(662,'Fletchinder',62,84,73,56,55,52,NULL,6),(663,'Talonflame',78,126,81,74,71,69,NULL,6),(664,'Scatterbug',38,35,35,27,40,25,NULL,6),(665,'Spewpa',45,29,22,27,60,30,NULL,6),(666,'Vivillon',80,89,52,90,50,50,NULL,6),(667,'Litleo',62,72,50,73,58,54,NULL,6),(668,'Pyroar',86,106,68,109,72,66,NULL,6),(669,'Flabébé',44,42,38,61,39,79,NULL,6),(670,'Floette',74,92,65,125,67,128,NULL,6),(671,'Florges',78,75,65,112,68,154,NULL,6),(672,'Skiddo',66,52,65,62,48,57,NULL,6),(673,'Gogoat',123,68,100,97,62,81,NULL,6),(674,'Pancham',67,43,82,46,62,48,NULL,6),(675,'Pangoro',95,58,124,69,78,71,NULL,6),(676,'Furfrou',75,102,80,65,60,90,NULL,6),(677,'Espurr',62,68,48,63,54,60,NULL,6),(678,'Meowstic',74,104,48,83,76,81,NULL,6),(679,'Honedge',45,28,80,35,100,37,NULL,6),(680,'Doublade',59,35,110,45,150,49,NULL,6),(681,'Aegislash',60,60,150,150,50,50,NULL,6),(682,'Spritzee',78,23,52,63,60,65,NULL,6),(683,'Aromatisse',101,29,72,99,72,89,NULL,6),(684,'Swirlix',62,49,48,59,66,57,NULL,6),(685,'Slurpuff',82,72,80,85,86,75,NULL,6),(686,'Inkay',53,45,54,37,53,46,NULL,6),(687,'Malamar',86,73,92,68,88,75,NULL,6),(688,'Binacle',42,50,52,39,67,56,NULL,6),(689,'Barbaracle',72,68,105,54,115,86,NULL,6),(690,'Skrelp',50,30,60,60,60,60,NULL,6),(691,'Dragalge',65,44,75,97,90,123,NULL,6),(692,'Clauncher',50,44,53,58,62,63,NULL,6),(693,'Clawitzer',71,59,73,120,88,89,NULL,6),(694,'Helioptile',44,70,38,61,33,43,NULL,6),(695,'Heliolisk',62,109,55,109,52,94,NULL,6),(696,'Tyrunt',58,48,89,45,77,45,NULL,6),(697,'Tyrantrum',82,71,121,69,119,59,NULL,6),(698,'Amaura',77,46,59,67,50,63,NULL,6),(699,'Aurorus',123,58,77,99,72,92,NULL,6),(700,'Sylveon',95,60,65,110,65,130,NULL,6),(701,'Hawlucha',78,118,92,74,75,63,NULL,6),(702,'Dedenne',67,101,58,81,57,67,NULL,6),(703,'Carbink',50,50,50,50,150,150,NULL,6),(704,'Goomy',45,40,50,55,35,75,NULL,6),(705,'Sliggoo',68,60,75,83,53,113,NULL,6),(706,'Goodra',90,80,100,110,70,150,NULL,6),(707,'Klefki',57,75,80,80,91,87,NULL,6),(708,'Phantump',43,38,70,50,48,60,NULL,6),(709,'Trevenant',85,56,110,65,76,82,NULL,6),(710,'Pumpkaboo',59,41,66,44,70,55,NULL,6),(711,'Gourgeist',85,54,100,58,122,75,NULL,6),(712,'Bergmite',55,28,69,32,85,35,NULL,6),(713,'Avalugg',95,28,117,44,184,46,NULL,6),(714,'Noibat',40,55,30,45,35,40,NULL,6),(715,'Noivern',85,123,70,97,80,80,NULL,6),(716,'Xerneas',126,99,131,131,95,98,NULL,6),(717,'Yveltal',126,99,131,131,95,98,NULL,6),(718,'Zygarde',216,85,100,91,121,95,NULL,6),(719,'Diancie',50,110,160,160,110,110,NULL,6),(720,'Hoopa',80,80,160,170,60,130,NULL,6),(721,'Volcanion',80,70,110,130,120,90,NULL,6),(722,'Rowlet',68,42,55,50,55,50,NULL,7),(723,'Dartrix',78,52,75,70,75,70,NULL,7),(724,'Decidueye',78,70,107,100,75,100,NULL,7),(725,'Litten',45,70,65,60,40,40,NULL,7),(726,'Torracat',65,90,85,80,50,50,NULL,7),(727,'Incineroar',95,60,115,80,90,90,NULL,7),(728,'Popplio',50,40,54,66,54,56,NULL,7),(729,'Brionne',60,50,69,91,69,81,NULL,7),(730,'Primarina',80,60,74,126,74,116,NULL,7),(731,'Pikipek',35,65,75,30,30,30,NULL,7),(732,'Trumbeak',55,75,85,40,50,50,NULL,7),(733,'Toucannon',80,60,120,75,75,75,NULL,7),(734,'Yungoos',48,45,70,30,30,30,NULL,7),(735,'Gumshoos',88,45,110,55,60,60,NULL,7),(736,'Grubbin',47,46,62,55,45,45,NULL,7),(737,'Charjabug',57,36,82,55,95,75,NULL,7),(738,'Vikavolt',77,43,70,145,90,75,NULL,7),(739,'Crabrawler',47,63,82,42,57,47,NULL,7),(740,'Crabominable',97,43,132,62,77,67,NULL,7),(741,'Oricorio',75,93,70,98,70,70,NULL,7),(742,'Cutiefly',40,84,45,55,40,40,NULL,7),(743,'Ribombee',60,124,55,95,60,70,NULL,7),(744,'Rockruff',45,60,65,30,40,40,NULL,7),(745,'Lycanroc',85,82,115,55,75,75,NULL,7),(746,'Wishiwashi',45,30,140,140,130,135,NULL,7),(747,'Mareanie',50,45,53,43,62,52,NULL,7),(748,'Toxapex',50,35,63,53,152,142,NULL,7),(749,'Mudbray',70,45,100,45,70,55,NULL,7),(750,'Mudsdale',100,35,125,55,100,85,NULL,7),(751,'Dewpider',38,27,40,40,52,72,NULL,7),(752,'Araquanid',68,42,70,50,92,132,NULL,7),(753,'Fomantis',40,35,55,50,35,35,NULL,7),(754,'Lurantis',70,45,105,80,90,90,NULL,7),(755,'Morelull',40,15,35,65,55,75,NULL,7),(756,'Shiinotic',60,30,45,90,80,100,NULL,7),(757,'Salandit',48,77,44,71,40,40,NULL,7),(758,'Salazzle',68,117,64,111,60,60,NULL,7),(759,'Stufful',70,50,75,45,50,50,NULL,7),(760,'Bewear',120,60,125,55,80,60,NULL,7),(761,'Bounsweet',42,32,30,30,38,38,NULL,7),(762,'Steenee',52,62,40,40,48,48,NULL,7),(763,'Tsareena',72,72,120,50,98,98,NULL,7),(764,'Comfey',51,100,52,82,90,110,NULL,7),(765,'Oranguru',90,60,60,90,80,110,NULL,7),(766,'Passimian',100,80,120,40,90,60,NULL,7),(767,'Wimpod',25,80,35,20,40,30,NULL,7),(768,'Golisopod',75,40,125,60,140,90,NULL,7),(769,'Sandygast',55,15,55,70,80,45,NULL,7),(770,'Palossand',85,35,75,100,110,75,NULL,7),(771,'Pyukumuku',55,5,60,30,130,130,NULL,7),(772,'Type: Null',95,59,95,95,95,95,NULL,7),(773,'Silvally',95,95,95,95,95,95,NULL,7),(774,'Minior',60,120,100,100,60,60,NULL,7),(775,'Komala',65,65,115,75,65,95,NULL,7),(776,'Turtonator',60,36,78,91,135,85,NULL,7),(777,'Togedemaru',65,96,98,40,63,73,NULL,7),(778,'Mimikyu',55,96,90,50,80,105,NULL,7),(779,'Bruxish',68,92,105,70,70,70,NULL,7),(780,'Drampa',78,36,60,135,85,91,NULL,7),(781,'Dhelmise',70,40,131,86,100,90,NULL,7),(782,'Jangmo-o',45,45,55,45,65,45,NULL,7),(783,'Hakamo-o',55,65,75,65,90,70,NULL,7),(784,'Kommo-o',75,85,110,100,125,105,NULL,7),(785,'Tapu Koko',70,130,115,95,85,75,NULL,7),(786,'Tapu Lele',70,95,85,130,75,115,NULL,7),(787,'Tapu Bulu',70,75,130,85,115,95,NULL,7),(788,'Tapu Fini',70,85,75,95,115,130,NULL,7),(789,'Cosmog',43,37,29,29,31,31,NULL,7),(790,'Cosmoem',43,37,29,29,131,131,NULL,7),(791,'Solgaleo',137,97,137,113,107,89,NULL,7),(792,'Lunala',137,97,113,137,89,107,NULL,7),(793,'Nihilego',109,103,53,127,47,131,NULL,7),(794,'Buzzwole',107,79,139,53,139,53,NULL,7),(795,'Pheromosa',71,151,137,137,37,37,NULL,7),(796,'Xurkitree',83,83,89,173,71,71,NULL,7),(797,'Celesteela',97,61,101,107,103,101,NULL,7),(798,'Kartana',59,109,181,59,131,31,NULL,7),(799,'Guzzlord',223,43,101,97,53,53,NULL,7),(800,'Necrozma',97,79,107,127,101,89,NULL,7),(801,'Magearna',80,65,95,130,115,115,NULL,7);
/*!40000 ALTER TABLE `pokemon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pokemon_type`
--

DROP TABLE IF EXISTS `pokemon_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pokemon_type` (
  `pokemon_id` int NOT NULL,
  `type_1` varchar(45) NOT NULL,
  `type_2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pokemon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon_type`
--

LOCK TABLES `pokemon_type` WRITE;
/*!40000 ALTER TABLE `pokemon_type` DISABLE KEYS */;
INSERT INTO `pokemon_type` VALUES (1,'grass','poison'),(2,'grass','poison'),(3,'grass','poison'),(4,'fire',''),(5,'fire',''),(6,'fire','flying'),(7,'water',''),(8,'water',''),(9,'water',''),(10,'bug',''),(11,'bug',''),(12,'bug','flying'),(13,'bug','poison'),(14,'bug','poison'),(15,'bug','poison'),(16,'normal','flying'),(17,'normal','flying'),(18,'normal','flying'),(19,'normal','dark'),(20,'normal','dark'),(21,'normal','flying'),(22,'normal','flying'),(23,'poison',''),(24,'poison',''),(25,'electric',''),(26,'electric','electric'),(27,'ground','ice'),(28,'ground','ice'),(29,'poison',''),(30,'poison',''),(31,'poison','ground'),(32,'poison',''),(33,'poison',''),(34,'poison','ground'),(35,'fairy',''),(36,'fairy',''),(37,'fire','ice'),(38,'fire','ice'),(39,'normal','fairy'),(40,'normal','fairy'),(41,'poison','flying'),(42,'poison','flying'),(43,'grass','poison'),(44,'grass','poison'),(45,'grass','poison'),(46,'bug','grass'),(47,'bug','grass'),(48,'bug','poison'),(49,'bug','poison'),(50,'ground','ground'),(51,'ground','ground'),(52,'normal','dark'),(53,'normal','dark'),(54,'water',''),(55,'water',''),(56,'fighting',''),(57,'fighting',''),(58,'fire',''),(59,'fire',''),(60,'water',''),(61,'water',''),(62,'water','fighting'),(63,'psychic',''),(64,'psychic',''),(65,'psychic',''),(66,'fighting',''),(67,'fighting',''),(68,'fighting',''),(69,'grass','poison'),(70,'grass','poison'),(71,'grass','poison'),(72,'water','poison'),(73,'water','poison'),(74,'rock','ground'),(75,'rock','ground'),(76,'rock','ground'),(77,'fire',''),(78,'fire',''),(79,'water','psychic'),(80,'water','psychic'),(81,'electric','steel'),(82,'electric','steel'),(83,'normal','flying'),(84,'normal','flying'),(85,'normal','flying'),(86,'water',''),(87,'water','ice'),(88,'poison','poison'),(89,'poison','poison'),(90,'water',''),(91,'water','ice'),(92,'ghost','poison'),(93,'ghost','poison'),(94,'ghost','poison'),(95,'rock','ground'),(96,'psychic',''),(97,'psychic',''),(98,'water',''),(99,'water',''),(100,'electric',''),(101,'electric',''),(102,'grass','psychic'),(103,'grass','psychic'),(104,'ground',''),(105,'ground','fire'),(106,'fighting',''),(107,'fighting',''),(108,'normal',''),(109,'poison',''),(110,'poison',''),(111,'ground','rock'),(112,'ground','rock'),(113,'normal',''),(114,'grass',''),(115,'normal',''),(116,'water',''),(117,'water',''),(118,'water',''),(119,'water',''),(120,'water',''),(121,'water','psychic'),(122,'psychic','fairy'),(123,'bug','flying'),(124,'ice','psychic'),(125,'electric',''),(126,'fire',''),(127,'bug',''),(128,'normal',''),(129,'water',''),(130,'water','flying'),(131,'water','ice'),(132,'normal',''),(133,'normal',''),(134,'water',''),(135,'electric',''),(136,'fire',''),(137,'normal',''),(138,'rock','water'),(139,'rock','water'),(140,'rock','water'),(141,'rock','water'),(142,'rock','flying'),(143,'normal',''),(144,'ice','flying'),(145,'electric','flying'),(146,'fire','flying'),(147,'dragon',''),(148,'dragon',''),(149,'dragon','flying'),(150,'psychic',''),(151,'psychic',''),(152,'grass',''),(153,'grass',''),(154,'grass',''),(155,'fire',''),(156,'fire',''),(157,'fire',''),(158,'water',''),(159,'water',''),(160,'water',''),(161,'normal',''),(162,'normal',''),(163,'normal','flying'),(164,'normal','flying'),(165,'bug','flying'),(166,'bug','flying'),(167,'bug','poison'),(168,'bug','poison'),(169,'poison','flying'),(170,'water','electric'),(171,'water','electric'),(172,'electric',''),(173,'fairy',''),(174,'normal','fairy'),(175,'fairy',''),(176,'fairy','flying'),(177,'psychic','flying'),(178,'psychic','flying'),(179,'electric',''),(180,'electric',''),(181,'electric',''),(182,'grass',''),(183,'water','fairy'),(184,'water','fairy'),(185,'rock',''),(186,'water',''),(187,'grass','flying'),(188,'grass','flying'),(189,'grass','flying'),(190,'normal',''),(191,'grass',''),(192,'grass',''),(193,'bug','flying'),(194,'water','ground'),(195,'water','ground'),(196,'psychic',''),(197,'dark',''),(198,'dark','flying'),(199,'water','psychic'),(200,'ghost',''),(201,'psychic',''),(202,'psychic',''),(203,'normal','psychic'),(204,'bug',''),(205,'bug','steel'),(206,'normal',''),(207,'ground','flying'),(208,'steel','ground'),(209,'fairy',''),(210,'fairy',''),(211,'water','poison'),(212,'bug','steel'),(213,'bug','rock'),(214,'bug','fighting'),(215,'dark','ice'),(216,'normal',''),(217,'normal',''),(218,'fire',''),(219,'fire','rock'),(220,'ice','ground'),(221,'ice','ground'),(222,'water','rock'),(223,'water',''),(224,'water',''),(225,'ice','flying'),(226,'water','flying'),(227,'steel','flying'),(228,'dark','fire'),(229,'dark','fire'),(230,'water','dragon'),(231,'ground',''),(232,'ground',''),(233,'normal',''),(234,'normal',''),(235,'normal',''),(236,'fighting',''),(237,'fighting',''),(238,'ice','psychic'),(239,'electric',''),(240,'fire',''),(241,'normal',''),(242,'normal',''),(243,'electric',''),(244,'fire',''),(245,'water',''),(246,'rock','ground'),(247,'rock','ground'),(248,'rock','dark'),(249,'psychic','flying'),(250,'fire','flying'),(251,'psychic','grass'),(252,'grass',''),(253,'grass',''),(254,'grass',''),(255,'fire',''),(256,'fire','fighting'),(257,'fire','fighting'),(258,'water',''),(259,'water','ground'),(260,'water','ground'),(261,'dark',''),(262,'dark',''),(263,'normal',''),(264,'normal',''),(265,'bug',''),(266,'bug',''),(267,'bug','flying'),(268,'bug',''),(269,'bug','poison'),(270,'water','grass'),(271,'water','grass'),(272,'water','grass'),(273,'grass',''),(274,'grass','dark'),(275,'grass','dark'),(276,'normal','flying'),(277,'normal','flying'),(278,'water','flying'),(279,'water','flying'),(280,'psychic','fairy'),(281,'psychic','fairy'),(282,'psychic','fairy'),(283,'bug','water'),(284,'bug','flying'),(285,'grass',''),(286,'grass','fighting'),(287,'normal',''),(288,'normal',''),(289,'normal',''),(290,'bug','ground'),(291,'bug','flying'),(292,'bug','ghost'),(293,'normal',''),(294,'normal',''),(295,'normal',''),(296,'fighting',''),(297,'fighting',''),(298,'normal','fairy'),(299,'rock',''),(300,'normal',''),(301,'normal',''),(302,'dark','ghost'),(303,'steel','fairy'),(304,'steel','rock'),(305,'steel','rock'),(306,'steel','rock'),(307,'fighting','psychic'),(308,'fighting','psychic'),(309,'electric',''),(310,'electric',''),(311,'electric',''),(312,'electric',''),(313,'bug',''),(314,'bug',''),(315,'grass','poison'),(316,'poison',''),(317,'poison',''),(318,'water','dark'),(319,'water','dark'),(320,'water',''),(321,'water',''),(322,'fire','ground'),(323,'fire','ground'),(324,'fire',''),(325,'psychic',''),(326,'psychic',''),(327,'normal',''),(328,'ground',''),(329,'ground','dragon'),(330,'ground','dragon'),(331,'grass',''),(332,'grass','dark'),(333,'normal','flying'),(334,'dragon','flying'),(335,'normal',''),(336,'poison',''),(337,'rock','psychic'),(338,'rock','psychic'),(339,'water','ground'),(340,'water','ground'),(341,'water',''),(342,'water','dark'),(343,'ground','psychic'),(344,'ground','psychic'),(345,'rock','grass'),(346,'rock','grass'),(347,'rock','bug'),(348,'rock','bug'),(349,'water',''),(350,'water',''),(351,'normal',''),(352,'normal',''),(353,'ghost',''),(354,'ghost',''),(355,'ghost',''),(356,'ghost',''),(357,'grass','flying'),(358,'psychic',''),(359,'dark',''),(360,'psychic',''),(361,'ice',''),(362,'ice',''),(363,'ice','water'),(364,'ice','water'),(365,'ice','water'),(366,'water',''),(367,'water',''),(368,'water',''),(369,'water','rock'),(370,'water',''),(371,'dragon',''),(372,'dragon',''),(373,'dragon','flying'),(374,'steel','psychic'),(375,'steel','psychic'),(376,'steel','psychic'),(377,'rock',''),(378,'ice',''),(379,'steel',''),(380,'dragon','psychic'),(381,'dragon','psychic'),(382,'water',''),(383,'ground',''),(384,'dragon','flying'),(385,'steel','psychic'),(386,'psychic',''),(387,'grass',''),(388,'grass',''),(389,'grass','ground'),(390,'fire',''),(391,'fire','fighting'),(392,'fire','fighting'),(393,'water',''),(394,'water',''),(395,'water','steel'),(396,'normal','flying'),(397,'normal','flying'),(398,'normal','flying'),(399,'normal',''),(400,'normal','water'),(401,'bug',''),(402,'bug',''),(403,'electric',''),(404,'electric',''),(405,'electric',''),(406,'grass','poison'),(407,'grass','poison'),(408,'rock',''),(409,'rock',''),(410,'rock','steel'),(411,'rock','steel'),(412,'bug',''),(413,'bug','grass'),(414,'bug','flying'),(415,'bug','flying'),(416,'bug','flying'),(417,'electric',''),(418,'water',''),(419,'water',''),(420,'grass',''),(421,'grass',''),(422,'water',''),(423,'water','ground'),(424,'normal',''),(425,'ghost','flying'),(426,'ghost','flying'),(427,'normal',''),(428,'normal',''),(429,'ghost',''),(430,'dark','flying'),(431,'normal',''),(432,'normal',''),(433,'psychic',''),(434,'poison','dark'),(435,'poison','dark'),(436,'steel','psychic'),(437,'steel','psychic'),(438,'rock',''),(439,'psychic','fairy'),(440,'normal',''),(441,'normal','flying'),(442,'ghost','dark'),(443,'dragon','ground'),(444,'dragon','ground'),(445,'dragon','ground'),(446,'normal',''),(447,'fighting',''),(448,'fighting','steel'),(449,'ground',''),(450,'ground',''),(451,'poison','bug'),(452,'poison','dark'),(453,'poison','fighting'),(454,'poison','fighting'),(455,'grass',''),(456,'water',''),(457,'water',''),(458,'water','flying'),(459,'grass','ice'),(460,'grass','ice'),(461,'dark','ice'),(462,'electric','steel'),(463,'normal',''),(464,'ground','rock'),(465,'grass',''),(466,'electric',''),(467,'fire',''),(468,'fairy','flying'),(469,'bug','flying'),(470,'grass',''),(471,'ice',''),(472,'ground','flying'),(473,'ice','ground'),(474,'normal',''),(475,'psychic','fighting'),(476,'rock','steel'),(477,'ghost',''),(478,'ice','ghost'),(479,'electric','ghost'),(480,'psychic',''),(481,'psychic',''),(482,'psychic',''),(483,'steel','dragon'),(484,'water','dragon'),(485,'fire','steel'),(486,'normal',''),(487,'ghost','dragon'),(488,'psychic',''),(489,'water',''),(490,'water',''),(491,'dark',''),(492,'grass','grass'),(493,'normal',''),(494,'psychic','fire'),(495,'grass',''),(496,'grass',''),(497,'grass',''),(498,'fire',''),(499,'fire','fighting'),(500,'fire','fighting'),(501,'water',''),(502,'water',''),(503,'water',''),(504,'normal',''),(505,'normal',''),(506,'normal',''),(507,'normal',''),(508,'normal',''),(509,'dark',''),(510,'dark',''),(511,'grass',''),(512,'grass',''),(513,'fire',''),(514,'fire',''),(515,'water',''),(516,'water',''),(517,'psychic',''),(518,'psychic',''),(519,'normal','flying'),(520,'normal','flying'),(521,'normal','flying'),(522,'electric',''),(523,'electric',''),(524,'rock',''),(525,'rock',''),(526,'rock',''),(527,'psychic','flying'),(528,'psychic','flying'),(529,'ground',''),(530,'ground','steel'),(531,'normal',''),(532,'fighting',''),(533,'fighting',''),(534,'fighting',''),(535,'water',''),(536,'water','ground'),(537,'water','ground'),(538,'fighting',''),(539,'fighting',''),(540,'bug','grass'),(541,'bug','grass'),(542,'bug','grass'),(543,'bug','poison'),(544,'bug','poison'),(545,'bug','poison'),(546,'grass','fairy'),(547,'grass','fairy'),(548,'grass',''),(549,'grass',''),(550,'water',''),(551,'ground','dark'),(552,'ground','dark'),(553,'ground','dark'),(554,'fire',''),(555,'fire','fire'),(556,'grass',''),(557,'bug','rock'),(558,'bug','rock'),(559,'dark','fighting'),(560,'dark','fighting'),(561,'psychic','flying'),(562,'ghost',''),(563,'ghost',''),(564,'water','rock'),(565,'water','rock'),(566,'rock','flying'),(567,'rock','flying'),(568,'poison',''),(569,'poison',''),(570,'dark',''),(571,'dark',''),(572,'normal',''),(573,'normal',''),(574,'psychic',''),(575,'psychic',''),(576,'psychic',''),(577,'psychic',''),(578,'psychic',''),(579,'psychic',''),(580,'water','flying'),(581,'water','flying'),(582,'ice',''),(583,'ice',''),(584,'ice',''),(585,'normal','grass'),(586,'normal','grass'),(587,'electric','flying'),(588,'bug',''),(589,'bug','steel'),(590,'grass','poison'),(591,'grass','poison'),(592,'water','ghost'),(593,'water','ghost'),(594,'water',''),(595,'bug','electric'),(596,'bug','electric'),(597,'grass','steel'),(598,'grass','steel'),(599,'steel',''),(600,'steel',''),(601,'steel',''),(602,'electric',''),(603,'electric',''),(604,'electric',''),(605,'psychic',''),(606,'psychic',''),(607,'ghost','fire'),(608,'ghost','fire'),(609,'ghost','fire'),(610,'dragon',''),(611,'dragon',''),(612,'dragon',''),(613,'ice',''),(614,'ice',''),(615,'ice',''),(616,'bug',''),(617,'bug',''),(618,'ground','electric'),(619,'fighting',''),(620,'fighting',''),(621,'dragon',''),(622,'ground','ghost'),(623,'ground','ghost'),(624,'dark','steel'),(625,'dark','steel'),(626,'normal',''),(627,'normal','flying'),(628,'normal','flying'),(629,'dark','flying'),(630,'dark','flying'),(631,'fire',''),(632,'bug','steel'),(633,'dark','dragon'),(634,'dark','dragon'),(635,'dark','dragon'),(636,'bug','fire'),(637,'bug','fire'),(638,'steel','fighting'),(639,'rock','fighting'),(640,'grass','fighting'),(641,'flying',''),(642,'electric','flying'),(643,'dragon','fire'),(644,'dragon','electric'),(645,'ground','flying'),(646,'dragon','ice'),(647,'water','fighting'),(648,'normal','psychic'),(649,'bug','steel'),(650,'grass',''),(651,'grass',''),(652,'grass','fighting'),(653,'fire',''),(654,'fire',''),(655,'fire','psychic'),(656,'water',''),(657,'water',''),(658,'water','dark'),(659,'normal',''),(660,'normal','ground'),(661,'normal','flying'),(662,'fire','flying'),(663,'fire','flying'),(664,'bug',''),(665,'bug',''),(666,'bug','flying'),(667,'fire','normal'),(668,'fire','normal'),(669,'fairy',''),(670,'fairy',''),(671,'fairy',''),(672,'grass',''),(673,'grass',''),(674,'fighting',''),(675,'fighting','dark'),(676,'normal',''),(677,'psychic',''),(678,'psychic',''),(679,'steel','ghost'),(680,'steel','ghost'),(681,'steel','ghost'),(682,'fairy',''),(683,'fairy',''),(684,'fairy',''),(685,'fairy',''),(686,'dark','psychic'),(687,'dark','psychic'),(688,'rock','water'),(689,'rock','water'),(690,'poison','water'),(691,'poison','dragon'),(692,'water',''),(693,'water',''),(694,'electric','normal'),(695,'electric','normal'),(696,'rock','dragon'),(697,'rock','dragon'),(698,'rock','ice'),(699,'rock','ice'),(700,'fairy',''),(701,'fighting','flying'),(702,'electric','fairy'),(703,'rock','fairy'),(704,'dragon',''),(705,'dragon',''),(706,'dragon',''),(707,'steel','fairy'),(708,'ghost','grass'),(709,'ghost','grass'),(710,'ghost','grass'),(711,'ghost','grass'),(712,'ice',''),(713,'ice',''),(714,'flying','dragon'),(715,'flying','dragon'),(716,'fairy',''),(717,'dark','flying'),(718,'dragon','ground'),(719,'rock','fairy'),(720,'psychic','ghost'),(721,'fire','water'),(722,'grass','flying'),(723,'grass','flying'),(724,'grass','ghost'),(725,'fire',''),(726,'fire',''),(727,'fire','dark'),(728,'water',''),(729,'water',''),(730,'water','fairy'),(731,'normal','flying'),(732,'normal','flying'),(733,'normal','flying'),(734,'normal',''),(735,'normal',''),(736,'bug',''),(737,'bug','electric'),(738,'bug','electric'),(739,'fighting',''),(740,'fighting','ice'),(741,'fire','flying'),(742,'bug','fairy'),(743,'bug','fairy'),(744,'rock',''),(745,'rock',''),(746,'water',''),(747,'poison','water'),(748,'poison','water'),(749,'ground',''),(750,'ground',''),(751,'water','bug'),(752,'water','bug'),(753,'grass',''),(754,'grass',''),(755,'grass','fairy'),(756,'grass','fairy'),(757,'poison','fire'),(758,'poison','fire'),(759,'normal','fighting'),(760,'normal','fighting'),(761,'grass',''),(762,'grass',''),(763,'grass',''),(764,'fairy',''),(765,'normal','psychic'),(766,'fighting',''),(767,'bug','water'),(768,'bug','water'),(769,'ghost','ground'),(770,'ghost','ground'),(771,'water',''),(772,'normal',''),(773,'normal',''),(774,'rock','flying'),(775,'normal',''),(776,'fire','dragon'),(777,'electric','steel'),(778,'ghost','fairy'),(779,'water','psychic'),(780,'normal','dragon'),(781,'ghost','grass'),(782,'dragon',''),(783,'dragon','fighting'),(784,'dragon','fighting'),(785,'electric','fairy'),(786,'psychic','fairy'),(787,'grass','fairy'),(788,'water','fairy'),(789,'psychic',''),(790,'psychic',''),(791,'psychic','steel'),(792,'psychic','ghost'),(793,'rock','poison'),(794,'bug','fighting'),(795,'bug','fighting'),(796,'electric',''),(797,'steel','flying'),(798,'grass','steel'),(799,'dark','dragon'),(800,'psychic',''),(801,'steel','fairy'),(805,'electric',NULL);
/*!40000 ALTER TABLE `pokemon_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer` (
  `trainer_id` int NOT NULL AUTO_INCREMENT,
  `trainer_name` varchar(45) NOT NULL,
  PRIMARY KEY (`trainer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer`
--

LOCK TABLES `trainer` WRITE;
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
INSERT INTO `trainer` VALUES (1,'Nithila'),(2,'Daniel'),(3,'Joshua'),(12,'kathleen'),(23,'kathleen'),(30,'newJosh');
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer_pokemon`
--

DROP TABLE IF EXISTS `trainer_pokemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainer_pokemon` (
  `trainer_id` int NOT NULL,
  `pokemon_id` int NOT NULL,
  PRIMARY KEY (`trainer_id`,`pokemon_id`),
  KEY `fk_pokemon_trainer_pokemon_idx` (`pokemon_id`),
  CONSTRAINT `fk_pokemon_trainer_pokemon` FOREIGN KEY (`pokemon_id`) REFERENCES `pokemon` (`idNum`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_trainer_trainer_pokemon` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer_pokemon`
--

LOCK TABLES `trainer_pokemon` WRITE;
/*!40000 ALTER TABLE `trainer_pokemon` DISABLE KEYS */;
INSERT INTO `trainer_pokemon` VALUES (1,1),(1,3),(1,5),(2,7),(2,9),(2,11),(3,13),(3,15),(3,17),(1,45),(30,100),(3,450);
/*!40000 ALTER TABLE `trainer_pokemon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `types` (
  `types` varchar(45) NOT NULL,
  PRIMARY KEY (`types`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES ('bug'),('dark'),('dragon'),('electric'),('fairy'),('fighting'),('fire'),('flying'),('ghost'),('grass'),('ground'),('ice'),('normal'),('poison'),('psychic'),('rock'),('steel'),('water');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pokemon_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `add_gen` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_gen`(IN gen_ INT, IN intro_ DATE)
BEGIN
DECLARE max_gen int;
DECLARE max_date DATE;
SELECT MAX(date_introduced) into max_date
FROM generation;
SELECT MAX(generation) into max_gen
FROM generation;
IF(gen_ > max_gen AND intro_ > max_date)
THEN
INSERT INTO generation(generation, date_introduced)
VALUES (gen_, intro_);
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_pokemon` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_pokemon`(IN name_ varchar(45), in HP_ int, in speed_ int, in attack_ int, in special_attack_ int, in defense_ int, in special_defense_ int, in evolve_id_ int, in generation_ int, in type1_ varchar(45), in type2_ varchar(45))
BEGIN
	insert into pokemon (name, HP, speed, attack, special_attack, defense, special_defense, evolve_id, generation)
	values(name_, HP_, speed_, attack_, special_attack_, defense_, special_defense_, evolve_id_, generation_);
    
    insert into pokemon_type(pokemon_id, type_1, type_2)
    values((select idNum from pokemon where name = name_), type1_, type2_); 
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_pokemon_to_trainer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_pokemon_to_trainer`(IN trainer_ int, in pokemon_ int)
BEGIN
	insert into trainer_pokemon (trainer_id, pokemon_id)
	values(trainer_, pokemon_);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `add_trainer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `add_trainer`(IN name_ varchar(45))
BEGIN
	insert into trainer (trainer_name)
	values(name_);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_pokemon` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_pokemon`(IN pokemon_ int)
BEGIN
	delete from pokemon where idNum = pokemon_;
    delete from pokemon_type where pokemon_id = pokemon_;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_trainer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `delete_trainer`(IN trainer_ int)
BEGIN
	delete from trainer where trainer_id = trainer_;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filter_by_game` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `filter_by_game`(IN game_ int)
BEGIN
	select * from pokemon
	WHERE generation <= (select generation from game where game_id = game_);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filter_by_generation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `filter_by_generation`(IN generation_ int)
BEGIN
	select * from pokemon
	WHERE generation = generation_;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filter_by_trainer` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `filter_by_trainer`(IN trainer_ int)
BEGIN
	select pokemon.*, trainer_id from pokemon join trainer_pokemon on idNum = pokemon_id
	WHERE trainer_id = trainer_;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filter_by_type` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `filter_by_type`(IN type_ varchar(45))
BEGIN
	select * from pokemon join pokemon_type on pokemon_id = idNum
	WHERE type_1 = type_ or type_2 = type_;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_by_id_new` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_by_id_new`(IN p_id int)
BEGIN
	select pokemon.*, type_1, type_2 from pokemon join pokemon_type on idNum = pokemon_id
	WHERE idNum = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_effectiveness` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_effectiveness`(IN attack_ int, IN defense_ int)
BEGIN
SELECT *
FROM effectiveness
WHERE effectiveness.attack_type IN (SELECT type_
										FROM (SELECT * 
												FROM (SELECT pokemon_id, type_1 AS type_
														FROM pokemon_type) AS t1
														UNION ALL
														(SELECT pokemon_id, type_2 AS type_
														FROM pokemon_type)) AS p_t
										WHERE p_t.pokemon_id = attack_)
	AND 
    effectiveness.defense_type IN (SELECT type_
										FROM (SELECT * 
												FROM (SELECT pokemon_id, type_1 AS type_
														FROM pokemon_type) AS t1
														UNION ALL
														(SELECT pokemon_id, type_2 AS type_
														FROM pokemon_type)) AS p_t
										WHERE p_t.pokemon_id = defense_)
ORDER BY effectiveness.effectiveness DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `get_evolution` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_evolution`(IN pokemon_ INT)
BEGIN
DECLARE ev INT;
SELECT evolve_id into ev FROM pokemon WHERE idNum = pokemon_;
IF(ev IS NOT NULL)
THEN
SELECT *
FROM
	(SELECT idNum, name, evolve_id
	FROM pokemon WHERE idNum = pokemon_) AS e;
END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `search_by_name` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `search_by_name`(IN name_ varchar(45))
BEGIN
	select pokemon.*, type_1, type_2 from pokemon join pokemon_type on idNum = pokemon_id
	WHERE name = name_;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_trainers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_trainers`(IN t_id int, IN name_ varchar(45))
BEGIN
UPDATE trainer
	SET trainer_name=name_
	WHERE trainer_id=t_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-12 20:04:44