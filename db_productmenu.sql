-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2025 at 11:14 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_productmenu`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` varchar(255) NOT NULL,
  `judul` varchar(255) NOT NULL,
  `jenis` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `judul`, `jenis`, `genre`, `harga`) VALUES
('B001', 'Laskar Pelangi', 'Fiksi', 'Fantasi', 85000),
('B002', 'Filosofi Teras', 'Non-Fiksi', 'Filsafat', 98000),
('B003', 'Naruto Vol.1', 'Fiksi', 'Fantasi', 45000),
('B004', 'Matematika SMA', 'Non-Fiksi', 'Sains', 60000),
('B005', 'Omniscient Reader’s Viewpoint Vol.3', 'Fiksi', 'Fantasi', 123000),
('B007', 'Attack on Titan Vol.4', 'Fiksi', 'Aksi', 70000),
('B008', 'Jujutsu Kaisen', 'Fiksi', 'Aksi', 45000),
('B009', 'Jujur kasihan', 'Non-Fiksi', 'Sosial', 20000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
