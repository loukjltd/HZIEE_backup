﻿#include "tools.h"
#include "medianfilter.h"

#define min2(a,b) (a)<(b)?(a):(a)
#define min(a,b,c) (min2(a,b))<(c)?(min2(a,b)):(c)


/*****************************************************************************
 *                           Greyscale
 * **************************************************************************/
QImage Tools::GreyScale(QImage origin)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                   QImage::Format_ARGB32);
    QColor oldColor;

    for (int x=0; x<newImage->width(); x++) {
        for (int y=0; y<newImage->height(); y++) {
            oldColor = QColor(origin.pixel(x,y));
            int average = (oldColor.red()*299+oldColor.green()*587+oldColor.blue()*114+500)/1000;
            newImage->setPixel(x,y,qRgb(average,average,average));
        }
    }

    return *newImage;

}

/*****************************************************************************
 *                           Adjust color temperature
 * **************************************************************************/
QImage Tools::Warm(int delta, QImage origin)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                  QImage::Format_ARGB32);

    QColor oldColor;
    int r, g, b;

    for (int x=0; x<newImage->width(); x++)
    {
        for (int y=0; y<newImage->height(); y++)
        {
            oldColor = QColor(origin.pixel(x,y));

            r = oldColor.red() + delta;
            g = oldColor.green() + delta;
            b = oldColor.blue();
            r = qBound(0, r, 255);
            g = qBound(0, g, 255);

            newImage->setPixel(x,y, qRgb(r,g,b));
        }
    }
    return *newImage;
}

QImage Tools::Cool(int delta, QImage origin)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                  QImage::Format_ARGB32);

    QColor oldColor;
    int r, g, b;

    for (int x=0; x<newImage->width(); x++)
    {
        for (int y=0; y<newImage->height(); y++)
        {
            oldColor = QColor(origin.pixel(x,y));

            r = oldColor.red();
            g = oldColor.green();
            b = oldColor.blue() + delta;

            // Check if the new values are between 0 and 255
            r = qBound(0, r, 255);
            g = qBound(0, g, 255);

            newImage->setPixel(x,y, qRgb(r,g,b));
        }
    }
    return *newImage;
}



/*****************************************************************************
 *                          Adjust image brightness
 * **************************************************************************/
QImage Tools::Brightness(int delta, QImage origin)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                  QImage::Format_ARGB32);

    QColor oldColor;
    int r, g, b;

    for (int x=0; x<newImage->width(); x++)
    {
        for (int y=0; y<newImage->height(); y++)
        {
            oldColor = QColor(origin.pixel(x,y));

            r = oldColor.red() + delta;
            g = oldColor.green() + delta;
            b = oldColor.blue() + delta;

            // Check if the new values are between 0 and 255
            r = qBound(0, r, 255);
            g = qBound(0, g, 255);
            b = qBound(0, b, 255);

            newImage->setPixel(x,y, qRgb(r,g,b));
        }
    }
    return *newImage;
}

/*****************************************************************************
 *                                   Flip
 * **************************************************************************/
QImage Tools::Horizontal(const QImage &origin)
{
    QImage *newImage = new QImage(QSize(origin.width(), origin.height()),
                                  QImage::Format_ARGB32);
    QColor tmpColor;
    int r, g, b;
    for (int x=0; x<newImage->width(); x++)
    {
        for (int y=0; y<newImage->height(); y++)
        {
            tmpColor = QColor(origin.pixel(x, y));
            r = tmpColor.red();
            g = tmpColor.green();
            b = tmpColor.blue();

            newImage->setPixel(newImage->width()-x-1,y, qRgb(r,g,b));

        }
    }
    return *newImage;
}

QImage Tools::Vertical(const QImage &origin)
{
    QImage *newImage = new QImage(QSize(origin.width(), origin.height()),
                                  QImage::Format_ARGB32);
    QColor tmpColor;
    int r, g, b;
    for (int x=0; x<newImage->width(); x++)
    {
        for (int y=0; y<newImage->height(); y++)
        {
            tmpColor = QColor(origin.pixel(x, y));
            r = tmpColor.red();
            g = tmpColor.green();
            b = tmpColor.blue();

            newImage->setPixel(x, newImage->height()-y-1, qRgb(r,g,b));

        }
    }
    return *newImage;
}





