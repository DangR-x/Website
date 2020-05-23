/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80020
Source Host           : localhost:3306
Source Database       : website-comment

Target Server Type    : MYSQL
Target Server Version : 80020
File Encoding         : 65001

Date: 2020-05-23 18:37:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `after_sale` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  `commission` decimal(10,0) DEFAULT NULL,
  `commission_type` int DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  `fx_type` int DEFAULT NULL,
  `got_score` int DEFAULT NULL,
  `got_score_type` int DEFAULT NULL,
  `hidden` int DEFAULT NULL,
  `kanjia` tinyint DEFAULT NULL,
  `limitation` tinyint DEFAULT NULL,
  `kanjia_price` varchar(10) DEFAULT NULL,
  `logistics_id` bigint DEFAULT NULL,
  `max_coupons` int DEFAULT NULL,
  `miaosha` tinyint DEFAULT NULL,
  `min_price` varchar(10) DEFAULT NULL,
  `min_score` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_fav` int DEFAULT NULL,
  `number_goodrequtation` int DEFAULT NULL COMMENT '名声',
  `number_orders` int DEFAULT NULL COMMENT '订单',
  `number_sells` int DEFAULT NULL COMMENT '售卖数量',
  `original_price` varchar(10) DEFAULT NULL COMMENT '原价',
  `paixu` int DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `pingtuan` tinyint DEFAULT NULL,
  `pingtuan_price` varchar(10) DEFAULT NULL,
  `recommend_status` int DEFAULT NULL COMMENT '推荐',
  `recommend_statusstr` varchar(255) DEFAULT NULL,
  `sell_end` tinyint DEFAULT NULL,
  `sell_start` tinyint DEFAULT NULL,
  `shop_id` bigint DEFAULT NULL,
  `status` int DEFAULT NULL,
  `statusstr` varchar(255) DEFAULT NULL,
  `store_alert` tinyint DEFAULT NULL,
  `stores` bigint DEFAULT NULL COMMENT '商店',
  `stores_unsale` tinyint DEFAULT NULL,
  `admin_id` bigint DEFAULT NULL,
  `vet_status` int DEFAULT NULL,
  `views` bigint DEFAULT NULL COMMENT '查看人数',
  `weight` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', 'haha', '2', '6', '1', '2020-05-23 09:47:52', null, '2', null, '1', '1', '0', '0', null, null, null, '0', null, null, null, null, null, null, null, null, null, null, '0', '3', null, null, '0', '0', null, null, null, '0', null, '0', '1', null, null, null);
INSERT INTO `t_goods` VALUES ('2', 'haha', '2', '6', '1', '2020-05-23 10:21:54', null, '2', null, '1', '1', '0', '0', null, null, null, '0', null, null, null, null, null, null, null, null, null, null, '0', null, null, null, '0', '0', null, null, null, '0', null, '0', '1', null, null, null);
