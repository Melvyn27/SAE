package SAE.exeption;

import SAE.graphics.error_interface.LoadErrorScreen;

public class LoadExeption extends Exception {
    public LoadExeption() {
        new LoadErrorScreen();
    }
    public LoadExeption(String line) {
        new LoadErrorScreen(line);
    }
    public LoadExeption(String line, String car) {
        new LoadErrorScreen(line,car);
    }
}
