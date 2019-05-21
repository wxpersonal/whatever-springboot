/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : localhost:3306
 Source Schema         : whatever

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : 65001

 Date: 03/04/2019 19:30:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `pid` int(11) NOT NULL DEFAULT '0' COMMENT '上级菜单',
                        `name` varchar(50) NOT NULL DEFAULT '""' COMMENT '排序级别',
                        `kind` int(11) NOT NULL DEFAULT '0' COMMENT '菜单类型  0菜单实例(默认),1菜单分组',
                        `url` varchar(500) DEFAULT NULL COMMENT 'url',
                        `icon` varchar(500) DEFAULT NULL COMMENT 'icon',
                        `sort_no` int(11) DEFAULT NULL COMMENT '菜单排序号',
                        `level` int(11) DEFAULT NULL COMMENT '菜单层级',
                        `desc` varchar(255) DEFAULT NULL COMMENT '备注',
                        `leaf_flag` tinyint(4) DEFAULT NULL COMMENT '是否是叶子结点',
                        `create_by` int(11) DEFAULT NULL,
                        `create_time` datetime DEFAULT NULL,
                        `update_by` int(11) DEFAULT NULL,
                        `update_time` datetime DEFAULT NULL,
                        `status` tinyint(4) DEFAULT '1' COMMENT '菜单状态',
                        `deleted` tinyint(4) DEFAULT '0',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_0
-- ----------------------------
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
                           `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `user_id` int(11) NOT NULL,
                           `status` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                           `create_by` int(11) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_by` int(11) DEFAULT NULL,
                           `update_time` int(11) DEFAULT NULL,
                           `deleted` tinyint(4) DEFAULT '0',
                           PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=320230945342881793 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of t_order_0
