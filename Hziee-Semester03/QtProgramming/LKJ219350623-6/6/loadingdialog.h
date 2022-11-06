#ifndef LOADINGDIALOG_H
#define LOADINGDIALOG_H

#include <QDialog>

namespace Ui {
class loadingdialog;
}

class loadingdialog : public QDialog
{
    Q_OBJECT

public:
    explicit loadingdialog(QWidget *parent = nullptr);
    ~loadingdialog();

private:
    Ui::loadingdialog *ui;
};

#endif // LOADINGDIALOG_H