/*****************************************************************************
 *                            添加相框
 * **************************************************************************/
QImage Tools::DrawFrame(QImage origin, QImage &frame)
{
    QImage *newImage = new QImage(origin);
    QPainter painter;

    int width = origin.width();
    int height = origin.height();

    QImage tmpFrame = frame.scaled(QSize(width, height));

    painter.begin(newImage);
    painter.drawImage(0, 0, tmpFrame);
    painter.end();

    return *newImage;

}

/*****************************************************************************
 *                           线性灰度变换 y = ax + b
 * **************************************************************************/
QImage Tools::LinearLevelTransformation(const QImage &origin, double _a, double _b)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                   QImage::Format_ARGB32);
    QColor oldColor;
    int grayLevel = 0;

    for (int x=0; x<newImage->width(); x++) {
        for (int y=0; y<newImage->height(); y++) {
            oldColor = QColor(origin.pixel(x,y));
            grayLevel = (oldColor.red()*299+oldColor.green()*587+oldColor.blue()*114+500)/1000;
            int _y = _a*grayLevel + _b;
            // Make sure that the new values are between 0 and 255
            _y = qBound(0, _y, 255);

            newImage->setPixel(x,y,qRgb(_y,_y,_y));
        }
    }
//    qDebug()<<"a:"<<_a<<"\tb:"<<_b;

    return *newImage;
}


/*****************************************************************************
 *                           对数灰度变换
 * **************************************************************************/
QImage Tools::LogGreyLevelTransformation(const QImage &origin, double a, double b)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                   QImage::Format_ARGB32);
    QColor oldColor;
    int grayLevel = 0;

    for (int x=0; x<newImage->width(); x++) {
        for (int y=0; y<newImage->height(); y++) {
            oldColor = QColor(origin.pixel(x,y));
            grayLevel = (oldColor.red()*299+oldColor.green()*587+oldColor.blue()*114+500)/1000;
            int _y = qLn(b+grayLevel)/qLn(a);

            // Make sure that the new values are between 0 and 255
            _y = qBound(0, _y, 255);

            newImage->setPixel(x,y,qRgb(_y,_y,_y));
        }
    }

    return *newImage;
}


/*****************************************************************************
 *                           幂次灰度变换 _y=c*_x^r+b
 * **************************************************************************/
QImage Tools::PowerGreyLevelTransformation(const QImage &origin, double c, double r, double b)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                   QImage::Format_ARGB32);
    QColor oldColor;
    int _x = 0;

    for (int x=0; x<newImage->width(); x++) {
        for (int y=0; y<newImage->height(); y++) {
            oldColor = QColor(origin.pixel(x,y));
            _x = (oldColor.red()*299+oldColor.green()*587+oldColor.blue()*114+500)/1000;
            int _y =c*qPow(_x, r)+b;

            // Make sure that the new values are between 0 and 255
            _y = qBound(0, _y, 255);

            newImage->setPixel(x,y,qRgb(_y,_y,_y));
        }
    }

    return *newImage;
}


/*****************************************************************************
 *                                  指数灰度变换
 * **************************************************************************/
QImage Tools::ExpTransform(const QImage &origin, double b, double c, double a)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                   QImage::Format_ARGB32);
    QColor oldColor;
    int _x = 0;

    for (int x=0; x<newImage->width(); x++) {
        for (int y=0; y<newImage->height(); y++) {
            oldColor = QColor(origin.pixel(x,y));
            _x = (oldColor.red()*299+oldColor.green()*587+oldColor.blue()*114+500)/1000;
            int _y =qPow(b, c*(_x-a));

            // Make sure that the new values are between 0 and 255
            _y = qBound(0, _y, 255);

            newImage->setPixel(x,y,qRgb(_y,_y,_y));
        }
    }

    return *newImage;
}

