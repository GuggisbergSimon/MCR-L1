import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Watch extends Observer {
    protected int id;
    protected int hours;
    protected int minutes;
    protected int seconds;
    protected JLabel label;


    public Watch(int id, int timeSeconds) {
        super();
        this.id = id;

        // toggle button
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO send toggle at ChronoManager
                System.out.println(id + " touched");
            }
        });
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setOpaque(false);
        add(button);

        // TODO fix button unclickable through label (and if label is printed before, then it doesn't appear)
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
}
