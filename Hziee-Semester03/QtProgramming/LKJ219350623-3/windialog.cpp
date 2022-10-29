#include "windialog.h"
#include "ui_windialog.h"

winDialog::winDialog(QWidget *parent) :
    QDialog(parent),
    ui(new Ui::winDialog)
{
    ui->setupUi(this);
    setWindowTitle("Geometry");
     updateLabel();
}

winDialog::~winDialog()
{
    delete ui;
}


void winDialog::updateLabel()
{
   QString temp;
   QString str_x;
   ui->xlabel->setText(str_x.setNum(x()));

   QString str_y;
   ui->ylabel->setText(str_y.setNum(y()));

   QString frameGeo;
    frameGeo =temp.setNum(frameGeometry().x()) + "," ;
    frameGeo +=temp.setNum(frameGeometry().y()) + ",";
    frameGeo +=temp.setNum(frameGeometry().width()) + "," ;
    frameGeo +=temp.setNum(frameGeometry().height());
    ui->flabel->setText(frameGeo);

    QString position;
    position = temp.setNum(pos().x()) + ",";
    position +=  temp.setNum(pos().y());
    ui->plabel->setText(position);

    QString geo;
    geo =temp.setNum(geometry().x()) + "," ;
    geo +=temp.setNum(geometry().y()) + ",";
    geo +=temp.setNum(geometry().width()) + "," ;
    geo +=temp.setNum(geometry().height());
    ui->glabel->setText(geo);

    QString w;
    ui->wlabel->setText(w.setNum(width()));
    QString h;
    ui->hlabel->setText(h.setNum(height()));

    QString r;
    r =temp.setNum(rect().x()) + "," ;
    r +=temp.setNum(rect().y()) + ",";
    r +=temp.setNum(rect().width()) + "," ;
    r +=temp.setNum(rect().height());
    ui->rlabel->setText(r);

    QString s;
    s =  temp.setNum(size().width()) + "," ;
    s +=temp.setNum(size().height()) ;
    ui->slabel->setText(s);
}
void winDialog::moveEvent(QMoveEvent*)
{
  updateLabel();
}

void winDialog::resizeEvent(QResizeEvent *)
{
  updateLabel();
}
