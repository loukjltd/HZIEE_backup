/********************************************************************************
** Form generated from reading UI file 'logindialog.ui'
**
** Created by: Qt User Interface Compiler version 6.4.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_LOGINDIALOG_H
#define UI_LOGINDIALOG_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>

QT_BEGIN_NAMESPACE

class Ui_LoginDialog
{
public:
    QLabel *label_32;
    QLineEdit *pwdLineEdit;
    QLabel *label_39;
    QPushButton *loginBtn;
    QPushButton *quitBtn;

    void setupUi(QDialog *LoginDialog)
    {
        if (LoginDialog->objectName().isEmpty())
            LoginDialog->setObjectName("LoginDialog");
        LoginDialog->resize(656, 375);
        label_32 = new QLabel(LoginDialog);
        label_32->setObjectName("label_32");
        label_32->setGeometry(QRect(60, 40, 321, 61));
        QFont font;
        font.setFamilies({QString::fromUtf8("Agency FB")});
        font.setPointSize(24);
        label_32->setFont(font);
        label_32->setFocusPolicy(Qt::TabFocus);
        label_32->setStyleSheet(QString::fromUtf8(""));
        label_32->setAlignment(Qt::AlignCenter);
        pwdLineEdit = new QLineEdit(LoginDialog);
        pwdLineEdit->setObjectName("pwdLineEdit");
        pwdLineEdit->setGeometry(QRect(140, 140, 271, 31));
        QFont font1;
        font1.setFamilies({QString::fromUtf8("Agency FB")});
        font1.setPointSize(28);
        pwdLineEdit->setFont(font1);
        label_39 = new QLabel(LoginDialog);
        label_39->setObjectName("label_39");
        label_39->setGeometry(QRect(50, 120, 61, 61));
        QFont font2;
        font2.setFamilies({QString::fromUtf8("Agency FB")});
        font2.setPointSize(16);
        label_39->setFont(font2);
        loginBtn = new QPushButton(LoginDialog);
        loginBtn->setObjectName("loginBtn");
        loginBtn->setGeometry(QRect(100, 220, 81, 51));
        loginBtn->setFont(font2);
        quitBtn = new QPushButton(LoginDialog);
        quitBtn->setObjectName("quitBtn");
        quitBtn->setGeometry(QRect(290, 220, 81, 51));
        quitBtn->setFont(font2);

        retranslateUi(LoginDialog);

        QMetaObject::connectSlotsByName(LoginDialog);
    } // setupUi

    void retranslateUi(QDialog *LoginDialog)
    {
        LoginDialog->setWindowTitle(QCoreApplication::translate("LoginDialog", "Dialog", nullptr));
        label_32->setText(QCoreApplication::translate("LoginDialog", "\346\254\242\350\277\216\344\275\277\347\224\250\346\225\260\346\215\256\347\256\241\347\220\206\347\263\273\347\273\237", nullptr));
        label_39->setText(QCoreApplication::translate("LoginDialog", "\345\257\206\347\240\201:", nullptr));
        loginBtn->setText(QCoreApplication::translate("LoginDialog", "\347\231\273\351\231\206", nullptr));
        quitBtn->setText(QCoreApplication::translate("LoginDialog", "\351\200\200\345\207\272", nullptr));
    } // retranslateUi

};

namespace Ui {
    class LoginDialog: public Ui_LoginDialog {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_LOGINDIALOG_H
