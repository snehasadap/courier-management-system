package courier;

import javax.swing.SwingUtilities;
import courier.view.MainGUI;

public class App {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}
