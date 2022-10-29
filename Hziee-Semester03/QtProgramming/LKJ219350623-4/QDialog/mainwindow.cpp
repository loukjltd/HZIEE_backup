#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QFileDialog>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent)
    , ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    ui->sComboBox->addItem("男");
    ui->sComboBox->addItem("女");

    ui->label_avatar->setPixmap(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QDialog/images/filesave.png"));
}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_pushButton_clicked()
{
    QString filePath = QFileDialog::getOpenFileName(this, tr("选择图片"), ".", tr("Image Files(*.jpg *.png)"));
    if (filePath == "") {
        ui->label_avatar->setPixmap(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-4/QDialog/images/filesave.png"));
    } else {
        ui->label_avatar->setPixmap(filePath);
    }

}

