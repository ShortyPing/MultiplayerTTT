package eu.steinmoetzger.ttt.client.networking;

public class TTTResponse {

    private int pos;
    private char c;

    public TTTResponse(int pos, char c) {
        this.pos = pos;
        this.c = c;
    }

    public int getPos() {
        return pos;
    }

    public char getC() {
        return c;
    }
}
