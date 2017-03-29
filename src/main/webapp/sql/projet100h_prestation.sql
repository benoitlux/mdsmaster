-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: projet100h
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `prestation`
--

DROP TABLE IF EXISTS `prestation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestation` (
  `idprestation` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `prix` varchar(45) NOT NULL,
  `idsouscat` int(11) NOT NULL,
  PRIMARY KEY (`idprestation`),
  KEY `idsouscategorie_idx` (`idsouscat`),
  CONSTRAINT `idsouscat` FOREIGN KEY (`idsouscat`) REFERENCES `souscategorie` (`idsouscategorie`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestation`
--

LOCK TABLES `prestation` WRITE;
/*!40000 ALTER TABLE `prestation` DISABLE KEYS */;
INSERT INTO `prestation` VALUES (3,'Test','','55',1),(4,'Escale BeautÃ©','','38â¬',2),(5,'Vital DÃ©fense','Soin nettoyant anti-oxydant','66â¬',3),(6,'Stimulastine','Soin anti-ride lissant','66€',3),(7,'Optimizer','Soin tenseur raffermissant','66€',3),(8,'Excellence Code','Soin global jeunesse','72€',3),(9,'Modelage Japonais du Visage',NULL,'60€',3),(10,'Modelage Japonais du Visage + Soin',NULL,'75€',3),(11,'Eclat Cocoon','Soin ultra-hydratant et relaxant aux pierres chaudes','61€',4),(12,'Plaisir d\'Arômes','Soin aromatique éclat et bien-être','61€',4),(13,'Soin Pureté','Soin pour les peaux acnéiques','61€',5),(14,'Soin Rougeurs','Soin calmant','61€',5),(15,'Alpha Vital','Soin exfoliant rénovateur aux AHA','66€',5),(16,'Soin Peaux Fragilisées','Soin réparateur des peaux en souffrance','45€',5),(17,'Secret Douceur','Soin d\'hydratation de la tête aux pieds','120€',6),(18,'Evasion Aromatique','Soin de détente visage et corps','105€',6),(19,'Gommage marin','Gommage corps tonifiant','45€',7),(23,'Soin Velours','Soin corps gommant, hydratant et relaxant','72€',8),(24,'Modelage femme enceinte',NULL,'60€',9),(25,'Modelage Californien',NULL,'60€',9),(26,'Relax Velours',NULL,'46€',9),(27,'Modelage à la bougie',NULL,'60€',9),(28,'Modelage Sanbao','Soin visant essentiellement à la relaxation et à la tonification des muscles','65€',9),(29,'Modelage Singapourien','Soin énergétique pour éliminer les problèmes liés au stress et à la fatigue','68€',9),(30,'Modelage Hawaïen','','65€',9),(31,'Soin du dos','Soin nettoyant et relaxant','53€',9),(32,'10 Séances',NULL,'65€',10),(33,'Lunettes',NULL,'3€',10),(34,'Sourcils',NULL,'9€',11),(35,'Lèvres ou Menton',NULL,'7€',11),(36,'Aisselles',NULL,'11€',11),(37,'Maillot Classique',NULL,'11€',11),(38,'Maillot Echancré',NULL,'16€',11),(39,'Maillot Intégral',NULL,'24€',11),(40,'Demi-Jambes ou Cuisses',NULL,'17€',11),(41,'Jambes Complètes',NULL,'24€',11),(42,'3/4 Jambes',NULL,'20€',11),(43,'Avant Bras',NULL,'13€',11),(44,'Dos ou Torse',NULL,'25€',11),(45,'Sourcils, Lèvres + Menton',NULL,'20€',12),(46,'Visage',NULL,'22€',12),(47,'Demi-Jambes + Aisselles',NULL,'22€',12),(48,'Demi-Jambes + Maillot Classique',NULL,'26€',12),(49,'Demi-Jambes + Maillot Classique + Aisselles',NULL,'36€',12),(50,'Jambes Complètes + Aisselles',NULL,'32€',12),(51,'Jambes Complètes + Maillot Classique',NULL,'32€',12),(52,'Jambes Complètes+ Maillot Classique + Aisselles',NULL,'34€',12),(53,'Teinture Cils',NULL,'15€',13),(54,'Rehaussement de Cils',NULL,'50€',13),(55,'Rehaussement de Cils + Teinture',NULL,'60€',13),(56,'Maquillage',NULL,'25€',13),(60,'Le grand classique','Soin de nettoyage profond, traitant et r','66â¬',1),(61,'Soin teenager','Soin de nettoyage profond et equilibrant','48â¬',1);
/*!40000 ALTER TABLE `prestation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-28 12:23:41
