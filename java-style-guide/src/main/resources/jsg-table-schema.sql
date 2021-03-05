
DROP TABLE IF EXISTS `jsg_user`;

CREATE TABLE `jsg_user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `nick_name` varchar(32) COLLATE utf8mb4_bin NOT NULL COMMENT '昵称',
  `phone_number` varchar(16) COLLATE utf8mb4_bin NOT NULL COMMENT '手机号码',
  `gender` tinyint(1) NOT NULL COMMENT '性别',
  `email_address` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `address_id` int(11) DEFAULT NULL COMMENT '地址ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UNIQUE_USER_NAME` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='JavaStyleGuide开发规范用户演示';

DROP TABLE IF EXISTS `jsg_user_address`;

CREATE TABLE `jsg_user_address` (
  `address_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '地址ID',
  `address_name` varchar(128) COLLATE utf8mb4_bin NOT NULL COMMENT '地址名称',
  `province_id` int(11) NOT NULL COMMENT '省份ID',
  `city_id` int(11) NOT NULL COMMENT '城市ID',
  `district_id` int(11) NOT NULL COMMENT '行政区ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='JavaStyleGuide开发规范用户地址演示';

