/*
 Navicat Premium Data Transfer

 Source Server         : 01
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : personalmanagement

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 03/01/2020 09:48:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attendence
-- ----------------------------
DROP TABLE IF EXISTS `attendence`;
CREATE TABLE `attendence`  (
  `attNo` int(11) NOT NULL,
  `absence` int(11) DEFAULT NULL,
  `attend` int(11) DEFAULT NULL,
  `leaveOut` int(11) DEFAULT NULL,
  PRIMARY KEY (`attNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendence
-- ----------------------------
INSERT INTO `attendence` VALUES (1, 3, 22, 2);
INSERT INTO `attendence` VALUES (2, 4, 21, 1);
INSERT INTO `attendence` VALUES (3, 3, 20, 3);

-- ----------------------------
-- Table structure for attendmanage
-- ----------------------------
DROP TABLE IF EXISTS `attendmanage`;
CREATE TABLE `attendmanage`  (
  `empId` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `attNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`empId`) USING BTREE,
  INDEX `attNo`(`attNo`) USING BTREE,
  CONSTRAINT `attendmanage_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `empmessage` (`empId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `attendmanage_ibfk_2` FOREIGN KEY (`attNo`) REFERENCES `attendence` (`attNo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of attendmanage
-- ----------------------------
INSERT INTO `attendmanage` VALUES ('1001', 1);
INSERT INTO `attendmanage` VALUES ('1002', 2);
INSERT INTO `attendmanage` VALUES ('1003', 3);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `Num` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `depName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Num`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('01', '人事部');
INSERT INTO `department` VALUES ('02', '财务部');

-- ----------------------------
-- Table structure for empmessage
-- ----------------------------
DROP TABLE IF EXISTS `empmessage`;
CREATE TABLE `empmessage`  (
  `password` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `empId` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `empName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `age` smallint(6) DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `IDnumber` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `departNo` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nation` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `birth` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `academic` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `politics` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`empId`) USING BTREE,
  INDEX `departNo`(`departNo`) USING BTREE,
  CONSTRAINT `empmessage_ibfk_1` FOREIGN KEY (`departNo`) REFERENCES `department` (`Num`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of empmessage
-- ----------------------------
INSERT INTO `empmessage` VALUES ('11111', '1001', '李浩冉', 21, '男', '636363663633', '343434', '01', '高工', '汉', '19980219', '本科', '团员');
INSERT INTO `empmessage` VALUES ('00000', '1002', '王浩', 21, '男', '323232323232', '22232', '02', '经理', '汉', '1984848', '本科', '团员');
INSERT INTO `empmessage` VALUES ('00000', '1003', '陈星星', 20, '女', '987654445567654', '323232', '02', '高工', '汉', '19990909', '本科', '团员');
INSERT INTO `empmessage` VALUES ('00000', '1004', '辛静', 33, '女', '3324234', '32242', '01', '经理', '汉', '3242442', '本科', '团员');
INSERT INTO `empmessage` VALUES ('00000', '1005', '李佳欢', 23, '女', '3242342342', '23423', '02', '经理', '汉', '日342', '本科', '团员');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `examNo` int(11) NOT NULL,
  `award` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `illegal` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`examNo`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, '全勤 奖', '无故缺勤一次');
INSERT INTO `exam` VALUES (2, '加班奖', '迟到');

-- ----------------------------
-- Table structure for exammanage
-- ----------------------------
DROP TABLE IF EXISTS `exammanage`;
CREATE TABLE `exammanage`  (
  `empId` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `examNo` int(11) NOT NULL,
  PRIMARY KEY (`empId`, `examNo`) USING BTREE,
  INDEX `examNo`(`examNo`) USING BTREE,
  CONSTRAINT `exammanage_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `empmessage` (`empId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `exammanage_ibfk_2` FOREIGN KEY (`examNo`) REFERENCES `exam` (`examNo`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exammanage
-- ----------------------------
INSERT INTO `exammanage` VALUES ('1001', 1);
INSERT INTO `exammanage` VALUES ('1002', 1);
INSERT INTO `exammanage` VALUES ('1001', 2);
INSERT INTO `exammanage` VALUES ('1002', 2);

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary`  (
  `id` int(11) NOT NULL,
  `basic` int(11) DEFAULT NULL,
  `reward` int(11) DEFAULT NULL,
  `deduction` int(11) DEFAULT NULL,
  `allowance` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary
-- ----------------------------
INSERT INTO `salary` VALUES (1, 3000, 1000, 1000, 1500);
INSERT INTO `salary` VALUES (2, 3500, 1500, 1000, 1800);
INSERT INTO `salary` VALUES (3, 5000, 2000, 1000, 1000);
INSERT INTO `salary` VALUES (4, 8000, 2500, 1500, 1000);
INSERT INTO `salary` VALUES (5, 8000, 1000, 800, 2000);
INSERT INTO `salary` VALUES (6, 20000, 2000, 3000, 2000);
INSERT INTO `salary` VALUES (7, 12000, 2000, 800, 1500);

-- ----------------------------
-- Table structure for salarymanage
-- ----------------------------
DROP TABLE IF EXISTS `salarymanage`;
CREATE TABLE `salarymanage`  (
  `empId` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `yfSalary` int(11) DEFAULT NULL,
  `sfSalary` int(11) DEFAULT NULL,
  `time` char(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`empId`) USING BTREE,
  CONSTRAINT `salarymanage_ibfk_1` FOREIGN KEY (`empId`) REFERENCES `empmessage` (`empId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salarymanage
-- ----------------------------
INSERT INTO `salarymanage` VALUES ('1001', 5000, 5000, '2020.1.1', 1);
INSERT INTO `salarymanage` VALUES ('1002', 6000, 6000, '2020.1.1', 2);
INSERT INTO `salarymanage` VALUES ('1003', 6000, 6000, '2020.1.1', 3);

SET FOREIGN_KEY_CHECKS = 1;
