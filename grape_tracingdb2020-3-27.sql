/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : grape_tracingdb

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-03-27 14:36:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for amount
-- ----------------------------
DROP TABLE IF EXISTS `amount`;
CREATE TABLE `amount` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_id` int(11) DEFAULT NULL,
  `amount` int(30) DEFAULT NULL,
  `year` int(20) DEFAULT NULL,
  `month` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `area_id` (`area_id`),
  CONSTRAINT `amount_ibfk_1` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of amount
-- ----------------------------
INSERT INTO `amount` VALUES ('2', '2', '10', '1997', '4');
INSERT INTO `amount` VALUES ('3', '2', '10', '1997', '4');
INSERT INTO `amount` VALUES ('4', '2', '10', '1997', '4');
INSERT INTO `amount` VALUES ('5', '2', '10', '1997', '4');
INSERT INTO `amount` VALUES ('6', '2', '10', '1997', '4');

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `area_id` int(20) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(40) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES ('1', '一号大棚', null);
INSERT INTO `area` VALUES ('2', 'dsf', 'dsf');
INSERT INTO `area` VALUES ('3', '三号大棚', null);
INSERT INTO `area` VALUES ('4', 'kkj', null);
INSERT INTO `area` VALUES ('5', 'fgg', null);
INSERT INTO `area` VALUES ('6', 'll', null);
INSERT INTO `area` VALUES ('7', 'we', 'gfg');
INSERT INTO `area` VALUES ('8', 'as', 'as');

-- ----------------------------
-- Table structure for farmcate
-- ----------------------------
DROP TABLE IF EXISTS `farmcate`;
CREATE TABLE `farmcate` (
  `farmcate_id` int(20) NOT NULL,
  `farmcate_name` varchar(20) DEFAULT NULL,
  KEY `farmcate_id` (`farmcate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farmcate
-- ----------------------------
INSERT INTO `farmcate` VALUES ('1', '施肥');
INSERT INTO `farmcate` VALUES ('2', '打药');
INSERT INTO `farmcate` VALUES ('3', '修剪');
INSERT INTO `farmcate` VALUES ('0', '其他');

