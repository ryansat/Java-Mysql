/*
SQLyog Enterprise - MySQL GUI v7.15 
MySQL - 5.1.73-community : Database - pkl
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`pkl` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pkl`;

/*Table structure for table `barang` */

DROP TABLE IF EXISTS `barang`;

CREATE TABLE `barang` (
  `ID_BARANG` varchar(20) NOT NULL,
  `NAMA_BARANG` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_BARANG`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `barang` */

insert  into `barang`(`ID_BARANG`,`NAMA_BARANG`) values ('1','HP 1000'),('2','Mouse');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `ID_CUSTOMER` varchar(10) NOT NULL,
  `NAMA` varchar(20) DEFAULT NULL,
  `ALAMAT` varchar(20) DEFAULT NULL,
  `TELEPON` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_CUSTOMER`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`ID_CUSTOMER`,`NAMA`,`ALAMAT`,`TELEPON`) values ('1','Joko','Surabaya','324234');

/*Table structure for table `dimiliki` */

DROP TABLE IF EXISTS `dimiliki`;

CREATE TABLE `dimiliki` (
  `ID_BARANG` varchar(20) NOT NULL,
  `ID_PENJUALAN` varchar(10) NOT NULL,
  `HARGA` int(11) DEFAULT NULL,
  `JUMLAH` int(12) DEFAULT NULL,
  `TOTAL` int(15) DEFAULT NULL,
  KEY `FK_DIMILIKI2` (`ID_PENJUALAN`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `dimiliki` */

insert  into `dimiliki`(`ID_BARANG`,`ID_PENJUALAN`,`HARGA`,`JUMLAH`,`TOTAL`) values ('1','3',560,1,620),('1','2',560,2,1120),('1','1',560,1,560),('1','4',560,1,560),('2','5',450,1,450);

/*Table structure for table `distributor` */

DROP TABLE IF EXISTS `distributor`;

CREATE TABLE `distributor` (
  `ID_DISTRIBUTOR` varchar(20) NOT NULL,
  `NAMA_DISTRIBUTOR` varchar(20) DEFAULT NULL,
  `ALAMAT` varchar(20) DEFAULT NULL,
  `TELEPON` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`ID_DISTRIBUTOR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `distributor` */

insert  into `distributor`(`ID_DISTRIBUTOR`,`NAMA_DISTRIBUTOR`,`ALAMAT`,`TELEPON`) values ('1','JAYA COMP','SURABAYA','342342');

/*Table structure for table `memiliki` */

DROP TABLE IF EXISTS `memiliki`;

CREATE TABLE `memiliki` (
  `ID_BARANG` varchar(20) NOT NULL,
  `ID_ORDER` varchar(10) NOT NULL,
  `HARGA` int(11) DEFAULT NULL,
  `JUMLAH` int(10) DEFAULT NULL,
  KEY `FK_MEMILIKI2` (`ID_ORDER`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `memiliki` */

insert  into `memiliki`(`ID_BARANG`,`ID_ORDER`,`HARGA`,`JUMLAH`) values ('1','2',550,1),('1','1',550,1),('2','3',450,1);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `ID_ORDER` varchar(10) NOT NULL,
  `ID_PEGAWAI` varchar(10) NOT NULL,
  `ID_DISTRIBUTOR` varchar(20) NOT NULL,
  `HARGA` decimal(10,0) DEFAULT NULL,
  `TANGGAL_ORDER` date DEFAULT NULL,
  `KURS` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ID_ORDER`),
  KEY `FK_MEMESAN` (`ID_PEGAWAI`),
  KEY `FK_MENSUPLY` (`ID_DISTRIBUTOR`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `orders` */

insert  into `orders`(`ID_ORDER`,`ID_PEGAWAI`,`ID_DISTRIBUTOR`,`HARGA`,`TANGGAL_ORDER`,`KURS`) values ('3','1','1','450','2014-09-01','0'),('2','1','1','550','2014-08-29','0'),('1','1','1','550','2014-08-29','0');

/*Table structure for table `pegawai` */

DROP TABLE IF EXISTS `pegawai`;

CREATE TABLE `pegawai` (
  `ID_PEGAWAI` varchar(10) NOT NULL,
  `NAMA_PEGAWAI` varchar(20) DEFAULT NULL,
  `GAJI` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_PEGAWAI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `pegawai` */

insert  into `pegawai`(`ID_PEGAWAI`,`NAMA_PEGAWAI`,`GAJI`) values ('1','Dian','34243');

/*Table structure for table `transaksi` */

DROP TABLE IF EXISTS `transaksi`;

CREATE TABLE `transaksi` (
  `ID_PENJUALAN` varchar(10) NOT NULL,
  `ID_PEGAWAI` varchar(10) NOT NULL,
  `ID_CUSTOMER` varchar(10) NOT NULL,
  `HARGA` decimal(10,0) DEFAULT NULL,
  `TANGGAL_TRANSAKSI` date DEFAULT NULL,
  `KURS` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ID_PENJUALAN`),
  KEY `FK_MEMBELI` (`ID_CUSTOMER`),
  KEY `FK_MENJUAL` (`ID_PEGAWAI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `transaksi` */

insert  into `transaksi`(`ID_PENJUALAN`,`ID_PEGAWAI`,`ID_CUSTOMER`,`HARGA`,`TANGGAL_TRANSAKSI`,`KURS`) values ('3','1','1','560','2014-09-30','7200'),('2','1','1','560','2014-08-29','6900'),('1','1','1','560','2014-08-29','6900'),('4','1','1','560','2014-09-01','7000'),('5','1','1','450','2014-09-03','8900'),('6','1','1','2450','2015-01-06','9200'),('7','1','1','2450','2015-01-06','9200');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `ID_USER` varchar(10) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_USER`,`PASSWORD`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`ID_USER`,`PASSWORD`) values ('123','fajar');

/*Table structure for table `penjualan` */

DROP TABLE IF EXISTS `penjualan`;

/*!50001 DROP VIEW IF EXISTS `penjualan` */;
/*!50001 DROP TABLE IF EXISTS `penjualan` */;

/*!50001 CREATE TABLE `penjualan` (
  `Barang` varchar(20) DEFAULT NULL,
  `Jumlah Beli` decimal(32,0) DEFAULT NULL,
  `Jumlah Terjual` decimal(32,0) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 */;

/*Table structure for table `price` */

DROP TABLE IF EXISTS `price`;

/*!50001 DROP VIEW IF EXISTS `price` */;
/*!50001 DROP TABLE IF EXISTS `price` */;

/*!50001 CREATE TABLE `price` (
  `NAMA_BARANG` varchar(20) DEFAULT NULL,
  `HARGA` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 */;

/*View structure for view penjualan */

/*!50001 DROP TABLE IF EXISTS `penjualan` */;
/*!50001 DROP VIEW IF EXISTS `penjualan` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `penjualan` AS select `a`.`NAMA_BARANG` AS `Barang`,sum(`b`.`JUMLAH`) AS `Jumlah Beli`,sum(`c`.`JUMLAH`) AS `Jumlah Terjual` from ((`barang` `a` join `dimiliki` `b` on((`b`.`ID_BARANG` = `a`.`ID_BARANG`))) join `memiliki` `c` on((`c`.`ID_BARANG` = `b`.`ID_BARANG`))) group by `a`.`NAMA_BARANG` */;

/*View structure for view price */

/*!50001 DROP TABLE IF EXISTS `price` */;
/*!50001 DROP VIEW IF EXISTS `price` */;

/*!50001 CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `price` AS select `barang`.`NAMA_BARANG` AS `NAMA_BARANG`,`memiliki`.`HARGA` AS `HARGA` from (`barang` join `memiliki` on((`barang`.`ID_BARANG` = `memiliki`.`ID_BARANG`))) */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
