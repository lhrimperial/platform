/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : platform

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-08-11 08:18:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `res_code` varchar(50) NOT NULL,
  `parent_code` varchar(50) DEFAULT NULL,
  `index` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `active` varchar(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_85wfgseo6k6iluphthf0305eh` (`res_code`),
  UNIQUE KEY `UK_wqmnx45x5ugtxaxljfopeewc` (`parent_code`),
  CONSTRAINT `FKmxxd78essctkj7g4o61w14nnj` FOREIGN KEY (`parent_code`) REFERENCES `t_resource` (`res_code`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES ('1', '10000', null, 'systemset', '系统设置', null, 'el-icon-date', null, null, null, 'Y', null, null);
INSERT INTO `t_resource` VALUES ('2', '10001', '10000', 'termsmanage', '词条管理', null, null, null, null, null, 'Y', null, null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_code` varchar(50) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `active` varchar(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'admin', 'admin', null, 'Y', '2018-08-09 19:41:33', '2018-08-09 19:41:35');
INSERT INTO `t_role` VALUES ('2', 'manage', 'manage', null, 'Y', '2018-08-09 19:41:56', '2018-08-09 19:41:59');

-- ----------------------------
-- Table structure for t_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource` (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`resource_id`),
  KEY `FKh0rhcym5jgeccq108lwe39wl2` (`resource_id`),
  CONSTRAINT `FKh0rhcym5jgeccq108lwe39wl2` FOREIGN KEY (`resource_id`) REFERENCES `t_resource` (`id`),
  CONSTRAINT `FKjoc0b6anonklrmwalu5g6udfl` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_resource
-- ----------------------------
INSERT INTO `t_role_resource` VALUES ('1', '1');
INSERT INTO `t_role_resource` VALUES ('1', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `nick_name` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `notes` varchar(100) DEFAULT NULL,
  `active` varchar(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '88212F91E2E9CF36981A91B6C518AF5C', null, 'admin', null, null, null, 'Y', '2018-08-09 19:41:09', '2018-08-09 19:41:13');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa9c8iiy6ut0gnx491fqx4pxam` (`role_id`),
  CONSTRAINT `FKa9c8iiy6ut0gnx491fqx4pxam` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FKq5un6x7ecoef5w1n39cop66kl` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '1');
INSERT INTO `t_user_role` VALUES ('1', '2');
