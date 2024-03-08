import javax.swing.*;
import java.awt.*;

public abstract class Watch extends Observer {

    protected int id;
    protected int hours;
    protected int minutes;
    protected int seconds;
    protected JLabel label;


    public Watch(int id, int timeSeconds) {
        super();
        this.id = id;

        // chrono label
        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        update(timeSeconds);
    }

    @Override
    public void update(int timeSeconds) {
        hours = timeSeconds / 3600;
        timeSeconds -= hours * 3600;
        minutes = timeSeconds / 60;
        timeSeconds -= minutes * 60;
        seconds = timeSeconds;
    }

    @Override
    public String toString() {
        return String.format("Chrono #%d", id);
    }

    public int getId() {
        return id;
    }
}
