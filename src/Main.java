public class Main {
    public static void main(String[] args) {
        //Default value is 3
        int nbChrono = 3;
        if (args.length > 0) {
            try {
                nbChrono = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }

        ChronoManager chronoManager = new ChronoManager(nbChrono);
    }
}