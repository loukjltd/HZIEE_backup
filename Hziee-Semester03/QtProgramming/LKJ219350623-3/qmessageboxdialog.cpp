#include "qmessageboxdialog.h"
#include "ui_qmessageboxdialog.h"

#include <QMessageBox>

QMessageBoxDialog::QMessageBoxDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::QMessageBoxDialog)
{
    ui->setupUi(this);
}

QMessageBoxDialog::~QMessageBoxDialog()
{
    delete ui;
}

void QMessageBoxDialog::on_QButton_clicked()
{
    switch(QMessageBox::question(this,tr("问题"),tr("已到达文档结尾,是否从头搜索?"), QMessageBox::Ok|QMessageBox::Cancel, QMessageBox::Ok))
          {
          case QMessageBox::Ok:
            ui->label->setText("Question button / OK");break;
          case QMessageBox::Cancel:
            ui->label->setText("Question button / Cancel");break;
          default: break;
          }
}

void QMessageBoxDialog::on_InpushButton_clicked()
{
     QMessageBox::information(this,"Information",tr("这是信息显示内容"));
}

void QMessageBoxDialog::on_WpushButton_clicked()
{
    switch(QMessageBox::warning(this,tr("警告"),tr("是否保存对文档的修改?"), QMessageBox::Save|QMessageBox::Discard|QMessageBox::Cancel, QMessageBox::Save))
        {
        case QMessageBox::Save:
          ui->label->setText("Warning button / Save");break;
        case QMessageBox::Discard:
          ui->label->setText("Warning button / Discard");break;
        case QMessageBox::Cancel:
          ui->label->setText("Warning button / Cancel");break;
        default: break;
        }
}

void QMessageBoxDialog::on_CrpushButton_clicked()
{
    QMessageBox::critical(this,"Information", tr("Fatal Error"));
       ui->label->setText("Critical");
}

void QMessageBoxDialog::on_ApushButton_clicked()
{
    QMessageBox::about(this, "About", tr("QMessageBox 实例"));
      ui->label->setText("About QMessageBox");
}

void QMessageBoxDialog::on_AQButton_clicked()
{
    QMessageBox::aboutQt(this,"About Qt");
     ui->label->setText("About Qt QMessageBox");
}

void QMessageBoxDialog::on_CButton_clicked()
{
    QMessageBox customMsgBox;
     customMsgBox.setWindowTitle("Custom Message Box");
     QPushButton *lockButton = customMsgBox.addButton(tr("Lock"),QMessageBox::ActionRole);
     QPushButton *unlockButton = customMsgBox.addButton(tr("Unlock"),QMessageBox::ActionRole);
     QPushButton *cancelButton = customMsgBox.addButton(QMessageBox::Cancel);
     customMsgBox.setIconPixmap(QPixmap("/Users/loukj/Documents/GitHub/HzieeBackup/Hziee-Semester03/QtProgramming/LKJ219350623-3/images/filesave.png"));
     customMsgBox.setText(tr("这是一条自定义的消息框！"));
     customMsgBox.exec();
     if(customMsgBox.clickedButton() == lockButton)
         ui->label->setText(" Custom MessageBox / Lock ");
     if(customMsgBox.clickedButton() == unlockButton)
         ui->label->setText(" Custom MessageBox / Unlock ");
     if(customMsgBox.clickedButton() == cancelButton)
         ui->label->setText(" Custom MessageBox / Cancel ");
}
