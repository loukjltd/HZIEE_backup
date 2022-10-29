#define QT3_SUPPORT
#include"drawer.h"
#include <QWidget>
#include <QGroupBox>
#include <QSize>
#include <QIcon>
#include <QPixmap>
#include <QVBoxLayout>
Drawer::Drawer()
{
    setWindowTitle("MY qq");
    QGroupBox *groupBox1 = new QGroupBox;   //创建一个对象
    //工具按钮是一种特殊的按钮，用于快速访问特定命令或选项。
    //与普通命令按钮相反，工具按钮通常不显示文本标签，而是显示图标。
    toolbutton1_1 = new QToolButton;        //创建一个工具按钮
    //对按钮的文字图标以及图标大小进行设置
    toolbutton1_1->setText("huanhuan");
    toolbutton1_1->setIcon(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/ww.png"));//添加图片路径
    toolbutton1_1->setIconSize(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/ww.png ").size());
    //设置鼠标离开按钮自动弹起
    toolbutton1_1->setAutoRaise(true);
    //文字显示在图标下面
    /*
        ToolButtonIconOnly, 只显示图标
        ToolButtonTextOnly, 只显示文字
        ToolButtonTextBesideIcon,文字显示在图标旁边
        ToolButtonTextUnderIcon,文字显示在图标下边
        ToolButtonFollowStyle
    */
    toolbutton1_1->setToolButtonStyle(Qt::ToolButtonTextUnderIcon);

    toolbutton1_2 = new QToolButton;
    toolbutton1_2->setText("beibei");
    toolbutton1_2->setIcon(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/bb.png"));
    toolbutton1_2->setIconSize(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/bb.png").size());
    toolbutton1_2->setAutoRaise(true);
    toolbutton1_2->setToolButtonStyle(Qt::ToolButtonTextUnderIcon);
    toolbutton1_2->setToolButtonStyle(Qt::ToolButtonTextUnderIcon);

    toolbutton1_3 = new QToolButton;
    toolbutton1_3->setText("ff");
    toolbutton1_3->setIcon(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/ff.png"));
    toolbutton1_3->setIconSize(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/ff.png").size());
    toolbutton1_3->setAutoRaise(true);
    toolbutton1_3->setToolButtonStyle(Qt::ToolButtonTextUnderIcon);

    toolbutton1_4 = new QToolButton;
    toolbutton1_4->setText("ff");
    toolbutton1_4->setIcon(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/hh.png"));
    toolbutton1_4->setIconSize(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/ff.png").size());
    toolbutton1_4->setAutoRaise(true);
    toolbutton1_4->setToolButtonStyle(Qt::ToolButtonTextUnderIcon);

    toolbutton1_5 = new QToolButton;
    toolbutton1_5->setText("ff");
    toolbutton1_5->setIcon(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/jj.png"));
    toolbutton1_5->setIconSize(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/jj.png").size());
    toolbutton1_5->setAutoRaise(true);
    toolbutton1_5->setToolButtonStyle(Qt::ToolButtonTextUnderIcon);


    QGroupBox *groupBox2 = new QGroupBox;
    toolbutton2_1 = new QToolButton;
    toolbutton2_1->setText("李四光");
    toolbutton2_1->setIcon(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/qq.png"));//添加图片路径
    toolbutton2_1->setIconSize(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/qqimg/qq.png").size());
    toolbutton2_1->setAutoRaise(true);
    toolbutton2_1->setToolButtonStyle(Qt::ToolButtonTextUnderIcon);


    QVBoxLayout *layout = new QVBoxLayout(groupBox1);//创建QVBoxLayout实例用来设置抽屉内按钮布局
//    layout->setMargin(10);  //设置窗体显示间距
    layout->setAlignment(Qt::AlignHCenter);//设置对齐方式
    layout->addWidget(toolbutton1_1);//将抽屉内按钮加入
    layout->addWidget(toolbutton1_2);
     layout->addWidget(toolbutton1_3);
      layout->addWidget(toolbutton1_4);
       layout->addWidget(toolbutton1_5);
    layout->addStretch();//

    QVBoxLayout *layout2 = new QVBoxLayout(groupBox2);
//    layout2->setMargin(10);
    layout2->setAlignment(Qt::AlignHCenter);
    layout2->addWidget(toolbutton2_1);
    layout2->addStretch();//在按钮之后加入占位符，使得所有按钮都能向上对齐，抽屉大小发生改变时按钮大小不变

    this->addItem((QWidget*)groupBox1,"My Friends");//把准备好的抽屉匣插入ToolBox
    this->addItem((QWidget*)groupBox2,"My Student");
}
