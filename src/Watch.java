import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Watch extends Observer {
    protected int id;
    protected JLabel label;


    public Watch(int id) {
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
        update();
    }

    @Override
    public String toString() {
        return String.format("Chrono #%d", id);
    }
}
