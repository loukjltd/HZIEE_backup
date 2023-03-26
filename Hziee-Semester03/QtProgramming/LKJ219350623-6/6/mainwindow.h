#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QFileDialog>
#include <QMouseEvent>
#include <QPainter>
#include <QLabel>
#include <manager.h>

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

private:
    QLabel *labelStatus;
    QLabel *labelMousePos;
    QFont font;
    QPixmap *pix;
    QImage image;
    int startX;
    int startY;
    int width;
    int height;
    int step;
    int x;
    int y;
    manager *m;
protected :
    void mouseMoveEvent (QMouseEvent* e);
    void mousePressEvent (QMouseEvent* e);
    void mouseReleaseEvent (QMouseEvent* e);
    void mouseDoubleClickEvent(QMouseEvent* e);

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();
    void drawPix();
    void keyPressEvent(QKeyEvent *);
    void paintEvent(QPaintEvent *);

private slots:
    void on_action_F_triggered();

    void on_action_D_triggered();

    void on_action_B_triggered();

private:
    Ui::MainWindow *ui;
};

#endif // MAINWINDOW_H
