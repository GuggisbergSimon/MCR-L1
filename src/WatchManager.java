import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class WatchManager extends JFrame {
    private static final int size = 200;
    LinkedList<JPanel> panels = new LinkedList<>();

    public WatchManager(WindowType type, int id) {
        super();
        setLayout(new GridLayout(1, 0));

        switch (type) {
            case Roman, Arabian ->
                    panels.add(new AnalogWatch(id, type, size));
            case Digital -> panels.add(new DigitalWatch(id));
            case All -> {
                panels.add(new AnalogWatch(id, WindowType.Roman, size));
                panels.add(new AnalogWatch(id, WindowType.Arabian, size));
                panels.add(new DigitalWatch(id));
            }
        }

        // Sets size of the panels and add them to the frame
        for (JPanel panel : panels) {
            panel.setPreferredSize(new Dimension(size, size));
            add(panel);
        }

        setLocationRelativeTo(null);
        setSize(panels.size() * size, size);
        pack();
        setVisible(true);
    }
}