-- ----------------------------
BEGIN;
INSERT INTO `t_order_0` VALUES (320230945342881792, 111222, NULL, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_order_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
                           `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
                           `user_id` int(11) NOT NULL,
                           `status` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                           `create_by` int(11) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           `update_by` int(11) DEFAULT NULL,
                           `update_time` int(11) DEFAULT NULL,
                           `deleted` tinyint(4) DEFAULT '0',
                           PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_order_item_0
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item_0`;
CREATE TABLE `t_order_item_0` (
                                `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `order_id` bigint(20) NOT NULL,
                                `user_id` int(11) NOT NULL,
                                `create_by` int(11) DEFAULT NULL,
                                `create_time` datetime DEFAULT NULL,
                                `update_by` int(11) DEFAULT NULL,
                                `update_time` int(11) DEFAULT NULL,
                                `deleted` tinyint(4) DEFAULT '0',
                                PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_order_item_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item_1`;
CREATE TABLE `t_order_item_1` (
                                `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `order_id` bigint(20) NOT NULL,
                                `user_id` int(11) NOT NULL,
                                `create_by` int(11) DEFAULT NULL,
                                `create_time` datetime DEFAULT NULL,
                                `update_by` int(11) DEFAULT NULL,
                                `update_time` int(11) DEFAULT NULL,
                                `deleted` tinyint(4) DEFAULT '0',
                                PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
                              `id` int(11) NOT NULL AUTO_INCREMENT,
                              `p_id` int(11) DEFAULT '0',
                              `name` varchar(50) NOT NULL,
                              `desc` varchar(1000) DEFAULT NULL comment '权限描述',
                              `url` varchar(500) DEFAULT NULL comment '',
                              `sort_no` int(11) DEFAULT '0' comment '排序',
                              `type` tinyint(4) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
                              `icon` varchar(50) DEFAULT NULL COMMENT '图标',
                              `create_by` int(11) DEFAULT '0',
                              `create_time` datetime DEFAULT NULL,
                              `update_by` int(11) DEFAULT '0',
                              `update_time` datetime DEFAULT NULL,
                              `status` tinyint(4) DEFAULT '1',
                              `deleted` tinyint(4) DEFAULT '0',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `code` varchar(50) NOT NULL COMMENT '权限编码',
                        `name` varchar(50) DEFAULT NULL,
                        `desc` varchar(1000) DEFAULT NULL COMMENT '权限说明',
                        `create_by` int(11) DEFAULT '0',
                        `create_time` datetime DEFAULT NULL,
                        `update_by` int(11) DEFAULT '0',
                        `update_time` datetime DEFAULT NULL,
                        `status` tinyint(4) DEFAULT '1',
                        `deleted` tinyint(4) DEFAULT '0',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, 'ROLE_ADMIN', '管理员', '拥有除权限管理系统外的所有权限', NULL, '2017-06-20 00:00:00', NULL, '2017-06-20 00:00:00', 1, 0);
INSERT INTO `t_role` VALUES (2, 'ROLE_SADMIN', '超级管理员', '拥有所有权限', NULL, '2017-06-20 00:00:00', NULL, '2017-06-20 00:00:00', 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
                                   `id` int(11) NOT NULL AUTO_INCREMENT,
                                   `role_id` int(11) NOT NULL,
                                   `permission_id` int(11) NOT NULL,
                                   `create_by` int(11) DEFAULT '0',
                                   `create_time` datetime DEFAULT NULL,
                                   `update_by` int(11) DEFAULT '0',
                                   `update_time` datetime DEFAULT NULL,
                                   `status` tinyint(4) DEFAULT '1',
                                   `deleted` tinyint(4) DEFAULT '0',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for t_sys_code
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_dic`;
CREATE TABLE `t_sys_dic` (
                            `id` bigint(20) NOT NULL,
                            `p_id` varchar(50) DEFAULT NULL,
                            `name` varchar(50) DEFAULT NULL COMMENT '字典名称',
                            `code` varchar(255) DEFAULT NULL COMMENT '字典的编码',
                            `desc` varchar(1000) DEFAULT NULL,
                            `sort_no` int(11) default '0' COMMENT '排序字段',
                            `create_by` int(11) DEFAULT '0',
                            `create_time` datetime DEFAULT NULL,
                            `updateBy` int(11) DEFAULT '0',
                            `update_time` datetime DEFAULT NULL,
                            `status` tinyint(4) DEFAULT '1',
                            `deleted` tinyint(4) DEFAULT '0',
                            PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_sys_file
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file`;
CREATE TABLE `t_sys_file` (
                            `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件id',
                            `objectid` int(11) DEFAULT '0' COMMENT '所属对象id',
                            `objecttype` int(11) DEFAULT '0',
                            `type` int(11) DEFAULT '0' COMMENT '附件类型',
                            `oldname` varchar(255) DEFAULT NULL COMMENT '附件原名称',
                            `newname` varchar(255) DEFAULT NULL COMMENT '附件新名称',
                            `size` int(11) DEFAULT '0' COMMENT '附件大小',
                            `path` varchar(255) DEFAULT NULL COMMENT '存放路径',
                            `relativepath` varchar(255) DEFAULT NULL COMMENT '相对路径',
                            `create_by` int(11) DEFAULT '0',
                            `create_time` datetime DEFAULT NULL,
                            `update_by` int(11) DEFAULT '0',
                            `update_time` datetime DEFAULT NULL,
                            `status` tinyint(4) DEFAULT '1',
                            `deleted` tinyint(4) DEFAULT '0',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                        `id` int(20) NOT NULL COMMENT '用户id',
                        `account` varchar(50) DEFAULT NULL COMMENT '用户名',
                        `password` varchar(50) DEFAULT NULL COMMENT '密码',
                        `salt` varchar(50) NOT NULL COMMENT '加密盐',
                        `name` varchar(50) DEFAULT NULL COMMENT '姓名',
                        `gender` int(20) DEFAULT '0' COMMENT '性别',
                        `mobile` varchar(50) DEFAULT NULL COMMENT '电话',
                        `birthday` datetime DEFAULT NULL COMMENT '出生时间',
                        `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
                        `address_id` int(11) DEFAULT '0',
                        `photo_id` int(20) DEFAULT '0' COMMENT '照片附件',
                        `create_by` int(11) DEFAULT '0',
                        `create_time` datetime DEFAULT NULL,
                        `update_by` int(11) DEFAULT '0',
                        `update_time` datetime DEFAULT NULL,
                        `status` tinyint(4) DEFAULT '1',
                        `deleted` tinyint(4) DEFAULT '0',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
BEGIN;
INSERT INTO `t_user` VALUES (1, 'admin', '1d6b1208c7d151d335790276a18e3d99', 'q6taw', '超级管理员', 0, '18205256689', '2017-06-16 00:00:00', 'wxpersonal@163.com', 0, 0, 0, '2017-06-16 00:00:00', 0, '2017-06-16 00:00:00', 1, 0);
INSERT INTO `t_user` VALUES (2, 'weix', '1d6b1208c7d151d335790276a18e3d99', 'q6taw', '魏祥',0, '18205256689', '2017-06-20 00:00:00', 'wxpersonal@163.com', 0, 0, 0, '2017-06-20 00:00:00', 0, '2017-06-20 00:00:00', 1, 0);
COMMIT;
COMMIT;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
                             `id` int(20) NOT NULL COMMENT '主键',
                             `user_id` int(11) NOT NULL COMMENT '用户id',
                             `role_id` int(11) NOT NULL COMMENT '角色code',
                             `create_by` int(11) DEFAULT '0',
                             `create_time` datetime DEFAULT NULL,
                             `update_by` int(11) DEFAULT '0',
                             `update_time` datetime DEFAULT NULL,
                             `status` tinyint(4) DEFAULT '1',
                             `deleted` tinyint(4) DEFAULT '0',
                             PRIMARY KEY ('id')
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
