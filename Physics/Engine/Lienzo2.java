package Physics.Engine;


import java.awt.Graphics;
import javax.swing.JPanel;


public class Lienzo2 extends JPanel {

    private static final int RECT_WIDTH = 100, RECT_HEIGHT = 70;
    private static final int SPEED = 3; // Incremento en pixeles por teclazo
    private int rectX = 50, rectY = 50;

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(rectX, rectY, RECT_WIDTH, RECT_HEIGHT);
    }

    public void moveRight() {
        if(rectX >= getWidth() - RECT_WIDTH) return;
        rectX += SPEED;
        repaint();
    }

    public void moveLeft() {
        if(rectX <= 0) return;
        rectX -= SPEED;
        repaint();
    }

    public void moveUp() {
        if(rectY <= 0) return;
        rectY -= SPEED;
        repaint();
    }

    public void moveDown() {
        if(rectY >= getHeight() - RECT_HEIGHT) return;
        rectY += SPEED;
        repaint();
    }

    public void move(int x, int y) {
//		Centramos el rectángulo con respecto a (x, y)
        rectX = x - RECT_WIDTH  / 2;
        rectY = y - RECT_HEIGHT / 2;
        repaint();
    }
}
