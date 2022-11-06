/********************************************************************************
** Form generated from reading UI file 'lkj.ui'
**
** Created by: Qt User Interface Compiler version 6.4.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_LKJ_H
#define UI_LKJ_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QDialog>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QTableView>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_xbb
{
public:
    QWidget *verticalLayoutWidget;
    QVBoxLayout *verticalLayout;
    QPushButton *pushButton;
    QPushButton *pushButton_2;
    QPushButton *pushButton_3;
    QPushButton *pushButton_4;
    QWidget *verticalLayoutWidget_2;
    QVBoxLayout *verticalLayout_2;
    QPushButton *pushButton_5;
    QPushButton *pushButton_6;
    QLineEdit *lineEdit;
    QWidget *verticalLayoutWidget_3;
    QVBoxLayout *verticalLayout_3;
    QPushButton *pushButton_7;
    QPushButton *pushButton_8;
    QTableView *tableView;

    void setupUi(QDialog *xbb)
    {
        if (xbb->objectName().isEmpty())
            xbb->setObjectName("xbb");
        xbb->resize(1768, 1151);
        verticalLayoutWidget = new QWidget(xbb);
        verticalLayoutWidget->setObjectName("verticalLayoutWidget");
        verticalLayoutWidget->setGeometry(QRect(770, 20, 172, 141));
        verticalLayout = new QVBoxLayout(verticalLayoutWidget);
        verticalLayout->setObjectName("verticalLayout");
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        pushButton = new QPushButton(verticalLayoutWidget);
        pushButton->setObjectName("pushButton");
        QFont font;
        font.setFamilies({QString::fromUtf8("Agency FB")});
        font.setPointSize(16);
        pushButton->setFont(font);

        verticalLayout->addWidget(pushButton);

        pushButton_2 = new QPushButton(verticalLayoutWidget);
        pushButton_2->setObjectName("pushButton_2");
        pushButton_2->setFont(font);

        verticalLayout->addWidget(pushButton_2);

        pushButton_3 = new QPushButton(verticalLayoutWidget);
        pushButton_3->setObjectName("pushButton_3");
        pushButton_3->setFont(font);

        verticalLayout->addWidget(pushButton_3);

        pushButton_4 = new QPushButton(verticalLayoutWidget);
        pushButton_4->setObjectName("pushButton_4");
        pushButton_4->setFont(font);

        verticalLayout->addWidget(pushButton_4);

        verticalLayoutWidget_2 = new QWidget(xbb);
        verticalLayoutWidget_2->setObjectName("verticalLayoutWidget_2");
        verticalLayoutWidget_2->setGeometry(QRect(770, 170, 171, 81));
        verticalLayout_2 = new QVBoxLayout(verticalLayoutWidget_2);
        verticalLayout_2->setObjectName("verticalLayout_2");
        verticalLayout_2->setContentsMargins(0, 0, 0, 0);
        pushButton_5 = new QPushButton(verticalLayoutWidget_2);
        pushButton_5->setObjectName("pushButton_5");
        pushButton_5->setFont(font);

        verticalLayout_2->addWidget(pushButton_5);

        pushButton_6 = new QPushButton(verticalLayoutWidget_2);
        pushButton_6->setObjectName("pushButton_6");
        pushButton_6->setFont(font);

        verticalLayout_2->addWidget(pushButton_6);

        lineEdit = new QLineEdit(xbb);
        lineEdit->setObjectName("lineEdit");
        lineEdit->setGeometry(QRect(770, 260, 151, 31));
        lineEdit->setFont(font);
        verticalLayoutWidget_3 = new QWidget(xbb);
        verticalLayoutWidget_3->setObjectName("verticalLayoutWidget_3");
        verticalLayoutWidget_3->setGeometry(QRect(770, 300, 161, 91));
        verticalLayout_3 = new QVBoxLayout(verticalLayoutWidget_3);
        verticalLayout_3->setObjectName("verticalLayout_3");
        verticalLayout_3->setContentsMargins(0, 0, 0, 0);
        pushButton_7 = new QPushButton(verticalLayoutWidget_3);
        pushButton_7->setObjectName("pushButton_7");
        pushButton_7->setFont(font);

        verticalLayout_3->addWidget(pushButton_7);

        pushButton_8 = new QPushButton(verticalLayoutWidget_3);
        pushButton_8->setObjectName("pushButton_8");
        pushButton_8->setFont(font);

        verticalLayout_3->addWidget(pushButton_8);

        tableView = new QTableView(xbb);
        tableView->setObjectName("tableView");
        tableView->setGeometry(QRect(20, 20, 721, 371));
        QFont font1;
        font1.setPointSize(14);
        tableView->setFont(font1);
        tableView->horizontalHeader()->setMinimumSectionSize(161);
        tableView->horizontalHeader()->setDefaultSectionSize(200);
        tableView->verticalHeader()->setMinimumSectionSize(80);
        tableView->verticalHeader()->setDefaultSectionSize(120);

        retranslateUi(xbb);

        QMetaObject::connectSlotsByName(xbb);
    } // setupUi

    void retranslateUi(QDialog *xbb)
    {
        xbb->setWindowTitle(QCoreApplication::translate("xbb", "Dialog", nullptr));
        pushButton->setText(QCoreApplication::translate("xbb", "\346\217\220\344\272\244\344\277\256\346\224\271", nullptr));
        pushButton_2->setText(QCoreApplication::translate("xbb", "\346\222\244\351\224\200\344\277\256\346\224\271", nullptr));
        pushButton_3->setText(QCoreApplication::translate("xbb", "\346\267\273\345\212\240\350\256\260\345\275\225", nullptr));
        pushButton_4->setText(QCoreApplication::translate("xbb", "\345\210\240\351\231\244\351\200\211\344\270\255\350\241\214", nullptr));
        pushButton_5->setText(QCoreApplication::translate("xbb", "\346\214\211id\345\215\207\345\272\217\346\216\222\345\272\217", nullptr));
        pushButton_6->setText(QCoreApplication::translate("xbb", "\346\214\211id\351\231\215\345\272\217\346\216\222\345\272\217", nullptr));
        lineEdit->setText(QCoreApplication::translate("xbb", "\345\247\223\345\220\215", nullptr));
        pushButton_7->setText(QCoreApplication::translate("xbb", "\346\237\245\350\257\242", nullptr));
        pushButton_8->setText(QCoreApplication::translate("xbb", "\350\241\250\347\244\272\345\205\250\350\241\250", nullptr));
    } // retranslateUi

};

namespace Ui {
    class xbb: public Ui_xbb {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_LKJ_H