-- ----------------------------
-- Table structure for farmop
-- ----------------------------
DROP TABLE IF EXISTS `farmop`;
CREATE TABLE `farmop` (
  `farmop_id` int(30) NOT NULL AUTO_INCREMENT,
  `area_id` int(20) DEFAULT NULL,
  `tree_id` int(20) DEFAULT NULL,
  `farmop_des` varchar(255) DEFAULT NULL,
  `farmcate_id` int(20) NOT NULL,
  `farmop_time` date DEFAULT NULL,
  `opperson` varchar(20) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`farmop_id`),
  KEY `opperon_id` (`opperson`),
  KEY `farmop_ibfk_3` (`farmcate_id`),
  KEY `farmop_ibfk_4` (`area_id`),
  KEY `tree_id` (`tree_id`),
  CONSTRAINT `farmop_ibfk_3` FOREIGN KEY (`farmcate_id`) REFERENCES `farmcate` (`farmcate_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `farmop_ibfk_4` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farmop
-- ----------------------------
INSERT INTO `farmop` VALUES ('6', '2', '2', '施肥2千克', '1', '2018-12-23', '张三1', null);
INSERT INTO `farmop` VALUES ('7', '3', '3', null, '3', null, null, null);
INSERT INTO `farmop` VALUES ('8', '1', '2', '施肥', '1', '2015-01-01', '张三', null);
INSERT INTO `farmop` VALUES ('9', '1', '2', '施肥1千克', '1', '2020-03-10', '李四', null);
INSERT INTO `farmop` VALUES ('10', '1', '2', '施肥1千克', '1', '2020-03-10', '李四', null);
INSERT INTO `farmop` VALUES ('11', '1', '2', '施肥', '1', '2015-01-01', '张三', null);
INSERT INTO `farmop` VALUES ('12', '1', '2', '施肥', '1', '2015-01-01', '张三', null);
INSERT INTO `farmop` VALUES ('13', '1', '2', '施肥', '1', '2015-01-01', '张三', null);
INSERT INTO `farmop` VALUES ('15', '2', '2', '施肥2千克', '1', '2018-12-23', '张三', null);
INSERT INTO `farmop` VALUES ('16', '3', null, null, '2', null, null, null);
INSERT INTO `farmop` VALUES ('17', '2', '1', null, '2', null, null, null);
INSERT INTO `farmop` VALUES ('19', '2', '10000', '施肥2千克', '1', '2018-12-23', '张三', null);
INSERT INTO `farmop` VALUES ('20', '2', '2', '施肥2千克', '1', '2018-12-23', '张三', null);
INSERT INTO `farmop` VALUES ('21', '2', '10000', '施肥2千克', '1', '2018-12-23', '张三', null);
INSERT INTO `farmop` VALUES ('24', '2', '2', '施肥2千克', '1', '2018-12-23', '张三', null);

-- ----------------------------
-- Table structure for logistics
-- ----------------------------
DROP TABLE IF EXISTS `logistics`;
CREATE TABLE `logistics` (
  `logistics_id` int(30) NOT NULL AUTO_INCREMENT,
  `qrcode_id` varchar(30) NOT NULL,
  `time` datetime DEFAULT NULL,
  `descri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`logistics_id`),
  KEY `qrcode_id` (`qrcode_id`),
  CONSTRAINT `logistics_ibfk_1` FOREIGN KEY (`qrcode_id`) REFERENCES `qrcode` (`qrcode_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logistics
-- ----------------------------
INSERT INTO `logistics` VALUES ('1', '201905261215001', '2020-03-18 19:31:00', '22');
INSERT INTO `logistics` VALUES ('2', '201905261215001', '2018-02-03 00:00:00', 'string');
INSERT INTO `logistics` VALUES ('3', '201905261215001', '2018-02-03 00:00:00', 'null');
INSERT INTO `logistics` VALUES ('7', '201905261215001', '2018-08-09 00:00:00', 'string');
INSERT INTO `logistics` VALUES ('8', '201905261215001', '2018-08-09 00:00:00', 'string');
INSERT INTO `logistics` VALUES ('9', '201905261215001', '2018-08-09 00:00:00', 'string');

-- ----------------------------
-- Table structure for qrcode
-- ----------------------------
DROP TABLE IF EXISTS `qrcode`;
CREATE TABLE `qrcode` (
  `qrcode_id` varchar(30) NOT NULL,
  `create_time` date DEFAULT NULL,
  `qrcode_addr` varchar(100) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  KEY `qrcode_id` (`qrcode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrcode
-- ----------------------------
INSERT INTO `qrcode` VALUES ('201905261215001', '2019-05-26', null, null);
INSERT INTO `qrcode` VALUES ('201905261215002', '2019-05-26', null, null);
INSERT INTO `qrcode` VALUES ('201905162189001', '2019-05-16', null, null);
INSERT INTO `qrcode` VALUES ('201905172189001', '2019-05-17', null, null);
INSERT INTO `qrcode` VALUES ('201905172189002', '2019-05-17', null, null);
INSERT INTO `qrcode` VALUES ('201805172189001', '2018-05-17', null, null);
INSERT INTO `qrcode` VALUES ('201905162189002', null, null, null);
INSERT INTO `qrcode` VALUES ('201905161201001', null, null, null);

-- ----------------------------
-- Table structure for quainf
-- ----------------------------
DROP TABLE IF EXISTS `quainf`;
CREATE TABLE `quainf` (
  `quainf_id` int(30) NOT NULL AUTO_INCREMENT,
  `area_id` int(20) DEFAULT NULL,
  `tree_id` int(20) DEFAULT NULL,
  `qrcode_id` varchar(11) DEFAULT NULL,
  `inf` varchar(1000) DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`quainf_id`),
  KEY `quainf_ibfk_3` (`qrcode_id`),
  KEY `quainf_ibfk_4` (`area_id`),
  KEY `quainf_ibfk_5` (`tree_id`),
  CONSTRAINT `quainf_ibfk_3` FOREIGN KEY (`qrcode_id`) REFERENCES `qrcode` (`qrcode_id`),
  CONSTRAINT `quainf_ibfk_4` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quainf
-- ----------------------------
INSERT INTO `quainf` VALUES ('2', '3', null, null, null, null);
INSERT INTO `quainf` VALUES ('3', '3', null, null, null, null);
INSERT INTO `quainf` VALUES ('4', '3', null, null, null, 'sdd');
INSERT INTO `quainf` VALUES ('5', '1', '1', null, 'qwer!', 'imageName');
INSERT INTO `quainf` VALUES ('6', '2', '3', null, 'string1', '/tree/01_1584284481475.jpg');
INSERT INTO `quainf` VALUES ('7', '3', '1', null, 'string1', '/tree/01_1584284809757.jpg');
INSERT INTO `quainf` VALUES ('8', '1', '1', null, 'string', '/tree/01_1584339956187.jpg');
INSERT INTO `quainf` VALUES ('9', '2', '1', null, 'string', '/tree/01_1584340018493.jpg');
INSERT INTO `quainf` VALUES ('10', '1', '1', null, null, '/tree/01_1584340446678.jpg');
INSERT INTO `quainf` VALUES ('11', '2', '1', null, null, '/tree/01_1584340521530.jpg');
INSERT INTO `quainf` VALUES ('20', null, null, null, null, null);
INSERT INTO `quainf` VALUES ('21', null, null, null, null, null);
INSERT INTO `quainf` VALUES ('22', '2', null, null, 'string', '/area/02_1584521239738.jpg');
INSERT INTO `quainf` VALUES ('23', '1', null, null, 'string', '/area/01_1584523783589.jpg');
INSERT INTO `quainf` VALUES ('24', '1', null, null, 'string', '/area/01_1584523805308.jpg');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '员工');

