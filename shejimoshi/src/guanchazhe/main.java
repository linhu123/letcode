package guanchazhe;

public class main {
    public static void main(String[] args) {
        Student stu = new Student();
        new ObserverOne(stu);
        new ObserverTwo(stu);
//        stu.notifyAllObs();
        stu.setState("111");
        stu.setState("222");
    }
}
