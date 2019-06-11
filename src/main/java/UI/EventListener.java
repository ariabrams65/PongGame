package UI;

import GameLogic.Game;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventListener implements ActionListener {

    private Game game;
    private Component c;

    public EventListener(Game game, Component c) {
        this.game = game;
        this.c = c;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        game.tick();

        c.repaint();
    }
}
