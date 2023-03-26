#ifndef CHOUTIDIALOG_H
#define CHOUTIDIALOG_H

#include <QDialog>

namespace Ui {
class choutiDialog;
}

class choutiDialog : public QDialog
{
    Q_OBJECT

public:
    explicit choutiDialog(QWidget *parent = nullptr);
    ~choutiDialog();

private:
    Ui::choutiDialog *ui;
};

#endif // CHOUTIDIALOG_H
