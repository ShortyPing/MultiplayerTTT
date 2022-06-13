package eu.steinmoetzger.ttt.server.server;

import eu.steinmoetzger.ttt.server.Game;
import eu.steinmoetzger.ttt.server.Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TTTServer {

    private ServerSocket socket;
    private final Game game;

    public TTTServer() {
        this.game = Main.gameInstance;
        try {
            ServerSocket socket = new ServerSocket(12345);
            System.out.println("Opened Server (" + socket + ")");
            while(true) {
                Socket client = socket.accept();
                if(this.game.getPlayer1() != null && this.game.getPlayer1().isClosed()) {
                    this.game.setPlayer1(client);
                    new ClientHandler(client, 2);
                    System.out.println("Player-1 connected (" + socket + ")");
                    continue;
                }
                if(this.game.getPlayer2() != null && this.game.getPlayer2().isClosed()) {
                    this.game.setPlayer2(client);
                    new ClientHandler(client, 2);
                    System.out.println("Player-2 connected (" + socket + ")");
                    continue;
                }
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Failed to start server on port 12345");
            throw new RuntimeException(e);
        }
    }
}
