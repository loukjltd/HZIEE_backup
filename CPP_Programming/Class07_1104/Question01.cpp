#include <iostream>
#include <cstring>

using namespace std;

class Student {
private:
    double m_score; // 学生分数
    char m_name[64];

    static int m_count;
    static double sum_score;

public:
    Student() {
    }

    Student(char *name ,double score) {
        m_score = score;

        m_count++;
        sum_score += score;

        strcpy(m_name, name);
    }

    static double Average() {
        return sum_score / m_count;
    }

    static double getSumScore() {
        return sum_score;
    }

    ~Student() {
        m_count--;
        sum_score -= m_score;

    }
};


int Student::m_count = 0;

double Student::sum_score = 0.0;

int main(){

    Student *s1 = new Student("Zhang", 82);
    Student *s2 = new Student("Li", 79);
    Student *s3 = new Student("Wang", 93);
    Student *s4 = new Student("Liu", 66);
    Student *s5 = new Student("Xia", 90);

    cout << Student::getSumScore() << endl;
    cout << Student::Average() << endl;

    delete s5;
    delete s4;
    delete s3;
    delete s2;
    delete s1;

    return 0;
}
