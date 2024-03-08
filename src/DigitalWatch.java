public class DigitalWatch extends Watch {
    private static final String format = " : %02dh %02dm %02ds";

    public DigitalWatch(int id, int timeSeconds) {
        super(id, timeSeconds);
    }

    @Override
    public void update(int timeSeconds) {
        super.update(timeSeconds);
        label.setText(this + String.format(format, hours, minutes, seconds));
        repaint();
    }
}
