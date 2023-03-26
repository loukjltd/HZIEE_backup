#include "mainwindow.h"
#include "connection.h"

#include <QApplication>
#include <QProcess>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    QProcess process;
    process.start("/usr/local/mysql-8.0.27-macos11-arm64/bin/mysqld");
    if (!createConnection()) return 1;

    MainWindow w;
    w.show();
    return a.exec();
}
