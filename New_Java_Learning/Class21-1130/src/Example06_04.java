class Animal{
    public String name;
    public Animal(){
        name = "无名";
    }
    public Animal(String name){
        this.name = name;
    }

    public void work(){
        System.out.print(name+"忙于");
    }
}

public class Example06_04 extends Animal{
    public String skill;
    public Example06_04(){
        this.skill = "学本领";
    }
    public Example06_04(String name,String skill){
        super(name);
        this.skill = skill;
    }
    public void work(){
        super.work();
        System.out.println(skill);
    }

    public static void main(String[] args) {
        Example06_04 c1 = new Example06_04();
        c1.work();
        Example06_04 c2 = new Example06_04("汤姆","抓老鼠");
        c2.work();
    }
}
