#ifndef lkj_H
#define lkj_H

#include <QDialog>
#include <QSqlQuery>
#include <QSqlTableModel>
#include <QSqlError>
#include <QMessageBox>
class QSqlTableModel;

namespace Ui {
class lkj;
}

class lkj : public QDialog
{
    Q_OBJECT

public:
    explicit lkj(QWidget *parent = nullptr);
    ~lkj();
private slots:
    void on_pushButton_clicked();

    void on_pushButton_2_clicked();

    void on_pushButton_7_clicked();

    void on_pushButton_8_clicked();

    void on_pushButton_5_clicked();

    void on_pushButton_6_clicked();

    void on_pushButton_4_clicked();

    void on_pushButton_3_clicked();

private:
    QSqlTableModel *model;

private:
    Ui::lkj *ui;
};

#endif
