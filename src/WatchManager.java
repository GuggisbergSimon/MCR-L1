import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class WatchManager extends JFrame {
    private static final int size = 200;
    private final LinkedList<Watch> watches = new LinkedList<>();

    private void setup() {
        // Sets size of the panels and add them to the frame
        for (JPanel panel : watches) {
            panel.setPreferredSize(new Dimension(size, size));
            add(panel);
        }

        // Sets flow layout
        setLayout(new FlowLayout(FlowLayout.LEADING));
        setLocationRelativeTo(null);
        setSize(watches.size() * size, size);
        pack();
        setVisible(true);

        // Resize event
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int width = getWidth();
                int maxColumns = width < watches.size() * size ?
                        Math.max(width / size, 1) : watches.size();
                setLayout(new GridLayout(0, maxColumns));
            }
        });
    }

    private void addPanel(WatchType type, final Chrono chrono) {
        int id = chrono.getId();
        int timeSeconds = chrono.getTimeElapsed();
        Watch watch;
        switch (type) {
            case Roman, Arabian ->
                    watch = new AnalogWatch(id, timeSeconds, type, size);
            // Digital
            default -> watch = new DigitalWatch(id, timeSeconds);
        }

        watches.add(watch);
        chrono.addObserver(watch);

        // toggle button
        watch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chrono.toggle();
            }
        });
    }

    /**
     * Getter for the list of watches
     *
     * @return the list of watches
     */
    public LinkedList<Watch> getWatches() {
        return watches;
    }

    /**
     * Create a WatchManager matching all chronos
     *
     * @param type    the type of the watches
     * @param chronos the chronos to be linked to the watches
     */
    public WatchManager(WatchType type, ArrayList<Chrono> chronos) {
        super();
        for (Chrono chrono : chronos) {
            addPanel(type, chrono);
        }

        setup();
    }

    /**
     * Create a WatchManager with a single watch
     *
     * @param type   the type of the watch
     * @param chrono the chrono to be linked to the watch
     */
    public WatchManager(WatchType type, Chrono chrono) {
        super();
        addPanel(type, chrono);
        setup();
    }
}
