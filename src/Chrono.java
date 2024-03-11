import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Chrono extends Subject {
    private final int id;
    private final Timer timer;
    private boolean isRunning;
    private int timeElapsed;
    private final ArrayList<Observer> observers;

    public Chrono(int id) {
        this.id = id;
        isRunning = false;
        timeElapsed = 0;
        observers = new ArrayList<>();

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++timeElapsed;
                notifyObserver();
            }
        });

    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(timeElapsed);
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
        if (isRunning) {
            stop();
        } else {
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
