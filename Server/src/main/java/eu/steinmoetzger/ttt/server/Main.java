package eu.steinmoetzger.ttt.server;

import eu.steinmoetzger.ttt.server.server.TTTServer;

public class Main {

    public static Game gameInstance;
    public static void main(String[] args) {
        System.out.println("Tic-Tac-Toe (Server) made by (Piotr Krysztof Wyrwas, Michael T. Steinmoetzger)");
        gameInstance = new Game();
        gameInstance.setServer(new TTTServer());
    }
}
