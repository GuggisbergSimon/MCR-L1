import javax.swing.*;
import java.awt.*;

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
        for (int j = 0; j < buttonsWatches.length; j++) {
            JButton button = new JButton(buttonsWatches[j]);
            panel.add(button);
        }
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
