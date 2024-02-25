import java.awt.*;

public class AnalogWatch extends Watch {
    private static final String arabianFileName = "cadran_chiffres_arabes.jpg";
    private static final String romanFileName = "cadran_chiffres_romains.jpg";
    private static final int size = 200;
    private Image image;
    private int hours;
    private int minutes;
    private int seconds;

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

        Graphics2D g2d = (Graphics2D) g;
        drawPointer(g2d, hours, 12,size / 4, 4);
        drawPointer(g2d, minutes, 60, size / 4 + size / 8, 2);
        drawPointer(g2d, seconds, 60, size / 2, 1);
    }

    @Override
    public void update() {
        //TODO send proper values
        hours = 3;
        minutes = 55;
        seconds = 25;
        label.setText(this.toString());
        repaint();
    }

    private void drawPointer(Graphics2D g2d, int numberPointed, int maxUnit, int lengthPointer, int boldness) {
        double angle = Math.toRadians((numberPointed % maxUnit) * ((double) 360 / maxUnit) - 90);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int xEnd = xCenter + (int) (lengthPointer * Math.cos(angle));
        int yEnd = yCenter + (int) (lengthPointer * Math.sin(angle));
        g2d.setStroke(new BasicStroke(boldness));
        g2d.drawLine(xCenter, yCenter, xEnd, yEnd);
    }
}
