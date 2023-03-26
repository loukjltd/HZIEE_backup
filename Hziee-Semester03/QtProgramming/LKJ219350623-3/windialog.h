#ifndef WINDIALOG_H
#define WINDIALOG_H

#include <QDialog>

namespace Ui {
class winDialog;
}

class winDialog : public QDialog
{
    Q_OBJECT

public:
    //explicit winDialog(QWidget *parent = nullptr);

    explicit winDialog(QWidget *parent = 0);
    ~winDialog();
    void updateLabel();

    //~winDialog();
protected:
  void moveEvent(QMoveEvent*);
  void resizeEvent(QResizeEvent *);

private:
    Ui::winDialog *ui;
};

#endif // WINDIALOG_H