/*****************************************************************************
 *                                  双阈值灰度变换
 * int option:
 *          0   0-255-0
 *          1   255-0-255
 * **************************************************************************/
QImage Tools::TwoThreshold(const QImage &origin, double t1, double t2, int option)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                   QImage::Format_ARGB32);
    QColor oldColor;
    int _x = 0;
    int _y = 0;
    if (option == 0)
    {
        for (int x=0; x<newImage->width(); x++) {
            for (int y=0; y<newImage->height(); y++) {
                oldColor = QColor(origin.pixel(x,y));
                _x = (oldColor.red()*299+oldColor.green()*587+oldColor.blue()*114+500)/1000;

                if (_x < t1 || _x > t2)
                    _y = 0;
                else
                    _y = 255;


                // Make sure that the new values are between 0 and 255
                _y = qBound(0, _y, 255);

                newImage->setPixel(x,y,qRgb(_y,_y,_y));
            }
        }
    }
    else
    {
        for (int x=0; x<newImage->width(); x++) {
            for (int y=0; y<newImage->height(); y++) {
                oldColor = QColor(origin.pixel(x,y));
                _x = (oldColor.red()*299+oldColor.green()*587+oldColor.blue()*114+500)/1000;

                if (_x>=t1 && _x<=t2)
                    _y = 0;
                else
                    _y = 255;


                // Make sure that the new values are between 0 and 255
                _y = qBound(0, _y, 255);

                newImage->setPixel(x,y,qRgb(_y,_y,_y));
            }
        }
    }

    return *newImage;
}



/*****************************************************************************
 *                                拉伸灰度变换
 * 拉伸变换使用一个分段函数，三个k值
 * **************************************************************************/
QImage Tools::StretchTransform(const QImage &origin,
                               int x1, int x2,
                               double k1, double k2, double k3,
                               double b2, double b3)
{
    QImage *newImage = new QImage(origin.width(), origin.height(),
                                   QImage::Format_ARGB32);
    QColor oldColor;
    int _x = 0;
    int _y = 0;

    for (int x=0; x<newImage->width(); x++) {
        for (int y=0; y<newImage->height(); y++) {
            oldColor = QColor(origin.pixel(x,y));
            _x = (oldColor.red()*299+oldColor.green()*587+oldColor.blue()*114+500)/1000;

            if ( _x<x1)
                _y = k1*_x;
            else if (_x < x2)
                _y = k2*_x + b2;
            else
                _y = k3*_x + b3;


            // Make sure that the new values are between 0 and 255
            _y = qBound(0, _y, 255);

            newImage->setPixel(x,y,qRgb(_y,_y,_y));
        }
    }

    return *newImage;
}

/*****************************************************************************
 *                                  高斯平滑
 * **************************************************************************/
QImage Tools::GaussianSmoothing(const QImage &origin, int radius, double sigma)
{

    GaussianBlur *blur = new GaussianBlur(radius, sigma);
    QImage newImage = blur->BlurImage(origin);

    return newImage;
}

/*****************************************************************************
 *                                 二值化
 * **************************************************************************/
QImage Tools::Binaryzation(const QImage &origin)
{


    int width = origin.width();
    int height = origin.height();
    QImage newImg = QImage(width, height, QImage::Format_RGB888);

    for (int x=0; x<width; x++)
    {
        for(int y=0; y<height; y++)
        {
            int gray = qGray(origin.pixel(x,y));
            int newGray;
            if (gray > 128)
                newGray = 255;
            else
                newGray = 0;
            newImg.setPixel(x,y,qRgb(newGray, newGray, newGray));
        }
    }
    return newImg;
}


/*****************************************************************************
 *                                 金属拉丝效果
 * **************************************************************************/
QImage Tools::Metal(QImage origin)
{
    QImage *baseImage = new QImage(":/img/src/metal.png");
    QImage darkImage = Tools::Brightness(-100, origin);
    QImage greyImage = Tools::GreyScale(darkImage);
    QPainter painter;

    QImage newImage = baseImage->scaled(QSize(origin.width(),origin.height()));

    painter.begin(&newImage);
    painter.setOpacity(0.5);
    painter.drawImage(0, 0, greyImage);
    painter.end();

    return newImage;
}


