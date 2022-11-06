#include "logindialog.h"
#include "ui_logindialog.h"
#include "QDebug"
#include "manager.h"

LoginDialog::LoginDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::LoginDialog)
{
    ui->setupUi(this);
    resize(500 ,400);

    setWindowTitle(tr("登录"));
    ui->pwdLineEdit->setFocus();
    ui->loginBtn->setDefault(true);
}

LoginDialog::~LoginDialog()
{
    delete ui;
}

void LoginDialog::on_loginBtn_clicked()
{
    if (ui->pwdLineEdit->text().isEmpty()) {
        QMessageBox::information(this, tr("请输入密码"), tr("请先输入密码再登录！"), QMessageBox::Ok);
        ui->pwdLineEdit->setFocus();
    } else {
        QSqlQuery query;
        query.exec("select pwd from password");
        query.next();
        qDebug() << "query.value(0).toString()=" << query.value(0).toString();
        if (query.value(0).toString() == ui->pwdLineEdit->text()) {
            qDebug() << "登陆成功";
            QDialog::accept();
        } else {
            qDebug() << "登陆错误";
            QMessageBox::warning(this, tr("密码错误"), tr("请输入正确的密码再登录！"), QMessageBox::Ok);
            ui->pwdLineEdit->clear();
            ui->pwdLineEdit->setFocus();
        }
    }
}

void LoginDialog::on_quitBtn_clicked()
{
    QDialog::reject();
}
