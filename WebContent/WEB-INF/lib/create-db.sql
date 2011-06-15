-- phpMyAdmin SQL Dump
-- version 2.11.6
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: Dec 24, 2008 at 10:54 AM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- Database: `jitter`
--
CREATE DATABASE IF NOT EXISTS `jitter`;
USE `jitter`;
-- --------------------------------------------------------

--
-- User creation for database `jitter`
--
CREATE USER 'jitter'@'%' IDENTIFIED BY 'j1tt3r';
GRANT ALL PRIVILEGES ON *.* TO 'jitter'@'%' WITH GRANT OPTION;

--
-- Table structure for table `authorities`
--

CREATE TABLE IF NOT EXISTS `Authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `Authorities` (`username`, `authority`) VALUES
('dave', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE IF NOT EXISTS `Post` (
  `id` int(11) NOT NULL auto_increment,
  `author` int(11) NOT NULL,
  `body` varchar(140) NOT NULL,
  `date` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`),
  KEY `author` (`author`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `post`
--

INSERT INTO `Post` (`id`, `author`, `body`, `date`) VALUES
(6, 1, 'Just going out to take some photos ;)', '2008-09-25 11:25:36'),
(7, 1, 'Got UV Filter for Canon 350D', '2008-11-13 14:43:53');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `User` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `photo` varchar(20) default NULL,
  PRIMARY KEY  (`id`,`username`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user`
--

INSERT INTO `User` (`id`, `username`, `email`, `firstName`, `lastName`, `photo`) VALUES
(1, 'dave', 'dave@harris.org.nz', 'Dave', 'Harris', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `username` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` bit(1) NOT NULL default b'0',
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `Users` (`username`, `password`, `enabled`) VALUES
('dave', 'dave', b'1');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorities`
--
ALTER TABLE `Authorities`
  ADD CONSTRAINT `Authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `User` (`username`);

--
-- Constraints for table `post`
--
ALTER TABLE `Post`
  ADD CONSTRAINT `Post_ibfk_1` FOREIGN KEY (`author`) REFERENCES `User` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `Users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`username`) REFERENCES `User` (`username`);
