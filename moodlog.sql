-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2025 at 10:39 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moodlog`
--

-- --------------------------------------------------------

--
-- Table structure for table `moods`
--

CREATE TABLE `moods` (
  `id_mood` int(100) NOT NULL,
  `id_user` int(100) NOT NULL,
  `timestamp` date NOT NULL,
  `mood` varchar(100) NOT NULL,
  `catatan` varchar(300) NOT NULL,
  `level_mood` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `moods`
--

INSERT INTO `moods` (`id_mood`, `id_user`, `timestamp`, `mood`, `catatan`, `level_mood`) VALUES
(5, 1, '2025-06-01', 'SURPRISED 😱', 'jadi cuyyy', 10),
(6, 1, '2025-06-01', 'SULKING 😤', 'page history ilang mulu anjir', 1),
(7, 1, '2025-06-01', 'LOVELY 😍', 'nasgornya santai kawan enakk', 10),
(11, 1, '2025-06-01', 'HAPPY 😚', 'akhirnya ni projek kelarrrrr', 10),
(12, 2, '2025-06-01', 'HAPPY 😚', 'projeknya kelarrr', 10),
(14, 2, '2025-06-01', 'LOVELY 😍', 'hari ini sukses', 9),
(15, 2, '2025-06-01', 'SULKING 😤', 'ini tuh ada laporannya apa ga sih???', 1),
(16, 3, '2025-06-02', 'SULKING 😤', 'gak punya pacar', 3),
(17, 1, '2025-06-02', 'LOVELY 😍', 'semua berjalan baik', 9),
(18, 1, '2025-06-02', 'HAPPY 😚', 'projek tuntass', 10),
(19, 1, '2025-06-02', 'SULKING 😤', 'namaku dipotong sama pak awang', 7),
(20, 1, '2025-06-02', 'FLUSHED 😳', 'hehe bisaa', 9);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id_user` int(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id_user`, `username`, `password`, `email`) VALUES
(1, 'amanda', 'aman123', 'mand@gmail.com'),
(2, 'aril', 'aril123', 'aril@gmail.com'),
(3, 'pinka', 'pinka123', 'pin@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `moods`
--
ALTER TABLE `moods`
  ADD PRIMARY KEY (`id_mood`),
  ADD KEY `fk_id_user` (`id_user`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username_unique` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `moods`
--
ALTER TABLE `moods`
  MODIFY `id_mood` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `moods`
--
ALTER TABLE `moods`
  ADD CONSTRAINT `fk_id_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
