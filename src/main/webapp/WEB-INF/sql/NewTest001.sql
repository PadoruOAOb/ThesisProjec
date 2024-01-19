CREATE DATABASE  IF NOT EXISTS `learning` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `learning`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: learning
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cartId` int NOT NULL AUTO_INCREMENT,
  `userId` int NOT NULL,
  `amount` int NOT NULL DEFAULT '0',
  `isCheckOut` int NOT NULL DEFAULT '0' COMMENT '0:未購買 1:已購買',
  `checkOutTime` datetime DEFAULT NULL,
  PRIMARY KEY (`cartId`),
  KEY `userId` (`userId`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1,1500,1,'2024-01-18 17:03:32');
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitem`
--

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartitem` (
  `cartItemId` int NOT NULL AUTO_INCREMENT,
  `cartId` int NOT NULL,
  `courseId` int NOT NULL,
  `price` int NOT NULL DEFAULT '0',
  `qty` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`cartItemId`),
  KEY `cartItem_cartId_idx` (`cartId`),
  KEY `cartItem_courseId_idx` (`courseId`),
  CONSTRAINT `cartItem_cartId` FOREIGN KEY (`cartId`) REFERENCES `cart` (`cartId`),
  CONSTRAINT `cartItem_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
INSERT INTO `cartitem` VALUES (1,1,1,1000,1),(2,1,2,500,1);
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `courseId` int NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) NOT NULL,
  `courseDescription` varchar(1000) NOT NULL,
  `courseDetail` varchar(4000) NOT NULL,
  `courseImg` varchar(1000) NOT NULL,
  `teacher` int NOT NULL,
  `price` int NOT NULL DEFAULT '0',
  `typeId` int NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`courseId`),
  KEY `course_teacher_idx` (`teacher`),
  KEY `course_typeId_idx` (`typeId`),
  CONSTRAINT `course_teacher` FOREIGN KEY (`teacher`) REFERENCES `user` (`userId`),
  CONSTRAINT `course_typeId` FOREIGN KEY (`typeId`) REFERENCES `type` (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'三角函數專屬課程','歡迎加入我們的三角函數專屬課程，這是一個精心設計的課程，旨在深入探討正弦、餘弦和正切等三角函數的神奇世界。無論你是初學者還是已經對數學充滿熱情，這個課程都將為你打開全新的數學視野。\n課程亮點：\n理論和實踐結合： 我們將理論知識與實際應用相結合，通過生動的實例和實際問題，讓你更好地理解三角函數的本質。\n生動教學：由資深數學教師授課，以清晰而生動的方式解釋三角函數的概念，讓學習變得輕鬆有趣。\n實用應用：學會如何應用三角函數解決現實生活中的問題，包括物理、工程和計算機科學等多個領域。','豐富的課程內容：\n深入介紹三角函數的基本概念，如正弦、餘弦、和正切。\n提供實際的例子和應用場景，以幫助學生理解三角函數在現實生活中的應用。\n包括數學模型和圖形演示，以視覺化三角函數的特性。\n強調不同角度的三角函數計算和應用。\n專業的指導:\n由經驗豐富、專業的數學教育者擔任指導，確保學生得到高品質的教育。\n提供實時問答和解說，以解決學生在學習過程中的疑問。\n舉辦定期的指導課程，讓學生有機會深入研究和探討特定主題。\n使用互動式工具和教學方法，使學生更輕鬆地理解三角函數的概念。\n課程證書\n提供完課後，學生將獲得正式的三角函數課程完成證書。\n證書應包含學生的名稱、課程名稱、完成日期等基本資訊，以便他們能在履歷或學習紀錄中展示。\n這個證書是學生參與並成功完成課程的有力證明，增加了他們的數學學習成就感。','/img/math.png',1,1000,1,'2024-01-18 15:09:50'),(2,'N5日文學習課程','N5日文學習課程歡迎您。這是一門精選的課程，旨在從基礎開始學習日文，並致力於掌握N5水平的語言技能。即使是初學者也可以放心參與。\n課程亮點：\n基礎理論深入：通過深入學習日文的核心理論，確保您能夠獲得扎實的語言基礎。\n應用案例：通過實際應用案例，學會在現實生活中應用日文，包括日常交流、商務溝通等方面。\n互動學習：課程中包含豐富的互動元素，如問答環節和小組討論，使學習更加生動有趣。','','/img/JP/JP01.png',1,500,2,'2024-01-18 15:09:50'),(7,'微積分入門課程','加入我們的微積分入門課程，探索數學的無窮魅力。這是一個適合數學愛好者和學術追求者的精選課程，將為你帶來深厚的微積分基礎。\n課程亮點:基礎理論深入： 微積分的核心理論將被深入淺出地介紹，以確保你對這一重要領域有全面的理解。\n應用案例：透過真實應用案例，學會如何在現實生活中應用微積分，包括物理學、工程學和經濟學等領域。\n互動學習：課程中包括豐富的互動元素，例如問答環節和小組討論，讓學習變得更加生動有趣。',' ','/img/math.png',1,850,1,'2024-01-18 15:23:57');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource` (
  `resourceId` int NOT NULL AUTO_INCREMENT,
  `courseId` int NOT NULL,
  `link` varchar(1000) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `type` int NOT NULL COMMENT '1:影片 2:文檔 3: 試看影片',
  PRIMARY KEY (`resourceId`),
  KEY `resource_courseId_idx` (`courseId`),
  CONSTRAINT `resource_courseId` FOREIGN KEY (`courseId`) REFERENCES `course` (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,1,'/mvc/video/v2/1','2024-01-18 15:09:50','2024-01-18 15:09:50',1),(2,2,'/download/material1','2024-01-18 15:09:50','2024-01-18 15:09:50',2);
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `typeId` int NOT NULL AUTO_INCREMENT,
  `typeName` varchar(100) NOT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'數學'),(2,'日文'),(3,'英文');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(1000) NOT NULL,
  `email` varchar(1000) NOT NULL,
  `level` int NOT NULL DEFAULT '1' COMMENT '1:使用者 2:教師 3:管理員',
  `authType` enum('local','github','google') DEFAULT 'local',
  `authId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'OAOb','123','OAOb@example.com',1,'local',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-18 17:14:28
