public class DigitalWatch extends Watch {
    private static final String format = " : %02dh %02dm %02ds";

    public DigitalWatch(int id) {
        super(id);
    }

    @Override
    public void update() {
        //TODO send proper values
        int hours = 1;
        int minutes = 2;
        int seconds = 3;
        label.setText(this + String.format(format, hours, minutes, seconds));
    }
}
