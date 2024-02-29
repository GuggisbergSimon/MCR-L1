public abstract class Subject {
    public abstract void notifyObserver();

    public abstract void addObserver(Observer observer);

    public abstract void removeObserver(Observer observer);
}
