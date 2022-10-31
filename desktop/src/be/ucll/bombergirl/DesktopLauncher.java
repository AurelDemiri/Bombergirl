package be.ucll.bombergirl;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setTitle("Bombergirl");

        int minWidth = 240;
        int minHeight = 208;
        config.setWindowSizeLimits(minWidth, minHeight, minWidth * 3, minHeight * 3);

        new Lwjgl3Application(new MyGame(), config);
    }
}
