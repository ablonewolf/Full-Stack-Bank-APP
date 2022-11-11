-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Nov 11, 2022 at 07:13 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `abbank`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `customer_id` int(11) NOT NULL,
  `account_number` int(11) NOT NULL,
  `account_type` varchar(100) NOT NULL,
  `branch_address` varchar(200) NOT NULL,
  `create_dt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`customer_id`, `account_number`, `account_type`, `branch_address`, `create_dt`) VALUES
(2, 2147483646, 'Savings', '123 Main Street, New York', '2022-11-03'),
(1, 2147483647, 'Savings', '123 Main Street, New York', '2022-11-03');

-- --------------------------------------------------------

--
-- Table structure for table `account_transactions`
--

CREATE TABLE `account_transactions` (
  `transaction_id` varchar(200) NOT NULL,
  `account_number` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `transaction_dt` date NOT NULL,
  `transaction_summary` varchar(200) NOT NULL,
  `transaction_type` varchar(100) NOT NULL,
  `transaction_amt` int(11) NOT NULL,
  `closing_balance` int(11) NOT NULL,
  `create_dt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account_transactions`
--

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, `transaction_dt`, `transaction_summary`, `transaction_type`, `transaction_amt`, `closing_balance`, `create_dt`) VALUES
('ffb16580-5a85-11ed-9708-50814072c959', 2147483647, 1, '2022-11-02', 'Coffee Shop', 'Withdrawal', 30, 34500, '2022-11-02'),
('ffb16580-5a85-11ed-9708-50814072d860', 2147483646, 2, '2022-11-02', 'Tea Shop', 'Withdrawal', 30, 34500, '2022-11-02'),
('ffb1dc9b-5a85-11ed-9708-50814072c959', 2147483647, 1, '2022-11-02', 'Uber', 'Withdrawal', 100, 34400, '2022-11-02'),
('ffb1dc9b-5a85-11ed-9708-50814072d860', 2147483646, 2, '2022-11-02', 'DHL', 'Withdrawal', 100, 34400, '2022-11-02'),
('ffb2649e-5a85-11ed-9708-50814072c959', 2147483647, 1, '2022-11-02', 'Self Deposit', 'Deposit', 500, 34900, '2022-11-02'),
('ffb2649e-5a85-11ed-9708-50814072d860', 2147483646, 2, '2022-11-02', 'Self Deposit', 'Deposit', 500, 34900, '2022-11-02'),
('ffb2f93f-5a85-11ed-9708-50814072c959', 2147483647, 1, '2022-11-02', 'Ebay', 'Withdrawal', 600, 34300, '2022-11-02'),
('ffb2f93f-5a85-11ed-9708-50814072d860', 2147483646, 2, '2022-11-02', 'Ebay', 'Withdrawal', 600, 34300, '2022-11-02'),
('ffb36b32-5a85-11ed-9708-50814072c959', 2147483647, 1, '2022-11-01', 'OnlineTransfer', 'Deposit', 700, 35000, '2022-11-01'),
('ffb36b32-5a85-11ed-9708-50814072d860', 2147483646, 2, '2022-11-01', 'OnlineTransfer', 'Deposit', 700, 35000, '2022-11-01'),
('ffb3f6f5-5a85-11ed-9708-50814072c959', 2147483647, 1, '2022-11-02', 'Amazon.com', 'Withdrawal', 100, 34900, '2022-11-02'),
('ffb3f6f5-5a85-11ed-9708-50814072d860', 2147483646, 2, '2022-11-02', 'Amazon.com', 'Withdrawal', 100, 34900, '2022-11-02');

-- --------------------------------------------------------

--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` (`id`, `customer_id`, `name`) VALUES
(11, 1, 'ROLE_USER'),
(12, 1, 'ROLE_ADMIN'),
(13, 2, 'ROLE_USER'),
(14, 4, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

CREATE TABLE `cards` (
  `card_id` int(11) NOT NULL,
  `card_number` varchar(100) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `card_type` varchar(100) NOT NULL,
  `total_limit` int(11) NOT NULL,
  `amount_used` int(11) NOT NULL,
  `available_amount` int(11) NOT NULL,
  `create_dt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`card_id`, `card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `create_dt`) VALUES
(1, '4565XXXX4656', 1, 'Credit', 10000, 500, 9500, '2022-11-03'),
(2, '3455XXXX8673', 1, 'Credit', 7500, 600, 6900, '2022-11-03'),
(3, '2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, '2022-11-03'),
(4, '5565XXXX5656', 2, 'Credit', 10000, 500, 9500, '2022-11-03'),
(5, '3466XXXX8677', 2, 'Credit', 7500, 600, 6900, '2022-11-03'),
(6, '2379XXXX9386', 2, 'Credit', 20000, 4000, 16000, '2022-11-03');

-- --------------------------------------------------------

--
-- Table structure for table `contact_messages`
--

CREATE TABLE `contact_messages` (
  `contact_id` varchar(50) NOT NULL,
  `contact_name` varchar(50) NOT NULL,
  `contact_email` varchar(100) NOT NULL,
  `subject` varchar(500) NOT NULL,
  `message` varchar(2000) NOT NULL,
  `create_dt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `password` varchar(500) NOT NULL,
  `role` varchar(100) NOT NULL,
  `create_dt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_id`, `name`, `email`, `mobile_number`, `password`, `role`, `create_dt`) VALUES
(1, 'Arka Bhuiyan', 'arka.bhuiyan@bjitgroup.com', '9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin', '2022-11-03'),
(2, 'Nipa Howlader', 'nipa.howlader@bjitgroup.com', '9876548340', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'user', '2022-11-03'),
(4, 'Farhan Zaman', 'farhan.zaman@bjitgroup.com', '01712991356', '$2a$10$CRdFUoVhfGwOs6GrSoSpBeKpON2alOGzaK61m.xqHjw4x2021qQgy', 'User', '2022-11-08');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `loans`
--

CREATE TABLE `loans` (
  `loan_number` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `start_dt` date NOT NULL,
  `loan_type` varchar(100) NOT NULL,
  `total_loan` int(11) NOT NULL,
  `amount_paid` int(11) NOT NULL,
  `outstanding_amount` int(11) NOT NULL,
  `create_dt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loans`
--

INSERT INTO `loans` (`loan_number`, `customer_id`, `start_dt`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_dt`) VALUES
(1, 1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13'),
(2, 1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06'),
(3, 1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14'),
(4, 1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14'),
(5, 2, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13'),
(6, 2, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06'),
(7, 2, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14'),
(8, 2, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

-- --------------------------------------------------------

--
-- Table structure for table `notice_details`
--

CREATE TABLE `notice_details` (
  `notice_id` int(11) NOT NULL,
  `notice_summary` varchar(200) NOT NULL,
  `notice_details` varchar(500) NOT NULL,
  `notic_beg_dt` date NOT NULL,
  `notic_end_dt` date DEFAULT NULL,
  `create_dt` date DEFAULT NULL,
  `update_dt` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notice_details`
--

INSERT INTO `notice_details` (`notice_id`, `notice_summary`, `notice_details`, `notic_beg_dt`, `notic_end_dt`, `create_dt`, `update_dt`) VALUES
(1, 'Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately', '2022-10-04', '2022-12-03', '2022-11-03', NULL),
(2, 'Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher', '2022-10-04', '2022-12-03', '2022-11-03', NULL),
(3, 'Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities', '2022-10-04', '2022-12-03', '2022-11-03', NULL),
(4, 'E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction', '2022-10-04', '2022-12-03', '2022-11-03', NULL),
(5, 'Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase', '2022-10-04', '2022-12-03', '2022-11-03', NULL),
(6, 'COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details', '2022-10-04', '2022-12-03', '2022-11-03', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`account_number`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `account_transactions`
--
ALTER TABLE `account_transactions`
  ADD PRIMARY KEY (`transaction_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `account_number` (`account_number`);

--
-- Indexes for table `authorities`
--
ALTER TABLE `authorities`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`card_id`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `contact_messages`
--
ALTER TABLE `contact_messages`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `loans`
--
ALTER TABLE `loans`
  ADD PRIMARY KEY (`loan_number`),
  ADD KEY `customer_id` (`customer_id`);

--
-- Indexes for table `notice_details`
--
ALTER TABLE `notice_details`
  ADD PRIMARY KEY (`notice_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `authorities`
--
ALTER TABLE `authorities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `cards`
--
ALTER TABLE `cards`
  MODIFY `card_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `loans`
--
ALTER TABLE `loans`
  MODIFY `loan_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `notice_details`
--
ALTER TABLE `notice_details`
  MODIFY `notice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accounts`
--
ALTER TABLE `accounts`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE;

--
-- Constraints for table `account_transactions`
--
ALTER TABLE `account_transactions`
  ADD CONSTRAINT `accounts_ibfk_2` FOREIGN KEY (`account_number`) REFERENCES `accounts` (`account_number`) ON DELETE CASCADE,
  ADD CONSTRAINT `acct_user_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE;

--
-- Constraints for table `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`);

--
-- Constraints for table `cards`
--
ALTER TABLE `cards`
  ADD CONSTRAINT `card_customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE;

--
-- Constraints for table `loans`
--
ALTER TABLE `loans`
  ADD CONSTRAINT `loan_customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
