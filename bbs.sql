/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-08-14 12:55:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bbs_section
-- ----------------------------
DROP TABLE IF EXISTS `bbs_section`;
CREATE TABLE `bbs_section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_section
-- ----------------------------
INSERT INTO `bbs_section` VALUES ('1', '软件开发');
INSERT INTO `bbs_section` VALUES ('2', '算法研究');
INSERT INTO `bbs_section` VALUES ('3', '问题反馈');

-- ----------------------------
-- Table structure for bbs_topic
-- ----------------------------
DROP TABLE IF EXISTS `bbs_topic`;
CREATE TABLE `bbs_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(45) DEFAULT NULL,
  `pid` varchar(45) DEFAULT NULL,
  `creat_date` timestamp NULL DEFAULT NULL,
  `is_legal` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_topic
-- ----------------------------
INSERT INTO `bbs_topic` VALUES ('1', '2', '软件', '软件开发的魅力', '0', '2013-05-19 22:09:14', null, '1');
INSERT INTO `bbs_topic` VALUES ('2', '2', '算法', '研究算法的优劣', '0', '2013-05-19 22:17:57', null, '2');
INSERT INTO `bbs_topic` VALUES ('3', '2', '回复问题', '问题反馈', '0', '2013-05-19 22:19:07', null, '3');
INSERT INTO `bbs_topic` VALUES ('4', '2', '硬件', '硬件发展', '0', '2013-05-19 22:22:53', null, '1');
INSERT INTO `bbs_topic` VALUES ('5', '2', '', '跟随潮流', '4', '2013-05-19 22:23:07', null, '1');

-- ----------------------------
-- Table structure for bbs_user
-- ----------------------------
DROP TABLE IF EXISTS `bbs_user`;
CREATE TABLE `bbs_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `realname` varchar(45) DEFAULT NULL,
  `favorite` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `home` varchar(45) DEFAULT NULL,
  `is_admin` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bbs_user
-- ----------------------------
INSERT INTO `bbs_user` VALUES ('1', 'admin', 'admin', null, null, null, null, null, '1');
INSERT INTO `bbs_user` VALUES ('2', '张三', '123', '', '123', '男', '135', '136', '0');
