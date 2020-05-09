package guanchazhe;

public class ObserverTwo extends Observer{
    public ObserverTwo(Student stu) {
        this.student = stu;
        this.student.attach(this);
    }

    @Override
    public void update() {
        System.out.println(student.getState());
    }
}
