package eu.steinmoetzger.ttt.client.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class Game {

    public static final String TITLE = "Tic-tac-toe";
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private JFrame frame;
    private GamePanel panel;

    public Game() {
        GraphicsUtils.registerFont(new File("assets/MeriendaOne.ttf"));

        this.panel = new GamePanel();

        this.frame = new JFrame(TITLE);
        this.frame.setSize(WIDTH, HEIGHT);
        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // We don't want the program to just exit,
                                                                         // as we need to close the client socket first.
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.add(panel);

        setUpListeners();
        gameLoop();

        this.frame.setVisible(true);
    }

    private void setUpListeners() {
        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panel.close();
                System.exit(0);
            }
        });
    }

    private void gameLoop() {
        new Thread() {

            @Override
            public void run() {

                // Main game loop
                while (true) {
                    panel.repaint();
                }

            }

        }.start();
    }

}
