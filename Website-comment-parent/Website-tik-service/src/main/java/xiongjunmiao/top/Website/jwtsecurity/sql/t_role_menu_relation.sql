/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : website-comment

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-05-23 10:53:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu_relation`;
CREATE TABLE `t_role_menu_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8 COMMENT='后台角色菜单关系表';

-- ----------------------------
-- Records of t_role_menu_relation
-- ----------------------------
INSERT INTO `t_role_menu_relation` VALUES ('33', '3', '1');
INSERT INTO `t_role_menu_relation` VALUES ('34', '3', '2');
INSERT INTO `t_role_menu_relation` VALUES ('35', '3', '3');
INSERT INTO `t_role_menu_relation` VALUES ('36', '3', '4');
INSERT INTO `t_role_menu_relation` VALUES ('37', '3', '5');
INSERT INTO `t_role_menu_relation` VALUES ('38', '3', '6');
INSERT INTO `t_role_menu_relation` VALUES ('53', '2', '7');
INSERT INTO `t_role_menu_relation` VALUES ('54', '2', '8');
INSERT INTO `t_role_menu_relation` VALUES ('55', '2', '9');
INSERT INTO `t_role_menu_relation` VALUES ('56', '2', '10');
INSERT INTO `t_role_menu_relation` VALUES ('57', '2', '11');
INSERT INTO `t_role_menu_relation` VALUES ('72', '1', '1');
INSERT INTO `t_role_menu_relation` VALUES ('73', '1', '2');
INSERT INTO `t_role_menu_relation` VALUES ('74', '1', '3');
INSERT INTO `t_role_menu_relation` VALUES ('75', '1', '4');
INSERT INTO `t_role_menu_relation` VALUES ('76', '1', '5');
INSERT INTO `t_role_menu_relation` VALUES ('77', '1', '6');
INSERT INTO `t_role_menu_relation` VALUES ('78', '1', '7');
INSERT INTO `t_role_menu_relation` VALUES ('79', '1', '8');
INSERT INTO `t_role_menu_relation` VALUES ('80', '1', '9');
INSERT INTO `t_role_menu_relation` VALUES ('81', '1', '10');
INSERT INTO `t_role_menu_relation` VALUES ('82', '1', '11');
INSERT INTO `t_role_menu_relation` VALUES ('83', '1', '12');
INSERT INTO `t_role_menu_relation` VALUES ('84', '1', '13');
INSERT INTO `t_role_menu_relation` VALUES ('85', '1', '14');
INSERT INTO `t_role_menu_relation` VALUES ('86', '1', '16');
INSERT INTO `t_role_menu_relation` VALUES ('87', '1', '17');
INSERT INTO `t_role_menu_relation` VALUES ('88', '1', '18');
INSERT INTO `t_role_menu_relation` VALUES ('89', '1', '19');
INSERT INTO `t_role_menu_relation` VALUES ('90', '1', '20');
INSERT INTO `t_role_menu_relation` VALUES ('91', '1', '21');
INSERT INTO `t_role_menu_relation` VALUES ('92', '1', '22');
INSERT INTO `t_role_menu_relation` VALUES ('93', '1', '23');
INSERT INTO `t_role_menu_relation` VALUES ('94', '1', '24');
INSERT INTO `t_role_menu_relation` VALUES ('95', '1', '25');
