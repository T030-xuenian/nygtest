/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50725
Source Host           : 127.0.0.1:3306
Source Database       : archives

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-11-11 12:26:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(36) NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `created_date` datetime NOT NULL,
  `password` varchar(20) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `user_type` int(11) NOT NULL,
  `current_tenant_id` varchar(36) DEFAULT NULL,
  `personnel_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_dx61ph83p21e9y80scx92i39p` (`user_name`),
  KEY `FKex3bf5jhvk4tdydw4fnyds0ku` (`current_tenant_id`),
  KEY `FK36sx0i0dt97flf7na7xy90t0r` (`personnel_id`),
  CONSTRAINT `FK36sx0i0dt97flf7na7xy90t0r` FOREIGN KEY (`personnel_id`) REFERENCES `tb_personnel` (`id`),
  CONSTRAINT `FKex3bf5jhvk4tdydw4fnyds0ku` FOREIGN KEY (`current_tenant_id`) REFERENCES `tb_tenant` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
