-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema resumebuilder
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ resumebuilder;
USE resumebuilder;

--
-- Table structure for table `resumebuilder`.`achievement`
--

DROP TABLE IF EXISTS `achievement`;
CREATE TABLE `achievement` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `user_id` int(10) unsigned NOT NULL default '0',
  `name` varchar(400) NOT NULL default '',
  `title` varchar(300) NOT NULL default '',
  `place` varchar(45) NOT NULL default '',
  `ach_date` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resumebuilder`.`achievement`
--

/*!40000 ALTER TABLE `achievement` DISABLE KEYS */;
/*!40000 ALTER TABLE `achievement` ENABLE KEYS */;


--
-- Table structure for table `resumebuilder`.`eductional_details`
--

DROP TABLE IF EXISTS `eductional_details`;
CREATE TABLE `eductional_details` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `user_id` int(10) unsigned NOT NULL default '0',
  `name` varchar(45) NOT NULL default '',
  `degree` varchar(45) NOT NULL default '',
  `subject` varchar(45) NOT NULL default '',
  `year` varchar(45) NOT NULL default '',
  `board_or_university` varchar(45) NOT NULL default '',
  `obtained_marks` varchar(20) NOT NULL default '0',
  `total_marks` varchar(20) NOT NULL default '0',
  `percentage` varchar(20) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resumebuilder`.`eductional_details`
--

/*!40000 ALTER TABLE `eductional_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `eductional_details` ENABLE KEYS */;


--
-- Table structure for table `resumebuilder`.`experience`
--

DROP TABLE IF EXISTS `experience`;
CREATE TABLE `experience` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `user_id` int(10) unsigned NOT NULL default '0',
  `employer` varchar(45) NOT NULL default '',
  `designation` varchar(45) NOT NULL default '',
  `joining_date` varchar(13) NOT NULL default '',
  `leaving_date` varchar(13) NOT NULL default '',
  `work` varchar(200) NOT NULL default '',
  `experience` varchar(500) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resumebuilder`.`experience`
--

/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;


--
-- Table structure for table `resumebuilder`.`participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE `participation` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `user_id` int(10) unsigned NOT NULL default '0',
  `part_name` varchar(45) NOT NULL default '',
  `start_date` varchar(45) NOT NULL default '',
  `end_date` varchar(45) NOT NULL default '',
  `sponsores` varchar(45) NOT NULL default '',
  `note` varchar(1000) NOT NULL default '',
  `topic` varchar(200) NOT NULL default '',
  `place` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resumebuilder`.`participation`
--

/*!40000 ALTER TABLE `participation` DISABLE KEYS */;
/*!40000 ALTER TABLE `participation` ENABLE KEYS */;


--
-- Table structure for table `resumebuilder`.`personal_details`
--

DROP TABLE IF EXISTS `personal_details`;
CREATE TABLE `personal_details` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `father_name` varchar(45) NOT NULL default '',
  `sex` varchar(45) NOT NULL default '',
  `dob` varchar(20) NOT NULL default '',
  `age` int(10) unsigned NOT NULL default '0',
  `contact` varchar(20) NOT NULL default '',
  `marital_status` varchar(45) NOT NULL default '',
  `address` varchar(100) NOT NULL default '',
  `email_id` varchar(45) NOT NULL default '',
  `langauge_proficiencies` varchar(75) NOT NULL default '',
  `mother_name` varchar(45) NOT NULL default '',
  `nationality` varchar(45) NOT NULL default '',
  `career_objectives` varchar(150) NOT NULL default '',
  `strength` varchar(100) NOT NULL default '',
  `hobbies` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resumebuilder`.`personal_details`
--

/*!40000 ALTER TABLE `personal_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_details` ENABLE KEYS */;


--
-- Table structure for table `resumebuilder`.`projects`
--

DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `user_id` int(10) unsigned NOT NULL default '0',
  `title` varchar(100) NOT NULL default '',
  `guide` varchar(100) NOT NULL default '',
  `front_end` varchar(100) NOT NULL default '',
  `back_end` varchar(100) NOT NULL default '',
  `input` varchar(1000) NOT NULL default '',
  `output` varchar(1000) NOT NULL default '',
  `description` varchar(1000) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resumebuilder`.`projects`
--

/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;


--
-- Table structure for table `resumebuilder`.`reference`
--

DROP TABLE IF EXISTS `reference`;
CREATE TABLE `reference` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `designation` varchar(45) NOT NULL default '',
  `affilation` varchar(45) NOT NULL default '',
  `email` varchar(45) NOT NULL default '',
  `contact_no` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resumebuilder`.`reference`
--

/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
/*!40000 ALTER TABLE `reference` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
