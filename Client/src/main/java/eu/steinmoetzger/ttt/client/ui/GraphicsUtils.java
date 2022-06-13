package eu.steinmoetzger.ttt.client.ui;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GraphicsUtils {

    public static void registerFont(File file) {
        if (!file.exists()) {
            System.out.println("Error: Critical resource not available '" + file.getPath() + "'");
            return;
        }
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            genv.registerFont(Font.createFont(Font.TRUETYPE_FONT, file));
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
