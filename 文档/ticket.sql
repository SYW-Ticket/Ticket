/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ticket

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-05 14:53:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `actor`
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(20) NOT NULL,
  `actor_photo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of actor
-- ----------------------------

-- ----------------------------
-- Table structure for `actor_film_details_chose`
-- ----------------------------
DROP TABLE IF EXISTS `actor_film_details_chose`;
CREATE TABLE `actor_film_details_chose` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actor_id` int(11) NOT NULL,
  `film_details_id` int(11) NOT NULL,
  `main_actor_flag` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_b` (`actor_id`),
  KEY `fk_g` (`film_details_id`),
  CONSTRAINT `fk_b` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`),
  CONSTRAINT `fk_g` FOREIGN KEY (`film_details_id`) REFERENCES `film_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of actor_film_details_chose
-- ----------------------------

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(30) NOT NULL,
  `admin_password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for `area`
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(50) NOT NULL,
  `city_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of area
-- ----------------------------

-- ----------------------------
-- Table structure for `cinema`
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_name` varchar(50) NOT NULL,
  `cinema_adress` varchar(100) NOT NULL,
  `cinema_tel` int(11) NOT NULL,
  `area_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_a` (`area_id`),
  CONSTRAINT `fk_a` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cinema
-- ----------------------------

-- ----------------------------
-- Table structure for `drama`
-- ----------------------------
DROP TABLE IF EXISTS `drama`;
CREATE TABLE `drama` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_details_id` int(11) NOT NULL,
  `drama_name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_h` (`film_details_id`),
  CONSTRAINT `fk_h` FOREIGN KEY (`film_details_id`) REFERENCES `film_details` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of drama
-- ----------------------------

-- ----------------------------
-- Table structure for `film`
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_img` varchar(50) NOT NULL,
  `film_name` varchar(50) NOT NULL,
  `film_score` int(11) DEFAULT NULL,
  `film_price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of film
-- ----------------------------

-- ----------------------------
-- Table structure for `film_details`
-- ----------------------------
DROP TABLE IF EXISTS `film_details`;
CREATE TABLE `film_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `details` varchar(100) NOT NULL,
  `film_start_date` varchar(100) NOT NULL,
  `director` varchar(20) NOT NULL,
  `synopsis` varchar(200) DEFAULT NULL,
  `film_end_date` varchar(200) DEFAULT NULL,
  `film_length` varchar(50) NOT NULL,
  `language` varchar(20) NOT NULL,
  `3DLV` varchar(20) DEFAULT NULL,
  `trailer_address` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_key` (`film_id`),
  CONSTRAINT `fk_key` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of film_details
-- ----------------------------

-- ----------------------------
-- Table structure for `film_label_chose`
-- ----------------------------
DROP TABLE IF EXISTS `film_label_chose`;
CREATE TABLE `film_label_chose` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_label` (`label_id`),
  KEY `fk_film` (`film_id`),
  CONSTRAINT `fk_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
  CONSTRAINT `fk_label` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of film_label_chose
-- ----------------------------

-- ----------------------------
-- Table structure for `film_type_chose`
-- ----------------------------
DROP TABLE IF EXISTS `film_type_chose`;
CREATE TABLE `film_type_chose` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_1` (`film_id`),
  KEY `fk_2` (`type_id`),
  CONSTRAINT `fk_1` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
  CONSTRAINT `fk_2` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of film_type_chose
-- ----------------------------

-- ----------------------------
-- Table structure for `hall`
-- ----------------------------
DROP TABLE IF EXISTS `hall`;
CREATE TABLE `hall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hall_name` varchar(50) NOT NULL,
  `row_max` int(11) NOT NULL,
  `col_max` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hall
-- ----------------------------

-- ----------------------------
-- Table structure for `hyper_admin`
-- ----------------------------
DROP TABLE IF EXISTS `hyper_admin`;
CREATE TABLE `hyper_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hyper_admin_username` varchar(30) NOT NULL,
  `hyper_admin_password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hyper_admin
-- ----------------------------

-- ----------------------------
-- Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of label
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) NOT NULL,
  `seat_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  `ticket_num` int(11) NOT NULL,
  `price` double NOT NULL,
  `total_price` double NOT NULL,
  `order_time` datetime NOT NULL,
  `cost_state` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userid` (`user_id`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `platoon`
-- ----------------------------
DROP TABLE IF EXISTS `platoon`;
CREATE TABLE `platoon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `show_start_time` datetime NOT NULL,
  `hall_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_y` (`film_id`),
  KEY `fk_x` (`hall_id`),
  CONSTRAINT `fk_x` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`),
  CONSTRAINT `fk_y` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of platoon
-- ----------------------------

-- ----------------------------
-- Table structure for `seat`
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hall_id` int(11) NOT NULL,
  `flag` int(11) NOT NULL,
  `row` int(11) NOT NULL,
  `col` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_q` (`hall_id`),
  CONSTRAINT `fk_q` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of seat
-- ----------------------------

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of type
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tel` varchar(20) NOT NULL,
  `money` int(11) DEFAULT NULL,
  `acount` varchar(20) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
