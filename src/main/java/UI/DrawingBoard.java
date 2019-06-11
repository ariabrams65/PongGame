package UI;

import GameLogic.Game;
import GameLogic.ScoreManager;
import Pieces.Paddle;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    private Game game;

    public DrawingBoard(Game game) {
        setBackground(Color.black);
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.white);

        game.getBall().draw(g);

        for (Paddle p : game.getPaddles()) {
            p.draw(g);
        }
        ScoreManager sm = game.getScoreManager();

        g.setColor(Color.ORANGE);
        drawCenteredString(g, new Font("Prime", Font.BOLD, 70), sm.getLeft() + "-" + sm.getRight());
    }

    public void drawCenteredString(Graphics g, Font font, String text) {
        ScoreManager sm = game.getScoreManager();

        FontMetrics metrics = g.getFontMetrics(font);

        int x = (game.getWidth() - metrics.stringWidth(sm.getLeft() + "-" + sm.getRight())) / 2;

        g.setFont(font);

        g.drawString(text, x, 100);
    }
}
