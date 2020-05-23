
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` bigint DEFAULT NULL,
  `menu` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '小明', '123', '1', null, 'http://localhost:9001/xiong/15d0a5bc1918d6.png');
INSERT INTO `t_user` VALUES ('2', '小花', '321', '1', null, 'http://localhost:9001/xiong/5ebb4ba00b868.png');
INSERT INTO `t_user` VALUES ('3', '小米', '123', '1', null, 'http://localhost:9001/xiong/5ebb4b71ebfe4.png');
