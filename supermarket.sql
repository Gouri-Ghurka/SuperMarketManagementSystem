-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: supermarket
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `c_name` varchar(30) NOT NULL,
  `c_phone_no` varchar(10) NOT NULL,
  `c_points` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES ('manisha','9121343222',100),('anahita','9121343223',1),('ruchika','9121343224',50),('jagdish','9394093604',2),('vanshika','8796325401',5),('chetan','6014533378',0),('vantika','7032145698',1),('krishna','6841230079',0),('radha','9908444482',1);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dealer`
--

DROP TABLE IF EXISTS `dealer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dealer` (
  `ID` int NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Category` varchar(20) NOT NULL,
  `Product_Name` varchar(20) NOT NULL,
  `Company` varchar(50) NOT NULL,
  `Contact_number` varchar(10) NOT NULL,
  `Email_id` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Quantity_Available` int NOT NULL,
  `Price_per_piece` float NOT NULL,
  `Discount` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dealer`
--

LOCK TABLES `dealer` WRITE;
/*!40000 ALTER TABLE `dealer` DISABLE KEYS */;
INSERT INTO `dealer` VALUES (1,'Ramesh','Brevrages','Pepsi','Pepsi','9876543210','ramesh@gmail.com','Saket,Delhi',45,15,6),(2,'Vikas','Groceries','Bread','Britania','8765432190','vikas23@ymail.com','MG Road,Pune',40,40.5,4),(3,'Suresh','Cosmetics','Shampoo','Sunsilk','6789012345','suresh47@yahoo.com','GanshiNagar,Gujarat',60,40,8),(4,'Amit','Biscuits','Parle-G','Parle-G','9087654321','amit003@gmail.com','Adarsh Nagar,Delhi',100,10,5),(5,'Himanshu','Edible Oil','Olive Oil','Figaro','8905673214','himanshu89@gmail.com','Sikri Road,Delhi',20,80,10),(6,'Gourav','Groceries','Flour','Ashirwad','7865904321','gourav34@yahoo.com','Suchetapuri,Mumbai',55,65,10),(7,'Shyam','Drinks','Bournvita','Catbury','8765009432','shyamlal@ymail.com','Krishna Nagar,Pune',30,35,7),(8,'Pankaj','Dairy','Milk','Jersy','6758493021','pankaj@gmail.com','Karvenagar,Pune',50,40,6),(9,'Piyush','Groceries','Maggi','Nestle','6574839012','piyush56@gmail.com','Malviya Nagar,Delhi',200,8,3),(10,'Prem','Soap','Handwash','Detol','9807563421','premprem@gmail.com','Green Park,Pune',90,20,8),(11,'Vipin','Diary','Cheese','Amul','7860945123','vipins0098@yahoo.com','Botanical Garden,Noida',50,15,6),(12,'Mukesh','Stationary','Pen','Cello','7689504332','mukesh67@ymail.com','Dilshad Garden,Delhi',60,10,5),(13,'Deepak','Brevrages','Orange Juice','Real','9876045213','deepak915@gmail.com','Govindpuram,Indore',9,15,10),(14,'Shubham','Groceries','Flour','Ashirwad','8905764123','shubham100@ymail.com','Indirapuram,Delhi',40,70,6),(15,'Vishesh','Brevrages','Orange Juice','Real','7869012345','visheshG@gmail.com','Rkpuram,Ghaziabad',14,17,9),(16,'Nishant','Groceries','Bread','Britania','8976503410','nishant@ymail.com','Kawade Road,Pune',35,37,8),(17,'Jagdish','Dairy','Milk','Jersy','9087564321','jagdish568@yahoo.com','Gautam Budh Nagar,Delhi',30,35,7),(18,'Yogendra','Stationary','Pen','Cello','6758940032','yogendra45@yahoo.com','Sarojini Nagar,Delhi',50,11,3),(19,'Manoj','Groceries','Bread','Britania','8900665544','manoj4@ymail.com','Hapur Road,Mumbai',12,36,9),(20,'Mohit','Brevrages','Orange Juice','Real','7896054100','mohit67@gmail.com','Dwarka,Delhi',12,16,10),(21,'Rahul','Stationary','Pen','Cello','7809563412','rahulrr@ymail.com','Rajiv Chowk,Delhi',55,12,4),(22,'Raman','Brevrages','Orange Juice','Real','8011223367','raman890@yahoo.com','Sanjay Nagar,Gujarat',10,18,5),(23,'Avinash','Groceries','Bread','Britania','8905643674','avi657@gmail.com','Near Friends Society,Pune',30,35,10),(24,'Aryan','Stationary','Pen','Cello','6700347712','aryan546@gmail.com','Sanjeevni Estate,Mumbai',40,10,4),(25,'Ankit','Dairy','Milk','Jersy','8907890345','ankit34@gmail.com','Vaishviya Nagar,Mumbai',55,37,5);
/*!40000 ALTER TABLE `dealer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empdata`
--

DROP TABLE IF EXISTS `empdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empdata` (
  `ID` int NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `CONTACT` varchar(10) NOT NULL,
  `role` varchar(50) NOT NULL,
  `SALARY` decimal(10,0) NOT NULL,
  `ADDRESS` varchar(50) NOT NULL,
  `EMAILID` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empdata`
--

LOCK TABLES `empdata` WRITE;
/*!40000 ALTER TABLE `empdata` DISABLE KEYS */;
INSERT INTO `empdata` VALUES (1,'Himanshi Methwani','9874563210','Cashier',15000,'Begumpet,Hyderabad','himanshi@gmail.com'),(2,'Muskan Singhal','8475963210','Store Manager',25000,'Somajiguda,Hyderabad','muskan@gmail.com'),(3,'Gouri Ghurka','8796350142','Inventory Control Specialist',20000,'Begumpet,Hyderabad','gouri@gmail.com'),(4,'Ruchita Herlekar','6805124976','Cashier',15000,'Himayat Nagar,Hyderabad','ruchita@gmail.com'),(5,'Rakesh Sharma','8793652014','Sales Associate',10000,'M.G.Road,Hyderabad','rakesh@gmail.com'),(6,'Varun Reddy','8796301254','Sales Associate',10000,'Begumpet,Hyderabad','varun@gmail.com'),(7,'Sai Ramesh','6012223457','Cashier',15000,'Somajiguda,Hyderabad','ramesh@gmail.com'),(8,'Rashmi Jadav','7000123649','Sales Associate',10000,'Ameerpet,Hyderabad','rashmi@gmail.com'),(9,'Shri Harsha','8765410032','Inventory Control Specialist',20000,'Police Line,Hyderabad','harsha@gmail.com'),(10,'Lakshmi Patel','8002233664','Sales Associate',10000,'Ameerpet,Hyderabad','lakshmi@gmail.com');
/*!40000 ALTER TABLE `empdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `productID` int NOT NULL AUTO_INCREMENT,
  `productName` varchar(30) NOT NULL,
  `productBrand` varchar(30) NOT NULL,
  `productCategory` varchar(30) NOT NULL,
  `productCostPrice` double(7,2) NOT NULL,
  `productMrp` double(7,2) NOT NULL,
  `productQuantity` int NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'shampoo','sunsilk','cosmetics',40.00,50.00,31),(2,'bread','britania','groceries',35.00,40.00,9),(3,'parle-g','parle-g','biscuits',10.00,15.00,52),(4,'olive oil','figaro','edible oil',80.00,100.00,47),(5,'flour','ashirwad','groceries',65.00,72.00,28),(6,'bournvita','catbury','drinks',35.00,40.00,20),(7,'milk','jersy','dairy',35.00,40.00,15),(8,'maggi','nestle','groceries',8.00,10.00,100),(9,'pepsi','pepsi','brevrages',15.00,20.00,40),(10,'handwash','detol','soap',20.00,25.00,90),(11,'cheese','amul','diary',15.00,20.00,45),(13,'pen','cello','stationary',10.00,20.00,4),(14,'Orange juice','real','brevrages',15.00,20.00,12);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-31 19:18:54
