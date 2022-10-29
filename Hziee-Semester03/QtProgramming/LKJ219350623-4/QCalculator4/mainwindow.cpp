#include "mainwindow.h"
#include "ui_mainwindow.h"


MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);

}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_pushButton_0_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 0;}
        //显示
        ui->lcdNumber->display(num);
}

void MainWindow::on_pushButton_1_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){
        num = num*10 + 1;
    }
    //显示
    ui->lcdNumber->display(num);
}


void MainWindow::on_pushButton_2_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 2;}
    //显示
    ui->lcdNumber->display(num);
}


void MainWindow::on_pushButton_3_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 3;}
    //显示
    ui->lcdNumber->display(num);
}


void MainWindow::on_pushButton_4_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 4;}
    //显示
    ui->lcdNumber->display(num);
}


void MainWindow::on_pushButton_5_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 5;}
    //显示
    ui->lcdNumber->display(num);
}


void MainWindow::on_pushButton_6_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 6;}
    //显示
    ui->lcdNumber->display(num);
}


void MainWindow::on_pushButton_7_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 7;}
    //显示
    ui->lcdNumber->display(num);
}


void MainWindow::on_pushButton_8_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 8;}
    //显示
    ui->lcdNumber->display(num);
}

void MainWindow::on_pushButton_9_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(num<999999999){num = num*10 + 9;}
    //显示
    ui->lcdNumber->display(num);
}

//清0
void MainWindow::on_pushButton_ac_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    num = 0;
    temp = 0;

    //显示
    ui->lcdNumber->display(num);
}

void MainWindow::on_pushButton_equ_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    switch (op) {
    case open_add:
        num = temp + num;
        break;
    case open_sub:
        num = temp - num;
        break;
    case open_mul:
        num = temp * num;
        break;
    case open_div:
        if(num == 0){
            num = 0;
            ui->lcdNumber->display("Error");
            return;
        }
        //当不是整除时
        int a = 0; //用来记录可以整除的部分
        a = temp / num;
        int b = 0; //用来记录取余的部分
        b = temp % num;
        if(b != 0){//如果余数！=0
            int c = 0; //对余数进行处理
            c = (b*100) / num;//保留两位小数
            QString sVal = QString("%1.%2").arg(a).arg(c);
//            QString str=QString::number(temp/num,'f',2);
            ui->lcdNumber->display(sVal);
            return;
        }
        num = a;
        break;
    }
    //操作数清0
    temp = 0;
    //显示
    if(num>999999999){
        ui->lcdNumber->display("Error");
        num = 0;
    }else{
        ui->lcdNumber->display(num);
    }
}

//加法
void MainWindow::on_pushButton_add_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    //如果temp不为0，前面已经输入过操作数
    if(temp != 0){
        //计算
        on_pushButton_equ_clicked();
    }
    //记录加法
    op = open_add;
    //当前值放入第一操作数
    temp = num;
    //num清0
    num = 0;

}

//减法
void MainWindow::on_pushButton_sub_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(temp != 0){
        on_pushButton_equ_clicked();
    }
    op = open_sub;
    temp = num;
    num = 0;
}


void MainWindow::on_pushButton_mul_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(temp != 0){
        on_pushButton_equ_clicked();
    }
    op = open_mul;
    temp = num;
    num = 0;
}

void MainWindow::on_pushButton_div_clicked()
{
    QSoundEffect *effect=new QSoundEffect;
    effect->setSource(QUrl::fromLocalFile("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QCalculator4/calculatorSound.wav"));
    effect->play();
    if(temp != 0){
        on_pushButton_equ_clicked();
    }
    op = open_div;
    temp = num;
    num = 0;
}