/*****************************************************************************
 *                                 轮廓提取法
 * **************************************************************************/
QImage Tools::ContourExtraction(const QImage &origin)
{
    int width = origin.width();
    int height = origin.height();
    int pixel[8];   // 当前像素周围的8个像素的像素值
//    int *pixel = new int[9];
    QImage binImg = Binaryzation(origin);
    QImage newImg = QImage(width, height, QImage::Format_RGB888);
    newImg.fill(Qt::white);

    for(int y=1; y<height; y++)
    {
        for(int x=1; x<width; x++)
        {
            memset(pixel,0,8);

            if (QColor(binImg.pixel(x,y)).red() == 0)
            {
                newImg.setPixel(x, y, qRgb(0,0,0));
                pixel[0] = QColor(binImg.pixel(x-1,y-1)).red();
                pixel[1] = QColor(binImg.pixel(x-1,y)).red();
                pixel[2] = QColor(binImg.pixel(x-1,y+1)).red();
                pixel[3] = QColor(binImg.pixel(x,y-1)).red();
                pixel[4] = QColor(binImg.pixel(x,y+1)).red();
                pixel[5] = QColor(binImg.pixel(x+1,y-1)).red();
                pixel[6] = QColor(binImg.pixel(x+1,y)).red();
                pixel[7] = QColor(binImg.pixel(x+1,y+1)).red();
                if (pixel[0]+pixel[1]+pixel[2]+pixel[3]+pixel[4]+pixel[5]+pixel[6]+pixel[7] == 0)
                    newImg.setPixel(x,y,qRgb(255,255,255));
            }
        }
    }

    return newImg;
}

QImage Tools::Final(const QImage &origin)
{
    int width  = origin.width()/3;
    int height = origin.height()/3;
    int dilateItem[9] = {1,0,1,
                         0,0,0,
                         1,0,1};



    QImage newImg = QImage(origin.width(), origin.height(), QImage::Format_RGB888);

    for(int x=1; x<width; x++)
    {
        for(int y=1; y<height; y++)
        {
            newImg.setPixel(x,y,qRgb(255,255,255));
            for(int m=0; m<3; m++)
            {
                for(int n=0; n<3; n++)
                {
                    if(dilateItem[m+n] == 1)
                        continue;
                    QColor mColor = origin.pixel(x+(n-1),y+(1-m));
                    if(mColor.red() < 128){
                        newImg.setPixel(x,y,qRgb(0,0,0));
                    }
                }
            }
        }
    }


    // laplace
    int window[3][3] = {0,-1,0,-1,4,-1,0,-1,0};
    for(int x=width; x<2*width; x++)
    {
        for(int y=1; y<height; y++)
        {
            int sumR = 0;
            int sumG = 0;
            int sumB = 0;

            //对每一个像素使用模板
            for(int m=x-1; m<= x+1; m++)
                for(int n=y-1; n<=y+1; n++)
                {
                    if(m>=0 && m<width && n<height)
                    {
                        sumR += QColor(origin.pixel(m,n)).red()*window[n-y+1][m-x+1];
                        sumG += QColor(origin.pixel(m,n)).green()*window[n-y+1][m-x+1];
                        sumB += QColor(origin.pixel(m,n)).blue()*window[n-y+1][m-x+1];
                    }
                }


            int old_r = QColor(origin.pixel(x,y)).red();
            sumR += old_r;
            sumR = qBound(0, sumR, 255);

            int old_g = QColor(origin.pixel(x,y)).green();
            sumG += old_g;
            sumG = qBound(0, sumG, 255);

            int old_b = QColor(origin.pixel(x,y)).blue();
            sumB += old_b;
            sumB = qBound(0, sumB, 255);


            newImg.setPixel(x,y, qRgb(sumR, sumG, sumB));
        }
    }
    return newImg;
}
