import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    // Main主函数
    public static void main(String[] args) {
        loginAccount();
        welcomeSystem();
    }

    // 登陆功能的方法
    public static void loginAccount() {
        int countWrongTimes = 3;
        while (countWrongTimes != 0) {
            System.out.println("请输入用户名：");
            Scanner getUserName = new Scanner(System.in);
            String enteredUserName = getUserName.nextLine();
            System.out.println("请输入密码：");
            Scanner getPassword = new Scanner(System.in);
            String enteredPassword = getPassword.nextLine();

            if ((Objects.equals(enteredUserName, "hziee")) && (Objects.equals(enteredPassword, "edu"))) {
                System.out.println("登陆成功！");
                break;
            } else {
                System.out.println("用户名或密码错误！");
                countWrongTimes = countWrongTimes - 1;
                System.out.println("你还有" + countWrongTimes + "次机会！");
            }

        }
        if (countWrongTimes == 0) {
            System.exit(0);
        }
    }

    // 随机生成0-100分数的方法
    public static int randomGrade() {
        return (int) (Math.random() * 100);
    }

    // 欢迎界面的方法
    public static void welcomeSystem() {
        ArrayList<Student> stuArray = new ArrayList<Student>();
        while (true) {
            System.out.println("-----欢迎来到主界面-----");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你的选择");

            Scanner getOptionNum = new Scanner(System.in);
            String targetOptionNum = getOptionNum.nextLine();

            switch (targetOptionNum) {
                case "1":
                    addStu(stuArray);
                    break;
                case "2":
                    delStu(stuArray);
                    break;
                case "3":
                    alterStu(stuArray);
                    break;
                case "4":
                    listAll(stuArray);
                    break;
                case "5":
                    System.out.println("再见！");
                    System.exit(0);
                    break;
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
        int stuGrade = randomGrade();

        Student testStu = new Student();
        testStu.setStuID(stuID);
        testStu.setStuName(stuName);
        testStu.setStuGrade(String.valueOf(stuGrade));

        stuArray.add(testStu);
        System.out.println("已成功添加一位学生信息！");
    }

    // 删除学生信息的方法
    public static void delStu(ArrayList<Student> stuArray) {
        Scanner getStuInfo = new Scanner(System.in);
        System.out.println("请输入要删除的学生的学号：");
        String stuID = getStuInfo.nextLine();

        int positionIndex = -1;
        for (int i = 0; i < stuArray.size() ; i ++) {
            Student testStu = stuArray.get(i);
            if (testStu.getStuID().equals(stuID) ) {
                positionIndex = i;
                break;
            }
        }

        if (positionIndex == -1) {
            System.out.println("该学生信息不存在，请重新输入！");
        } else {
            stuArray.remove(positionIndex);
            System.out.println("已成功删除一位学生信息！");
        }
    }

    // 更改学生信息的方法
    public static void alterStu(ArrayList<Student> stuArray) {
        Scanner getStuInfo = new Scanner(System.in);
        System.out.println("请输入要修改学生的学号：");
        String stuID = getStuInfo.nextLine();
        System.out.println("请输入学生新姓名：");
        String newName = getStuInfo.nextLine();
        System.out.println("请输入学生新成绩：");
        String newGrade = getStuInfo.nextLine();

        Student s = new Student();
        s.setStuID(stuID);
        s.setStuName(newName);
        s.setStuGrade(newGrade);

        int positionIndex = -1;
        for (int i = 0; i < stuArray.size(); i++) {
            Student student = stuArray.get(i);
            if (student.getStuID().equals(stuID)) {
                positionIndex = i;
                break;
            }
        }

        if (positionIndex == -1) {
            System.out.println("该学生信息不存在!");
        } else {
            stuArray.set(positionIndex, s);
            System.out.println("已成功修改一位学生信息！");

        }
    }

    // 查看所有学生信息的方法
    public static void listAll(ArrayList<Student> stuArray) {
        if (stuArray.size() == 0) {
            System.out.println("数据库中无学生信息！");
            return;
        }

        System.out.println("学号 姓名 成绩");
        for (int i = 0; i < stuArray.size(); i++) {
            Student testStu = stuArray.get(i);
            System.out.println(testStu.getStuID() + "\t" + testStu.getStuName() + "\t" + testStu.getStuGrade() + "分");
        }
    }
}

// Student类
class Student {
    private String stuID;
    private String stuName;
    private int stuGrade;

    public Student() {

    }

    public Student(String stuID, String stuName, int stuGrade) {
        this.stuID = stuID;
        this.stuName = stuName;
        this.stuGrade = stuGrade;
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

    public int getStuGrade() {
        return stuGrade;
    }
    public void setStuGrade(String stuGrade) {
        this.stuGrade = Integer.parseInt(stuGrade);
    }
}
