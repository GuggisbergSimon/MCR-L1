import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Chrono extends Subject {

    int id;
    Timer timer;
    boolean isRunning;
    int timeElapsed;
    ArrayList<Observer> observers;

    public Chrono(int id) {
        this.id = id;
        isRunning = false;
        timeElapsed = 0;
        observers = new ArrayList<>();

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Time is running");
                ++timeElapsed;
                notifyObserver();
            }
        });

    }
    @Override
    public void notifyObserver() {
        for(Observer observer : observers) {
            observer.update(timeElapsed);
            System.out.println("Some got notifed !");
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
        timer.stop();
        isRunning = false;
        timeElapsed = 0;
        notifyObserver();
    }

    public int getTimeElapsed() {
        return timeElapsed;
    }

    public int getId() {
        return id;
    }
}
