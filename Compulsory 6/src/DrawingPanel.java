import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.Graphics;
import java.util.Random;
import java.util.ArrayList;

class DrawingPanel extends JPanel {
    private List<Point> dots = new ArrayList<>();
    private Random random = new Random();

    public void generateDots(int numDots) {
        dots.clear();
        int width = getWidth(), height = getHeight();
        for (int i = 0; i < numDots; i++) {
            dots.add(new Point(random.nextInt(width), random.nextInt(height)));
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        for (Point dot : dots) {
            g.fillOval(dot.x - 5, dot.y - 5, 10, 10);
        }
    }
}