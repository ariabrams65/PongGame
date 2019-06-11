
package Main;

import UI.UserInterface;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface(1000, 700);
        SwingUtilities.invokeLater(ui);
    }
    
}
