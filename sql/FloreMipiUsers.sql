<<<<<<< HEAD
-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           10.1.9-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win32
-- HeidiSQL Version:             9.3.0.5052
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour floremipyuser
CREATE DATABASE IF NOT EXISTS `floremipyuser` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `floremipyuser`;

DROP TABLE IF EXISTS `version`;

-- Export de la structure de la table floremipyuser. userdbversion
DROP TABLE IF EXISTS `userdbversion`;
CREATE TABLE IF NOT EXISTS `userdbversion` (
  `id` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipyuser.userdbversion : ~1 rows (environ)
DELETE FROM `userdbversion`;
/*!40000 ALTER TABLE `userdbversion` DISABLE KEYS */;
INSERT INTO `userdbversion` (`id`, `version`) VALUES
	(1, 6);
/*!40000 ALTER TABLE `userdbversion` ENABLE KEYS */;

-- Export de la structure de la table floremipyuser. users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `usertype` varchar(250) NOT NULL,
  `idcustomer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipyuser.users : ~14 rows (environ)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `usertype`, `idcustomer`) VALUES
	(1, 'user1', 'user1', 'user', 1),
	(2, 'admin1', 'admin1', 'admin', NULL),
	(3, 'employee1', 'employee1', 'employee', NULL),
	(27, 'testCreateUser1', 'testCreateUser1', 'user', 1),
	(28, 'testCreateUser2', 'testCreateUser2', 'user', 1),
	(29, 'testCreateUser3', 'testCreateUser3', 'user', 1),
	(30, 'testCreateUser4', 'testCreateUser4', 'user', 1),
	(31, 'testCreateUser5', 'testCreateUser5', 'user', 1),
	(32, 'testCreateUser6', 'testCreateUser6', 'user', 1),
	(33, 'testCreateUser7', 'testCreateUser7', 'user', 1),
	(34, 'testCreateUser8', 'testCreateUser8', 'user', 1),
	(35, 'testCreateUser9', 'testCreateUser9', 'user', 1),
	(36, 'testCreateUser10', 'testCreateUser10', 'user', 1),
	(37, 'testCreateUser11', 'testCreateUser11', 'user', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
=======
-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           10.1.9-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win32
-- HeidiSQL Version:             9.3.0.5052
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour floremipyuser
CREATE DATABASE IF NOT EXISTS `floremipyuser` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `floremipyuser`;

DROP TABLE IF EXISTS `version`;

-- Export de la structure de la table floremipyuser. userdbversion
DROP TABLE IF EXISTS `userdbversion`;
CREATE TABLE IF NOT EXISTS `userdbversion` (
  `id` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipyuser.userdbversion : ~1 rows (environ)
DELETE FROM `userdbversion`;
/*!40000 ALTER TABLE `userdbversion` DISABLE KEYS */;
INSERT INTO `userdbversion` (`id`, `version`) VALUES
	(1, 6);
/*!40000 ALTER TABLE `userdbversion` ENABLE KEYS */;

-- Export de la structure de la table floremipyuser. users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `usertype` varchar(250) NOT NULL,
  `idcustomer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipyuser.users : ~14 rows (environ)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `usertype`, `idcustomer`) VALUES
	(1, 'user1', 'user1', 'user', 1),
	(2, 'admin1', 'admin1', 'admin', NULL),
	(3, 'employee1', 'employee1', 'employee', NULL),
	(27, 'testCreateUser1', 'testCreateUser1', 'user', 1),
	(28, 'testCreateUser2', 'testCreateUser2', 'user', 1),
	(29, 'testCreateUser3', 'testCreateUser3', 'user', 1),
	(30, 'testCreateUser4', 'testCreateUser4', 'user', 1),
	(31, 'testCreateUser5', 'testCreateUser5', 'user', 1),
	(32, 'testCreateUser6', 'testCreateUser6', 'user', 1),
	(33, 'testCreateUser7', 'testCreateUser7', 'user', 1),
	(34, 'testCreateUser8', 'testCreateUser8', 'user', 1),
	(35, 'testCreateUser9', 'testCreateUser9', 'user', 1),
	(36, 'testCreateUser10', 'testCreateUser10', 'user', 1),
	(37, 'testCreateUser11', 'testCreateUser11', 'user', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
>>>>>>> developpement
