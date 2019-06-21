# Host: localhost  (Version 5.5.62)
# Date: 2018-12-22 23:05:10
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "userorder"
#

CREATE TABLE `userorder` (
  `Id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `userId` varchar(255) NOT NULL DEFAULT '' COMMENT '证件号',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '手机号',
  `name` varchar(255) DEFAULT '匿名' COMMENT '下单人',
  `statu` varchar(255) NOT NULL DEFAULT '已提交' COMMENT '订单状态',
  `startTime` datetime DEFAULT NULL COMMENT '提交时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  `totalPrice` decimal(10,2) DEFAULT '0.00' COMMENT '订单总价',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户订单表';

#
# Data for table "userorder"
#

INSERT INTO `userorder` VALUES (2,'441802199604047896','13750002345','李四','已提交','2018-12-12 00:00:00','2018-12-22 09:47:30',0.00),(3,'441802199912311234','13750001234','李四','已提交','2018-12-21 22:07:55','2018-12-21 22:07:55',0.00),(4,'441802199806012345','13712345678','鲁花油','已提交','2018-12-21 22:32:01','2018-12-21 22:32:01',0.00),(7,'441802199604047896','13750002345','马克','已提交','2018-12-22 09:45:52','2018-12-22 09:45:52',0.00),(8,'441802200101014567','13750002345','大狗子','已提交','2018-12-22 21:01:50','2018-12-22 21:01:50',0.00),(9,'441802198903033456','13750007896','黄山美','已提交','2018-12-22 21:02:43','2018-12-22 21:02:43',0.00);
