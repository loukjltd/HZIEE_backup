class Fruit6_3{
    public void health(){
        System.out.println("吃水果有益");
    }
}

public class Example06_03 extends Fruit6_3{
    public void health(String content){
        System.out.println("一般功效：" + content);
    }
    public void health(String patients,String content){
        System.out.println("对于" + patients + "," + content);
    }
    public static void main(String[] args) {
        Example06_03 testFruit = new Example06_03();
        testFruit.health();
        testFruit.health("生津止渴、润肺除烦");
        testFruit.health("糖尿病患者","要吃苹果");
    }
}
