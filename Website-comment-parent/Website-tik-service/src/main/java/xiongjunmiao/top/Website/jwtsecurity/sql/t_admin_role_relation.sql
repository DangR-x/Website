/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : website-comment

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-05-23 10:53:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_role_relation`;
CREATE TABLE `t_admin_role_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `admin_id` bigint DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='后台用户和角色关系表';

-- ----------------------------
-- Records of t_admin_role_relation
-- ----------------------------
INSERT INTO `t_admin_role_relation` VALUES ('26', '3', '1');
INSERT INTO `t_admin_role_relation` VALUES ('27', '6', '3');
INSERT INTO `t_admin_role_relation` VALUES ('28', '7', '2');
INSERT INTO `t_admin_role_relation` VALUES ('29', '1', '1');
INSERT INTO `t_admin_role_relation` VALUES ('30', '4', '1');
INSERT INTO `t_admin_role_relation` VALUES ('31', '13', '1');
