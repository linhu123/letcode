package guanchazhe;

public class ObserverOne extends Observer{
    public ObserverOne(Student stu) {
        this.student = stu;
        this.student.attach(this);
    }

    @Override
    public void update() {
        System.out.println(student.getState());
    }
}
