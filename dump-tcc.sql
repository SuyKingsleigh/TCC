-- MySQL dump 10.13  Distrib 8.0.33, for macos13.3 (arm64)
--
-- Host: localhost    Database: tcc
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `Mention`
--

DROP TABLE IF EXISTS `Mention`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Mention` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mention_id` varchar(100) NOT NULL,
  `since_id` varchar(100) DEFAULT NULL,
  `checked_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Mention_id_uindex` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Mention`
--

LOCK TABLES `Mention` WRITE;
/*!40000 ALTER TABLE `Mention` DISABLE KEYS */;
/*!40000 ALTER TABLE `Mention` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Response`
--

DROP TABLE IF EXISTS `Response`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Response` (
  `response_id` int NOT NULL AUTO_INCREMENT,
  `text` text,
  PRIMARY KEY (`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Response`
--

LOCK TABLES `Response` WRITE;
/*!40000 ALTER TABLE `Response` DISABLE KEYS */;
/*!40000 ALTER TABLE `Response` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tweet`
--

DROP TABLE IF EXISTS `Tweet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tweet` (
  `tweet_id` varchar(100) NOT NULL,
  `text` text NOT NULL,
  `link` text,
  PRIMARY KEY (`tweet_id`),
  UNIQUE KEY `Tweet_tweet_id_uindex` (`tweet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tweet`
--

LOCK TABLES `Tweet` WRITE;
/*!40000 ALTER TABLE `Tweet` DISABLE KEYS */;
/*!40000 ALTER TABLE `Tweet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TweetResponse`
--

DROP TABLE IF EXISTS `TweetResponse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TweetResponse` (
  `tweet_response_id` int NOT NULL AUTO_INCREMENT,
  `tweet_id` varchar(100) NOT NULL,
  `response_id` int DEFAULT NULL,
  PRIMARY KEY (`tweet_response_id`),
  KEY `tweet_id` (`tweet_id`),
  KEY `response_id` (`response_id`),
  CONSTRAINT `tweetresponse_ibfk_1` FOREIGN KEY (`tweet_id`) REFERENCES `Tweet` (`tweet_id`),
  CONSTRAINT `tweetresponse_ibfk_2` FOREIGN KEY (`response_id`) REFERENCES `Response` (`response_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TweetResponse`
--

LOCK TABLES `TweetResponse` WRITE;
/*!40000 ALTER TABLE `TweetResponse` DISABLE KEYS */;
/*!40000 ALTER TABLE `TweetResponse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-23 12:49:58
