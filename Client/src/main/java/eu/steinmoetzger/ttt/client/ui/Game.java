package eu.steinmoetzger.ttt.client.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Game {

    final String title = "Tic-tac-toe";
    final int width = 1000;
    final int height = 700;

    private JFrame frame;
    private GamePanel panel;

    public Game() {
        this.panel = new GamePanel();

        this.frame = new JFrame(title);
        this.frame.setSize(new Dimension(width, height));
        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // We don't want the program to just exit,
                                                                         // as we need to close the client socket first.
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.add(panel);

        setUpListeners();
        gameLoop();

        this.frame.setVisible(true);
    }

    void setUpListeners() {
        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panel.close();
            }
        });
    }

    void gameLoop() {
        new Thread() {

            @Override
            public void start() {

                // Main game loop
                while (true) {
                    panel.repaint();
                }

            }

        }.start();
    }

}
