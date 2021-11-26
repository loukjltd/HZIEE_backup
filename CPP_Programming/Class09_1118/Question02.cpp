#include<iostream>
#include<string>

using namespace std;

class Publication{
protected:
    string title;
    float price;

public:
    void SetPublication(string new_title) {
        title = new_title;
    }

    void SetPublication(float new_price) {
        price = new_price;
    }

    string GetTitle() const {
        return title;
    }

    float GetPrice() const {
        return price;
    }

    void show() const;
    void GetData();
    Publication();
};

Publication::Publication(){
    title = "";
    price = 0;
}

void Publication::show() const{
    cout << "标题:" << title << endl;
    cout << "价格:" << price << "元" << endl;
}

void Publication::GetData() {
    cin >> title >> price;
}


class Book : public Publication{
private:
    int page;

public:
    void SetPage(int pg) {
        page = pg;
    }

    int Getpage() const {
        return page;

    }
    void show() const;
    void GetData();
    Book();
};

Book::Book(){
    page = 0;
}

void Book::show() const{
    cout << "标题:" << title << endl;
    cout << "价格:" << price << "元" << endl;
    cout << "页数:" << page << endl;
}


void Book::GetData() {
    cin >> title >> price >> page;

}

class Tape : public Publication{
private:
    float playTime;

public:
    void SetplayTime(float new_playTime) {
        playTime = new_playTime;
    }
    float GetplayTime() const {
        return playTime;
    }

    void show() const;
    void GetData();
    Tape();
};

Tape::Tape(){
    playTime = 0;
}

void Tape::GetData() {
    cin >> title >> price >> playTime;
}

void Tape::show() const{
    cout << "标题:" << title << endl;
    cout << "价格:" << price << "元" << endl;
    cout << "播放时间:" << playTime << "分钟" << endl;
}

int main(){

    Publication *p = new Publication();
    p -> GetData();
    cout << "出版物信息:" << endl;
    p -> show();

    Book *b = new Book();
    b -> GetData();
    cout << "书籍信息:" << endl;
    b -> show();

    Tape *t = new Tape();
    t -> GetData();
    cout << "磁带信息:" << endl;
    t -> show();

    delete t;
    delete b;
    delete p;

    return 0;
}

