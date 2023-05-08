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
-- Table structure for table `tbllichhoc`
--

DROP TABLE IF EXISTS `tbllichhoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbllichhoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `tblLopHocPhanId` int(11) NOT NULL,
  `tblTuanId` int(11) NOT NULL,
  `tblNgayId` int(11) NOT NULL,
  `tblKipId` int(11) NOT NULL,
  `tblPhongHocId` int(11) NOT NULL,
  `tblGiangVienId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lichhoc_giangvien` (`tblGiangVienId`),
  KEY `fk_lichhoc_phonghoc` (`tblPhongHocId`),
  KEY `fk_lichhoc_kip` (`tblKipId`),
  KEY `fk_lichhoc_ngay` (`tblNgayId`),
  KEY `fk_lichhoc_tuan` (`tblTuanId`),
  KEY `fk_lichhoc_lophocphan` (`tblLopHocPhanId`),
  CONSTRAINT `fk_lichhoc_giangvien` FOREIGN KEY (`tblGiangVienId`) REFERENCES `tblgiangvien` (`tblthanhvienid`),
  CONSTRAINT `fk_lichhoc_kip` FOREIGN KEY (`tblKipId`) REFERENCES `tblkip` (`id`),
  CONSTRAINT `fk_lichhoc_lophocphan` FOREIGN KEY (`tblLopHocPhanId`) REFERENCES `tbllophocphan` (`id`),
  CONSTRAINT `fk_lichhoc_ngay` FOREIGN KEY (`tblNgayId`) REFERENCES `tblngay` (`id`),
  CONSTRAINT `fk_lichhoc_phonghoc` FOREIGN KEY (`tblPhongHocId`) REFERENCES `tblphonghoc` (`id`),
  CONSTRAINT `fk_lichhoc_tuan` FOREIGN KEY (`tblTuanId`) REFERENCES `tbltuan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbllichhoc`
--

LOCK TABLES `tbllichhoc` WRITE;
/*!40000 ALTER TABLE `tbllichhoc` DISABLE KEYS */;
INSERT INTO `tbllichhoc` VALUES (1,NULL,NULL,1,1,3,5,1,2),(2,NULL,NULL,1,2,3,5,1,2),(3,NULL,NULL,1,3,3,5,1,2),(4,NULL,NULL,1,4,3,5,1,2),(5,NULL,NULL,1,5,3,5,1,2),(6,NULL,NULL,2,1,3,1,2,2),(7,NULL,NULL,2,2,3,1,2,2),(8,NULL,NULL,2,3,3,1,2,2),(9,NULL,NULL,2,4,3,1,2,2),(10,NULL,NULL,2,5,3,1,2,2);
/*!40000 ALTER TABLE `tbllichhoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-26 15:50:12
