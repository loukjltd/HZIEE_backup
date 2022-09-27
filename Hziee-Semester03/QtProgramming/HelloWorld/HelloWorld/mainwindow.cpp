#include "mainwindow.h"
#include "ui_mainwindow.h"
#include "lkjpoint.h"

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

LKJPoint lkj;

void MainWindow::on_pushButton_clicked()
{
    lkj.Add();
    lkj.Show();
    lkj.ShowUnderline();
}

