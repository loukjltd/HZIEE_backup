#ifndef DRAWER_H
#define DRAWER_H
#include <QToolBox>
#include <QToolButton>

//QToolBox 提供一种列装的层叠窗体
//QToolButton提供一种快速访问命令或选择项
class Drawer:public QToolBox
{
    Q_OBJECT
public:
    Drawer();

    //有些没用到
    QToolButton *toolbutton1_1;
    QToolButton *toolbutton1_2;
    QToolButton *toolbutton1_3;
    QToolButton *toolbutton1_4;
    QToolButton *toolbutton1_5;
    QToolButton *toolbutton2_1;
    QToolButton *toolbutton2_2;
    QToolButton *toolbutton3_1;
    QToolButton *toolbutton3_2;

};
#endif // DRAWER_H

