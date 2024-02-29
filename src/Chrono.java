import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Chrono extends Subject {

    Timer timer;
    boolean isRunning;

    ArrayList<Observer> observers;

    public Chrono() {

        isRunning = false;
        observers = new ArrayList<>();
        timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyObserver();
            }
        });

    }
    @Override
    public void notifyObserver() {
        for(Observer observer : observers) {
            observer.notify();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void toggle() {
        if(isRunning) {
            stop();
        } else  {
            start();
        }
    }
    public void stop() {
        timer.stop();
        isRunning = false;
    }
    public void start() {
        timer.start();
        isRunning = true;
    }
    public void reset() {
        timer.restart();
    }
}
