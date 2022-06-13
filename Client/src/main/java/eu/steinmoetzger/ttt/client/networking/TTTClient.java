package eu.steinmoetzger.ttt.client.networking;

import java.io.IOException;
import java.net.Socket;

public class TTTClient extends Thread {

    private Socket socket;

    public TTTClient(String hostname, int port) {
        try {
            this.socket = new Socket(hostname, port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        // TODO Stuff
    }

    public Socket getSocket() {
        return socket;
    }
}
