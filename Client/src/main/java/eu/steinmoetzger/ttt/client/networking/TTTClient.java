package eu.steinmoetzger.ttt.client.networking;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.DoubleToIntFunction;

public class TTTClient extends Thread {

    private Socket socket;
    private Stack<String> sendStack;

    public TTTClient(String hostname, int port) {
        this.sendStack = new Stack<>();
        try {
            this.socket = new Socket(hostname, port);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
             outputStream = socket.getOutputStream();
             inputStream = socket.getInputStream();
             new InputThread(inputStream);
            while(true) {
                try {
                    String s = this.getSendStack().pop();
                    if(s == null) continue;
                    outputStream.write(s.getBytes(StandardCharsets.UTF_8));
                    outputStream.flush();
                } catch (EmptyStackException e) {
                    continue;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public Socket getSocket() {
        return socket;
    }

    public Stack<String> getSendStack() {
        return sendStack;
    }

    static class InputThread extends Thread {
        InputStream inputStream;

        public InputThread(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));
            while(true) {
                try {
                    if (!reader.ready()) break;
                    System.out.println("read");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
