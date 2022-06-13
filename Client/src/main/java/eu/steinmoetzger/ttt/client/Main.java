package eu.steinmoetzger.ttt.client;

import eu.steinmoetzger.ttt.client.networking.TTTClient;

public class Main {

    public static void main(String[] args) {
        new TTTClient("localhost", 12345);
    }

}
