#define QT3_SUPPORT
#ifndef CHOUTI_H
#define CHOUTI_H

#include <QToolBox>
#include <qtoolbutton.h>

namespace Ui {
class chouti;
}

class chouti : public QToolBox
{
    Q_OBJECT

public:
    explicit chouti(QWidget *parent=0, Qt::WindowFlags f=0 );
    ~chouti();
    QToolButton *toolButton1_1;//定义各个抽屉里的按键(图像
    QToolButton *toolButton1_2;
    QToolButton *toolButton1_3;
    QToolButton *toolButton1_4;
    QToolButton *toolButton1_5;
    QToolButton *toolButton2_1;
    QToolButton *toolButton2_2;
    QToolButton *toolButton3_1;
    QToolButton *toolButton3_2;
    };



#endif // CHOUTI_H
