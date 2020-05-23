/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : website-comment

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-05-23 10:53:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource_relation`;
CREATE TABLE `t_role_resource_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL COMMENT '角色ID',
  `resource_id` bigint DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8 COMMENT='后台角色资源关系表';

-- ----------------------------
-- Records of t_role_resource_relation
-- ----------------------------
INSERT INTO `t_role_resource_relation` VALUES ('103', '2', '8');
INSERT INTO `t_role_resource_relation` VALUES ('104', '2', '9');
INSERT INTO `t_role_resource_relation` VALUES ('105', '2', '10');
INSERT INTO `t_role_resource_relation` VALUES ('106', '2', '11');
INSERT INTO `t_role_resource_relation` VALUES ('107', '2', '12');
INSERT INTO `t_role_resource_relation` VALUES ('141', '1', '31');
INSERT INTO `t_role_resource_relation` VALUES ('142', '1', '1');
INSERT INTO `t_role_resource_relation` VALUES ('143', '1', '2');
INSERT INTO `t_role_resource_relation` VALUES ('144', '1', '3');
INSERT INTO `t_role_resource_relation` VALUES ('145', '1', '4');
INSERT INTO `t_role_resource_relation` VALUES ('146', '1', '5');
INSERT INTO `t_role_resource_relation` VALUES ('147', '1', '6');
INSERT INTO `t_role_resource_relation` VALUES ('148', '1', '8');
INSERT INTO `t_role_resource_relation` VALUES ('149', '1', '9');
INSERT INTO `t_role_resource_relation` VALUES ('150', '1', '10');
INSERT INTO `t_role_resource_relation` VALUES ('151', '1', '11');
INSERT INTO `t_role_resource_relation` VALUES ('152', '1', '12');
INSERT INTO `t_role_resource_relation` VALUES ('153', '1', '13');
INSERT INTO `t_role_resource_relation` VALUES ('154', '1', '14');
INSERT INTO `t_role_resource_relation` VALUES ('155', '1', '15');
INSERT INTO `t_role_resource_relation` VALUES ('156', '1', '16');
INSERT INTO `t_role_resource_relation` VALUES ('157', '1', '17');
INSERT INTO `t_role_resource_relation` VALUES ('158', '1', '18');
INSERT INTO `t_role_resource_relation` VALUES ('159', '1', '19');
INSERT INTO `t_role_resource_relation` VALUES ('160', '1', '20');
INSERT INTO `t_role_resource_relation` VALUES ('161', '1', '21');
INSERT INTO `t_role_resource_relation` VALUES ('162', '1', '22');
INSERT INTO `t_role_resource_relation` VALUES ('163', '1', '23');
INSERT INTO `t_role_resource_relation` VALUES ('164', '1', '24');
INSERT INTO `t_role_resource_relation` VALUES ('165', '1', '25');
INSERT INTO `t_role_resource_relation` VALUES ('166', '1', '26');
INSERT INTO `t_role_resource_relation` VALUES ('167', '1', '27');
INSERT INTO `t_role_resource_relation` VALUES ('168', '1', '28');
INSERT INTO `t_role_resource_relation` VALUES ('169', '1', '29');
INSERT INTO `t_role_resource_relation` VALUES ('170', '3', '1');
INSERT INTO `t_role_resource_relation` VALUES ('171', '3', '2');
INSERT INTO `t_role_resource_relation` VALUES ('172', '3', '3');
INSERT INTO `t_role_resource_relation` VALUES ('173', '3', '4');
INSERT INTO `t_role_resource_relation` VALUES ('174', '3', '5');
INSERT INTO `t_role_resource_relation` VALUES ('175', '3', '6');
INSERT INTO `t_role_resource_relation` VALUES ('176', '3', '23');
INSERT INTO `t_role_resource_relation` VALUES ('177', '3', '24');
