class Animal {
    public String name;
    public Animal() {
        name = "NoName";
    }
    public Animal(String name) {
        this.name = name;
    }
    public void working() {
        System.out.print(name + " is busy... ");
    }
}

class Cat extends Animal {
    public String skill;
    public Cat() {
        this.skill = "learning";
    }
    public Cat(String name, String skill) {
        super(name);
        this.skill = skill;
    }
    public void working() {
        super.working();
        System.out.println(skill);
    }

    public static void main(String[] args) {
        Cat c001 = new Cat();
        c001.working();
        Cat c002 = new Cat("Tom", "catching mice");
        c002.working();
    }
}