#ifndef MANAGER_H
#define MANAGER_H

#include <QWidget>
#include <QMessageBox>
#include <QSqlQueryModel>
#include <QSqlQuery>
#include <QSqlTableModel>
#include <QSqlError>

class QSqlTableModel;

namespace Ui {
class manager;
}

class manager : public QWidget
{
    Q_OBJECT

public:
    explicit manager(QWidget *parent = nullptr);
    ~manager();

private slots:
    void on_sellBtn_clicked();

    void on_buyBtn_clicked();

    void on_queryBtn_clicked();

    void on_addBtn_clicked();

    void on_passwordBtn_clicked();


    void on_sellTypeComboBox_currentIndexChanged(QString type);

    void on_goodsTypeComboBox_currentIndexChanged(QString type);

    void on_newTypeComboBox_currentIndexChanged(QString type);

    void on_queryTypeComboBox_currentIndexChanged(QString type);

    void on_sellBrandComboBox_currentIndexChanged(const QString &arg1);

    void on_goodsBrandComboBox_currentIndexChanged(const QString &arg1);

    void on_newBrandLineEdit_textChanged(const QString &arg1);

    void on_goodsNumSpinBox_valueChanged(int arg1);

    void on_sellNumSpinBox_valueChanged(int arg1);

    void on_newNumSpinBox_valueChanged(int arg1);

    void on_newPriceSpinBox_valueChanged(int arg1);

    void on_sellOkBtn_clicked();

    void on_goodsOkBtn_clicked();

    void on_newOkBtn_clicked();

    void on_sellCancelBtn_clicked();

    void on_goodsCancelBtn_clicked();

    void on_newCancelBtn_clicked();

    void on_queryPushButton_clicked();

    void on_queryPushButton_2_clicked();
private:
    QSqlTableModel *model;

private:
    Ui::manager *ui;
};

#endif // MANAGER_H
