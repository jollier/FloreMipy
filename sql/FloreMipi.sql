-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           5.6.26 - MySQL Community Server (GPL)
-- SE du serveur:                Win32
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de la base pour floremipi
DROP DATABASE IF EXISTS `floremipi`;
CREATE DATABASE IF NOT EXISTS `floremipi` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `floremipi`;


-- Export de la structure de table floremipi. adress
DROP TABLE IF EXISTS `adress`;
CREATE TABLE IF NOT EXISTS `adress` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Location` varchar(200) DEFAULT NULL,
  `ZipCode` varchar(200) DEFAULT NULL,
  `City` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.adress : ~14 rows (environ)
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


-- Export de la structure de table floremipi. article
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(200) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Category` varchar(200) DEFAULT NULL,
  `Imgsrc` varchar(300) DEFAULT NULL,
  `QuantityInStock` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.article : ~12 rows (environ)
DELETE FROM `article`;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`Id`, `Name`, `Description`, `Category`, `Imgsrc`, `QuantityInStock`) VALUES
    (1, 'Câdre en boule', 'Super cadre de Noël avec des boules de Noël.', 'Arbres', 'cadre_en_boule.jpg', 10),
    (2, 'Sapin', 'À Noël, optez pour le sapin naturel Nobilis d\'une hauteur de 100/150 cm ! Décoré selon vos envies, il trouvera sa place chez vous avec son beau feuillage gris-bleu.', 'Arbres', 'Sapin.jpg', 10),
    (3, 'Epinette bleue', 'Variété de conifère nain, de forme conique compacte, pouvant atteindre 3 m de hauteur. Feuillage bleu lumineux. De faible développement, il convient à un petit jardin ou à une culture en bac.', 'Arbres', 'Epinette_bleue.jpg', 10),
    (4, 'Chêne', 'Arbre à la cime régulière pyramidale, à la végétation dense. Feuillage persistant, vert foncé, lisse dessus, duveteux dessous. Fleurs jaunes en chatons, en mai. Glands de 2 à 3 cm réunis par 2 ou 3.', 'Arbres', 'Chene.jpg', 10),
    (5, 'Erable argenté', 'Incroyable, cet Érable d\'exception, prêt à planter, vous offrira un panache de couleur à l\'automne ! Il sera livré chez vous par camion grue sans frais supplémentaires en région parisienne.', 'Arbres', 'Erable_argente.jpg', 10),
    (6, 'Alisier torminal', 'L\'Alisier torminal est un arbre appartenant au genre des sorbiers, de la famille des Rosacées. Il est relativement rare et vit de manière dispersée dans la forêt.', 'Rosacees', 'Alisier_torminal.jpg', 10),
    (7, 'Poirier', 'Variété ancienne très productive appréciée pour ses gros fruits d\'été. Chair juteuse, bien blanche, fondante et très sucrée.', 'Fruits', 'Poirier.jpg', 10),
    (8, 'Catalpa', 'Arbre à cime globuleuse, applatie. Feuillage caduc, vert clair. Fleurs rose pâle strié de jaune avec la gorge tâcheté de violet foncé. Fruits en longues gousses pendantes, vertes.', 'Arbres', 'Catalpa.jpg', 10),
    (9, 'Pommier', 'Variété colonnaire de pommier, \'Versailles\' offre avec générosité de savoureuses pommes d\'automne, croquantes et juteuses.', 'Fruits', 'Pommier.jpg', 10),
    (10, 'Génévrier', 'Un "genévrier de Hollywood\' qui intrigue et charme par son étrange port. À découvrir !', 'Arbustes', 'Genevrier.jpg', 10),
    (11, 'Abricotier rustique', 'Cet abricotier à une floraison abondante étalée tout au long du printemps, qui permet aux fleurs d´échapper aux gelées. Les fruits sont de très bonne qualité.', 'Fruits', 'Abricotier.jpg', 10),
    (82, 'Cactus', 'Faciles à cultiver et décoratives, ces plantes, appelées cactées, cactus ou plantes grasses, vivent longtemps à la maison. La plupart d\'entre elles vous surprendront par de magnifiques floraisons.', 'Cactus', 'Cactus.jpg', 12);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;


