import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {

    // attributes
    Color backgroundColor = new Color(10,10,10);
    Color foregroundColor = new Color(80, 255, 80);
    public boolean isClear = false;

    public DrawingPanel() {
        this.setBackground(backgroundColor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isClear) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            drawShapes(g2d);
        }

    }

    public void drawShapes(Graphics2D g2d) {
        g2d.setColor(foregroundColor);
        g2d.fillRect(50, 50, 100, 100);
    }

    public void clearScreen() {
        this.isClear = true;
        repaint();
    }

    public void point(int x, int y) {
        if (!this.isClear) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.fillRect(x, y, 100, 100);

        }
    }
}
