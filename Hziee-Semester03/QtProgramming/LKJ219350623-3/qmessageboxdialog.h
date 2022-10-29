#ifndef QMESSAGEBOXDIALOG_H
#define QMESSAGEBOXDIALOG_H

#include <QDialog>

namespace Ui {
class QMessageBoxDialog;
}

class QMessageBoxDialog : public QDialog
{
    Q_OBJECT

public:
    explicit QMessageBoxDialog(QWidget *parent = nullptr);
    ~QMessageBoxDialog();

private slots:
    void on_QButton_clicked();

    void on_InpushButton_clicked();

    void on_WpushButton_clicked();

    void on_CrpushButton_clicked();

    void on_ApushButton_clicked();

    void on_AQButton_clicked();

    void on_CButton_clicked();

private:
    Ui::QMessageBoxDialog *ui;
};

#endif // QMESSAGEBOXDIALOG_H
