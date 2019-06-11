
package UI;

import GameLogic.Game;
import Pieces.Ball;
import Pieces.Paddle;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {
    
    private Game game;
    private EventListener el;
    private DrawingBoard board;
    
    public UserInterface(int width, int height) {
        this.game = new Game(width, height);
        this.board = new DrawingBoard(game);
        EventListener el = new EventListener(game, board);
        Timer t = new Timer(20, el);
        this.game.addTimer(t);
        t.start();
    }

    private JFrame frame;
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(game.getWidth(), game.getHeight()));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void createComponents(Container container) { 
        container.add(board);
        frame.addKeyListener(new KeyboardListener(game));
    }
    
    public JFrame getFrame() {
        return this.frame;
    }
    
}
