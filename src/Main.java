public class Main {
    public static void main(String[] args) {
        //TODO retrieve argument and convert to int for initializing chronoManager
        ChronoManager chronoManager = new ChronoManager(3);

        // Debug purposes
        WatchManager watchManagerAll = new WatchManager(WindowType.All, 1);
        WatchManager watchManagerAlone = new WatchManager(WindowType.Arabian, 2);
    }
}