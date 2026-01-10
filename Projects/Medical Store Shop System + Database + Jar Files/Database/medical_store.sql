-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: medical_store
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Navana','942903','Navana@gmail.com','India'),(2,'Squre','823234777','Squre@gmail.com','Tangail');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicines`
--

DROP TABLE IF EXISTS `medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `medicine_name` varchar(50) NOT NULL,
  `medicine_type` varchar(100) NOT NULL,
  `company_name` varchar(100) NOT NULL,
  `price_per_unit` int NOT NULL,
  `stock` int NOT NULL,
  `current_stock` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicines`
--

LOCK TABLES `medicines` WRITE;
/*!40000 ALTER TABLE `medicines` DISABLE KEYS */;
INSERT INTO `medicines` VALUES (1,'Napa','Tablet','Beximco Pharmaceuticals Ltd.',8,100,90),(2,'Cab-5','Relax','Opsonine',5,200,100),(3,'Napa Extra','PainKiller','Squre',50,150,149),(37,'Dexpoten','Syrup','Eskayef Bangladesh Ltd.',55,260,10),(38,'Napa','Tablet','Beximco Pharmaceuticals Ltd.',50,110,99),(39,'Seclo','Capsule','Omeprazole',5,75,59),(40,'Arotril','Tablet','Aristopharma Limited',50,16,16);
/*!40000 ALTER TABLE `medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sellsrecord`
--

DROP TABLE IF EXISTS `sellsrecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sellsrecord` (
  `no` int NOT NULL AUTO_INCREMENT,
  `mediId` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `quantity` int NOT NULL,
  `price` int NOT NULL,
  `totalBill` int NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=142 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellsrecord`
--

LOCK TABLES `sellsrecord` WRITE;
/*!40000 ALTER TABLE `sellsrecord` DISABLE KEYS */;
INSERT INTO `sellsrecord` VALUES (48,38,'Napa',5,5,25),(49,39,'Seclo',5,10,50),(50,40,'Arotril',5,5,25),(51,39,'Seclo',5,10,50),(52,39,'Seclo',5,5,25),(53,38,'Napa',50,10,500),(54,40,'Arotril',50,5,250),(55,39,'Seclo',5,10,50),(56,38,'Napa',50,1,50),(57,39,'Seclo',5,13,65),(58,38,'Napa',50,5,250),(59,39,'Seclo',5,10,50),(60,37,'Dexpoten',55,5,275),(61,39,'Seclo',5,10,50),(62,2,'Cab-5',5,5,25),(63,37,'Dexpoten',55,10,550),(64,39,'Seclo',5,10,50),(65,2,'Cab-5',5,10,50),(66,39,'Seclo',5,10,50),(67,3,'Napa Extra',50,10,500),(68,3,'Napa Extra',50,10,500),(69,3,'Napa Extra',50,10,500),(70,3,'Napa Extra',50,50,2500),(71,3,'Napa Extra',50,25,1250),(72,3,'Napa Extra',50,30,1500),(73,39,'Seclo',5,1,5),(74,3,'Napa Extra',50,4,200),(75,3,'Napa Extra',50,4,200),(76,3,'Napa Extra',50,3,150),(77,3,'Napa Extra',50,3,150),(78,3,'Napa Extra',50,3,150),(79,3,'Napa Extra',50,2,100),(80,3,'Napa Extra',50,8,400),(81,3,'Napa Extra',50,8,400),(82,3,'Napa Extra',50,8,400),(83,3,'Napa Extra',50,8,400),(84,3,'Napa Extra',50,7,350),(85,3,'Napa Extra',50,6,300),(86,3,'Napa Extra',50,5,250),(87,37,'Dexpoten',55,10,550),(88,39,'Seclo',5,10,50),(89,38,'Napa',50,17,850),(90,38,'Napa',50,15,750),(91,38,'Napa',50,44,2200),(92,2,'Cab-5',5,10,50),(93,40,'Arotril',50,5,250),(94,40,'Arotril',50,4,200),(95,39,'Seclo',5,10,50),(96,39,'Seclo',5,10,50),(97,39,'Seclo',5,10,50),(98,39,'Seclo',68,10,680),(99,3,'Napa Extra',50,5,250),(100,37,'Dexpoten',55,10,550),(101,37,'Dexpoten',55,9,495),(102,37,'Dexpoten',8,55,440),(103,38,'Napa',30,50,1500),(104,37,'Dexpoten',75,55,4125),(105,37,'Dexpoten',74,55,4070),(106,3,'Napa Extra',4,50,200),(107,3,'Napa Extra',4,50,200),(108,3,'Napa Extra',46,50,2300),(109,3,'Napa Extra',10,50,500),(110,3,'Napa Extra',2,50,100),(111,2,'Cab-5',2,5,10),(112,3,'Napa Extra',2,50,100),(113,3,'Napa Extra',2,50,100),(114,3,'Napa Extra',2,50,100),(115,2,'Cab-5',5,5,25),(116,41,'nirjor',10,50000,500000),(117,41,'nirjor',10,50000,500000),(118,41,'nirjor',11,50000,550000),(119,40,'Arotril',41,50,2050),(120,38,'Napa',10,50,500),(121,37,'Dexpoten',10,55,550),(122,39,'Seclo',104,5,520),(123,40,'Arotril',89,50,4450),(124,38,'Napa',10,50,500),(125,39,'Seclo',10,5,50),(126,38,'Napa',1,50,50),(127,40,'Arotril',10,50,500),(128,40,'Arotril',10,50,500),(129,40,'Arotril',15,50,750),(130,1,'Napa',10,8,80),(131,41,'skba',10,5,50),(132,41,'skba',3,5,15),(133,41,'skba',9,5,45),(134,41,'skba',8,5,40),(135,41,'skba',5,5,25),(136,39,'Seclo',6,5,30),(137,2,'Cab-5',200,10,2000),(138,42,'asd',100,11,1100),(139,42,'asd',8,12,96),(140,42,'asd',2,12,24),(141,3,'Napa Extra',1,50,50);
/*!40000 ALTER TABLE `sellsrecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(16) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `user_type` int NOT NULL DEFAULT '0',
  `address` text NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `gender` text NOT NULL,
  `dob` varchar(20) NOT NULL,
  `mail` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'admin','admin','saad','sabit',1,'home','123456','male','1-1-1990','admin@gmail.com'),(5,'asus','asus','asus','asus',0,'asus,asus','1234567890','male','Jul 1, 2016','asus@gmail.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-27 17:23:40
