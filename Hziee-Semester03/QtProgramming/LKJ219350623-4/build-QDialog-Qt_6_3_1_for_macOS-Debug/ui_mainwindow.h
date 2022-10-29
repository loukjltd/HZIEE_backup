/********************************************************************************
** Form generated from reading UI file 'mainwindow.ui'
**
** Created by: Qt User Interface Compiler version 6.3.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MAINWINDOW_H
#define UI_MAINWINDOW_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QComboBox>
#include <QtWidgets/QFormLayout>
#include <QtWidgets/QGridLayout>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPlainTextEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QTextEdit>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_MainWindow
{
public:
    QWidget *centralwidget;
    QWidget *formLayoutWidget;
    QFormLayout *formLayout;
    QLabel *iLabel;
    QLineEdit *iLineEdit;
    QLabel *mLabel;
    QLineEdit *mLineEdit;
    QLabel *sLabel;
    QComboBox *sComboBox;
    QLabel *aLabel;
    QLineEdit *aLineEdit;
    QLabel *dLabel;
    QPlainTextEdit *dTextEdit;
    QWidget *horizontalLayoutWidget;
    QHBoxLayout *horizontalLayout;
    QLabel *label;
    QLabel *label_avatar;
    QPushButton *pushButton;
    QWidget *verticalLayoutWidget;
    QVBoxLayout *verticalLayout;
    QLabel *label_2;
    QPlainTextEdit *plainTextEdit;
    QWidget *gridLayoutWidget;
    QGridLayout *gridLayout;
    QPushButton *pushButton_3;
    QPushButton *pushButton_2;
    QTextEdit *textEdit;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *MainWindow)
    {
        if (MainWindow->objectName().isEmpty())
            MainWindow->setObjectName(QString::fromUtf8("MainWindow"));
        MainWindow->resize(800, 600);
        centralwidget = new QWidget(MainWindow);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        formLayoutWidget = new QWidget(centralwidget);
        formLayoutWidget->setObjectName(QString::fromUtf8("formLayoutWidget"));
        formLayoutWidget->setGeometry(QRect(60, 40, 190, 241));
        formLayout = new QFormLayout(formLayoutWidget);
        formLayout->setObjectName(QString::fromUtf8("formLayout"));
        formLayout->setContentsMargins(0, 0, 0, 0);
        iLabel = new QLabel(formLayoutWidget);
        iLabel->setObjectName(QString::fromUtf8("iLabel"));

        formLayout->setWidget(0, QFormLayout::LabelRole, iLabel);

        iLineEdit = new QLineEdit(formLayoutWidget);
        iLineEdit->setObjectName(QString::fromUtf8("iLineEdit"));

        formLayout->setWidget(0, QFormLayout::FieldRole, iLineEdit);

        mLabel = new QLabel(formLayoutWidget);
        mLabel->setObjectName(QString::fromUtf8("mLabel"));

        formLayout->setWidget(1, QFormLayout::LabelRole, mLabel);

        mLineEdit = new QLineEdit(formLayoutWidget);
        mLineEdit->setObjectName(QString::fromUtf8("mLineEdit"));

        formLayout->setWidget(1, QFormLayout::FieldRole, mLineEdit);

        sLabel = new QLabel(formLayoutWidget);
        sLabel->setObjectName(QString::fromUtf8("sLabel"));

        formLayout->setWidget(2, QFormLayout::LabelRole, sLabel);

        sComboBox = new QComboBox(formLayoutWidget);
        sComboBox->setObjectName(QString::fromUtf8("sComboBox"));

        formLayout->setWidget(2, QFormLayout::FieldRole, sComboBox);

        aLabel = new QLabel(formLayoutWidget);
        aLabel->setObjectName(QString::fromUtf8("aLabel"));

        formLayout->setWidget(3, QFormLayout::LabelRole, aLabel);

        aLineEdit = new QLineEdit(formLayoutWidget);
        aLineEdit->setObjectName(QString::fromUtf8("aLineEdit"));

        formLayout->setWidget(3, QFormLayout::FieldRole, aLineEdit);

        dLabel = new QLabel(formLayoutWidget);
        dLabel->setObjectName(QString::fromUtf8("dLabel"));

        formLayout->setWidget(4, QFormLayout::LabelRole, dLabel);

        dTextEdit = new QPlainTextEdit(formLayoutWidget);
        dTextEdit->setObjectName(QString::fromUtf8("dTextEdit"));

        formLayout->setWidget(4, QFormLayout::FieldRole, dTextEdit);

        horizontalLayoutWidget = new QWidget(centralwidget);
        horizontalLayoutWidget->setObjectName(QString::fromUtf8("horizontalLayoutWidget"));
        horizontalLayoutWidget->setGeometry(QRect(280, 40, 221, 91));
        horizontalLayout = new QHBoxLayout(horizontalLayoutWidget);
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        label = new QLabel(horizontalLayoutWidget);
        label->setObjectName(QString::fromUtf8("label"));

        horizontalLayout->addWidget(label);

        label_avatar = new QLabel(horizontalLayoutWidget);
        label_avatar->setObjectName(QString::fromUtf8("label_avatar"));

        horizontalLayout->addWidget(label_avatar);

        pushButton = new QPushButton(horizontalLayoutWidget);
        pushButton->setObjectName(QString::fromUtf8("pushButton"));

        horizontalLayout->addWidget(pushButton);

        verticalLayoutWidget = new QWidget(centralwidget);
        verticalLayoutWidget->setObjectName(QString::fromUtf8("verticalLayoutWidget"));
        verticalLayoutWidget->setGeometry(QRect(279, 180, 221, 100));
        verticalLayout = new QVBoxLayout(verticalLayoutWidget);
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        label_2 = new QLabel(verticalLayoutWidget);
        label_2->setObjectName(QString::fromUtf8("label_2"));

        verticalLayout->addWidget(label_2);

        plainTextEdit = new QPlainTextEdit(verticalLayoutWidget);
        plainTextEdit->setObjectName(QString::fromUtf8("plainTextEdit"));

        verticalLayout->addWidget(plainTextEdit);

        gridLayoutWidget = new QWidget(centralwidget);
        gridLayoutWidget->setObjectName(QString::fromUtf8("gridLayoutWidget"));
        gridLayoutWidget->setGeometry(QRect(60, 310, 441, 86));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout->setObjectName(QString::fromUtf8("gridLayout"));
        gridLayout->setContentsMargins(0, 0, 0, 0);
        pushButton_3 = new QPushButton(gridLayoutWidget);
        pushButton_3->setObjectName(QString::fromUtf8("pushButton_3"));

        gridLayout->addWidget(pushButton_3, 0, 2, 1, 1);

        pushButton_2 = new QPushButton(gridLayoutWidget);
        pushButton_2->setObjectName(QString::fromUtf8("pushButton_2"));

        gridLayout->addWidget(pushButton_2, 0, 1, 1, 1);

        textEdit = new QTextEdit(gridLayoutWidget);
        textEdit->setObjectName(QString::fromUtf8("textEdit"));
        textEdit->setEnabled(false);

        gridLayout->addWidget(textEdit, 0, 0, 1, 1);

        MainWindow->setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 800, 22));
        MainWindow->setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        MainWindow->setStatusBar(statusbar);
#if QT_CONFIG(shortcut)
        iLabel->setBuddy(iLineEdit);
        mLabel->setBuddy(mLineEdit);
        sLabel->setBuddy(sComboBox);
        aLabel->setBuddy(aLineEdit);
        dLabel->setBuddy(dTextEdit);
        label_avatar->setBuddy(pushButton);
        label_2->setBuddy(plainTextEdit);
#endif // QT_CONFIG(shortcut)
        QWidget::setTabOrder(iLineEdit, mLineEdit);
        QWidget::setTabOrder(mLineEdit, sComboBox);
        QWidget::setTabOrder(sComboBox, aLineEdit);
        QWidget::setTabOrder(aLineEdit, dTextEdit);
        QWidget::setTabOrder(dTextEdit, textEdit);
        QWidget::setTabOrder(textEdit, pushButton);
        QWidget::setTabOrder(pushButton, plainTextEdit);
        QWidget::setTabOrder(plainTextEdit, pushButton_2);
        QWidget::setTabOrder(pushButton_2, pushButton_3);

        retranslateUi(MainWindow);

        QMetaObject::connectSlotsByName(MainWindow);
    } // setupUi

    void retranslateUi(QMainWindow *MainWindow)
    {
        MainWindow->setWindowTitle(QCoreApplication::translate("MainWindow", "MainWindow", nullptr));
        iLabel->setText(QCoreApplication::translate("MainWindow", "\347\224\250\346\210\267\345\220\215\357\274\210&I\357\274\211\357\274\232", nullptr));
        mLabel->setText(QCoreApplication::translate("MainWindow", "\345\247\223\345\220\215\357\274\210&M\357\274\211\357\274\232", nullptr));
        sLabel->setText(QCoreApplication::translate("MainWindow", "\346\200\247\345\210\253\357\274\210&S\357\274\211\357\274\232", nullptr));
        aLabel->setText(QCoreApplication::translate("MainWindow", "\345\271\264\351\276\204\357\274\210&A\357\274\211\357\274\232", nullptr));
        dLabel->setText(QCoreApplication::translate("MainWindow", "\351\203\250\351\227\250\357\274\210&D\357\274\211\357\274\232", nullptr));
        label->setText(QCoreApplication::translate("MainWindow", "\345\244\264\345\203\217\357\274\232", nullptr));
        label_avatar->setText(QCoreApplication::translate("MainWindow", "TextLabel", nullptr));
        pushButton->setText(QCoreApplication::translate("MainWindow", "\346\233\264\346\226\260", nullptr));
        label_2->setText(QCoreApplication::translate("MainWindow", "\344\270\252\344\272\272\350\257\264\346\230\216\357\274\232", nullptr));
        pushButton_3->setText(QCoreApplication::translate("MainWindow", "\345\217\226\346\266\210", nullptr));
        pushButton_2->setText(QCoreApplication::translate("MainWindow", "\347\241\256\345\256\232", nullptr));
        textEdit->setPlaceholderText(QCoreApplication::translate("MainWindow", "\345\244\207\346\263\250\357\274\232", nullptr));
    } // retranslateUi

};

namespace Ui {
    class MainWindow: public Ui_MainWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MAINWINDOW_H
