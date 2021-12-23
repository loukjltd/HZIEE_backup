#include <iostream>
#include <string.h>

using namespace std;

class Student{
private:
    int m_score;
    char * m_name;

public:
    Student(const char * n, int score);
    friend char Compare(const Student stu1, const Student stu2);
    ~Student();
    Student();
};

Student::Student(const char * name, int score){
    int len = strlen(name);
    m_name = new char[len+1];
    strcpy(m_name, name);

    m_score = score;
}

Student::~Student() {
    if (m_name != NULL) {
        m_name = NULL;
    }
}

char Compare(const Student stu1, const Student stu2){
    if(stu1.m_score > stu2.m_score) {
        return('>');
    } else if (stu1.m_score < stu2.m_score){
        return('<');
    } else {
        return('=');
    }
}

int main(){

    char name[64];
    int score;

    cin >> name >> score;
    Student *stu1 = new Student(name, score);

    cin >> name >> score;
    Student *stu2 = new Student(name, score);

    cout << Compare(*stu1, *stu2) << endl;

    delete stu1;
    delete stu2;

    return 0;
}
