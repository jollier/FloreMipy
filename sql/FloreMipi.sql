-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           10.1.9-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win32
-- HeidiSQL Version:             9.3.0.5055
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour floremipi
CREATE DATABASE IF NOT EXISTS `floremipi` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `floremipi`;

-- Export de la structure de la table floremipi. adress
CREATE TABLE IF NOT EXISTS `adress` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Location` varchar(200) DEFAULT NULL,
  `ZipCode` varchar(200) DEFAULT NULL,
  `City` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.adress : ~8 rows (environ)
DELETE FROM `adress`;
/*!40000 ALTER TABLE `adress` DISABLE KEYS */;
INSERT INTO `adress` (`Id`, `Location`, `ZipCode`, `City`) VALUES
	(1, '2,Place de la canebière', '13000', 'Marseille'),
	(2, '4,Rue de la broussaille', '69000', 'Lyon'),
	(3, '8,Chemin de Rasteau', '75456', 'Paris'),
	(4, '10,Place de la Gondolle', '31000', 'Toulouse'),
	(5, '84,Impasse de la cheminee', '34000', 'Montpellier'),
	(6, '123,Allee du general Leclerc', '31400', 'Toulouse'),
	(7, '35,Rue des 36 ponts', '31400', 'Toulouse'),
	(8, '1,Rue louis Merlino', '13014', 'Marseille');
/*!40000 ALTER TABLE `adress` ENABLE KEYS */;

-- Export de la structure de la table floremipi. article
CREATE TABLE IF NOT EXISTS `article` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Category` varchar(200) DEFAULT NULL,
  `Imgsrc` varchar(300) DEFAULT NULL,
  `QuantityInStock` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.article : ~13 rows (environ)
DELETE FROM `article`;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`Id`, `Name`, `Description`, `Category`, `Imgsrc`, `QuantityInStock`) VALUES
	(1, 'Câdre en boule', 'Super cadre de Noël avec des boules (de Noël)', 'Arbres', 'img/cadre_en_boule.jpg', 10),
	(2, 'Sapin', 'Ca sent le ...', 'Arbres', 'img/Sapin.JPG', 10),
	(3, 'Epinette bleue', 'Epi net', 'Arbres', 'img/Epinette_bleue.jpg', 10),
	(4, 'Chêne', 'SM bienvenu', 'Arbres', 'img/Chene.jpg', 10),
	(5, 'Erable argenté', 'Tabernacle', 'Arbres', 'img/Erable_argente.jpg', 10),
	(6, 'Herbe à puce', 'Gratt Gratt', 'Herbacées', 'img/Herbe_a_puce.jpg', 10),
	(7, 'Poirier', 'Jean-Marie (RIP)', 'Fruits', 'img/Poirier.jpg', 10),
	(8, 'Catalpa', '????', 'Arbres', 'img/Catalpa.jpg', 10),
	(9, 'Pommier', 'Jean-Marie (private joke)', 'Fruits', 'img/Pommier.jpg', 10),
	(10, 'Génévrier', 'hips', 'Arbustes', 'img/Genevrier.jpg', 10),
	(11, 'Abricotier rustique', 'J\'adore sucer un abricot pendant des heures', 'Fruits', 'img/Abricotier.jpg', 10),
	(82, 'Cactus', 'Aie ça pique', 'Cactus', 'img/Dancing_cactus.gif', 12),
	(83, 'Try and Pray', 'Même pas cap !', 'Arbres', 'img/Try_and_Pray.jpg', 1);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- Export de la structure de la table floremipi. articleinprogress
CREATE TABLE IF NOT EXISTS `articleinprogress` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Quantity` int(11) NOT NULL DEFAULT '0',
  `StartDate` date NOT NULL,
  `ReleaseDate` date NOT NULL,
  `IdArticle` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdArticle` (`IdArticle`),
  CONSTRAINT `articleinprogress_ibfk_1` FOREIGN KEY (`IdArticle`) REFERENCES `article` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.articleinprogress : ~1 rows (environ)
DELETE FROM `articleinprogress`;
/*!40000 ALTER TABLE `articleinprogress` DISABLE KEYS */;
INSERT INTO `articleinprogress` (`Id`, `Quantity`, `StartDate`, `ReleaseDate`, `IdArticle`) VALUES
	(1, 5, '2016-03-10', '2016-03-10', 1);
/*!40000 ALTER TABLE `articleinprogress` ENABLE KEYS */;

