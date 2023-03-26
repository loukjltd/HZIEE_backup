#include "choutidialog.h"
#include "ui_choutidialog.h"

choutiDialog::choutiDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::choutiDialog)
{
    ui->setupUi(this);
}

choutiDialog::~choutiDialog()
{
    delete ui;
}
