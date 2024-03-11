import java.awt.*;

public class AnalogWatch extends Watch {
    private static final String arabianFileName = "cadran_chiffres_arabes.jpg";
    private static final String romanFileName = "cadran_chiffres_romains.jpg";
    private final int size;
    private Image image;

    /**
     * AnalogWatch constructor
     *
     * @param id          the id of the Watch
     * @param timeSeconds the number of seconds to be initialized with
     * @param type        the type of the Watch
     * @param size        the size of the Watch (a watch is assumed to be a circle so length and height are the same)
     */
    public AnalogWatch(int id, int timeSeconds, WatchType type, int size) {
        super(id, timeSeconds);
        String imageName = "";
        switch (type) {
            case Arabian -> imageName = arabianFileName;
            case Roman -> imageName = romanFileName;
        }

        // Loads image and scale it
        this.size = size;
        image = Toolkit.getDefaultToolkit().getImage(imageName);
        image = image.getScaledInstance(size, size, Image.SCALE_SMOOTH);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - size) / 2;
        int y = (getHeight() - size) / 2;
        g.drawImage(image, x, y, size, size, this);

        Graphics2D g2d = (Graphics2D) g;
        drawPointer(g2d, hours, 12, size / 4, 3, Color.black);
        drawPointer(g2d, minutes, 60, size / 4 + size / 16, 2, Color.blue);
        drawPointer(g2d, seconds, 60, size / 2, 1, Color.red);
    }

    @Override
    public void update(int timeSeconds) {
        super.update(timeSeconds);
        label.setText(this.toString());
        repaint();
    }

    /**
     * Draws a pointer of the watch with a line
     *
     * @param g2d           the Graphics2D object to be used to draw
     * @param numberPointed the number the pointer is pointing at
     * @param maxUnit       the maximum number of unit allowed for the pointer (usual clock go to 12 for hours, 60 for minutes and seconds)
     * @param lengthPointer the length of the line drawn
     * @param boldness      the thickness of the line drawn
     * @param c             the color of the line drawn
     */
    private void drawPointer(Graphics2D g2d, int numberPointed, int maxUnit, int lengthPointer, int boldness, Color c) {
        double angle = Math.toRadians((numberPointed % maxUnit) * ((double) 360 / maxUnit) - 90);
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int xEnd = xCenter + (int) (lengthPointer * Math.cos(angle));
        int yEnd = yCenter + (int) (lengthPointer * Math.sin(angle));
        g2d.setStroke(new BasicStroke(boldness));
        g2d.setColor(c);
        g2d.drawLine(xCenter, yCenter, xEnd, yEnd);
    }
}
