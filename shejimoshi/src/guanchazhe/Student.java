package guanchazhe;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private List<Observer> list = new ArrayList<>();
    private String state;

    public void attach(Observer observer){
        list.add(observer);
    }
    public String getState() {
        return state;
    }
    public void setState(String state){
        this.state = state;
        notifyAllObs();
    }
    public void notifyAllObs(){
        for (Observer obs :list){
            obs.update();
        }
    }

}
