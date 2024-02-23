import javax.swing.*;
import java.util.LinkedList;

public class WatchManager extends JFrame {
    LinkedList<JPanel> panels = new LinkedList<>();
    public WatchManager(WindowType type) {
        switch (type) {
            case Roman, Arabian -> panels.add(new AnalogWatch(type));
            case Digital -> panels.add(new DigitalWatch());
            case All -> {
                panels.add(new AnalogWatch(WindowType.Roman));
                panels.add(new AnalogWatch(WindowType.Arabian));
                panels.add(new DigitalWatch());
            }
        }
    }
}
