import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

    private List<CustomPoint> points = new ArrayList<>();

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

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for (CustomPoint p : points) {
            g2d.setColor(p.color);
            g2d.fillRect(p.x, p.y, p.size, p.size);
        }

    }

    public void drawShapes(Graphics2D g2d) {
        g2d.setColor(foregroundColor);
        g2d.fillRect(50, 50, 100, 100);
    }

    public void clearScreen() {
//        this.isClear = true;
        points.clear();
        repaint();
    }

    public void drawPoint(int x, int y) {
        int size = 10;
        CustomPoint newPoint = new CustomPoint(x, y, size);
        newPoint.toScreenCoord();

        System.out.println("Lol i got" + newPoint.x + newPoint.y);

        points.add(newPoint);
        repaint();
    }




}
