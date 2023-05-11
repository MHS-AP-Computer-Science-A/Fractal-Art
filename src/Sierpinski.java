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

public class Sierpinski extends JPanel {
    // Settings
    private boolean drawOnScreen = true;
    private boolean writeToImageFile = false;
    private static final String imageFileName = "fractal.bmp";
    private final int WIDTH = 1600;
    private final int HEIGHT = 900;

    // Other variables
    private JFrame frame;
    private BufferedImage image;

    public Sierpinski(int depth) throws IOException {
        // CREATE A BLANK IMAGE
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // SET BACKGROUND COLOR
        g2.setColor(Color.black);
        g2.fillRect(0, 0, WIDTH, HEIGHT);

        // SET INITIAL DRAWING COLOR
        g2.setColor(Color.WHITE);

        // DRAW THE FRACTAL
        drawTriangles(g2, new Point(WIDTH / 2, 10), new Point(10, HEIGHT-10), new Point(WIDTH-10, HEIGHT-10), depth);

        // WRITES THE FRACTAL TO AN IMAGE FILE
        if (writeToImageFile) {
            ImageIO.write(image, "BMP", new File(imageFileName));
            g2.dispose();
        }

        // SHOWS FRACTAL ON SCREEN
        if (drawOnScreen) {
            frame = new JFrame("Sierpinski Fractal");
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

    // POST: Computes and returns the midpoint between p1 and p2
    private static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }

    private void drawTriangles(Graphics2D g2, Point p1, Point p2, Point p3, int depth) {

        if (depth == 0) {
            /*
             * Draw 3 lines connecting p1, p2, p3 using the g2.drawLine command
            *      p1
            *     /  \
            *    /    \
            *   /      \
            * p2 _ _ _ _p3
            */

            //TODO
           

            return;
        } else {
            /*
             *Compute the midpoints of each side of the triangle using the provided method
             *      p1
             *     /  \
             *   m12  m13
             *   /      \
             * p2 _ m23 _ p3
            */

            //TODO
       

            /* Recursively call drawTriangles 3 times to draw 3 triangles within triangle p1,p2,p3
             * For example, the top triangle would be made using points m12, p1, and m13
             *      p1
             *     /  \
             *   m12 _ m13
             *   /  \ /  \
             * p2 _ m23 _ p3
            */

            //TODO
          
        }
    }

}