-- ----------------------------
-- Table structure for tree
-- ----------------------------
DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `area_id` int(20) NOT NULL,
  `tree_id` int(20) DEFAULT NULL,
  `tree_cate` varchar(40) DEFAULT NULL,
  `plant_date` date DEFAULT NULL,
  `tree_state` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `area_id` (`area_id`),
  CONSTRAINT `tree_ibfk_1` FOREIGN KEY (`area_id`) REFERENCES `area` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10027 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tree
-- ----------------------------
INSERT INTO `tree` VALUES ('10006', '1', '1', null, null, null);
INSERT INTO `tree` VALUES ('10007', '1', '2', null, null, null);
INSERT INTO `tree` VALUES ('10008', '1', '3', null, null, null);
INSERT INTO `tree` VALUES ('10009', '1', '4', null, null, null);
INSERT INTO `tree` VALUES ('10010', '1', '5', null, null, null);
INSERT INTO `tree` VALUES ('10011', '2', '1', null, null, null);
INSERT INTO `tree` VALUES ('10012', '2', '2', null, null, null);
INSERT INTO `tree` VALUES ('10013', '2', '3', null, null, null);
INSERT INTO `tree` VALUES ('10014', '2', '4', null, null, null);
INSERT INTO `tree` VALUES ('10015', '3', '1', null, null, null);
INSERT INTO `tree` VALUES ('10016', '3', '2', null, null, null);
INSERT INTO `tree` VALUES ('10017', '3', '3', null, null, null);
INSERT INTO `tree` VALUES ('10018', '3', '4', null, null, null);
INSERT INTO `tree` VALUES ('10019', '3', '5', null, null, null);
INSERT INTO `tree` VALUES ('10020', '2', '10', 'string', '2019-02-03', 'string');
INSERT INTO `tree` VALUES ('10021', '2', '11', '黑加仑', '2019-03-02', '存活');
INSERT INTO `tree` VALUES ('10022', '2', '12', '绿提', '2019-03-02', '存活');
INSERT INTO `tree` VALUES ('10023', '1', '6', '黑加仑', '2019-03-02', '存活');
INSERT INTO `tree` VALUES ('10024', '1', '7', '绿提', '2019-03-02', '存活');
INSERT INTO `tree` VALUES ('10025', '4', '1', '绿提', '2019-03-02', '敌法');
INSERT INTO `tree` VALUES ('10026', '2', '13', '黑加仑', '2019-03-02', '存活');

-- ----------------------------
-- Table structure for treecate
-- ----------------------------
DROP TABLE IF EXISTS `treecate`;
CREATE TABLE `treecate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tree_cate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of treecate
-- ----------------------------
INSERT INTO `treecate` VALUES ('1', '黑加仑');
INSERT INTO `treecate` VALUES ('2', '红提');
INSERT INTO `treecate` VALUES ('3', '绿提');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(20) NOT NULL,
  `password` varchar(80) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `nikename` varchar(50) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123', '123', null, '123', null, null, '2');
INSERT INTO `user` VALUES ('ff', 'ff', null, null, null, null, '1');
INSERT INTO `user` VALUES ('sd', 'sd', '1', null, null, null, '1');

-- ----------------------------
-- Procedure structure for insertArea
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertArea`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertArea`(IN name VARCHAR(50),IN addr VARCHAR(50))
BEGIN
		DECLARE maxid INT;
		SELECT MAX(area_id) into maxid from area ;
		SET @sql = CONCAT("alter table area AUTO_INCREMENT=",maxid);
		PREPARE q from @sql;
		EXECUTE q;
		insert into area(area_name,addr) value(name,addr);
	END
;;
DELIMITER ;
