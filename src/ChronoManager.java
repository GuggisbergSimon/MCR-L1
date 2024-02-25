import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChronoManager extends JFrame {
    private static final String[] buttonsLines = {"démarrer", "arrêter", "réinitialiser", "cadran romain", "cadran arabe", "numérique"};
    private static final String[] buttonsWatches = {"cadran romain", "cadran arabe", "numérique"};

    public ChronoManager(int nbChrono) {
        super("Panneau de contrôle");
        setLayout(new GridLayout(nbChrono + 1, 1));

        for (int i = 0; i < nbChrono; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            // label
            JLabel label = new JLabel("Chrono #" + i);
            panel.add(label);

            // buttons
            for (int j = 0; j < buttonsLines.length; j++) {
                JButton button = new JButton(buttonsLines[j]);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //TODO call dedicated method
                    }
                });
                panel.add(button);
            }
            add(panel);
        }

        // all Chrono buttons
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // label
        JLabel label = new JLabel("Tous les chronos");
        panel.add(label);

        // buttons
        for (int i = 0; i < buttonsWatches.length; i++) {
            JButton button = new JButton(buttonsWatches[i]);
            final int index = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new WatchManager(nbChrono, WindowType.values()[index]);
                }
            });
            panel.add(button);
        }
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void start(int id) {
        System.out.println("Start " + id);
    }

    private void stop(int id) {
        System.out.println("Stop " + id);
    }

    private void reset(int id) {
        System.out.println("Reset " + id);
    }

    private void newWatch(int id, WindowType type) {
        JFrame frame = new WatchManager(type, id);
    }
}
