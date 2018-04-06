-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	5.7.18-1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tb_article`
--

DROP TABLE IF EXISTS `tb_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_name` varchar(1024) NOT NULL,
  `article_image` varchar(2448) DEFAULT NULL,
  `article_type_id` int(11) NOT NULL,
  `article_desc` text NOT NULL,
  `article_text` text NOT NULL,
  `article_create_time` datetime DEFAULT NULL,
  `article_last_edit_time` datetime DEFAULT NULL,
  `article_like` int(11) DEFAULT '0',
  `article_priority` int(11) DEFAULT '0',
  `article_owner_id` int(11) NOT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_article`
--

LOCK TABLES `tb_article` WRITE;
/*!40000 ALTER TABLE `tb_article` DISABLE KEYS */;
INSERT INTO `tb_article` VALUES (4,'有一个      不重要      的标题','/upload/item/blog/1/4/2018031118301975324.jpg',3,'很不中要的案例看发动机爱上了； 洒类似的咖啡机爱上了对方拉斯快递费','### amazeui 啦啦啦啦阿拉啦\n\n通过 \"data-provide = am-md-editable\" 调用MD编辑器','2018-03-11 10:30:19',NULL,0,NULL,1),(5,'helkf的房价来      看的福利卡积分离开的房间辣 ','/upload/item/blog/1/5/2018031216575664372.jpg',3,'是的发送到是打发斯蒂芬德国法国电视是是打发斯蒂芬对方水电费是的发生阿斯顿发生','### amazeui 啦啦啦啦阿拉啦\n\n通过 \"data-provide = am-md-editable\" 调用MD编辑器','2018-03-12 08:57:56',NULL,0,4,1),(6,'dfasf  d','/upload/item/blog/1/6/2018031713472523956.jpg',3,'fsddffghhg','### amazeui 啦啦啦啦阿拉啦\n\n通过 \"data-provide = am-md-editable\" 调用MD编辑器','2018-03-17 05:47:25',NULL,0,6,1),(7,'fdsf辅导辅导费打发打发','/upload/item/blog/1/7/2018032223522667411.jpg',3,'奋斗奋斗的打发打发是发斯蒂芬的','### amazeui 啦啦啦啦阿拉啦\n\n通过 \"data-provide = am-md-editable\" 调用MD编辑器','2018-03-22 15:52:26',NULL,0,7,1),(8,'张见豪测试','/upload/item/blog/1/8/2018032223574628189.jpg',3,'和不重要的测试地方地方大哈哈哈哈哈哈哈','### amazeui 啦啦啦啦阿拉啦\n\n通过 \"data-provide = am-md-editable\" 调用MD编辑器','2018-03-22 15:57:46',NULL,0,NULL,1);
/*!40000 ALTER TABLE `tb_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_article_type`
--

DROP TABLE IF EXISTS `tb_article_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_article_type` (
  `article_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `article_type_name` varchar(100) NOT NULL DEFAULT '',
  `article_type_desc` varchar(1000) DEFAULT '',
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`article_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_article_type`
--

LOCK TABLES `tb_article_type` WRITE;
/*!40000 ALTER TABLE `tb_article_type` DISABLE KEYS */;
INSERT INTO `tb_article_type` VALUES (1,'科技','一些科技技巧',10,NULL,NULL,NULL),(2,'文学','优美的文章',5,NULL,NULL,NULL),(3,'java','java语言',8,NULL,NULL,1),(4,'c++','c++语言',5,NULL,NULL,1),(5,'算法','简单有趣的算法',9,NULL,NULL,1),(6,'轻小说','有趣的小说',4,NULL,NULL,2);
/*!40000 ALTER TABLE `tb_article_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL,
  `user_password` varchar(128) NOT NULL,
  `user_image` varchar(1024) DEFAULT NULL,
  `user_desc` text,
  `create_time` datetime DEFAULT NULL,
  `last_edit_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_local_profile` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES (1,'admin','admin','/upload/item/blog/1/headimage/f14.jpg','我不想成为一个庸俗的人。十年百年后，当我们死去，质疑我们的人同样死去，后人看到的是裹足不前、原地打转的你，还是一直奔跑、走到远方的我？',NULL,NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-05 22:18:58
