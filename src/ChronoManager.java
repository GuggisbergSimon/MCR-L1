import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ChronoManager extends JFrame {
    private abstract static class ClosingWindowListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
        }

        @Override
        public void windowClosed(WindowEvent e) {
        }

        @Override
        public void windowIconified(WindowEvent e) {
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
        }

        @Override
        public void windowActivated(WindowEvent e) {
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
        }
    }

    ArrayList<Chrono> chronos;

    private record Button(
            String text,
            FunctionID action,
            boolean isControl) {
    }

    @FunctionalInterface
    private interface FunctionID {
        void run(int id);
    }

    private final Button[] buttons = {
            new Button("démarrer", this::start, true),
            new Button("arrêter", this::stop, true),
            new Button("réinitialiser", this::reset, true),
            new Button("cadran romain", this::newWatchRoman, false),
            new Button("cadran arabe", this::newWatchArabian, false),
            new Button("cadran numérique", this::newWatchDigital, false),
    };

    public ChronoManager(int nbChrono) {
        super("Panneau de contrôle");
        setLayout(new GridLayout(nbChrono + 1, 1));
        chronos = new ArrayList<Chrono>(nbChrono);
        for (int i = 0; i < nbChrono; i++) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

            chronos.add(new Chrono(i));
            // label
            JLabel label = new JLabel("Chrono #" + i);
            panel.add(label);

            // buttons
            for (int j = 0; j < buttons.length; j++) {
                JButton button = new JButton(buttons[j].text);
                final int indexI = i;
                final int indexJ = j;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        buttons[indexJ].action.run(indexI);
                    }
                });
                panel.add(button);
            }
            add(panel);
        }

        // all Chronos buttons
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        // label
        JLabel label = new JLabel("Tous les chronos");
        panel.add(label);

        // buttons
        for (int i = 0, j = 0; i < buttons.length; i++) {
            if (buttons[i].isControl) {
                continue;
            }

            JButton button = new JButton(buttons[i].text);
            final int index = j++;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final WatchManager watchManager = new WatchManager(WatchType.values()[index], chronos);

                    watchManager.addWindowListener(new ClosingWindowListener() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            for (Chrono chrono : ChronoManager.this.chronos) {
                                int id = chrono.getId();
                                for (Watch watch : watchManager.watches) {
                                    if (watch.getId() == id) {
                                        chrono.removeObserver(watch);
                                    }
                                }
                            }
                        }
                    });
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
        chronos.get(id).start();
    }

    private void stop(int id) {
        chronos.get(id).stop();
    }

    private void reset(int id) {
        chronos.get(id).start();
    }

    private void newWatchRoman(int id) {
        newWatch(id, WatchType.Roman);
    }

    private void newWatchArabian(int id) {
        newWatch(id, WatchType.Arabian);
    }

    private void newWatchDigital(int id) {
        newWatch(id, WatchType.Digital);
    }

    private void newWatch(int id, WatchType type) {
        final WatchManager watchManager = new WatchManager(type, chronos.get(id));

        watchManager.addWindowListener(new ClosingWindowListener() {
            @Override
            public void windowClosing(WindowEvent e) {
                for (Chrono chrono : ChronoManager.this.chronos) {
                    int id = chrono.getId();
                    for (Watch watch : watchManager.watches) {
                        if (watch.getId() == id) {
                            chrono.removeObserver(watch);
                        }
                    }
                }
            }
        });
    }

    public ArrayList<Chrono> getChronos() {
        return chronos;
    }
}
