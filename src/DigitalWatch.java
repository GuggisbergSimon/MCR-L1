public class DigitalWatch extends Watch {
    private static final String format = " : %02dh %02dm %02ds";

    /**
     * Watch constructor
     *
     * @param id          the id of the Watch
     * @param timeSeconds the number of seconds to be initialized with
     */
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
