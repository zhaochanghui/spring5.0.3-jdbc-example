# spring5.0.3-jdbc-example
W3c上学习spring课程spring-jdbc部分，自己写的例子，教程上中有个bug,spring5.0.3,public Student getStudent(Integer id) .. 这个直接用有问题，我的例子里解决了

** 编辑器是IDEA2017.3.5
** 学习W3C教程spring篇章，下的spring-jdbc一节写的例子，https://www.w3cschool.cn/wkspring/iuck1mma.html

**  上面有个函数有问题：StudentJDBCTemplate 类下的方法 public Student getStudent 有问题，
**  我的例子中以解决了 。参照这的public Employee getById(int id)  方法解决的。里https://www.journaldev.com/2593/spring-jdbc-example解决的。

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;