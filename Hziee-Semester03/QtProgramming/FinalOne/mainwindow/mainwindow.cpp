#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QDebug>
#include <QGraphicsPixmapItem>
#include <QTranslator>

MainWindow::MainWindow(QWidget *parent) :
        QMainWindow(parent),
        ui(new Ui::MainWindow) {
    ui->setupUi(this);

    QTranslator translator;
    translator.load(":/language/cn.qm");
    qApp->installTranslator(&translator);
    ui->retranslateUi(this);


    leftScene = new QGraphicsScene;
    rightScene = new QGraphicsScene;

    leftPixmapItem = new QGraphicsPixmapItem();
    rightPixmapItem = new QGraphicsPixmapItem();

    size = new QLabel;

    info = nullptr;

    leftScene->setBackgroundBrush(QColor::fromRgb(224, 224, 224));
    ui->leftGraphicsView->setScene(leftScene);
    rightScene->setBackgroundBrush(QColor::fromRgb(224, 224, 224));
    ui->rightGraphicsView->setScene(rightScene);

    ui->statusBar->addPermanentWidget(size);


    createAction();
    createToolBar();


    setActionStatus(false);
    setWindowTitle("楼可嘉 - 219350623");
}

void MainWindow::createToolBar() {
    ui->toolBar->addAction(ui->actionOpen);
    ui->toolBar->addAction(ui->actionClose);
    ui->toolBar->addAction(ui->actionSaveAs);
    ui->toolBar->addAction(ui->actionExit);

    ui->toolBar->addSeparator();
    ui->toolBar->addAction(ui->actionRestore);
    ui->toolBar->addAction(ui->actionHistogram);
    ui->toolBar->addAction(ui->actionGrayscale);
    ui->toolBar->addAction(ui->actionAdjust_brightness);

    ui->toolBar->addSeparator();
    ui->toolBar->addAction(ui->actionAbout);
}

void MainWindow::createAction() {

}


MainWindow::~MainWindow() {
    delete ui;

    if (leftScene) {
        delete leftScene;
        leftScene = nullptr;
    }

    if (size) {
        delete size;
        size = nullptr;
    }


    //add
    if (rightScene) {
        delete leftScene;
        leftScene = nullptr;
    }

}

/******************************************************************************
 *                Update right image and repaint right scene
 *****************************************************************************/
void MainWindow::updateRightImage(QPixmap &pixmap) {
    rightPixmapItem->setPixmap(pixmap);
    rightScene->setSceneRect(QRectF(pixmap.rect()));
}

/******************************************************************************
 *                      Clean image of both Scene
 *
 *****************************************************************************/
void MainWindow::cleanImage() {
    leftScene->clear();
    ui->leftGraphicsView->resetTransform();

    rightScene->clear();
    ui->rightGraphicsView->resetTransform();


    if (size) {
        delete size;
        size = new QLabel;
        ui->statusBar->addPermanentWidget(size);
    }


    this->setWindowTitle(WINDOW_TITLE);
    setActionStatus(false);
}

void MainWindow::setActionStatus(bool status) {
    ui->actionContour_extraction->setEnabled(status);
    // Blur
    ui->actionGauss->setEnabled(status);
    // Grey Transform
    ui->actionBinaryzation->setEnabled(status);
    ui->actionStretch_transformation->setEnabled(status);
    ui->actionExp_transfrom->setEnabled(status);
    ui->actionTwo_thresholds_transform->setEnabled(status);
    ui->actionPower_transformation->setEnabled(status);
    ui->actionLogarithm_grey_level_transformation->setEnabled(status);
    ui->actionClose->setEnabled(status);
    ui->actionSaveAs->setEnabled(status);
    ui->actionCool->setEnabled(status);
    ui->actionWarm->setEnabled(status);
    ui->actionFlower_frame->setEnabled(status);
    ui->actionGrayscale->setEnabled(status);
    ui->actionHistogram->setEnabled(status);
    ui->actionHorizontal->setEnabled(status);
    ui->actionLinear_level_transformation->setEnabled(status);
    ui->actionMetal->setEnabled(status);
    ui->actionMovie_frame->setEnabled(status);
    ui->actionRestore->setEnabled(status);
    ui->actionVertical->setEnabled(status);
    ui->actionClassic_frame->setEnabled(status);
    ui->actionAdjust_brightness->setEnabled(status);
    ui->actionZoom->setEnabled(status);
}


