# server_maven
后端的maven代码


version:
mysql 5.7
redis 3.2.10
mybatis 3.3.0

example 示例代码，在做移动端开发的时候，需要服务器，这个demo可以先使用；


（1）创建数据库：
创建库：mybatis_demo

（2）数据库的创建表：
CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `userName` varchar(32) NOT NULL,
  `passWord` varchar(50) NOT NULL,
  `realName` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

