#include "biaozundialog.h"
#include "ui_biaozundialog.h"

#include <QColorDialog>
#include <QFileDialog>
#include <QFontDialog>

biaozunDialog::biaozunDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::biaozunDialog)
{
    ui->setupUi(this);
}

biaozunDialog::~biaozunDialog()
{

    delete ui;
}  



void biaozunDialog::on_pushButton_clicked()
{
    QString s=QFileDialog::getOpenFileName(this,"open file dialog", "/","C++files(*.cpp);;C files(*.c);;Head files(*.h)");
   ui->fileLineEdit->setText(s.toLatin1());
}

void biaozunDialog::slotOpenFileDlg()
{
     QString s=QFileDialog::getOpenFileName(this,"open file dialog", "/","C++files(*.cpp);;C files(*.c);;Head files(*.h)");

}

void biaozunDialog::on_pushButton_2_clicked()
{
    QColor color = QColorDialog::getColor(Qt::blue);
    if(color.isValid())
        {
          ui->colorFrame->setPalette(QPalette(color));
        }
}

void biaozunDialog::on_pushButton_3_clicked()
{
    bool ok;
       QFont font = QFontDialog::getFont(&ok);
       if(ok)
         {
           ui->fontLineEdit->setFont(font);
         }
}
