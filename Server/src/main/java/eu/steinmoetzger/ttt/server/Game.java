package eu.steinmoetzger.ttt.server;

import eu.steinmoetzger.ttt.server.server.TTTServer;

import java.net.Socket;

public class Game {

    private TTTServer server;
    private Socket player1;
    private Socket player2;

    public Game() {
        this.server = new TTTServer();
    }


    public Socket getPlayer1() {
        return player1;
    }

    public void setPlayer1(Socket player1) {
        this.player1 = player1;
    }

    public Socket getPlayer2() {
        return player2;
    }

    public void setPlayer2(Socket player2) {
        this.player2 = player2;
    }
}
