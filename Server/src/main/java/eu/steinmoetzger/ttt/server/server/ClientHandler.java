package eu.steinmoetzger.ttt.server.server;

import java.net.Socket;

public class ClientHandler extends Thread {

    private final Socket socket;
    private final int player;

    public ClientHandler(Socket socket, int player) {
        this.socket = socket;
        this.player = player;

        // starts the client handler thing
        this.start();
    }

    @Override
    public void run() {

    }
}