-- Export de la structure de la table floremipi. customer
CREATE TABLE IF NOT EXISTS `customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) NOT NULL,
  `FirstName` varchar(200) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `IdAdress` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdAdress` (`IdAdress`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`IdAdress`) REFERENCES `adress` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.customer : ~8 rows (environ)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`Id`, `Name`, `FirstName`, `Phone`, `Email`, `IdAdress`) VALUES
	(1, 'Sansom', 'Luc', '(999)999-9999', 'Sansom.Luc@mail.com', 1),
	(2, 'Tremblay', 'Dollard', '(888)888-8888', 'Tremblay.Dollard@mail.com', 2),
	(3, 'Bô', 'Lin', '(777)777-7777', 'Bo.Lin@mail.com', 3),
	(4, 'Leconte', 'Jean', '(666)666-6666', 'Leconte.Jean@mail.com', 4),
	(5, 'Alaoui', 'Hafed', '(555)555-5555', 'Alaoui.hafed@mail.com', 5),
	(6, 'Leconte', 'Marie', '(666)666-6666', 'Leconte.marie@mail.com', 6),
	(7, 'Lecoq', 'Simon', '(444)444-4419', 'Lecoq.simon@mail.com', 7),
	(8, 'Tremblay', 'Dollard', '(333)333-3333', 'Tremblay.Dollard@mail.com', 8);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Export de la structure de la table floremipi. customerorder
