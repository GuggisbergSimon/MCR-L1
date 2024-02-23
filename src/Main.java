public class Main {
    public static void main(String[] args) {
        //TODO retrieve argument and convert to int for initializing chronoManager
        int nbChrono = 3;
        ChronoManager chronoManager = new ChronoManager(nbChrono);

        // Debug purposes
        WatchManager watchManagerAll = new WatchManager(nbChrono, WindowType.Arabian);
        WatchManager watchManagerAlone = new WatchManager(WindowType.Digital, 2);
    }
}