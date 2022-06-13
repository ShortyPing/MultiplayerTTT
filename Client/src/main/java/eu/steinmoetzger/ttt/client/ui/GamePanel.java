package eu.steinmoetzger.ttt.client.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Stack;

public class GamePanel extends JPanel {

    private Stack<InputEvent> evts;

    public GamePanel() {
        super();
        this.evts = new Stack<InputEvent>();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(BetterColors.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
    }

    public void pushEvent(InputEvent evt) {
        this.evts.push(evt);
    }

    public void close() {
        // TODO Close Client Socket
        System.out.println("Exiting ...");
    }

}
