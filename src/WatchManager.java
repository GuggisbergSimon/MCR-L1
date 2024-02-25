import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedList;

public class WatchManager extends JFrame {
    private static final int size = 200;
    LinkedList<JPanel> panels = new LinkedList<>();

    private void setup() {
        // Sets size of the panels and add them to the frame
        for (JPanel panel : panels) {
            panel.setPreferredSize(new Dimension(size, size));
            add(panel);
        }

        setLayout(new FlowLayout(FlowLayout.LEADING));
        setLocationRelativeTo(null);
        setSize(panels.size() * size, size);
        pack();
        setVisible(true);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int maxColumns = width / size;
                // TODO improve resize
                setLayout(new GridLayout(0, Math.max(maxColumns, 1)));
            }
        });
    }

    private void addPanel(WindowType type, int id) {
        switch (type) {
            case Roman, Arabian ->
                    panels.add(new AnalogWatch(id, type, size));
            case Digital -> panels.add(new DigitalWatch(id));
        }
    }

    public WatchManager(int nbWatches, WindowType type) {
        super();
        for (int i = 1; i <= nbWatches; i++) {
            addPanel(type, i);
        }

        setup();
    }

    public WatchManager(WindowType type, int id) {
        super();
        addPanel(type, id);
        setup();
    }
}
