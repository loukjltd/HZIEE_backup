class Person {
    protected String name;
    protected char sex;
    public Person(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }
    String name(){
        return name;
    }
    char sex(){
        return sex;
    }
    public String toString() {
        String s = new String(name + "(sex:"+sex+")");
        return s;
    }
}

class Student extends Person {
    protected String id;
    Student(String name, char sex) {
        super(name, sex);
    }
    Student(String name, char sex, String id) {
        super(name, sex);
        this.id = id;
    }
    public String toString() {
        String s = new String(name + "(sex:" + sex);
        if (id != null) s += "id" + id;
        s+=")";
        return s;
    }
    public void setId(String id) {
        this.id = id;
    }
}

class Main{
    public static void main(String[] args) {
        Person frank = new Person("Frank", 'M');
        Student alice = new Student("Alice", 'F');
        System.out.println("frank: " + frank);
        System.out.println("alice " + alice);
        Person tom = alice;
        System.out.println("tom: " + tom);
        alice.setId("alice");
        System.out.println("tom: " + tom);
    }
}