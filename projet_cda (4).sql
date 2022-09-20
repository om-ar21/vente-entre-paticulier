-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 18 sep. 2022 à 16:44
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_cda`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `nom` varchar(15) NOT NULL,
  `prenom` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mdp` varchar(200) NOT NULL,
  `privilege` tinyint(1) NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `nom`, `prenom`, `email`, `mdp`, `privilege`, `del`) VALUES
(1, 'bouchnayaf', 'omar', 'omarbouch901@gmail.com', 'dac5bec37ee707cdadd766b733a3368ef5fed614eb9f0725feb0126483c71608', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `id_souscat` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `description` text NOT NULL,
  `date_pub` date NOT NULL,
  `val` tinyint(4) NOT NULL DEFAULT 0,
  `del` tinyint(4) NOT NULL DEFAULT 0,
  `image` varchar(150) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id`, `titre`, `id_souscat`, `id_user`, `description`, `date_pub`, `val`, `del`, `image`, `ville`, `prix`) VALUES
(1, 'Scooter Honda Forza 125 cm3 2016', 10, 15, 'Vend Honda Forza 125 cm3 annÃÂ©e 2016, avec support smartphone, trÃÂ¨s bon ÃÂ©tat. Cause : permis moto.\r\n\r\nMise en circulation juin 2016.\r\nKilomÃÂ©trage 5400 km.\r\nRÃÂ©vision constructeur, carnet d\'entretien disponible.', '2022-09-02', 1, 0, 'moto.jpg', 'lyonn', 3600),
(2, 'test supp', 3, 15, 'test image supp', '2022-09-02', 0, 0, 'store-4156934.png', 'Saint-Didier-au-Mont-d\'Or', 45),
(3, 'Nothing Phone 1 ', 9, 15, 'dfgdfgdfg', '2022-09-02', 0, 0, '4.jpg', 'Aubervilliers', 1450),
(4, 'test max', 13, 15, 'test max id', '2022-09-02', 0, 0, 'store-4156934.png', 'Aubervilliers', 1400),
(5, 'test final', 15, 15, 'test image supplÃ©mentaires', '2022-09-02', 1, 1, 'background.jpg', 'paris', 22),
(6, 'Fruit', 12, 15, 'test image vide', '2022-09-02', 0, 0, 'servlet1.png', 'Saint-Didier-au-Mont-d\'Or', 600),
(7, 'fantome', 3, 15, 'testsrg', '2022-09-02', 0, 0, 'Capture dâ€™Ã©cran 2022-08-31 182810.png', 'Aubervilliers', 600),
(8, 'dgdg', 14, 15, 'fgdfg', '2022-09-02', 0, 0, 'Capture dâ€™Ã©cran 2022-08-25 160415.png', 'Saint-Didier-au-Mont-d\'Or', 600),
(9, 'dÃ©veloppeur web', 15, 15, 'vgdrg', '2022-09-02', 0, 0, 'Capture dâ€™Ã©cran 2022-08-25 160415.png', 'Saint-Didier-au-Mont-d\'Or', 22),
(10, 'Nothing Phone 1 ', 13, 15, 'dsqd', '2022-09-02', 0, 0, 'Capture dâ€™Ã©cran 2022-08-25 160415.png', 'Saint-Didier-au-Mont-d\'Or', 600),
(11, 'Nike air force 1', 14, 15, 'Je vends une paire dÃ¢ÂÂair force one blanche neuve jamais portÃÂ©e', '2022-09-02', 1, 0, 'nike.jpg', 'Saint-Didier-au-Mont-d\'Or', 50),
(12, 'Samsung s22 ultra ', 3, 15, 'Je le vend car je l\'utilise jamais il est tout neuf vendu avec tout ses accessoires facture d\'achat il est garantie casse 2 ans\r\nCordialement', '2022-09-02', 1, 0, 's22.jpeg', 'Lyon', 800),
(13, 'Nothing Phone 1 ', 2, 15, 'dgdtg', '2022-09-02', 0, 0, 'Capture dâ€™Ã©cran 2022-08-25 160415.png', 'Saint-Didier-au-Mont-d\'Or', 22),
(14, 'Alien', 12, 15, 'test croise les doigts', '2022-09-02', 0, 0, 'Capture dâ€™Ã©cran 2022-08-25 160415.png', 'paris', 600),
(15, 'test espace', 3, 16, 'test espace image', '2022-09-03', 0, 1, 'Capturedâ€™Ã©cran2022-08-31182844.png', 'Saint-Didier-au-Mont-d\'Or', 600),
(16, 'test espace', 3, 16, 'test espace image', '2022-09-03', 1, 1, 'Capturedâ€™Ã©cran2022-08-31182844.png', 'Saint-Didier-au-Mont-d\'Or', 600),
(17, 'ps4', 1, 17, 'Bonjour\r\nje mets en vente ma ps4 en trÃ¨s bon Ã©tat, elle fonctionne parfaitement.\r\nelle est fournie avec tous ses accessoires et des jeux.\r\n', '2022-09-12', 1, 0, 'ps41.jpg', 'paris', 200),
(18, 'Iphone 13 pro', 3, 17, 'VEND IPHONE 13 pro 128g Vert alpine tout neuf , avec facture dÃ¢ÂÂachat garantie tout .\r\nEnvoi possible', '2022-09-12', 1, 0, 'iphone1.jpg', 'pris', 550),
(19, 'blender', 7, 17, 'Cause double emploi vends ce blender rose Ã©tat neuf\r\nServi une 10aine de fois pour smoothies', '2022-09-12', 1, 0, 'blender.jpeg', 'Paris', 20),
(20, 'ps5 ', 1, 16, 'Je vends ma ps5 en parfait Ã©tat, trÃ¨s peu utilisÃ©\r\nfournie avec tous ses accessoires.', '2022-09-12', 1, 1, 'ps51.jpeg', 'Lyon', 550),
(21, 'télé LG', 2, 16, 'Je vends ma tÃ©lÃ© LG de 107 cm elle est en bon Ã©tat\r\n', '2022-09-12', 1, 0, 'tv1.jpeg', 'Lyon', 200),
(22, 'Studio meublé à  louer', 5, 16, 'Studio MeublÃ© 22mÂ². Beau studio meublÃ© au 2Ã¨me Ã©tage avec ascenseur dâun immeuble bien entretenu, ce bel appartement dispose de beaucoup de charme et est louÃ© meublÃ©.\r\nIl est Ã©quipÃ©, dâune cuisine sÃ©parÃ©e amÃ©nagÃ©e et entiÃ¨rement Ã©quipÃ©e, dâune salle de bains et de toilettes sÃ©parÃ©es.', '2022-09-12', 1, 1, 'app1.jpg', 'Lyon', 375),
(23, 'béret ', 15, 16, 'bÃ©ret en parfait Ã©tat ', '2022-09-12', 1, 0, 'beret1.jpeg', 'Lyon', 15),
(24, 'télé', 2, 15, 'tÃ©lÃ© trÃ¨s belle ', '2022-09-14', 0, 0, 'tv1.jpeg', 'Aubervilliers', 600),
(25, 'télé 4K', 2, 15, 'télé vision', '2022-09-14', 1, 0, 'tv1.jpeg', 'Saint-Didier-au-Mont-d\'Or', 600);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `titre` varchar(40) NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `titre`, `del`) VALUES
(1, ' multimédia', 0),
(2, 'immobilier', 0),
(3, 'maison', 0),
(4, 'véhicules', 0),
(5, 'mode', 0),
(6, 'temp', 1);

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sujet` varchar(50) NOT NULL,
  `message` text NOT NULL,
  `etat` tinyint(4) NOT NULL DEFAULT 0,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `contact`
--

INSERT INTO `contact` (`id`, `email`, `sujet`, `message`, `etat`, `id_user`) VALUES
(1, 'teest@gmail.com', 'test', 'test contact', 0, 16),
(4, 'notconnected@gmail.com', 'test', 'test contact', 0, 1),
(5, 'm.julien@gmail.com', 'test', 'bonjour', 0, 15);

-- --------------------------------------------------------

--
-- Structure de la table `conversation`
--

CREATE TABLE `conversation` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_annonce` int(11) NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `favoris`
--

CREATE TABLE `favoris` (
  `id` int(11) NOT NULL,
  `id_annonce` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `favoris`
--

INSERT INTO `favoris` (`id`, `id_annonce`, `id_user`, `del`) VALUES
(10, 5, 15, 0),
(16, 1, 16, 0),
(19, 19, 15, 0);

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `id_annonce` int(11) NOT NULL,
  `lien` varchar(150) NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`id`, `id_annonce`, `lien`, `del`) VALUES
(5, 5, 'store-4156934.png', 0),
(6, 5, 'exo1.png', 0),
(7, 5, 'Capture dâ€™Ã©cran 2022-08-18 144742.png', 0),
(8, 5, 'exo13.png', 0),
(9, 7, 'servlet2.png', 0),
(10, 14, 'servlet2.png', 0),
(11, 15, 'add_annonce.png', 0),
(12, 15, 'Capturedâ€™Ã©cran2022-08-31182844.png', 0),
(14, 16, 'Capturedâ€™Ã©cran2022-08-31182844.png', 0),
(15, 17, 'ps42.jpg', 0),
(16, 17, 'ps43.jpg', 0),
(17, 18, 'iphone2.jpg', 0),
(18, 20, 'ps52.jpeg', 0),
(19, 22, 'app2.jpg', 0),
(20, 22, 'app3.jpg', 0),
(21, 23, 'beret2.jpeg', 0);

-- --------------------------------------------------------

--
-- Structure de la table `messagerie`
--

CREATE TABLE `messagerie` (
  `id` int(11) NOT NULL,
  `id_em` int(11) NOT NULL,
  `id_rec` int(11) NOT NULL,
  `id_annonce` int(11) NOT NULL,
  `message` varchar(200) NOT NULL,
  `date_message` timestamp NOT NULL DEFAULT current_timestamp(),
  `etat` tinyint(4) NOT NULL DEFAULT 0,
  `contact` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `messagerie`
--

INSERT INTO `messagerie` (`id`, `id_em`, `id_rec`, `id_annonce`, `message`, `date_message`, `etat`, `contact`) VALUES
(41, 15, 16, 16, 'bonjour, c\'est toujours disponible ?', '2022-09-09 14:11:53', 1, 15),
(42, 16, 15, 16, 'bonjour oui', '2022-09-09 14:12:38', 1, 15),
(43, 15, 16, 16, 'sur ?', '2022-09-09 14:13:13', 1, 15),
(44, 16, 15, 5, 'bonjour je suis interesse', '2022-09-09 14:16:16', 1, 16),
(45, 15, 16, 16, 'oui bonjour test', '2022-09-09 14:17:14', 1, 15),
(46, 15, 16, 16, 'bonjour', '2022-09-09 22:20:52', 1, 15),
(47, 15, 16, 5, 'oui pourquoi?', '2022-09-10 11:06:04', 1, 16),
(48, 16, 15, 5, 'rien ', '2022-09-10 11:07:54', 1, 16),
(49, 16, 15, 1, 'bonjour je suis intÃ©ressÃ© ', '2022-09-10 11:09:33', 1, 16),
(50, 15, 16, 1, 'binjour', '2022-09-10 11:10:40', 1, 16),
(51, 16, 15, 16, 'bonsoir', '2022-09-10 18:26:54', 1, 15),
(52, 15, 17, 18, 'bonjour ', '2022-09-12 11:28:59', 1, 15),
(53, 15, 17, 18, 'bonjour ', '2022-09-12 11:29:10', 1, 15),
(54, 17, 15, 18, 'bonjour \r\nl\'annonce est toujours disponible ', '2022-09-12 11:30:20', 1, 15),
(55, 15, 16, 1, 'le scooter est beau', '2022-09-12 11:35:13', 1, 16),
(56, 15, 17, 18, 'votre dernier prix ?', '2022-09-12 12:06:24', 1, 15),
(57, 17, 15, 18, '540 eur', '2022-09-12 12:06:51', 1, 15),
(58, 16, 15, 1, 'bonjour', '2022-09-14 18:38:30', 1, 16);

-- --------------------------------------------------------

--
-- Structure de la table `recherche`
--

CREATE TABLE `recherche` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `mot` varchar(20) NOT NULL,
  `date_rech` date NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `recherche`
--

INSERT INTO `recherche` (`id`, `id_user`, `mot`, `date_rech`, `del`) VALUES
(1, 1, 'test', '2022-09-06', 0),
(2, 1, 'nothing', '2022-09-06', 0),
(3, 1, 'test', '2022-09-06', 0),
(4, 1, 'test', '2022-09-06', 0),
(5, 1, 'nothing', '2022-09-06', 0),
(6, 1, 'nothing', '2022-09-06', 0),
(7, 1, 'nothing', '2022-09-06', 0),
(8, 1, 'nothing', '2022-09-06', 0),
(9, 1, 'nothing', '2022-09-06', 0),
(10, 1, 'nothing', '2022-09-06', 0),
(11, 16, 'test', '2022-09-06', 0),
(12, 16, 'test', '2022-09-06', 0),
(13, 15, 'a', '2022-09-08', 0),
(14, 15, 'alien', '2022-09-12', 0),
(15, 15, 'ps4', '2022-09-12', 0);

-- --------------------------------------------------------

--
-- Structure de la table `signalement`
--

CREATE TABLE `signalement` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_annonce` int(11) NOT NULL,
  `sujet` varchar(15) NOT NULL,
  `message` text NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `signalement`
--

INSERT INTO `signalement` (`id`, `id_user`, `id_annonce`, `sujet`, `message`, `del`) VALUES
(1, 1, 16, 'discrimination', 'test', 0),
(2, 1, 5, 'contrefaÃ§on', 'tesst', 0);

-- --------------------------------------------------------

--
-- Structure de la table `souscat`
--

CREATE TABLE `souscat` (
  `id` int(11) NOT NULL,
  `titre` varchar(40) NOT NULL,
  `id_categorie` int(11) NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `souscat`
--

INSERT INTO `souscat` (`id`, `titre`, `id_categorie`, `del`) VALUES
(1, 'consoles', 1, 0),
(2, 'image & son', 1, 0),
(3, 'téléphonie', 1, 0),
(4, 'vente immobilière', 2, 0),
(5, 'location', 2, 0),
(6, 'colocation', 2, 0),
(7, 'Electroménger', 3, 0),
(8, 'Ameublement', 3, 0),
(9, 'jardinage', 3, 0),
(10, 'moto', 4, 0),
(11, 'voiture', 4, 0),
(12, 'équipement auto', 4, 0),
(13, 'vêtements', 5, 0),
(14, 'chaussures', 5, 0),
(15, 'accéssoires', 5, 0),
(16, 'temp', 6, 1),
(17, 'Fruit', 1, 0),
(18, 'image & son', 2, 0),
(19, 'image & son', 3, 0),
(20, 'consoles', 5, 1),
(21, 'console', 1, 1),
(22, 'console', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `date_inscription` date NOT NULL,
  `tel` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `mdp` varchar(200) NOT NULL,
  `del` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `date_inscription`, `tel`, `email`, `mdp`, `del`) VALUES
(1, 'visiteur', 'visiteur', '2022-01-01', '0666666666', 'visiteur@visiteur.fr', '1234', 0),
(9, 'test', 'test', '2022-09-01', '08t341345234', 'omarbouch901@gmail.com', 'dac5bec37ee707cdadd766b733a3368ef5fed614eb9f0725feb0126483c71608', 0),
(11, 'test', 'testee', '2022-09-01', '07t4223421', 'test@test.fr', 'dac5bec37ee707cdadd766b733a3368ef5fed614eb9f0725feb0126483c71608', 0),
(15, 'julien', 'marc', '2022-09-01', '0945563213', 'm.julien@gmail.com', 'dac5bec37ee707cdadd766b733a3368ef5fed614eb9f0725feb0126483c71608', 0),
(16, 'bouchnayaf', 'omar', '2022-09-03', '0945365647', 'b.omar@gmail.com', 'dac5bec37ee707cdadd766b733a3368ef5fed614eb9f0725feb0126483c71608', 0),
(17, 'esteve', 'lucie', '2022-09-07', '0666420024', 'e.lucie@gmail.com', 'dac5bec37ee707cdadd766b733a3368ef5fed614eb9f0725feb0126483c71608', 0),
(20, 'teest', 'teest', '2022-09-15', '0945365647', 'em.ilie@gmail.com', 'dac5bec37ee707cdadd766b733a3368ef5fed614eb9f0725feb0126483c71608', 0);

-- --------------------------------------------------------

--
-- Structure de la table `visite`
--

CREATE TABLE `visite` (
  `id` int(11) NOT NULL,
  `id_annonce` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date_visite` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `visite`
--

INSERT INTO `visite` (`id`, `id_annonce`, `id_user`, `date_visite`) VALUES
(1, 5, 16, '2022-09-05'),
(2, 16, 16, '2022-09-05'),
(7, 3, 1, '2022-09-05'),
(8, 16, 15, '2022-09-05'),
(9, 16, 15, '2022-09-05'),
(10, 16, 15, '2022-09-05'),
(11, 16, 15, '2022-09-05'),
(12, 16, 15, '2022-09-05'),
(13, 16, 15, '2022-09-05'),
(14, 16, 15, '2022-09-05'),
(15, 16, 15, '2022-09-05'),
(16, 16, 15, '2022-09-05'),
(17, 1, 15, '2022-09-05'),
(18, 3, 15, '2022-09-05'),
(19, 3, 15, '2022-09-05'),
(20, 16, 15, '2022-09-05'),
(21, 16, 15, '2022-09-05'),
(22, 1, 15, '2022-09-05'),
(23, 3, 15, '2022-09-05'),
(24, 3, 15, '2022-09-05'),
(25, 5, 1, '2022-09-05'),
(26, 5, 16, '2022-09-05'),
(27, 5, 16, '2022-09-05'),
(28, 1, 16, '2022-09-05'),
(29, 1, 16, '2022-09-05'),
(30, 5, 1, '2022-09-05'),
(31, 5, 16, '2022-09-05'),
(32, 5, 16, '2022-09-05'),
(33, 5, 16, '2022-09-05'),
(34, 5, 16, '2022-09-05'),
(35, 3, 1, '2022-09-05'),
(36, 5, 16, '2022-09-05'),
(37, 5, 16, '2022-09-05'),
(38, 5, 16, '2022-09-05'),
(39, 5, 16, '2022-09-05'),
(40, 5, 16, '2022-09-05'),
(41, 5, 16, '2022-09-05'),
(42, 5, 16, '2022-09-05'),
(43, 5, 16, '2022-09-05'),
(44, 5, 16, '2022-09-05'),
(45, 5, 16, '2022-09-05'),
(46, 5, 16, '2022-09-05'),
(47, 1, 16, '2022-09-05'),
(48, 1, 16, '2022-09-05'),
(49, 5, 16, '2022-09-05'),
(50, 5, 16, '2022-09-05'),
(51, 3, 16, '2022-09-05'),
(52, 3, 16, '2022-09-05'),
(53, 3, 16, '2022-09-05'),
(54, 5, 16, '2022-09-05'),
(55, 1, 16, '2022-09-05'),
(56, 3, 16, '2022-09-05'),
(57, 5, 16, '2022-09-05'),
(58, 1, 16, '2022-09-05'),
(59, 1, 16, '2022-09-05'),
(60, 1, 16, '2022-09-05'),
(61, 1, 16, '2022-09-05'),
(62, 1, 16, '2022-09-05'),
(63, 1, 16, '2022-09-05'),
(64, 1, 16, '2022-09-05'),
(65, 1, 16, '2022-09-05'),
(66, 3, 1, '2022-09-06'),
(67, 3, 1, '2022-09-06'),
(68, 3, 1, '2022-09-06'),
(69, 3, 1, '2022-09-06'),
(70, 3, 1, '2022-09-06'),
(71, 3, 1, '2022-09-06'),
(72, 3, 1, '2022-09-06'),
(73, 3, 1, '2022-09-06'),
(74, 3, 1, '2022-09-06'),
(75, 3, 1, '2022-09-06'),
(76, 3, 1, '2022-09-06'),
(77, 3, 1, '2022-09-06'),
(78, 3, 1, '2022-09-06'),
(79, 3, 1, '2022-09-06'),
(80, 3, 1, '2022-09-06'),
(81, 3, 1, '2022-09-06'),
(82, 3, 1, '2022-09-06'),
(83, 3, 1, '2022-09-06'),
(84, 3, 1, '2022-09-06'),
(85, 5, 1, '2022-09-06'),
(86, 5, 1, '2022-09-06'),
(87, 5, 1, '2022-09-06'),
(88, 5, 1, '2022-09-06'),
(89, 5, 1, '2022-09-06'),
(90, 5, 1, '2022-09-06'),
(91, 5, 1, '2022-09-06'),
(92, 5, 1, '2022-09-06'),
(93, 5, 1, '2022-09-06'),
(94, 5, 1, '2022-09-06'),
(95, 5, 1, '2022-09-06'),
(96, 5, 1, '2022-09-06'),
(97, 5, 1, '2022-09-06'),
(98, 5, 1, '2022-09-06'),
(99, 5, 1, '2022-09-06'),
(100, 5, 1, '2022-09-06'),
(101, 5, 1, '2022-09-06'),
(102, 5, 1, '2022-09-06'),
(103, 5, 1, '2022-09-06'),
(104, 5, 1, '2022-09-06'),
(105, 5, 1, '2022-09-06'),
(106, 5, 1, '2022-09-06'),
(107, 5, 1, '2022-09-06'),
(108, 5, 1, '2022-09-06'),
(109, 5, 1, '2022-09-06'),
(110, 5, 1, '2022-09-06'),
(111, 5, 1, '2022-09-06'),
(112, 5, 1, '2022-09-06'),
(113, 5, 1, '2022-09-06'),
(114, 5, 1, '2022-09-06'),
(115, 5, 1, '2022-09-06'),
(116, 5, 1, '2022-09-06'),
(117, 5, 1, '2022-09-06'),
(118, 16, 1, '2022-09-06'),
(119, 16, 1, '2022-09-06'),
(120, 16, 1, '2022-09-06'),
(121, 16, 1, '2022-09-06'),
(122, 16, 1, '2022-09-06'),
(123, 5, 1, '2022-09-06'),
(124, 5, 1, '2022-09-06'),
(125, 5, 1, '2022-09-06'),
(126, 5, 1, '2022-09-06'),
(127, 5, 1, '2022-09-06'),
(128, 16, 16, '2022-09-06'),
(129, 16, 16, '2022-09-06'),
(130, 16, 16, '2022-09-06'),
(131, 16, 16, '2022-09-06'),
(132, 16, 16, '2022-09-06'),
(133, 16, 16, '2022-09-06'),
(134, 16, 16, '2022-09-06'),
(135, 16, 16, '2022-09-06'),
(136, 16, 16, '2022-09-06'),
(137, 13, 1, '2022-09-06'),
(138, 13, 1, '2022-09-06'),
(139, 3, 1, '2022-09-06'),
(140, 10, 1, '2022-09-06'),
(141, 4, 16, '2022-09-06'),
(142, 1, 16, '2022-09-06'),
(143, 1, 16, '2022-09-06'),
(144, 1, 16, '2022-09-06'),
(145, 1, 16, '2022-09-06'),
(146, 1, 16, '2022-09-06'),
(147, 16, 16, '2022-09-06'),
(148, 1, 15, '2022-09-06'),
(149, 1, 15, '2022-09-06'),
(150, 1, 15, '2022-09-06'),
(151, 1, 15, '2022-09-06'),
(152, 3, 15, '2022-09-06'),
(153, 12, 15, '2022-09-06'),
(154, 16, 15, '2022-09-06'),
(155, 5, 1, '2022-09-06'),
(156, 5, 1, '2022-09-06'),
(157, 5, 1, '2022-09-06'),
(158, 5, 1, '2022-09-06'),
(159, 5, 1, '2022-09-06'),
(160, 5, 1, '2022-09-06'),
(161, 5, 1, '2022-09-06'),
(162, 5, 1, '2022-09-06'),
(163, 5, 1, '2022-09-06'),
(164, 5, 1, '2022-09-06'),
(165, 5, 1, '2022-09-06'),
(166, 3, 1, '2022-09-06'),
(167, 14, 1, '2022-09-06'),
(168, 12, 1, '2022-09-06'),
(169, 12, 1, '2022-09-06'),
(170, 5, 1, '2022-09-06'),
(171, 5, 1, '2022-09-07'),
(172, 5, 1, '2022-09-07'),
(173, 1, 15, '2022-09-07'),
(174, 1, 15, '2022-09-07'),
(175, 1, 15, '2022-09-07'),
(176, 1, 15, '2022-09-07'),
(177, 1, 15, '2022-09-07'),
(178, 1, 15, '2022-09-07'),
(179, 1, 15, '2022-09-07'),
(180, 1, 15, '2022-09-07'),
(181, 1, 15, '2022-09-07'),
(182, 1, 15, '2022-09-07'),
(183, 1, 15, '2022-09-07'),
(184, 1, 15, '2022-09-07'),
(185, 11, 1, '2022-09-07'),
(186, 5, 16, '2022-09-07'),
(187, 5, 16, '2022-09-07'),
(188, 5, 16, '2022-09-07'),
(189, 5, 15, '2022-09-07'),
(190, 5, 15, '2022-09-07'),
(191, 5, 15, '2022-09-07'),
(192, 5, 15, '2022-09-07'),
(193, 16, 15, '2022-09-07'),
(194, 5, 15, '2022-09-07'),
(195, 5, 15, '2022-09-07'),
(196, 16, 15, '2022-09-07'),
(197, 16, 15, '2022-09-07'),
(198, 5, 15, '2022-09-07'),
(199, 3, 15, '2022-09-07'),
(200, 11, 15, '2022-09-07'),
(201, 12, 15, '2022-09-07'),
(202, 16, 15, '2022-09-07'),
(203, 16, 15, '2022-09-07'),
(204, 16, 15, '2022-09-07'),
(205, 16, 15, '2022-09-07'),
(206, 12, 15, '2022-09-07'),
(207, 16, 15, '2022-09-07'),
(208, 16, 15, '2022-09-07'),
(209, 16, 15, '2022-09-07'),
(210, 16, 15, '2022-09-07'),
(211, 16, 15, '2022-09-07'),
(212, 16, 15, '2022-09-07'),
(213, 16, 15, '2022-09-07'),
(214, 3, 17, '2022-09-07'),
(215, 5, 17, '2022-09-07'),
(216, 5, 17, '2022-09-07'),
(217, 5, 17, '2022-09-07'),
(218, 5, 17, '2022-09-07'),
(219, 3, 15, '2022-09-07'),
(220, 5, 15, '2022-09-07'),
(221, 1, 17, '2022-09-07'),
(222, 1, 17, '2022-09-07'),
(223, 16, 15, '2022-09-08'),
(224, 16, 15, '2022-09-08'),
(225, 5, 15, '2022-09-08'),
(226, 16, 15, '2022-09-08'),
(227, 16, 15, '2022-09-08'),
(228, 16, 15, '2022-09-08'),
(229, 12, 15, '2022-09-08'),
(230, 1, 15, '2022-09-08'),
(231, 5, 15, '2022-09-08'),
(232, 3, 16, '2022-09-08'),
(233, 3, 16, '2022-09-08'),
(234, 1, 17, '2022-09-08'),
(235, 16, 17, '2022-09-08'),
(236, 16, 17, '2022-09-08'),
(237, 16, 15, '2022-09-09'),
(238, 16, 15, '2022-09-09'),
(239, 16, 15, '2022-09-09'),
(240, 16, 15, '2022-09-09'),
(241, 12, 15, '2022-09-09'),
(242, 11, 15, '2022-09-09'),
(243, 5, 15, '2022-09-09'),
(244, 1, 15, '2022-09-09'),
(245, 5, 16, '2022-09-09'),
(246, 5, 16, '2022-09-09'),
(247, 16, 16, '2022-09-09'),
(248, 16, 16, '2022-09-09'),
(249, 16, 15, '2022-09-09'),
(250, 16, 15, '2022-09-09'),
(251, 5, 16, '2022-09-09'),
(252, 5, 16, '2022-09-09'),
(253, 5, 15, '2022-09-09'),
(254, 12, 15, '2022-09-09'),
(255, 11, 15, '2022-09-09'),
(256, 1, 15, '2022-09-09'),
(257, 3, 15, '2022-09-09'),
(258, 5, 15, '2022-09-09'),
(259, 16, 15, '2022-09-09'),
(260, 16, 15, '2022-09-09'),
(261, 16, 15, '2022-09-10'),
(262, 12, 15, '2022-09-10'),
(263, 11, 15, '2022-09-10'),
(264, 1, 15, '2022-09-10'),
(265, 1, 16, '2022-09-10'),
(266, 1, 16, '2022-09-10'),
(267, 1, 15, '2022-09-10'),
(268, 11, 15, '2022-09-10'),
(269, 16, 15, '2022-09-10'),
(270, 11, 15, '2022-09-10'),
(271, 1, 1, '2022-09-11'),
(272, 16, 1, '2022-09-11'),
(273, 5, 1, '2022-09-11'),
(274, 15, 1, '2022-09-11'),
(275, 1, 15, '2022-09-11'),
(276, 1, 15, '2022-09-11'),
(277, 5, 15, '2022-09-12'),
(278, 1, 17, '2022-09-12'),
(279, 22, 15, '2022-09-12'),
(280, 18, 15, '2022-09-12'),
(281, 18, 15, '2022-09-12'),
(282, 18, 15, '2022-09-12'),
(283, 18, 17, '2022-09-12'),
(284, 18, 15, '2022-09-12'),
(285, 21, 15, '2022-09-12'),
(286, 1, 15, '2022-09-12'),
(287, 1, 15, '2022-09-12'),
(288, 22, 1, '2022-09-12'),
(289, 21, 1, '2022-09-12'),
(290, 17, 16, '2022-09-12'),
(291, 17, 16, '2022-09-12'),
(292, 20, 17, '2022-09-12'),
(293, 20, 1, '2022-09-12'),
(294, 20, 15, '2022-09-14'),
(295, 1, 15, '2022-09-14'),
(296, 19, 15, '2022-09-14'),
(297, 11, 15, '2022-09-14'),
(298, 12, 15, '2022-09-14'),
(299, 1, 15, '2022-09-14'),
(300, 20, 16, '2022-09-14'),
(301, 22, 16, '2022-09-14'),
(302, 22, 16, '2022-09-14'),
(303, 22, 16, '2022-09-14'),
(304, 23, 1, '2022-09-16'),
(305, 21, 1, '2022-09-17'),
(306, 25, 1, '2022-09-17'),
(307, 23, 1, '2022-09-17'),
(308, 23, 1, '2022-09-17'),
(309, 23, 1, '2022-09-17'),
(310, 12, 1, '2022-09-17'),
(311, 12, 1, '2022-09-17');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_annonce_souscat` (`id_souscat`),
  ADD KEY `fk_annonce_user` (`id_user`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_contact_user` (`id_user`);

--
-- Index pour la table `conversation`
--
ALTER TABLE `conversation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_conversation_user` (`id_user`);

--
-- Index pour la table `favoris`
--
ALTER TABLE `favoris`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_favoris_user` (`id_user`);

--
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_image_annonce` (`id_annonce`);

--
-- Index pour la table `messagerie`
--
ALTER TABLE `messagerie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_messagerie_annonce` (`id_annonce`),
  ADD KEY `fk_messagerie_userem` (`id_em`),
  ADD KEY `fk_messagerie_userrec` (`id_rec`);

--
-- Index pour la table `recherche`
--
ALTER TABLE `recherche`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_recherche_user` (`id_user`);

--
-- Index pour la table `signalement`
--
ALTER TABLE `signalement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_signalement_user` (`id_user`),
  ADD KEY `fk_signalement_annonce` (`id_annonce`);

--
-- Index pour la table `souscat`
--
ALTER TABLE `souscat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_soucat_cat` (`id_categorie`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `visite`
--
ALTER TABLE `visite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_visite_user` (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `contact`
--
ALTER TABLE `contact`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `conversation`
--
ALTER TABLE `conversation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `favoris`
--
ALTER TABLE `favoris`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT pour la table `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT pour la table `messagerie`
--
ALTER TABLE `messagerie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT pour la table `recherche`
--
ALTER TABLE `recherche`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT pour la table `signalement`
--
ALTER TABLE `signalement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `souscat`
--
ALTER TABLE `souscat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `visite`
--
ALTER TABLE `visite`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=312;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD CONSTRAINT `fk_annonce_souscat` FOREIGN KEY (`id_souscat`) REFERENCES `souscat` (`id`),
  ADD CONSTRAINT `fk_annonce_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `fk_contact_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `conversation`
--
ALTER TABLE `conversation`
  ADD CONSTRAINT `fk_conversation_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `favoris`
--
ALTER TABLE `favoris`
  ADD CONSTRAINT `fk_favoris_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `image`
--
ALTER TABLE `image`
  ADD CONSTRAINT `fk_image_annonce` FOREIGN KEY (`id_annonce`) REFERENCES `annonce` (`id`);

--
-- Contraintes pour la table `messagerie`
--
ALTER TABLE `messagerie`
  ADD CONSTRAINT `fk_messagerie_annonce` FOREIGN KEY (`id_annonce`) REFERENCES `annonce` (`id`),
  ADD CONSTRAINT `fk_messagerie_userem` FOREIGN KEY (`id_em`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `fk_messagerie_userrec` FOREIGN KEY (`id_rec`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `recherche`
--
ALTER TABLE `recherche`
  ADD CONSTRAINT `fk_recherche_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `signalement`
--
ALTER TABLE `signalement`
  ADD CONSTRAINT `fk_signalement_annonce` FOREIGN KEY (`id_annonce`) REFERENCES `annonce` (`id`),
  ADD CONSTRAINT `fk_signalement_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `souscat`
--
ALTER TABLE `souscat`
  ADD CONSTRAINT `fk_soucat_cat` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `fk_visite_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
