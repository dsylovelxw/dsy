/*
SQLyog v10.2 
MySQL - 5.5.37 : Database - smbmsquan
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smbmsquan` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `smbmsquan`;

/*Table structure for table `lode_meun` */

DROP TABLE IF EXISTS `lode_meun`;

CREATE TABLE `lode_meun` (
  `lodeId` int(11) NOT NULL,
  `meunId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `lode_meun` */

insert  into `lode_meun`(`lodeId`,`meunId`) values (2,1),(2,2),(2,3),(2,6),(2,8),(2,4),(2,5),(3,1),(2,2),(1,1),(1,2),(1,3),(1,6),(1,8),(1,4),(1,7),(1,13),(1,14),(1,5),(1,9),(1,30),(1,31),(1,32),(1,33);

/*Table structure for table `lr_bumeng` */

DROP TABLE IF EXISTS `lr_bumeng`;

CREATE TABLE `lr_bumeng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meng_name` varchar(100) NOT NULL,
  `renshu_id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

/*Data for the table `lr_bumeng` */

insert  into `lr_bumeng`(`id`,`meng_name`,`renshu_id`,`userId`) values (1,'开发部',10,1),(2,'董事部',2,2),(3,'运维部',5,3);

/*Table structure for table `lr_lode` */

DROP TABLE IF EXISTS `lr_lode`;

CREATE TABLE `lr_lode` (
  `id` int(11) NOT NULL,
  `lodName` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lr_lode` */

insert  into `lr_lode`(`id`,`lodName`) values (1,'超级管理员'),(2,'管理员'),(3,'用户');

/*Table structure for table `lr_meun` */

DROP TABLE IF EXISTS `lr_meun`;

CREATE TABLE `lr_meun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mName` varchar(100) NOT NULL,
  `fatherid` int(11) NOT NULL,
  `mbetn` varchar(500) NOT NULL,
  `type` int(11) NOT NULL,
  `ishide` int(11) DEFAULT '0',
  `resUrl` varchar(100) DEFAULT NULL,
  `js` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

/*Data for the table `lr_meun` */

insert  into `lr_meun`(`id`,`mName`,`fatherid`,`mbetn`,`type`,`ishide`,`resUrl`,`js`) values (1,'系统基础管理',0,' 系统基础管理 ',1,0,'','11'),(2,'用户管理',1,'<a href=\"/EMentTet/UserServlet?action=EasybuyUserLists\">用户管理</a>',2,0,'/denglu/QuanSerlvet?action=YonghuList','js/yonghu/userList.js'),(3,'新增',2,'<button type=\'button\' lay-event=\'addFunc\' class=\'layui-btn layui-btn-warm xz\'><i class=\'layui-icon\'>&#xe654;</i>新增</button>',3,0,'addFunc','222'),(4,'权限管理',1,'<a href=\"/EMentTet/MeunSerlvet?action=QuanUserLists\">权限管理</a>',2,0,'/denglu/QuanSerlvet?action=QuanxianList','js/quan/userList.js'),(5,'角色管理',1,'<a href=\"/EMentTet/JueseServlet?action=JueseLists\">角色管理</a>',2,0,'/denglu/QuanSerlvet?action=JueseList','js/juese/userList.js'),(6,'修改',2,'<button type=\'button\' lay-event=\'editFun\' class=\'layui-btn layui-btn-normal xz\'><i class=\'layui-icon\'>&#xe642;</i>修改</button>',3,0,'editFun','111'),(7,'新增',4,'<button type=\'button\' lay-event=\'addFunc\' class=\'layui-btn layui-btn-warm xz\'><i class=\'layui-icon\'>&#xe654;</i>新增</button>',3,0,'addFunc','222'),(8,'删除',2,'<button type=\'button\' lay-event=\'delFunc\' class=\'layui-btn layui-btn-danger xz\'><i class=\'layui-icon\'>&#xe640;</i>删除</button>',3,0,'delFunc','222'),(9,'分配',5,'<button type=\'button\' lay-event=\'fenFunc\' class=\'layui-btn layui-btn-primary xz\'><i class=\'layui-icon\'>&#xe654;</i>分配</button>',3,0,'fenFunc','222'),(13,'修改',4,'<button type=\'button\' lay-event=\'editFun\' class=\'layui-btn layui-btn-normal xz\'><i class=\'layui-icon\'>&#xe642;</i>修改</button>',3,0,'editFun','111'),(14,'删除',4,'<button type=\'button\' lay-event=\'delFunc\' class=\'layui-btn layui-btn-danger xz\'><i class=\'layui-icon\'>&#xe640;</i>删除</button>',3,0,'delFunc','111'),(30,'部门管理',1,'<a href=\"/EMentTet/BumenServletZXD?action=BumenBtn\">部门管理</a>',2,0,'/BumenServletZXD?action=BumenBtn','/EMentTet/js/bumen/bumenList.js'),(31,'新增部门',30,'<button type=\'button\' lay-event=\'addFunc\' class=\'layui-btn layui-btn-warm xz\'><i class=\'layui-icon\'>&#xe654;</i>新增部门</button>',3,0,'inBumen',NULL),(32,'修改部门',30,'<button type=\'button\' lay-event=\'editFun\' class=\'layui-btn layui-btn-normal xz\'><i class=\'layui-icon\'>&#xe642;</i>修改部门</button>',3,0,'upBumen',NULL),(33,'删除部门',30,'<button type=\'button\' lay-event=\'delFunc\' class=\'layui-btn layui-btn-danger xz\'><i class=\'layui-icon\'>&#xe640;</i>删除部门</button>',3,0,'delBumen',NULL);

/*Table structure for table `lr_user` */

DROP TABLE IF EXISTS `lr_user`;

CREATE TABLE `lr_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `userCode` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `userPassword` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户密码',
  `gender` int(10) DEFAULT NULL COMMENT '性别（1:女、 2:男）',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `address` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `bumeng_id` int(11) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `zhicheng_id` int(10) DEFAULT NULL COMMENT '职称关系',
  `lode_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `d` (`zhicheng_id`),
  KEY `b` (`bumeng_id`),
  KEY `c` (`lode_id`),
  CONSTRAINT `c` FOREIGN KEY (`lode_id`) REFERENCES `lr_lode` (`id`),
  CONSTRAINT `b` FOREIGN KEY (`bumeng_id`) REFERENCES `lr_bumeng` (`id`),
  CONSTRAINT `d` FOREIGN KEY (`zhicheng_id`) REFERENCES `lr_zhicheng` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `lr_user` */

insert  into `lr_user`(`id`,`userCode`,`userName`,`userPassword`,`gender`,`birthday`,`phone`,`address`,`bumeng_id`,`age`,`zhicheng_id`,`lode_id`) values (1,'admin','系统管理员','12345',1,'1983-10-10','13688889999','北京市海淀区成府路207号',2,22,1,1),(2,'liming','李明','12345',0,'1983-12-10','13688884457','北京市东城区前门东大街9号',1,23,3,2),(5,'hanlubiao','韩路彪','0000000',0,'2012-12-18','18567542321','合肥',3,52,3,2),(19,'1241234','13242352','123456',2,NULL,'23222222222',NULL,1,23,1,1);

/*Table structure for table `lr_zhicheng` */

DROP TABLE IF EXISTS `lr_zhicheng`;

CREATE TABLE `lr_zhicheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zhi_nmae` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=gb2312;

/*Data for the table `lr_zhicheng` */

insert  into `lr_zhicheng`(`id`,`zhi_nmae`) values (1,'董事长'),(2,'经理'),(3,'项目组长'),(4,'员工');

/*Table structure for table `ls_butten` */

DROP TABLE IF EXISTS `ls_butten`;

CREATE TABLE `ls_butten` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `btntype` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

/*Data for the table `ls_butten` */

insert  into `ls_butten`(`id`,`btntype`) values (1,'<button type=\'button\' lay-event=\'delFunc\' class=\'layui-btn layui-btn-danger xz\'><i class=\'layui-icon\'>&#xe640;</i>删除</button>'),(2,'<button type=\'button\' lay-event=\'addFunc\' class=\'layui-btn layui-btn-warm xz\'><i class=\'layui-icon\'>&#xe654;</i>新增</button>'),(3,'<button type=\'button\' lay-event=\'upFunc\' class=\'layui-btn layui-btn-normal xz\'><i class=\'layui-icon\'>&#xe642;</i>修改</button>'),(4,'<button type=\'button\' lay-event=\'shangFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\'layui-icon\'>&#xe681;</i>上传</button>'),(5,'<button type=\'button\' lay-event=\'xiaFunc\' class=\'layui-btn layui-btn-radius xz\'><i class=\"layui-icon\">&#xe601;</i>下载</button>'),(6,'<button type=\'button\' lay-event=\'fenFunc\' class=\'layui-btn layui-btn-primary xz\'><i class=\'layui-icon\'>&#xe654;</i>分配</button>');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
