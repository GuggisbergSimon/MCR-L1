import java.awt.*;

public class AnalogWatch extends Watch {
    private static final String arabianFileName = "cadran_chiffres_arabes.jpg";
    private static final String romanFileName = "cadran_chiffres_romains.jpg";
    private static final int size = 200;
    private Image image;

    public AnalogWatch(int id, WindowType type, int size) {
        super(id);
        String imageName = "";
        switch (type) {
            case Arabian -> imageName = arabianFileName;
            case Roman -> imageName = romanFileName;
        }

        // Loads image and scale it
        image = Toolkit.getDefaultToolkit().getImage(imageName);
        image = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;
        g.drawImage(image, x, y, size, size, this);
    }

    @Override
    public void update() {

    }
}
