package eu.steinmoetzger.ttt.server;

public class Main {

    public static Game gameInstance;
    public static void main(String[] args) {
        System.out.println("Tic-Tac-Toe (Server) made by (Piotr Krysztof Wyrwas, Michael T. Steinmoetzger)");
        gameInstance = new Game();
    }
}
