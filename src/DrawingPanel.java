import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {

    private List<CustomPoint> points = new ArrayList<>();

    // attributes
    Color backgroundColor = new Color(10,10,10);
    Color foregroundColor = new Color(80, 255, 80);
    public boolean isClear = false;

    // game stuff
    int FPS = 60;
    double dz = 0;

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
            Rectangle2D.Double rect = new Rectangle2D.Double(p.x, p.y, p.size, p.size);

            g2d.fill(rect);
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

    public void drawPoint(double x, double y) {
        int size = 10;

        CustomPoint newPoint = new CustomPoint(x, y, size);
        newPoint.toScreenCord();

        System.out.println("Lol i got" + newPoint.x + newPoint.y);

        points.add(newPoint);
        repaint();
    }

    // Inside DrawingPanel.java

    public CustomPoint project(double x, double y, double z) {
        // 1. Perspective Divide
        double px = x / z;
        double py = y / z;

        double scale = 400.0;
        px *= scale;
        py *= scale;

        // 3. Center it (Shift 0,0 from top-left to middle of window)
        px += (getWidth() / 2.0);
        py += (getHeight() / 2.0);

        return new CustomPoint(px, py, 10);
    }

    public void updateFrame(double[][] vertices) {
        double dt = 1.0 / FPS;
        this.dz += 2.0 * dt;


        if (dz > 20) dz = 0.000001;

        this.points.clear();


        for (int row = 0; row < vertices.length; row++) {
            points.add(this.project(vertices[row][0], vertices[row][1], vertices[row][2]+dz));

        }

        repaint();
    }
}