void MainWindow::receiveGaussianFactor(int radius, double sigma) {
    GaussianBlur *blur = new GaussianBlur(radius, sigma);

    QPixmap rightImage = rightPixmapItem->pixmap();

    QImage newImage = blur->BlurImage(rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::receiveLinearGreyParameter(double _a, double _b) {
    QPixmap rightImage = rightPixmapItem->pixmap();

    QImage newImage = Tools::LinearLevelTransformation(rightImage.toImage(), _a, _b);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::receivePowerGreyParamter(double c, double r, double b) {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::PowerGreyLevelTransformation(rightImage.toImage(), c, r, b);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::receiveLogGreyParamter(double _a, double _b) {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::LinearLevelTransformation(rightImage.toImage(), _a, _b);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::receiveExpGreyParamter(double b, double c, double a) {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::ExpTransform(rightImage.toImage(), b, c, a);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::receiveTwoThresholdParamter(int t1, int t2, int option) {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::TwoThreshold(rightImage.toImage(), t1, t2, option);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::receiveStretchParamter(int x1, int x2,
                                        double k1, double k2, double k3,
                                        double b2, double b3) {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::StretchTransform(rightImage.toImage(), x1, x2, k1, k2, k3, b2, b3);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}


/******************************************************************************
 *                      Open a image file and show it
 ******************************************************************************
 * Args:
 *      QString imagePath: The abslute path of a image
 *****************************************************************************/
void MainWindow::on_actionOpen_triggered() {
    // Automatically detects the current user's home directory
    // And then wait the user to select one image
    QString imagePath = QFileDialog::getOpenFileName(this, tr("Open image"), getUserPath() + "/Pictures",
                                                     tr("All Files (*);;"
                                                        "All Images (*.bpm *.gif *.jpg *.jpeg *.png *.ppm *.xbm *.xpm);;"
                                                        "Image BPM (*.bpm);;"
                                                        "Image GIF (*.gif);;"
                                                        "Image JPG (*.jpg);;"
                                                        "Image JPEG (*.jpeg);;"
                                                        "Image PNG (*.png);;"
                                                        "Image PPM (*.ppm);;"
                                                        "Image XBM (*.xbm);;"
                                                        "Image XPM (*.xpm);;"));

    if (!imagePath.isEmpty()) {
        QFile file(imagePath);
        if (!file.open(QIODevice::ReadOnly)) {
            QMessageBox::critical(this, tr(WINDOW_CRITICAL),
                                  tr("Unable to open image."));
            return;
        }

        // delete previous image
        cleanImage();

        // upload image
        info = new QFileInfo(imagePath);

        QPixmap leftPixmap(imagePath);
        leftPixmapItem = leftScene->addPixmap(leftPixmap);
        leftScene->setSceneRect(QRectF(leftPixmap.rect()));

        QPixmap rightPixmap(imagePath);
        rightPixmapItem = rightScene->addPixmap(rightPixmap);
        rightScene->setSceneRect(QRectF(rightPixmap.rect()));

        // settings
        this->setWindowTitle(info->fileName() + " - Photoshop");

        setActionStatus(true);

        size->setText(QString::number(leftPixmapItem->pixmap().width())
                      + " x " + QString::number(leftPixmapItem->pixmap().height()));
    }

    adjustSizeLeft();
    adjustSizeRight();
}

/******************************************************************************
 *                      Clean image of both Scene
 *
 *****************************************************************************/
void MainWindow::on_actionClose_triggered() {
    cleanImage();
}

/******************************************************************************
 *                          Action : Save as
 *****************************************************************************/
void MainWindow::on_actionSaveAs_triggered() {

    QString newPath = QFileDialog::getSaveFileName(this, tr("Save image"), QString(),
                                                   tr("All files (*);;"
                                                      "Image BPM (*.bpm);;"
                                                      "Image GIF (*.gif);;"
                                                      "Image JPG (*.jpg);;"
                                                      "Image JPEG (*.jpeg);;"
                                                      "Image PNG (*.png);;"
                                                      "Image PPM (*.ppm);;"
                                                      "Image XBM (*.xbm);;"
                                                      "Image XPM (*.xpm);;"));

    if (!newPath.isEmpty()) {

        QFile file(newPath);
        if (!file.open(QIODevice::WriteOnly)) {
            QMessageBox::critical(this, tr(WINDOW_CRITICAL), tr("Unable to save image."));
            return;
        }

        //Save image to new path
        rightPixmapItem->pixmap().save(newPath);
//        rightImage->save(newPath);
    }
}

/******************************************************************************
 *                        Exit the program
 *
 *****************************************************************************/
void MainWindow::on_actionExit_triggered() {
    qApp->quit();
}


/******************************************************************************
 *                              Greyscale
 *****************************************************************************/
void MainWindow::on_actionGrayscale_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::GreyScale(rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}


/******************************************************************************
 *                  Adjust the image size to fit the window
 *
 *****************************************************************************/
void MainWindow::adjustSizeLeft() {
    // left
    int height = leftPixmapItem->pixmap().height();
    int width = leftPixmapItem->pixmap().width();
    int max_height = ui->leftGraphicsView->height();
    int max_width = ui->leftGraphicsView->width();
    int size, max_size, fact = 0;
    double val = 0;


    size = qMin(width, height);
    max_size = qMin(max_width, max_height);


    if (size < max_size) {
        while ((size * val) < max_size)
            val = pow(1.2, fact++);
        val = pow(1.2, fact - 2);
        ui->leftGraphicsView->setFactor(fact - 2);
    } else {
        val = 1;
        while ((size * val) > max_size)
            val = pow(1.2, fact--);
        val = pow(1.2, fact + 1);
        ui->leftGraphicsView->setFactor(fact + 1);
    }

    ui->leftGraphicsView->scale(val, val);
}

void MainWindow::adjustSizeRight() {
    // right
    int height = leftPixmapItem->pixmap().height();
    int width = leftPixmapItem->pixmap().width();
    int max_height = ui->leftGraphicsView->height();
    int max_width = ui->leftGraphicsView->width();
    int size, max_size, fact = 0;
    double val = 0;

    height = leftPixmapItem->pixmap().height();
    width = leftPixmapItem->pixmap().width();
    max_height = ui->rightGraphicsView->height();
    max_width = ui->rightGraphicsView->width();
    size = max_size = fact = 0;
    val = 0;


    size = qMin(width, height);
    max_size = qMin(max_width, max_height);


    if (size < max_size) {
        while ((size * val) < max_size)
            val = pow(1.2, fact++);
        val = pow(1.2, fact - 2);
        ui->rightGraphicsView->setFactor(fact - 2);
    } else {
        val = 1;
        while ((size * val) > max_size)
            val = pow(1.2, fact--);
        val = pow(1.2, fact + 1);
        ui->rightGraphicsView->setFactor(fact + 1);
    }

    ui->rightGraphicsView->scale(val, val);
}

void MainWindow::on_actionAdjustToFitZoom_triggered() {
    adjustSizeLeft();
    adjustSizeRight();
}


/******************************************************************************
 *                   Restore the image, both size and rotate
 *****************************************************************************/
void MainWindow::on_actionRestore_triggered() {
    on_actionNormal_triggered();
    adjustSizeRight();

}

/******************************************************************************
 *                           绘制图像直方图
 *****************************************************************************/
void MainWindow::on_actionHistogram_triggered() {

    QDialog *hstgrmDialog = new QDialog(this);
    QScrollArea *scrollArea = new QScrollArea(hstgrmDialog);
    Histogram *hstgrm = new Histogram(scrollArea);
    hstgrm->computeHstgrm(rightPixmapItem->pixmap().toImage());

    if (hstgrm == nullptr)
        return;


    scrollArea->setWidget(hstgrm);

    QHBoxLayout *layout = new QHBoxLayout;
    layout->addWidget(scrollArea);
    hstgrmDialog->setLayout(layout);

    hstgrm->resize(800, 780);
    hstgrmDialog->setFixedWidth(820);
    scrollArea->setHorizontalScrollBarPolicy(Qt::ScrollBarAlwaysOff);
    scrollArea->adjustSize();

    hstgrmDialog->setWindowTitle("Histogram - ImageQt");

    hstgrmDialog->show();
}


/******************************************************************************
 *                              Add frame
 *****************************************************************************/
void MainWindow::on_actionMovie_frame_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage frame = QImage(":/img/frame_3.png");
    QImage newImage = Tools::DrawFrame(rightImage.toImage(), frame);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::on_actionClassic_frame_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage frame = QImage(":/img/frame_1.png");
    QImage newImage = Tools::DrawFrame(rightImage.toImage(), frame);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::on_actionFlower_frame_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage frame = QImage(":/img/frame_2.png");
    QImage newImage = Tools::DrawFrame(rightImage.toImage(), frame);
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

/******************************************************************************
 *                          Add metal texture
 *****************************************************************************/
void MainWindow::on_actionMetal_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::Metal(rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

/******************************************************************************
 *                              Cool
 *****************************************************************************/
void MainWindow::on_actionCool_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::Cool(30, rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

/******************************************************************************
 *                              Warm
 *****************************************************************************/
void MainWindow::on_actionWarm_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::Warm(30, rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

/******************************************************************************
 *                             高斯平滑
 *****************************************************************************/
void MainWindow::on_actionGauss_triggered() {
    GaussianBlurDialog dialog;
    connect(&dialog, SIGNAL(sendData(int, double)), this,
            SLOT(receiveGaussianFactor(int, double)));

    dialog.exec();
}

/******************************************************************************
 *                     on Action tools->zoom triggered
 *****************************************************************************/
void MainWindow::on_zoomAction_triggered() {
    bool ok;
    int factor = QInputDialog::getInt(this, tr("Zoom"), "Input a value for zoom ratio(%)", 100, 10, 1000, 10, &ok);
    if (ok) {
        if (factor != 100) {
            QPixmap rightImage = rightPixmapItem->pixmap();

            int cur_width = rightImage.width();
            int cur_height = rightImage.height();

            QPixmap newPixmap = rightImage.scaled(cur_width * factor / 100, cur_height * factor / 100);

            updateRightImage(newPixmap);
        } else {
            return;
        }
    }

}

/******************************************************************************
 *                          水平翻转
 *****************************************************************************/
void MainWindow::on_actionHorizontal_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::Horizontal(rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

/******************************************************************************
 *                          垂直翻转
 *****************************************************************************/
void MainWindow::on_actionVertical_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::Vertical(rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}


/******************************************************************************
 *                           灰度线性变换 y = ax + b
 *****************************************************************************/
void MainWindow::on_actionLinear_level_transformation_triggered() {
    LinearGrayDialog dialog;
    connect(&dialog, SIGNAL(sendData(double, double)),
            this, SLOT(receiveLinearGreyParameter(double, double)));
    dialog.exec();
}

/******************************************************************************
 *                             灰度幂次变换
 *****************************************************************************/
void MainWindow::on_actionPower_transformation_triggered() {
    DialogPowerGrey dialog;
    connect(&dialog, SIGNAL(sendData(double, double, double)),
            this, SLOT(receivePowerGreyParamter(double, double, double)));
    dialog.exec();
}

/******************************************************************************
 *                       灰度对数变换 y = log(b+x)/log(a)
 *****************************************************************************/
void MainWindow::on_actionLogarithm_grey_level_transformation_triggered() {
    DialogLogGrey dialog;
    connect(&dialog, SIGNAL(sendData(double, double)),
            this, SLOT(receiveLogGreyParamter(double, double)));
    dialog.exec();
}

/******************************************************************************
 *                             灰度指数变换
 *****************************************************************************/
void MainWindow::on_actionExp_transfrom_triggered() {
    DialogExpTransform dialog;
    connect(&dialog, SIGNAL(sendData(double, double, double)),
            this, SLOT(receiveExpGreyParamter(double, double, double)));
    dialog.exec();
}

/******************************************************************************
 *                             灰度双阈值变换
 *****************************************************************************/
void MainWindow::on_actionTwo_thresholds_transform_triggered() {
    DialogThresholdTransform dialog;
    connect(&dialog, SIGNAL(sendData(int, int, int)),
            this, SLOT(receiveTwoThresholdParamter(int, int, int)));
    dialog.exec();
}

/******************************************************************************
 *                             灰度拉伸变换
 *****************************************************************************/
void MainWindow::on_actionStretch_transformation_triggered() {
    DialogStretchTransform dialog;
    connect(&dialog, SIGNAL(sendData(int, int, double, double, double, double, double)),
            this, SLOT(receiveStretchParamter(int, int, double, double, double, double, double)));
    dialog.exec();
}

void MainWindow::on_actionBinaryzation_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::Binaryzation(rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}


/******************************************************************************
 *                          调整亮度
 *****************************************************************************/
void MainWindow::on_actionAdjust_brightness_triggered() {
    bool ok;
    int delta = QInputDialog::getInt(this,
                                     tr("Brightness"),
                                     "Input a value for brightness(+/-)",
                                     0, -1000, 1000, 10, &ok);
    if (ok) {
        if (delta != 100) {
            QPixmap rightImage = rightPixmapItem->pixmap();

            QImage newImage = Tools::Brightness(delta, rightImage.toImage());
            rightImage.convertFromImage(newImage);

            updateRightImage(rightImage);
        } else {
            return;
        }
    }

}


/******************************************************************************
 *                              To do
 *****************************************************************************/
void MainWindow::on_actionNormal_triggered() {
    QPixmap leftImage = leftPixmapItem->pixmap();
    updateRightImage(leftImage);
    ui->rightGraphicsView->resetTransform();
}


/******************************************************************************
 *                              “关于”窗口
 *****************************************************************************/
void MainWindow::on_actionAbout_triggered() {
    QMessageBox message(QMessageBox::NoIcon, tr(WINDOW_ABOUT), "<p>楼可嘉</p>"
                                                               "<p>219350623</p>");
    message.setIconPixmap(QPixmap(":/img/myAvatar.jpg"));
    message.exec();
}


/******************************************************************************
 *                           获得当前用户的用户名
 *****************************************************************************/
QString MainWindow::getUserName() {
    QString userPath = QStandardPaths::writableLocation(QStandardPaths::HomeLocation);
    QString userName = userPath.section("/", -1, -1);
    return userName;
}

/******************************************************************************
 *                              获得当前用户的家目录
 *****************************************************************************/
QString MainWindow::getUserPath() {
    QString userPath = QStandardPaths::writableLocation(QStandardPaths::HomeLocation);
    return userPath;
}

/******************************************************************************
 *                              轮廓提取法
 *****************************************************************************/
void MainWindow::on_actionContour_extraction_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImage = Tools::ContourExtraction(rightImage.toImage());
    rightImage.convertFromImage(newImage);

    updateRightImage(rightImage);
}

void MainWindow::on_actionArea_triggered() {
    QPixmap rightImage = rightPixmapItem->pixmap();
    QImage newImg = rightImage.toImage();
    QImage binImg = Tools::Binaryzation(newImg);
    int area = 0;
    for (int x = 0; x < binImg.width(); x++) {
        for (int y = 0; y < binImg.height(); y++) {
            if (QColor(binImg.pixel(x, y)).red() == 0)
                area++;
        }
    }

    QMessageBox *message = new QMessageBox(QMessageBox::NoIcon, QObject::tr("面积计算"),
                                           "连通区域的面积为：" + QString::number(area));
    message->show();
}

void MainWindow::on_actionRotate_triggered() {
    bool ok;
    int factor = QInputDialog::getInt(this, tr("旋转"), "请输入要旋转的角度（正数向右，负数向左）", 0, -360, 360, 10, &ok);
    if (ok) {
        if (factor != 0) {
            QPixmap rightImage = rightPixmapItem->pixmap();

            QImage *imgRotate = new QImage;
            QMatrix matrix;
            matrix.rotate(factor);
            *imgRotate = rightImage.toImage().transformed(matrix);
            QPixmap newPixmap;
            newPixmap = QPixmap::fromImage(*imgRotate);
            updateRightImage(newPixmap);
        } else {
            return;
        }
    }
}


void MainWindow::on_actionSwitchChinese_triggered() {
    QTranslator translator;
    translator.load(":/language/cn.qm");
    qApp->installTranslator(&translator);
    ui->retranslateUi(this);
}

void MainWindow::on_actionSwitchEnglish_triggered() {
    QTranslator translator;
    translator.load(":/language/en.qm");
    qApp->installTranslator(&translator);
    ui->retranslateUi(this);
}


void MainWindow::on_actionZoom_triggered() {
    bool ok;
    int factor = QInputDialog::getInt(this, tr("Zoom"), "Input a value for zoom ratio(%)", 100, 10, 1000, 10, &ok);
    if (ok) {
        if (factor != 100) {
            QPixmap rightImage = rightPixmapItem->pixmap();

            int cur_width = rightImage.width();
            int cur_height = rightImage.height();

            QPixmap newPixmap = rightImage.scaled(cur_width * factor / 100, cur_height * factor / 100);

            updateRightImage(newPixmap);
        } else {
            return;
        }
    }
}

