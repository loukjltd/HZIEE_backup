#include "biaozundialog.h"
//#include "chouti.h"
#include "choutidialog.h"
#include "drawer.h"
#include "mainwindow.h"
#include "qmessageboxdialog.h"
#include "windialog.h"

#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    MainWindow w;
    biaozunDialog b;
    winDialog win;
    QMessageBoxDialog q;
    Drawer bi;
        bi.show();
    b.show();
    win.show();
    q.show();
    return a.exec();
}