-- Export de la structure de table floremipi. articleinprogress
DROP TABLE IF EXISTS `articleinprogress`;
CREATE TABLE IF NOT EXISTS `articleinprogress` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Quantity` int(11) NOT NULL DEFAULT '0',
  `StartDate` date NOT NULL,
  `ReleaseDate` date NOT NULL,
  `IdArticle` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdArticle` (`IdArticle`),
  CONSTRAINT `articleinprogress_ibfk_1` FOREIGN KEY (`IdArticle`) REFERENCES `article` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.articleinprogress : ~0 rows (environ)
DELETE FROM `articleinprogress`;
/*!40000 ALTER TABLE `articleinprogress` DISABLE KEYS */;
INSERT INTO `articleinprogress` (`Id`, `Quantity`, `StartDate`, `ReleaseDate`, `IdArticle`) VALUES
    (1, 5, '2016-03-10', '2016-03-10', 1);
/*!40000 ALTER TABLE `articleinprogress` ENABLE KEYS */;


-- Export de la structure de table floremipi. customer
DROP TABLE IF EXISTS `customer`;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.customer : ~11 rows (environ)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`Id`, `Name`, `FirstName`, `Phone`, `Email`, `IdAdress`) VALUES
    (1, 'Sansom', 'Cyrille', '(999)999-9999', 'Sansom.Luc@mail.com', 14),
    (2, 'Tremblay', 'Dollard', '(888)888-8888', 'Tremblay.Dollard@mail.com', 2),
    (3, 'Bô', 'Lin', '(777)777-7777', 'Bo.Lin@mail.com', 3),
    (4, 'Leconte', 'Jean', '(666)666-6666', 'Leconte.Jean@mail.com', 4),
    (5, 'Alaoui', 'Hafed', '(555)555-5555', 'Alaoui.hafed@mail.com', 5),
    (6, 'Leconte', 'Marie', '(666)666-6666', 'Leconte.marie@mail.com', 6),
    (7, 'Lecoq', 'Simon', '(444)444-4419', 'Lecoq.simon@mail.com', 7),
    (8, 'Tremblay', 'Dollard', '(333)333-3333', 'Tremblay.Dollard@mail.com', 8);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- Export de la structure de table floremipi. price
DROP TABLE IF EXISTS `price`;
CREATE TABLE IF NOT EXISTS `price` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdArticle` int(11) NOT NULL,
  `Value` decimal(10,2) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdArticle` (`IdArticle`),
  CONSTRAINT `price_ibfk_1` FOREIGN KEY (`IdArticle`) REFERENCES `article` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.price : ~16 rows (environ)
DELETE FROM `price`;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` (`Id`, `IdArticle`, `Value`, `Date`) VALUES
    (2, 2, 12.99, '2013-11-01'),
    (3, 3, 25.99, '2013-11-01'),
    (4, 4, 22.99, '2013-11-01'),
    (5, 5, 15.99, '2013-11-01'),
    (6, 6, 10.99, '2013-11-01'),
    (7, 7, 26.99, '2013-11-01'),
    (8, 8, 25.99, '2013-11-01'),
    (9, 9, 25.99, '2013-11-01'),
    (10, 10, 15.99, '2013-11-01'),
    (11, 11, 21.90, '2013-11-01'),
    (12, 82, 10.99, '2016-03-22'),
    (13, 1, 24.99, '2016-04-11');
/*!40000 ALTER TABLE `price` ENABLE KEYS */;


-- Export de la structure de table floremipi. version
DROP TABLE IF EXISTS `version`;
CREATE TABLE IF NOT EXISTS `version` (
  `id` int(11) NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipi.version : ~0 rows (environ)
DELETE FROM `version`;
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
INSERT INTO `version` (`id`, `version`) VALUES
    (1, 10);
/*!40000 ALTER TABLE `version` ENABLE KEYS */;


-- Export de la structure de déclencheur floremipi. Trg_deleteArticle
DROP TRIGGER IF EXISTS `Trg_deleteArticle`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `Trg_deleteArticle` BEFORE DELETE ON `article` FOR EACH ROW BEGIN

DELETE from articleinprogress where articleinprogress.IdArticle = OLD.Id;
DELETE from price where price.IdArticle = OLD.Id;

END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
