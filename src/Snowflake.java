import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Point;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snowflake extends JPanel {
    // Settings
    private boolean drawOnScreen = true;
    private boolean writeToImageFile = false;
    private static final String imageFileName = "fractal.bmp";
    private final int WIDTH = 1600;
    private final int HEIGHT = 900;

    // Other variables
    private JFrame frame;
    private BufferedImage image;

    public Snowflake(int depth) throws IOException {
        // CREATE A BLANK IMAGE
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // SET BACKGROUND COLOR
        g2.setColor(Color.black);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        // SET INITIAL DRAWING COLOR
        g2.setColor(Color.WHITE);

        // DEFINE THE STARTING POINTS
        Point a = new Point(400, 250);
        Point b = new Point(WIDTH - 400, 250);
        Point c = new Point(WIDTH/2, HEIGHT - 15);

        //DRAW THE SNOWFLAKE
        drawSnowflake(g2, a, b, depth);
        drawSnowflake(g2, b, c, depth);
        drawSnowflake(g2, c, a, depth);

        // WRITES THE FRACTAL TO AN IMAGE FILE
        if (writeToImageFile) {
            ImageIO.write(image, "BMP", new File(imageFileName));
            g2.dispose();
        }

        // SHOWS FRACTAL ON SCREEN
        if (drawOnScreen) {
            frame = new JFrame("Koch Snowflake");
            // Set to close program when frame is closed
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // Set panel size
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            // Place panel on the frame centered
            frame.add(this);
            frame.pack();
            frame.setLocationRelativeTo(null);
            // Show the frame
            frame.setVisible(true);
        }

    }

    // POST: Draws the fractal on the screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Convert to a Graphics2D object bc it gives us way more tools
        Graphics2D g2 = (Graphics2D) g;
        // Turn on anti-aliasing (smoothing)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Display the image
        g2.drawImage(image, 0, 0, WIDTH, HEIGHT, frame);

    }

    // POST: Computes and returns the distance between p1 and p2
    public static double distance(Point p1, Point p2) {
        double xDiff = p2.x - p1.x;
        double yDiff = p2.y - p1.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    private void drawSnowflake(Graphics2D g2, Point p1, Point p5, int depth) {

        if (depth == 0) {
            // Draw a line connecting p1 and p5 using g2.drawLine

            //TODO
       
            return;
        } else {
            /*  Compute p2, p3, p4 to create a triangle at the middle of the segment:
             *              p3
             *             /  \
             *            /    \       
             *  p1 ----- p2     p4 ----- p5
            */
            double dx = (p5.x - p1.x);
            double dy = (p5.y - p1.y);

            Point p2 = new Point((int) (p1.x + dx / 3.0), (int) (p1.y + dy / 3.0));
            Point p4 = new Point((int) (p1.x + 2 * dx / 3.0), (int) (p1.y + 2 * dy / 3.0));

            Point p3 = new Point((int) (0.5 * (p1.x + p5.x) + Math.sqrt(3) * (p5.y - p1.y) / 6),
                    (int) (0.5 * (p1.y + p5.y) + Math.sqrt(3) * (p1.x - p5.x) / 6));

            // Recursively call drawSnowflake for each pair of points

            //TODO

        }
    }

}
