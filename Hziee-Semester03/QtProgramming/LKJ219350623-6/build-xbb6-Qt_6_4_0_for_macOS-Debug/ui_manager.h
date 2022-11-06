/********************************************************************************
** Form generated from reading UI file 'manager.ui'
**
** Created by: Qt User Interface Compiler version 6.4.0
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MANAGER_H
#define UI_MANAGER_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QComboBox>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QSpinBox>
#include <QtWidgets/QStackedWidget>
#include <QtWidgets/QTableView>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_manager
{
public:
    QWidget *horizontalLayoutWidget;
    QHBoxLayout *horizontalLayout;
    QPushButton *sellBtn;
    QPushButton *buyBtn;
    QPushButton *addBtn;
    QPushButton *queryBtn;
    QPushButton *passwordBtn;
    QStackedWidget *stackedWidget;
    QWidget *page;
    QLabel *label_7;
    QComboBox *sellTypeComboBox;
    QLineEdit *sellSumLineEdit;
    QLabel *label;
    QSpinBox *sellNumSpinBox;
    QLineEdit *sellPriceLineEdit;
    QComboBox *sellBrandComboBox;
    QLabel *label_9;
    QWidget *verticalLayoutWidget;
    QVBoxLayout *verticalLayout;
    QLabel *label_2;
    QLabel *label_4;
    QLabel *label_3;
    QLabel *label_5;
    QLabel *label_6;
    QPushButton *sellCancelBtn;
    QPushButton *sellOkBtn;
    QLabel *sellLastNumLabel;
    QWidget *page_3;
    QLabel *label_10;
    QComboBox *goodsTypeComboBox;
    QLineEdit *goodsSumLineEdit;
    QSpinBox *goodsNumSpinBox;
    QLineEdit *goodsPriceLineEdit;
    QComboBox *goodsBrandComboBox;
    QLabel *label_12;
    QWidget *verticalLayoutWidget_2;
    QVBoxLayout *verticalLayout_2;
    QLabel *label_13;
    QLabel *label_14;
    QLabel *label_15;
    QLabel *label_16;
    QLabel *label_17;
    QPushButton *goodsCancelBtn;
    QPushButton *goodsOkBtn;
    QLabel *label_18;
    QWidget *page_4;
    QLabel *label_29;
    QLineEdit *newBrandLineEdit;
    QSpinBox *newPriceSpinBox;
    QSpinBox *newNumSpinBox;
    QPushButton *newOkBtn;
    QLabel *label_30;
    QLineEdit *newSumLineEdit;
    QComboBox *newTypeComboBox;
    QLabel *label_11;
    QPushButton *newCancelBtn;
    QWidget *verticalLayoutWidget_3;
    QVBoxLayout *verticalLayout_4;
    QLabel *label_24;
    QLabel *label_25;
    QLabel *label_26;
    QLabel *label_27;
    QLabel *label_28;
    QWidget *page_5;
    QLabel *label_31;
    QPushButton *queryPushButton;
    QComboBox *queryTypeComboBox;
    QWidget *verticalLayoutWidget_4;
    QVBoxLayout *verticalLayout_5;
    QLabel *label_33;
    QLabel *label_34;
    QComboBox *queryBrandComboBox;
    QTableView *tableView;
    QWidget *page_6;
    QLabel *label_32;
    QLineEdit *oldPwdLineEdit;
    QLineEdit *newPwdLineEdit;
    QWidget *verticalLayoutWidget_5;
    QVBoxLayout *verticalLayout_6;
    QLabel *label_35;
    QLabel *label_36;
    QPushButton *changePwdBtn;
    QWidget *page_2;

    void setupUi(QWidget *manager)
    {
        if (manager->objectName().isEmpty())
            manager->setObjectName("manager");
        manager->resize(1280, 800);
        horizontalLayoutWidget = new QWidget(manager);
        horizontalLayoutWidget->setObjectName("horizontalLayoutWidget");
        horizontalLayoutWidget->setGeometry(QRect(110, 40, 541, 81));
        horizontalLayout = new QHBoxLayout(horizontalLayoutWidget);
        horizontalLayout->setObjectName("horizontalLayout");
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        sellBtn = new QPushButton(horizontalLayoutWidget);
        sellBtn->setObjectName("sellBtn");
        QFont font;
        font.setFamilies({QString::fromUtf8("Agency FB")});
        font.setPointSize(16);
        sellBtn->setFont(font);

        horizontalLayout->addWidget(sellBtn);

        buyBtn = new QPushButton(horizontalLayoutWidget);
        buyBtn->setObjectName("buyBtn");
        buyBtn->setFont(font);

        horizontalLayout->addWidget(buyBtn);

        addBtn = new QPushButton(horizontalLayoutWidget);
        addBtn->setObjectName("addBtn");
        addBtn->setFont(font);

        horizontalLayout->addWidget(addBtn);

        queryBtn = new QPushButton(horizontalLayoutWidget);
        queryBtn->setObjectName("queryBtn");
        queryBtn->setFont(font);

        horizontalLayout->addWidget(queryBtn);

        passwordBtn = new QPushButton(horizontalLayoutWidget);
        passwordBtn->setObjectName("passwordBtn");
        passwordBtn->setFont(font);

        horizontalLayout->addWidget(passwordBtn);

        stackedWidget = new QStackedWidget(manager);
        stackedWidget->setObjectName("stackedWidget");
        stackedWidget->setGeometry(QRect(0, 150, 711, 561));
        QFont font1;
        font1.setPointSize(28);
        stackedWidget->setFont(font1);
        page = new QWidget();
        page->setObjectName("page");
        label_7 = new QLabel(page);
        label_7->setObjectName("label_7");
        label_7->setGeometry(QRect(1160, 320, 99, 83));
        QFont font2;
        font2.setFamilies({QString::fromUtf8("Agency FB")});
        font2.setPointSize(28);
        label_7->setFont(font2);
        sellTypeComboBox = new QComboBox(page);
        sellTypeComboBox->setObjectName("sellTypeComboBox");
        sellTypeComboBox->setGeometry(QRect(670, 150, 281, 51));
        sellTypeComboBox->setFont(font2);
        sellSumLineEdit = new QLineEdit(page);
        sellSumLineEdit->setObjectName("sellSumLineEdit");
        sellSumLineEdit->setGeometry(QRect(670, 510, 441, 61));
        sellSumLineEdit->setFont(font2);
        label = new QLabel(page);
        label->setObjectName("label");
        label->setGeometry(QRect(30, 20, 1611, 91));
        QFont font3;
        font3.setFamilies({QString::fromUtf8("Agency FB")});
        font3.setPointSize(48);
        label->setFont(font3);
        label->setFocusPolicy(Qt::TabFocus);
        label->setStyleSheet(QString::fromUtf8("background:transparent;border:2px solid black"));
        label->setAlignment(Qt::AlignCenter);
        sellNumSpinBox = new QSpinBox(page);
        sellNumSpinBox->setObjectName("sellNumSpinBox");
        sellNumSpinBox->setGeometry(QRect(670, 420, 441, 61));
        sellNumSpinBox->setFont(font2);
        sellNumSpinBox->setMinimum(1);
        sellPriceLineEdit = new QLineEdit(page);
        sellPriceLineEdit->setObjectName("sellPriceLineEdit");
        sellPriceLineEdit->setGeometry(QRect(670, 330, 441, 61));
        sellPriceLineEdit->setFont(font2);
        sellBrandComboBox = new QComboBox(page);
        sellBrandComboBox->setObjectName("sellBrandComboBox");
        sellBrandComboBox->setGeometry(QRect(670, 240, 581, 51));
        sellBrandComboBox->setFont(font2);
        label_9 = new QLabel(page);
        label_9->setObjectName("label_9");
        label_9->setGeometry(QRect(1170, 490, 99, 83));
        label_9->setFont(font2);
        verticalLayoutWidget = new QWidget(page);
        verticalLayoutWidget->setObjectName("verticalLayoutWidget");
        verticalLayoutWidget->setGeometry(QRect(500, 140, 101, 441));
        verticalLayout = new QVBoxLayout(verticalLayoutWidget);
        verticalLayout->setObjectName("verticalLayout");
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        label_2 = new QLabel(verticalLayoutWidget);
        label_2->setObjectName("label_2");
        label_2->setFont(font2);

        verticalLayout->addWidget(label_2);

        label_4 = new QLabel(verticalLayoutWidget);
        label_4->setObjectName("label_4");
        label_4->setFont(font2);

        verticalLayout->addWidget(label_4);

        label_3 = new QLabel(verticalLayoutWidget);
        label_3->setObjectName("label_3");
        label_3->setFont(font2);

        verticalLayout->addWidget(label_3);

        label_5 = new QLabel(verticalLayoutWidget);
        label_5->setObjectName("label_5");
        label_5->setFont(font2);

        verticalLayout->addWidget(label_5);

        label_6 = new QLabel(verticalLayoutWidget);
        label_6->setObjectName("label_6");
        label_6->setFont(font2);

        verticalLayout->addWidget(label_6);

        sellCancelBtn = new QPushButton(page);
        sellCancelBtn->setObjectName("sellCancelBtn");
        sellCancelBtn->setGeometry(QRect(1060, 690, 151, 111));
        sellCancelBtn->setFont(font2);
        sellOkBtn = new QPushButton(page);
        sellOkBtn->setObjectName("sellOkBtn");
        sellOkBtn->setGeometry(QRect(570, 690, 151, 111));
        sellOkBtn->setFont(font2);
        sellLastNumLabel = new QLabel(page);
        sellLastNumLabel->setObjectName("sellLastNumLabel");
        sellLastNumLabel->setGeometry(QRect(1160, 410, 471, 83));
        sellLastNumLabel->setFont(font2);
        stackedWidget->addWidget(page);
        page_3 = new QWidget();
        page_3->setObjectName("page_3");
        label_10 = new QLabel(page_3);
        label_10->setObjectName("label_10");
        label_10->setGeometry(QRect(1163, 325, 99, 83));
        label_10->setFont(font2);
        goodsTypeComboBox = new QComboBox(page_3);
        goodsTypeComboBox->setObjectName("goodsTypeComboBox");
        goodsTypeComboBox->setGeometry(QRect(673, 155, 281, 51));
        goodsTypeComboBox->setFont(font2);
        goodsSumLineEdit = new QLineEdit(page_3);
        goodsSumLineEdit->setObjectName("goodsSumLineEdit");
        goodsSumLineEdit->setGeometry(QRect(673, 515, 441, 61));
        goodsSumLineEdit->setFont(font2);
        goodsNumSpinBox = new QSpinBox(page_3);
        goodsNumSpinBox->setObjectName("goodsNumSpinBox");
        goodsNumSpinBox->setGeometry(QRect(673, 425, 441, 61));
        goodsNumSpinBox->setFont(font2);
        goodsNumSpinBox->setMinimum(1);
        goodsPriceLineEdit = new QLineEdit(page_3);
        goodsPriceLineEdit->setObjectName("goodsPriceLineEdit");
        goodsPriceLineEdit->setGeometry(QRect(673, 335, 441, 61));
        goodsPriceLineEdit->setFont(font2);
        goodsBrandComboBox = new QComboBox(page_3);
        goodsBrandComboBox->setObjectName("goodsBrandComboBox");
        goodsBrandComboBox->setGeometry(QRect(673, 245, 581, 51));
        goodsBrandComboBox->setFont(font2);
        label_12 = new QLabel(page_3);
        label_12->setObjectName("label_12");
        label_12->setGeometry(QRect(1173, 495, 99, 83));
        label_12->setFont(font2);
        verticalLayoutWidget_2 = new QWidget(page_3);
        verticalLayoutWidget_2->setObjectName("verticalLayoutWidget_2");
        verticalLayoutWidget_2->setGeometry(QRect(497, 142, 101, 441));
        verticalLayout_2 = new QVBoxLayout(verticalLayoutWidget_2);
        verticalLayout_2->setObjectName("verticalLayout_2");
        verticalLayout_2->setContentsMargins(0, 0, 0, 0);
        label_13 = new QLabel(verticalLayoutWidget_2);
        label_13->setObjectName("label_13");
        label_13->setFont(font2);

        verticalLayout_2->addWidget(label_13);

        label_14 = new QLabel(verticalLayoutWidget_2);
        label_14->setObjectName("label_14");
        label_14->setFont(font2);

        verticalLayout_2->addWidget(label_14);

        label_15 = new QLabel(verticalLayoutWidget_2);
        label_15->setObjectName("label_15");
        label_15->setFont(font2);

        verticalLayout_2->addWidget(label_15);

        label_16 = new QLabel(verticalLayoutWidget_2);
        label_16->setObjectName("label_16");
        label_16->setFont(font2);

        verticalLayout_2->addWidget(label_16);

        label_17 = new QLabel(verticalLayoutWidget_2);
        label_17->setObjectName("label_17");
        label_17->setFont(font2);

        verticalLayout_2->addWidget(label_17);

        goodsCancelBtn = new QPushButton(page_3);
        goodsCancelBtn->setObjectName("goodsCancelBtn");
        goodsCancelBtn->setGeometry(QRect(1063, 695, 151, 111));
        goodsCancelBtn->setFont(font2);
        goodsOkBtn = new QPushButton(page_3);
        goodsOkBtn->setObjectName("goodsOkBtn");
        goodsOkBtn->setGeometry(QRect(573, 695, 151, 111));
        goodsOkBtn->setFont(font2);
        label_18 = new QLabel(page_3);
        label_18->setObjectName("label_18");
        label_18->setGeometry(QRect(30, 20, 1611, 91));
        label_18->setFont(font3);
        label_18->setFocusPolicy(Qt::TabFocus);
        label_18->setStyleSheet(QString::fromUtf8("background:transparent;border:2px solid black"));
        label_18->setAlignment(Qt::AlignCenter);
        stackedWidget->addWidget(page_3);
        page_4 = new QWidget();
        page_4->setObjectName("page_4");
        label_29 = new QLabel(page_4);
        label_29->setObjectName("label_29");
        label_29->setGeometry(QRect(30, 20, 1611, 91));
        label_29->setFont(font3);
        label_29->setFocusPolicy(Qt::TabFocus);
        label_29->setStyleSheet(QString::fromUtf8("background:transparent;border:2px solid black"));
        label_29->setAlignment(Qt::AlignCenter);
        newBrandLineEdit = new QLineEdit(page_4);
        newBrandLineEdit->setObjectName("newBrandLineEdit");
        newBrandLineEdit->setGeometry(QRect(675, 244, 441, 61));
        newBrandLineEdit->setFont(font2);
        newPriceSpinBox = new QSpinBox(page_4);
        newPriceSpinBox->setObjectName("newPriceSpinBox");
        newPriceSpinBox->setGeometry(QRect(675, 334, 441, 61));
        newPriceSpinBox->setFont(font2);
        newPriceSpinBox->setMinimum(1);
        newPriceSpinBox->setMaximum(2147483647);
        newNumSpinBox = new QSpinBox(page_4);
        newNumSpinBox->setObjectName("newNumSpinBox");
        newNumSpinBox->setGeometry(QRect(675, 434, 441, 61));
        newNumSpinBox->setFont(font2);
        newNumSpinBox->setMinimum(1);
        newOkBtn = new QPushButton(page_4);
        newOkBtn->setObjectName("newOkBtn");
        newOkBtn->setGeometry(QRect(575, 704, 151, 111));
        newOkBtn->setFont(font2);
        label_30 = new QLabel(page_4);
        label_30->setObjectName("label_30");
        label_30->setGeometry(QRect(1160, 510, 99, 83));
        label_30->setFont(font2);
        newSumLineEdit = new QLineEdit(page_4);
        newSumLineEdit->setObjectName("newSumLineEdit");
        newSumLineEdit->setGeometry(QRect(675, 524, 441, 61));
        newSumLineEdit->setFont(font2);
        newTypeComboBox = new QComboBox(page_4);
        newTypeComboBox->setObjectName("newTypeComboBox");
        newTypeComboBox->setGeometry(QRect(675, 164, 281, 51));
        newTypeComboBox->setFont(font2);
        label_11 = new QLabel(page_4);
        label_11->setObjectName("label_11");
        label_11->setGeometry(QRect(1150, 320, 99, 83));
        label_11->setFont(font2);
        newCancelBtn = new QPushButton(page_4);
        newCancelBtn->setObjectName("newCancelBtn");
        newCancelBtn->setGeometry(QRect(1065, 704, 151, 111));
        newCancelBtn->setFont(font2);
        verticalLayoutWidget_3 = new QWidget(page_4);
        verticalLayoutWidget_3->setObjectName("verticalLayoutWidget_3");
        verticalLayoutWidget_3->setGeometry(QRect(505, 154, 101, 441));
        verticalLayout_4 = new QVBoxLayout(verticalLayoutWidget_3);
        verticalLayout_4->setObjectName("verticalLayout_4");
        verticalLayout_4->setContentsMargins(0, 0, 0, 0);
        label_24 = new QLabel(verticalLayoutWidget_3);
        label_24->setObjectName("label_24");
        label_24->setFont(font2);

        verticalLayout_4->addWidget(label_24);

        label_25 = new QLabel(verticalLayoutWidget_3);
        label_25->setObjectName("label_25");
        label_25->setFont(font2);

        verticalLayout_4->addWidget(label_25);

        label_26 = new QLabel(verticalLayoutWidget_3);
        label_26->setObjectName("label_26");
        label_26->setFont(font2);

        verticalLayout_4->addWidget(label_26);

        label_27 = new QLabel(verticalLayoutWidget_3);
        label_27->setObjectName("label_27");
        label_27->setFont(font2);

        verticalLayout_4->addWidget(label_27);

        label_28 = new QLabel(verticalLayoutWidget_3);
        label_28->setObjectName("label_28");
        label_28->setFont(font2);

        verticalLayout_4->addWidget(label_28);

        stackedWidget->addWidget(page_4);
        page_5 = new QWidget();
        page_5->setObjectName("page_5");
        label_31 = new QLabel(page_5);
        label_31->setObjectName("label_31");
        label_31->setGeometry(QRect(170, 20, 421, 41));
        label_31->setFont(font);
        label_31->setFocusPolicy(Qt::TabFocus);
        label_31->setStyleSheet(QString::fromUtf8("background:transparent;border:2px solid black"));
        label_31->setAlignment(Qt::AlignCenter);
        queryPushButton = new QPushButton(page_5);
        queryPushButton->setObjectName("queryPushButton");
        queryPushButton->setGeometry(QRect(460, 220, 111, 61));
        queryPushButton->setFont(font2);
        queryTypeComboBox = new QComboBox(page_5);
        queryTypeComboBox->setObjectName("queryTypeComboBox");
        queryTypeComboBox->setGeometry(QRect(280, 180, 141, 51));
        queryTypeComboBox->setFont(font2);
        verticalLayoutWidget_4 = new QWidget(page_5);
        verticalLayoutWidget_4->setObjectName("verticalLayoutWidget_4");
        verticalLayoutWidget_4->setGeometry(QRect(140, 170, 101, 151));
        verticalLayout_5 = new QVBoxLayout(verticalLayoutWidget_4);
        verticalLayout_5->setObjectName("verticalLayout_5");
        verticalLayout_5->setContentsMargins(0, 0, 0, 0);
        label_33 = new QLabel(verticalLayoutWidget_4);
        label_33->setObjectName("label_33");
        label_33->setFont(font);

        verticalLayout_5->addWidget(label_33);

        label_34 = new QLabel(verticalLayoutWidget_4);
        label_34->setObjectName("label_34");
        label_34->setFont(font);

        verticalLayout_5->addWidget(label_34);

        queryBrandComboBox = new QComboBox(page_5);
        queryBrandComboBox->setObjectName("queryBrandComboBox");
        queryBrandComboBox->setGeometry(QRect(280, 270, 141, 51));
        queryBrandComboBox->setFont(font2);
        tableView = new QTableView(page_5);
        tableView->setObjectName("tableView");
        tableView->setGeometry(QRect(40, 360, 1601, 621));
        tableView->setFont(font1);
        tableView->horizontalHeader()->setMinimumSectionSize(50);
        tableView->horizontalHeader()->setDefaultSectionSize(200);
        tableView->verticalHeader()->setMinimumSectionSize(80);
        tableView->verticalHeader()->setDefaultSectionSize(100);
        stackedWidget->addWidget(page_5);
        page_6 = new QWidget();
        page_6->setObjectName("page_6");
        label_32 = new QLabel(page_6);
        label_32->setObjectName("label_32");
        label_32->setGeometry(QRect(30, 20, 1611, 91));
        label_32->setFont(font3);
        label_32->setFocusPolicy(Qt::TabFocus);
        label_32->setStyleSheet(QString::fromUtf8("background:transparent;border:2px solid black"));
        label_32->setAlignment(Qt::AlignCenter);
        oldPwdLineEdit = new QLineEdit(page_6);
        oldPwdLineEdit->setObjectName("oldPwdLineEdit");
        oldPwdLineEdit->setGeometry(QRect(770, 270, 441, 61));
        oldPwdLineEdit->setFont(font2);
        newPwdLineEdit = new QLineEdit(page_6);
        newPwdLineEdit->setObjectName("newPwdLineEdit");
        newPwdLineEdit->setGeometry(QRect(770, 400, 441, 61));
        newPwdLineEdit->setFont(font2);
        verticalLayoutWidget_5 = new QWidget(page_6);
        verticalLayoutWidget_5->setObjectName("verticalLayoutWidget_5");
        verticalLayoutWidget_5->setGeometry(QRect(600, 250, 131, 231));
        verticalLayout_6 = new QVBoxLayout(verticalLayoutWidget_5);
        verticalLayout_6->setObjectName("verticalLayout_6");
        verticalLayout_6->setContentsMargins(0, 0, 0, 0);
        label_35 = new QLabel(verticalLayoutWidget_5);
        label_35->setObjectName("label_35");
        label_35->setFont(font2);

        verticalLayout_6->addWidget(label_35);

        label_36 = new QLabel(verticalLayoutWidget_5);
        label_36->setObjectName("label_36");
        label_36->setFont(font2);

        verticalLayout_6->addWidget(label_36);

        changePwdBtn = new QPushButton(page_6);
        changePwdBtn->setObjectName("changePwdBtn");
        changePwdBtn->setGeometry(QRect(560, 540, 691, 141));
        QFont font4;
        font4.setFamilies({QString::fromUtf8("Agency FB")});
        font4.setPointSize(36);
        changePwdBtn->setFont(font4);
        stackedWidget->addWidget(page_6);
        page_2 = new QWidget();
        page_2->setObjectName("page_2");
        stackedWidget->addWidget(page_2);

        retranslateUi(manager);

        stackedWidget->setCurrentIndex(3);


        QMetaObject::connectSlotsByName(manager);
    } // setupUi

    void retranslateUi(QWidget *manager)
    {
        manager->setWindowTitle(QCoreApplication::translate("manager", "\346\225\260\346\215\256\347\256\241\347\220\206\347\263\273\347\273\237", nullptr));
        sellBtn->setText(QCoreApplication::translate("manager", "\345\207\272\345\224\256\345\225\206\345\223\201", nullptr));
        buyBtn->setText(QCoreApplication::translate("manager", "\345\225\206\345\223\201\345\205\245\345\272\223", nullptr));
        addBtn->setText(QCoreApplication::translate("manager", "\346\267\273\345\212\240\345\225\206\345\223\201", nullptr));
        queryBtn->setText(QCoreApplication::translate("manager", "\345\225\206\345\223\201\346\237\245\350\257\242", nullptr));
        passwordBtn->setText(QCoreApplication::translate("manager", "\344\277\256\346\224\271\345\257\206\347\240\201", nullptr));
        label_7->setText(QCoreApplication::translate("manager", "\345\205\203", nullptr));
        sellSumLineEdit->setText(QString());
        label->setText(QCoreApplication::translate("manager", "\345\207\272\345\224\256\345\225\206\345\223\201", nullptr));
        label_9->setText(QCoreApplication::translate("manager", "\345\205\203", nullptr));
        label_2->setText(QCoreApplication::translate("manager", "\347\261\273\345\236\213:", nullptr));
        label_4->setText(QCoreApplication::translate("manager", "\345\223\201\347\211\214:", nullptr));
        label_3->setText(QCoreApplication::translate("manager", "\345\215\225\344\273\267:", nullptr));
        label_5->setText(QCoreApplication::translate("manager", "\346\225\260\351\207\217:", nullptr));
        label_6->setText(QCoreApplication::translate("manager", "\351\207\221\351\242\235:", nullptr));
        sellCancelBtn->setText(QCoreApplication::translate("manager", "\345\217\226\346\266\210", nullptr));
        sellOkBtn->setText(QCoreApplication::translate("manager", "\347\241\256\345\256\232", nullptr));
        sellLastNumLabel->setText(QCoreApplication::translate("manager", "000", nullptr));
        label_10->setText(QCoreApplication::translate("manager", "\345\205\203", nullptr));
        goodsSumLineEdit->setText(QString());
        label_12->setText(QCoreApplication::translate("manager", "\345\205\203", nullptr));
        label_13->setText(QCoreApplication::translate("manager", "\347\261\273\345\236\213:", nullptr));
        label_14->setText(QCoreApplication::translate("manager", "\345\223\201\347\211\214:", nullptr));
        label_15->setText(QCoreApplication::translate("manager", "\345\215\225\344\273\267:", nullptr));
        label_16->setText(QCoreApplication::translate("manager", "\346\225\260\351\207\217:", nullptr));
        label_17->setText(QCoreApplication::translate("manager", "\351\207\221\351\242\235:", nullptr));
        goodsCancelBtn->setText(QCoreApplication::translate("manager", "\345\217\226\346\266\210", nullptr));
        goodsOkBtn->setText(QCoreApplication::translate("manager", "\347\241\256\345\256\232", nullptr));
        label_18->setText(QCoreApplication::translate("manager", "\345\225\206\345\223\201\345\205\245\345\272\223", nullptr));
        label_29->setText(QCoreApplication::translate("manager", "\346\267\273\345\212\240\345\225\206\345\223\201", nullptr));
        newOkBtn->setText(QCoreApplication::translate("manager", "\347\241\256\345\256\232", nullptr));
        label_30->setText(QCoreApplication::translate("manager", "\345\205\203", nullptr));
        newSumLineEdit->setText(QString());
        label_11->setText(QCoreApplication::translate("manager", "\345\205\203", nullptr));
        newCancelBtn->setText(QCoreApplication::translate("manager", "\345\217\226\346\266\210", nullptr));
        label_24->setText(QCoreApplication::translate("manager", "\347\261\273\345\236\213:", nullptr));
        label_25->setText(QCoreApplication::translate("manager", "\345\223\201\347\211\214:", nullptr));
        label_26->setText(QCoreApplication::translate("manager", "\345\215\225\344\273\267:", nullptr));
        label_27->setText(QCoreApplication::translate("manager", "\346\225\260\351\207\217:", nullptr));
        label_28->setText(QCoreApplication::translate("manager", "\351\207\221\351\242\235:", nullptr));
        label_31->setText(QCoreApplication::translate("manager", "\345\225\206\345\223\201\346\237\245\350\257\242", nullptr));
        queryPushButton->setText(QCoreApplication::translate("manager", "\346\237\245 \350\257\242", nullptr));
        label_33->setText(QCoreApplication::translate("manager", "\347\261\273\345\236\213:", nullptr));
        label_34->setText(QCoreApplication::translate("manager", "\345\223\201\347\211\214:", nullptr));
        label_32->setText(QCoreApplication::translate("manager", "\344\277\256\346\224\271\345\257\206\347\240\201", nullptr));
        label_35->setText(QCoreApplication::translate("manager", "\345\216\237\345\257\206\347\240\201:", nullptr));
        label_36->setText(QCoreApplication::translate("manager", "\346\226\260\345\257\206\347\240\201:", nullptr));
        changePwdBtn->setText(QCoreApplication::translate("manager", "\347\241\256   \345\256\232", nullptr));
    } // retranslateUi

};

namespace Ui {
    class manager: public Ui_manager {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MANAGER_H
