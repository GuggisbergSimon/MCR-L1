import javax.swing.*;
import java.awt.*;

public abstract class Watch extends Observer {
    protected int id;
    protected int hours;
    protected int minutes;
    protected int seconds;
    protected JLabel label;

    /**
     * Watch constructor
     *
     * @param id          the id of the Watch
     * @param timeSeconds the number of seconds to be initialized with
     */
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

    /**
     * Updates the watch with a new time
     *
     * @param timeSeconds the time in seconds to update the Watch with
     */
    @Override
    public void update(int timeSeconds) {
        hours = timeSeconds / 3600;
        timeSeconds -= hours * 3600;
        minutes = timeSeconds / 60;
        timeSeconds -= minutes * 60;
        seconds = timeSeconds;
    }

    /**
     * Watch as a String
     *
     * @return the Watch as a String
     */
    @Override
    public String toString() {
        return String.format("Chrono #%d", id);
    }

    /**
     * Getter to the Watch id
     *
     * @return the id of the Watch
     */
    public int getId() {
        return id;
    }
}
