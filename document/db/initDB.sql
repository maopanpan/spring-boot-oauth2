/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : oauth2_test

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-11-16 15:41:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(255) NOT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `client_secret` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `authorized_grant_types` varchar(255) DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) DEFAULT NULL,
  `authorities` varchar(255) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` text,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `archived` tinyint(1) DEFAULT '0',
  `trusted` tinyint(1) DEFAULT '0',
  `autoapprove` varchar(255) DEFAULT 'false',
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('mobile-client', 'mobile-resource', 'mobile', 'read,write', 'password,refresh_token', null, 'ROLE_CLIENT', null, null, null, '2017-11-10 17:20:31', '0', '0', 'false');
INSERT INTO `oauth_client_details` VALUES ('unity-client', 'unity-resource', 'unity', 'read,write', 'password,refresh_token', null, 'ROLE_CLIENT', null, null, null, '2017-11-10 17:20:31', '0', '0', 'false');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `guid` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `archived` tinyint(1) DEFAULT '0',
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `default_user` tinyint(1) DEFAULT '0',
  `last_login_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `guid` (`guid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('21', '29f6004fb1b0466f9572b02bf2ac1be8', '2017-11-13 09:25:21', '0', 'admin@wdcy.cc', '21232f297a57a5a743894a0e4a801fc3', '028-1234567', 'admin', '1', null);
INSERT INTO `sys_user` VALUES ('22', '55b713df1c6f423e842ad68668523c49', '2017-11-13 09:25:21', '0', 'unity@wdcy.cc', '439b3a25b555b3bc8667a09a036ae70c', '', 'unity', '0', null);
INSERT INTO `sys_user` VALUES ('23', '612025cb3f964a64a48bbdf77e53c2c1', '2017-11-13 09:25:21', '0', 'mobile@wdcy.cc', '532c28d5412dd75bf975fb951c740a30', '', 'mobile', '0', null);

-- ----------------------------
-- Table structure for `sys_user_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_privilege`;
CREATE TABLE `sys_user_privilege` (
  `user_id` int(11) DEFAULT NULL,
  `privilege` varchar(255) DEFAULT NULL,
  KEY `user_id_index` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_privilege
-- ----------------------------
INSERT INTO `sys_user_privilege` VALUES ('22', 'UNITY');
INSERT INTO `sys_user_privilege` VALUES ('23', 'MOBILE');
