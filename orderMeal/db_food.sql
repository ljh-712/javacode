/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.27 : Database - db_food
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_food` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_food`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `goodsDesc` varchar(200) DEFAULT NULL,
  `imageLink` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */


/*Table structure for table `order_goods` */

DROP TABLE IF EXISTS `order_goods`;

CREATE TABLE `order_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(50) DEFAULT NULL,
  `goodsTotalPrice` float DEFAULT NULL,
  `goodsId` int(10) DEFAULT NULL,
  `goodsPrice` float DEFAULT NULL,
  `goodsNum` int(10) DEFAULT NULL,
  `goodsName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_goods_2` (`orderId`),
  KEY `FK_order_goods_1` (`goodsId`),
  CONSTRAINT `FK_order_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`),
  CONSTRAINT `FK_order_goods_2` FOREIGN KEY (`orderId`) REFERENCES `order_info` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Data for the table `order_goods` */

insert  into `order_goods`(`id`,`orderId`,`goodsTotalPrice`,`goodsId`,`goodsPrice`,`goodsNum`,`goodsName`) values (23,'20130708001514',12,10,12,1,'回锅肉'),(28,'20130708021437',12,10,12,1,'回锅肉'),(31,'20130708110510',22,5,22,1,'青椒肉丝'),(32,'20130708110510',9,9,9,1,'鱼香肉丝'),(33,'20130708110513',12,10,12,1,'回锅肉'),(34,'20130708110513',32,11,32,1,'热狗肠'),(39,'20130708115503',2,8,2,1,'21'),(40,'20130708115508',12,10,12,1,'回锅肉'),(41,'20130708115508',32,11,32,1,'热狗肠'),(42,'20130708115512',22,5,22,1,'青椒肉丝'),(43,'20130708121456',9,9,9,1,'鱼香肉丝');

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `orderId` varchar(50) NOT NULL,
  `orderStatus` int(10) DEFAULT NULL,
  `orderNum` int(10) DEFAULT NULL,
  `orderTotalMoney` float DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_info` */


/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `rank` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`password`,`email`,`rank`) values (1,'admin','123',NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
