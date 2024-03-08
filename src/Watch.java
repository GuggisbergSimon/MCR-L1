import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Watch extends Observer {
    private class ToggleListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            //TODO send toggle at ChronoManager

            System.out.println(id + " touched");
        }
    }

    protected int id;
    protected int hours;
    protected int minutes;
    protected int seconds;
    protected JLabel label;


    public Watch(int id, int timeSeconds) {
        super();
        this.id = id;

        // toggle button
        this.addMouseListener(new ToggleListener());

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
