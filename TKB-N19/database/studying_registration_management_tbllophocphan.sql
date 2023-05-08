CREATE DATABASE  IF NOT EXISTS `studying_registration_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `studying_registration_management`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: studying_registration_management
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbllophocphan`
--

DROP TABLE IF EXISTS `tbllophocphan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbllophocphan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) NOT NULL,
  `sisotoida` int(11) NOT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `tblMonHocKiHocId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lophocphan_monhockihoc` (`tblMonHocKiHocId`),
  CONSTRAINT `fk_lophocphan_monhockihoc` FOREIGN KEY (`tblMonHocKiHocId`) REFERENCES `tblmonhockihoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllophocphan`
--

LOCK TABLES `tbllophocphan` WRITE;
/*!40000 ALTER TABLE `tbllophocphan` DISABLE KEYS */;
INSERT INTO `tbllophocphan` VALUES (1,'D18-001',70,NULL,1),(2,'D18-002',70,NULL,1),(3,'D18-003',70,NULL,1),(4,'D18-004',70,NULL,1),(5,'D18-005',70,NULL,2),(6,'D18-006',70,NULL,2),(7,'D18-007',70,NULL,2),(8,'D18-008',70,NULL,2),(9,'D18-009',70,NULL,3),(10,'D18-010',70,NULL,3),(11,'D18-011',70,NULL,3),(12,'D18-012',70,NULL,3),(13,'D18-013',70,NULL,4),(14,'D18-014',70,NULL,4),(15,'D18-015',70,NULL,4),(16,'D18-016',70,NULL,4),(17,'D18-017',70,NULL,5),(18,'D18-018',70,NULL,5),(19,'D18-019',70,NULL,5),(20,'D18-020',70,NULL,5),(21,'D18-021',70,NULL,6),(22,'D18-022',70,NULL,6),(23,'D18-023',70,NULL,6),(24,'D18-024',70,NULL,6);
/*!40000 ALTER TABLE `tbllophocphan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-26 15:50:03
