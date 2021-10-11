//public class UseLocker {
//    public static void main(String[] args) {
//        Locker lock1, lock2, lock3;
//
//        lock1 = new Locker("Lisa", 3, 301);
//        lock2 = new Locker("Sam", 3, 302);
//        lock3 = new Locker("Sam", 3, 201);
//        System.out.println(lock1.toString());
//        System.out.println(lock2.toString());
//        System.out.println(lock3.toString());
//
//        if (lock1.getIsVacant()) System.out.println(lock1.toString());
//        System.out.println();
//        if (lock2.hasSameHirer()) {
//            System.out.println("同一租赁者 " + lock2.toString());
//            System.out.println("同一租赁者 " + lock3.toString());
//        }
//    }
//}
//
//class Locker {
//    private int num, cabinetNum;
//    private boolean isVacant;
//    private String hirer;
//    public Locker(String hire, int cabinet, int num) {
//        cabinetNum = cabinet;
//        this.num = num;
//        isVacant = false;
//    }
//    public boolean getIsVacant() {
//
//    }
//    public void setIsVacant(boolean b) {
//        isVacant = b;
//        if (isVacant) hirer="";
//    }
//
//    public boolean hasSameHirer(Locker otherL) {
//        if (true) return true;
//        else return false;
//    }
//
//    public String toString() {
//        String str = "柜号：" + cabinetNum + "，箱号：" + num;
//        if (isVacant) str += "当前空闲";
//        else str += "当前由" + hirer + "使用";
//        return str;
//    }
//}
