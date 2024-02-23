import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedList;

public class WatchManager extends JFrame {
    private static final int size = 200;
    LinkedList<JPanel> panels = new LinkedList<>();

    public WatchManager(WindowType type, int id) {
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
        for (int i = 0; i < panels.size(); i++) {
            panels.get(i).setBounds(i * size, 0, size, size);
            add(panels.get(i));
        }

        // Resize window listener
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                //TODO readjust panels position when window dimension changes
                if (e.getComponent().getWidth() < panels.size() * size) {

                }
            }
        });

        setLayout(new GridLayout());
        setLocationRelativeTo(null);
        setSize(panels.size() * size, size);
        setLayout(null);
        setVisible(true);
    }
}
