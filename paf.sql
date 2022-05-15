-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306:8111
-- Generation Time: May 15, 2022 at 02:59 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paf`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `itemID` int(11) NOT NULL,
  `itemCode` varchar(10) NOT NULL,
  `itemName` varchar(30) NOT NULL,
  `itemPrice` decimal(5,2) NOT NULL,
  `itemDesc` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`itemID`, `itemCode`, `itemName`, `itemPrice`, `itemDesc`) VALUES
(3, '102', 'aaaa', '200.00', 'bbbb'),
(4, 'm102', 'm_aaaa', '200.00', 'm_bbbb'),
(6, '101', 'Biscuit', '100.00', 'Munchee Tikiri Marie'),
(8, '103', 'Milk', '210.00', 'E.H. Fresh Milk');

-- --------------------------------------------------------

--
-- Table structure for table `powergenerators`
--

CREATE TABLE `powergenerators` (
  `gID` int(11) NOT NULL,
  `gCode` varchar(6) NOT NULL,
  `gName` varchar(25) NOT NULL,
  `gType` varchar(25) NOT NULL,
  `gLocation` varchar(25) NOT NULL,
  `gUnitPrice` decimal(5,2) NOT NULL,
  `gRegDate` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `powergenerators`
--

INSERT INTO `powergenerators` (`gID`, `gCode`, `gName`, `gType`, `gLocation`, `gUnitPrice`, `gRegDate`) VALUES
(8, 'g1025', 'Kothmale', 'Hydroelectric', 'Kothmale', '25.75', '2015-10-25'),
(31, 'g1792', 'ColomboPort', 'Oil-fired', 'Colombo', '27.50', '2017-04-10'),
(32, 'g4236', 'Sampur', 'Coal-fired', 'Trincomalee', '26.20', '2019-06-21'),
(33, 'g2553', 'Sapugaskanda', 'Oil-fired', 'Sapugaskanda', '24.40', '2020-02-28');

-- --------------------------------------------------------

--
-- Table structure for table `reg_cus_billing`
--

CREATE TABLE `reg_cus_billing` (
  `invoiceNo` int(5) NOT NULL,
  `date` date NOT NULL,
  `cusName` varchar(25) NOT NULL,
  `accNo` int(8) NOT NULL,
  `noOfUnits` int(11) NOT NULL,
  `unitPrice` double NOT NULL,
  `tax` double NOT NULL,
  `totalAmount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `powergenerators`
--
ALTER TABLE `powergenerators`
  ADD PRIMARY KEY (`gID`);

--
-- Indexes for table `reg_cus_billing`
--
ALTER TABLE `reg_cus_billing`
  ADD PRIMARY KEY (`invoiceNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `powergenerators`
--
ALTER TABLE `powergenerators`
  MODIFY `gID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `reg_cus_billing`
--
ALTER TABLE `reg_cus_billing`
  MODIFY `invoiceNo` int(5) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
