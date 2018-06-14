/*
 Navicat MySQL Data Transfer

 Source Server         : aliyunMain
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : 119.23.42.247:3306
 Source Schema         : ticket

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 12/06/2018 20:36:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actor
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actor_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `actor_photo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of actor
-- ----------------------------
INSERT INTO `actor` VALUES (1, '周润发', 'fage.jpg');
INSERT INTO `actor` VALUES (2, '发哥', 'fage.jpg');

-- ----------------------------
-- Table structure for actor_film_details_chose
-- ----------------------------
DROP TABLE IF EXISTS `actor_film_details_chose`;
CREATE TABLE `actor_film_details_chose`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `actor_id` int(11) NOT NULL,
  `film_details_id` int(11) NOT NULL,
  `main_actor_flag` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_b`(`actor_id`) USING BTREE,
  INDEX `fk_g`(`film_details_id`) USING BTREE,
  CONSTRAINT `fk_b` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_g` FOREIGN KEY (`film_details_id`) REFERENCES `film_details` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of actor_film_details_chose
-- ----------------------------
INSERT INTO `actor_film_details_chose` VALUES (1, 1, 1, 1);
INSERT INTO `actor_film_details_chose` VALUES (2, 2, 1, 1);

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `city_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '江岸区', '武汉');
INSERT INTO `area` VALUES (2, '江夏区', '武汉');

-- ----------------------------
-- Table structure for cinema
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cinema_adress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cinema_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `area_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_a`(`area_id`) USING BTREE,
  CONSTRAINT `fk_a` FOREIGN KEY (`area_id`) REFERENCES `area` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cinema
-- ----------------------------
INSERT INTO `cinema` VALUES (1, '武汉紫星影城', '武汉江岸区台北路153号（原武汉影城3F', '027-85683333', 1);
INSERT INTO `cinema` VALUES (2, '武汉百丽宫影城(壹方店)', '武汉江岸区中山大道1515号壹方购物中心', '027-82902166', 1);
INSERT INTO `cinema` VALUES (3, '明星时代影城', '武汉江岸区后湖大道与百步亭交汇处华林广场1-2层', '027-82607066', 1);

-- ----------------------------
-- Table structure for drama
-- ----------------------------
DROP TABLE IF EXISTS `drama`;
CREATE TABLE `drama`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_details_id` int(11) NOT NULL,
  `drama_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_h`(`film_details_id`) USING BTREE,
  CONSTRAINT `fk_h` FOREIGN KEY (`film_details_id`) REFERENCES `film_details` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for f_order
-- ----------------------------
DROP TABLE IF EXISTS `f_order`;
CREATE TABLE `f_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ticket_num` int(11) NOT NULL,
  `total_price` double NULL DEFAULT NULL,
  `order_time` datetime(0) NOT NULL,
  `cost_state` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `platoon_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_userid`(`user_id`) USING BTREE,
  CONSTRAINT `fk_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of f_order
-- ----------------------------
INSERT INTO `f_order` VALUES (1, 1, 43.5, '2018-06-09 15:32:23', 1, 1, 1);
INSERT INTO `f_order` VALUES (2, 1, 3, '2018-06-06 11:14:55', 0, 1, 1);
INSERT INTO `f_order` VALUES (4, 2, 2000, '2018-06-12 11:29:02', 0, 1, 1);
INSERT INTO `f_order` VALUES (6, 2, 87, '2018-06-12 19:19:17', 0, 2, 1);
INSERT INTO `f_order` VALUES (7, 2, 87, '2018-06-12 19:37:59', 0, 2, 1);
INSERT INTO `f_order` VALUES (8, 2, 87, '2018-06-12 19:55:16', 0, 3, 1);
INSERT INTO `f_order` VALUES (9, 2, 87, '2018-06-12 20:03:37', 2, 2, 1);

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `film_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `film_score` int(11) NULL DEFAULT NULL,
  `film_hot` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES (1, 'test_film.jpg', '超时空同居', 9, 168);
INSERT INTO `film` VALUES (2, '1212', '凄凄切切', 1, 2);
INSERT INTO `film` VALUES (3, '1212', '驱蚊器无', 1, 1);
INSERT INTO `film` VALUES (4, '12312', '我QQ1', 1, 0);
INSERT INTO `film` VALUES (5, '121', '申请王群', 1, 0);
INSERT INTO `film` VALUES (6, '1231', '我QQ二', 1, 6);
INSERT INTO `film` VALUES (7, '1213', '恩奇都群', 1, 0);
INSERT INTO `film` VALUES (8, '1212', '万千瓦', 1, 0);
INSERT INTO `film` VALUES (9, '212', '切尔奇二群', 1, 0);
INSERT INTO `film` VALUES (10, '1212', '驱蚊器', 1, 0);
INSERT INTO `film` VALUES (11, '12131', '亲亲我', 1, 0);
INSERT INTO `film` VALUES (12, '12113', '二七区多', 1, 0);

-- ----------------------------
-- Table structure for film_details
-- ----------------------------
DROP TABLE IF EXISTS `film_details`;
CREATE TABLE `film_details`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `details` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `film_start_date` date NULL DEFAULT NULL,
  `director` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `synopsis` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `film_end_date` date NULL DEFAULT NULL,
  `film_length` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `language` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `3DLV` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `trailer_address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_key`(`film_id`) USING BTREE,
  CONSTRAINT `fk_key` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of film_details
-- ----------------------------
INSERT INTO `film_details` VALUES (1, 1, '你喜欢什么面，我喜欢你的心里面', '2018-06-05', '王鹏', '一个想骗钱反被骗的2018年失意女青年谷小焦（佟丽娅饰），一个竭尽全力拉投资却卷进害老板事件的1999年陆鸣（雷佳音饰），一觉醒来时空发生重叠两人睡在一张床上，更惊喜的是两人通过自己的房门可以将对方带到自己的年代。一系列投机作弊的合伙行为引发种种爆笑事件，可他们却不知道他俩紧密的宿命联系竟然掌握在早就知道这一切的神秘人手里 [4]  ', NULL, '100', '国语', '3d', NULL);
INSERT INTO `film_details` VALUES (2, 2, '2', '2018-06-05', '2', '2', NULL, '100', '英语', '2d', NULL);
INSERT INTO `film_details` VALUES (3, 3, '3', '2018-06-05', '3', '3', NULL, '100', '泰语', '3d', NULL);
INSERT INTO `film_details` VALUES (4, 4, '4', '2018-06-05', '4', '4', NULL, '100', '俄语', '3d', NULL);
INSERT INTO `film_details` VALUES (5, 5, '5', '2018-06-05', '5', '5', NULL, '100', '韩语', '2d', NULL);
INSERT INTO `film_details` VALUES (6, 6, '6', '2018-06-05', '6', '6', NULL, '100', '法语', '2d', NULL);
INSERT INTO `film_details` VALUES (7, 7, '7', '2018-06-30', '7', '7', NULL, '100', '德语', '4d', NULL);
INSERT INTO `film_details` VALUES (8, 8, '8', '2018-06-30', '8', '8', NULL, '100', '日语', '2d', NULL);
INSERT INTO `film_details` VALUES (9, 9, '9', '2018-06-30', '9', '9', NULL, '100', '日语', '3d', NULL);
INSERT INTO `film_details` VALUES (10, 10, '10', '2018-06-30', '10', '10', NULL, '100', '德语', '4d', NULL);
INSERT INTO `film_details` VALUES (11, 11, '11', '2018-06-30', '11', '11', NULL, '100', '英语', '2d', NULL);
INSERT INTO `film_details` VALUES (12, 12, '12', '2018-06-30', '12', '12', NULL, '100', '国语', '3d', NULL);

-- ----------------------------
-- Table structure for film_label_chose
-- ----------------------------
DROP TABLE IF EXISTS `film_label_chose`;
CREATE TABLE `film_label_chose`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_label`(`label_id`) USING BTREE,
  INDEX `fk_film`(`film_id`) USING BTREE,
  CONSTRAINT `fk_film` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_label` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for film_type_chose
-- ----------------------------
DROP TABLE IF EXISTS `film_type_chose`;
CREATE TABLE `film_type_chose`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) NOT NULL,
  `film_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_1`(`film_id`) USING BTREE,
  INDEX `fk_2`(`type_id`) USING BTREE,
  CONSTRAINT `fk_1` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_2` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for hall
-- ----------------------------
DROP TABLE IF EXISTS `hall`;
CREATE TABLE `hall`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hall_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `row_max` int(11) NOT NULL,
  `col_max` int(11) NOT NULL,
  `cinema_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_j`(`cinema_id`) USING BTREE,
  CONSTRAINT `fk_j` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hall
-- ----------------------------
INSERT INTO `hall` VALUES (1, '7号厅', 12, 7, 2);

-- ----------------------------
-- Table structure for hyper_admin
-- ----------------------------
DROP TABLE IF EXISTS `hyper_admin`;
CREATE TABLE `hyper_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hyper_admin_username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `hyper_admin_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for platoon
-- ----------------------------
DROP TABLE IF EXISTS `platoon`;
CREATE TABLE `platoon`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) NOT NULL,
  `show_start_time` datetime(0) NOT NULL,
  `hall_id` int(11) NOT NULL,
  `film_price` double NULL DEFAULT NULL,
  `show_start_date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_y`(`film_id`) USING BTREE,
  INDEX `fk_x`(`hall_id`) USING BTREE,
  CONSTRAINT `fk_x` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_y` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of platoon
-- ----------------------------
INSERT INTO `platoon` VALUES (1, 1, '2018-06-12 15:20:00', 1, 43.5, '2018-06-12');
INSERT INTO `platoon` VALUES (2, 1, '2018-06-12 17:05:08', 1, 43.5, '2018-06-12');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hall_id` int(11) NOT NULL,
  `flag` int(11) NOT NULL,
  `row` int(11) NOT NULL,
  `col` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_q`(`hall_id`) USING BTREE,
  CONSTRAINT `fk_q` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (1, 1, 1, 1, 1, '1排1号');
INSERT INTO `seat` VALUES (2, 1, 1, 1, 2, '1排2号');
INSERT INTO `seat` VALUES (3, 1, 1, 1, 3, '1排3号');
INSERT INTO `seat` VALUES (4, 1, 1, 1, 4, '1排4号');
INSERT INTO `seat` VALUES (5, 1, 1, 1, 5, '1排5号');
INSERT INTO `seat` VALUES (6, 1, 1, 1, 6, '1排6号');
INSERT INTO `seat` VALUES (7, 1, 1, 1, 7, '1排7号');
INSERT INTO `seat` VALUES (8, 1, 1, 1, 8, '1排8号');
INSERT INTO `seat` VALUES (9, 1, 1, 1, 9, '1排9号');
INSERT INTO `seat` VALUES (10, 1, 1, 1, 10, '1排10号');
INSERT INTO `seat` VALUES (11, 1, 0, 1, 11, '无');
INSERT INTO `seat` VALUES (12, 1, 0, 1, 12, '无');
INSERT INTO `seat` VALUES (13, 1, 1, 2, 1, '2排1号');
INSERT INTO `seat` VALUES (14, 1, 1, 2, 2, '2排2号');
INSERT INTO `seat` VALUES (15, 1, 1, 2, 3, '2排3号');
INSERT INTO `seat` VALUES (16, 1, 1, 2, 4, '2排4号');
INSERT INTO `seat` VALUES (17, 1, 1, 2, 5, '2排5号');
INSERT INTO `seat` VALUES (18, 1, 1, 2, 6, '2排6号');
INSERT INTO `seat` VALUES (19, 1, 1, 2, 7, '2排7号');
INSERT INTO `seat` VALUES (20, 1, 1, 2, 8, '2排8号');
INSERT INTO `seat` VALUES (21, 1, 1, 2, 9, '2排9号');
INSERT INTO `seat` VALUES (22, 1, 1, 2, 10, '2排10号');
INSERT INTO `seat` VALUES (23, 1, 0, 2, 11, '无');
INSERT INTO `seat` VALUES (24, 1, 0, 2, 12, '无');
INSERT INTO `seat` VALUES (25, 1, 1, 3, 1, '3排1号');
INSERT INTO `seat` VALUES (26, 1, 1, 3, 2, '3排2号');
INSERT INTO `seat` VALUES (27, 1, 1, 3, 3, '3排3号');
INSERT INTO `seat` VALUES (28, 1, 1, 3, 4, '3排4号');
INSERT INTO `seat` VALUES (29, 1, 1, 3, 5, '3排5号');
INSERT INTO `seat` VALUES (30, 1, 1, 3, 6, '3排6号');
INSERT INTO `seat` VALUES (31, 1, 1, 3, 7, '3排7号');
INSERT INTO `seat` VALUES (32, 1, 1, 3, 8, '3排8号');
INSERT INTO `seat` VALUES (33, 1, 1, 3, 9, '3排9号');
INSERT INTO `seat` VALUES (34, 1, 1, 3, 10, '3排10号');
INSERT INTO `seat` VALUES (35, 1, 0, 3, 11, '无');
INSERT INTO `seat` VALUES (36, 1, 0, 3, 12, '无');
INSERT INTO `seat` VALUES (37, 1, 1, 4, 1, '4排1号');
INSERT INTO `seat` VALUES (38, 1, 1, 4, 2, '4排2号');
INSERT INTO `seat` VALUES (39, 1, 1, 4, 3, '4排3号');
INSERT INTO `seat` VALUES (40, 1, 1, 4, 4, '4排4号');
INSERT INTO `seat` VALUES (41, 1, 1, 4, 5, '4排5号');
INSERT INTO `seat` VALUES (42, 1, 1, 4, 6, '4排6号');
INSERT INTO `seat` VALUES (43, 1, 1, 4, 7, '4排7号');
INSERT INTO `seat` VALUES (44, 1, 1, 4, 8, '4排8号');
INSERT INTO `seat` VALUES (45, 1, 1, 4, 9, '4排9号');
INSERT INTO `seat` VALUES (46, 1, 1, 4, 10, '4排10号');
INSERT INTO `seat` VALUES (47, 1, 0, 4, 11, '无');
INSERT INTO `seat` VALUES (48, 1, 0, 4, 12, '无');
INSERT INTO `seat` VALUES (49, 1, 1, 5, 1, '5排1号');
INSERT INTO `seat` VALUES (50, 1, 1, 5, 2, '5排2号');
INSERT INTO `seat` VALUES (51, 1, 1, 5, 3, '5排3号');
INSERT INTO `seat` VALUES (52, 1, 1, 5, 4, '5排4号');
INSERT INTO `seat` VALUES (53, 1, 1, 5, 5, '5排5号');
INSERT INTO `seat` VALUES (54, 1, 1, 5, 6, '5排6号');
INSERT INTO `seat` VALUES (55, 1, 1, 5, 7, '5排7号');
INSERT INTO `seat` VALUES (56, 1, 1, 5, 8, '5排8号');
INSERT INTO `seat` VALUES (57, 1, 1, 5, 9, '5排9号');
INSERT INTO `seat` VALUES (58, 1, 1, 5, 10, '5排10号');
INSERT INTO `seat` VALUES (59, 1, 0, 5, 11, '无');
INSERT INTO `seat` VALUES (60, 1, 0, 5, 12, '无');
INSERT INTO `seat` VALUES (61, 1, 1, 6, 1, '6排1号');
INSERT INTO `seat` VALUES (62, 1, 1, 6, 2, '6排2号');
INSERT INTO `seat` VALUES (63, 1, 1, 6, 3, '6排3号');
INSERT INTO `seat` VALUES (64, 1, 1, 6, 4, '6排4号');
INSERT INTO `seat` VALUES (65, 1, 1, 6, 5, '6排5号');
INSERT INTO `seat` VALUES (66, 1, 1, 6, 6, '6排6号');
INSERT INTO `seat` VALUES (67, 1, 1, 6, 7, '6排7号');
INSERT INTO `seat` VALUES (68, 1, 1, 6, 8, '6排8号');
INSERT INTO `seat` VALUES (69, 1, 1, 6, 9, '6排9号');
INSERT INTO `seat` VALUES (70, 1, 1, 6, 10, '6排10号');
INSERT INTO `seat` VALUES (71, 1, 1, 6, 11, '6排11号');
INSERT INTO `seat` VALUES (72, 1, 0, 6, 12, '无');
INSERT INTO `seat` VALUES (73, 1, 1, 7, 1, '7排1号');
INSERT INTO `seat` VALUES (74, 1, 1, 7, 2, '7排2号');
INSERT INTO `seat` VALUES (75, 1, 1, 7, 3, '7排3号');
INSERT INTO `seat` VALUES (76, 1, 1, 7, 4, '7排4号');
INSERT INTO `seat` VALUES (77, 1, 1, 7, 5, '7排5号');
INSERT INTO `seat` VALUES (78, 1, 1, 7, 6, '7排6号');
INSERT INTO `seat` VALUES (79, 1, 1, 7, 7, '7排7号');
INSERT INTO `seat` VALUES (80, 1, 1, 7, 8, '7排8号');
INSERT INTO `seat` VALUES (81, 1, 1, 7, 9, '7排9号');
INSERT INTO `seat` VALUES (82, 1, 1, 7, 10, '7排10号');
INSERT INTO `seat` VALUES (83, 1, 1, 7, 11, '7排11号');
INSERT INTO `seat` VALUES (84, 1, 1, 7, 12, '7排12号');

-- ----------------------------
-- Table structure for seat_occupied
-- ----------------------------
DROP TABLE IF EXISTS `seat_occupied`;
CREATE TABLE `seat_occupied`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `seat_occupied` int(11) NOT NULL,
  `seat_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_pp`(`seat_id`) USING BTREE,
  INDEX `fk_oo`(`order_id`) USING BTREE,
  CONSTRAINT `fk_oo` FOREIGN KEY (`order_id`) REFERENCES `f_order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_pp` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of seat_occupied
-- ----------------------------
INSERT INTO `seat_occupied` VALUES (1, 1, 3, 1);
INSERT INTO `seat_occupied` VALUES (2, 1, 21, 1);
INSERT INTO `seat_occupied` VALUES (3, 1, 22, 1);
INSERT INTO `seat_occupied` VALUES (4, 1, 23, 1);
INSERT INTO `seat_occupied` VALUES (5, 1, 24, 1);
INSERT INTO `seat_occupied` VALUES (6, 1, 25, 1);
INSERT INTO `seat_occupied` VALUES (7, 1, 26, 1);
INSERT INTO `seat_occupied` VALUES (8, 1, 31, 6);
INSERT INTO `seat_occupied` VALUES (9, 1, 32, 6);
INSERT INTO `seat_occupied` VALUES (10, 1, 43, 7);
INSERT INTO `seat_occupied` VALUES (11, 1, 44, 7);
INSERT INTO `seat_occupied` VALUES (12, 1, 80, 8);
INSERT INTO `seat_occupied` VALUES (13, 1, 81, 8);
INSERT INTO `seat_occupied` VALUES (14, 1, 39, 9);
INSERT INTO `seat_occupied` VALUES (15, 1, 40, 9);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` int(11) NULL DEFAULT NULL,
  `acount` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '123456789', 222, '2222', '123456');
INSERT INTO `user` VALUES (2, '18602743162', NULL, NULL, NULL);
INSERT INTO `user` VALUES (3, '19945007635', NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
