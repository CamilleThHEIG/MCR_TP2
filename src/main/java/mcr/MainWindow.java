package mcr;

public class MainWindow {
    private static MainWindow instance = null;
    private MainWindow(){
        // constructeur de la classe main
    }

    public static MainWindow getInstance() {
        if (instance == null){
            instance = new MainWindow();
        }
        return instance;
    }
}
