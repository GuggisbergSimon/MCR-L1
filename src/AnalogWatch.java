import java.awt.*;

public class AnalogWatch extends Watch {
    private static final int sizeX = 200;
    private static final int sizeY = 200;
    private static final String arabianFileName = "cadran_chiffres_arabes.jpg";
    private static final String romanFileName = "cadran_chiffres_romains.jpg";
    private Image image;

    public AnalogWatch(WindowType type) {
        String imageName = "";
        switch (type) {
            case Arabian -> imageName = arabianFileName;
            case Roman -> imageName = romanFileName;
        }

        // Loads image and scale it
        image = Toolkit.getDefaultToolkit().getImage(imageName);
        image = image.getScaledInstance(sizeX, sizeY, Image.SCALE_SMOOTH);
    }

    public void paintComponent (Graphics g) {
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void update() {

    }
}