CREATE TABLE IF NOT EXISTS `customerorder` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `CustomerOrderDate` date NOT NULL,
  `IdCustomer` int(11) NOT NULL,
  `IdAdress` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdCustomer` (`IdCustomer`),
  KEY `IdAdress` (`IdAdress`),
  CONSTRAINT `customerorder_ibfk_1` FOREIGN KEY (`IdCustomer`) REFERENCES `customer` (`Id`),
  CONSTRAINT `customerorder_ibfk_2` FOREIGN KEY (`IdAdress`) REFERENCES `adress` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.customerorder : ~8 rows (environ)
DELETE FROM `customerorder`;
/*!40000 ALTER TABLE `customerorder` DISABLE KEYS */;
INSERT INTO `customerorder` (`Id`, `CustomerOrderDate`, `IdCustomer`, `IdAdress`) VALUES
	(1, '2013-11-01', 1, 4),
	(2, '2013-11-02', 2, 3),
	(3, '2013-11-02', 1, 2),
	(4, '2013-11-05', 1, 1),
	(5, '2013-11-09', 3, 1),
	(6, '2013-11-09', 2, 6),
	(7, '2013-11-15', 4, 4),
	(8, '2013-11-15', 4, 2);
/*!40000 ALTER TABLE `customerorder` ENABLE KEYS */;

-- Export de la structure de la table floremipi. customerorderline
CREATE TABLE IF NOT EXISTS `customerorderline` (
  `IdCustomerOrder` int(11) NOT NULL,
  `IdArticle` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `DelivredQuantity` int(11) NOT NULL,
  PRIMARY KEY (`IdCustomerOrder`,`IdArticle`),
  KEY `IdArticle` (`IdArticle`),
  CONSTRAINT `customerorderline_ibfk_1` FOREIGN KEY (`IdCustomerOrder`) REFERENCES `customerorder` (`Id`),
  CONSTRAINT `customerorderline_ibfk_2` FOREIGN KEY (`IdArticle`) REFERENCES `article` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.customerorderline : ~15 rows (environ)
DELETE FROM `customerorderline`;
/*!40000 ALTER TABLE `customerorderline` DISABLE KEYS */;
INSERT INTO `customerorderline` (`IdCustomerOrder`, `IdArticle`, `Quantity`, `DelivredQuantity`) VALUES
	(1, 1, 10, 10),
	(1, 7, 5, 5),
	(1, 9, 1, 1),
	(2, 4, 2, 2),
	(2, 9, 3, 3),
	(3, 2, 1, 1),
	(4, 4, 1, 1),
	(4, 5, 1, 1),
	(5, 1, 5, 5),
	(5, 2, 5, 5),
	(5, 7, 3, 3),
	(6, 1, 5, 5),
	(6, 4, 1, 1),
	(7, 5, 1, 1),
	(8, 2, 3, 3);
/*!40000 ALTER TABLE `customerorderline` ENABLE KEYS */;

-- Export de la structure de la table floremipi. delivery
CREATE TABLE IF NOT EXISTS `delivery` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `DeliveryDate` date NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.delivery : ~6 rows (environ)
DELETE FROM `delivery`;
/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
INSERT INTO `delivery` (`Id`, `DeliveryDate`) VALUES
	(1, '2013-11-03'),
	(2, '2013-11-04'),
	(3, '2013-11-04'),
	(4, '2013-11-05'),
	(5, '2013-11-07'),
	(6, '2013-11-08');
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;

-- Export de la structure de la table floremipi. deliverydetail
CREATE TABLE IF NOT EXISTS `deliverydetail` (
  `IdDelivery` int(11) NOT NULL,
  `IdCustomerOrder` int(11) NOT NULL,
  `IdArticle` int(11) NOT NULL,
  `QuantityDelivred` int(11) NOT NULL,
  PRIMARY KEY (`IdDelivery`,`IdCustomerOrder`,`IdArticle`),
  KEY `IdCustomerOrder` (`IdCustomerOrder`,`IdArticle`),
  CONSTRAINT `deliverydetail_ibfk_1` FOREIGN KEY (`IdDelivery`) REFERENCES `delivery` (`Id`),
  CONSTRAINT `deliverydetail_ibfk_2` FOREIGN KEY (`IdCustomerOrder`, `IdArticle`) REFERENCES `customerorderline` (`IdCustomerOrder`, `IdArticle`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.deliverydetail : ~9 rows (environ)
DELETE FROM `deliverydetail`;
/*!40000 ALTER TABLE `deliverydetail` DISABLE KEYS */;
INSERT INTO `deliverydetail` (`IdDelivery`, `IdCustomerOrder`, `IdArticle`, `QuantityDelivred`) VALUES
	(1, 1, 1, 7),
	(1, 1, 7, 5),
	(1, 3, 2, 1),
	(2, 1, 1, 3),
	(3, 2, 4, 2),
	(3, 2, 9, 1),
	(4, 1, 9, 1),
	(5, 4, 4, 1),
	(6, 5, 7, 2);
/*!40000 ALTER TABLE `deliverydetail` ENABLE KEYS */;

-- Export de la structure de la table floremipi. indicator
CREATE TABLE IF NOT EXISTS `indicator` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) DEFAULT NULL,
  `sqlText` varchar(400) DEFAULT NULL,
  `periodicity` varchar(200) DEFAULT NULL,
  `targets` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.indicator : ~0 rows (environ)
DELETE FROM `indicator`;
/*!40000 ALTER TABLE `indicator` DISABLE KEYS */;
/*!40000 ALTER TABLE `indicator` ENABLE KEYS */;

-- Export de la structure de la table floremipi. news
CREATE TABLE IF NOT EXISTS `news` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(20) DEFAULT NULL,
  `Contenu` varchar(200) DEFAULT NULL,
  `Modifiable` tinyint(1) DEFAULT NULL,
  `Auteur` int(11) NOT NULL,
  `DernierAuteur` int(11) NOT NULL,
  `DateCreation` date DEFAULT NULL,
  `DateModification` date DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `Auteur` (`Auteur`),
  KEY `DernierAuteur` (`DernierAuteur`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`Auteur`) REFERENCES `customer` (`Id`),
  CONSTRAINT `news_ibfk_2` FOREIGN KEY (`DernierAuteur`) REFERENCES `customer` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.news : ~0 rows (environ)
DELETE FROM `news`;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- Export de la structure de la table floremipi. price
CREATE TABLE IF NOT EXISTS `price` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdArticle` int(11) NOT NULL,
  `Value` decimal(10,2) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdArticle` (`IdArticle`),
  CONSTRAINT `price_ibfk_1` FOREIGN KEY (`IdArticle`) REFERENCES `article` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.price : ~11 rows (environ)
DELETE FROM `price`;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` (`Id`, `IdArticle`, `Value`, `Date`) VALUES
	(1, 1, 10.99, '2013-11-01'),
	(2, 2, 12.99, '2013-11-01'),
	(3, 3, 25.99, '2013-11-01'),
	(4, 4, 22.99, '2013-11-01'),
	(5, 5, 15.99, '2013-11-01'),
	(6, 6, 10.99, '2013-11-01'),
	(7, 7, 26.99, '2013-11-01'),
	(8, 8, 25.99, '2013-11-01'),
	(9, 9, 25.99, '2013-11-01'),
	(10, 10, 15.99, '2013-11-01'),
	(11, 11, 21.90, '2013-11-01');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;

-- Export de la structure de la table floremipi. result
CREATE TABLE IF NOT EXISTS `result` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Date` date DEFAULT NULL,
  `Value` double DEFAULT NULL,
  `IdIndicator` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdIndicator` (`IdIndicator`),
  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`IdIndicator`) REFERENCES `indicator` (`Id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.result : ~0 rows (environ)
DELETE FROM `result`;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;

-- Export de la structure de la table floremipi. version
CREATE TABLE IF NOT EXISTS `version` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.version : ~1 rows (environ)
DELETE FROM `version`;
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
INSERT INTO `version` (`id`, `version`) VALUES
	(1, 7);
/*!40000 ALTER TABLE `version` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
