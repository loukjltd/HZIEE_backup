#ifndef BIAOZUNDIALOG_H
#define BIAOZUNDIALOG_H

#include <QDialog>

namespace Ui {
class biaozunDialog;
}

class biaozunDialog : public QDialog
{
    Q_OBJECT

public:
    explicit biaozunDialog(QWidget *parent = nullptr);
    ~biaozunDialog();


    void slotOpenFileDlg();
private slots:
    void on_pushButton_clicked();

    void on_pushButton_2_clicked();

    void on_pushButton_3_clicked();

private:
    Ui::biaozunDialog *ui;
};

#endif // BIAOZUNDIALOG_H
