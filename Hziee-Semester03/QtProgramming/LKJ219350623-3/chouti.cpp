#include "chouti.h"
#include "ui_chouti.h"

chouti::chouti(QWidget *parent) :
    QToolBox(parent),
    ui(new Ui::chouti)
{
    ui->setupUi(this);
}

chouti::~chouti()
{
    delete ui;
}
