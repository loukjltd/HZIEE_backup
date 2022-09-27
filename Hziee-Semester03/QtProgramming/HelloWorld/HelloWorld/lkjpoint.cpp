#include <iostream>
#include "lkjpoint.h"
using namespace std;

void LKJPoint::Add()
{ x ++; y ++; }
void LKJPoint::Show()			// 显示坐标
{ qDebug() << "(" << x << "," << y << ")"; }   //可用qDebug()代替cout
void LKJPoint::ShowUnderline()
{ qDebug() << "----------"; }
