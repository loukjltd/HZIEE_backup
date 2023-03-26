#ifndef CONNECTION_H
#define CONNECTION_H

#include <QMessageBox>
#include <QSqlDatabase>
#include <QSqlQuery>
static bool createConnection()
{
   QSqlDatabase db = QSqlDatabase::addDatabase("QSQLITE");
   db.setHostName("localhost");
   db.setDatabaseName("mydata");
   db.setUserName("root");
   db.setPassword("");
   if (!db.open()) {
       QMessageBox::critical(0, QObject::tr("无法打开数据库"), "无法创建数据库连接！", QMessageBox::Cancel);
   return false;
   }
   // 下面来创建表
   // 如果 MySQL 数据库中已经存在同名的表，那么下面的代码不会执行
   QSqlQuery query(db);
   // 使数据库支持中文
   query.exec("SET NAMES 'Latin1'");
   // 创建 course 表
   query.exec("create table course (id int primary key, name varchar(20), teacher varchar(20))");
   query.exec("insert into course values(0, '计算机专业', '刘同学')");
   query.exec("insert into course values(1, '金融专业', '张同学')");
   query.exec("insert into course values(2, '英语专业', '白同学')");
   query.exec("insert into course values(3, '会计专业', '李同学')");
   query.exec("insert into course values(4, '机械专业', '王同学')");


   // 创建分类表
   query.exec("create table type(id varchar(20) primary key, name varchar(20))");
   query.exec("insert into type values('0', '请选择类型')");
   query.exec("insert into type values('01', '手机')");
   query.exec("insert into type values('02', '平板')");
   // 创建品牌表
   query.exec("create table brand(id varchar(20) primary key, name varchar(30), "
   "type varchar(20), price int, sum int, sell int, last int)");
   query.exec("insert into brand values('01', '小米', '手机', 3699, 50, 10, 40)");
   query.exec("insert into brand values('02', '华为', '手机', 6499, 20, 5, 15)");
   query.exec("insert into brand values('03', '荣耀', '手机', 4199, 80, 40, 40)");
   query.exec("insert into brand values('04', 'vivo', '手机', 3999, 40, 10, 30)");
   query.exec("insert into brand values('05', '小米', '平板', 3899, 60, 10, 50)");
   query.exec("insert into brand values('06', '华为', '平板', 2799, 70, 20, 50)");
   query.exec("insert into brand values('07', '苹果', '手机', 8999, 40, 10, 30)");
   // 创建密码表
   query.exec("create table password(id varchar(20) primary key, pwd varchar(50))");
   query.exec("insert into password values('admin', '123')");
   return true;
}
#endif // CONNECTION_H
