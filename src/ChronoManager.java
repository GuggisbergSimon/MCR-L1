import javax.swing.*;

public class ChronoManager extends JFrame {
    private static final String[] buttonsLines = {"démarrer", "arrêter", "réinitialiser", "cadran romain", "cadran arabe", "numérique"};
    private static final String[] buttonsWatches = {"cadran romain", "cadran arabe", "numérique"};

    public ChronoManager(int nbChrono) {
        super("Panneau de contrôle");
        int x = 10;
        int width = 120;
        int height = 25;
        // setSize sets the size for the menu bar as well so needs to add a small margin to have a pretty result
        //TODO retrieve that margin more precisely and automatically
        setSize((buttonsLines.length + 1) * width + 50, (nbChrono + 1) * height + 50);
        for (int i = 0; i < nbChrono; i++) {
            int y = i * height;
            // label
            JLabel label = new JLabel("Chrono #" + i, JLabel.LEFT);
            label.setBounds(x, y, width, height);
            add(label);

            // buttons
            for (int j = 0; j < buttonsLines.length; j++) {
                JButton button = new JButton(buttonsLines[j]);
                button.setBounds(x + ((j + 1) * width), y, width, height);
                add(button);
            }
        }

        // all Chrono buttons
        int y = nbChrono * height;
        int offset = 1 + buttonsLines.length - buttonsWatches.length;
        for (int j = 0; j < buttonsWatches.length; j++) {
            JButton button = new JButton(buttonsWatches[j]);
            button.setBounds(x + ((j + offset) * width), y, width, height);
            add(button);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
