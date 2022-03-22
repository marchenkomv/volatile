package task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Toy toy = new Toy();
        Thread userThread = new Thread(null, toy::switchOn, "Пользователь");
        Thread toyThread = new Thread(null, toy::play, "Игрушка");
        userThread.start();
        toyThread.start();
        userThread.join();
        toyThread.interrupt();
    }
}
