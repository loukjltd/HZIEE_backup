import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // 输入学生的学号，姓名，各科成绩及总分，以end结束
    public static void main(String[] args) {
        welcomeSystem();
    }
    // 欢迎界面的方法
    public static void welcomeSystem() {
        ArrayList<Student> stuArray = new ArrayList<>();
        while (true) {
            System.out.println("-----欢迎来到主界面-----");
            System.out.println("1. 添加学生");
            System.out.println("2. 排序并查看所有学生");
            System.out.println("3. 退出");
            System.out.println("请输入你的选择");

            Scanner getOptionNum = new Scanner(System.in);
            String targetOptionNum = getOptionNum.nextLine();

            switch (targetOptionNum) {
                case "1" -> addStu(stuArray);
                case "2" -> listAll(stuArray);
                case "3" -> {
                    System.out.println("再见！");
                    System.exit(0);
                }
            }
        }
    }

    // 添加学生信息的方法
    public static void addStu(ArrayList<Student> stuArray) {
        Scanner getStuInfo = new Scanner(System.in);
        System.out.println("请输入学生的学号：");
        String stuID = getStuInfo.nextLine();
        System.out.println("请输入学生的姓名：");
        String stuName = getStuInfo.nextLine();
        System.out.println("请输入学生的语文成绩：");
        int stuChinGrade = getStuInfo.nextInt();
        System.out.println("请输入学生的数学成绩：");
        int stuMathGrade = getStuInfo.nextInt();
        System.out.println("请输入学生的英语成绩：");
        int stuEngGrade = getStuInfo.nextInt();


        Student testStu = new Student();
        testStu.setStuID(stuID);
        testStu.setStuName(stuName);
        testStu.setStuChinGrade(stuChinGrade);
        testStu.setStuMathGrade(stuMathGrade);
        testStu.setStuEngGrade(stuEngGrade);
        testStu.setStuTotalGrade(stuChinGrade + stuMathGrade + stuEngGrade);

        stuArray.add(testStu);
        System.out.println("已成功添加一位学生信息！");
    }

    // 查看所有学生信息的方法
    public static void listAll(ArrayList<Student> stuArray) {
        if (stuArray.size() == 0) {
            System.out.println("数据库中无学生信息！");
            return;
        }

        // 对stuTotalGrade从高到低进行选择排序，并输出序号
        for (int i = 0; i < stuArray.size(); i++) {
            for (int j = i + 1; j < stuArray.size(); j++) {
                if (stuArray.get(i).getStuTotalGrade() < stuArray.get(j).getStuTotalGrade()) {
                    Student temp = stuArray.get(i);
                    stuArray.set(i, stuArray.get(j));
                    stuArray.set(j, temp);
                }
            }
        }


        System.out.println("名次 学号 姓名 语文 数学 英语 总分");
        for (int i = 0; i < stuArray.size(); i++) {
            int rank = i + 1;
            Student testStu = stuArray.get(i);
            Student lastStu;
            if (i > 0) {
                lastStu = stuArray.get(i - 1);
            } else {
                lastStu = stuArray.get(i);
            }

            if (i > 0 && testStu.getStuTotalGrade() == lastStu.getStuTotalGrade()) {
                rank = i;
            }

            System.out.println(rank + " " + testStu.getStuID() + " " + testStu.getStuName() + " " +
                    testStu.getStuChinGrade() + " " + testStu.getStuMathGrade() + " " +
                    testStu.getStuEngGrade() + " " + testStu.getStuTotalGrade());
        }
    }
}


class Student {
    private String stuID;
    private String stuName;
    private int stuChinGrade;
    private int stuMathGrade;
    private int stuEngGrade;
    private int stuTotalGrade;
    public Student() {

    }

    public Student(String stuID, String stuName, int stuChinGrade, int stuMathGrade, int stuEngGrade, int stuGrade) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuChinGrade = stuChinGrade;
        this.stuMathGrade = stuMathGrade;
        this.stuEngGrade = stuEngGrade;
        this.stuTotalGrade = stuGrade;
    }

    public String getStuID() {
        return stuID;
    }
    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }
    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuChinGrade() {
        return stuChinGrade;
    }
    public void setStuChinGrade(int stuChinGrade) {
        this.stuChinGrade = stuChinGrade;
    }

    public int getStuMathGrade() {
        return stuMathGrade;
    }
    public void setStuMathGrade(int stuMathGrade) {
        this.stuMathGrade = stuMathGrade;
    }

    public int getStuEngGrade() {
        return stuEngGrade;
    }
    public void setStuEngGrade(int stuEngGrade) {
        this.stuEngGrade = stuEngGrade;
    }

    public int getStuTotalGrade() {
        return stuTotalGrade;
    }
    public void setStuTotalGrade(int stuTotalGrade) {
        this.stuTotalGrade = stuTotalGrade;
    }
}