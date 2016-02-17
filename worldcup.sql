-- phpMyAdmin SQL Dump
-- version 4.0.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 17 Février 2016 à 10:59
-- Version du serveur: 10.0.14-MariaDB
-- Version de PHP: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `worldcup`
--

-- --------------------------------------------------------

--
-- Structure de la table `Equipe`
--

CREATE TABLE IF NOT EXISTS `Equipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `lienImage` varchar(255) DEFAULT NULL,
  `groupe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7C2D8A55D1753E00` (`groupe_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=33 ;

--
-- Contenu de la table `Equipe`
--

INSERT INTO `Equipe` (`id`, `libelle`, `lienImage`, `groupe_id`) VALUES
(1, 'Brésil', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01352___42x22.png', 1),
(2, 'Cameroun', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03yl2t__42x22.png', 1),
(3, 'Mexique', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03dj48__42x22.png', 1),
(4, 'Croatie', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-0356gk__42x22.png', 1),
(5, 'Australie', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-0cnk2q__42x22.png', 2),
(6, 'Chili', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-033nzk__42x22.png', 2),
(7, 'Pays-Bas', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02ltg3__42x22.png', 2),
(8, 'Espagne', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02w64f__42x22.png', 2),
(9, 'Colombie', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-032c08__42x22.png', 3),
(10, 'Côte d''Ivoire', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-040pyq__42x22.png', 3),
(11, 'Grèce', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-035qgm__42x22.png', 3),
(12, 'Japon', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03xh50__42x22.png', 3),
(13, 'Costa Rica', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03zb6t__42x22.png', 4),
(14, 'Angleterre', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02pp1__42x22.png', 4),
(15, 'Italie', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01_lhg__42x22.png', 4),
(16, 'Uruguay', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-0329r5__42x22.png', 4),
(17, 'Equateur', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03zj_3__42x22.png', 5),
(18, 'France', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01l3vx__42x22.png', 5),
(19, 'Honduras', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03z8bw__42x22.png', 5),
(20, 'Suisse', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-032jlh__42x22.png', 5),
(21, 'Argentine', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02bh_v__42x22.png', 6),
(22, 'Bosnie', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03yv9r__42x22.png', 6),
(23, 'Iran', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01n_2f__42x22.png', 6),
(24, 'Nigéria', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03ylxn__42x22.png', 6),
(25, 'Allemagne', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-01l3wr__42x22.png', 7),
(26, 'Ghana', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03_qrp__42x22.png', 7),
(27, 'Portugal', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02rqxc__42x22.png', 7),
(28, 'Etats-Unis', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-02s9vc__42x22.png', 7),
(29, 'Algérie', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03_qj1__42x22.png', 8),
(30, 'Belgique', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-0329gm__42x22.png', 8),
(31, 'Corée du Sud', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03zrhb__42x22.png', 8),
(32, 'Russie', 'http://ssl.gstatic.com/onebox/sports/worldcup/flags//-m-03262k__42x22.png', 8);

-- --------------------------------------------------------

--
-- Structure de la table `Groupe`
--

CREATE TABLE IF NOT EXISTS `Groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `Groupe`
--

INSERT INTO `Groupe` (`id`, `libelle`) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C'),
(4, 'D'),
(5, 'E'),
(6, 'F'),
(7, 'G'),
(8, 'H');

-- --------------------------------------------------------

--
-- Structure de la table `Matchs`
--

CREATE TABLE IF NOT EXISTS `Matchs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `debut` datetime DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `ordre` int(11) NOT NULL,
  `equipe1_id` int(11) DEFAULT NULL,
  `equipe2_id` int(11) DEFAULT NULL,
  `score_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK88F24B6E50664DB4` (`score_id`),
  KEY `FK88F24B6EEAA9B038` (`equipe2_id`),
  KEY `FK88F24B6EEAA93BD9` (`equipe1_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=65 ;

--
-- Contenu de la table `Matchs`
--

INSERT INTO `Matchs` (`id`, `debut`, `libelle`, `ordre`, `equipe1_id`, `equipe2_id`, `score_id`) VALUES
(49, '2014-06-28 18:00:00', 'Huitieme de finale', 49, 1, 6, 627),
(50, '2014-06-28 22:00:00', 'Huitieme de finale', 50, 9, 16, 628),
(51, '2014-06-29 18:00:00', 'Huitieme de finale', 51, 7, 3, 629),
(52, '2014-06-29 22:00:00', 'Huitieme de finale', 52, 13, 11, 630),
(53, '2014-06-30 18:00:00', 'Huitieme de finale', 53, 18, 24, 639),
(54, '2014-06-30 22:00:00', 'Huitieme de finale', 54, 25, 29, 640),
(55, '2014-07-01 18:00:00', 'Huitieme de finale', 55, 21, 20, 641),
(56, '2014-07-01 22:00:00', 'Huitieme de finale', 56, 28, 30, 642),
(57, '2014-07-04 18:00:00', ' Match phase finale', 57, 18, 25, 691),
(58, '2014-07-04 22:00:00', ' Match phase finale', 58, 1, 9, 692),
(59, '2014-07-05 18:00:00', ' Match phase finale', 59, 21, 30, 693),
(60, '2014-07-05 22:00:00', ' Match phase finale', 60, 7, 13, 694),
(61, '2014-07-08 22:00:00', ' Match phase finale', 61, 1, 25, 719),
(62, '2014-09-07 22:00:00', ' Match phase finale', 62, 7, 21, 720),
(63, '2014-07-12 21:00:00', ' Match phase finale', 63, 1, 7, 745),
(64, '2014-07-13 22:00:00', ' Match phase finale', 64, 21, 25, 746);

-- --------------------------------------------------------

--
-- Structure de la table `Pari`
--

CREATE TABLE IF NOT EXISTS `Pari` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pointDiff` int(11) NOT NULL,
  `pointGagnant` int(11) NOT NULL,
  `pris` bit(1) NOT NULL,
  `scoreExact` int(11) NOT NULL,
  `matchs_id` int(11) DEFAULT NULL,
  `score_id` int(11) DEFAULT NULL,
  `utilisateur_id` int(11) DEFAULT NULL,
  `scoreTirAuBut_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK25D80850664DB4` (`score_id`),
  KEY `FK25D80857C8F100` (`matchs_id`),
  KEY `FK25D8088C870894` (`utilisateur_id`),
  KEY `FK25D80897F78E64` (`scoreTirAuBut_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=193 ;

--
-- Contenu de la table `Pari`
--

INSERT INTO `Pari` (`id`, `pointDiff`, `pointGagnant`, `pris`, `scoreExact`, `matchs_id`, `score_id`, `utilisateur_id`, `scoreTirAuBut_id`) VALUES
(1, 0, 0, b'0', 0, 49, 529, 1, NULL),
(2, 0, 0, b'0', 0, 49, 530, 5, NULL),
(3, 1, 2, b'0', 0, 49, 531, 6, NULL),
(4, 0, 0, b'0', 0, 49, 532, 7, NULL),
(5, 0, 0, b'0', 0, 49, 533, 8, NULL),
(6, 1, 2, b'0', 0, 49, 534, 9, NULL),
(7, 0, 0, b'0', 0, 49, 535, 10, NULL),
(8, 1, 2, b'0', 1, 49, 536, 12, NULL),
(9, 1, 2, b'0', 1, 50, 537, 1, NULL),
(10, 0, 2, b'0', 0, 50, 538, 5, NULL),
(11, 0, 0, b'0', 0, 50, 539, 6, NULL),
(12, 0, 0, b'0', 0, 50, 540, 7, NULL),
(13, 1, 2, b'0', 1, 50, 541, 8, NULL),
(14, 0, 0, b'0', 0, 50, 542, 9, NULL),
(15, 0, 2, b'0', 0, 50, 543, 10, NULL),
(16, 0, 2, b'0', 0, 50, 544, 12, NULL),
(17, 1, 2, b'0', 0, 51, 545, 1, NULL),
(18, 0, 2, b'0', 0, 51, 546, 5, NULL),
(19, 0, 0, b'0', 0, 51, 547, 6, NULL),
(20, 1, 2, b'0', 0, 51, 548, 7, NULL),
(21, 1, 2, b'0', 0, 51, 549, 8, NULL),
(22, 0, 0, b'0', 0, 51, 550, 9, NULL),
(23, 1, 2, b'0', 0, 51, 551, 10, NULL),
(24, 0, 2, b'0', 0, 51, 552, 12, NULL),
(25, 0, 0, b'0', 0, 52, 553, 1, NULL),
(26, 0, 0, b'0', 0, 52, 554, 5, NULL),
(27, 1, 2, b'0', 0, 52, 555, 6, NULL),
(28, 0, 0, b'0', 0, 52, 556, 7, NULL),
(29, 0, 0, b'0', 0, 52, 557, 8, NULL),
(30, 1, 2, b'0', 0, 52, 558, 9, NULL),
(31, 0, 0, b'0', 0, 52, 559, 10, NULL),
(32, 0, 0, b'0', 0, 52, 560, 12, NULL),
(33, 1, 2, b'0', 1, 53, 561, 1, NULL),
(34, 1, 2, b'0', 1, 53, 562, 5, NULL),
(35, 1, 2, b'0', 1, 53, 563, 6, NULL),
(36, 1, 2, b'0', 1, 53, 564, 7, NULL),
(37, 0, 2, b'0', 0, 53, 565, 8, NULL),
(38, 0, 0, b'0', 0, 53, 566, 9, NULL),
(39, 1, 2, b'0', 0, 53, 567, 10, NULL),
(40, 0, 2, b'0', 0, 53, 568, 12, NULL),
(41, 0, 2, b'0', 0, 54, 569, 1, NULL),
(42, 0, 2, b'0', 0, 54, 570, 5, NULL),
(43, 0, 2, b'0', 0, 54, 571, 6, NULL),
(44, 0, 2, b'0', 0, 54, 572, 7, NULL),
(45, 0, 2, b'0', 0, 54, 573, 8, NULL),
(46, 0, 0, b'0', 0, 54, 574, 9, NULL),
(47, 0, 2, b'0', 0, 54, 575, 10, NULL),
(48, 0, 2, b'0', 0, 54, 576, 12, NULL),
(49, 0, 2, b'0', 0, 55, 577, 1, NULL),
(50, 0, 0, b'0', 0, 55, 578, 5, NULL),
(51, 0, 2, b'0', 0, 55, 579, 6, NULL),
(52, 1, 2, b'0', 1, 55, 580, 7, NULL),
(53, 1, 2, b'0', 0, 55, 581, 8, NULL),
(54, 0, 2, b'0', 0, 55, 582, 9, NULL),
(55, 0, 2, b'0', 0, 55, 583, 10, NULL),
(56, 0, 0, b'0', 0, 55, 584, 12, NULL),
(57, 0, 0, b'0', 0, 56, 585, 1, NULL),
(58, 0, 0, b'0', 0, 56, 586, 5, NULL),
(59, 0, 0, b'0', 0, 56, 587, 6, NULL),
(60, 0, 0, b'0', 0, 56, 588, 7, NULL),
(61, 1, 2, b'0', 0, 56, 589, 8, NULL),
(62, 1, 2, b'0', 0, 56, 590, 9, NULL),
(63, 0, 0, b'0', 0, 56, 591, 10, NULL),
(64, 0, 0, b'0', 0, 56, 592, 12, NULL),
(65, 0, 0, b'0', 0, 49, 603, 16, NULL),
(66, 0, 0, b'0', 0, 50, 604, 16, NULL),
(67, 1, 2, b'0', 0, 51, 605, 16, NULL),
(68, 0, 0, b'0', 0, 52, 606, 16, NULL),
(69, 1, 2, b'0', 1, 53, 607, 16, NULL),
(70, 0, 2, b'0', 0, 54, 608, 16, NULL),
(71, 0, 2, b'0', 0, 55, 609, 16, NULL),
(72, 1, 2, b'0', 1, 56, 610, 16, NULL),
(73, 0, 0, b'0', 0, 49, 611, 17, NULL),
(74, 0, 2, b'0', 0, 50, 612, 17, NULL),
(75, 0, 0, b'0', 0, 51, 613, 17, NULL),
(76, 0, 0, b'0', 0, 52, 614, 17, NULL),
(77, 0, 2, b'0', 0, 53, 615, 17, NULL),
(78, 0, 2, b'0', 0, 54, 616, 17, NULL),
(79, 0, 2, b'0', 0, 55, 617, 17, NULL),
(80, 0, 0, b'0', 0, 56, 618, 17, NULL),
(81, 1, 2, b'0', 0, 49, 619, 18, NULL),
(82, 0, 0, b'0', 0, 50, 620, 18, NULL),
(83, 0, 0, b'0', 0, 51, 621, 18, NULL),
(84, 1, 2, b'0', 0, 52, 622, 18, NULL),
(85, 0, 2, b'0', 0, 53, 623, 18, NULL),
(86, 0, 2, b'0', 0, 54, 624, 18, NULL),
(87, 1, 2, b'0', 0, 55, 625, 18, NULL),
(88, 0, 0, b'0', 0, 56, 626, 18, NULL),
(89, 0, 0, b'0', 0, 49, 631, 19, NULL),
(90, 0, 0, b'0', 0, 50, 632, 19, NULL),
(91, 0, 0, b'0', 0, 51, 633, 19, NULL),
(92, 0, 0, b'0', 0, 52, 634, 19, NULL),
(93, 0, 2, b'0', 0, 53, 635, 19, NULL),
(94, 0, 0, b'0', 0, 54, 636, 19, NULL),
(95, 1, 2, b'0', 1, 55, 637, 19, NULL),
(96, 1, 2, b'0', 1, 56, 638, 19, NULL),
(97, 1, 2, b'0', 1, 57, 643, 1, NULL),
(98, 0, 0, b'0', 0, 57, 644, 5, NULL),
(99, 0, 0, b'0', 0, 57, 645, 6, NULL),
(100, 0, 0, b'0', 0, 57, 646, 7, NULL),
(101, 1, 2, b'0', 0, 57, 647, 8, NULL),
(102, 1, 2, b'0', 1, 57, 648, 9, NULL),
(103, 1, 2, b'0', 0, 57, 649, 10, NULL),
(104, 0, 0, b'0', 0, 57, 650, 12, NULL),
(105, 0, 0, b'0', 0, 57, 651, 16, NULL),
(106, 0, 0, b'0', 0, 57, 652, 17, NULL),
(107, 0, 0, b'0', 0, 57, 653, 18, NULL),
(108, 0, 0, b'0', 0, 57, 654, 19, NULL),
(109, 0, 0, b'0', 0, 58, 655, 1, NULL),
(110, 0, 0, b'0', 0, 58, 656, 5, NULL),
(111, 1, 2, b'0', 1, 58, 657, 6, NULL),
(112, 0, 0, b'0', 0, 58, 658, 7, NULL),
(113, 0, 0, b'0', 0, 58, 659, 8, NULL),
(114, 0, 0, b'0', 0, 58, 660, 9, NULL),
(115, 0, 0, b'0', 0, 58, 661, 10, NULL),
(116, 0, 0, b'0', 0, 58, 662, 12, NULL),
(117, 0, 0, b'0', 0, 58, 663, 16, NULL),
(118, 0, 0, b'0', 0, 58, 664, 17, NULL),
(119, 0, 0, b'0', 0, 58, 665, 18, NULL),
(120, 1, 2, b'0', 0, 58, 666, 19, NULL),
(121, 0, 0, b'0', 0, 59, 667, 1, NULL),
(122, 0, 0, b'0', 0, 59, 668, 5, NULL),
(123, 1, 2, b'0', 1, 59, 669, 6, NULL),
(124, 0, 0, b'0', 0, 59, 670, 7, NULL),
(125, 0, 0, b'0', 0, 59, 671, 8, NULL),
(126, 1, 2, b'0', 1, 59, 672, 9, NULL),
(127, 0, 2, b'0', 0, 59, 673, 10, NULL),
(128, 0, 0, b'0', 0, 59, 674, 12, NULL),
(129, 1, 2, b'0', 0, 59, 675, 16, NULL),
(130, 0, 0, b'0', 0, 59, 676, 17, NULL),
(131, 0, 0, b'0', 0, 59, 677, 18, NULL),
(132, 0, 0, b'0', 0, 59, 678, 19, NULL),
(133, 0, 0, b'0', 0, 60, 679, 1, NULL),
(134, 1, 2, b'0', 1, 60, 680, 5, NULL),
(135, 0, 0, b'0', 0, 60, 681, 6, NULL),
(136, 1, 2, b'0', 1, 60, 682, 7, NULL),
(137, 0, 0, b'0', 0, 60, 683, 8, NULL),
(138, 0, 0, b'0', 0, 60, 684, 9, NULL),
(139, 0, 0, b'0', 0, 60, 685, 10, NULL),
(140, 0, 0, b'0', 0, 60, 686, 12, NULL),
(141, 0, 0, b'0', 0, 60, 687, 16, NULL),
(142, 1, 2, b'0', 1, 60, 688, 17, NULL),
(143, 1, 2, b'0', 1, 60, 689, 18, NULL),
(144, 0, 0, b'0', 0, 60, 690, 19, NULL),
(145, 0, 0, b'0', 0, 61, 695, 1, NULL),
(146, 0, 0, b'0', 0, 61, 696, 5, NULL),
(147, 0, 2, b'0', 0, 61, 697, 6, NULL),
(148, 0, 0, b'0', 0, 61, 698, 7, NULL),
(149, 0, 2, b'0', 0, 61, 699, 8, NULL),
(150, 0, 2, b'0', 0, 61, 700, 9, NULL),
(151, 0, 0, b'0', 0, 61, 701, 10, NULL),
(152, 0, 0, b'0', 0, 61, 702, 12, NULL),
(153, 0, 0, b'0', 0, 61, 703, 16, NULL),
(154, 0, 0, b'0', 0, 61, 704, 17, NULL),
(155, 0, 0, b'0', 0, 61, 705, 18, NULL),
(156, 0, 0, b'0', 0, 61, 706, 19, NULL),
(157, 0, 0, b'0', 0, 62, 707, 1, NULL),
(158, 1, 2, b'0', 1, 62, 708, 5, NULL),
(159, 0, 0, b'0', 0, 62, 709, 6, NULL),
(160, 1, 2, b'0', 1, 62, 710, 7, NULL),
(161, 1, 2, b'0', 0, 62, 711, 8, NULL),
(162, 0, 0, b'0', 0, 62, 712, 9, NULL),
(163, 0, 0, b'0', 0, 62, 713, 10, NULL),
(164, 1, 2, b'0', 1, 62, 714, 12, NULL),
(165, 0, 0, b'0', 0, 62, 715, 16, NULL),
(166, 1, 2, b'0', 1, 62, 716, 17, NULL),
(167, 0, 0, b'0', 0, 62, 717, 18, NULL),
(168, 0, 0, b'0', 0, 62, 718, 19, NULL),
(169, 1, 2, b'0', 1, 63, 721, 1, NULL),
(170, 0, 0, b'0', 0, 63, 722, 5, NULL),
(171, 0, 2, b'0', 0, 63, 723, 6, NULL),
(172, 0, 2, b'0', 0, 63, 724, 7, NULL),
(173, 0, 0, b'0', 0, 63, 725, 8, NULL),
(174, 0, 2, b'0', 0, 63, 726, 9, NULL),
(175, 0, 0, b'0', 0, 63, 727, 10, NULL),
(176, 0, 0, b'0', 0, 63, 728, 12, NULL),
(177, 0, 0, b'0', 0, 63, 729, 16, NULL),
(178, 0, 0, b'0', 0, 63, 730, 17, NULL),
(179, 0, 2, b'0', 0, 63, 731, 18, NULL),
(180, 0, 0, b'0', 0, 63, 732, 19, NULL),
(181, 0, 2, b'0', 0, 64, 733, 1, NULL),
(182, 0, 0, b'0', 0, 64, 734, 5, NULL),
(183, 0, 2, b'0', 0, 64, 735, 6, NULL),
(184, 0, 2, b'0', 0, 64, 736, 7, NULL),
(185, 0, 0, b'0', 0, 64, 737, 8, NULL),
(186, 0, 2, b'0', 0, 64, 738, 9, NULL),
(187, 0, 0, b'0', 0, 64, 739, 10, NULL),
(188, 0, 0, b'0', 0, 64, 740, 12, NULL),
(189, 0, 0, b'0', 0, 64, 741, 16, NULL),
(190, 0, 0, b'0', 0, 64, 742, 17, NULL),
(191, 1, 2, b'0', 0, 64, 743, 18, NULL),
(192, 0, 0, b'0', 0, 64, 744, 19, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `Score`
--

CREATE TABLE IF NOT EXISTS `Score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `butEquipe1` int(11) NOT NULL,
  `butEquipe2` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=747 ;

--
-- Contenu de la table `Score`
--

INSERT INTO `Score` (`id`, `butEquipe1`, `butEquipe2`) VALUES
(529, 1, 0),
(530, 2, 1),
(531, 0, 0),
(532, 2, 0),
(533, 2, 1),
(534, 0, 0),
(535, 3, 1),
(536, 1, 1),
(537, 2, 0),
(538, 2, 1),
(539, 0, 0),
(540, 0, 1),
(541, 2, 0),
(542, 0, 0),
(543, 2, 1),
(544, 3, 0),
(545, 1, 0),
(546, 2, 0),
(547, 0, 0),
(548, 1, 0),
(549, 1, 0),
(550, 0, 0),
(551, 3, 2),
(552, 2, 0),
(553, 2, 0),
(554, 1, 0),
(555, 0, 0),
(556, 0, 1),
(557, 2, 0),
(558, 0, 0),
(559, 2, 0),
(560, 1, 2),
(561, 2, 0),
(562, 2, 0),
(563, 2, 0),
(564, 2, 0),
(565, 3, 0),
(566, 0, 0),
(567, 3, 1),
(568, 1, 0),
(569, 2, 0),
(570, 2, 0),
(571, 3, 1),
(572, 2, 0),
(573, 4, 1),
(574, 0, 0),
(575, 3, 1),
(576, 3, 0),
(577, 2, 0),
(578, 0, 0),
(579, 4, 1),
(580, 1, 0),
(581, 2, 1),
(582, 2, 0),
(583, 3, 1),
(584, 0, 1),
(585, 2, 1),
(586, 0, 0),
(587, 2, 1),
(588, 1, 0),
(589, 0, 1),
(590, 0, 1),
(591, 2, 1),
(592, 2, 1),
(603, 3, 1),
(604, 1, 1),
(605, 1, 0),
(606, 2, 0),
(607, 2, 0),
(608, 3, 0),
(609, 3, 1),
(610, 1, 2),
(611, 1, 2),
(612, 3, 0),
(613, 1, 2),
(614, 3, 0),
(615, 1, 0),
(616, 2, 0),
(617, 2, 0),
(618, 3, 2),
(619, 0, 0),
(620, 0, 0),
(621, 0, 0),
(622, 0, 0),
(623, 2, 1),
(624, 2, 0),
(625, 2, 1),
(626, 1, 1),
(627, 1, 1),
(628, 2, 0),
(629, 2, 1),
(630, 1, 1),
(631, 0, 0),
(632, 0, 0),
(633, 0, 0),
(634, 0, 0),
(635, 2, 1),
(636, 0, 0),
(637, 1, 0),
(638, 1, 2),
(639, 2, 0),
(640, 2, 1),
(641, 1, 0),
(642, 1, 2),
(643, 0, 1),
(644, 0, 0),
(645, 0, 0),
(646, 0, 0),
(647, 1, 2),
(648, 0, 1),
(649, 1, 2),
(650, 2, 0),
(651, 3, 1),
(652, 0, 0),
(653, 0, 0),
(654, 2, 1),
(655, 1, 2),
(656, 0, 0),
(657, 2, 1),
(658, 0, 0),
(659, 0, 2),
(660, 0, 1),
(661, 1, 1),
(662, 1, 2),
(663, 0, 1),
(664, 0, 0),
(665, 0, 0),
(666, 1, 0),
(667, 1, 1),
(668, 0, 0),
(669, 1, 0),
(670, 0, 0),
(671, 1, 2),
(672, 1, 0),
(673, 2, 0),
(674, 0, 1),
(675, 2, 1),
(676, 0, 0),
(677, 0, 0),
(678, 0, 1),
(679, 2, 0),
(680, 0, 0),
(681, 2, 1),
(682, 0, 0),
(683, 2, 0),
(684, 2, 0),
(685, 2, 0),
(686, 1, 0),
(687, 2, 0),
(688, 0, 0),
(689, 0, 0),
(690, 2, 1),
(691, 0, 1),
(692, 2, 1),
(693, 1, 0),
(694, 0, 0),
(695, 1, 0),
(696, 0, 0),
(697, 1, 2),
(698, 0, 0),
(699, 0, 2),
(700, 0, 1),
(701, 1, 1),
(702, 3, 0),
(703, 0, 0),
(704, 0, 0),
(705, 0, 0),
(706, 0, 0),
(707, 2, 1),
(708, 0, 0),
(709, 3, 1),
(710, 0, 0),
(711, 1, 1),
(712, 2, 1),
(713, 1, 2),
(714, 0, 0),
(715, 2, 1),
(716, 0, 0),
(717, 2, 1),
(718, 4, 2),
(719, 1, 7),
(720, 0, 0),
(721, 0, 3),
(722, 0, 0),
(723, 1, 2),
(724, 0, 1),
(725, 0, 0),
(726, 0, 2),
(727, 0, 0),
(728, 0, 0),
(729, 2, 0),
(730, 0, 0),
(731, 1, 2),
(732, 0, 0),
(733, 0, 2),
(734, 0, 0),
(735, 0, 2),
(736, 0, 2),
(737, 3, 1),
(738, 0, 2),
(739, 0, 0),
(740, 0, 0),
(741, 2, 1),
(742, 0, 0),
(743, 1, 2),
(744, 0, 0),
(745, 0, 3),
(746, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `Utilisateur`
--

CREATE TABLE IF NOT EXISTS `Utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `abilitationAdministrateur` bit(1) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `identifiant` varchar(255) DEFAULT NULL,
  `motpasse` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=20 ;

--
-- Contenu de la table `Utilisateur`
--

INSERT INTO `Utilisateur` (`id`, `abilitationAdministrateur`, `email`, `identifiant`, `motpasse`, `nom`, `prenom`) VALUES
(1, b'0', NULL, 'nat', 'natnat', 'Belloulou', 'Nathan'),
(2, b'1', NULL, 'admin', 'adminnat', 'admin', 'admin'),
(5, b'0', NULL, 'enzo', 'enz', 'Kaci', 'Enzo'),
(6, b'0', NULL, 'ali', 'CMD2014', 'Mansour', 'Ali'),
(7, b'0', NULL, 'jcm', 'jcm', 'Marie', 'Jean-Clément'),
(8, b'0', NULL, 'sylvain', 'rivollet', 'Rivollet', 'Sylvain'),
(9, b'0', NULL, 'aurelien', 'aur', 'Djoutsop', 'Aurélien'),
(10, b'0', NULL, 'hicham', 'WorldCup', 'Chbani', 'Hicham'),
(12, b'0', NULL, 'patrick', 'pat', 'Azria', 'Patrick'),
(16, b'0', NULL, 'loic', 'loi', 'Thelier', 'Loïc'),
(17, b'0', NULL, 'gregory', 'greg', 'Knaff', 'Gregory'),
(18, b'0', NULL, 'amara', 'ama', 'El Mahdi', 'Amara'),
(19, b'0', NULL, 'test', 'moi12345', 'Guillaume', 'Nahon');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Equipe`
--
ALTER TABLE `Equipe`
  ADD CONSTRAINT `FK7C2D8A55D1753E00` FOREIGN KEY (`groupe_id`) REFERENCES `Groupe` (`id`);

--
-- Contraintes pour la table `Matchs`
--
ALTER TABLE `Matchs`
  ADD CONSTRAINT `FK88F24B6E50664DB4` FOREIGN KEY (`score_id`) REFERENCES `Score` (`id`),
  ADD CONSTRAINT `FK88F24B6EEAA93BD9` FOREIGN KEY (`equipe1_id`) REFERENCES `Equipe` (`id`),
  ADD CONSTRAINT `FK88F24B6EEAA9B038` FOREIGN KEY (`equipe2_id`) REFERENCES `Equipe` (`id`);

--
-- Contraintes pour la table `Pari`
--
ALTER TABLE `Pari`
  ADD CONSTRAINT `FK25D80850664DB4` FOREIGN KEY (`score_id`) REFERENCES `Score` (`id`),
  ADD CONSTRAINT `FK25D80857C8F100` FOREIGN KEY (`matchs_id`) REFERENCES `Matchs` (`id`),
  ADD CONSTRAINT `FK25D8088C870894` FOREIGN KEY (`utilisateur_id`) REFERENCES `Utilisateur` (`id`),
  ADD CONSTRAINT `FK25D80897F78E64` FOREIGN KEY (`scoreTirAuBut_id`) REFERENCES `Score` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
