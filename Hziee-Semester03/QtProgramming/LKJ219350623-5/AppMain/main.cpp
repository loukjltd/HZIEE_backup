#include "mainwindow.h"

#include <QApplication>

#include <QPixmap>
#include <QSplashScreen>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);

    QPixmap pixmap(":/images/images/LKJ01113.jpeg");  /* 设置启动图片 */
    QSplashScreen splash(pixmap); /* 利用QPixmap对象创建一个QSplashScreen对象 */
    splash.show();
    a.processEvents();

    MainWindow w;
    w.show();

    splash.finish((&w));

    return a.exec();
}
