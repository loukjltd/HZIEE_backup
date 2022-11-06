#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "LoginDialog.h"
#include "manager.h"
#include "lkj.h"

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{

    ui->setupUi(this);
    resize(1280,800);
    //showFullScreen();
    font.setPointSize(15);
    statusBar()->setFont(font);

//用于显示鼠标移动时的鼠标位置
    labelStatus = new QLabel();
    labelStatus->setText(tr("鼠标位置:"));
    labelStatus -> setFixedWidth (160);

//用于显示鼠标按下、释放时鼠标的位置
    labelMousePos = new QLabel();
    labelMousePos->setText(tr(""));
    labelMousePos->setFixedWidth (200);

//在QMainWindow的状态栏中增加控件
    statusBar()->addPermanentWidget(labelStatus);
    statusBar()->addPermanentWidget(labelMousePos);

    this->setMouseTracking (true);//这是激活整个窗体的鼠标追踪

    setAutoFillBackground(true);

    QPalette palette = this->palette();
    palette.setColor(QPalette::Window,Qt::white);
    setPalette(palette);


    width=size().width();
    height=size().height();

    pix = new QPixmap(width,height);
    pix->fill(Qt::white);

    step=32;



    startX=0;
    startY=0;


    drawPix();

}
//鼠标移动事件响应函数
void MainWindow::mouseMoveEvent (QMouseEvent* e)
{
   labelMousePos ->setText("("+QString::number(e->x())+","+QString::number(e->y())+")");
   if(e->buttons()==Qt::LeftButton&&childAt(e->pos())!=NULL){
         startX = e->pos().x();
         startY = e->pos().y();
         drawPix();//重新在pix中绘制图像
         update();//触发界面重画
       }
}
//鼠标按下事件响应函数
void MainWindow::mousePressEvent ( QMouseEvent* e)
{

    QString str="("+QString::number(e->x())+","+QString::number(e->y())+")";
    if(e->button()==Qt::LeftButton)
    {
        statusBar()->showMessage (tr("左键点击:")+str);
    }
    else if(e->button()==Qt::RightButton)
    {
        statusBar()->showMessage (tr("右键点击:")+str);
    }
    else if(e->button()==Qt::MiddleButton)
    {
        statusBar()->showMessage (tr("中间点击:")+str);
    }
}

//鼠标双击事件响应函数
void MainWindow::mouseDoubleClickEvent(QMouseEvent* e)
{
    QString str="("+QString::number(e->x())+","+QString::number(e->y())+")";
    if(e->button()==Qt::LeftButton)
    {
        statusBar()->showMessage (tr("左键双击:")+str);
    }
    else if(e->button()==Qt::RightButton)
    {
        statusBar()->showMessage (tr("右键双击:")+str);
    }
    else if(e->button()==Qt::MiddleButton)
    {
        statusBar()->showMessage (tr("中间双击:")+str);
    }
}

//鼠标松开事件响应函数
void MainWindow::mouseReleaseEvent (QMouseEvent * e )
{
    QString str="("+QString::number(e->x())+","+QString::number(e->y())+")";
    statusBar()->showMessage (tr("鼠标松开:")+str,1000);
}

//drawPix()函数实现在QPixmap对象上绘制图像：
void MainWindow::drawPix()
{
    pix->fill(Qt::white);//重刷pix对象为白色底色
QPainter *painter = new QPainter(pix);//创建QPainter对象，指定pix为绘图设备

    QPen pen(Qt::DotLine);//设置画笔类型，用于绘制网格
    painter->setPen(pen);
    for(int i=step;i<width;)
    {
        painter->drawLine(QPoint(i,0),QPoint(i,height));
        i=i+step;
    }
    for(int j=step;j<height;)
    {
        painter->drawLine(QPoint(0,j),QPoint(width,j));
        j=j+step;
    }

    //在pix对象中绘制可移动的小图标

    painter->drawImage(QPoint(startX,startY),image);
    delete painter;
}

//keyPressEvent()函数处理键盘的按下事件：
void MainWindow::keyPressEvent(QKeyEvent *event)
{
    if(event->modifiers() == Qt::ControlModifier)
    {
        if(event->key() == Qt::Key_Left)
        {
            startX=(startX-1<0)?startX:startX-1;

        }
        if(event->key() == Qt::Key_Right)
        {
            startX=(startX+1+image.width ()>width)?startX:startX+1;

        }
        if(event->key() == Qt::Key_Up)
        {
            startY=(startY-1<0)?startY:startY-1;

        }
        if(event->key() == Qt::Key_Down)
        {
            startY=(startY+1+image.height()>height)?startY:startY+1;

        }
    }
    else
    {
        startX=startX-startX%step;
        startY=startY-startY%step;

        if(event->key() == Qt::Key_Left)
        {
            startX=(startX-step<0)?startX:startX-step;
        }
        if(event->key() == Qt::Key_Right)
        {
            startX=(startX+step+image.width()>width)?startX:startX+step;
        }
        if(event->key() == Qt::Key_Up)
        {
            startY=(startY-step<0)?startY:startY-step;
        }
        if(event->key() == Qt::Key_Down)
        {
            startY=(startY+step+image.height()>height)?startY:startY+step;
        }
        if(event->key() == Qt::Key_Home)
        {
            startX=0;
            startY=0;
        }
        if(event->key() == Qt::Key_End)
        {
            startX=width-image.width();
            startY=height-image.height();
        }
    }
    drawPix();//重新在pix中绘制图像
    update();//触发界面重画
}

//paintEvent()为界面的重画函数，将pix绘制在界面上。具体代码如下：
void MainWindow::paintEvent(QPaintEvent *)
{
    QPainter painter(this);
    painter.drawPixmap(QPoint(0,0),*pix);
}



MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_action_F_triggered()
{
    QString fileName = QFileDialog::getOpenFileName(this,"图片","/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-6/6/images/filenew.png","");
    image.load(fileName);//图片自己定义
    drawPix();
}

void MainWindow::on_action_D_triggered()
{
    lkj t(this);
   t.exec();
}

void MainWindow::on_action_B_triggered()
{

    LoginDialog dlg;
    if (dlg.exec() == QDialog::Accepted) {
        image = QImage();
        m = new manager(this);
        m->show();
    } else {
        ;
    }
}
