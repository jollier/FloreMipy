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


-- Export de la structure de la base pour floremipyuser
CREATE DATABASE IF NOT EXISTS `floremipyuser` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `floremipyuser`;

-- Export de la structure de la table floremipyuser. userdbversion
CREATE TABLE IF NOT EXISTS `userdbversion` (
  `id` int(11) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Export de données de la table floremipyuser.userdbversion : ~1 rows (environ)
DELETE FROM `userdbversion`;
/*!40000 ALTER TABLE `userdbversion` DISABLE KEYS */;
INSERT INTO `userdbversion` (`id`, `version`) VALUES
	(1, 7);
/*!40000 ALTER TABLE `userdbversion` ENABLE KEYS */;

-- Export de la structure de la table floremipyuser. users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `usertype` varchar(250) NOT NULL,
  `idcustomer` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=latin1;

-- Export de données de la table floremipyuser.users : ~11 rows (environ)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `usertype`, `idcustomer`) VALUES
	(1, 'user1', 'user1', 'user', 1),
	(2, 'admin1', 'admin1', 'admin', NULL),
	(3, 'employee1', 'employee1', 'employee', NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
